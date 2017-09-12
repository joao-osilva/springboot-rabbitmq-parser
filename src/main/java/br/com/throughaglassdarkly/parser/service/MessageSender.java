package br.com.throughaglassdarkly.parser.service;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

	@Value("${queue.to}")
	private String queue;

	private final RabbitMessagingTemplate template;

	@Autowired
	public MessageSender(final RabbitMessagingTemplate template) {
		this.template = template;
	}

	public void send(final Object message) {
		template.convertAndSend(queue, message);
	}

}
