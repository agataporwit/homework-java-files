/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author agatajelen CSD 141 Winter 2018
 */
public class Geometry {

    /**
     * @param radius
     * @param args the command line arguments
     * @return
     */
    //Setting up calculations 
    public static double areaOfCircle(double radius) {
        return Math.PI * radius * radius;
    }

    public static double areaOfRectangle(double length, double width) {
        return length * width;
    }

    public static double areaOfTriangle(double base, double h) {
        return base * h * 0.5;
    }

    public static void main(String[] args) {

        int choice; // The user's menu choice

        do {
            // Get the user's menu choice.
            choice = getMenu();
//switch dtatements 
            switch (choice) {
                case 1:
                    calculateCircleArea();
                    break;
                case 2:
                    calculateRectangleArea();
                    break;
                case 3:
                    calculateTriangleArea();
                    break;
                case 4:
                    System.out.println("Thanks for calculating!");
                    break;
                default:
                    break;
            }

        } while (choice != 4);
    }

    public static int getMenu() {
//user picks which calcluations they woulf like to perform 
        int userChoice;

        // keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Display the menu.
        System.out.println("\nGeometry Calculator\n");
        System.out.println("1. Calculate the Area of a Circle");
        System.out.println("2. Calculate the Area of a Rectangle");
        System.out.println("3. Calculate the Area of a Triangle");
        System.out.println("4. Quit\n");
        System.out.print("Enter your choice (1-4) : ");

        // get input from user
        userChoice = keyboard.nextInt();

        // validate input
        while (userChoice < 1 || userChoice > 4) {
            System.out.print("Please enter a valid range: 1, 2, 3, or 4: ");
            userChoice = keyboard.nextInt();
        }

        return userChoice;
    }
//getting input from the user for specific dimentions - try/catch block used later on and used printf %.2f to have two numbers after decimal.

    public static void calculateCircleArea() {
        // Get input from user
        double radius = getInput("What is the circle's radius? ");

        // Display output
        System.out.printf("The circle's area is %.2f \n",
                Geometry.areaOfCircle(radius));
    }

    public static void calculateRectangleArea() {
        // Get length
        double length = getInput("Enter length? ");

        // Get width
        double width = getInput("Enter width? ");

        // Display output
        System.out.printf("The rectangle's area is %.2f \n", Geometry.areaOfRectangle(length, width));
    }

    public static void calculateTriangleArea() {
        double base = getInput("Enter length of the triangle's base? ");
        double height = getInput("Enter triangle's height? ");
        // Display the triangle's area.
        System.out.printf("The triangle's area is %.2f \n", Geometry.areaOfTriangle(base, height));
    }

    private static double getInput(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        double num = 0;
        // This is a try chatch that is chatiching if user inputs a negative number or a letter for dimentions
        do {
            System.out.print(prompt);
            try {
                num = keyboard.nextDouble();
                if (num <= 0) {
                    System.out.println("Number should be greater than zero. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number. Try again.");
                keyboard.nextLine();  // skippes line if incorrect input and goes back to the previous question 
            }
        } while (num <= 0);

        return num;
    }
}
