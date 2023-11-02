package br.com.joaomoreira.transactionbff.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "uuid")
@RedisHash(value = "TransactionDto", timeToLive = 300)
public class TransactionDto {

    @Schema(description = "Código de identificação da transação")
    @Id
    private UUID uuid;
    @Schema(description = "Valor da transação")
    @NotNull(message = "Informar o valor da transação")
    private BigDecimal valor;
    @Schema(description = "Data/hora/minuto e segundo da transação")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime data;
    @NotNull(message = "Informar a conta de origem da transação")
    @Schema(description = "Conta de origem da transação")
    @Valid
    private Conta conta;
    @Schema(description = "Beneficiário da transação")
    @Valid
    private BeneficiatioDto beneficiario;
    @NotNull(message = "Informar o tipo da transação")
    @Schema(description = "Tipo de transação")
    private TipoTransacao tipoTransacao;
    @Schema(description = "Situação da transação")
    private SituacaoEnum situacao;


    public void naoAnalisada() {
        setSituacao(SituacaoEnum.NAO_ANALISADA);
    }


}
