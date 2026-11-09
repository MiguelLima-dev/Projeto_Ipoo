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
    private static GreenfootSound musica = new GreenfootSound("forest-ambience.wav");
    
    /**
     * Constructor for objects of class Tela.
     */
    public Tela(String caminhoImagem)
    {    
        super(1200, 900, 1); 
        // define o plano de fn
        setBackground(new GreenfootImage(caminhoImagem));
        // define o volume da musica para 70
        musica.setVolume(70);
    }

    public void act() {
        String tecla = Greenfoot.getKey();

        if (tecla != null) {
            tratarTecla(tecla);
        }
    }

    protected void tratarTecla(String tecla) {

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

    /**
     * Para a musica que esta sendo tocada
     */
    protected void pararMusica() {
        musica.stop();
    }
}
