package com.yakir.springframework.service;

import java.util.List;

import com.yakir.springframework.model.Speaker;

public interface SpeakerService {

	List<Speaker> findAll();

}