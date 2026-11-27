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
            {901,104}, {681, 612}, {229, 155}, {146, 574}, {806, 318}, {997, 607}
        };
        
        adicionarFrutos(posicoes);
    }
    
    @Override
    protected Mundo criarProximoMundo() {
        return new FaseDois(obterHorasRelogio(), obterMinutosRelogio(), obterJogador(), obterPartida());
    }
}
