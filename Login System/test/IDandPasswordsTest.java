/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import org.junit.jupiter.api.Test;
import java.util.HashMap;
import login.system.IDandPasswords;
import static org.junit.jupiter.api.Assertions.*;

public class IDandPasswordsTest {

    @Test
    void testGetLoginInfoContainsDefaultUsers() {
        IDandPasswords idp = new IDandPasswords();
        HashMap<String, String> info = idp.getLoginInfo();

        assertTrue(info.containsKey("Bro"));
        assertEquals("pizza", info.get("Bro"));
    }

    @Test
    void testGetLoginInfoReturnsCopy() {
        IDandPasswords idp = new IDandPasswords();
        HashMap<String, String> info = idp.getLoginInfo();
        info.put("NewUser", "test");

        assertFalse(idp.getLoginInfo().containsKey("NewUser"));
    }
}
