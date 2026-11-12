import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe entidade, guarda as informacoes comuns a todos os personagens animados
 * do jogo.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entidade extends Actor
{
    // velocidade com que essa entidade se move
    private int vel;
    // vetor de imagens da entidade parada
    private GreenfootImage[] imagensParado;
    // vetor de imagens da entidade andando
    private GreenfootImage[] imagensAndando;
    // indica se a entidade esta andando
    private boolean andando;
    // guarda o indice da imagem atual do fazendeiro
    private int indiceImagemAtual;
    // indica quantos passos sao necessarios para atualizar a imagem
    private static final int passosParaAtualizarImagem = 8;
    // indica quantos passos se passaram desde a ultima atualizacao da imagem
    private int passosDesdeUltimaAtualizacaoImagem;

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
        // há quantos passos a imagem foi atualizada
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
     * Trata a animacao da entidade a cada frame
     */
    public void act()
    {
        tratarAtualizacaoImagem();
    }

    /**
     * Retorna a velocidade da entidade
     * @return a velocidade da entidade
     */
    protected int obterVel() {
        return vel;
    }

    /**
     * Carrega um conjunto de imagens no formato: prefixo (1).png, prefixo (2).png, ...
     * @param prefixo prefixo da imagem a ser carregada
     * @param numeroDeImagens numero de imagens a serem carregadas
     * @return As imagens com o prefixo encontradas
     */
    public static GreenfootImage[] carregarImagens(String prefixo, int numeroDeImagens) {
        GreenfootImage[] imagens = new GreenfootImage[numeroDeImagens];
        for (int i = 0; i < imagens.length; i++) {
            imagens[i] = new GreenfootImage(prefixo + " (" + (i+1) + ").png");
        }
        return imagens;
    }

    /**
     * Trata a atualizacao das imagens da entidade, levando em consideracao se
     * a entidade esta parada ou andando
     */
    private void tratarAtualizacaoImagem() {
        passosDesdeUltimaAtualizacaoImagem++;

        if (passosDesdeUltimaAtualizacaoImagem >= passosParaAtualizarImagem) {
            passosDesdeUltimaAtualizacaoImagem = 0;

            // decide qual vetor sera usado, com base no estado da entidade
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
     * pela parade ao invez de grudar nela. Tambem atuliaza o estado
     * "andando", trocando entre as animacoes de parede e andando.
     * Retorna se a entidade se moveu
     * @param dx O quanto a entidade se move no eixo x
     * @param dy O quanto a entidade se move no eixo y
     * @return true se a entidade se moveu, false caso contrario
     */
    protected boolean mover(int dx, int dy) {
        int xInicial = getX(), yInicial =  getY();
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
        
        // retorna se a posicao mudou
        return getX() != xInicial || getY() != yInicial;
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
}
