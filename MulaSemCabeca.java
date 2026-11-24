import greenfoot.*;

/**
 * A chefe final do jogo MulaSemCabeca persegue o jogador e quando 
 * chega a uma determinada distancia, realiza uma investida em 
 * linha reta.
 */
public class MulaSemCabeca extends Inimigo
{
    // fazendeiro que sera perseguido
    private Fazendeiro alvo;
    
    // indica se a mula esta esperando para começar a atacar
    private boolean preparandoInvestida;
    // indica se ela esta realizando a investida  
    private boolean realizandoInvestida;
    
    // tempo que falta para começar a investida
    private int tempoPreparacao;
    // tempo para terminar a investida
    private int tempoInvestida;
    // tempo para atacar novamente 
    private int tempoRecarga;
    
    // direcao que será realizada a investida 
    private double direcaoX;
    private double direcaoY;
    
    // distancia que a mula começa a preparar o ataque
    private static final int distanciaAtaque = 250;
    // tempo que ela espera antes de atacar
    private static final int duracaoPreparacao = 35;
    // duração maxima da investida
    private static final int duracaoInvestida = 25;
    // tempo que a mula espera até atacar novamente 
    private static final int duracaoRecarga = 100;
    // velocidade da investida 
    private static final int velocidadeInvestida = 7;
    
    /**
     * Construtor de objetos da classe MulaSemCabeca
     * @param recebe da classe da fase o Actor que representa o jogador
     */
    public MulaSemCabeca(Fazendeiro jogador)
    {
        // idle: 11 imagens| walk: 10 imagens| velocidade: 1
        super("MulaSemCabeca_idle", 11, "MulaSemCabeca_walk", 10, 1);
        
        // define o jogador como alvo 
        alvo = jogador; 
        
        // inicializa os atributos 
        preparandoInvestida = false;
        realizandoInvestida = false;
        tempoPreparacao = 0;
        tempoInvestida = 0;
        tempoRecarga = 0;
    }
    
    public void act()
    {
        super.act();
        tratarMovimento();
    }
    
    public void tratarMovimento()
    {
        // se realizandoInvestida for verdadeiro, executamos a Investida
        if (realizandoInvestida)
        {
            executaInvestida();
            return; 
        }
        
        // se a mula estiver preparando para atacar, ela não deve seguir o jogador 
        if (preparandoInvestida)
        {
            mover(0, 0);
            tempoPreparacao--;
            
            // quando o contador chega a zero iniciamos a investida
            if (tempoPreparacao <= 0)
            {
                iniciarInvestida();
            }
            return;
        }
        
        // enquanto o tempo é maior que zero, reduzimos uma unidade a cada ciclo
        if (tempoRecarga > 0)
        {
            tempoRecarga--;
        }
        
        // calculo da distancia 
        int dx = alvo.getX() - getX();
        int dy = alvo.getY() - getY();
        
        // teorema de pitagoras
        double distancia = Math.sqrt(dx*dx + dy*dy);
        
        /* se a distancia entre a mula e o fazendeiro for menor ou
         * igual a distancia minima de ataque e o tempo de recarga 
         * for igual a zero a mula começa a preparar o ataque 
         */
        if (distancia <= distanciaAtaque && tempoRecarga == 0)
        {
            preparandoInvestida = true;
            // tempo de preparacao reinicia
            tempoPreparacao = duracaoPreparacao;
            mover(0, 0);
        }
        else 
        {
            moverEmDirecaoAoAlvo(alvo);    
        }
    }
    
    /**
     * Inicia o processo da investida,calculando primeiramente 
     * a sua direção.
     */
    public void iniciarInvestida()
    {
        // calculo distancia entre mula e fazendeiro 
        double dx = alvo.getX() - getX();
        double dy = alvo.getY() - getY();
        double distancia = Math.sqrt(dx * dx + dy * dy);
        
        // verificamos se a mula e o fazendeiro não ocupam a mesma posição
        if (distancia > 0)
        {
            // normalização do vetor
            direcaoX = dx / distancia;
            direcaoY = dy / distancia;
        }
        else 
        {
            direcaoX = 0;
            direcaoY = 0;
        }
        
        preparandoInvestida = false;
        realizandoInvestida = true;
        tempoInvestida = duracaoInvestida;
    }
    
    /** 
     * Realiza a investida em si.
     */
    public void executaInvestida()
    {
        
    }
}
