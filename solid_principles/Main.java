import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// this class i made just to familiar with string manipulation

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = input.length();

        System.out.println("is empty: " + input.isEmpty());
        System.out.println("is blank: " + input.isBlank());

        String s = input.strip(); // removes all trailing and leading spaces
        String s1 = input.toLowerCase();
        String s2 = input.toUpperCase();
        String s3 = input.replaceAll("\\s+", "");

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        String[] parts = s3.split("[,\\s]+");
        for(int i = 0; i < parts.length; i++){
            System.out.println(parts[i]);
        }
    }
}
