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
    // o actor do jogador, que a Cuca persegue
    private Fazendeiro alvo;
    // usada para controlar quando a cuca se move
    private boolean seMoveNesseAct;
    /**
     * Construtor de objetos para a classe Cuca. Recebe o jogado que ela
     * persegue como argumento
     * @param jogadorAlvo o jogador que sera perseguido
     */
    public Cuca(Fazendeiro jogadorAlvo)
    {
        // idle: 11 imagens| walk: 10 imagens| velocidade: 1
        super("Cuca_idle", 11, "Cuca_walk", 10, 1);
        alvo = jogadorAlvo;
        seMoveNesseAct = true;
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
     * a ele independente da sua distância ou posição no mapa.
     * Move-se uma vez sim, uma vez nao.
     */
    private void tratarMovimento()
    {   
        if (seMoveNesseAct) {
            moverEmDirecaoAoAlvo(alvo);
        }
        seMoveNesseAct = !seMoveNesseAct;
    }
}
