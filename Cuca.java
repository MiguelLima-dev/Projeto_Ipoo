import greenfoot.*;
import greenfoot.Actor;

/**
 * O inimigo Cuca segue o inimigo no mapa.
 * 
 * @author helena
 * @version 10-11
 */
public class Cuca extends Inimigo
{
    /**
     * Construtor de objetos para a classe Cuca.
     */
    public Cuca()
    {
        // idle: 11 imagens| walk: 10 imagens| velocidade: 1
        super("Cuca_idle", 11, "Cuca_walk", 10, 1);
    }

    /**
     * Act - do whatever the Cuca wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        tratarMovimento();
    }
    
    /**
     * O método busca o fazendeiro e faz com que a Cuca se movimente em direção
     * a ele idependente da sua distância ou posição no mapa.
     */
    private void tratarMovimento()
    {
        // busca todos os objetos da classe Fazendeiro existentes no mundo
        java.util.List alvos = getWorld().getObjects(Fazendeiro.class);
    
        if (!alvos.isEmpty()) 
        {
            Actor alvo = (Actor) alvos.get(0); // armazena em 'alvo' o primeiro (0) jogador a ser encontrado no mapa 
            turnTowards(alvo.getX(), alvo.getY()); 
            move(1); // velocidade 
        }
    }
}
