package br.com.joaomoreira.transactionbff.domain;

import br.com.joaomoreira.transactionbff.dto.LimiteDiario;
import br.com.joaomoreira.transactionbff.feign.LimiteClient;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class LimiteService {

    LimiteClient limiteClient;

    @Autowired
    private CircuitBreaker timeCircuitBreaker;


    public LimiteService(LimiteClient limiteClient) {
        this.limiteClient = limiteClient;
    }

    public Mono<LimiteDiario> buscarLimiteDiario(final Long agencia, final Long conta) {

        return buscarLimiteDiarioSupplier(agencia, conta);


    }

    private Mono<LimiteDiario> buscarLimiteDiarioSupplier(final Long agencia, final Long conta) {
        var limiteDiarioSup = timeCircuitBreaker.decorateSupplier(() ->
                limiteClient.buscarLimiteDiario(agencia, conta));

        return Mono.fromSupplier(

                Decorators
                        .ofSupplier(limiteDiarioSup)
                        .withCircuitBreaker(timeCircuitBreaker)
                        .withFallback(Arrays.asList(CallNotPermittedException.class),
                                e -> this.getStaticLimit())
                        .decorate()

        );
    }

    private LimiteDiario getStaticLimit() {
        LimiteDiario limiteDiario = new LimiteDiario();
        limiteDiario.setValor(BigDecimal.ZERO);
        return limiteDiario;
    }


}
