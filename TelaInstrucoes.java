import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Eh a classe da tela que contem as intrucoes de jogo,
 * ela tambem pode iniciar o jogo
 */
public class TelaInstrucoes extends Tela
{

    /**
     * Constroi a tela iniciao com  dada imagem
     */
    public TelaInstrucoes()
    {
        super("telaInstrucoes.png");
    }

    /**
     * Trata as teclas de alteraçao de tela
     * espaco inicia a primeira fase
     */
    @Override
    protected void tratarTecla(String tecla) {
        if ("space".equals(tecla)) {
            pararMusica();
            Greenfoot.setWorld(new FaseUm());
        }
    }
}
