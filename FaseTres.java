import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe da terceira fase do jogo, a fase do chefe
 */
public class FaseTres extends Fase
{
    /**
     * Construtor da fase tres do jogo
     * @param horaInicio hora em que o relogio do jogo se inicia
     * @param minutoInico minuto em que o relogio do jogo se inicia
     */
    public FaseTres(int horaInicio, int minutoInicio) {
        super("faseTres.png", null, 60, horaInicio, minutoInicio);
        
    }
    
    /**
     * Na terceira fase, nao ha saida, entao 
     * o metodo que cria a saida eh retirado
     */
    @Override
    protected void tentarCriarSaida() {}
}
