
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;



import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class Main extends JFrame implements ActionListener {
    private JLabel definition;

        public Main(){
        super("Group 7 Airlines");
        setupGUI();
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);   
        
    }
     public void setupGUI(){

        definition = new JLabel("Welcome to Group 7 Airlines, Please select an option:");
        
        JButton userLoginButton = new JButton("Login as User");
        userLoginButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                new UserGUI().setVisible(true);
            }

        });
        JButton adminLoginButton = new JButton("Login as Admin");
        adminLoginButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                new AdminGUI().setVisible(true);
            }
        });
        JButton crewLoginButton = new JButton("Login as Crew");
        crewLoginButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                new CrewGUI().setVisible(true);
            }
        });
        JButton userRegButton = new JButton("Register as User");
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
            new Main().setVisible(true);        
        });
    }

}