/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.io.Serializable;
import java.util.*;

/**
 * Time counter.
 * @author Kamil
 */
public class Clock implements Serializable, Enumeration<String> 
{
    private int mins, secs;
    
    /**
     * Create instance with minutes and seconds equals zero.
     */
    public Clock()
    {
        mins = 0;
        secs = 0;
    }
    
    /**
     * Check if next element exist. Always true.
     * @return true
     */
    @Override
    public boolean hasMoreElements() 
    {
        return true;
    }

    /**
     * Returns next element of time.
     * @return String Minutes:Seconds
     */
    @Override
    public String nextElement() 
    {
        String res;
        secs++;
        
        if(secs == 60)
        {
            mins++;
            secs=0;
        }
        
        if(secs<10)
            res = mins + ":0" + secs;
        else
            res = mins + ":" + secs;
        
        return res;        
    }
    
    /**
     * Returns current time in seconds.
     * @return int - time in seconds
     */
    public int toSeconds()
    {
        return secs + mins * 60;
    }
    
    /**
     * Returns current time.
     * @return String Minutes:Seconds
     */
    @Override
    public String toString()
    {
        String res;
        
        if(secs<10)
            res = mins + ":0" + secs;
        else
            res = mins + ":" + secs;
        
        return res;  
    }


    
}
