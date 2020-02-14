package com.jd.teams.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jd.teams.model.Employee;
import com.jd.teams.model.ScrumTeams;
import com.jd.teams.services.SearchService;

@CrossOrigin
@RestController
public class TeamsController {
	@Autowired
	private SearchService service;
	
	@PostMapping(path="/saveemployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PostMapping(path="/savescrumteam")
	public ScrumTeams saveScrumTeam(@RequestBody ScrumTeams scrumteamname) {
		return service.saveScrumTeam(scrumteamname);
	}

	@GetMapping(path="/searchteams")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();		
	}
	
	@GetMapping(path="/searchallsrcrumteams")
	public List<ScrumTeams> getAllScrumTeams(){
		return service.getAllScrumTeams();
	}
	
	@PutMapping(path="/updateemployee")
	public Employee updateEmployee(@RequestBody Employee employee) {	
		return service.updateEmployee(employee);
		
	}
	
	@PutMapping(path="/updateteamname")
	public ScrumTeams updateScrumTeams(@RequestBody ScrumTeams scrumteamname) {
		return service.updateScrumTeams(scrumteamname);		
	}
	
	@DeleteMapping(path="/deleteemployee/{username}")
	public void deleteEmployee(@PathVariable String username) {	
		 service.deleteEmployee(username);
		
	}
	
	@GetMapping(path="/searchteams/names")
	public List<Employee> serachFunctonality(@RequestParam(required=false) String fname , @RequestParam(required=false) String lname, @RequestParam(required=false) String role, @RequestParam(required=false) String product) {
		return service.serachFunctonality(fname, lname,role,product);	 
	}
	
	
}
