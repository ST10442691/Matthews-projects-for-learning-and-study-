/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coffeegui;

/**
 *
 * @author lab_services_student
 */
import static java.awt.Color.red;
import java.awt.LayoutManager;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class CoffeeGUI extends JFrame implements ActionListener {

    JComboBox<String> cboCoffee = new JComboBox<>(new String[]{"Espresso","Cappuccino","Latte","Americano"});
    JTextField txtCups = new JTextField();
    JTextField txtPrice = new JTextField();
    JTextArea txtReport = new JTextArea();
    

    JMenuItem mnuProcess = new JMenuItem("Process Price");
    JMenuItem mnuClear   = new JMenuItem("Clear");
    JMenuItem mnuExit    = new JMenuItem("Exit app");

    ICoffeeOrder order = new CoffeeOrder();

    public CoffeeGUI() {
        setTitle("Coffee Shop Order System");
        setSize(500,400);
        setLayout((LayoutManager) red);

        JLabel lbl1 = new JLabel("Coffee:");
        JLabel lbl2 = new JLabel("Cups:");
        JLabel lbl3 = new JLabel("Price per Cup:");

        lbl1.setBounds(40,40,100,25);
        lbl2.setBounds(40,80,100,25);
        lbl3.setBounds(40,120,120,25);

        cboCoffee.setBounds(160,40,200,25);
        txtCups.setBounds(160,80,200,25);
        txtPrice.setBounds(160,120,200,25);

        txtReport.setBounds(40,170,400,150);
        txtReport.setEditable(false);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        file.add(mnuExit);
        tools.add(mnuProcess);
        tools.add(mnuClear);
        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);

        add(lbl1); add(lbl2); add(lbl3);
        add(cboCoffee); add(txtCups); add(txtPrice); add(txtReport);

        mnuExit.addActionListener(this);
        mnuProcess.addActionListener(this);
        mnuClear.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mnuExit) dispose();

        if(e.getSource()==mnuClear){
            txtCups.setText(""); txtPrice.setText(""); txtReport.setText("");
        }

        if(e.getSource()==mnuProcess){
            try{
                String coffee = cboCoffee.getSelectedItem().toString();
                int cups = Integer.parseInt(txtCups.getText());
                double price = Double.parseDouble(txtPrice.getText());
                CoffeeData data = new CoffeeData(coffee,cups,price);

                if(!order.ValidateData(data)){
                    JOptionPane.showMessageDialog(this,"Invalid data entered!");
                    return;
                }

                double total = order.CalculateTotalPrice(cups,price);
                String report = "Coffee: "+coffee+
                        "\nCups: "+cups+
                        "\nPrice per cup: "+price+
                        "\nTOTAL (incl. VAT): "+String.format("%.2f",total);
                txtReport.setText(report);

                FileWriter fw = new FileWriter("CoffeeReport.txt");
                fw.write(report);
                fw.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
            }
        }
    }

    public static void main(String[] args){ new CoffeeGUI(); }
}
