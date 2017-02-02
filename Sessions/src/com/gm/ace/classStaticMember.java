package com.gm.ace;

class subClass1 {
	public static void fun(){
		System.out.println("subClass");
	}
}
public class classStaticMember extends subClass1{
	public static void fun(){
		System.out.println("supperClass");
	}
	public classStaticMember(){
		
	}
  public static void main(String[] args) {
	  subClass1 classStaticMember = new classStaticMember();
	  classStaticMember.fun();
}
}
