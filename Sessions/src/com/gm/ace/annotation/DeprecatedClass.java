package com.gm.ace.annotation;


public class DeprecatedClass {
	
	/**
	 * @deprecated new function
	 */
  @Deprecated
  public void someFuntion(){
	  
  }
}

class ExtendDeprecatedClass  extends DeprecatedClass{
	
	
	@Override
	public void someFuntion(){
		  
	}
	
}

class SomeClass {
	public void someMethod(){
		DeprecatedClass class1 = new DeprecatedClass();
		class1.someFuntion();
	}
}