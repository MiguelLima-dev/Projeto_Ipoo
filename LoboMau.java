import greenfoot.*;

/**
 * O inimigo LoboMau percorre o mapa na horizontal,
 * se movendo de um lado para o outro.
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
        super("Lobisomem_idle", 11, "Lobisomem_walk", 10, 1, "lobo_mau_uivando.wav");
        
        // o lobo mau comeca andando para direita
        andandoParaDireita = true;
    }

    /**
     * Faz o lobo agir, se movimentando de um lado para o outro no eixo y
     */
    @Override
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