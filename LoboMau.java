import greenfoot.*;

/**
 * O inimigo LoboMau percorre o mapa na horizontal.
 * 
 * @author helena 
 * @version 10-11
 */
public class LoboMau extends Inimigo
{
    // guarda para qual sentido o lobo mau anda
    private boolean andandoParaDireita;

    /**
     * Construtor de objetos para a classe LoboMau.
     */
    public LoboMau() 
    {
        // idle: 11 imagens| walk: 10 imagens| velocidade: 1
        super("Lobisomem_idle", 11, "Lobisomem_walk", 10, 1);
        
        // o lobo mau comeca andando para direita
        andandoParaDireita = true;
    }

    /**
     * Act - do whatever the LoboMau wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        tratarMovimento();
    }

    /**
     * O lobo mau se move de um lado para o outro no eixo x.
     */
    private void tratarMovimento() {
        int dx;
        if (andandoParaDireita) {
            dx = obterVel();
        }
        else {
            dx = -obterVel();
        }
        // move o lobo no sentido indicado
        boolean moveu = mover(dx, 0);
        
        // verifica se o lobomau se encostou na beira do mundo,
        // se sim, muda o sentido do movimento
        if (isAtEdge() || !moveu) {
            andandoParaDireita = !andandoParaDireita;
        }
    }
}