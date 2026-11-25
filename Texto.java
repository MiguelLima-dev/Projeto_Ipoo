import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esse ator exibe um texto em branco na tela.
 * O tamanho padrao da fonte  50
 */
public class Texto extends Actor
{   
    // dimensoes da imagem e da fonte
    private static final int TAMANHO_PADRAO_FONTE = 50;
    // o tamanho da fonte, quanto nao padrao
    private final int tamanho;
    // guarda o texto exibido atualmente
    private String textoAtual;

    /**
     * Exibe um texto no tamanho especificado.
     * @param texto o texto a ser exibido
     * @param tamanho o tamanho da fonte do texto
     */
    public Texto(String texto, int tamanho) {
        this.tamanho = tamanho;
        escreverTexto(texto);
    }
    
    /**
     * Exibe um texto no tamanho de fonte padrao
     * @param texto o texto a ser exibido
     */
    public Texto(String texto) {
        this(texto, TAMANHO_PADRAO_FONTE);
    }
    
    /**
     * Exibe um novo texto, nao troca caso seja o mesmo
     * @param o novo texto a ser exibido
     */
    public void atualizarTexto(String texto) {
        if (!texto.equals(textoAtual)) {
            escreverTexto(texto);
        }
    }
    
    /**
     * Escrever o texto, com o tamanho dado, no actor
     * @param texto o texto a ser escrito
     * @param tamanho o tamanho do texto a ser escrito
     */
    private void escreverTexto(String texto) {
        textoAtual = texto;
        setImage(new GreenfootImage(texto, tamanho, Color.WHITE,
                                     new Color(0, 0, 0, 0)));

    }
}
