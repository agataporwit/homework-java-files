import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.*;

public class ReadInput {
    public static void main(String[] args) throws IOException {
        BufferedReader R = new BufferedReader(new InputStreamReader(in));
        out.print("Input your name: ");
        String name = R.readLine();
        out.println("Your name is: " + name);
    }
}

