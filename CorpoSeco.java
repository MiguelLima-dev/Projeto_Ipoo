import greenfoot.*;

/**
 * O inimigo CorpoSeco ...
 */
public class CorpoSeco extends Inimigo 
{
    
    /**
     * Construtor de objetos da classe CorpoSeco
     */
    public CorpoSeco()
    {
        // idle: 11 imagens| walk: 10 imagens| velocidade: 1
        super("CorpoSeco_idle", 11, "CorpoSeco_walk", 10, 1);
    }
    
    public void act()
    {
        tratarMovimento();        
    }
    
    public void tratarMovimento()
    {
        
    }
}
