import greenfoot.*;

/**
 * Classe do Hud do jogo
 */
public class Hud {
    private static final int PLACAR_X = 1050;
    private static final int PLACAR_Y = 62;
    private static final int HORARIO_X = 165;
    private static final int HORARIO_Y = 47;
    private static final int GARRAFA_X = 880;
    private static final int GARRAFA_Y = 55;
    private static final int CRISTAL_X = 1050;
    private static final int CRISTAL_Y = 162;
    private Texto placar;
    private Texto horario;
    private Texto garrafa;
    private Texto cristal;
    
    /**
     * Cria um hud com pontuacao e horario
     * @param pontuacaoInicial pontuacao inicial do placar
     * @param horarioInicial horario inicial do hud
     * @param numeroGarrafa numero inicial de garrafas
     * @param numeroCristal numero inicial de cristais 
     */
    public Hud(int pontuacaoInicial, String horarioInicial, int numeroGarrafa, int numeroCristal) {
        placar = new Texto(String.valueOf(pontuacaoInicial));
        horario = new Texto(horarioInicial);
        garrafa = new Texto(String.valueOf(numeroGarrafa));
        cristal = new Texto(String.valueOf(numeroCristal));
    }
    
    /**
     * Adiciona o Hud ao mundo
     * @param mundo mundo ao qual o hud sera adicionado
     */
    public void adicionarAoMundo(World mundo) {
        mundo.addObject(placar, PLACAR_X, PLACAR_Y);
        mundo.addObject(horario, HORARIO_X, HORARIO_Y);
        mundo.addObject(garrafa, GARRAFA_X, GARRAFA_Y);
        mundo.addObject(cristal, CRISTAL_X, CRISTAL_Y);
    }
    
    /**
     * Atualiza o hud
     * @param pontuacao a nova pontuacao
     * @param novoHorario o novo horario
     * @param nGarrafa o novo numero de garrafas
     * @param nCristal o novo numero de cristais
     */
    public void atualizar(int pontuacao, String novoHorario, int nGarrafa, int nCristal) {
        placar.atualizarTexto(String.valueOf(pontuacao));
        horario.atualizarTexto(novoHorario);
        garrafa.atualizarTexto(String.valueOf(nGarrafa));
        cristal.atualizarTexto(String.valueOf(nCristal));
    }
}