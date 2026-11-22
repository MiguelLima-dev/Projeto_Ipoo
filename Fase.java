import greenfoot.*;
import java.util.List;

/**
 * Superclasse das fases do jogo
 */
public class Fase extends Mundo {
    // chance de um fruto brotar a cada act
    private static final int CHANCE_BROTAR = 1;
    // minutos antes da saida aparecer
    private static final int MINUTOS_SAIDA = 45;
    // posicao da saida
    private static final int SAIDA_X = 1170;
    private static final int SAIDA_Y = 312;
    // posicao do jogador
    private static final int JOGADOR_X = 284;
    private static final int JOGADOR_Y = 576;

    private int minutosFase;
    private Fazendeiro jogador;
    private Relogio relogio;
    private Hud hud;

    private boolean saidaAberta;

    /**
     * Construtor de uma fase
     * @param arquivoFundo arquivo da imagem de fundo
     * @param arquivoMusica arquivo da musica de fundo
     * @param minutosFase quantos minutos do jogo a fase dura
     * @param horaInicial hora inicial do jogo
     * @param minutoInicial minuto do jogo inicial
     */
    protected Fase(String arquivoFundo, String arquivoMusica, int minutosFase, int horaInicial,
    int minutoInicial) {
        super(arquivoFundo, arquivoMusica);
        setPaintOrder(Texto.class, Inimigo.class, Fazendeiro.class, Fruto.class);
        this.minutosFase = minutosFase;
        relogio = new Relogio(horaInicial, minutoInicial);
        jogador = new Fazendeiro();
        addObject(jogador, JOGADOR_X, JOGADOR_Y);
        hud = new Hud(jogador.obterPontuacao(), relogio.obterHorario());
        hud.adicionarAoMundo(this);
        saidaAberta = false;
    }

    /**
     * Executa as acoes do mundo a cada frame
     */
    @Override
    public void act() {
        // tenta fazer um fruto brotar
        tentarCrescerFruto();
        // atualiza o relogio
        relogio.passaTempo();
        // atualiza o relogio e o placar
        atualizarInfo();
        // criar saida para o jogador, no horario esperado
        tentarCriarSaida();
        tratarFim();
    }
    
    /**
     * Adiciona os frutos a fase
     * @param posicoes vetores de posicoes onde os frutos serao colocados
     */
    protected void adicionarFrutos(int[][] posicoes) {
        for (int i = 0; i < posicoes.length; i++) {
            int x = posicoes[i][0];
            int y = posicoes[i][1];
            addObject(new Fruto(), x, y);
        }
    }
    
    /**
     * Retorna o jogador da fase
     * @return retorna o jogador
     */
    protected Fazendeiro obterJogador() {
        return jogador;
    }

    /**
     * Retorna se o jogador venceu, o caso padrao eh quando ele
     * chega na saida
     * @return true se o jogador venceu, false caso contrario
     */
    protected boolean jogadorVenceu() {
        return jogador.chegouNaSaida();
    }

    /**
     * Verifica se o horario para sair chegou e tenta posicionar a saida
     */
    protected void tentarCriarSaida(){
        //Verifica se já deu o horario para liberar a saida
        if(relogio.obterMinutosPassados() >= MINUTOS_SAIDA && !saidaAberta){
            addObject(new Texto("SAÍDA LIBERADA!"), getWidth()/2, 50);
            addObject(new Saida(), SAIDA_X, SAIDA_Y);
            saidaAberta = true;
        }
    }

    /**
     * Retorna se o jogador perdeu o jogo
     * @return true se o jogador perdeu, false caso contrario
     */
    protected boolean jogadorPerdeu() {
        return jogador.encostouNoInimigo() || tempoSeEsgotou();
    }

    /**
     * Trata as condicoes de fim de fase
     */
    private void tratarFim() {
        if (jogadorPerdeu()) {
            trocarMundo(criarTelaFinal(false));
        }
        else if (jogadorVenceu()) {
            trocarMundo(criarProximoMundo());
        }
    }

    /**
     * Retorna o proximo Mundo do jogo.
     * O comportamento padrao leva para a tela final de vitoria,
     * mas pode ser sobrescrito pelas subclasses.
     * @return o proximo mundo
     */
    protected Mundo criarProximoMundo() {
        return criarTelaFinal(true);
    }    
    
    /**
     * Retorna as horas do relogio da fase
     * @return as horas do relogio da fase
     */
     protected int obterHorasRelogio() {
         return relogio.obterHoras();
     }
     
     /**
      * Retorna os minutos do relogio da fase
      * @return os minutos do relogio da fase
      */
     protected int obterMinutosRelogio() {
         return relogio.obterMinutos();
     }
     
    /**
     * Cria uma tela final e a retorna
     * @param venceu se o jogador venceu ou nao a fase
     * @return a tela final
     */
    private TelaFinal criarTelaFinal(boolean venceu) {
        return new TelaFinal(venceu);
    }

    /**
     * Tenta crescer um fruto, com uma chance fixa
     */    
    private void tentarCrescerFruto() {
        // lista com os frutos da fase
        List<Fruto> frutos = getObjects(Fruto.class);

        int tentativa = Greenfoot.getRandomNumber(100);
        if (tentativa < CHANCE_BROTAR) {
            if (frutos.size() > 0) {
                int indiceFruto = Greenfoot.getRandomNumber(frutos.size());
                frutos.get(indiceFruto).brotar();
            }
        }
    }

    /**
     * Atualiza o hud
     */
    private void atualizarInfo() {
        hud.atualizar(jogador.obterPontuacao(), relogio.obterHorario());
    }

    /**
     * Retorna se o tempo se esgotou
     * @return true se o tempo se esgotou, false caso contrario
     */
    private boolean tempoSeEsgotou() {
        return relogio.obterMinutosPassados() >= minutosFase;
    }
}