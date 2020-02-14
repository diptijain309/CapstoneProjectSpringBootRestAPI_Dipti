package com.jd.teams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.teams.model.Employee;
import com.jd.teams.model.ScrumTeams;
import com.jd.teams.repository.SearchEmployeeRepository;
import com.jd.teams.repository.SearchTeamRepository;

@Service
public class SearchService {
	@Autowired
	private SearchEmployeeRepository searchemprepo;
	@Autowired
	private SearchTeamRepository searchteamrepo;
	
	public Employee saveEmployee(Employee employee) {
		return searchemprepo.save(employee);
		
	}
	
	public ScrumTeams saveScrumTeam(ScrumTeams scrumteamname) {
		return searchteamrepo.save(scrumteamname);
		
	}
	
	public List<Employee> getAllEmployees(){
		return searchemprepo.findAll();
		
	}
	
	public List<ScrumTeams> getAllScrumTeams(){
		return searchteamrepo.findAll();		
	}
	
	public Employee updateEmployee(Employee employee) {	
		Optional<Employee> emp = searchemprepo.findById(employee.getUsername());
		Employee empobj = emp.orElse(null);
		if(empobj != null) {
			return searchemprepo.save(employee);
		}
		return empobj;		
	}
	
	public ScrumTeams updateScrumTeams(ScrumTeams scrumteamname) {	
		return searchteamrepo.save(scrumteamname);
		
	}
		
	public Optional<ScrumTeams> findByScrumTeam(String teamname){
		return searchteamrepo.findById(teamname);	
	}
	
	public Employee deleteEmployee(String username) {	
		Optional<Employee> emp = searchemprepo.findById(username);
		Employee empobj = emp.orElse(null);
		if(empobj != null) {
		 searchemprepo.delete(empobj);
		}
		return empobj;		
	}
		
	public List<Employee> serachFunctonality(String fname, String lname, String role, String product){	
		if(fname == null && lname== null && role==null) {
			List<Employee> obj = searchemprepo.findByProduct(product);
			return obj;	
		}
		
		else if(fname == null && lname== null && product==null) {
			List<Employee> obj = searchemprepo.findByRole(role);
			return obj;	
		}
		
		else if (fname == null && role== null && product==null) {
			List<Employee> obj = searchemprepo.findByLname(lname);
			return obj;	
		}
		
		else if (lname == null && role== null && product==null) {
			List<Employee> obj = searchemprepo.findByFname(fname);
			return obj;	
		}
		
		else if (role== null && product==null) {
			List<Employee> obj = searchemprepo.findByLnameAndFname(fname, lname);	
			return obj;	
		}
		
		else if (lname== null && product==null) {
			List<Employee> obj = searchemprepo.findByRoleAndFname(fname, role);	
			return obj;	
		}
		
		else if (lname== null && role==null) {
			List<Employee> obj = searchemprepo.findByProductAndFname(fname, product);	
			return obj;	
		}
		
		else if (fname== null && product==null) {
			List<Employee> obj = searchemprepo.findByRoleAndLname(lname, role);	
			return obj;	
		}
		
		else if (fname== null && role==null) {
			List<Employee> obj = searchemprepo.findByProductAndLname(lname, product);	
			return obj;	
		}

		else if (fname== null && lname==null) {
			System.out.println("inside role and product");
			List<Employee> obj = searchemprepo.findByProductAndRole(role, product);	
			return obj;	
		}
		
		return searchemprepo.findByLnameAndFname(fname, lname);		
	}
}
