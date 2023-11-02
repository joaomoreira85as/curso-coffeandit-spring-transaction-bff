package br.com.joaomoreira.transactionbff.api;

import br.com.joaomoreira.transactionbff.api.dto.RequestTransactionDto;
import br.com.joaomoreira.transactionbff.api.dto.TransactionDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController
{
    @PostMapping
    public Mono<TransactionDto> sendTransaction(@RequestBody final RequestTransactionDto requestTransactionDto ){
        return Mono.empty();
    }

    @GetMapping("/{uuid}")
    public Mono<TransactionDto> getTransaction(@PathVariable final String uuid){
        return Mono.empty();
    }

    @DeleteMapping("/{uuid}")
    public Mono<TransactionDto> deleteTransaction(@PathVariable final String uuid){
        return Mono.empty();
    }

    @PatchMapping("/{uuid}/confirm")
    public Mono<TransactionDto>confirmTransaction(@PathVariable final String uuid){
        return Mono.empty();
    }
}
