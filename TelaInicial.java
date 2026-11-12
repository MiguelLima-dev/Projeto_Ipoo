import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tela inicial do jogo, leva para primeira fase ou para a
 * tela de instrucoes
 */
public class TelaInicial extends Tela
{

    /**
     * Constroi a tela inicial com a imagem indicada
     */
    public TelaInicial()
    {  
        super("telaInicial.png");
        
    }
    
    /**
     * Trata as teclas de alteraçao de tela
     * enter leva para tela de instrucoes
     * espaco inicia a primeira fase
     */
    @Override
    protected void tratarTecla(String tecla) {
        if ("enter".equals(tecla)) {
            Greenfoot.setWorld(new TelaInstrucoes());
        }
        else if ("space".equals(tecla)) {
            pararMusica();
            Greenfoot.setWorld(new FaseUm());
        }
    }
}
