
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;


import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class PaymentGUI extends JFrame implements ActionListener, MouseListener{
    private JLabel definition;
    private int seat;
    private JTextField userText;
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField passText;

        public PaymentGUI(int seat){
        super("Seat Select");
        this.seat = seat;
        setupGUI();
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);    
        addMouseListener(this);
        
    }
     public void setupGUI(){

        
        
        definition = new JLabel("Enter Payment Info:");

        userLabel = new JLabel("Please Enter Email For Flight Detalis:");
        userLabel.setBounds(20, 40, 260, 25);
        this.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(260, 40, 165, 25);
        this.add(userText);
        
        passLabel = new JLabel("Enter Your Credit Card Number:");
        passLabel.setBounds(20, 70, 260, 25);
        this.add(passLabel);

        passText = new JTextField(20);
        passText.setBounds(260, 70, 165, 25);
        this.add(passText);

        passLabel = new JLabel("Expiration Date:");
        passLabel.setBounds(160, 100, 150, 25);
        this.add(passLabel);

        passText = new JTextField(20);
        passText.setBounds(260, 100, 50, 25);
        this.add(passText);

        passLabel = new JLabel("CVV:");
        passLabel.setBounds(320, 100, 30, 25);
        this.add(passLabel);

        passText = new JTextField(20);
        passText.setBounds(360, 100, 30, 25);
        this.add(passText);
        
        JButton button = new JButton("Make Payment");
        button.addActionListener(this);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(definition);

        submitPanel.add(button);


        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
}

    public void actionPerformed(ActionEvent event){
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.getConnection();
        dbConnection.insertPassengers(not done);
        
    }
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){


    }
    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new PaymentGUI(1).setVisible(true);        
        });
    }

    
    public void mouseClicked(MouseEvent e) {
        
    }
}