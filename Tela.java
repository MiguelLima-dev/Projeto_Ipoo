import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tela extends World
{
    // guarda a musica que toca durante as telas do jogo
    private static GreenfootSound musica = new GreenfootSound("musica_assombrada.wav");
    
    /**
     * Constructor for objects of class Tela.
     * 
     */
    public Tela(String caminhoImagem)
    {    
        super(1200, 900, 1); 

        setBackground(new GreenfootImage(caminhoImagem));
        
        musica.setVolume(70);
    }
    
    /**
     * Comeca a tocar a musica quando entra em uma tela
     */
    public void started() {
        musica.playLoop();
    }
    
    /**
     * Pausa a musica para comecar de onde parou depois 
     */
    public void stopped() {
        musica.pause();
    }
    



}
