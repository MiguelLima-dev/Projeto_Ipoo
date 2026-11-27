import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Cristais coletaveis pelo jogador, utilizado para causar dano ao inimigo.
 * 
 * 
 */
public class Cristal extends Actor
{
    private boolean coletavel;
    
    public Cristal (){
        coletavel = true;
        
        GreenfootImage imagem = getImage();
        if (imagem != null) {
            // Ajuste estes valores conforme o tamanho desejado no mapa
            imagem.scale(45, 55);
            setImage(imagem);
        }
    }
    
    /**Tenta coletar o cristal do mundo, so funciona quando ele eh coletavel
     * @return true se o cristal foi coletado, false caso contrario
     */
    public boolean coletar(){
        if (coletavel) {
            coletavel = false;
            getWorld().removeObject(this);
            return true;
        }
        // o cristal ainda nao eh coletavel
        return false;
    }
}
