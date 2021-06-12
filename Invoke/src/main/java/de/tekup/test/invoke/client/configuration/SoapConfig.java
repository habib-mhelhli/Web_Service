package de.tekup.test.invoke.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
	
		Jaxb2Marshaller marshaller =new Jaxb2Marshaller();
		marshaller.setPackagesToScan("de.tekup.test.soap.api.consume.whiteTest");
		return marshaller;
	}
}
