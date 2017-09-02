package br.com.throughaglassdarkly.parser.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import br.com.throughaglassdarkly.parser.domain.ConsumedMessage;
import br.com.throughaglassdarkly.parser.domain.ProducedMessage;;

public final class MessageConverter {

	private MessageConverter() {
	}

	public static ProducedMessage toProducedMessage(final ConsumedMessage msg) {
		final ProducedMessage result = new ProducedMessage();
		
		result.setId(msg.getId());
		result.setTitle(msg.getTitle());
		
		Map<String, String> infos = new HashMap<>();		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		infos.put("process_timestamp", df.format(Calendar.getInstance().getTime()));
		
		String language = Locale.getDefault().getDisplayLanguage();
		infos.put("process_language", language);
		
		String country = Locale.getDefault().getDisplayCountry();
		infos.put("process_country", country);	
		
		result.setInfo(infos);
		
		return result;
	}

}