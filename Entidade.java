import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entidade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entidade extends Actor
{
    // velocidade com que essa entidade se move
    protected int vel;
    
    // vetor de imagens da entidade parada
    private GreenfootImage[] imagensParado;
    // vetor de imagens da entidade andando
    private GreenfootImage[] imagensAndando;
    // indica se a entidade esta andando
    private boolean andando;
    // guarda o indice da imagem atual do fazendeiro
    private int indiceImagemAtual;
    // indica quantos passos sao necessarios para atualizar a imagem
    protected int passosParaAtualizarImagem;
    // indica quantos passos se passaram desde a ultima atualizacao da imagem
    private int passosDesdeUltimaAtualizacaoImagem;

/**
 * @param prefixoParado Prefixo das imagens da entidade parada
 * @param prefixoAndando Prefixo das imagens da entidade andando
 * @param nImagensParado Numero de imagens da entidade parada
 * @param nImagensAndando Numero de imagens da entidade andando
 * @param vel Velocidade com que a entidade se move
 */
    public Entidade(String prefixoParado, int nImagensParado,
                    String prefixoAndando, int nImagensAndando, int vel) {
        // a imagem sera atualizada a cada 6 passos
        passosParaAtualizarImagem = 6;
        passosDesdeUltimaAtualizacaoImagem = 0;

        // carrega as imagens da entidade parada
        imagensParado = carregarImagens(prefixoParado, nImagensParado);
        // carrega as imagens da entidade parada
        imagensAndando = carregarImagens(prefixoAndando, nImagensAndando);
        // inicia com a primeira imagem da entidade parada
        indiceImagemAtual = 0;
        setImage(imagensParado[indiceImagemAtual]);
        andando = false;

        // a velocidade com que a entidade se move
        this.vel = vel;
    }
    /**
     * Act - do whatever the Entidade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        tratarAtualizacaoImagem();
    }
    
    /**
     * Carrega um conjunto de imagens no formato: prefixo (1).png, prefixo (2).png, ...
     */
    private GreenfootImage[] carregarImagens(String prefixo, int numeroDeImagens) {
        GreenfootImage[] imagens = new GreenfootImage[numeroDeImagens];
        for (int i = 0; i < imagens.length; i++) {
            imagens[i] = new GreenfootImage(prefixo + " (" + (i+1) + ").png");
        }
        return imagens;
    }

    /**
     * Exibe a proxima imagem do vetor
     */
    private void tratarAtualizacaoImagem() {
        passosDesdeUltimaAtualizacaoImagem++;

        if (passosDesdeUltimaAtualizacaoImagem >= passosParaAtualizarImagem) {
            passosDesdeUltimaAtualizacaoImagem = 0;

            GreenfootImage[] imagens;
            if (andando) imagens = imagensAndando;
            else imagens = imagensParado;

            indiceImagemAtual++;
            if (indiceImagemAtual >= imagens.length) {
                indiceImagemAtual = 0;
            }
            setImage(imagens[indiceImagemAtual]);
        }
    }

    /**
     * Move a entidade (dx, dy), parando ao colidir com obstaculos.
     * Cada eixo eh testado separadamente, entao a entidade desliza
     * pela parade ao invez de grudar nela. Tambem atuliza o estado
     * "andando", trocando entre as animacoes de parede e andando.
     * @param dx O quanto a entidade se move no eixo x
     * @param dy O quanto a entidade se move no eixo y
     */
    protected void mover(int dx, int dy) {
        boolean estavaAndando = andando;
        andando = (dx != 0 || dy != 0);

        // deixou ou comecou a andar, reinicia a animacao
        if (andando != estavaAndando) {
            indiceImagemAtual = 0;
            passosDesdeUltimaAtualizacaoImagem = 0;
            if (andando) setImage(imagensAndando[0]);
            else setImage(imagensParado[0]);
        }

        // tenta mover no eixo x
        int xAnterior = getX();
        setLocation(getX() + dx, getY());
        if (isTouching(Obstaculo.class)) setLocation(xAnterior, getY());

        // tenta mover no eixo y
        int yAnterior = getY();
        setLocation(getX(), getY() + dy);
        if (isTouching(Obstaculo.class)) setLocation(getX(), yAnterior);
    }
}
