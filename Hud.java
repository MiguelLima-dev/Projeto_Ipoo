import greenfoot.*;

/**
 * Classe do Hud do jogo
 */
public class Hud {
    private static final int PLACAR_X = 1050;
    private static final int PLACAR_Y = 62;
    private static final int HORARIO_X = 165;
    private static final int HORARIO_Y = 47;
    private static final int CRISTAIS_X = 920;
    private static final int CRISTAIS_Y = 62;

    private Texto placar;
    private Texto horario;
    private Texto cristais;

    /**
     * Cria um hud com pontuacao e horario
     * @param pontuacaoInicial pontuacao inicial do placar
     * @param horarioInicial horario inicial do hud
     */
    public Hud(int pontuacaoInicial, String horarioInicial) {
        placar = new Texto(String.valueOf(pontuacaoInicial));
        horario = new Texto(horarioInicial);
    }

    /**
     * Adiciona o Hud ao mundo
     * @param mundo mundo ao qual o hud sera adicionado
     */
    public void adicionarAoMundo(World mundo) {
        mundo.addObject(placar, PLACAR_X, PLACAR_Y);
        mundo.addObject(horario, HORARIO_X, HORARIO_Y);
        if(cristais != null){
            mundo.addObject(cristais, CRISTAIS_X, CRISTAIS_Y);
        }
    }
    
    public void ativarCristais(World mundo, int quantidadeInicial){
        cristais = new Texto(String.valueOf(quantidadeInicial));
        mundo.addObject(cristais, CRISTAIS_X, CRISTAIS_Y);
    }

    /**
     * Atualiza o hud
     * @param pontuacao a nova pontuacao
     * @param novoHorario o novo horario
     */
    public void atualizar(int pontuacao, String novoHorario) {
        placar.atualizarTexto(String.valueOf(pontuacao));
        horario.atualizarTexto(novoHorario);
    }
    
    public void atualizarCristais(int quantidade){
        if(cristais != null){
            cristais.atualizarTexto(String.valueOf(quantidade));
        }
    }
}