/**
 * Classe da tela final do jogo, onde eh exibido se o jogador venceu ou nao.
 * Tambem sao exibidas algumas estatisticas, como pontuacao e tempo ao longo do jogo
 */
public class TelaFinal extends Tela  
{
    /**
     * Construtor da tela final, recebe se o jogador venceu ou nao
     * @param venceu se o jogador venceu ou nao o jogo
     * 
     */
    public TelaFinal(boolean venceu) {
        super("telaFinal.png");
    }
}
