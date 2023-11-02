package br.com.joaomoreira.transactionbff.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Account implements Serializable {
    @Schema(description = "Código da Agência")
    @NotNull(message = "Informar o código da Agência")
    private Long accountBranchNumber;
    @Schema(description = "Código da Conta")
    @NotNull(message = "Informar o código da Conta")
    private Long accountNumber;
}
