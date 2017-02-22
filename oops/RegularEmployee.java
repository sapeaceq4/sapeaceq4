package com.sapient.ace.corejava.oops;

public class RegularEmployee extends Employee{
	public double calculateIncrementedSalary(){
		return getSalary()*1.15;
	}
}
