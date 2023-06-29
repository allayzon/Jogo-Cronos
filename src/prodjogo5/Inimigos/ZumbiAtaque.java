/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodjogo5.Inimigos;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Leonardo
 */
public class ZumbiAtaque {
    private int cont;
    private int indice;
    private BufferedImage[] imagemZumbiAtaque;
    int vasco;
    public ZumbiAtaque(){
        vasco = 0;
        cont = 0;
        indice = 0;
        imagemZumbiAtaque = new BufferedImage[8]; 
    }
    
   public void carregarZumbi(InimigoZombie zumbi){
        if(zumbi.tipo == 1){  
            try{
                for(int i = 0; i < 8; i++){
                    String imagem = "zumbicerto/Attack (" + (i + 1) + ").png";
                    System.out.println("carregando a imagem " + imagem);
                    imagemZumbiAtaque[i] = ImageIO.read(new File(imagem));
                }
            }catch (Exception e){
                System.out.println("Não foi possivel carregar as imagens do zumbi atacando");
            } 
        }else if (zumbi.tipo == 2){
            try{
                for(int i = 0; i < 8; i++){
                    String imagem = "zumbicerto2/Attack (" + (i + 1) + ").png";
                    System.out.println("carregando a imagem " + imagem);
                    imagemZumbiAtaque[i] = ImageIO.read(new File(imagem));
                }
            }catch (Exception e){
                System.out.println("Não foi possivel carregar as imagens do zumbi atacando");
            } 
        }
    }
    
    
    public  void atualizar(){
        
            cont++;
             if(cont>= 6){
                 indice++;
                 if(indice >= 8){
                     indice = 0;
                 }
              
                 cont = 0;
                 }
        
    }
    
    public void pintar(Graphics2D g, InimigoZombie zumbi){
            if(zumbi.getUltimaDirecao() == 1){
                g.drawImage(imagemZumbiAtaque[indice],
                    zumbi.getPosx(), zumbi.getPosy(),
                    zumbi.getPosx() + zumbi.getLargura(), zumbi.getPosy() + zumbi.getAltura(),
                    0, 0, 
                    imagemZumbiAtaque[indice].getWidth(), imagemZumbiAtaque[indice].getHeight(),
                    null);
            } else if(zumbi.getUltimaDirecao() == -1){ 
                g.drawImage(
                        imagemZumbiAtaque[indice],
                        zumbi.getPosx(), zumbi.getPosy(),
                        zumbi.getPosx() + zumbi.getLargura(), zumbi.getPosy() + zumbi.getAltura(),
                        imagemZumbiAtaque[indice].getWidth(), 0, 
                        0, imagemZumbiAtaque[indice].getHeight(),
                        null);    
            }
    }
}
