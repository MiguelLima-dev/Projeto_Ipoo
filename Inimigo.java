import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo extends Entidade
{
    // dano que esse inimigo causa
    private int dano;
    
    public Inimigo(String prefixoParado, int nImagensParado,
                   String prefixoAndando, int nImagensAndando, double vel,
                   int dano) {
        super(prefixoParado, nImagensParado, prefixoAndando, nImagensAndando, vel);
        this.dano = dano;
    }
    
    /**
     * Act - do whatever the Inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
}
