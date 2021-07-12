import java.util.*;
import java.io.*;

public class Personnel {

	public static void main(String[] args) throws IOException{
	ArrayList<Employee> employees = new ArrayList<Employee>(); //ArrayList of Employee objects
	printMenu(employees); //calling printMenu method


}
	//printing the menu method
	//Precondition: The ArrayList that stores Employee objects should not have any values stored.
	//Postcondition:The method will keep taking user input using a Scanner until the user decides to exit the program.
	public static void printMenu(ArrayList<Employee> employees){
	String choice; //stores the option that the user picks
	Scanner input  = new Scanner(System.in); //creating a Scanner name input

do {
	//print statements for the menu
	System.out.println("-----------------------------------");
        System.out.println("|Commands: n - New employee       |");
        System.out.println("|          c - Compute paychecks  |");
        System.out.println("|          r - Raise wages        |");
        System.out.println("|          p - Print records      |");
        System.out.println("|          d - Download data      |");
        System.out.println("|          u - Upload data        |");
        System.out.println("|          q - Quit               |");
        System.out.println("-----------------------------------");
	System.out.println();
	System.out.print("Enter command: "); //print statement for entering command
	choice = input.nextLine();//stores the input of the user from the Scanner

	switch(choice){
	//accepts either lower case or upper case and runs the casen method
	case "n": 
	case "N":
	{
	casen(employees); //method call for casen passing employees ArrayList in as a parameter
	break;
	}
	//accepts either lower case or upper case and runs the casec method
	case "c": 
	case "C":
	{
	casec(employees);//method call for casec passing employees ArrayList in as a parameter
	break;
	}
	//accepts either lower case or upper case and runs the caser method
	case "r":
	case "R":
	{
	caser(employees);//method call for caser passing employees ArrayList in as a parameter
	break;
	}
	//accepts either lower case or upper case and runs the casep method
	case "p":
	case "P":
	{
	casep(employees);//method call for casep passing employees ArrayList in as a parameter
	break;
	}
	//accepts either lower case or upper case and runs the cased method
	case "d":
	case "D":
	{
	cased(employees);//method call for cased passing employees ArrayList in as a parameter
	break;
	}
        //accepts either lower case or upper case and runs the caseu method
	case "u": 
	case "U":
	{
	caseu(employees);//method call for caseu passing employees ArrayList in as a parameter
	}
	//accepts either lower case or upper case
	case "q": 	
	case "Q": {
	break;//stop case
	}
	//if the user does not input one of the options
	default:
	System.out.println();
	System.out.println("Command was not recognized; please try again."); 
        System.out.println();

}

}while(!(choice.equalsIgnoreCase("Q"))); //while choice does not equal q or Q keep running the program
}

