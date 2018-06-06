/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.util.Timer;
import java.util.TimerTask;
import sun.rmi.runtime.Log;

/**
 * Main class which starts the game.
 * @author Kamil
 */
public class Memory 
{

    /**
     * Main static functions which starts menu
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException 
    {
        new Menu();
        
    }
    
}
