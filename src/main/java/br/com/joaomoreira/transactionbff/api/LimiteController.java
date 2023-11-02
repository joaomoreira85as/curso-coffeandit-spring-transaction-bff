package br.com.joaomoreira.transactionbff.api;

import br.com.joaomoreira.transactionbff.domain.LimiteService;
import br.com.joaomoreira.transactionbff.dto.LimiteDiario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/limites")
public class LimiteController {

    public LimiteController(LimiteService limiteService) {
        this.limiteService = limiteService;
    }

    private LimiteService limiteService;

    @GetMapping(value = "/{agencia}/{conta}")
    public Mono<LimiteDiario> buscarLimiteDiario(@PathVariable("agencia") final Long agencia, @PathVariable("conta") final Long conta) {

        return limiteService.buscarLimiteDiario(agencia, conta);

    }
}
