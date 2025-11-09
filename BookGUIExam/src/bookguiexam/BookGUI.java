/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookguiexam;

/**
 *
 * @author lab_services_student
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class BookGUI extends JFrame implements ActionListener {
    JComboBox<String> cboBook = new JComboBox<>(new String[]{"Java Basics","Python Power","C# for Beginners"});
    JTextField txtQty=new JTextField(), txtPrice=new JTextField();
    JTextArea txtReport=new JTextArea();
    JMenuItem mnuProcess=new JMenuItem("Process"), mnuClear=new JMenuItem("Clear"), mnuExit=new JMenuItem("Exit");
    IBookSales sales = new BookSales();

    public BookGUI(){
        setTitle("Bookstore Sales Tracker");
        setSize(500,400); setLayout(null);

        JLabel l1=new JLabel("Book:"), l2=new JLabel("Quantity:"), l3=new JLabel("Price:");
        l1.setBounds(40,40,80,25); l2.setBounds(40,80,80,25); l3.setBounds(40,120,80,25);
        cboBook.setBounds(150,40,200,25); txtQty.setBounds(150,80,200,25); txtPrice.setBounds(150,120,200,25);
        txtReport.setBounds(40,170,400,150); txtReport.setEditable(false);

        JMenuBar bar=new JMenuBar(); JMenu file=new JMenu("File"); JMenu salesMenu=new JMenu("Sales");
        file.add(mnuExit); salesMenu.add(mnuProcess); salesMenu.add(mnuClear);
        bar.add(file); bar.add(salesMenu); setJMenuBar(bar);

        add(l1); add(l2); add(l3); add(cboBook); add(txtQty); add(txtPrice); add(txtReport);

        mnuExit.addActionListener(this); mnuProcess.addActionListener(this); mnuClear.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE); setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==mnuExit)dispose();
        if(e.getSource()==mnuClear){txtQty.setText("");txtPrice.setText("");txtReport.setText("");}
        if(e.getSource()==mnuProcess){
            try{
                String book=cboBook.getSelectedItem().toString();
                int qty=Integer.parseInt(txtQty.getText());
                double price=Double.parseDouble(txtPrice.getText());
                BookData data=new BookData(book,qty,price);
                if(!sales.ValidateData(data)){JOptionPane.showMessageDialog(this,"Invalid input!");return;}
                double total=sales.CalculateTotalSale(qty,price);
                String report="Book: "+book+"\nQuantity: "+qty+"\nPrice: "+price+"\nTotal incl. VAT: "+String.format("%.2f",total);
                txtReport.setText(report);
                FileWriter fw=new FileWriter("BookSales.txt"); fw.write(report); fw.close();
            }catch(Exception ex){JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());}
        }
    }
    public static void main(String[] args){new BookGUI();}
}
