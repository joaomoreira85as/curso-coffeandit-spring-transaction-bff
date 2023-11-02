package br.com.joaomoreira.transactionbff.redis;

import br.com.joaomoreira.transactionbff.dto.TransactionDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRedisRepository extends CrudRepository<TransactionDto, String> {
}
