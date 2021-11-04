package EmployeeMapDemo;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMap {

    /** create a private Map objectVarName **/

    Map<Integer, Employee> empMap;

    public EmployeeMap()

    {

// Instantiate map. Using new keyword HashMap()

        empMap = new HashMap<Integer, Employee>();

    }

    //Use put keyword(e.getIdNum(),e
    public void add(Employee e)

    {

        empMap.put(e.getId(),e);

    }

    //return employeeMap.get(idNum)
    public Employee get(Integer idNumber)

    {

        return empMap.get(idNumber);

    }

}