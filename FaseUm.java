import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Essa classe eh a primeria fase do jogo, contem tres inimigos e alguns
 * frutos coletaveis que renascem.
 * A saida eh aberta depois de um certo tempo
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
    // confere se a saida esta aberta
    private boolean saidaAberta;
    // Condição de termino
    private boolean fimDeJogo;
    // texto do placar
    private Texto placar;

    /**
     * Constroi a fase um
     */
    public FaseUm()
    {
        super(1200, 700, 1);
        setBackground(new GreenfootImage("faseUm.png"));

        // a hora inicia em 23:00
        relogio = new Relogio(23, 00);
        fimDeJogo = false;
        
        saidaAberta = false;
        prepare();
    }

    /**
     * A cada act, o mundo tenta fazers um fruto crescer
     */
    public void act() {
        // tenta fazer um fruto brotar
        tentarCrescerFruto();
        // atualiza o relogio
        relogio.passaTempo();
        // atualiza o relogio e o placar
        atualizarInfo();

        // criar saida para o jogador, no horario esperado
        tentarCriarSaida();
        // trata as condicoes para o jogo acabar
        tratarFimDeJogo();
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
     * Verifica se já deu 23:45
     */
    private void tentarCriarSaida(){
        //Verifica se já deu 23:45 para liberar a saida
        if(relogio.obterMinutosPassados() >= saidaMinutos && !saidaAberta){
            addObject(new Texto("SAÍDA LIBERADA!"), getWidth()/2, 50);
            addObject(new Saida(), 1170, 312);
            saidaAberta = true;
        }
    }

    
    /**
     * Exibe uma mensagem de fim de jogo e pausa a execucao
     */
    private void finalizarJogo(String mensagem){
        fimDeJogo = true;
        addObject(new Texto(mensagem), getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
    
    /**
     * Verifica as condições de fim de jogo, sao elas:
     * tempo esgotado, jogador pego por um inimigo e jogador escapando
     */
    private void tratarFimDeJogo(){
        //Confere se o jogo já terminou
        if(fimDeJogo){
            return;
        }

        //Verifica se já deu 00:00 para finalizar o tempo de jogo
        if (relogio.obterMinutosPassados() == totalMinutos){
            finalizarJogo("O tempo de jogo acabou!");
            return;
        }

        //Confere se o jogador encostou no inimigo
        if(jogador.encostouNoInimigo()){
            //finaliza o jogo
            finalizarJogo("GAME OVER!");
            return;
        }

        //Verifica se a saida ja esta liberada e se o jogador chegou na saida
        if(jogador.chegouNaSaida()){
            //Finaliza o jogo
            finalizarJogo("Você conseguiu escapar a tempo!");
            return;
        }
    }
    
    /**
     * Cria os objeto iniciais no mundo
     */
    private void prepare()
    {
        // inicia e posiciona os frutos
        Fruto fruto = new Fruto();
        addObject(fruto,901,104);
        Fruto fruto2 = new Fruto();
        addObject(fruto2,681,612);
        Fruto fruto3 = new Fruto();
        addObject(fruto3,229,155);
        Fruto fruto4 = new Fruto();
        addObject(fruto4,146,574);
        Fruto fruto5 = new Fruto();
        addObject(fruto5,806,318);
        Fruto fruto6 = new Fruto();
        addObject(fruto6,997,607);
        
         // inicia e posiciona o jogador
        jogador = new Fazendeiro();
        addObject(jogador,284,576);
        
        // inicia e posiciona os frutos
        Cuca cuca = new Cuca(jogador);
        addObject(cuca,592,102);

        LoboMau loboMau = new LoboMau();
        addObject(loboMau,646,236);

        BichoPapao bichoPapao = new BichoPapao();
        addObject(bichoPapao,135,322);
        
        // inicia e posiciona o placar
        placar = new Texto(String.valueOf(jogador.obterPontuacao()));
        addObject(placar, 1050, 62);
        // inicia e posiciona o horario
        horario = new Texto(relogio.obterHorario());
        addObject(horario, 165, 47);
        
        // inicia e posiciona os obstaculos
        Obstaculo obstaculo = new Obstaculo();
        addObject(obstaculo,426,65);
        Obstaculo obstaculo2 = new Obstaculo();
        addObject(obstaculo2,443,466);
        Obstaculo obstaculo3 = new Obstaculo();
        addObject(obstaculo3,965,436);
    }
}
