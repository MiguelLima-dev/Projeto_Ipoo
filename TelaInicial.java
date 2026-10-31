import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaInicial extends Tela
{

    /**
     * Constructor for objects of class TelaInicial.
     * 
     */
    public TelaInicial()
    {  
        // cria um mundo.
        super("telaInicial.png");
        
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new TelaInstrucoes());
        }
        else if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new FaseUm());
        }
    }
}
