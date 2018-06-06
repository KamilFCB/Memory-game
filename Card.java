/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.awt.Image;
import java.awt.Insets;
import javax.swing.*;

/**
 * Represents one card on the board.
 * @author Kamil
 */
public class Card implements Comparable<Card>
{
    private boolean clicked, uncovered;
    private String img;
    private JButton button;
    private ImageIcon icon;
    
    
    /**
     * Makes empty card
     */
    public Card()
    {
        clicked = false;
        uncovered = false;
        img = "";        
    }
    
    /**
     * Returns new icon
     * @param path
     * @param description
     * @return 
     */
    protected ImageIcon createImageIcon(String path, String description) 
    {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    /**
     * Return button of the card.
     * @return JButton 
     */
    public JButton getButtion()
    {
        return button;
    }
    
    /**
     * Sets an image to button.
     * @param name 
     */
    public void setImage(String name)
    {
        img = name;
        
        if(uncovered)
            icon = createImageIcon("img/" + name + ".png", "card");
        else
            icon = createImageIcon("img/karta.png", "card");
        
        Image image = icon.getImage();
        Image new_image = image.getScaledInstance(126, 179, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(new_image);
        button = new JButton(icon);
        button.setMargin(new Insets(0, 12, 0, 0));
    }
    
    /**
     * Sets button as clicked.
     */
    public void setClicked()
    {
        clicked = true;
    }
    
    /**
     * Sets button as uncovered.
     */
    public void setUncovered()
    {
        uncovered = true;
    }
    
    /**
     * Uncovers the card.
     */
    public void uncover()
    {
        icon = createImageIcon("img/" + img + ".png", "card");
        Image image = icon.getImage();
        Image new_image = image.getScaledInstance(126, 179, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(new_image);
        button.setIcon(icon);
        clicked=true;
    }
    
    /** 
     * Covers the card.
     */
    public void cover()
    {
        icon = createImageIcon("img/karta.png", "card");
        Image image = icon.getImage();
        Image new_image = image.getScaledInstance(126, 179, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(new_image);
        button.setIcon(icon);
        clicked=false;
    }
    
    /**
     * Return true if card is uncovered else false.
     * @return uncovered 
     */
    public boolean is_uncovered()
    {
        return uncovered;
    }
    
    /**
     * Return true if card is clicked else false.
     * @return 
     */
    public boolean is_clicked()
    {
        return clicked;
    }

    /**
     * Compares two cards using image which they represents. 
     * @param o
     */
    @Override
    public int compareTo(Card o) 
    {
        return img.equals(o.img) ? 1 : 0;
    }
}
