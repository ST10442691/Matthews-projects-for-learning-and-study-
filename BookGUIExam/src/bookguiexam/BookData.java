/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookguiexam;

/**
 *
 * @author lab_services_student
 */
public class BookData {
    public String bookName;
    public int quantity;
    public double price;
    public BookData(String name,int qty,double price){
        this.bookName=name; this.quantity=qty; this.price=price;
    }
}
