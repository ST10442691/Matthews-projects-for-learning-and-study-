/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login.system;

/**
 *
 * @author lab_services_student
 */
public class LoginSystem {
    public static void main(String[] args) {
        IDandPasswords idandPasswords = new IDandPasswords();
        new LoginPage(idandPasswords.getLoginInfo());
    }
}
