package br.com.joaomoreira.transactionbff.api.config;

import br.com.joaomoreira.transactionbff.dto.RequestTransactionDto;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.sender.SenderOptions;

import java.util.Map;

@Configuration
public class ReactiveKafkaProducerConfig {

    @Bean
    public ReactiveKafkaProducerTemplate<String, RequestTransactionDto> reactiveKafkaProducerTemplate(final KafkaProperties kafkaProperties) {
        Map<String, Object> props = kafkaProperties.buildProducerProperties();
        return new ReactiveKafkaProducerTemplate<String, RequestTransactionDto>(SenderOptions.create(props));
    }
}
