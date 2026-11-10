import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Texto extends Actor
{   
    public Texto(String texto) {
        GreenfootImage imagem = new GreenfootImage(350, 50);
        imagem.setColor(Color.WHITE);
        imagem.setFont(new Font("Serif", true, false, 36));
        imagem.drawString(texto, 10, 30);
        setImage(imagem);
    }
    
    public void atualizarTexto(String texto) {
        GreenfootImage imagem = new GreenfootImage(350, 50);
        imagem.setColor(Color.WHITE);
        imagem.setFont(new Font("Serif", true, false, 36));
        imagem.drawString(texto, 10, 30);
        setImage(imagem);   
    }
}
