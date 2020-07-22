package databind;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        try{

            ObjectMapper objectMapper = new ObjectMapper();
            Student theStudent = objectMapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println("First Name = " + theStudent.getFirstName());
            System.out.println("Surname = " + theStudent.getLastName());
            System.out.println(theStudent.getAddress().toString());
            System.out.println(Arrays.toString(theStudent.getLanguages()));

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