	//case n method
	//Precondition: The ArrayList that stores Employee objects should be created. It may or maynot have Employee objects depending
	//on when it is ran.
	//Postcondition: An Employee object will be successfully added to the end of the ArrayList.
	public static void casen(ArrayList<Employee> employees){
	String name; //String for the name of the employee
	String type; //String for the type of employee
	String wage; //String for the wage of the employee
	double wage1 = -0.000001; //double value stores the wage of the employee
	Scanner inputn = new Scanner(System.in); //creating a Scanner named inputn 

	System.out.print("Enter the name of the new employee: "); //print statement for entering employee name
	name = inputn.nextLine(); //stores the name of the employee that the user inputs (assumed the user may have a name title such as 
	//Charlie the 2nd 
	System.out.print("Hourly (h) or salaried (s): "); //print statement for hourly or salaried 
	type = inputn.nextLine(); //stores the type of employee that the user inputs

	//while statement to make sure input is h or s (case doesn't matter)
	while((!type.equalsIgnoreCase("H")) && (!type.equalsIgnoreCase("S"))) {
	System.out.println("Input was not h or s; please try again.");
	System.out.print("Hourly (h) or salaried (s): ");
	type = inputn.nextLine(); //stores the type of employee that the user inputs 
	if(type.equalsIgnoreCase("H") ||type.equalsIgnoreCase("S")){ //stops the program once input is correct
	break;
	}
	}

	//if statement if input is h or H
	if(type.equalsIgnoreCase("H")){
	System.out.print("Enter hourly wage: ");//prints out enter hourly wage
	wage = inputn.nextLine();//stores hourly wage user inputs
	//checks to see if user inputted a valid input
	while(wage1 == -0.000001){
	try {
	wage1 =Double.parseDouble(wage); //changes wage String input to Double value
	wage = "";
	}
	catch(NumberFormatException e) {
	System.out.println("You have made an error.");
	System.out.print("Enter hourly wage : ");
	wage = inputn.nextLine();//stores hourly wage user inputs
	}
	//if a valid number is there then check this if statement
	if(wage.equals("")){
	//if wage is negative then prompt the user they have made an error
	if(wage1 < 0.0){
	System.out.println("You have made an error. ");
	System.out.print("Enter hourly wage : ");
	wage = inputn.nextLine();//stores hourly wage user inputs
	wage1 = -0.000001; //reset variable for the while loop to continue until valid input is received
	}
	}
	}
	HourlyEmployee newEm = new HourlyEmployee(name, wage1); //creates a new HourlyEmployee object with the values of name and wage1
	employees.add(newEm); //adds the employee to the ArrayList of Employee objects
	}

	//if statement if input is s or S
	if(type.equalsIgnoreCase("S")) {
	System.out.print("Enter annual salary: "); //prints out enter annual salary
	wage = inputn.nextLine();//stores annual salary user inputs
	//checks to see if user inputted a valid input
	while(wage1 == -0.000001){
        try {
        wage1 =Double.parseDouble(wage);//changes wage String input to Double Value
	wage = "";
        }
        catch(NumberFormatException e) {
        System.out.println("You have made an error.");
        System.out.print("Enter annual salary: ");
        wage = inputn.nextLine();//stores hourly wage user inputs
        }
	//if a valid number is there then check this if statement
	if(wage.equals("")){
	//if salary is negative then prompt the user they have made an error
	if(wage1 < 0.0){
        System.out.println("You have made an error. ");
        System.out.print("Enter hourly wage : ");
        wage = inputn.nextLine();
        wage1 = -0.000001;//reset variable for the while loop to continue until valid input is received
        }}
	}
	SalariedEmployee newEm = new SalariedEmployee(name,wage1);//creates a new SalariedEmployee object with the values of name and wage1
	employees.add(newEm);//adds the employee to the ArrrayList of Employee objects
	}
	}
	//case c 
	//Precondition: The ArrayList that stores Employee objects should be created. The Arraylist of Employee objects should have at
	//least one Employee object to sucessfully use this method.      
	//Postcondition: Every Employee object in the ArrayList will have their pay checks computed depending on how many hours they have 
	//worked.
	public static void casec(ArrayList<Employee> employees){
	String hours; //String that stores the number of hours the employee worked
	double hours1 = -0.000001; //double value that stores the number of hours the employee worked
	Scanner inputc = new Scanner(System.in); //creating a Scanner named inputc
	//goes through every Employee object in the ArrayList
	for(int i = 0; i<employees.size(); i++) {
	System.out.print("Enter number of hours worked by " + employees.get(i).getName()+ ": ");//prints name of the employee at a current
	//index
	hours = inputc.nextLine();//stores the number of hours the user inputs
	//checks to see if user inputted a valid input
	while(hours1 == -0.000001){
	try {
	hours1 = Double.parseDouble(hours);//changes hours String input to Double Value
	hours = "";
	}
	catch(NumberFormatException e) {
	System.out.println("You have made an error.");
	System.out.print("Enter number of hours worked by " + employees.get(i).getName()+ ": ");//prints name of employee at current index
	hours = inputc.nextLine();//stores the number of hours the user inputs
	}
	//if a valid number is there then check this if statement
	if(hours.equals("")){
	//if hours is negative then prompt the user they have made an error
	if(hours1 < 0.0){
        System.out.println("You have made an error. ");
	System.out.print("Enter number of hours worked by " + employees.get(i).getName()+ ": ");//prints name of employee at current index       
	hours = inputc.nextLine();//stores number of hours the user inputs
        hours1 = -0.000001;//reset variable for the while loop to continue until valid input is received
        }
	}}
	System.out.println("Pay: $" + employees.get(i).toDollars(computePay1(employees,i,hours1)));//print the employee's pay
	hours = null;//reset hours for next loop iteration
	hours1 = -0.000001;//reset hours1 for next loop iteration
	}
	}
	//case r
	//Precondition:The ArrayList that stores Employee objects should be created. The Arraylist of Employee objects should have at
	//least one Employee object to sucessfully use this method.
	//Postcondition: Every Employee object in the ArrayList will have their wages raised by a certain percentage and their new wages
	//printed out along with their names.
	public static void caser(ArrayList<Employee> employees){
	String percentage; //String that stores the number of hours the employee worked
	double percentage1 = -0.000001; //double value that stores the percentage
	Scanner inputr = new Scanner(System.in); //creating a Scanner named inputr
	System.out.print("Enter percentage increase: ");
	percentage = inputr.nextLine();//stores the pecentage that user inputs
	//checks to see if user inputted a valid input
	while(percentage1 == -0.000001) {
	try{ 
	percentage1 = Double.parseDouble(percentage);//changes percentage String input to Double Value
	percentage = "";
	}
	catch(NumberFormatException e){
	System.out.println("You have made an error.");
	System.out.print("Enter percentage increase: ");
	percentage = inputr.nextLine();//stores the number of percentage the user inputs
	}
	//if a valid number is there then check this if statement
	if(percentage.equals("")){
	//if percentage is negative then prompt the user they have made an error
	if(percentage1 < 0.0){
        System.out.println("You have made an error. ");
        System.out.print("Enter percentage increase: ");
        percentage = inputr.nextLine();//stores the percentage that user inputs
        percentage1 = -0.000001;//reset variable for the while loop to continue until valid input is received
        }
	}}
	System.out.println();
	System.out.println("New Wages");
	System.out.println("---------");
	//for loop to print the wages of all the employees in the ArrayList after the increase in wage
	for(int i = 0; i <employees.size(); i++){
	employees.get(i).increaseWage(percentage1);
	System.out.println(employees.get(i).toString());}
	}
	//case p
	//Precondition: The ArrayList that stores Employee objects should be created. The Arraylist of Employee objects should have at
	//least one Employee object to sucessfully use this method.
	//Postcondition: Every Employee object in the ArrayList will be printed out with their name and their wage.
	public static void casep(ArrayList<Employee> employees){
	System.out.println();
	System.out.println("Employees and their Wages");
	System.out.println("--------------------------");
	//for loop to print the name and wages of all the employees in the ArrayList
	for(int i = 0; i<employees.size(); i++){
	System.out.println(employees.get(i).toString());}
	}
	//compute pay method that is used in case c
	//Precondition: The ArrayList that stores Employee objects should be created. The ArrayList of Employee objects should have at
	//least one Employee object to sucessfully use this method. The number of hours will be inputted by the user.
	//Postcondition: The pay of the Employee object at a particular index will be computed.
	public static double computePay1(ArrayList <Employee> employees,int index, double hours) {
	double pay;//double that stores the pay of the employee
	pay =employees.get(index).computePay(hours);//calls the computePay method from the specific type of employee class
	return pay;
	}
	//cased 
	//Precondition: The ArrayList that stores Employee objects should be created. The ArrayList may or may not have Employee objects
	//stored in it.
	//Postcondition: A file will be created that stores the objects that are written.
	public static void cased(ArrayList <Employee> employees){
	String fileName = "Employees.dat";//String that stores file name
	ArrayList<Employee> a = new ArrayList<Employee>();//a ArrayList with no objects called a
	/*test code*/
	//a.add(new SalariedEmployee("Collin",80000));
	//a.add(new SalariedEmployee("Jacob",70000));
	//writing the objects to the file and error catching if there is any issues
	try {
	FileOutputStream fileOut =
            new FileOutputStream(fileName);
          ObjectOutputStream out =
            new ObjectOutputStream(fileOut);
          out.writeObject(a);
          out.close();
        }
        catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
	//caseu
	//Precondition: The ArrayList that stores Employee objects should be created. The ArrayList may or may not have Employee objects
	//stored in it.
	//Postcondition: Will read the file and add the objects to the arraylist called employees to the end of the list.
	public static void caseu(ArrayList <Employee> employees){
	String fileName = "Employees.dat";//String that stores file name
	ArrayList<Employee> a = null;//a Arraylist of type Employee initialized to null
	//reading the objects from the file
	try {
          FileInputStream fileIn =
            new FileInputStream(fileName);
          ObjectInputStream in =
            new ObjectInputStream(fileIn);
          a = (ArrayList<Employee>) in.readObject();
          in.close();
        }
        catch (IOException e) {
          System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
          System.out.println(e.getMessage());
        }
	//adding objects from the ArrayList a to the ArrayList called employees to the end of the list
        for (int i = 0;  i < a.size();  i++)
                employees.add(a.get(i));

      }
}



	

	
	
	
	
	
	
