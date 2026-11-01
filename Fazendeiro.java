import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entidade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fazendeiro extends Entidade
{
    public Fazendeiro() {
        // idle: 11 imagens, walk: 9 imagens, velocidade 1
        super("Fazendeiro_idle", 11, "Fazendeiro_walk", 9, 2);
        // atualizar a cada 5 passos
        passosParaAtualizarImagem = 5;
    }

    public void act() {
        tratarMovimento();
        super.act();
    }

    /**
     * Move o fazendeiro conforme as setas do teclado.
     */
    private void tratarMovimento() {
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("up")) dy -= vel;
        if (Greenfoot.isKeyDown("down")) dy += vel;
        if (Greenfoot.isKeyDown("left")) dx -= vel;
        if (Greenfoot.isKeyDown("right")) dx += vel;

        mover(dx, dy);
    }
}