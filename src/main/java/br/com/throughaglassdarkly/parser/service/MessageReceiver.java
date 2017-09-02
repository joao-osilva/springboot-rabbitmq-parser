package br.com.throughaglassdarkly.parser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.throughaglassdarkly.parser.domain.ConsumedMessage;
import br.com.throughaglassdarkly.parser.domain.ProducedMessage;


@Component
public class MessageReceiver {
	private static final Logger LOG = LoggerFactory.getLogger(MessageConverter.class);

	private final MessageSender sender;

	@Autowired
	public MessageReceiver(final MessageSender sender) {
		this.sender = sender;
	}

	@RabbitListener(queues = "${queue.from}")
	public void processMessage(final ConsumedMessage consumedMsg) {
		LOG.info("Message received: {}", consumedMsg);

		final ProducedMessage producedMsg = MessageConverter.toProducedMessage(consumedMsg);
		sender.send(producedMsg);

		LOG.info("Message sent: {}", producedMsg);
	}

}
