import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe da terceira fase do jogo, a fase do chefe
 */
public class FaseTres extends Fase
{
    // o chefe da fase
    private Saci chefe;
    
    /**
     * Construtor da fase tres do jogo
     * @param horaInicio hora em que o relogio do jogo se inicia
     * @param minutoInico minuto em que o relogio do jogo se inicia
     */
    public FaseTres(int horaInicio, int minutoInicio, Fazendeiro jogador, Partida partida) {
        super("faseTres.png", "bird.mp3", 60, horaInicio, minutoInicio, jogador, partida);
        chefe = new Saci(obterJogador());
        addObject(chefe, 700, 500);
        prepare();
    }
    
    /**
     * Retorna o chefe da fase
     * @return o chefe da fase
     */
    public Saci obterChefe() {
        return chefe;
    }
    /**
     * Na terceira fase, nao ha saida, entao 
     * o metodo que cria a saida eh retirado
     */
    @Override
    protected void tentarCriarSaida() {}
    
    /**
     * Na terceira fase, o jogador vence quando o chefe
     * eh derrotado
     * @return true se o jogador venceu, false caso nao
     */
    @Override
    protected boolean jogadorVenceu() {
        return !chefe.estaVivo();
    }
    
    /**
     * Prepara os obstaculos da fase
     */
    private void prepare() {
        Espinhos espinhos = new Espinhos();
        addObject(espinhos,259,350);
        Espinhos espinhos2 = new Espinhos();
        addObject(espinhos2,646,115);
    }
}
