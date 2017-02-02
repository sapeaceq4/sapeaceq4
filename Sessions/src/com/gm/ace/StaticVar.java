package com.gm.ace;

import java.util.Enumeration;

public class StaticVar {
    public static int s = 5;
}
//class Class A?
class EstaticVar extends StaticVar {
  public static void main(String[] args) {
	  EstaticVar v = new EstaticVar();
	  System.out.println(v.s);
	  Object s;
	  Enumeration e;
  }
}
