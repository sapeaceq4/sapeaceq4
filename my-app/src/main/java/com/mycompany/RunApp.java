package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunApp {
	public static void main(String[] args) {
		SpringApplication.run(RunApp.class, args);
	}
	
//	@Bean BasicAuthenticationFilter basicAuthFilter(AuthenticationManager authenticationManager,
//			BasicAuthenticationEntryPoint basicAuthEntryPoint) {
//		return new BasicAuthenticationFilter(authenticationManager, basicAuthEntryPoint());
//	}
//	
//	@Bean BasicAuthenticationEntryPoint basicAuthEntryPoint() {
//		BasicAuthenticationEntryPoint bauth = new BasicAuthenticationEntryPoint();
//		bauth.setRealmName("GAURAVBYTES");
//		return bauth;
//}
}
