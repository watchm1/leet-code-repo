package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("leetCode console app ready.");
        if (args.length > 0) {
            System.out.println("Args: " + String.join(", ", args));
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter something (or press Enter to exit): ");
        String line = reader.readLine();
        if (line != null && !line.isEmpty()) {
            System.out.println("You typed: " + line);
        }
    }
}
