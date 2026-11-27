import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Essa classe eh a primeria fase do jogo, contem tres inimigos e alguns
 * frutos coletaveis que renascem.
 * A saida eh aberta depois de um certo tempo
 */
public class FaseUm extends Fase {
    /**
     * Constroi a fase um
     */
    public FaseUm() {
        super("faseUm.png", "seashore.mp3", 60, 23, 0, new Fazendeiro(), new Partida());

        int[][] posicoes = {
                {901,150}, {681, 612}, {229, 155}, {150, 574}, {806, 318}, {997, 607}
            };

        adicionarFrutos(posicoes);
        prepare();
    }

    @Override
    protected Mundo criarProximoMundo() {
        return new FaseDois(obterHorasRelogio(), obterMinutosRelogio(), obterJogador(), obterPartida());
    }
    
    /**
     * Prepara os actors da fase
     */
    private void prepare()
    {
        Obstaculo obstaculo = new Obstaculo();
        addObject(obstaculo,811,471);
        Obstaculo obstaculo2 = new Obstaculo();
        addObject(obstaculo2,110,381);
        Obstaculo obstaculo3 = new Obstaculo();
        addObject(obstaculo3,602,55);
        BichoPapao bichoPapao = new BichoPapao();
        addObject(bichoPapao,191,235);
        bichoPapao.setLocation(360,69);
        bichoPapao.setLocation(361,59);
        Cuca cuca = new Cuca(obterJogador());
        addObject(cuca,998,245);
        GarrafaDeCaptura garrafaDeCaptura = new GarrafaDeCaptura();
        addObject(garrafaDeCaptura,27,97);

        Espinhos espinhos = new Espinhos();
        addObject(espinhos,259,350);
        Espinhos espinhos2 = new Espinhos();
        addObject(espinhos2,646,115);
        Espinhos espinhos3 = new Espinhos();
        addObject(espinhos3,788,511);
    }
}
