package com.designpattern.CreationalDesignPattern.abstractfactorydesignpattern;

public class PC extends Computer{

	@Override
	public String getRam() {
		// TODO Auto-generated method stub
		return "2 GB";
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return "100 GB";
	}

	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
		return "2.4 GH";
	}

}
