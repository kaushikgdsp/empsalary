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
public class EmployeeController 	// the MVC Controller class
{

	@Autowired
	EmployeeService eService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)	// handler method to generate the homepage view
	public String generateHomePage()
	{
		return "homepage";
	}
	
	@RequestMapping(value="/empinsertform", method=RequestMethod.GET)	// handler method to generate the empform view
	public String generateInsertForm(Model model)					    // by rendering the Employee model in order to
	{																    // accept employee details
		model.addAttribute("eform", new Employee());
		
		return "empform";
	}
	
	@RequestMapping(value="/empadd", method=RequestMethod.POST)
	public String addEmployeeDetails(@ModelAttribute("eform") @Valid Employee employee, BindingResult result)	//handler
	{															// method in order to accept the submitted values from empform
																// into the Employee bean with proper validations.
		if(result.hasErrors())									// If validation errors exists then the empform view will be
		{														// rendered with all errors, otherwise the success view 
			System.out.println(result.hasErrors());				// will be generated, or for any other error the error view will
			return "empform";									// be generated
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
	
	@RequestMapping(value="/viewemp", method=RequestMethod.GET)		// handler method to display employee details with the
	public String viewAllEmployee(Model model)						// bonus amount by generating the empresult view, or if no
	{																// employee data found then the noempdata view will be
		Employee e=eService.getEmployee();							// generated to give the message
		
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
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String validationError(@ModelAttribute("eform") @Valid Employee employee, MethodArgumentNotValidException ex) 
	{															// a separate handler method in order to render the empform
	    BindingResult result = ex.getBindingResult();			// view by handling the 'MethodArgumentNotValidException'
	    final List<FieldError> fieldErrors = result.getFieldErrors(); // exception for validation failure. But this is not
	    														// required here as the 'BindingResult' which is used in
	    System.out.println(fieldErrors);						// 'addEmployeeDetails' handler method is checking any
	    														// validation errors before binding values with Employee
	    return "empform";										// and then render empform view so as to display all errors
	}				// we have to go for either using BindingResult or handling MethodArgumentNotValidException exception
	
}
