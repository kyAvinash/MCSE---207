import java.io.*;
import java.util.regex.*;

public class SyntaxErrorHandler {

    // Define a regex pattern for a simple arithmetic expression
    private static final Pattern expressionPattern = Pattern.compile("^[0-9]+[+\\-*/][0-9]+$");

    public static void main(String[] args) {
        // File paths
        String inputFile = "source.txt";
        
        // Process the source file and detect syntax errors
        processFile(inputFile);
    }

    private static void processFile(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (!isValidExpression(line)) {
                    System.out.println("Syntax error on line " + lineNumber + ": " + line);
                }
            }
            System.out.println("Syntax checking complete.");

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static boolean isValidExpression(String line) {
        Matcher matcher = expressionPattern.matcher(line);
        return matcher.matches();
    }
}
