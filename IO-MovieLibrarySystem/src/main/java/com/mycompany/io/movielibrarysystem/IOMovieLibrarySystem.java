

package com.mycompany.io.movielibrarysystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOMovieLibrarySystem {

    public static void main(String[] args) {
      String fileName = "movies.txt";

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            String line;
            System.out.println("Welcome to the Movie Library!");
            System.out.println("--------------------------------");

            while ((line = br.readLine()) != null) {
                
//                String[] movieData = line.split(",");// Split each line by comma
//
//                String title = movieData[0].trim();
//                String genre = movieData[1].trim();
//                String year = movieData[2].trim();
//                System.out.println("Title: " + title);
//                System.out.println("   Genre: " + genre);
//                System.out.println("   Year: " + year);
//                System.out.println("--------------------------------");


                // Read and display each line as-is
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
              
            }

            br.close();
            reader.close();
            
            System.out.println("All movies displayed successfully!");

        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }

        
        
        
    }
}
