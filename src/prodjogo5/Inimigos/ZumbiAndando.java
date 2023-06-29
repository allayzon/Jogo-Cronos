/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodjogo5.Inimigos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Leonardo
 */
public class ZumbiAndando {
    private int cont;
    private int indice;
    private BufferedImage[] imagemZumbiAndando;
    int vasco;
    public ZumbiAndando(){
        vasco = 0;
        cont = 0;
        indice = 0;
        imagemZumbiAndando = new BufferedImage[9];    
    }
    public void carregarZumbi(InimigoZombie zumbi){
        if(zumbi.tipo == 1){  
            try{
                for(int i = 0; i < 9; i++){
                    String imagem = "zumbicerto/Walk (" + (i + 1) + ").png";
                    System.out.println("carregando a imagem " + imagem);
                    imagemZumbiAndando[i] = ImageIO.read(new File(imagem));
                }
            }catch (Exception e){
                System.out.println("Não foi possivel carregar as imagens do zumbi Andando");
            } 
        }else if (zumbi.tipo == 2){
            try{
                for(int i = 0; i < 9; i++){
                    String imagem = "zumbicerto2/Walk (" + (i + 1) + ").png";
                    System.out.println("carregando a imagem " + imagem);
                    imagemZumbiAndando[i] = ImageIO.read(new File(imagem));
                }
            }catch (Exception e){
                System.out.println("Não foi possivel carregar as imagens do zumbi 2 Andando");
            } 
        }
    }
    public void contador(){
        cont++;
             if(cont>= 6){
                 indice++;
                 if(indice >= 9){
                     indice = 0;
                 }
              
                 cont = 0;
                 }
    }
    
    public  void atualizar(InimigoZombie zumbi){    
        if(zumbi.getDirecao() == 1){
            zumbi.setPosx(zumbi.getPosx() + 1); 
            contador();
            if(zumbi.getPosx() == zumbi.getChaoMaior()){
                zumbi.setDirecao(-1);
            }
        }else if (zumbi.getDirecao() == -1) {
            zumbi.setPosx(zumbi.getPosx() -1); 
            contador();
            if(zumbi.getPosx() == zumbi.getChaoMenor()){
                zumbi.setDirecao(1);
            }
        }  
    }
    
    public void pintar(Graphics2D g, InimigoZombie zumbi){
            if(zumbi.getUltimaDirecao() == 1){
                g.drawImage(imagemZumbiAndando[indice],
                    zumbi.getPosx(), zumbi.getPosy(),
                    zumbi.getPosx() + zumbi.getLargura(), zumbi.getPosy() + zumbi.getAltura(),
                    0, 0, 
                    imagemZumbiAndando[indice].getWidth(), imagemZumbiAndando[indice].getHeight(),
                    null);
            } else if(zumbi.getUltimaDirecao() == -1){ 
                g.drawImage(
                        imagemZumbiAndando[indice],
                        zumbi.getPosx(), zumbi.getPosy(),
                        zumbi.getPosx() + zumbi.getLargura(), zumbi.getPosy() + zumbi.getAltura(),
                        imagemZumbiAndando[indice].getWidth(), 0, 
                        0, imagemZumbiAndando[indice].getHeight(),
                        null);    
            }
    }
}
