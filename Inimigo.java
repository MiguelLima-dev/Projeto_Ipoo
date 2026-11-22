import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclasse dos inimigos do jogo
 */
public class Inimigo extends Entidade
{
    // arquivo do som que o inimigo faz ao pegar o jogador
    private String arquivoSom;

    /**
     * Cria um inimigo, partindo do construtor de entidade
     */
    protected Inimigo(String prefixoParado, int nImagensParado,
    String prefixoAndando, int nImagensAndando, int vel, String arquivoSom) {
        super(prefixoParado, nImagensParado, prefixoAndando, nImagensAndando, vel);
        this.arquivoSom = arquivoSom;
    }

    /**
     * age como uma entidade
     */
    public void act()
    {
        super.act();
        tocarSomCaptura();
    }

    /**
     * Move o inimigo em direcao a um alvo (um actor)
     * @param alvo o actor alvo
     */
    protected void moverEmDirecaoAoAlvo(Actor alvo) {
        int dx = 0; // posicao horizontal
        int dy = 0; // posicao vertical

        // se o alvo estiver a direita, dx recebe velocidade positiva
        // se estiver a esquerda, recebe velocidade negativa 
        if (alvo.getX() > getX()) {    
            dx = obterVel();
        } else if (alvo.getX() < getX()) {   
            dx = -obterVel();
        }

        // se o alvo estiver em cima, dy recebe velocidade positiva
        // se estiver em baixo, velocidade negativa
        if (alvo.getY() > getY()) {
            dy = obterVel();
        } else if (alvo.getY() < getY()) {
            dy = -obterVel();
        }

        mover(dx, dy);
    }

    /**
     * Toca o som do inimigo ao pegar o jogador
     */
    private void tocarSomCaptura() {
        if (isTouching(Fazendeiro.class)) {
            if (arquivoSom != null) {
                Greenfoot.playSound(arquivoSom);
            }
        }
    }
}
