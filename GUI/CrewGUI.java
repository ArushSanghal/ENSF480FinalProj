package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;


import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class CrewGUI extends JFrame implements ActionListener, MouseListener{
    private JLabel definition;
    private JTextArea textArea = new JTextArea("PASSENGERS\ng\ng\ng\ng\ng\ng\ng\ng\ng\ng\ngS\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\n");

        public CrewGUI(){
        super("Crew");
        setupGUI();
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);    
        addMouseListener(this);
        
    }
     public void setupGUI(){

        
        
        definition = new JLabel("Click to View Passengers:");
        
        JButton button = new JButton("Browse Passengers");
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
        textArea.setEditable(false);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize( new Dimension( 300, 400 ) );
        JOptionPane.showMessageDialog(rootPane, scroll, "Passengers",  
                                                        JOptionPane.DEFAULT_OPTION);
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
            new CrewGUI().setVisible(true);        
        });
    }

    
    public void mouseClicked(MouseEvent e) {
        
    }
}