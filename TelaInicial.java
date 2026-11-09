import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaInicial extends Tela
{

    /**
     * Constructor for objects of class TelaInicial.
     * 
     */
    public TelaInicial()
    {  
        super("telaInicial.png");
        
    }
    
    @Override
    protected void tratarTecla(String tecla) {
        if ("enter".equals(tecla)) {
            Greenfoot.setWorld(new TelaInstrucoes());
        }
        else if ("space".equals(tecla)) {
            pararMusica();
            Greenfoot.setWorld(new FaseUm());
        }
    }
}
