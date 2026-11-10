import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * O inimigo BichoPapao pega os itens que aparecem no mapa.
 *
 * @author helena
 * @version 10-11
 */
public class BichoPapao extends Inimigo
{   
    // guarda para qual sentido o bicho papao anda
    private boolean andandoParaDireita;

    public BichoPapao() {
        // idle: 11 imagens| walk: 10 imagens| velocidade: 1| dano: 2
        super("BichoPapao_idle", 11, "BichoPapao_walk", 10, 1, 2);

        // o bicho papao comeca andando para direita
        andandoParaDireita = true;
    }

    /**
     * Act - do whatever the BichoPapao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        tratarMovimento();
    }

    /**
     * O bicho papao se move de um lado para o outro no eixo x
     */
    private void tratarMovimento() {
        // verifica se o bichopapao se encostou na beira do mundo,
        // se sim, muda o sentido do movimento
        if (isAtEdge()) {
    
            andandoParaDireita = !andandoParaDireita;
        }
        
        // move o bichopapao conforme o sentido do movimento
        if (andandoParaDireita) {
            mover(obterVel(), 0);
        }
        else { 
            mover(-obterVel(), 0);
        }
    }
}
