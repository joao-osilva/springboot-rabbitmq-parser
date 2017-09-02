package br.com.throughaglassdarkly.parser;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class AppConfiguration {

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		
		factory.setConnectionFactory(connectionFactory);		
		factory.setConcurrentConsumers(3);
		factory.setMaxConcurrentConsumers(10);		
		factory.setMessageConverter(new Jackson2JsonMessageConverter());

		return factory;
	}
	
	@Bean
	public RabbitMessagingTemplate rabbitMessagingTemplate(ConnectionFactory connectionFactory){
		RabbitMessagingTemplate template = new RabbitMessagingTemplate();
		
		template.setRabbitTemplate(new RabbitTemplate(connectionFactory));
		template.setAmqpMessageConverter(new Jackson2JsonMessageConverter());
		
		return template;
	}
}
