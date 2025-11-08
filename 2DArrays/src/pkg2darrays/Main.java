
package pkg2darrays;


public class Main {

    public static void main(String[] args) {
         // Define a 2D array with 3 rows and 4 columns
        int[][] twoDimensionalArray = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Accessing elements in the array
        int elementAtRow1Column2 = twoDimensionalArray[1][2]; 
// This will give you the value 7
        
        System.out.println("The element at position [1][2] is " + elementAtRow1Column2);
        
        TwoDArray(twoDimensionalArray);// Invoke your method here
    }
    
    //Create your method for your 2D array.Array2D is the parameter
    public static void TwoDArray(int[][] Array2D)
    {

    for(int i=0; i< Array2D.length; i++)
    {           
      for (int j=0; j < Array2D[i].length; j++)
        // The loop runs from j = 0 (the first column of the current row) to 
        // j < Array2D[i].length (the last column of the current row).
      {
          System.out.print(Array2D[i][j] + " "); 
//Print values of element at current row 'i' and column 'j'
      }
      
      System.out.println();// Here you can change the print or println
    }
    
    }
}

