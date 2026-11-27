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
    public FaseDois(int horaInicio, int minutoInicio, Fazendeiro jogador, Partida partida) {
        super("faseDois.png", "seashore.mp3", 60, horaInicio, minutoInicio, jogador, partida);
        
        int[][] posicoes = {
            {901,150}, {681, 612}, {229, 155}, {150, 574}, {806, 318}, {997, 607}
        };
        
        adicionarFrutos(posicoes);
        prepare();
    }
    
    /**
     * O proximo mundo agora eh a terceira fase
     */
    @Override
    protected Mundo criarProximoMundo() {
        return new FaseTres(obterHorasRelogio(), obterMinutosRelogio(), obterJogador(), obterPartida());
    }
    
    /**
     * Prepara os actors da fase
     */
    private void prepare() {
        Espinhos espinhos = new Espinhos();
        addObject(espinhos,846,444);
        Obstaculo obstaculo4 = new Obstaculo();
        addObject(obstaculo4,200,312);
        Obstaculo obstaculo5 = new Obstaculo();
        addObject(obstaculo5,564,657);
        Espinhos espinhos2 = new Espinhos();
        addObject(espinhos2,673,121);
        LoboMau loboMau = new LoboMau();
        addObject(loboMau,151,127);
        Cuca cuca2 = new Cuca(obterJogador());
        addObject(cuca2,447,127);
        BichoPapao bichoPapao2 = new BichoPapao();
        addObject(bichoPapao2,1048,405);
        
        GarrafaDeCaptura garrafaDeCaptura2 = new GarrafaDeCaptura();
        addObject(garrafaDeCaptura2,1117,630);
        GarrafaDeCaptura garrafaDeCaptura3 = new GarrafaDeCaptura();
        addObject(garrafaDeCaptura3,445,227);
    }
}
