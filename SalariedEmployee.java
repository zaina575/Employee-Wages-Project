import java.util.*;
import java.io.*;

public class SalariedEmployee extends Employee implements Serializable {

//constructor for the SalariedEmployee class 
public SalariedEmployee(String name, double salary) {
super(name,(salary/(40*52))); //calls super constructor and divides the slary by (40*52) to get wage
}
//getter method for annual salary
//Precondition: The object is a valid object of the SalariedEmployee class.
//Postcondition: A double will be returned that represents the annual salary of the employee.
public double getAnnualSalary(){
return getWage()*40*52; //multiply by 40 and 52 to get the annual salary
}
//setter method for annual salary
//Precondition: The object is a valid object of the SalariedEmployee class.
//Postcondition: Modifies the salary of a SalariedEmployee object
public void setSalary(double newsalary){
newsalary = newsalary/(40*52); //to change the annual salary value 
}
//compute Pay method for the SalariedEmployee class
//Precondition:A valid double will value be passed into computePay as a parameter representing the number of hours the employee has worked.
//Postcondition: A double value will be returned regarding the SalariedEmployee's pay.
public double computePay(double hoursWorked){
return 40*getWage(); //40 times wage to get pay
}
//overriden toString for the SalariedEmployee class
//Precondition: The object is a valid object of the SalariedEmployee class.
//Postcondition: The object's information will be converted to a String.
public String toString() {
String format = "$" + toDollars(getAnnualSalary()) + "/year";  //String that stores the salary every year
return pad(getName(),40-format.length()) + format; //ensures that String is exactly 40 characters long
  }



}
