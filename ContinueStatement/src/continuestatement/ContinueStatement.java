/*
Java's continue statement without label transfers control to the immediate enclosing while, do, or for loop. 
Whereas, a continue statement with label transfers control to the labeled loop statement. 
The following program illustrates the use of both unlabeled, and labeled continue statements.
 */
package continuestatement;

/**
 *
 * @author agatajelen
 */
public class ContinueStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
    // demonstrating unlabelled break
    System.out.println("Demonstration of unlabeled continue:");
    for (int i =1; i <= 50; i++)
    {
      if (i % 5 != 0) continue;
      System.out.format("%5d", i);
    }
 
    System.out.println("\n");
    System.out.println("Demonstration of labeled continue:");
    outer:
    for (int i =1; i <= 50; i++)
    {
      for(int j = 1; j <= 10; j++)
      {
        if (i % 5 != 0) continue outer;
        System.out.format("%5d", i*j);
      }
      System.out.println();
    }
  }
}
