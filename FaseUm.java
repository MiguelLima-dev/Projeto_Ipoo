import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FaseUm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaseUm extends Fase
{

    /**
     * Constructor for objects of class FaseUm.
     * 
     */
    public FaseUm()
    {
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Fazendeiro fazendeiro = new Fazendeiro();
        addObject(fazendeiro,163,373);
    }
}
