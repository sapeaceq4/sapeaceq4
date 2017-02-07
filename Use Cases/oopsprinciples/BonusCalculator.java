package com.ace.oopsprinciples;

public class BonusCalculator {
	public static void main(String[] args) {
		Employee regularEmployee = new Regular(1000000);
		Employee contactor = new Contractors(500000);
		
		System.out.println("Bonus for Reglaur Employee " + regularEmployee.calculateBonus());
		System.out.println("Bonus for Contractor " + contactor.calculateBonus());
		
	
	}
}