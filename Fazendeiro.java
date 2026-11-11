import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entidade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fazendeiro extends Entidade
{
    // quantos pontos o fazendeiro tem, a contagem de frutos coletados
    private int pontuacao;
    
    public Fazendeiro() {
        // idle: 11 imagens| walk: 9 imagens| velocidade 2
        super("Fazendeiro_idle", 11, "Fazendeiro_walk", 10, 2);
        // inicia com 0 pontos
        pontuacao = 0;
    }

    public void act() {
        // trata o movimento do fazendeiro
        tratarMovimento();
        // trata a animacao idle do fazendeiro
        super.act();
        // tenta pegar o fruto e adiciona na pontuação se for possível
        if(tentarPegarFruto())
        {
            pontuacao += 1;
        }
    }

    /**
     * Move o fazendeiro conforme as setas do teclado.
     */
    private void tratarMovimento() {
        int dx = 0, dy = 0, vel = obterVel();
        if (Greenfoot.isKeyDown("up")) dy -= vel;
        if (Greenfoot.isKeyDown("down")) dy += vel;
        if (Greenfoot.isKeyDown("left")) dx -= vel;
        if (Greenfoot.isKeyDown("right")) dx += vel;

        mover(dx, dy);
    }
    
    /**
     * Retorna a pontuacao do fazendeiro
     * @return a pontuacao do fazendeiro
     */
    public int obterPontuacao() {
        return pontuacao;
    }
    
    /**
     * Verifica se o jogador e o inimigo se tocaram
     * @return true se encostar no inimigo, false se não encostar
     */
    public  boolean encostouNoInimigo(){
        return isTouching(Inimigo.class);
    }
    
    /**
     * Verifica se o jogador chegou até a saída
     * @return true se o jogador chegou na saida, false se não chegou
     */
    public boolean chegouNaSaida(){
        return isTouching(Saida.class);
    }
}