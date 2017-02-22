package com.sapient.designpatterns.behavioural;

abstract class ConfigurationDeployer {
	public void deployConfigurationOnServer() {
		validateConfiguration();
		provisionConfiguration();
		deployConfiguration();
	}

	
	protected void validateConfiguration() {
		System.out.println("Configuration Validated");
	}

	protected abstract void provisionConfiguration();

	protected abstract void deployConfiguration();


}

class FEConfigurationDeployer extends ConfigurationDeployer {
	
	protected void provisionConfiguration() {
		System.out.println("FE Configuration Provisioned");

	}

	protected void deployConfiguration() {
		System.out.println("FE Configuration Deployed");

	}
}

class OnlineConfigurationDeployer extends ConfigurationDeployer {
	
	protected void provisionConfiguration() {
		System.out.println("Online Configuration Provisioned");

	}

	protected void deployConfiguration() {
		System.out.println("Online Configuration Deployed");

	}
}

public class TemplatePatternDemo {

	public static void main(String[] args) {
		ConfigurationDeployer fDeployer = new FEConfigurationDeployer();
		fDeployer.deployConfigurationOnServer();
		
		ConfigurationDeployer oDeployer = new OnlineConfigurationDeployer();
		oDeployer.deployConfigurationOnServer();
	}

}
