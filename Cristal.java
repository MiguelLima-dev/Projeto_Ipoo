import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Cristais coletaveis pelo jogador, utilizado para causar dano ao inimigo.
 * 
 * 
 */
public class Cristal extends Actor
{

    public Cristal (){
        setImage("Cristal.png");
    }

    /**Tenta coletar o cristal do mundo, so funciona quando ele eh coletavel
     * @return true se o cristal foi coletado, false caso contrario
     */
    public void coletar(){
        getWorld().removeObject(this);
    }
}
