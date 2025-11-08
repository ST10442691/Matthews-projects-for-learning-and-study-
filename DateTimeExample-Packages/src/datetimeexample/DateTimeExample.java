
package datetimeexample;

//import java.time.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeExample {
    public static void main(String[] args) {
        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);
  System.out.println("-------------------------------------------");
  
        // Creating a specific date
        LocalDate specificDate = LocalDate.of(2023, 9, 20);
        System.out.println("Specific Date: " + specificDate);
  System.out.println("-------------------------------------------");
  
        // Creating a specific time
        LocalTime specificTime = LocalTime.of(15, 30, 0);
        System.out.println("Specific Time: " + specificTime);
  System.out.println("-------------------------------------------");
  
        // Combining date and time
        LocalDateTime combinedDateTime = specificDate.atTime(specificTime);
        System.out.println("Combined Date and Time: " + combinedDateTime);
  System.out.println("-------------------------------------------");
  
        // Formatting date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
        String formattedDateTime = combinedDateTime.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime);
  System.out.println("-------------------------------------------");
  
        // Date calculations
        LocalDate futureDate = specificDate.plus(30, ChronoUnit.DAYS);
        LocalDate pastDate = specificDate.minus(90, ChronoUnit.DAYS);
        LocalDate oneYearLater = specificDate.plus(1, ChronoUnit.YEARS);

  
        System.out.println("Date 30 days from specific date: " + futureDate);
          System.out.println("-------------------------------------------");
          
        System.out.println("Date 90 days ago from specific date: " + pastDate);
          System.out.println("-------------------------------------------");
          
        System.out.println("Date 1 year from specific date: " + oneYearLater);
    }
}

