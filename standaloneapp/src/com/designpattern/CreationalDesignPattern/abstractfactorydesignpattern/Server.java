package com.designpattern.CreationalDesignPattern.abstractfactorydesignpattern;

public class Server extends Computer{

	@Override
	public String getRam() {
		// TODO Auto-generated method stub
		return "4 GB";
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return "500 GB";
	}

	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
		return "5.6 GH";
	}

}
