/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import bookguiexam.BookData;
import bookguiexam.BookSales;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookSalesTest {
    BookSales sales;
    @BeforeEach void init(){sales=new BookSales();}

    @Test
    void CalculateTotalSale_ReturnsExpectedValue(){
        double result=sales.CalculateTotalSale(2,100);
        assertEquals(228.0,result,0.01);
    }

    @Test
    void ValidationTests(){
        BookData invalid=new BookData("",0,-10);
        assertFalse(sales.ValidateData(invalid));
        BookData valid=new BookData("Java Basics",1,150);
        assertTrue(sales.ValidateData(valid));
    }
}
