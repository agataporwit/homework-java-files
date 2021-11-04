

import org.jetbrains.annotations.Contract;

import java.util.Scanner;


/*
 * Write Java methods to calculate the area of a triangle.
 * @author Agata
 */


public class Area {

    private static double side1;
    private static double side2;
    private static double side3;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Input number for side A");
        double sideA = in.nextDouble();

        System.out.println("Input number for side B");
        double sideB = in.nextDouble();

        System.out.println("Input number for side C");
        double sideC = in.nextDouble();


        System.out.println(is_Valid(sideA, sideB, sideC) ? "The area of the triangle is " + area_triangle(sideA, sideB, sideC) : "Invalid triangle");
    }

    @Contract(pure = true)//for intelliJ only
    public static boolean is_Valid(double side1, double side2, double side3) {
        Area.side1 = side1;
        Area.side2 = side2;
        Area.side3 = side3;
        if (side1 + side2 > side3 &&
                side2 + side3 > side1 &&
                side1 + side3 > side2) return true;
        else return false;
    }

    public static double area_triangle(double side1, double side2, double side3) {
        double area = 0;
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}
