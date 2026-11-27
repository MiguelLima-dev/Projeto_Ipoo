import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Classe do item coletavel utilizado para derrotar o chefe
 */
public class GarrafaDeCaptura extends Actor
{
    // a animaçao da garrafa
    private Animacao animacao;
    // se a garrafa deve executar a animaçao ou nao
    private boolean animar;
    
    /**
     * Constroi uma garrafa de captura
     */
    public GarrafaDeCaptura() {
        animacao = new Animacao("Garrafa_capture", 16);
        animar = true;
    }

    /**
     * Executa a animacao uma vez e para de trocar de imagem
     */
    public void act() {
        if (animacao.estaNaUltimaImagem()) {
            animar = false;
        }
        if (animar) {
            GreenfootImage novaImagem = animacao.avancar();
            if (novaImagem != null) {
                setImage(novaImagem);
            }
        }
    }
    
    /**
     * Remove o item do mundo
     */
    public void coletar() {
        getWorld().removeObject(this);
    }
}
