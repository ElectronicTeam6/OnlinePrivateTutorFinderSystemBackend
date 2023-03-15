package com.optfs.service;


import java.util.List;

import com.optfs.entity.Admin;
import com.optfs.exception.NullEmailFoundException;
import com.optfs.exception.NullUserFound;

public interface AdminService {
	
	public Admin registerAdmin(Admin admin) throws NullUserFound, NullEmailFoundException;
	
	public List<Admin> getAllAdmins();
	
	public Admin getAdminById(Integer pid) throws NullUserFound;
	
	public Admin updateAdmin(Admin admin) throws NullUserFound;
	
	public String deleteAdmin(Admin admin) throws NullUserFound;
	
	public Admin loginAdmin(String email, String password) throws NullUserFound;
}