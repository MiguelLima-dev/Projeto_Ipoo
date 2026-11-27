import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe entidade, guarda as informacoes comuns a todos os personagens animados
 * do jogo.
 */
public class Entidade extends Actor
{
    // velocidade com que essa entidade se move
    private int vel;
    // animacao da entidade parada
    private Animacao animacaoParado;
    // animacao da entidade andando
    private Animacao animacaoAndando;
    // animacao atual
    private Animacao animacaoAtual;

    /**
     * Construtor de uma entidade, recebe o prefixo das imagens da entidade
     * parada e andando, tambem o numero de imagens de cada tipo de imagem,
     * recebe tambem a velocidade com que a entidade se move
     *
     * @param prefixoParado Prefixo das imagens da entidade parada
     * @param nImagensParado Numero de imagens da entidade parada
     * @param prefixoAndando Prefixo das imagens da entidade andando
     * @param nImagensAndando Numero de imagens da entidade andando
     * @param vel Velocidade com que a entidade se move
     */
    protected Entidade(String prefixoParado, int nImagensParado,
    String prefixoAndando, int nImagensAndando, int vel) {
        // carrega as animacoes
        animacaoParado = new Animacao(prefixoParado, nImagensParado);
        animacaoAndando = new Animacao(prefixoAndando, nImagensAndando);
        animacaoAtual = animacaoParado;
        setImage(animacaoAtual.reiniciar());

        // a velocidade com que a entidade se move
        this.vel = vel;
    }

    /**
     * Trata a animacao da entidade a cada frame
     */
    public void act()
    {
        GreenfootImage novaImagem = animacaoAtual.avancar();
        if (novaImagem != null) {
            setImage(novaImagem);
        }
    }

    /**
     * Retorna a velocidade da entidade
     * @return a velocidade da entidade
     */
    protected int obterVel() {
        return vel;
    }

    /**
     * Move a entidade (dx, dy), parando ao colidir com obstaculos.
     * Cada eixo eh testado separadamente, entao a entidade desliza
     * pela parede ao invez de grudar nela. Tambem atualiza o estado
     * "andando", trocando entre as animacoes de parado e andando.
     * Retorna se a entidade se moveu
     * @param dx O quanto a entidade se move no eixo x
     * @param dy O quanto a entidade se move no eixo y
     * @return true se a entidade se moveu, false caso contrario
     */
    protected boolean mover(int dx, int dy) {
        int xInicial = getX(), yInicial =  getY();

        definirAnimacao(dx != 0 || dy != 0);
        moverNumEixo(dx, 0);
        moverNumEixo(0, dy);
        
            // retorna se a posicao mudou
        return getX() != xInicial || getY() != yInicial;
    }

    /**
     * Tenta mover o actor,desfaz o movimento caso
     * encontre um obstaculo
     */
    private void moverNumEixo(int dx, int dy) {
        int x = getX(), y = getY();
        setLocation(x + dx, y + dy);
        if (isTouching(Obstaculo.class)) {
            setLocation(x, y);
        }
    }
    /**
     * Define qual animacao sera usada no momento
     */
    private void definirAnimacao(boolean andando) {
        Animacao nova;
        if (andando) {
            nova = animacaoAndando;
        }
        else {
            nova = animacaoParado;
        }
        if (nova != animacaoAtual) {
            animacaoAtual = nova;
            setImage(nova.reiniciar());
        }
    }

    /**
     * Tenta pegar o fruto que a entidade está tocando.
     * @return true se foi possível pegar o fruto, false caso contrário.
     */
    protected boolean tentarPegarFruto()
    {
        if(isTouching(Fruto.class))
        {
            Fruto fruto = (Fruto) getOneIntersectingObject(Fruto.class);
            return fruto.coletar();
        }
        return false;
    }
    
    /**
     * Tenta pegar o fruto que o Fazendeiro esta tocando.
     * @return true se foi possível pegar o cristal, false caso contrário.
     */
    public boolean tentarPegarCristal()
    {
        if (isTouching(Cristal.class))
        {
            Cristal cristal = (Cristal) getOneIntersectingObject(Cristal.class);
            return cristal.coletar();
        }
        return false;
    }
}