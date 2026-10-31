import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tela extends World
{

    /**
     * Constructor for objects of class Tela.
     * 
     */
    public Tela(String caminhoImagem)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground(new GreenfootImage(caminhoImagem));
    }
}
