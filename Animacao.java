import greenfoot.*;

/**
 * Controla a sequencia de imagens de uma animacao
 */
public class Animacao {
    // quantos passos sao necessarios para trocar de imagem
    private static final int PASSOS_POR_IMAGEM_PADRAO = 8;
    // guarda as imagens da animacao
    private GreenfootImage[] imagens;
    // quantos passos cada imagem dura, no caso da animacao nao ser uniforme
    private int[] duracoes;
    // guarda o indice da imagem atual
    private int indiceAtual;
    // guarda a quantidade de passos dados desde a ultima animacao
    private int passos;

    /**
     * Construtor de uma animacao, todas imagens tem a mesma duraçao
     * @param prefixo prefixo dos arquivos
     * @param quantidade numero de arquivos de imagem
     */
    public Animacao(String prefixo, int quantidade) {
        this(prefixo, quantidade, criarVetorComDuracoesIguais(quantidade));
    }

    /**
     * Construtor de uma animacao, cada imagem tem uma certa duraçao
     * @param prefixo prefixo dos arquivos
     * @param quantidade numero de arquivos de imagem
     * @param duracoes vetor de duracoes
     */
    public Animacao(String prefixo, int quantidade, int duracoes[]) {
        imagens = carregarImagens(prefixo, quantidade);
        this.duracoes = duracoes;
        indiceAtual = 0;
        passos =  0;
    }

    /**
     * Cria um vetor de duracoes, todas com o mesmo valor
     * @param quantidade quantas posicoes esse vetor possui
     * @return o vetor com todos os valores iguais a p
     */
    private static int[] criarVetorComDuracoesIguais(int quantidade) {
        int[] duracoesCriadas = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            duracoesCriadas[i] = PASSOS_POR_IMAGEM_PADRAO;
        }
        return duracoesCriadas;
    }

    /**
     * Carrega um conjunto de imagens no formato: prefixo (1).png, prefixo (2).png, ...
     * @param prefixo prefixo da imagem a ser carregada
     * @param numeroDeImagens numero de imagens a serem carregadas
     * @return As imagens com o prefixo encontradas
     */
    public static GreenfootImage[] carregarImagens(String prefixo, int numeroDeImagens) {
        GreenfootImage[] imagensCarregadas = new GreenfootImage[numeroDeImagens];
        for (int i = 0; i < imagensCarregadas.length; i++) {
            imagensCarregadas[i] = new GreenfootImage(prefixo + " (" + (i+1) + ").png");
        }
        return imagensCarregadas;
    }

    /**
     * Avanca um passo(frame). Retorna uma imagem ao chegar a hora de trocar, ou
     * null, caso nao seja necessario trocar
     * @return a nova imagem, null caso nao seja nova
     */
    public GreenfootImage avancar() {
        passos++;
        if (passos < duracoes[indiceAtual]) {
            return null;
        }
        passos = 0;
        indiceAtual = (indiceAtual + 1) % imagens.length;
        return imagens[indiceAtual];
    }

    /**
     * Volta para a primeira imagem e retorna ela
     * @return a primeira imagem do vetor
     */
    public GreenfootImage reiniciar() {
        indiceAtual = 0;
        passos = 0;
        return imagens[0];
    }
    
    /**
     * Retorna se esta na ultima imagem da animacao
     * @return true se esta na ultima imagem, false caso contrario
     */
    public boolean estaNaUltimaImagem() {
        return indiceAtual == imagens.length - 1;
    }
}
