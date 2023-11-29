
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;


import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class ViewFlights extends JFrame implements ActionListener, MouseListener{
    private JLabel definition;
    private JTextArea textArea;
    private String selection = "No Flight Selected";
    private int index;
    


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
        JButton button = new JButton("Select Flight");
        button.addActionListener(this);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        String textString = "";
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.createConnection();
        List<String> flights = dbConnection.getFlightDetails();
        for (int i = 0; i < flights.size(); i++) {
            JButton flightButton = new JButton(flights.get(i));
            flightButton.setBounds(20, 40, 125, 25);
            index = i;

            flightButton.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event){
                    String[] options = {"CONFIRM", "CANCEL"};
                    int optionSelected =JOptionPane.showOptionDialog(rootPane, "Confirmation: " + flights.get(i),
                    "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
                    if (optionSelected == 0) {
                        new Payforit().setVisible(true);
                    }
                }
    
            });
            clientPanel.add(flightButton);
        }
        textArea = new JTextArea(textString);
        
        
        definition = new JLabel("Available Filghts:");
        

        
        headerPanel.add(definition);

        submitPanel.add(button);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
        

 
        // textArea.setEditable(false);  
        // textArea.setLineWrap(true);  
        // textArea.setWrapStyleWord(true); 
        // JScrollPane scroll = new JScrollPane(textArea);
        // scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // this.add(scroll, BorderLayout.CENTER);
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



