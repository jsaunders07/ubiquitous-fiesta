package game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gui{
    JLabel roomTitle = new JLabel("");
    JTextArea roomDescription = new JTextArea("");
    JTextArea actionDescription = new JTextArea("");
    JLabel inputLabel = new JLabel("What do you want to do?");
    JTextField textInput = new JTextField("");
    public boolean enterPressed = false;

    public Gui(String windowTitle) {
        JFrame mainWindow = new JFrame(windowTitle);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(800, 850);

        roomTitle.setBounds(50, 20, 700, 50);
        roomTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        roomTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        roomDescription.setBounds(50, 80, 700, 300);
        roomDescription.setBorder(BorderFactory.createLineBorder(Color.black));
        roomDescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        roomDescription.setEditable(false);
        //roomDescription.setVerticalAlignment(JLabel.TOP);
        //roomDescription.setHorizontalTextPosition(JLabel.LEFT);
        actionDescription.setBounds(50, 400, 700, 300);
        actionDescription.setBorder(BorderFactory.createLineBorder(Color.red));
        actionDescription.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        actionDescription.setForeground(Color.red);
        actionDescription.setEditable(false);
        //actionDescription.setVerticalAlignment(JLabel.TOP);
        //actionDescription.setHorizontalTextPosition(JLabel.LEFT);
        inputLabel.setBounds(50, 685, 700, 50);
        textInput.setBounds(50, 720, 700, 50);
        mainWindow.add(roomTitle);
        mainWindow.add(roomDescription);
        mainWindow.add(actionDescription);
        mainWindow.add(inputLabel);
        mainWindow.add(textInput);

        
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
    }

    public void setRoomName(String roomName) {
        roomTitle.setText(roomName);
    }

    public void setRoomDesc(String roomDesc) {
        roomDescription.setText(roomDesc);
    }

    public void setActionDesc(String actDesc) {
        actionDescription.setText(actDesc);
    }
    
    public String getActionDesc() {
        return actionDescription.getText();
    }
    
    public String getInput() {
    	return textInput.getText();
    }
    
    public void runOnEnter(JTextField textf) {
    	textf.addActionListener(e -> {
        	Game.runLogic();
        });
    }
    
    public void setInput(String a) {
    	textInput.setText(a);
    }
    
    public boolean getEnterPressed() {
    	return enterPressed;
    }

    public static void main(String[] args) {
        Gui goat = new Gui("Hey Goat");
        goat.setRoomName("The Loo");
        goat.setActionDesc("Your'e going loo");
        goat.setRoomDesc("Toilet sadface");
    }
}