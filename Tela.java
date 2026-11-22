import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Eh a superclasse que guarda a informaçao comum a todas as telas do jogo
 */
public class Tela extends Mundo
{
    /**
     * Constroi uma tela
     * @param caminhoImagem o arquivo da imagem do fundo
     */
    protected Tela(String caminhoImagem)
    {    
        super(caminhoImagem, "forest-ambience.wav");
    }
    
    /**
     * Guarda a ultima tecla pressionada a cada act
     */
    public void act() {
        String tecla = Greenfoot.getKey();

        if (tecla != null) {
            tratarTecla(tecla);
        }
    }
    
    /**
     * Eh feita para para ser sobreescrita pelas subclasses,
     * deve tratar o uso de botoes para alterar a tela
     */
    protected void tratarTecla(String tecla) {

    }
}
