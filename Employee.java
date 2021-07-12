import java.util.*;
import java.io.*;

public abstract class Employee implements Serializable{

private String name; //String to store the name of the employee
private double wage; //double value to store the wage of the employee

//protected constructor for Employee class
protected Employee (String name, double wage) {
this.name = name; //setting private variable name to the name parameter passed in
this.wage = wage; //setting private variable wage to the wage parameter passed in
}
//Precondition:A valid double will value be passed into computePay as a parameter representing the number of hours the employee has worked.
//Postcondition: A double value will be returned regarding the Employee's pay.
//abstract method ComputePay
public abstract double computePay(double hoursWorked);

//Precondition: The object is a valid object of the Employee class.
//Postcondition: Returns the name of the Employee
//getter method for name of the Employee
public String getName() {
return name;
}
//Precondition: The object is a valid object of the Employee class.
//Postcondition: Returns the wage of the Employee
//getter method for the wage of the Employee
public double getWage() {
return wage;
}
//setter method for the name of the Employee
//Precondition: The object is a valid object of the Employee class.
//Postcondition: Modifies the name of the Employee
public void setName(String name) {
this.name = name;
}
//setter method for the wage of the Employee
//Precondition:The object is a valid object of the Employee class.
//Postcondition: Modifies the wage of the Employee
public void setWage(double wage) {
this.wage = wage;
}

//method that increases the hourly wage by a given percentage
//Precondition: The object is a valid object of the Employee class.
//Postcondition: The wages of the employee are changed based off a percentage entered for the pay raise.
public void increaseWage(double percentage) {
wage +=(wage*(percentage/100));//adding wage times percentage to the current wage
}

//method that allows to make a string a particular length (from the Utilites.java that Dr.Digh provided)
//Precondition: A valid string is used for this method.
//Postcondition:str, with spaces added at the end so that the total length is n. If the length of str exceeds n, 
//a truncated version of str is returned.
public static String pad(String str, int n) {
    if (str.length() > n)
      return str.substring(0, n); //if length is greater than n (remove spaces)
    while (str.length() < n)
      str+=" "; //add more spaces if it less than n (add spaces)
    return str;
  }
//method that converts double amount to a String that is formatted using currency format (from the Utilities.java that Dr.Digh provided)
//Precondition: A valid double value is used.
//Postcondition: A double value value will be converted to a String where it is in proper currency format.
 public static String toDollars(double amount) {
    long roundedAmount = Math.round(amount * 100);
    long dollars = roundedAmount / 100;
    long cents = roundedAmount % 100;

    if (cents <= 9)
      return dollars + ".0" + cents;
    else
      return dollars + "." + cents;
  }
}

        


