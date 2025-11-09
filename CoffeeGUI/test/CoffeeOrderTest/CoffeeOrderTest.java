/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package CoffeeOrderTest;

import coffeegui.CoffeeData;
import coffeegui.CoffeeOrder;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeOrderTest {

    CoffeeOrder order;

    @BeforeEach
    void init(){ order = new CoffeeOrder(); }

    @Test
    void CalculateTotalPrice_CalculatedSuccessfully(){
        double total = order.CalculateTotalPrice(2,20);
        assertEquals(46.0, total, 0.01);
    }

    @Test
    void ValidationTests(){
        CoffeeData invalid = new CoffeeData("",0,-5);
        assertFalse(order.ValidateData(invalid));
        CoffeeData valid = new CoffeeData("Latte",2,30);
        assertTrue(order.ValidateData(valid));
    }
}
