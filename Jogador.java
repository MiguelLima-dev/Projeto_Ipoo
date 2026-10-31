import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogador extends Actor
{
    // velocidade com que o jogador se move
    private int vel;
    
    public void act()
    {   
        vel = 2;
        mover();
    }
    
    private void mover() {
        int x = getX(), y = getY();
        if (Greenfoot.isKeyDown("up"))
            setLocation(x, y-vel);
        if (Greenfoot.isKeyDown("down"))
            setLocation(x, y+vel);
        if (Greenfoot.isKeyDown("left"))
            setLocation(x - vel, y);
        if (Greenfoot.isKeyDown("right"))
            setLocation(x + vel, y);
            
        if (isTouching(Obstaculo.class))
            setLocation(x, y);
    }
}
