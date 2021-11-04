import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        // Create new ArrayList.
        ArrayList<Integer> elements = new ArrayList<>();

        // Add three elements.
        elements.add(10);
        elements.add(15);
        elements.add(20);

        // Get size and display.
        int count = elements.size();
        System.out.println("Count: " + count);

        // Loop through elements.
        for (int i = 0; i < elements.size(); i++) {
            int value = elements.get(i);
            System.out.println("Element: " + value);
        }
    }
}