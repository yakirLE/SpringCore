package com.yakir.springframework.repository;

import java.util.List;

import com.yakir.springframework.model.Speaker;

public interface SpeakerRepository {

	List<Speaker> findAll();

}