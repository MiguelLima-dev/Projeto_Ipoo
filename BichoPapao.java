import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * O inimigo BichoPapao pega os itens que aparecem no mapa.
 *
 * @author helena
 * @version 11-11
 */
public class BichoPapao extends Inimigo
{  
    // fruto que o bicho papao vai roubar 
    private Fruto frutoAlvo;
    
    /**
     * Construtor de objetos para a classe BichoPapao.
     */
    public BichoPapao() {

        // idle: 11 imagens| walk: 10 imagens| velocidade: 1
        super("BichoPapao_idle", 11, "BichoPapao_walk", 10, 1);
    }

    /**
     * Act - do whatever the BichoPapao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        tratarMovimento();
        tentarPegarFruto();
    }

    private void tratarMovimento()
    {
        // se não houver alvo ou o alvo não for coletavel ele busca um novo alvo.
        if (frutoAlvo == null || !frutoAlvo.frutoEstaColetavel())
        {
            buscarFruto();
        }
        // se houver um fruto alvo o bicho papao vai até ele.
        if (frutoAlvo != null)
        {
            perseguirFruto();
        }
        // se ele conseguir pegar o fruto, a variavel alvo fica nula para ele procurar outro fruto.
        if (tentarPegarFruto())
        {
            frutoAlvo = null;
        }
    }
    
    /**
     * O método busca um fruto para ser perseguido no mapa.
     */
    private void buscarFruto() {
        frutoAlvo = null;
        for (Fruto fruto : getWorld().getObjects(Fruto.class))
        {   
            // se o objeto fruto que ele encontrou for coletavel, ele será armazenado na variavel alvo.
            if (fruto.frutoEstaColetavel())
            {
                frutoAlvo = fruto;
                break; 
            }
        }
    }
    
    private void perseguirFruto()
    {
        int dx = 0; // posicao horizontal
        int dy = 0; // posicao vertical

        // se o fruto estiver a direita, dx recebe velocidade positiva
        // se estiver a esquerda, recebe velocidade negativa 
        if (frutoAlvo.getX() > getX()) {    
            dx = obterVel();
        } else if (frutoAlvo.getX() < getX()) {   
            dx = -obterVel();
        }
        
        // se o fruto estiver em cima, dy recebe velocidade positiva
        // se estiver em baixo, velocidade negativa
        if (frutoAlvo.getY() > getY()) {
            dy = obterVel();
        } else if (frutoAlvo.getY() < getY()) {
            dy = -obterVel();
        }
    
        mover(dx, dy);
    }
}