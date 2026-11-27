import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Eh um fruto coletavel pelo jogador, utilizado como marca de pontuacao.
 * Ele brota com uma animacao.
 */
public class Fruto extends Actor
{
    // quantos frames dura cada imagem
    private static final int[] DURACAO_IMAGENS = {10, 25, 20, 20, 15, 10, 6};
    // para ajustar o volume do audio
    private static final GreenfootSound SOM_BROTAR = new GreenfootSound("fruta_brotando.wav");
    // animacao do fruto brotando
    private Animacao animacaoBrotar;
    
    // se a planta esta coletavel
    private boolean coletavel;
    // se a planta esta brotando
    private boolean brotando;

    
    public Fruto() {
        // inicia a animacao e a imagem do actor
        animacaoBrotar = new Animacao("fruto", 7, DURACAO_IMAGENS);
        setImage(animacaoBrotar.reiniciar());
        // a planta inicia sem fruto
        coletavel = false;
        // inicia a planta sem brotar
        brotando = false;
        // altera o volume do som
        SOM_BROTAR.setVolume(70);
    }
    
    /**
     * Tenta brotar a cada act
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
        GreenfootImage novaImagem = animacaoBrotar.avancar();
        if (novaImagem != null) {
            setImage(novaImagem);
            
            if (animacaoBrotar.estaNaUltimaImagem()) {
                coletavel = true;
                brotando = false;
                SOM_BROTAR.play();
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
            setImage(animacaoBrotar.reiniciar());
            return true;
        }
        // o fruto ainda nao eh coletavel
        return false;
    }
    
    /**
     * @return true se o fruto pode ser coletado e false caso contrário.
     */
    public boolean frutoEstaColetavel()
    {
        return coletavel;
    }
}