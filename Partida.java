import java.util.ArrayList;

/**
 * Guarda as infomaçoes de uma partida, a pontuacao,
 * tempo de jogo
 */
public class Partida {
    // guardam as posicoes de cada informacao no vetor dentro do arraylist
    private static final int POS_PONTUACAO = 0;
    private static final int POS_TEMPO = 1;
    // o numero de informaçoes que cada fase possui
    private static final int CAMPOS_POR_FASE = 2;
    // guarda as pontuacoes e tempos de cada fase
    private ArrayList<int[]> dadosFases; 
    
    /**
     * Construtor de um objeto partida, inicia
     * o ArrayList de dados
     */
    public Partida() {
        dadosFases = new ArrayList<>();
    }

    /**
     * Adiciona os dados de uma fase
     * @param pontuacao pontuacao de uma fase
     * @param tempoPassado tempo gasto em uma fase
     */
    public void adicionarDados(int pontuacao, int tempoPassado) {
        int[] dados = new int[CAMPOS_POR_FASE];
        dados[POS_PONTUACAO] = pontuacao;
        dados[POS_TEMPO] = tempoPassado;
        dadosFases.add(dados);
    }

    /**
     * Retorna o numero de fases da partida
     * @return o numero de fases da partida
     */
    public int obterNumeroDeFases() {
        return dadosFases.size();
    }

    /**
     * Retorna a pontuacao de uma fase de dado indice
     * @param indice indice da fase a ser acessada
     * @return a pontuacao da fase em dado indice, -1 caso o indice seja invalido
     */
    public int obterPontuacaoFase(int indice) {
        return obterCampoFase(indice, POS_PONTUACAO);
    }

    /**
     * Retorna o tempo de uma fase de dado indice
     * @param indice indice da fase a ser acessada
     * @return o tempo da fase em dado indice, -1 caso o indice seja invalido
     */
    public int obterTempoFase(int indice) {
        return obterCampoFase(indice, POS_TEMPO);
    }
    
    /**
     * Retorna a pontuacao total obtida na partida
     * @return a pontuacao total obtida na partida
     */
    public int obterPontuacaoTotal() {
        return obterTotalCampo(POS_PONTUACAO);
    }
    
    /**
     * Retorna o tempo do jogo total gasto na partida
     * @return o tempo do jogo total gasto na partida
     */
    public int obterTempoTotal() {
        return obterTotalCampo(POS_TEMPO);
    }
    
    /**
     * Retorna a informacao de dado campo de dado indice
     */
    private int obterCampoFase(int indice, int campo) {
        // cada fase ocupa a posicao NumeroDaFase -1 no vetor
        int posicao = indice - 1;
        if (posicao >= 0 && posicao < dadosFases.size()) {
            return dadosFases.get(posicao)[campo];
        }
        return -1;
    }
    
    /**
     * Retorna o total de um indice do vetor
     */
    private int obterTotalCampo(int campo) {
        int soma = 0;
        for (int[] dados : dadosFases) {
            soma += dados[campo];
        }
        return soma;
    }
}