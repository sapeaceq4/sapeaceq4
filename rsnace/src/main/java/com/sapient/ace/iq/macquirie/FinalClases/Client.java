package com.sapient.ace.iq.macquirie.FinalClases;

/**
 * Created by Ravdeep Singh on 23-02-2017.
 */
public class Client {
    public static void main(String[] args) {
        Employee obj = new Employee("King", "SAPE");
        Person immObj = (Person) obj;
        System.out.println(immObj.getName());
        obj.setCompany("Sape");
        System.out.println(immObj.getName());


    }

}

