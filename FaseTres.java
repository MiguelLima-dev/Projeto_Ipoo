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
    public FaseTres(int horaInicio, int minutoInicio, Fazendeiro jogador, Partida partida) {
        super("faseTres.png", "bird.mp3", 60, horaInicio, minutoInicio, jogador, partida);
        
        adicionarCristais();
        
        adicionarChefe();
        
        adicionarPedras();
    }
    
    public void act(){
        super.act();
        if(obterJogador() != null && obterHud() != null){
            obterHud().atualizarCristais(obterJogador().obterCristais());
        }
    }
    
    private void adicionarCristais(){
        addObject(new Cristal(), 250, 200);
        addObject(new Cristal(), 750, 450);
        addObject(new Cristal(), 550, 650);
    }
    
    public void adicionarPedras(){
        addObject(new ObstaculoDois(), 180, 300);
        addObject(new ObstaculoDois(), 760, 170);
        addObject(new ObstaculoDois(), 1080, 420);
    }
    
    private void adicionarChefe(){
        addObject(new Saci(obterJogador()), 800, 300);
    }
    
    /**
     * Na terceira fase, nao ha saida, entao 
     * o metodo que cria a saida eh retirado
     */
    @Override
    protected void tentarCriarSaida() {}
}
