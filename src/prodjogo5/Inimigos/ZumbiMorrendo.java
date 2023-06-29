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
public class ZumbiMorrendo {
    private int cont;
    private int indice;
    private BufferedImage[] imagemZumbiMorrendo;

    public ZumbiMorrendo(){
        cont = 0;
        indice = 0;
        imagemZumbiMorrendo = new BufferedImage[9];
    }
    public void carregarZumbi(InimigoZombie zumbi){
        if(zumbi.tipo == 1){  
            try{
            for(int i = 0; i < 9; i++){
                String imagem = "zumbicerto/Dead (" + (i + 1) + ").png";
                System.out.println("carregando a imagem " + imagem);
                imagemZumbiMorrendo[i] = ImageIO.read(new File(imagem));
            }
        }catch (Exception e){
            System.out.println("Não foi possivel carregar as imagens do zumbi Parado");
        } 
        }else if (zumbi.tipo == 2){
            try{
            for(int i = 0; i < 9; i++){
                String imagem = "zumbicerto2/Dead (" + (i + 1) + ").png";
                System.out.println("carregando a imagem " + imagem);
                imagemZumbiMorrendo[i] = ImageIO.read(new File(imagem));
            }
        }catch (Exception e){
            System.out.println("Não foi possivel carregar as imagens do zumbi Parado");
        } 
        }
    }
    
    public void atualizar(){
        cont++;
        if(cont>= 6){
            indice++;
            if(indice >= 9){
                indice = 8;
            }
            cont = 0;
            }
    }
    
    public void pintar(Graphics2D g, InimigoZombie zumbi){
        if(zumbi.getUltimaDirecao() == 1){
            
            g.drawImage(imagemZumbiMorrendo[indice],
                    zumbi.getPosx(), zumbi.getPosy(),
                    zumbi.getPosx() + zumbi.getLargura() + 10, zumbi.getPosy() + zumbi.getAltura() + 10,
                    0, 0, 
                    imagemZumbiMorrendo[indice].getWidth(), imagemZumbiMorrendo[indice].getHeight(),
                    null);
            
        }else if(zumbi.getUltimaDirecao() == -1){
               g.drawImage(imagemZumbiMorrendo[indice],
                    zumbi.getPosx(), zumbi.getPosy(),
                    zumbi.getPosx() + zumbi.getLargura() + 10, zumbi.getPosy() + zumbi.getAltura() + 10,
                    imagemZumbiMorrendo[indice].getWidth(), 0,
                    0, imagemZumbiMorrendo[indice].getHeight(),
                    null);
            
        }
        
    }
}
