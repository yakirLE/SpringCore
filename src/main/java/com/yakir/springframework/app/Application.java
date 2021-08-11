package com.yakir.springframework.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yakir.springframework.service.SpeakerService;

public class Application {

	public static void main(String[] args) {
//		v0.0 - no spring used
//		SpeakerService service = new SpeakerServiceImpl();
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
		
//		v1.4 - using beans without string name
		SpeakerService service = appContext.getBean(SpeakerService.class);
		System.out.println("service reference: " + service + "\n");
		
//		System.out.println(service.findAll().get(0).getFirstName());
		
//		v1.7 - SpEL
//		System.out.println(service.findAll().get(0).getSeedNum());
		
		System.out.println(service.findAll().get(0) + "\n");
		
		SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class);
		System.out.println("service2 reference: " + service2);
		
	}
}
