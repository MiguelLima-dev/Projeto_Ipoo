import greenfoot.*;

/**
 * O inimigo LoboMau percorre o mapa na horizontal.
 * 
 * @author helena 
 * @version 10-11
 */
public class LoboMau extends Inimigo
{
    // guarda para qual sentido o bicho papao anda
    private boolean andandoParaDireita;

    public LoboMau() 
    {
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