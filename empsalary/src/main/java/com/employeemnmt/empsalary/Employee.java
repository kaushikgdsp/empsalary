package com.employeemnmt.empsalary;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Component
public class Employee 
{
	@Min(value=1, message="employee code should be valid.....")
	private int code;
	
	@NotBlank(message="employee name cannot be empty.....")
	private String name;
	
	@Min(value=1, message="do not enter any negative or zero value.....")
	private double salary;
	
	private double bonus;
	
	public int getCode() 
	{
		return code;
	}
	public void setCode(int code) 
	{
		this.code = code;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public double getSalary() 
	{
		return salary;
	}
	public void setSalary(double salary) 
	{
		this.salary = salary;
	}
	
	public double getBonus() 
	{
		return bonus;
	}
	public void setBonus(double bonus) 
	{
		this.bonus = bonus;
	}
	
	@Override
	public String toString() 
	{
		return "Employee [code=" + code + ", name=" + name + ", salary=" + salary + "bonus=" + bonus+"]";
	}
		
}
