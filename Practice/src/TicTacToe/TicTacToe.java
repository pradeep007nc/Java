package TicTacToe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame Frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel ButtonPanel = new JPanel();
    JLabel textFiled = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton button=new JButton();
    Boolean Player1_turn;

    TicTacToe() {
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(800, 800);
        Frame.getContentPane().setBackground(new Color(50, 50, 50));
        Frame.setLayout(new BorderLayout());
        Frame.setVisible(true);

        textFiled.setBackground(new Color(255, 25, 25));
        textFiled.setForeground(new Color(25, 255, 0));
        textFiled.setFont(new Font("Ink Free", Font.BOLD, 70));
        textFiled.setHorizontalAlignment(JLabel.CENTER);
        textFiled.setText("Tic-Tac-Toe");
        textFiled.setOpaque(true);


        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        ButtonPanel.setLayout(new GridLayout(3, 3));
        ButtonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            ButtonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textFiled);
        Frame.add(titlePanel, BorderLayout.NORTH);
        Frame.add(ButtonPanel);
        firstTurn();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (Player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        Player1_turn = false;
                        textFiled.setText("O Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        Player1_turn = true;
                        textFiled.setText("X Turn");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn() {

        if (random.nextInt(2) == 0) {
            Player1_turn = true;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            textFiled.setText("X turn");
        } else {
            Player1_turn = false;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            textFiled.setText("O turn");
        }
    }

    public void check() {
        if(
                (buttons[0].getText().equals("X"))&&
                (buttons[1].getText().equals("X"))&&
                (buttons[2].getText().equals("X"))
        ){
            xWins(0,1,2);
        }
        if(
                (buttons[0].getText().equals("X"))&&
                        (buttons[3].getText().equals("X"))&&
                        (buttons[6].getText().equals("X"))
        ){
            xWins(0,3,6);
        }
        if(
                (buttons[3].getText().equals("X"))&&
                        (buttons[4].getText().equals("X"))&&
                        (buttons[5].getText().equals("X"))
        ){
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText().equals("X"))&&
                        (buttons[7].getText().equals("X"))&&
                        (buttons[8].getText().equals("X"))
        ){
            xWins(6,7,8);
        }
        if(
                (buttons[1].getText().equals("X"))&&
                        (buttons[4].getText().equals("X"))&&
                        (buttons[7].getText().equals("X"))
        ){
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText().equals("X"))&&
                        (buttons[5].getText().equals("X"))&&
                        (buttons[8].getText().equals("X"))
        ){
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText().equals("X"))&&
                        (buttons[4].getText().equals("X"))&&
                        (buttons[8].getText().equals("X"))
        ){
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText().equals("X"))&&
                        (buttons[4].getText().equals("X"))&&
                        (buttons[6].getText().equals("X"))
        ){
            xWins(2,4,6);
        }
      //O wins
        if(
                (buttons[0].getText().equals("O"))&&
                        (buttons[1].getText().equals("O"))&&
                        (buttons[2].getText().equals("O"))
        ){
            oWins(0,1,2);
        }
        if(
                (buttons[0].getText().equals("O"))&&
                        (buttons[3].getText().equals("O"))&&
                        (buttons[6].getText().equals("O"))
        ){
            oWins(0,3,6);
        }
        if(
                (buttons[3].getText().equals("O"))&&
                        (buttons[4].getText().equals("O"))&&
                        (buttons[5].getText().equals("O"))
        ){
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText().equals("O"))&&
                        (buttons[7].getText().equals("O"))&&
                        (buttons[8].getText().equals("O"))
        ){
            oWins(6,7,8);
        }
        if(
                (buttons[1].getText().equals("O"))&&
                        (buttons[4].getText().equals("O"))&&
                        (buttons[7].getText().equals("O"))
        ){
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText().equals("O"))&&
                        (buttons[5].getText().equals("O"))&&
                        (buttons[8].getText().equals("O"))
        ){
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText().equals("O"))&&
                        (buttons[4].getText().equals("O"))&&
                        (buttons[8].getText().equals("O"))
        ){
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText().equals("O"))&&
                        (buttons[4].getText().equals("O"))&&
                        (buttons[6].getText().equals("O"))
        ){
            oWins(2,4,6);
        }


    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.orange);
        buttons[b].setBackground(Color.orange);
        buttons[c].setBackground(Color.orange);
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textFiled.setText("X Wins");

    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textFiled.setText("O Wins");

    }

}



