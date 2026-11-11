import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclasse dos inimigos do jogo
 */
public class Inimigo extends Entidade
{
    
    /**
     * Cria um inimigo, partindo do construtor de entidade
     */
    protected Inimigo(String prefixoParado, int nImagensParado,
    String prefixoAndando, int nImagensAndando, int vel) {
        super(prefixoParado, nImagensParado, prefixoAndando, nImagensAndando, vel);
    }

    /**
     * age como uma entidade
     */
    public void act()
    {
        super.act();
    }

    /**
     * Move o inimigo em direcao a um alvo (um actor)
     * @param alvo o actor alvo
     */
    protected void moverEmDirecaoAoAlvo(Actor alvo) {
        int dx = 0; // posicao horizontal
        int dy = 0; // posicao vertical

        // se o fruto estiver a direita, dx recebe velocidade positiva
        // se estiver a esquerda, recebe velocidade negativa 
        if (alvo.getX() > getX()) {    
            dx = obterVel();
        } else if (alvo.getX() < getX()) {   
            dx = -obterVel();
        }

        // se o fruto estiver em cima, dy recebe velocidade positiva
        // se estiver em baixo, velocidade negativa
        if (alvo.getY() > getY()) {
            dy = obterVel();
        } else if (alvo.getY() < getY()) {
            dy = -obterVel();
        }

        mover(dx, dy);
    }
}
