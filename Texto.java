import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esse ator exibe um texto em branco na tela
 */
public class Texto extends Actor
{   
    // dimensoes da imagem e da fonte
    private static final int largura = 350;
    private static final int altura = 50;
    private static final int margemX = 10;
    private static final int margemY = 30;
    private static final int tamanhoFonte = 36;
    
    // guarda o texto exibido atualmente
    private String textoAtual;

    /**
     * Exibe um texto.
     * @param texto o texto a ser exibido
     */
    public Texto(String texto) {
        escreverTexto(texto);
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
     * Escreve o texto no actor
     */
    private void escreverTexto(String texto) {
        textoAtual = texto;

        GreenfootImage imagem = new GreenfootImage(largura, altura);
        imagem.setColor(Color.WHITE);
        imagem.setFont(new Font("Serif", true, false, tamanhoFonte));
        setImage(imagem);
    }
}
