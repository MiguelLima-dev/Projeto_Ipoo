import greenfoot.*;

/**
 * A chefe final do jogo Saci persegue o jogador e quando 
 * chega a uma determinada distancia, realiza uma investida em 
 * linha reta.
 */
public class Saci extends Inimigo
{
    // fazendeiro que sera perseguido
    private Fazendeiro alvo;

    // indica se o saci esta esperando para começar a atacar
    private boolean preparandoInvestida;
    // indica se ele esta realizando a investida  
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

    // distancia que o saci começa a preparar o ataque
    private static final int DISTANCIA_ATAQUE = 250;
    // tempo que ele espera antes de atacar
    private static final int DURACAO_PREPARACAO = 35;
    // duração maxima da investida
    private static final int DURACAO_INVESTIDA = 25;
    // tempo que o saci espera até atacar novamente 
    private static final int DURACAO_RECARGA = 100;
    // velocidade da investida 
    private static final int VELOCIDADE_INVESTIDA = 9;

    // o numero de vidas
    private int vidas;
    /**
     * Construtor de objetos da classe Saci
     * @param recebe da classe da fase o Actor que representa o jogador
     */
    public Saci(Fazendeiro jogador)
    {
        // idle: 10 imagens| walk: 10 imagens| velocidade: 1
        super("Saci_idle", 10, "Saci_walk", 10, 1, "laugh.wav");

        // define o jogador como alvo 
        alvo = jogador; 

        // inicializa os atributos 
        preparandoInvestida = false;
        realizandoInvestida = false;
        tempoPreparacao = 0;
        tempoInvestida = 0;
        tempoRecarga = 0;

        // inicia com 3 vidas
        vidas = 3;
    }

    public void act()
    {
        super.act();
        tratarMovimento();
        tratarDano();
    }

    /**
     * Retorna se esta vivo
     * @return true se esta vivo, false caso contrario
     */
    public boolean estaVivo() {
        return vidas > 0;
    }

    /**
     * Leva dano caso encoste em garrafas de captura ou toque em espinhos
     */
    private void tratarDano() {
        Espinhos espinhos = (Espinhos) getOneIntersectingObject(Espinhos.class);

        if (espinhos != null) {
            getWorld().removeObject(espinhos);
            vidas--;
        }

        GarrafaDeCaptura garrafa =
            (GarrafaDeCaptura) getOneIntersectingObject(GarrafaDeCaptura.class);

        if (garrafa != null) {
            getWorld().removeObject(garrafa);
            vidas--;
        }
    }

    /**
     * Trata a movimentaçao. Esse inimigo se movimenta seguindo o jogador, ao
     * se aproximar, ele para por um tempo e avança rapidamente depois da espera em uma
     * linha reta. Depois disso, ele volta a seguir o alvo e repete essa sequencia
     */
    private void tratarMovimento()
    {
        // se realizandoInvestida for verdadeiro, executamos a Investida
        if (realizandoInvestida)
        {
            executaInvestida();
            return; 
        }

        // se o saci estiver preparando para atacar, ele não deve seguir o jogador 
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

        /* se a distancia entre o saci e o fazendeiro for menor ou
         * igual a distancia minima de ataque e o tempo de recarga 
         * for igual a zero, o saci começa a preparar o ataque, se 
         * não, ele continua perseguindo o fazendeiro.
         */
        if (distancia <= DISTANCIA_ATAQUE && tempoRecarga == 0)
        {
            preparandoInvestida = true;
            // tempo de preparacao reinicia
            tempoPreparacao = DURACAO_PREPARACAO;
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
    private void iniciarInvestida()
    {
        // calculo distancia entre saci e fazendeiro 
        double dx = alvo.getX() - getX();
        double dy = alvo.getY() - getY();
        double distancia = Math.sqrt(dx * dx + dy * dy);

        // verificamos se o saci e o fazendeiro não ocupam a mesma posição
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
        tempoInvestida = DURACAO_INVESTIDA;
    }

    /** 
     * Realiza a investida em si.
     */
    private void executaInvestida()
    {
        // direção da investida x velocidade determinam deslocamento
        int dx = (int) Math.round(direcaoX * VELOCIDADE_INVESTIDA);
        int dy = (int) Math.round(direcaoY * VELOCIDADE_INVESTIDA);

        boolean moveu = mover(dx, dy);

        tempoInvestida--;

        // se o tempo acabar ou o saci não conseguir se mover, a investida termina
        if (tempoInvestida <= 0 || !moveu)
        {
            // encerra a investida
            realizandoInvestida = false;
            // reinicia o tempo para o próximo ataque
            tempoRecarga = DURACAO_RECARGA;
        }
    }

    /**
     * Aumenta o tempo que o saci fica parado até realizar a investida.
     */
    public void aumentarPreparacaoDaInvestida()
    {
        tempoPreparacao += 30;
    }
}