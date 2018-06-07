/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Represents ranking, three best scores of easy, medium and hard level.
 * @author Kamil
 */
public class Ranking implements Serializable
{
    private Score[] easy = new Score[3];
    private Score[] medium = new Score[3];
    private Score[] hard = new Score[3];
    
    /**
     * Generates new ranking and adds achieved results from serialized file
     * @throws ClassNotFoundException 
     */
    public Ranking() throws ClassNotFoundException
    {
        for(int i=0; i<3; i++)
        {
            easy[i] = new Score();
            medium[i] = new Score();
            hard[i] = new Score();
        }
        
        try
        {
            FileInputStream file_in = new FileInputStream("ranking.ser");
            ObjectInputStream in = new ObjectInputStream(file_in);
            Ranking r = (Ranking) in.readObject();
            easy = r.get_easy();
            medium = r.get_medium();
            hard = r.get_hard();
            in.close();
            file_in.close();
        }
        catch(IOException ex) 
        {
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("Lista nie znaleziona");
        }
    }
    
    /**
     * Returns three best scores of easy's level
     * @return 
     */
    public Score[] get_easy()
    {
        return easy;
    }
    
    /**
     * Returns three best scores of medium's level
     * @return 
     */
    public Score[] get_medium()
    {
        return medium;
    }
    
    /**
     * Returns three best scores of hard's level
     * @return 
     */
    public Score[] get_hard()
    {
        return hard;
    }
    
    /**
     * Adds new score to the ranking if necessary
     * @param lvl
     * @param scr 
     */
    public void update(int lvl, Score scr)
    {
        if(lvl == 1) // easy
        {
            for(int i=0; i<3; i++)
            {
                if(easy[i].get_moves() == 0)
                {
                    easy[i] = scr;
                    try
                    {
                        FileOutputStream file_out = new FileOutputStream("ranking.ser");
                        ObjectOutputStream out = new ObjectOutputStream(file_out);
                        out.writeObject(this);
                        out.close();
                        file_out.close();
                    }
                    catch(IOException e)
                    {
                    }
                    return;
                }
                else
                {
                    int rank_secs = easy[i].get_time().toSeconds();
                    int new_secs = scr.get_time().toSeconds();
                    
                    if((new_secs < rank_secs) || (new_secs == rank_secs && scr.get_moves() < easy[i].get_moves()))
                    {
                        if(i == 0)
                        {
                            easy[2] = easy[1];
                            easy[1] = easy[0];
                            easy[0] = scr;
                        }
                        else if(i == 1)
                        {
                            easy[2] = easy[1];
                            easy[1] = scr;
                        }
                        else
                            easy[i] = scr;
                        
                        try
                        {
                            FileOutputStream file_out = new FileOutputStream("ranking.ser");
                            ObjectOutputStream out = new ObjectOutputStream(file_out);
                            out.writeObject(this);
                            out.close();
                            file_out.close();
                        }
                        catch(IOException e)
                        {
                        }
                        return;
                    }
                }
            }           
        }
        else if(lvl == 2) // medium 
        {
            for(int i=0; i<3; i++)
            {
                if(medium[i].get_moves() == 0)
                {
                    medium[i] = scr;
                    try
                    {
                        FileOutputStream file_out = new FileOutputStream("ranking.ser");
                        ObjectOutputStream out = new ObjectOutputStream(file_out);
                        out.writeObject(this);
                        out.close();
                        file_out.close();
                    }
                    catch(IOException e)
                    {
                    }
                    return;
                }
                else
                {
                    int rank_secs = medium[i].get_time().toSeconds();
                    int new_secs = scr.get_time().toSeconds();
                    
                    if((new_secs < rank_secs) || (new_secs == rank_secs && scr.get_moves() < medium[i].get_moves()))
                    {
                        if(i == 0)
                        {
                            medium[2] = medium[1];
                            medium[1] = medium[0];
                            medium[0] = scr;
                        }
                        else if(i == 1)
                        {
                            medium[2] = medium[1];
                            medium[1] = scr;
                        }
                        else
                            medium[i] = scr;
                        
                        try
                        {
                            FileOutputStream file_out = new FileOutputStream("ranking.ser");
                            ObjectOutputStream out = new ObjectOutputStream(file_out);
                            out.writeObject(this);
                            out.close();
                            file_out.close();
                        }
                        catch(IOException e)
                        {
                        }
                        return;
                    }
                }
            } 
        }
        else if(lvl == 3) // hard 
        {
            for(int i=0; i<3; i++)
            {
                if(hard[i].get_moves() == 0)
                {
                    hard[i] = scr;
                    try
                    {
                        FileOutputStream file_out = new FileOutputStream("ranking.ser");
                        ObjectOutputStream out = new ObjectOutputStream(file_out);
                        out.writeObject(this);
                        out.close();
                        file_out.close();
                    }
                    catch(IOException e)
                    {
                    }
                    return;
                }
                else
                {
                    int rank_secs = hard[i].get_time().toSeconds();
                    int new_secs = scr.get_time().toSeconds();
                    
                    if((new_secs < rank_secs) || (new_secs == rank_secs && scr.get_moves() < hard[i].get_moves()))
                    {
                        if(i == 0)
                        {
                            hard[2] = hard[1];
                            hard[1] = hard[0];
                            hard[0] = scr;
                        }
                        else if(i == 1)
                        {
                            hard[2] = hard[1];
                            hard[1] = scr;
                        }
                        else
                            hard[i] = scr;
                        
                        try
                        {
                            FileOutputStream file_out = new FileOutputStream("ranking.ser");
                            ObjectOutputStream out = new ObjectOutputStream(file_out);
                            out.writeObject(this);
                            out.close();
                            file_out.close();
                        }
                        catch(IOException e)
                        {
                        }
                        return;
                    }
                }
            } 
        }
    }
    
    
}
