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
public class DinoCorrendo {
    private int cont;
    private int indice;
    private BufferedImage[] imagemDinoCorrendo;
    
    public DinoCorrendo(){
        cont = 0;
        indice = 0;
        imagemDinoCorrendo = new BufferedImage[8];
        try{
            for(int i = 0; i < 8; i++){
                String imagem = "imagensDino/Run (" + (i + 1) + ").png";
                System.out.println("carregando a imagem " + imagem);
                imagemDinoCorrendo[i] = ImageIO.read(new File(imagem));
            }
        }catch (Exception e){
            System.out.println("Não foi possivel carregar as imagens do dino Parado");
        }   
    }
    public void contador(){
        cont++;
        if(cont>= 4){
            indice++;
            if(indice >= 8){
                indice = 0;
            }
            cont = 0;
            }
    }
     
    
    public void atualizar(InimigoDino dino){
        contador();
        dino.setPosx(-4);
    }
    
    public void pintar(Graphics2D g, InimigoDino dino){
        if(dino.getUltimaDirecao() == 1){
            g.drawImage(imagemDinoCorrendo[indice],
                    dino.getPosx(), dino.getPosy(),
                    dino.getPosx() + dino.getLargura(), dino.getPosy() + dino.getAltura(),
                    0, 0, 
                    imagemDinoCorrendo[indice].getWidth(), imagemDinoCorrendo[indice].getHeight(),
                    null);
        }else if(dino.getUltimaDirecao() == -1){
             g.drawImage(
                    imagemDinoCorrendo[indice],
                    dino.getPosx(), dino.getPosy(),
                    dino.getPosx() + dino.getLargura(), dino.getPosy() + dino.getAltura(),
                    imagemDinoCorrendo[indice].getWidth(), 0, 
                    0, imagemDinoCorrendo[indice].getHeight(),
                    null);   
            
        }
    }
    
}
