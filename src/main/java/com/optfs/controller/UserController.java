package com.optfs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optfs.entity.Admin;
import com.optfs.entity.Parent;
import com.optfs.entity.Tutor;
import com.optfs.exception.NullUserFound;
import com.optfs.repository.UserRepository;
import com.optfs.service.AdminService;
import com.optfs.service.ParentService;
import com.optfs.service.TutorService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/User")
public class UserController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	ParentService parentService;
	
	@Autowired
	TutorService tutorService;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public String defaultMessage() {
		return "Welcome to User controller";
	}
	

	@GetMapping("/allUsers")
	public List<?> getAllUsers(){
		
		List admins = adminService.getAllAdmins();
		List parents = parentService.getAllParents();
		List tutors = tutorService.getAllTutors();
		
		List users;
		for(Object a:admins) {
			parents.add(a);
		}
		for(Object t:tutors) {
			parents.add(t);
		}

		return parents;
	}
	
	@PostMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) throws NullUserFound {
		return adminService.updateAdmin(admin);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteAdmin(@RequestBody Admin admin) throws NullUserFound {
		return adminService.deleteAdmin(admin);
	}
	
	@GetMapping("/loginAdmin")
	public Admin loginAdmin(@RequestBody List<String> credentials) throws NullUserFound
	{
		String email = credentials.get(0);
		String password = credentials.get(1);
		return adminService.loginAdmin(email, password);
	}
	
}