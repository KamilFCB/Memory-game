/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.io.Serializable;

/**
 * Represents result obtained by the player.
 * @author Kamil
 */
public class Score implements Serializable
{
    private Clock time;
    private int moves;
    
    /**
     * Generates new score.
     * @param t
     * @param m 
     */
    public Score(Clock t, int m)
    {
        time = t;
        moves = m;
    }
    
    /**
     * Generates empty result.
     */
    public Score()
    {
        time = new Clock();
        moves = 0;
    }
    
    /**
     * Returns time.
     * @return Clock
     */
    public Clock get_time()
    {
        return time;
    }
    
    /**
     * Returns moves.
     * @return int
     */
    public int get_moves()
    {
        return moves;
    }
    
    /**
     * Sets new time.
     * @param t 
     */
    public void set_time(Clock t)
    {
        time = t;
    }
    
    /**
     * Sets new moves.
     * @param m 
     */
    public void set_moves(int m)
    {
        moves = m;
    }
    
    /**
     * Increments number of the moves.
     */
    public void increment_moves()
    {
        moves++;
    }
    
    /**
     * Increments time.
     * @return String
     */
    public String increment_time()
    {
        return time.nextElement();
    }
}
