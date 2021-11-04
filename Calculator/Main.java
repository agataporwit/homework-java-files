package Agata_Jelen_asignment3_CSD_143;

/**
 * @author agatajelen
 * CSD 143 , Spring 2018
 * Implementation of anonymous inner classes,
 * Lambda
 * MathPow
 * Fctorial
 * Radius
 */

public class Main {

    static IntCalculator polynomial = new IntCalculator()
    {
        public int calculate(int number)
        {
            return number * number + 2 * number + 4;
        }
    };

    static IntCalculator polynomialLambda = x -> x * x + 2 * x + 4;

    static DoubleCalculator mathPow = new DoubleCalculator()
    {
        public double power(double num1, double num2)
        {
            return Math.pow(num1, num2);
        }
    };
    static DoubleCalculator mathPowering =(x , y) -> Math.pow(x,y);

    static RadiusCalculator calcRadius  = new RadiusCalculator()
    {
        public double calcRadius  (double rad)
        {
            return Math.PI * rad * rad;
        }
    };
    static RadiusCalculator radCalc = x -> Math.PI * x * x;

    static FactorialCalculator factorial = new FactorialCalculator()
    {
        public double calculateFactorial(int num)
        {
            if (num <= 0)
            {
                return 1;
            }
            double total = 1;
            for(int i = 1; i <= num; i++)
            {
                total *= i;
            }
            return total;
        }
    };

    static FactorialCalculator fact = x -> {
        if (x <= 0)
        {
            return 1;
        }
        double total = 1;
        for(int i = 1; i <= x; i++)
        {
            total *= i;
        }
        return total;
    };

    // tests four expression handlers

    public static void main(String[] args)
    {
        System.out.println(polynomial.calculate(5));
        System.out.println(polynomialLambda.calculate(5));
        System.out.println(mathPow.power(4,8));
        System.out.println(mathPowering.power(2,9));
        System.out.println(calcRadius.calcRadius(10));
        System.out.println(radCalc.calcRadius(10));
        System.out.println(factorial.calculateFactorial(8));
        System.out.println(fact.calculateFactorial(4));
    }
}


