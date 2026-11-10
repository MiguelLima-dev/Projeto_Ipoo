import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class FaseUm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaseUm extends World
{   
    // minutos até o jogo acabar, até o relogio bater 00:00
    private static final int totalMinutos = 60;
    // minutos até a saida aparecer
    private static final int saidaMinutos = 45;
    // chance, em %, de um fruto brotar, a cada act
    private static final int chanceBrotar = 1;

    // o actor que o jogador controla
    private Fazendeiro jogador;
    // Atributos que formam o relógio e o horario
    private Relogio relogio;
    private Texto horario;
    //atributos do tempo final
    private boolean saidaLiberada;
    // Condição de termino
    private boolean fimDeJogo;
    // texto do placar
    private Texto placar;

    /**
     * Constructor for objects of class FaseUm.
     * 
     */
    public FaseUm()
    {
        super(1200, 900, 1);
        setBackground(new GreenfootImage("faseUm.png"));

        // a hora inicia em 23:00
        relogio = new Relogio(23, 00);
        saidaLiberada = false;
        fimDeJogo = false;
        
        prepare();
    }

    /**
     * A cada act, o mundo tenta fazers um fruto crescer
     */
    public void act() {
        // tenta fazer um fruto brotar
        tentarCrescerFruto();
        // atualiza o relogio
        relogio.passatempo();
        // atualiza o relogio e o placar
        atualizarInfo();

        
        //vitória ou derrota
        derrota();
        vitoria();
    }

    /**
     * Tenta crescer um fruto, com uma chance de 1%
     */    
    private void tentarCrescerFruto() {
        // lista com os frutos da fase
        List<Fruto> frutos = getObjects(Fruto.class);
        
        int tentativa = Greenfoot.getRandomNumber(100);
        if (tentativa < chanceBrotar) {
            if (frutos.size() > 0) {
                int indiceFruto = Greenfoot.getRandomNumber(frutos.size());
                frutos.get(indiceFruto).brotar();
            }
        }
    }
    
    /**
     * Atualiza o placar da pontuacao e tambem o relogio
     */
    private void atualizarInfo() {
        placar.atualizarTexto(String.valueOf(jogador.obterPontuacao()));
        horario.atualizarTexto(relogio.obterHorario());
    }
    
    /**
     * Verifica se já deu 23:30 ou 00:00
     */
    private void verificarRelogio(){
        //Verifica se já deu 23:45 para liberar a saida
        if(horas == 23 && minutos >= 45 && !saidaLiberada){
            saidaLiberada = true;
            surgirMonstro();
            addObject(new Texto("SAÍDA LIBERADA!"), 600, 50);
            
            addObject(new Saida(), 1170, 312);
        }
        //Verifica se já deu 00:00 para finalizar o tempo de jogo
        if (horas == 0 && minutos == 0){
            fimDeJogo = true;
            showText("O tempo de jogo acabou!", 600, 450);
            Greenfoot.stop();
        }
    }
    
    /**
     * Faz o BichoPapao aparcer
     */
    private void surgirMonstro(){
        //Adiciona o monstro nessas coordenadas
        addObject(new BichoPapao(), 1100, 450);
    }
    
    /**
     * Metodo de acesso para consultar se a saida já está liberada
     * @return true se a saida estiver liberada, false se não estiver liberada 
     */
    public boolean saidaEstaLiberada(){
        //Retorna o estado se o acesso a saida esta liberado ou não
        return saidaLiberada;
    }
    
    /**
     * Verifica as condições de derrota e finaliza caso o fazendeiro seja atingido pelo inimigo
     */
    private void derrota(){
        //verifica se o jogo ja terminou
        if(fimDeJogo) {
            return;
        }
        
        //Busca o objeto da classe fazendeiro
        for(Fazendeiro jogador: getObjects(Fazendeiro.class)){
            //Confere se o jogador encostou no inmigo
            if(jogador.encostouNoInimigo()){
                //finaliza o jogo
               fimDeJogo = true;
               addObject(new Texto("GAME OVER!"), 600, 350);
               Greenfoot.stop();
               return;
            }
        }
    }
    
    /**
     * Verifica as condições de vitória do jogador 
     */
    private void vitoria(){
        //Confere se o jogo já terminou
        if(fimDeJogo){
            return;
        }
        
        //Busca o objeto da classe Fazendeiro
        for (Fazendeiro jogador: getObjects(Fazendeiro.class)){
            //Verifica se a saida ja esta liberada
            if(saidaLiberada)
            //Verifica se o jogador chegou na saida
            if(jogador.chegouNaSaida()){
                //Finaliza o jogo
                fimDeJogo = true;
                showText("Você conseguiu escapar a tempo!", 600, 450);
                Greenfoot.stop();
                return;
            }
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        jogador = new Fazendeiro();
        addObject(jogador,163,373);

        placar = new Texto(String.valueOf(obterPontuacaoJogador()));
        addObject(placar, 1210, 70);
        
        horario = new Texto(relogio.obterHoras());
        addObject(horario, 200, 50);

        Obstaculo obstaculo = new Obstaculo();
        addObject(obstaculo,285,211);
        Fruto fruto = new Fruto();
        addObject(fruto,769,337);
        Fruto fruto2 = new Fruto();
        addObject(fruto2,580,257);
        Fruto fruto3 = new Fruto();
        addObject(fruto3,592,157);
        Fruto fruto4 = new Fruto();
        addObject(fruto4,885,194);
        Fruto fruto5 = new Fruto();
        addObject(fruto5,969,363);
        Fruto fruto6 = new Fruto();
        addObject(fruto6,527,559);
        Fruto fruto7 = new Fruto();
        addObject(fruto7,920,632);

        fruto2.setLocation(358,454);
        fruto3.setLocation(418,225);
        fruto2.setLocation(348,562);
    }
}
