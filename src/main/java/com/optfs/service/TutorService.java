package com.optfs.service;

import java.util.List;

import com.optfs.entity.Tutor;
import com.optfs.exception.NullEmailFoundException;
import com.optfs.exception.NullUserFound;

public interface TutorService {
	
	public Tutor registerTutor(Tutor tutor) throws NullUserFound, NullEmailFoundException;
	
	public List<Tutor> getAllTutors();
	
	public Tutor getTutorById(Integer pid) throws NullUserFound;
	
	public Tutor updateTutor(Tutor tutor) throws NullUserFound;
	
	public String deleteTutor(Tutor tutor) throws NullUserFound;
	
	public Tutor loginTutor(String email, String password) throws NullUserFound;

	
	
}
