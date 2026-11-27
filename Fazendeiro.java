import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A classe fazendeiro representa o jogador
 */
public class Fazendeiro extends Entidade
{
    // quantos pontos o fazendeiro tem, a contagem de frutos coletados
    private int pontuacao;
    //quantidade de cristais coletados pelo faazendeiro
    private int cristais;
    
    public Fazendeiro() {
        // idle: 11 imagens| walk: 10 imagens| velocidade 2
        super("Fazendeiro_idle", 11, "Fazendeiro_walk", 10, 2);
        // inicia com 0 pontos
        pontuacao = 0;
    }

    public void act() {
        // trata o movimento do fazendeiro
        tratarMovimento();
        // trata a animacao idle do fazendeiro
        super.act();
        // trata a coleta do fruto
        tratarColetaFruto();
        // trata a coleta dos cristais
        tratarColetaCristal();
        tratarUsoCristal();

    }
    
    /**
     * Trata a coleta do fruto, caso
     * um fruto seja coletado, incrementa a
     * pontuacao.
    */
    private void tratarColetaFruto() {
        if (tentarPegarFruto()) {
            pontuacao += 1;
            Greenfoot.playSound("fazendeiro_coletando_fruto.wav");
        }
    }
    
    private void tratarColetaCristal(){
        if(tentarPegarCristal()){
            cristais += 1;
            Greenfoot.playSound("fazendeiro_coletando_fruto.wav");
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
    
    public int obterCristais(){
        return cristais;
    }
    
    private void tratarUsoCristal(){
        if(cristais > 0 && "space".equals(Greenfoot.getKey()) && getWorld() != null){
            cristais -= 1;
            for(Saci saci: getWorld().getObjects(Saci.class)){
                saci.aplicarLentidao(600);
            }
        }
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