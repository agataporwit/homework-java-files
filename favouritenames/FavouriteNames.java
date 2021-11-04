package favouritenames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Program reads from two files BoyNames.txt, and GirlNames.txt into separate ArrayLists.
 *After loading the 2 ArrayLists, prompts the user to enter one or more names.
 *Prints if name or names were popular or no popular. 
 *Displays message indicating that the name was not a favorite name for boys or girls if the name was not found in either of the ArrayLists.
 * @throw IOEception
 * @author agatajelen Assignment 1, CSD 143 April 13, 2018
 */
public class FavouriteNames {

    public static void main(String[] args) {
        //create two array lists to store the names of boys and girls respectively
        ArrayList<String> boyNames = new ArrayList<>();
        ArrayList<String> girlNames = new ArrayList<>();
        try {
            //open the text file that contains boy names
            BufferedReader br = new BufferedReader(new FileReader("BoyNames.txt"));
            String name;
            //read each name from the file and store it in the array list
            while ((name = br.readLine()) != null) {
                boyNames.add(name);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("'BoyNames.txt' cannot be opened");
        }
        try {
            //open the text file that contains girl names
            BufferedReader br = new BufferedReader(new FileReader("GirlNames.txt"));
            String name;
            //read each name from the file and store it in the array list
            while ((name = br.readLine()) != null) {
                girlNames.add(name);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("'GirlNames.txt' cannot be opened");
        }

        //create another array list to store the names entered by the user
        ArrayList<String> findNames = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        //prompt the user to enter one or more names
        System.out.println("Enter one or more names (Press 'q' when you finished with your names list and press enter to display the results): ");
        boolean repeat = true;
        while (repeat) {
            //add each of the names entered by the user to an array list
            String n = input.nextLine();
            if (n.equalsIgnoreCase("q")) {
                repeat = false;
            } else {
                findNames.add(n);
            }
        }

        System.out.println();
        //search the names in the boys array list  
        for (int i = 0; i < findNames.size(); i++) {
            boolean isFound = false;
            //search each name in the array list of boys names
            for (int j = 0; j < boyNames.size(); j++) {
                if (!isFound) {
                    //if name is found print that name is found in boys list
                    if (findNames.get(i).equalsIgnoreCase(boyNames.get(j))) {
                        System.out.println("" + findNames.get(i) + " is favourite name for boys.");
                        isFound = true;
                    }
                }
            }
            //search each name in the array list of girls names
            for (int k = 0; k < girlNames.size(); k++) {
                if (!isFound) {
                    //if name is found print that name is found in girls list
                    if (findNames.get(i).equalsIgnoreCase(girlNames.get(k))) {
                        System.out.println("" + findNames.get(i) + " is favourite name for girls.");
                        isFound = true;
                    }
                }
            }
            //if name is not fount print appropriate message
            if (!isFound) {
                System.out.println("" + findNames.get(i) + " is not favourite name for boys or girls.");
            }
        }
    }

}
