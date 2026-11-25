/**
 * Classe da tela final do jogo, onde eh exibido se o jogador venceu ou nao.
 * Tambem sao exibidas algumas estatisticas, como pontuacao e tempo ao longo do jogo
 */
public class TelaFinal extends Tela  
{
    private Partida partida;
    /**
     * Construtor da tela final, recebe se o jogador venceu ou nao
     * @param venceu se o jogador venceu ou nao o jogo
     * 
     */
    public TelaFinal(boolean venceu, Partida partida) {
        super("telaFinal.png");
        this.partida = partida;
    }
    
    private void exibirResultados() {
        int i = 1;
        while (partida.obterPontuacaoFase(i) != -1) {
            addObject(new Texto
        }
    }
}
