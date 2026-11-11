import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * O inimigo BichoPapao pega os itens que aparecem no mapa.
 *
 * @author helena
 * @version 10-11
 */
public class BichoPapao extends Inimigo
{   
    /**
     * Construtor de objetos para a classe BichoPapao.
     */
    public BichoPapao() {
        // idle: 11 imagens| walk: 10 imagens| velocidade: 1| dano: 2
        super("BichoPapao_idle", 11, "BichoPapao_walk", 10, 1, 2);
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

    /**
     * O método busca onde estão os frutos no mapa e faz o BichoPapao
     * ir até eles.
     */
    private void tratarMovimento() {
        for (Fruto fruto : getWorld().getObjects(Fruto.class))
        {
            
        }
    }
}