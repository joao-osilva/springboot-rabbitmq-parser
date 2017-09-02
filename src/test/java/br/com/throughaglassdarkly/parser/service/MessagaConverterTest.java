package br.com.throughaglassdarkly.parser.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.throughaglassdarkly.parser.domain.ConsumedMessage;
import br.com.throughaglassdarkly.parser.domain.ProducedMessage;
import br.com.throughaglassdarkly.parser.service.MessageConverter;


@RunWith(SpringRunner.class)
public class MessagaConverterTest {

	@Test
	public void convert_to_produced_message() {
		ConsumedMessage msg = new ConsumedMessage();
		msg.setId("1");
		msg.setTitle("msg-1");

		ProducedMessage result = MessageConverter.toProducedMessage(msg);

		assertEquals("1", result.getId());
		assertEquals("msg-1", result.getTitle());
		assertNotNull(result.getInfo());
		assertFalse(result.getInfo().isEmpty());
	}

}
