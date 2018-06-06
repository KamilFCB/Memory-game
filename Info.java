/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.awt.*;
import javax.swing.*;

/**
 * Sends informations to the player.
 * @author Kamil
 */
public class Info extends JFrame
{
    private final JPanel panel = new JPanel(new BorderLayout(1, 3));
    private final JLabel info = new JLabel();
    private final JLabel time = new JLabel();
    private final JLabel moves = new JLabel();
    
    
    {
        panel.add(info, BorderLayout.NORTH);
        panel.add(time, BorderLayout.CENTER);
        panel.add(moves, BorderLayout.SOUTH);
    }
    
    /**
     * Shows a score after completed game.
     * @param t
     * @param time
     * @param moves 
     */
    public Info(String t, String time, int moves)
    {
        super("Victory!");
        info.setText(t);
        info.setHorizontalAlignment(JLabel.CENTER);
        this.time.setText("Your time: " + time);
        this.time.setHorizontalAlignment(JLabel.CENTER);
        this.moves.setText("Moves: " + Integer.toString(moves));
        this.moves.setHorizontalAlignment(JLabel.CENTER);
        info.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.time.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.moves.setFont(new Font("Dialog", Font.PLAIN, 15));        
        setSize(200, 150);
        setLocation(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel);
        setVisible(true);
    }
    
    /**
     * Shows rules of the game.
     * @param t 
     */
    public Info(String t)
    {
        super("How to play");
        info.setFont(new Font("Dialog", Font.PLAIN, 15));
        info.setText("<html><center>" + t + "</center></html>");
        setSize(300, 250);
        setLocation(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel);
        setVisible(true);
    }
}
