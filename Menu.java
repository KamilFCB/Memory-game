/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Menu which enable to choose level, show best scores and instrucion of the game.
 * @author Kamil
 */
public class Menu extends JFrame
{
    private final JPanel panel = new JPanel(new GridLayout(5, 1));
    private final JButton l_easy = new JButton("Easy");
    private final JButton l_medium = new JButton("Medium");
    private final JButton l_hard = new JButton("Hard");
    private final JButton info = new JButton("How to play");
    private final JButton top = new JButton("Leaderboard");
    
    private final ActionListener easy_listener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            new Level("Easy");
        }
    };
    
    private final ActionListener medium_listener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            new Level("Medium");
        }
    };
    
    private final ActionListener hard_listener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            new Level("Hard");
        }
    };
    
    private final ActionListener top_listener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            try {
                new Leaderboard();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    };
    
    private final ActionListener how_to_play = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            new Info("Turn over one tile and then try to find a matching tile. There are 3 levels, each getting progressively harder.");
        }
    };
            
    {
        l_easy.addActionListener(easy_listener);
        l_medium.addActionListener(medium_listener);
        l_hard.addActionListener(hard_listener);
        info.addActionListener(how_to_play);
        top.addActionListener(top_listener);
        l_easy.setFont(new Font("Dialog", Font.PLAIN, 17));
        l_medium.setFont(new Font("Dialog", Font.PLAIN, 17));
        l_hard.setFont(new Font("Dialog", Font.PLAIN, 17));
        info.setFont(new Font("Dialog", Font.PLAIN, 17));
        top.setFont(new Font("Dialog", Font.PLAIN, 17));
        panel.add(l_easy);
        panel.add(l_medium);
        panel.add(l_hard);
        panel.add(top);
        panel.add(info);
    }
    
    /**
     * Generates menu
     */
    public Menu()
    {
        super("Memory game");
        setSize(325, 310);
        setLocation(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
        
    }
}
