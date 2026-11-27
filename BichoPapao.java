import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * O inimigo BichoPapao pega os itens que aparecem no mapa.
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
        super("BichoPapao_idle", 11, "BichoPapao_walk", 10, 1, "bicho_papando.wav");
    }

    /**
     * Faz o bichoPapao agir, tentando pegar os frutos
     */
    @Override
    public void act()
    {
        super.act();
        tratarMovimento();
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
            moverEmDirecaoAoAlvo(frutoAlvo);
        }
        // se ele conseguir pegar o fruto, a variavel alvo fica nula para ele procurar outro fruto.
        if (tentarPegarFruto())
        {
            frutoAlvo = null;
            tocarSom();
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
                return; 
            }
        }
    }
    

}