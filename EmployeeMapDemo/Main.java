package EmployeeMapDemo;

/*
@author: Agata Jelen, CSD 143, Spring 2018
Assignment 6 part 1
Create an Employee class that stores an employee’s ID number and information about the employee.
Then create an EmployeeMap that allows you to add Employee objects and look them up by employee ID number.
The EmployeeMap class should use a Map object to map ID numbers to Employee objects. Create an application
to demonstrate the classes.
The employee information you store in the map must include employee name (first, last),
address (street address, city, state, zip), and hire date.
*/

public class Main {

    public static void main(String[] args) {

// Create an instance of EmployeeMap.

        EmployeeMap Emap = new EmployeeMap();

// Create an array of employees

        Employee e1 = new Employee(123, "Agata", "Jelen", "1003 166th AVE", "Bellevue", "US", "98008",

                "21-Mar-1991\n");

        Employee e2 = new Employee(124, "Sasha", "Labradoodle", "4 Paws Street", "Seattle", "US", "98006", "21-Apr-2009\n");

        Employee e3 = new Employee(125, "Kuma", "Jackson", "Washington Street", "Kirkland", "US", "98009", "21-May-1991\n");

// Add the employees to EmployeeMap using a loop

        Emap.add(e1);

        Emap.add(e2);

        Emap.add(e3);

// Search for the mappings that was added.

        searchEmployee(Emap, 123);
        searchEmployee(Emap, 124);
        //searchEmployee(Emap, 125);

// Search for a mapping that does not exist.



        searchEmployee(Emap, 777);
    }

    public static void searchEmployee(EmployeeMap objectVar,

                                      Integer id)
    {

        Employee emp = objectVar.get(id);

// Display Employees with valid ID

        if (emp != null) {

            System.out.println("Employee with ID number "+ id + " has been  found : \n\n" + emp);
        }
//not found
        else

            System.out.println( "Employee with  ID number "+ id +" could not be found \n\n");

    }

}