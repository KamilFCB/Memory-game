/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Class responsible for the game.
 * @author Kamil
 */
public class Level extends JFrame 
{
    private int rows;
    private int cols;
    private int level;
    private int clicked = 0;
    private Score score = new Score();
    private int clicked_cords[][] = new int[2][2];
    private Card[][] cards;
    private JPanel panel = new JPanel(new FlowLayout());
    private JPanel timer = new JPanel(new BorderLayout());
    private final JPanel board;
    private Random generator = new Random();
    private JLabel time_label = new JLabel("Time: " + score.get_time().toString(), JLabel.CENTER);
    private JLabel moves_label = new JLabel("Moves: 0", JLabel.CENTER);
    private String[] lvl_cards;
    
    private java.util.Timer mTimer = new java.util.Timer();
    
    javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) 
        {
            if(clicked == 2)
            {
                if(check() == 0)                
                    cover();
                                
                clicked = 0;
            }
            enable_all();
        }
    });
    
    
    private void disable_all()
    {
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                cards[i][j].getButtion().removeActionListener(cards_listener);
    }
    
    private void enable_all()
    {
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                cards[i][j].getButtion().addActionListener(cards_listener);
    }
    
    private void start() 
    {
        mTimer.scheduleAtFixedRate(mTask, 1000, 1000);
    }
    
    private TimerTask mTask = new TimerTask() 
    {
        @Override
        public void run()
        {
            score.get_time().nextElement();
            time_label.setText("Time: " + score.get_time().toString());
        }
    };
    
    
    private void rand()
    {
        int c = (rows*cols)/2;
        int[] used = new int[c];
        int rand;
        
        for(int i=0; i<c; i++)
            used[i] = 2;
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                cards[i][j]=new Card();
                rand = generator.nextInt(c);
                
                while(used[rand] == 0)
                    rand = generator.nextInt(c);
                
                used[rand]--;
                cards[i][j].setImage(lvl_cards[rand]);
            }
        }
    }
    
    private boolean is_game_over()
    {
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(!cards[i][j].is_uncovered())
                    return false;
            }
        }
        return true;
    }
    
    private void cover()
    {
        cards[clicked_cords[0][0]][clicked_cords[0][1]].cover();
        cards[clicked_cords[1][0]][clicked_cords[1][1]].cover();
    }
    
    private int check()
    {
        return cards[clicked_cords[0][0]][clicked_cords[0][1]].compareTo(cards[clicked_cords[1][0]][clicked_cords[1][1]]);
    }
    
    private ActionListener cards_listener = new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JButton b = (JButton)e.getSource();
            String s = b.getText();
            int x = s.charAt(0)-'0';
            int y = s.charAt(2)-'0';
            
            if(cards[x][y].is_uncovered() || cards[x][y].is_clicked())
                return;
            
            cards[x][y].uncover();
            cards[x][y].setClicked();
            clicked_cords[clicked][0] = x;
            clicked_cords[clicked][1] = y;
            clicked++;
            
            if(clicked == 2)
            {
                score.increment_moves();
                moves_label.setText("Moves: " + score.get_moves());
                
                if(check() == 1)
                {
                    cards[clicked_cords[0][0]][clicked_cords[0][1]].setUncovered();
                    cards[clicked_cords[1][0]][clicked_cords[1][1]].setUncovered();
                    
                    clicked = 0;
                    
                    if(is_game_over())
                    {
                        mTimer.cancel(); 
                        try 
                        {
                            Ranking r = new Ranking();
                            r.update(level, score);
                        } catch (ClassNotFoundException ex) {                        
                        }   
                        new Info("End of the game!", score.get_time().toString(), score.get_moves());                                     
                    }  
                }
                else
                {
                    disable_all();
                    t.start();
                }
                              
            }
            
        }        
    };
    
    /**
     * Generates new board depending on the level selected by player.
     * @param lvl
     */
    public Level(String lvl)
    {
        super(lvl + " level");
        int height = 100, width = 100;
        
        if(lvl.equals("Easy"))
        {
            rows = 3;
            cols = 4;
            level = 1;
            width = cols * 126;
            height = rows * 179;
            lvl_cards = new String[6];            
            lvl_cards[0] = "robot1";
            lvl_cards[1] = "robot2";
            lvl_cards[2] = "robot3";
            lvl_cards[3] = "robot4";
            lvl_cards[4] = "robot5";
            lvl_cards[5] = "robot6";
        }
        else if(lvl.equals("Medium"))
        {
            rows = 4;
            cols = 4;
            level = 2;
            width = cols * 126;
            height = rows * 179;
            lvl_cards = new String[8];            
            lvl_cards[0] = "robot1";
            lvl_cards[1] = "robot2";
            lvl_cards[2] = "robot3";
            lvl_cards[3] = "robot4";
            lvl_cards[4] = "robot5";
            lvl_cards[5] = "robot6";
            lvl_cards[6] = "robot7";
            lvl_cards[7] = "robot8";
        }
        else if(lvl.equals("Hard"))
        {
            rows = 4;
            cols = 5;
            level = 3;
            width = cols * 126;
            height = rows * 179;
            lvl_cards = new String[10];            
            lvl_cards[0] = "robot1";
            lvl_cards[1] = "robot2";
            lvl_cards[2] = "robot3";
            lvl_cards[3] = "robot4";
            lvl_cards[4] = "robot5";
            lvl_cards[5] = "robot6";
            lvl_cards[6] = "robot7";
            lvl_cards[7] = "robot8";
            lvl_cards[8] = "robot9";
            lvl_cards[9] = "robot10";
        }
        
        cards = new Card[rows][cols];
        board = new JPanel(new GridLayout(rows, cols));
        rand();
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                cards[i][j].getButtion().setText(i + " " + j);
                cards[i][j].getButtion().addActionListener(cards_listener);
                board.add(cards[i][j].getButtion());
            }
        }
        
        t.setInitialDelay(1000);
        t.setRepeats(false);
        timer.setPreferredSize(new Dimension(100, height));
        board.setPreferredSize(new Dimension(width, height));
        time_label.setFont(new Font("Dialog", Font.PLAIN, 18));
        moves_label.setFont(new Font("Dialog", Font.PLAIN, 18));
        timer.add(time_label, BorderLayout.NORTH);
        timer.add(moves_label, BorderLayout.SOUTH);
        panel.add(timer, BorderLayout.WEST);
        panel.add(board, BorderLayout.EAST);
        setLocation(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel);
        setVisible(true);
        pack();
        start();
    }
}
