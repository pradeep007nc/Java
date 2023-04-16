package Bot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Bot extends JFrame {
    JTextArea chatArea=new JTextArea();
    JTextField chatBot=new JTextField();
    Bot(){
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(600,600);
        frame.setTitle("Chat Box");
        frame.add(chatArea);
        frame.add(chatBot);
        // For Text Area
        chatArea.setSize(500,400);
        chatArea.setLocation(40,15);


        //For text feild
        chatBot.setSize(500,30);
        chatBot.setLocation(40,470);

        chatBot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gText=chatBot.getText().toLowerCase();
                chatArea.append("You ->"+gText+" \n");
                chatBot.setText("");
                if(gText.contains("hi")){
                    bot("Hola");
                }else {
                    int rand = (int) (Math.random() * 3 + 1);
                    if (rand == 1) {
                        bot("I dont understand");
                    }
                    else if(rand == 2){
                        bot("I dont understand Bro");
                    }
                    else {
                        bot("Chutiya Ho Kya");
                    }
                }
            }
        });
    }
    void bot(String str){
        chatArea.append("Bot ->" +str+" \n");
    }
}

public class SimpleBot {
    public static void main(String[] args) {
        new Bot();
    }

}