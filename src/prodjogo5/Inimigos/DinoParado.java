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
public class DinoParado {
    private int cont;
    private int indice;
    private BufferedImage[] imagemDinoParado;
    
    public DinoParado(){
        cont = 0;
        indice = 0;
        imagemDinoParado = new BufferedImage[10];
        try{
            for(int i = 0; i < 10; i++){
                String imagem = "imagensDino/Idle (" + (i + 1) + ").png";
                System.out.println("carregando a imagem " + imagem);
                imagemDinoParado[i] = ImageIO.read(new File(imagem));
            }
        }catch (Exception e){
            System.out.println("Não foi possivel carregar as imagens do dino Parado");
        }   
    }
    
    public void atualizar(){
        cont++;
        if(cont>= 4){
            indice++;
            if(indice >= 10){
                indice = 0;
            }
            cont = 0;
            }
    }
    
    public void pintar(Graphics2D g, InimigoDino dino){
        if(dino.getUltimaDirecao() == 1){
            g.drawImage(imagemDinoParado[indice],
                dino.getPosx(), dino.getPosy(),
                dino.getPosx() + dino.getLargura(), dino.getPosy() + dino.getAltura(),
                0, 0, 
                imagemDinoParado[indice].getWidth(), imagemDinoParado[indice].getHeight(),
                null);
        }else if(dino.getUltimaDirecao() == -1){
             g.drawImage(
                imagemDinoParado[indice],
                dino.getPosx(), dino.getPosy(),
                dino.getPosx() + dino.getLargura(), dino.getPosy() + dino.getAltura(),
                imagemDinoParado[indice].getWidth(), 0, 
                0, imagemDinoParado[indice].getHeight(),
                null);   
            
        }
    }
    
}
