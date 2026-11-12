import greenfoot.*;
/**
 * Actor da saida por onde o jogador escapa
 */
public class Saida extends Actor
{
    /**
     * Constroi a saida com a imagem de um portal
     */
    public Saida()
    {
        GreenfootImage portal = new GreenfootImage("portal.png");
        portal.scale(100,150);
        setImage(portal);
    }
}
