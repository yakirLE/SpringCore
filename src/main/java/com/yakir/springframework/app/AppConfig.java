package com.yakir.springframework.app;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yakir.springframework.util.CalendarFactory;

@Configuration
@ComponentScan({"com.yakir.springframework"}) // v1.3 stereotypes - fully autowired
public class AppConfig {
	
	/* v1.3 stereotypes - fully autowired
//	v1.0 - setterInjection
	@Bean(name = "speakerService")
//	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE) // singleton is default
	public SpeakerService getSpeakerService() {
//		v1.0 - setterInjection
//		SpeakerServiceImpl service = new SpeakerServiceImpl();
//		service.setRepository(getSpeakerRepository());
		
//		v1.1 - constructorInjection
//		SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
		
//		v1.2.1 - autowired setterInjection - hybrid
		SpeakerServiceImpl service = new SpeakerServiceImpl();
		
		return service;
	}
	
	*/

	
	/* v1.3 stereotypes - fully autowired
//	v1.0 - setterInjection
//	v1.1 - constructorInjection
	@Bean(name = "speakerRepository")
	public SpeakerRepository getSpeakerRepository() {
		return new HibernateSpeakerRepositoryImpl();
	}
	
	*/
	
//	v1.6 - factory bean
	@Bean(name = "cal")
	public CalendarFactory calFactory() {
		CalendarFactory factory = new CalendarFactory();
		factory.addDays(2);
		
		return factory;
	}
	
//	v1.6 - factory bean
	@Bean 
	public Calendar cal() throws Exception {
		return calFactory().getObject();
	}
}
