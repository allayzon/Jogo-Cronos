/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodjogo5.Inimigos;


import prodjogo4.Robo.Tiro;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;


/**
 *
 * @author Leonardo
 */
public class Inimigos {
    private int posx, posy;
    private int tamx, tamy;
    private int vida;
    private int timer;
    private int cont;
 //   Tiro tiro;
    private ArrayList<Tiro> tiros;    
    private BufferedImage imagemParado[];
    private BufferedImage imagemMorrendo[];
    private int indiceAtual;
    private boolean morreu;
    private int indiceTiroAtual;
    private int timerTiro;
    private boolean atirando;
    private BufferedImage imagemAtirando[];
    private boolean estaNoChao;
    public int tempoPulo;

    
    public Inimigos(int inicialX, int inicialY){
        cont = 0;
    //    tiro = new Tiro(posx, posy + 40);
        posx = inicialX;
        posy = inicialY;
        tiros = new ArrayList<Tiro>();
        timer = 0;
        indiceAtual = 0;
        tamx = 150;
        tamy = 150;
        atirando = true;
        imagemMorrendo = new BufferedImage[10];
        imagemParado = new BufferedImage[8];
        imagemAtirando = new BufferedImage[4];
        morreu = false;
        estaNoChao = true;
        tempoPulo = 0;
   
        try{
            for (int i = 0; i < 10; i++) {   
                String imagem = "imagensRobo/Dead (" + (i + 1) + ").png";
                System.out.println("Carregando a imagem: " + imagem);
                imagemMorrendo[i] = ImageIO.read(new File(imagem));
            }
            for (int i = 0; i < 4; i++) {   
                String imagem = "imagensRobo/Shoot (" + (i + 1) + ").png";
                System.out.println("Carregando a imagem: " + imagem);
                imagemAtirando[i] = ImageIO.read(new File(imagem));
            }
        
            for (int i = 0; i < 8; i++) {   
                imagemParado[i] = ImageIO.read(new File("imagensRobo/Idle (" + (i+1) + ").png"));
            }
        }catch(Exception e){
            System.out.println("Não foi possível carregar as imagens do robo correndo");
        }
    }
    
    public int getPosx() {
        return posx;
    }
    public void setEstaNoChao(boolean estaNoChao) {
        this.estaNoChao = estaNoChao;
    }

    public void morra(){
        morreu = true;
    }
    public boolean isMorreu() {
        return morreu;
    }

    public Tiro atira(){
        indiceTiroAtual++;
        if(indiceTiroAtual >= 9){
            atirando = true;
        }
        Tiro tiro;
        tiro = new Tiro(posx, posy + 40, -1); 
        return tiro;
    }
    
   public boolean podeAtirar(){
       cont++;
       if(atirando == false){
           if(this.isMorreu() == false){
                if(cont >= 50){
                    cont = 0;
                    return true;
                }
            }     
        }
       return false;
    }
    
    public void encontrouChao(){     
        setEstaNoChao(true);
    }
   
   
    
    public void atualizar(){
        timer++;
        
        if(isMorreu() == false) {
            if(estaNoChao == false){          
                //setPosy((int) (posy0 - (-1 * tempoPulo * tempoPulo)/2));
                setPosy(5);
                tempoPulo++;
            }
            if (atirando ){
                    timerTiro++;
                    if(timerTiro >= 4){
                        indiceTiroAtual++;
                        if(indiceTiroAtual >= 4){
                            indiceTiroAtual = 0;
                            atirando = false;
                        timerTiro = 0;
                    }
                }
            }
        if(timer >= 6){
                indiceAtual++;
                if(indiceAtual == 8){
                    indiceAtual = 0; 
                    atirando = true;
                }
                timer = 0;
            }
    }
        else{    
            if(timer >= 4){
                indiceAtual++;
                if(indiceAtual >= 10){
                    indiceAtual = 9;  
                }
                timer = 0;
            }
        }
        
    }
 
    public void pintar(Graphics2D g){
        if(isMorreu() == true){
            g.drawImage(imagemMorrendo[indiceAtual],
                posx, posy,
                posx + tamx, posy + tamy,
                imagemMorrendo[indiceAtual].getWidth(), 0,
                0, imagemMorrendo[indiceAtual].getHeight(),
                null);
        }else if(atirando){
            g.drawImage(imagemAtirando[indiceTiroAtual],
                posx, posy,
                posx + tamx, posy + tamy,
                imagemAtirando[indiceTiroAtual].getWidth(), 0,
                0, imagemAtirando[indiceTiroAtual].getHeight(),
                null);
        }
        else{
            g.drawImage(imagemParado[indiceAtual],
                posx, posy,
                posx + tamx, posy + tamy,
                 imagemParado[indiceAtual].getWidth(), 0, 
                0, imagemParado[indiceAtual].getHeight(),
                null);
             }
    }
    
    public void setPosy(int posy) {
        this.posy += posy;
    }

    public int getPosy() {
        return posy;
    }
    

    public int getTamx() {
        return tamx;
    }

    public int getTamy() {
        return tamy;
    }
}