/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.system;

/**
 * This allows the user to login 
 **/


import java.util.HashMap;

public class IDandPasswords {

    private final HashMap<String, String> loginInfo = new HashMap<>();

    public IDandPasswords() {
        loginInfo.put("Matthew", "pizza");
        loginInfo.put("Prog", "PASSWORD");
        loginInfo.put("ST10442691", "abc1234");
    }

    public HashMap<String, String> getLoginInfo() {
        return new HashMap<>(loginInfo); 
    }
}
