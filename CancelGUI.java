
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;


import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class CancelGUI extends JFrame implements ActionListener, MouseListener{
    private JLabel definition;
    private String email;
    private JTextField userText;
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField passText;


        public CancelGUI(String email){
        super("User");
        this.email = email;
        setupGUI();
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);    
        addMouseListener(this);
        
    }
     public void setupGUI(){
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.createConnection();

        String name = dbConnection.getNameFromEmail(email);
        List<String> cancellableIds = dbConnection.getFlightIDsToCancel(name);
        List<String> cancellableFlights = dbConnection.getFlightsToCancel(cancellableIds);
        definition = new JLabel("Enter Login Info:");

        JButton button = new JButton("Login");
        button.addActionListener(this);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        for (int i = 0; i < cancellableFlights.size(); i++) {
            JButton flightButton = new JButton(cancellableFlights.get(i));
            flightButton.setBounds(20, 40, 125, 25);
            final int index = i;

            flightButton.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event){
                    String[] options = {"CONFIRM", "CANCEL"};
                    int optionSelected =JOptionPane.showOptionDialog(rootPane, "Cancel: " + cancellableFlights.get(index),
                    "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
                    if (optionSelected == 0) {
                        dbConnection.deletePassengers(Integer.valueOf(cancellableIds.get(index)), name);
                        JOptionPane.showMessageDialog(rootPane, "Flight Cancelled Successfully.", "Success",  
                        JOptionPane.DEFAULT_OPTION);
                    }
                }
    
            });
            clientPanel.add(flightButton);
        }
        
        headerPanel.add(definition);

        submitPanel.add(button);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
}

    public void actionPerformed(ActionEvent event){
  

        if (User.loginUser(userText.getText(), passText.getText())) {
            new UserSelectGUI(userText.getText()).setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Credentials", "Login Failed",  
            JOptionPane.DEFAULT_OPTION);
        }
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
            new UserGUI().setVisible(true);        
        });
    }

    
    public void mouseClicked(MouseEvent e) {
        
    }
}