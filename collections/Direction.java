package com.sapient.ace.corejava.collections;

public enum Direction {
NORTH,SOUTH,EAST,WEST;
public static void check(Direction direction)
{
 switch(direction)
 {
 case NORTH : System.out.println("North found"); break;
 case SOUTH : System.out.println("South found");break;
 case EAST : System.out.println("East found");break;
 case WEST : System.out.println("West founhd");break;
 
 }
}
}
