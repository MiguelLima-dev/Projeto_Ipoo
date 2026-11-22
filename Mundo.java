import greenfoot.*;

/**
 * Superclasse dos mundos do jogo(fases e telas)
 */
public class Mundo extends World {
    // largura e altura da tela
    private static final int LARGURA = 1200;
    private static final int ALTURA = 700;
    // guarda a musica sendo tocada no momento
    private static GreenfootSound musicaAtual;
    // guarda o nome do arquivo da musica atual
    private static String arquivoMusicaAtual;
    // guarda o nome do arquivo da musica de cada mundo
    private String arquivoMusica;

    /**
     * Cria um mundo e define a música de fundo
     */
    protected Mundo(String arquivoFundo, String arquivoMusica) {
        super(LARGURA, ALTURA, 1);
        setBackground(new GreenfootImage(arquivoFundo));

        this.arquivoMusica = arquivoMusica;
    }
    
    /**
     * Garante que a musica correta esta tocando com quando o jogador inicia
     */
    public void started() {
        garantirMusicaTocando();
    }

    /**
     * Pause a musica quando o jogador pausa o jogo
     */
    public void stopped() {
        if (musicaAtual != null) {
            musicaAtual.pause();
        }
    }

    /**
     * Garante que a musica de fundo seja correta e esteja tocando
     */
    private void garantirMusicaTocando() {
        if (arquivoMusica == null) {
            if (musicaAtual != null) {
                musicaAtual.stop();
            }
        }
        else if (arquivoMusica.equals(arquivoMusicaAtual)) {
            if (!musicaAtual.isPlaying()) {
                musicaAtual.playLoop();
            }
            return;
        }
        else {
            if (musicaAtual != null) {
                musicaAtual.stop();
            }
            GreenfootSound novaMusica = new GreenfootSound(arquivoMusica);
            novaMusica.setVolume(70);

            arquivoMusicaAtual = arquivoMusica;
            musicaAtual = novaMusica;
            novaMusica.playLoop();
        }
    }

    /**
     * Troca o mundo atual para um mundo destino
     * @param destino o novo mundo
     */
    protected void trocarMundo(Mundo destino) {
        Greenfoot.setWorld(destino);
        destino.garantirMusicaTocando();
    }
}