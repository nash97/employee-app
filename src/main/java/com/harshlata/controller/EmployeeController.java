package com.harshlata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.harshlata.model.Employee;
import com.harshlata.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployee());
		// return "index";
		return findPaginated(1, model);
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		System.out.println("show employee form");
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println("save executed");
		employeeService.saveEmployee(employee);
		return "redirect:/";
		// return "index.html";
	}

//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
//		Employee employee = employeeService.getEmployeeById(id);
//		model.addAttribute("employee", employee);
//		System.out.println(employee.getFirstName());
//		return "update_employee";
//	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable(value = "id") long id) {
		System.out.println("delete employee");
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 2;
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
		List<Employee> listEmployee = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listEmployees", listEmployee);
		return "index";

	}

}
