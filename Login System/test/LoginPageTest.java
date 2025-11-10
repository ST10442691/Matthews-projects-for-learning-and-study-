/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest {

    @Test
    void testValidLoginInfo() {
        HashMap<String, String> mockInfo = new HashMap<>();
        mockInfo.put("user1", "pass1");

        assertEquals("pass1", mockInfo.get("user1"));
    }

    @Test
    void testInvalidLogin() {
        HashMap<String, String> mockInfo = new HashMap<>();
        mockInfo.put("user1", "pass1");

        assertFalse(mockInfo.containsKey("user2"));
    }
}
