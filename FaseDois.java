import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe da segunda fase do jogo
 */
public class FaseDois extends Fase
{

    /**
     * Construtor da fase dois do jogo
     * @param horaInicio hora inicial do relogio
     * @param minutoInicio minutor inicial do relogio
     */
    public FaseDois(int horaInicio, int minutoInicio, Fazendeiro jogador) {
        super("faseDois.png", null, 60, horaInicio, minutoInicio, jogador);
        
        int[][] posicoes = {
            {901,104}, {681, 612}, {229, 155}, {146, 574}, {806, 318}, {997, 607}
        };
        
        adicionarFrutos(posicoes);
    }
    
    /**
     * O proximo mundo agora eh a terceira fase
     */
    @Override
    protected Mundo criarProximoMundo() {
        return new FaseTres(obterHorasRelogio(), obterMinutosRelogio(), obterJogador());
    }
}
