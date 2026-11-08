import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class FaseUm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaseUm extends Fase
{
    // lista de frutos do mundo
    private List<Fruto> frutos;
    // guarda a imagem original do fundo
    private GreenfootImage fundoOriginal;
    
    /**
     * Constructor for objects of class FaseUm.
     * 
     */
    public FaseUm()
    {
        fundoOriginal = new GreenfootImage(getBackground());
        
        prepare();
        setBackground(new GreenfootImage("faseUm.png"));
        frutos = getObjects(Fruto.class);

        Fazendeiro fazendeiro = new Fazendeiro();
        addObject(fazendeiro,163,373);
    }

    /**
     * A cada act, o mundo tenta fazers um fruto crescer
     */
    public void act() {
        tentarCrescerFruto();
        atualizarPlacar();
    }

    /**
     * Tenta crescer um fruto, com uma chance de 1%
     */    
    private void tentarCrescerFruto() {
        int tentativa = Greenfoot.getRandomNumber(100);
        if (tentativa < 1) {
            if (frutos.size() > 0) {
                int indiceFruto = Greenfoot.getRandomNumber(frutos.size());
                frutos.get(indiceFruto).brotar();
            }
        }
    }

    private int obterPontuacaoJogador() {
        return getObjects(Fazendeiro.class).get(0).obterPontuacao();
    }

    private void atualizarPlacar() {
        GreenfootImage fundo = new GreenfootImage(fundoOriginal);
        fundo.setColor(Color.WHITE);
        fundo.setFont(new Font("Serif", true, false, 36));
        fundo.drawString("" + obterPontuacaoJogador(), 1035, 75);
        setBackground(fundo);
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
