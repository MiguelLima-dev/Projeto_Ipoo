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
    // guarda a imagem original do fundo
    private GreenfootImage fundoOriginal;
    // Atributos que formam o relógio
    private int horas;
    private int minutos;
    private int tiquesRelogio;
    //atributos do tempo final
    private boolean saidaLiberada;
    private boolean aparecerMonstro;
    // Condição de termino
    private boolean fimDeJogo;
    
    /**
     * Constructor for objects of class FaseUm.
     * 
     */
    public FaseUm()
    {
        super(1200, 900, 1);
        fundoOriginal = new GreenfootImage(getBackground());
        
        prepare();
        setBackground(new GreenfootImage("faseUm.png"));
 
        Fazendeiro fazendeiro = new Fazendeiro();
        addObject(fazendeiro,163,373);
        
        horas = 23;
        minutos = 0;
        tiquesRelogio = 0;
        
        saidaLiberada = false;
        aparecerMonstro = false;
        fimDeJogo = false;
    }

    /**
     * A cada act, o mundo tenta fazers um fruto crescer
     */
    public void act() {
        tentarCrescerFruto();
        atualizarPlacar();
        
        //Controle do time
        passaTempo();
        atualizarRelogio();
        verificarRelogio();
        
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
        if (tentativa < 1) {
            if (frutos.size() > 0) {
                int indiceFruto = Greenfoot.getRandomNumber(frutos.size());
                frutos.get(indiceFruto).brotar();
            }
        }
    }
    
    /** 
     * Retorna a pontuacao do jogador nessa fase.
     */
    private int obterPontuacaoJogador() {
        return getObjects(Fazendeiro.class).get(0).obterPontuacao();
    }
    
    /**
     * Atualiza o placar da pontuacao
     */
    private void atualizarPlacar() {
        GreenfootImage fundo = new GreenfootImage(fundoOriginal);
        fundo.setColor(Color.WHITE);
        fundo.setFont(new Font("Serif", true, false, 36));
        fundo.drawString("" + obterPontuacaoJogador(), 1035, 75);
        setBackground(fundo);
    }
    
    private void passaTempo(){
        tiquesRelogio++;
        
        if(tiquesRelogio >= 30){
            minutos++;
            tiquesRelogio = 0;
            
            if(minutos >= 60){
                minutos = 0;
                horas = (horas + 1) % 24;
            }
        }
    }
    
    private void atualizarRelogio(){
        String tempoTela = String.format("%02d:%02d", horas, minutos);
        showText("Horário - " + tempoTela, 200, 50);
    }
    
    private void verificarRelogio(){
        if(horas == 23 && minutos >= 30 && !saidaLiberada){
            saidaLiberada = true;
            showText("SAÍDA LIBERADA!", 600, 50);
            
            addObject(new Saida(), 1170, 312);
        }
        
        if (horas == 0 && minutos == 0 && !aparecerMonstro){
            fimDeJogo = true;
            showText("O tempo de jogo acabou!", 600, 450);
            Greenfoot.stop();
        }
    }
    
    private void surgirMonstro(){
        addObject(new BichoPapao(), 1100, 450);
    }
    
    public boolean saidaEstaLiberada(){
        return saidaLiberada;
    }
    
    private void derrota(){
        if(fimDeJogo) {
            return;
        }
        
        for(Fazendeiro jogador: getObjects(Fazendeiro.class)){
            if(jogador.encostouNoInimigo()){
               fimDeJogo = true;
               showText("GAME OVER!", 600, 450);
               Greenfoot.stop();
               return;
            }
        }
    }
    
    private void vitoria(){
        if(fimDeJogo){
            return;
        }
        for (Fazendeiro jogador: getObjects(Fazendeiro.class)){
            if(saidaLiberada)
            if(jogador.chegouNaSaida()){
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

        Obstaculo obstaculo = new Obstaculo("arbusto.png");
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
