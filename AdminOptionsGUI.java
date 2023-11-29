
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;



import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class AdminOptionsGUI extends JFrame implements ActionListener {
    private JLabel definition;
    private JTextArea textArea = new JTextArea("PASSENGERS\ng\ng\ng\ng\ng\ng\ng\ng\ng\ng\ngS\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\n");

        public AdminOptionsGUI(){
        super("Admin Menu");
        setupGUI();
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);   
        
    }
     public void setupGUI(){

        definition = new JLabel("Logged in as Admin, Please select an option:");
        
        JButton userLoginButton = new JButton("Browse Flights");
        userLoginButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                new UserGUI().setVisible(true);
            }

        });
        JButton adminLoginButton = new JButton("Browse Passengers");
        adminLoginButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                textArea.setEditable(false);  
                textArea.setLineWrap(true);  
                textArea.setWrapStyleWord(true); 
                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scroll.setPreferredSize( new Dimension( 300, 400 ) );
                JOptionPane.showMessageDialog(rootPane, scroll, "Passengers on flight #:",  
                                                                JOptionPane.DEFAULT_OPTION);
            }
        });
        JButton crewLoginButton = new JButton("Add Flight");
        crewLoginButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                new CrewGUI().setVisible(true);
            }
        });
        JButton userRegButton = new JButton("Modify Flight");
        userRegButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                new UserRegGUI().setVisible(true);
            }
        });
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(definition);

        clientPanel.add(userLoginButton);
        clientPanel.add(adminLoginButton);
        clientPanel.add(crewLoginButton);
        clientPanel.add(userRegButton);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
}

    public void actionPerformed(ActionEvent event){

    }
    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new AdminOptionsGUI().setVisible(true);        
        });
    }

}