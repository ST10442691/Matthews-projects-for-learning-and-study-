
package filesexample;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FilesExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\dengovender\\Downloads\\FilesExample.txt");

        try {
            // Check if the file exists
            if (Files.exists(path)) {
                // Read content from the file
                String content = Files.readString(path);
                System.out.println("File Content: " + content);

                // Write to the file
                Files.writeString(path, "Updated content of the file");
                System.out.println("File updated.");
            } else {
                // Create a new file if it doesn't exist
                Files.createFile(path);
                System.out.println("File created.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

