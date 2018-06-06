/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.awt.*;
import javax.swing.*;

/**
 * Displays three best scores of each level.
 * @author Kamil
 */
public class Leaderboard extends JFrame
{
    private final Ranking r = new Ranking();
    
    private final JPanel panel = new JPanel(new GridLayout(6, 1));
    private final JPanel lvl_easy = new JPanel(new GridLayout(4, 3));
    private final JPanel lvl_medium = new JPanel(new GridLayout(4, 3));
    private final JPanel lvl_hard = new JPanel(new GridLayout(4, 3));
    
    private int font_size = 18;
    
    {
        Score[] lvl = r.get_easy();
        lvl_easy.add(new JLabel("#")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        lvl_easy.add(new JLabel("Time")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        lvl_easy.add(new JLabel("Moves")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        
        for(int i=0; i<3; i++)
        {
            if(lvl[i].get_moves() == 0)
            {
                lvl_easy.add(new JLabel("" + (i+1)));
                lvl_easy.add(new JLabel("-"));
                lvl_easy.add(new JLabel("-"));
            }
            else
            {
                lvl_easy.add(new JLabel("" + (i+1)));
                lvl_easy.add(new JLabel(lvl[i].get_time().toString()));
                lvl_easy.add(new JLabel("" + lvl[i].get_moves()));
            }
        }
        
        lvl = r.get_medium();
        lvl_medium.add(new JLabel("#")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        lvl_medium.add(new JLabel("Time")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        lvl_medium.add(new JLabel("Moves")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        
        for(int i=0; i<3; i++)
        {
            if(lvl[i].get_moves() == 0)
            {
                lvl_medium.add(new JLabel("" + (i+1)));
                lvl_medium.add(new JLabel("-"));
                lvl_medium.add(new JLabel("-"));
            }
            else
            {
                lvl_medium.add(new JLabel("" + (i+1)));
                lvl_medium.add(new JLabel(lvl[i].get_time().toString()));
                lvl_medium.add(new JLabel("" + lvl[i].get_moves()));
            }
        }
        
        lvl = r.get_hard();
        lvl_hard.add(new JLabel("#")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        lvl_hard.add(new JLabel("Time")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        lvl_hard.add(new JLabel("Moves")).setFont(new Font("Dialog", Font.PLAIN, font_size));
        
        for(int i=0; i<3; i++)
        {
            if(lvl[i].get_moves() == 0)
            {
                lvl_hard.add(new JLabel("" + (i+1)));
                lvl_hard.add(new JLabel("-"));
                lvl_hard.add(new JLabel("-"));
            }
            else
            {
                lvl_hard.add(new JLabel("" + (i+1)));
                lvl_hard.add(new JLabel(lvl[i].get_time().toString()));
                lvl_hard.add(new JLabel("" + lvl[i].get_moves()));
            }
        }
        
        panel.add(new JLabel("Easy", JLabel.CENTER)).setFont(new Font("Dialog", Font.PLAIN, font_size));
        panel.add(lvl_easy);
        panel.add(new JLabel("Medium", JLabel.CENTER)).setFont(new Font("Dialog", Font.PLAIN, font_size));
        panel.add(lvl_medium);
        panel.add(new JLabel("Hard", JLabel.CENTER)).setFont(new Font("Dialog", Font.PLAIN, font_size));
        panel.add(lvl_hard);
    }
    
    /**
     * Generates new window with best scores
     * @throws ClassNotFoundException 
     */
    public Leaderboard() throws ClassNotFoundException 
    {
        super("Memory game");
        setSize(350, 420);
        setLocation(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel);
        setVisible(true);
    }
}
