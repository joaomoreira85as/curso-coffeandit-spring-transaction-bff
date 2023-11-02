package br.com.joaomoreira.transactionbff.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "uuid")
public class TransactionDto {

    @Schema(description = "Código de identificação da transação")
    private UUID uuid;
    @Schema(description = "Valor da transação")
    @NotNull(message = "Informar o valor da transação")
    private BigDecimal valor;
    @Schema(description = "Dia/hora/minuto e segundos da transação")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;
    @Schema(description = "Conta de origem da transação")
    @NotNull(message = "Informar a conta de origem da transação")
    @Valid
    private Account account;
    @Schema(description = "Beneficiário da transação")
    @Valid
    private BeneficiaryDto beneficiary;
    @Schema(description = "Tipo de transação")
    @NotNull(message = "Informar o tipo da transação")
    private TransactionType transactionType;
    @Schema(description = "Situação da transação")
    private Situation situation;
}
