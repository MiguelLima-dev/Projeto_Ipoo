/**
 * Classe da tela final do jogo, onde eh exibido se o jogador venceu ou nao.
 * Tambem sao exibidas as estatisticas de pontuacao e tempo ao longo do jogo.
 * Tambm da a opçao de reiniciar o jogo apertando espaço
 */
public class TelaFinal extends Tela  
{
    private static final int MEIO_TELA = 600;
    /**
     * Construtor da tela final, recebe se o jogador venceu ou nao e a
     * partida com as estatisticas a serem exibidas
     * @param venceu se o jogador venceu ou nao o jogo
     * @param partida a partida com as estatisticas
     */
    public TelaFinal(boolean venceu, Partida partida) {
        super("telaFinal.png");
        exibirVitoriaOuDerrota(venceu);
        exibirResultados(partida);
        adicionarInstrucao();
    }
    
    /**
     * Adiciona o texto com a instrucao de como jogar outra partida
     */
    private void adicionarInstrucao() {
        addObject(new Texto("Aperte Espaço para jogar novamente", 30), MEIO_TELA, 625);
    }
    
    /**
     * Exibe o texto com vitoria ou derrota
     * @param vitoria se o texto exibido eh vitoria ou nao
     */
    private void exibirVitoriaOuDerrota(boolean vitoria) {
        if (vitoria) {
            addObject(new Texto("Vitoria", 100), MEIO_TELA, 90);
        }
        else {
            addObject(new Texto("Derrota", 100), MEIO_TELA, 90);
        }
    }
    
    /**
     * Exibe as estatisticas de pontuaçao e minutos de jogo ao longo da partida
     * @param partida a partida a ser analisada
     */
    private void exibirResultados(Partida partida) {
        addObject(new Texto("Resultados dessa aventura: ", 75), MEIO_TELA, 175);
        int numeroFases = partida.obterNumeroDeFases();
        int distanciaY = 245;
        for (int i = 1; i <= numeroFases; i++) {
            addObject(new Texto("Fase " + i + ": " + partida.obterPontuacaoFase(i) + " pontos - " +
            partida.obterTempoFase(i) + " minutos"), MEIO_TELA, distanciaY);
            distanciaY += 55;
        }
        
        distanciaY += 55;
        
        addObject(new Texto("Pontuaçao total: " + partida.obterPontuacaoTotal() + " pontos"), 
                    MEIO_TELA, distanciaY);
        distanciaY += 55;
        addObject(new Texto("Tempo total: " + partida.obterTempoTotal() + " minutos"), 
                    MEIO_TELA, distanciaY);
    
    }
}
