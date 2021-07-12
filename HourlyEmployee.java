import java.util.*;
import java.io.*;

public class HourlyEmployee extends Employee implements Serializable{

//constructor for the HourlyEmployee class
public HourlyEmployee(String name, double wage) {
super(name, wage); //calls super constructor (Employee)
}
//overriding computePay method from the Employee super class
//Precondition:A valid double will value be passed into computePay as a parameter representing the number of hours the employee has worked.
//Postcondition: A double value will be returned regarding the HourlyEmployee's pay.
public double computePay(double hoursWorked) {
//for employee that works 40 hours or less
if(hoursWorked <= 40){
return hoursWorked*getWage();
}
//for employee that works overtime
else {
return 40*getWage()+(hoursWorked-40)*getWage()*1.5; }
}

//overriding object toString method with toString for HourlyEmployee
//Precondition: The object is a valid object of the HourlyEmployee class.
//Postcondition: The object's information will be converted to a String.
public String toString() {
String format = "$" + toDollars(getWage()) + "/hour"; //String that stores the wage per hour 
return pad(getName(),40-format.length()) + format; //ensuring it is 40 characters long
  }


}
