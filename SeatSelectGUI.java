
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;


import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class SeatSelectGUI extends JFrame implements ActionListener, MouseListener{
    private JLabel definition;
    private String flight;
    int availableSeats = 52;

        public SeatSelectGUI(String flight){
        super("Seat Select");
        this.flight = flight;
        setupGUI();
        setSize(250,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);    
        addMouseListener(this);
        
    }
     public void setupGUI(){

        
        
        definition = new JLabel("Select Seat:");
        
        JButton button = new JButton("Confirm");
        button.addActionListener(this);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(definition);

        // submitPanel.add(button);
        for (int i = 0; i  < availableSeats; i++) {
            JButton flightButton = new JButton(Integer.toString(i + 1) + ' ');
            flightButton.setBounds(20, 40, 125, 25);
            final int index = i;

            flightButton.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event){
                    String[] options = {"CONFIRM", "CANCEL"};
                    int optionSelected =JOptionPane.showOptionDialog(rootPane, "Confirmation: Seat " + index,
                    "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
                    if (optionSelected == 0) {
                        new PaymentGUI(index).setVisible(true);
                    }
                }
    
            });
            clientPanel.add(flightButton);
        }
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
}

    public void actionPerformed(ActionEvent event){

        
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
            new SeatSelectGUI("wooo").setVisible(true);        
        });
    }

    
    public void mouseClicked(MouseEvent e) {
        
    }
}