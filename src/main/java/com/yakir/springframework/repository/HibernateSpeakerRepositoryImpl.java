package com.yakir.springframework.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.yakir.springframework.model.Speaker;

@Repository("speakerRepository") // v1.3 stereotypes - fully autowired
@Profile("yakirDev") // v1.8 - profiles
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

//	v1.6 - factory bean
	@Autowired
	private Calendar cal;
	
//	v1.7 - SpEL
	@Value("#{ T(java.lang.Math).random() * 100 }")
	private double seedNum;
	
	@Override
	public List<Speaker> findAll() {
		List<Speaker> speakers = new ArrayList<>();
		
		Speaker speaker = new Speaker();
		speaker.setFirstName("yakir");
		speaker.setLastName("levi");
		
//		v1.6 - factory bean
		speaker.setTime(cal.getTime());
		
//		v1.7 - SpEL
		speaker.setSeedNum(seedNum);
		
		speakers.add(speaker);
		
		return speakers;
	}
	
}
