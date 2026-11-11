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
    }

    /**
     * O método busca onde estão os frutos no mapa e faz o BichoPapao
     * coleta-los.
     */
    private void tratarMovimento() {
        // busca todos os objetos da classe 'Fruto' no mapa
        java.util.List frutos = getWorld().getObjects(Fruto.class);
        
        // se houver pelo menos um fruto o bicho papao vai até suas coordenadas
        if(!frutos.isEmpty())
        {
            Fruto itemAlvo = (Fruto) frutos.get(0);
            turnTowards(itemAlvo.getX(), itemAlvo.getY());
            move(1);
        }
        
        if(isTouching(Fruto.class))
        {
            
        }
    }
}