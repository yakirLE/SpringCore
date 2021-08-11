package com.yakir.springframework.model;

import java.util.Date;

import lombok.Data;

@Data
public class Speaker {
	private String firstName;
	private String lastName;
	private Date time;
	private double seedNum;
}
