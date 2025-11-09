/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package flightgui;

/**
 *
 * @author lab_services_student
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class FlightGUI extends JFrame implements ActionListener {
    JComboBox<String> cboDest=new JComboBox<>(new String[]{"Cape Town","Durban","Johannesburg"});
    JTextField txtTickets=new JTextField(), txtPrice=new JTextField();
    JTextArea txtReport=new JTextArea();
    JMenuItem mnuProcess=new JMenuItem("Process"), mnuClear=new JMenuItem("Clear"), mnuExit=new JMenuItem("Exit");
    IFlightTicket flight=(IFlightTicket) new FlightTicket();

    public FlightGUI(){
        setTitle("Airline Ticket Booking System");
        setSize(500,400); setLayout(null);

        JLabel l1=new JLabel("Destination:"), l2=new JLabel("Tickets:"), l3=new JLabel("Price per Ticket:");
        l1.setBounds(40,40,100,25); l2.setBounds(40,80,100,25); l3.setBounds(40,120,120,25);
        cboDest.setBounds(160,40,200,25); txtTickets.setBounds(160,80,200,25); txtPrice.setBounds(160,120,200,25);
        txtReport.setBounds(40,170,400,150); txtReport.setEditable(false);

        JMenuBar bar=new JMenuBar(); JMenu file=new JMenu("File"); JMenu actions=new JMenu("Actions");
        file.add(mnuExit); actions.add(mnuProcess); actions.add(mnuClear); bar.add(file); bar.add(actions);
        setJMenuBar(bar);

        add(l1); add(l2); add(l3); add(cboDest); add(txtTickets); add(txtPrice); add(txtReport);

        mnuExit.addActionListener(this); mnuProcess.addActionListener(this); mnuClear.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE); setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==mnuExit)dispose();
        if(e.getSource()==mnuClear){txtTickets.setText("");txtPrice.setText("");txtReport.setText("");}
        if(e.getSource()==mnuProcess){
            try{
                String dest=cboDest.getSelectedItem().toString();
                int tickets=Integer.parseInt(txtTickets.getText());
                double price=Double.parseDouble(txtPrice.getText());
                FlightData data=new FlightData(dest,tickets,price);
                if(!flight.ValidateData(data)){JOptionPane.showMessageDialog(this,"Invalid input!");return;}
                double total=flight.CalculateTotalTicketPrice(tickets,price);
                String report="Destination: "+dest+"\nTickets: "+tickets+"\nPrice per Ticket: "+price+
                        "\nTotal incl. VAT: "+String.format("%.2f",total);
                txtReport.setText(report);
                FileWriter fw=new FileWriter("FlightReport.txt"); fw.write(report); fw.close();
            }catch(Exception ex){JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());}
        }
    }
    public static void main(String[] args){new FlightGUI();}
}
