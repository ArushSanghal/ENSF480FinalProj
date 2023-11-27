package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;


import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class ViewFlights extends JFrame implements ActionListener, MouseListener{
    private JLabel definition;
    private JTextArea textArea = new JTextArea("\tALL THE FLIGHTS\n\n\n\tFORMATTED FLIGHTS GO HERE\n\n\n\tVancouver to Montreal 8:30PM PST");
    private String selection = "No Flight Selected";
    


    /**
     * Constructs a new GUI object.
     */
    public ViewFlights(){
        super("View Available Flights");
        setupGUI();
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);    
        addMouseListener(this);
        
    }
    
    /**
     * Sets up the graphical user interface.
     */
    public void setupGUI(){

        
        
        definition = new JLabel("Available Filghts:");
        
        JButton button = new JButton("Select Flight");
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
        

 
        textArea.setEditable(false);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll, BorderLayout.CENTER);
    }
    

    public void actionPerformed(ActionEvent event){
        String[] options = {"CONFIRM", "CANCEL"};
        if (selection != "No Flight Selected") {
            int optionSelected =JOptionPane.showOptionDialog(rootPane, "Confirmation: " + selection,
            "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
            if (optionSelected == 0) {
                new Payforit().setVisible(true);
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Please Select a Flight", "Selection Failed",  
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
        if (textArea.getSelectedText() != null) { // See if they selected something 
            this.selection = textArea.getSelectedText();
            
        }
        else {
            this.selection = "No Flight Selected";
        }

    }
    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new ViewFlights().setVisible(true);        
        });
    }

    
    public void mouseClicked(MouseEvent e) {
        
    }
}



