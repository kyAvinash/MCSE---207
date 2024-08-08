import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Assembler {

    // Define the opcode table with more instructions
    private static final Map<String, String> opcodeMap = new HashMap<>();

    static {
        opcodeMap.put("LDA", "00"); // Load accumulator
        opcodeMap.put("ADD", "01"); // Add
        opcodeMap.put("SUB", "02"); // Subtract
        opcodeMap.put("STA", "03"); // Store accumulator
        opcodeMap.put("LDR", "04"); // Load register
        opcodeMap.put("STR", "05"); // Store register
        opcodeMap.put("JMP", "06"); // Jump
        opcodeMap.put("JZ", "07");  // Jump if zero
        opcodeMap.put("JNZ", "08"); // Jump if not zero
        opcodeMap.put("HLT", "09"); // Halt
        //We can Add more instructions if needed
    }

    public static void main(String[] args) {
        // File paths
        String inputFile = "source.asm";
        String outputFile = "output.txt";

        // Process the source file and generate output
        processFile(inputFile, outputFile);
    }

    private static void processFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String instruction = parts[0];
                String operand = parts.length > 1 ? parts[1] : "";

                String opcode = opcodeMap.get(instruction);

                if (opcode != null) {
                    if (instruction.equals("HLT")) {
                        writer.write(opcode);
                        writer.newLine(); // HLT has no operand
                    } else {
                        writer.write(opcode + " " + operand);
                        writer.newLine();
                    }
                } else {
                    System.out.println("Unknown instruction: " + instruction);
                }
            }
            System.out.println("Translation complete. Check " + outputFile + " for machine code.");

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}
