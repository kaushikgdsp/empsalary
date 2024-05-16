package com.employeemnmt.empsalary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;

@Controller
public class EmployeeController 
{

	@Autowired
	EmployeeService eService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String generateHomePage()
	{
		return "homepage";
	}
	
	@RequestMapping(value="/empinsertform", method=RequestMethod.GET)
	public String generateInsertForm(Model model)
	{
		model.addAttribute("eform", new Employee());
		
		return "empform";
	}
	
	@RequestMapping(value="/empadd", method=RequestMethod.POST)
	public String addEmployeeDetails(@ModelAttribute("eform") @Valid Employee employee, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			System.out.println(result.hasErrors());
			return "empform";
		}
		else
		{
			Employee emp=eService.addEmployee(employee);
			
			if(emp!=null)
			{
				
				return "success";
			}
			else
			{
				
				return "error";
			}
		}
		
	}
	
/*	@RequestMapping(value="/viewemp", method=RequestMethod.GET)
	public String viewAllEmployee(Model model)
	{
		Employee e=eService.getEmployee();
		
		if(e!=null)
		{
			int code=e.getCode();
			String name=e.getName();
			double salary=e.getSalary();
			
			if(code>0 && name!="" && salary>0.0)
			{
				model.addAttribute("emp", e);
		
				return "empresult";
			}
			else
			{
				return "noempdata";
			}
		}
		else
		{
			return "noempdata";
		}
		
	}		*/
	

	@RequestMapping(value="/viewemp", method=RequestMethod.GET)
	public String viewAllEmployee(Model model)
	{
		List<Employee> elst=eService.getAllEmployee();
		
		if(elst!=null)
		{
			model.addAttribute("emp", elst);
		
			return "empresult1";
		}
		else
		{
			return "noempdata";
		}
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String validationError(@ModelAttribute("eform") @Valid Employee employee, MethodArgumentNotValidException ex) 
	{
	    BindingResult result = ex.getBindingResult();
	    final List<FieldError> fieldErrors = result.getFieldErrors();

	    System.out.println(fieldErrors);
	    
	    return "empform";
	}
	
}
