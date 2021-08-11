package com.yakir.springframework.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.yakir.springframework.model.Speaker;
import com.yakir.springframework.repository.SpeakerRepository;

@Service("speakerService") // v1.3 stereotypes - fully autowired
@Scope(value = BeanDefinition.SCOPE_SINGLETON) // singleton is default
public class SpeakerServiceImpl implements SpeakerService {

//	v1.3.3 - stereotypes - fully autowired - wiring a field that will be delivered using reflection instead of setter/constructor
	@Autowired
	private SpeakerRepository repository;

//	v1.2 - autowired - sysout prep
	public SpeakerServiceImpl() {
		System.out.println(SpeakerServiceImpl.class.getSimpleName() + " no args constructor");
	}
	
//	v1.1 - constructorInjection
//	@Autowired // v1.3.2 stereotypes - fully autowired - constructorInjection
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		this.repository = speakerRepository;
		
//		v1.2 - autowired - sysout prep
		System.out.println(SpeakerServiceImpl.class.getSimpleName() + " repository constructor");
	}
	
//	v1.5 - bean lifecycle - post constructor actions
	@PostConstruct
	private void initialize() {
		System.out.println(SpeakerServiceImpl.class.getSimpleName() + " called after the constructors");
	}
	
	@Override
	public List<Speaker> findAll() {
		return repository.findAll();
	}
	
//	v1.2.1 - autowired setterInjection - hybrid
//	v1.3.1 stereotypes - fully autowired - setterInjection
//	@Autowired
	public void setRepository(SpeakerRepository repository) {
		this.repository = repository;
		
//		v1.2 - autowired - sysout prep
		System.out.println(SpeakerServiceImpl.class.getSimpleName() + " setter");
	}
	
}
