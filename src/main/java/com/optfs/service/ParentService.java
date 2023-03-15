package com.optfs.service;

import java.util.List;

import com.optfs.entity.Parent;
import com.optfs.exception.NullEmailFoundException;
import com.optfs.exception.NullUserFound;

public interface ParentService {
	
	public Parent registerParent(Parent parent) throws NullUserFound, NullEmailFoundException;
	
	public List<Parent> getAllParents();
	
	public Parent getParentById(Integer pid) throws NullUserFound;
	
	public Parent updateParent(Parent parent) throws NullUserFound;
	
	public String deleteParent(Parent parent) throws NullUserFound;
	
	public Parent loginParent(String email, String password) throws NullUserFound;

}
