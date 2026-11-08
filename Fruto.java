import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fruto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruto extends Actor
{
    // guarda as imagens do fruto
    private static final GreenfootImage[] imagensFruto = Entidade.carregarImagens("fruto", 7);
    // quantos frames dura cada imagem
    private static final int[] duracaoImagem = {10, 25, 20, 20, 15, 10, 6};
    // indice da imagem atual
    private int indiceImagemAtual;
    // quantos frames se passaram desde que a p    
    private int frames;
    // se o fruto esta disponivel
    private boolean coletavel;
    // se a planta esta brotando
    private boolean brotando;
    
    public Fruto() {
        // a imagem comeca no primeiro indice
        indiceImagemAtual = 0;
        // define a imagem
        setImage(imagensFruto[indiceImagemAtual]);
        // a planta inicia sem fruto
        coletavel = false;
        // inicia a planta sem brotar
        brotando = false;
    }
    
    /**
     * Act - do whatever the Fruto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (brotando) {
            animarBrotar();
        }
    }
    
    /**
     * Faz o fruto começar a brotar
     */
    public void brotar() {
        if (!coletavel && !brotando) {
            brotando = true;
        }
    }
    /**
     * Executa a animacao de crescimento do fruto
     */
    private void animarBrotar() {
        frames++;
        if (frames >= duracaoImagem[indiceImagemAtual]) {
            frames = 0;
            indiceImagemAtual++;
            setImage(imagensFruto[indiceImagemAtual]);
            
            if (indiceImagemAtual == imagensFruto.length - 1) {
                // o fruto agora eh coletavel
                coletavel = true;
                // o fruto nao esta mais crescendo
                brotando = false;
            }
        }
    }
    
    /**
     * Tenta remover o fruto da planta, so funciona quando ele eh coletavel
     * @return true se o fruto foi coletado, false caso contrario
     */
    public boolean coletar() {
        if (coletavel) {
            coletavel = false;
            indiceImagemAtual = 0;
            setImage(imagensFruto[indiceImagemAtual]);
            return true;
        }
        // o fruto ainda nao eh coletavel
        return false;
    }
    
    /**
     * Retorna se o fruto poder brotar
     * @return true se o fruto pode brotar, false caso contrario
     */
    public boolean podeBrotar() {
        return !coletavel && !brotando;
    }
}