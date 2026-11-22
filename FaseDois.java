import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FaseDois here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaseDois extends Fase
{

    /**
     * Constructor for objects of class FaseDois.
     * 
     */
    public FaseDois(int horaInicio, int horaFim) {
        super("faseDois.png", null, 60, horaInicio, horaFim);
        
        int[][] posicoes = {
            {901,104}, {681, 612}, {229, 155}, {146, 574}, {806, 318}, {997, 607}
        };
        
        adicionarFrutos(posicoes);
    }
    
    @Override
    protected Mundo criarProximoMundo() {
        return new FaseTres(obterHorasRelogio(), obterMinutosRelogio());
    }
}
