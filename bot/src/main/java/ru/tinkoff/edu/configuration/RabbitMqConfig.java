package ru.tinkoff.edu.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.scrapperlink.dto.request.LinkUpdate;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {
    private final ApplicationConfig config;


    @Bean
    public ClassMapper classMapper(){
        Map<String, Class<?>> mappings = new HashMap<>();
        mappings.put("ru.tinkoff.edu.dto.request.LinkUpdate", LinkUpdate.class);
        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setTrustedPackages("ru.tinkoff.edu.dto.*");
        classMapper.setIdClassMapping(mappings);
        return classMapper;
    }
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(config.exchangeName(), false, false);
    }

    @Bean("queueBean")
    public Queue queue() {
        return QueueBuilder.nonDurable(config.queueName()).build();
    }

    @Bean("bindingBean")
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(config.queueName());
    }

    @Bean
    public MessageConverter jsonMessageConverter(ClassMapper classMapper) {
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        messageConverter.setClassMapper(classMapper);
        return messageConverter;
    }
}
