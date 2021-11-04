package HashTableOptional;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer>map = new Map<>();
        map.add("this",4 );
        map.add("coder",5);
        map.add("this",3);
        map.add("hi",7 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}