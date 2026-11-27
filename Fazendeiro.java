import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A classe fazendeiro representa o jogador
 */
public class Fazendeiro extends Entidade
{
    // quantos pontos o fazendeiro tem, a contagem de frutos coletados
    private int pontuacao;
    // quantos cristais foram coletados pelo fazendeiro
    private int cristais;
    // quantas garrafas o fazendeiro tem
    private int garrafas;
    public Fazendeiro() {
        // idle: 11 imagens| walk: 10 imagens| velocidade 2
        super("Fazendeiro_idle", 11, "Fazendeiro_walk", 10, 2);
        // inicia com 0 pontos, 0 cristais e 1 garrafa
        pontuacao = 0;
        cristais = 0;
        garrafas = 1;
    }

    public void act() {
        // trata o movimento do fazendeiro
        tratarMovimento();
        // trata a animacao idle do fazendeiro
        super.act();
        // trata a coleta de items
        tratarColetaFruto();
        tratarColetaCristal();
        tratarColetaGarrafa();
        // trata o uso de items
        String tecla = Greenfoot.getKey();
        tratarUsoCristal(tecla);
        tratarUsoGarrafa(tecla);
    }
    
    /**
     * Trata a coleta do fruto, caso
     * um fruto seja coletado, incrementa a
     * pontuacao.
    */
    private void tratarColetaFruto() {
        if (tentarPegarFruto()) {
            pontuacao += 1;
            Greenfoot.playSound("fazendeiro_coletando_fruto.wav");
        }
    }
    
    /**
     * Retorna se o fazendeiro esta na fase tres
     */
    private boolean estaNaFaseFinal() {
        return (getWorld() instanceof FaseTres);
    }
    
    /**
     * Quando o jogador, na terceira fase, aperta a tecla 'e',
     * a proxima investida do boss acontece mais devagar. Mas
     * isso consome um cristal
     */
    private void tratarUsoCristal(String tecla) {
        if (estaNaFaseFinal()) {
            if ("e".equals(tecla) && cristais > 0) {
                Saci saci = getWorldOfType(FaseTres.class).obterChefe();
                if (saci != null) {
                    saci.aumentarPreparacaoDaInvestida();
                    cristais--;
                }
            }
        }
    }
    
    /**
     * Quando o jogador, na terceira fase, aperta a tecla 'd',
     * ele deixa no lugar onde estava. Isso consome o numero de
     * garrafas do jogador
     */
    private void tratarUsoGarrafa(String tecla) {
        if (estaNaFaseFinal()) {
            if ("d".equals(tecla) && garrafas > 0) {
                getWorld().addObject(new GarrafaDeCaptura(), getX(), getY());
                garrafas--;
            }
        }
    }
    /**
     * Tenta pegar o fruto que o Fazendeiro esta tocando.
     * Caso consiga coletar um cristal, incrementa a contagem de cristais do fazendeiro
     */
    private void tratarColetaCristal()
    {
        if (isTouching(Cristal.class))
        {
            Cristal cristal = (Cristal) getOneIntersectingObject(Cristal.class);
            cristal.coletar();
            cristais++;
        }
    }
    
    /**
     * Coleta uma garrafa quando o fazendeiro a toca.
     * Nao funciona na fase final
     */
    private void tratarColetaGarrafa() {
        if (isTouching(GarrafaDeCaptura.class) && !estaNaFaseFinal()) {
            GarrafaDeCaptura garrafa = (GarrafaDeCaptura) getOneIntersectingObject(GarrafaDeCaptura.class);
            garrafa.coletar();
            garrafas++;
        }
    }
    /**
     * Move o fazendeiro conforme as setas do teclado.
     */
    private void tratarMovimento() {
        int dx = 0, dy = 0, vel = obterVel();
        if (Greenfoot.isKeyDown("up")) dy -= vel;
        if (Greenfoot.isKeyDown("down")) dy += vel;
        if (Greenfoot.isKeyDown("left")) dx -= vel;
        if (Greenfoot.isKeyDown("right")) dx += vel;

        mover(dx, dy);
    }
    
    /**
     * Retorna a pontuacao 
     * @return a pontuacao
     */
    public int obterPontuacao() {
        return pontuacao;
    }
    
    /**
     * Retorna a quantidade de cristais
     * @return a quantidade de cristais
     */
    public int obterCristais() {
        return cristais;
    }
    
    /**
     * Retorna a quantidade de garrafas
     * @return a quantidade de garrafas
     */
    public int obterGarrafas() {
        return garrafas;
    }
    
    /**
     * Verifica se o jogador encostou em algum actor que o mate
     * @return true se ele foi morto, false caso contrario
     */
    public  boolean morreu(){
        return isTouching(Inimigo.class) || isTouching(Espinhos.class);
    }
    
    /**
     * Verifica se o jogador chegou até a saída
     * @return true se o jogador chegou na saida, false se não chegou
     */
    public boolean chegouNaSaida(){
        return isTouching(Saida.class);
    }

}