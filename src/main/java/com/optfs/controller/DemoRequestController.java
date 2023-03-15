package com.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optfs.entity.DemoRequests;
import com.optfs.entity.Parent;
import com.optfs.entity.Tutor;
import com.optfs.exception.NullUserFound;
import com.optfs.exception.NullValuesFoundException;
import com.optfs.service.DemoRequestService;
import com.optfs.service.ParentService;
import com.optfs.service.TutorService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/demoReq")
public class DemoRequestController {

	@Autowired
	DemoRequestService demoService;
	
	@Autowired
	ParentService pService;
	
	@Autowired
	TutorService tService;
	
	@PostMapping("/getDemoRequests/{pid}/{tid}")
	public DemoRequests addDemoRequest(@PathVariable Integer pid, @PathVariable Integer tid) throws NullUserFound, NullValuesFoundException {
		DemoRequests d = new DemoRequests();
		Tutor tutor = tService.getTutorById(tid);
		Parent parent = pService.getParentById(pid);
		
		d.setParent(parent);
		d.setTutor(tutor);
		
		return demoService.addDemoRequests(d);
	}
	
	@GetMapping("/getDemoRequestsByPID/{pid}")
	public List<DemoRequests> getDemoRequestsByPID(@PathVariable Integer pid) throws NullValuesFoundException{
		return demoService.getDemoRequestsByParentId(pid);
	}
	
	@GetMapping("/getDemoRequestsByTID/{tid}")
	public List<DemoRequests> getDemoRequestsByTID(@PathVariable Integer tid) throws NullValuesFoundException{
		return demoService.getDemoRequestsByTutorId(tid);
	}
	
	@PutMapping("/updateReq/{d}")
	public DemoRequests updateDemo(@PathVariable Integer d) throws NullValuesFoundException{
		return demoService.updateDemoRequest(d);
	}
	
	@DeleteMapping("/deleteReq")
	public void deleteDemo(@RequestBody DemoRequests d) throws NullValuesFoundException{
		demoService.deleteDemoRequest(d);
	}
}
