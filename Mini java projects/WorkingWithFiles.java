import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class WorkingWithFiles {


    public String reading_file(String filePath) {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            String content = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                content = content + line;
            
            }            
            reader.close();
        return content;
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        return "";
        }
    }

    public void writing_file(String filePath, String content){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();

            System.out.println("Content written to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void copy(String sourceFilePath, String destinationFilePath){

        try (FileInputStream sourceStream = new FileInputStream(sourceFilePath);
             FileOutputStream destStream = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = sourceStream.read(buffer)) != -1) {
                destStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


}
