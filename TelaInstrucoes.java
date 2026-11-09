import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaInstrucoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaInstrucoes extends Tela
{

    /**
     * Constructor for objects of class TelaInstrucoes.
     * 
     */
    public TelaInstrucoes()
    {
        super("telaInstrucoes.png");
    }
    
    @Override
    protected void tratarTecla(String tecla) {
        if ("space".equals(tecla)) {
            pararMusica();
            Greenfoot.setWorld(new FaseUm());
        }
    }
}
