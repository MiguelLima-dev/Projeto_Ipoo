import greenfoot.*;

/**
 * Controla a sequencia de imagens de uma animacao
 */
public class Animacao {
    // quantos passos sao necessarios para trocar de imagem
    private static final int PASSOS_POR_IMAGEM = 8;
    // guarda as imagens da animacao
    private GreenfootImage[] imagens;
    // guarda o indice da imagem atual
    private int indiceAtual;
    // guarda a quantidade de passos dados desde a ultima animacao
    private int passos;
    
    /**
     * Construtor da classe animacao
     * @param prefixo prefixo dos arquivos
     * @param quantidade numero de arquivos de imagem
     */
    public Animacao(String prefixo, int quantidade) {
        imagens = carregarImagens(prefixo, quantidade);
        indiceAtual = 0;
        passos = 0;
    }
    
     /**
     * Carrega um conjunto de imagens no formato: prefixo (1).png, prefixo (2).png, ...
     * @param prefixo prefixo da imagem a ser carregada
     * @param numeroDeImagens numero de imagens a serem carregadas
     * @return As imagens com o prefixo encontradas
     */
    public static GreenfootImage[] carregarImagens(String prefixo, int numeroDeImagens) {
        GreenfootImage[] imagens = new GreenfootImage[numeroDeImagens];
        for (int i = 0; i < imagens.length; i++) {
            imagens[i] = new GreenfootImage(prefixo + " (" + (i+1) + ").png");
        }
        return imagens;
    }
    
    /**
     * Avanca um passo(frame). Retorna uma imagem ao chegar a hora de trocar, ou
     * null, caso nao seja necessario trocar
     */
    public GreenfootImage avancar() {
        passos++;
        if (passos < PASSOS_POR_IMAGEM) {
            return null;
        }
        passos = 0;
        indiceAtual = (indiceAtual + 1) % imagens.length;
        return imagens[indiceAtual];
    }
    
    /**
     * Volta para a primeira imagem e retorna ela
     */
    public GreenfootImage reiniciar() {
        indiceAtual = 0;
        passos = 0;
        return imagens[0];
    }
}
