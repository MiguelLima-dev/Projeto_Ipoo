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
        // idle: 11 imagens| walk: 9 imagens| velocidade 1
        super("Fazendeiro_idle", 11, "Fazendeiro_walk", 9, 2);
        // inicia com 0 pontos
        pontuacao = 0;
    }

    public void act() {
        // trata o movimento do fazendeiro
        tratarMovimento();
        // trata a animacao idle do fazendeiro
        super.act();
        
        tentarPegarFruto();
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
     * Tenta coletar um fruto que o fazendeiro toca, caso
     * o fruto for coletado, incrementa a pontuacao.
     */
    private void tentarPegarFruto() {
        if (isTouching(Fruto.class)) {
            Fruto fruto = (Fruto) getOneIntersectingObject(Fruto.class);
            if (fruto.coletar()) {
                pontuacao += 1;
            }
        }
    }
    
    /**
     * Retorna a pontuacao do fazendeiro
     * @return a pontuacao do fazendeiro
     */
    public int obterPontuacao() {
        return pontuacao;
    }
    
    public  boolean encostouNoInimigo(){
        return isTouching(BichoPapao.class);
    }
    
    public boolean chegouNaSaida(){
        return isTouching(Saida.class);
    }
}