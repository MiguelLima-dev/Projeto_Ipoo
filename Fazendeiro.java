import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fazendeiro extends Actor
{
    // velocidade com que o jogador se move
    private int vel;
    
    // vetor de imagens do fazendeiro parado
    private GreenfootImage[] imagensParado;
    // vetor de imagens do fazendeiro andando
    private GreenfootImage[] imagensAndando;
    // indica se o fazendeiro esta andando
    private boolean andando;
    // guarda o indice da imagem atual do fazendeiro
    private int indiceImagemAtual;
    // indica quantos passos sao necessarios para atualizar a imagem
    private int passosParaAtualizarImagem;
    // indica quantos passos se passaram desde a ultima atualizacao da imagem
    private int passosDesdeUltimaAtualizacaoImagem;

    
    /**
     * Cria um objeto fazendeiro
     * Carrega as imagens e define a imagem inicial.
     */
    public Fazendeiro() {
        // as imagens serao atualizadas a cada 6 passos
        passosParaAtualizarImagem = 6;
        passosDesdeUltimaAtualizacaoImagem = 0;

        // carrega as imagens do fazendeiro parado
        imagensParado = carregarImagens("Fazendeiro_idle", 11);
        // carrega as imagens do fazendeiro andando
        imagensAndando = carregarImagens("Fazendeiro_walk", 9);
        // inicia com a primeira imagem
        indiceImagemAtual = 0;
        setImage(imagensParado[indiceImagemAtual]);


        // velocidade com que o fazendeiro se move
        vel = 6;
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

    public void act()
    {   
        tratarMovimento();
        tratarAtualizacaoImagem();
    }
    
    /**
     * Move o fazendeiro conforme as setas do teclado.
     */
    private void tratarMovimento() {
        // calcula o quanto ele deve ser mover, baseado na tecla pressionada
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("up")) dy -= vel;
        if (Greenfoot.isKeyDown("down")) dy += vel;
        if (Greenfoot.isKeyDown("left")) dx -= vel;
        if (Greenfoot.isKeyDown("right")) dx += vel;

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
