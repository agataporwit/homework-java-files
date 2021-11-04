package EmployeeMapDemo;

public class Employee {


    private int id;


    private String firstName;

    private String lastName;

    private String streetAddress;

    private String city;

    private String state;

    private String zip;

    private String hireDate;

    public Employee()

    {
//constructor

        id = 0;

        this.firstName = "";

        this.lastName = "";

        this.streetAddress = "";

        this.city = "";

        this.state = "";

        this.zip = "";

        this.hireDate = "";

    }

    Employee(int id, String firstName, String lastName, String streetAddress, String city, String state,

             String zip, String hireDate) {

        this.id = id;

        this.firstName = firstName;

        this.lastName = lastName;

        this.streetAddress = streetAddress;

        this.city = city;

        this.state = state;

        this.zip = zip;

        this.hireDate = hireDate;

    }


    public int getId() {

        return id;

    }


  /*  public void setId(int id) {

        this.id = id;

    }

    public String getFirstName() {

        return firstName;

    }


    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }


    public String getLastName() {

        return lastName;

    }


    public void setLastName(String lastName) {

        this.lastName = lastName;

    }


    public String getStreetAddress() {

        return streetAddress;

    }

    public void setStreetAddress(String streetAddress) {

        this.streetAddress = streetAddress;

    }


    public String getCity() {

        return city;

    }

    public void setCity(String city) {

        this.city = city;

    }

    public String getState() {

        return state;

    }


    public void setState(String state) {

        this.state = state;

    }


    public String getZip() {

        return zip;

    }


    public void setZip(String zip) {

        this.zip = zip;

    }


    public String getHireDate() {

        return hireDate;

    }


    public void setHireDate(String hireDate) {

        this.hireDate = hireDate;

    }
*/

    @Override

    public String toString() {

        return "Employee ID: " + id + "\nFirst Name: " + firstName + "\nLastName: " + lastName + "\nAddress: "

                + streetAddress + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip + "\nHired On: " + hireDate;

    }

}
