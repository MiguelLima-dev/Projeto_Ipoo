import greenfoot.*;

/**
 * A chefe final do jogo MulaSemCabeca persegue o jogador e quando 
 * chega a uma determinada distancia, realiza uma investida.
 */
public class MulaSemCabeca extends Inimigo
{
    // fazendeiro que sera perseguido
    private Fazendeiro alvo;
    
    //  indica se a mula esta preparando o ataque ou realizando o ataque 
    private boolean preparandoAtaque;
    private boolean atacando;
    
    // contadores de tempo
    private int tempoPreparacao;
    private int tempoAtaque;
    private int tempoRecarga;
    
    // direcao do ataque 
    private double direcaoX;
    private double direcaoY;
    
    /**
     * Constructor for objects of class MulaSemCabeca
     */
    public MulaSemCabeca()
    {
        // idle: 11 imagens| walk: 10 imagens| velocidade: 1
        super("MulaSemCabeca_idle", 11, "MulaSemCabeca_walk", 10, 1);
    }
    
    public void act()
    {
        
    }
    
    public void tratarMovimento()
    {
        
    }
}
