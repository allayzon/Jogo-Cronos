/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodjogo5.TiroRobo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Leonardo
 */
public class RoboAtirandoCorrendo{
    private BufferedImage AnimacaoAtiraCorrendo[];
    private int timer;


    private int indiceTiroAtual;

    
    
    public RoboAtirandoCorrendo() {

        AnimacaoAtiraCorrendo = new BufferedImage[9];
        try{
        //IMAGENS DO ROBO correndo e atirando
                for (int i = 0; i < 9; i++) {   
                    String imagem = "imagensRobo/RunShoot (" + (i + 1) + ").png";
                    System.out.println("Carregando a imagem: " + imagem);
                    AnimacaoAtiraCorrendo[i] = ImageIO.read(new File(imagem));
                }
        }catch(Exception e ){
            System.out.println("Não foi possivel carregar as imagens atirando correndo");
        }
    }

    
    
    public void atualizar(prodjogo4.Robo.Robo robo) {
        timer++;
                if(timer >= 4){
                    indiceTiroAtual++;
                    if(indiceTiroAtual >= 9){
                        indiceTiroAtual = 0;
                     //   atirando = false;
                        robo.setAtirando(false);
                    }
                    timer = 0;
                }
    }

   

    public void pintar(prodjogo4.Robo.Robo robo, Graphics2D g) {
            if(robo.getUltimaDirecao() == 1){
                g.drawImage(AnimacaoAtiraCorrendo[indiceTiroAtual],
                robo.getPosx(), robo.getPosy(),
                robo.getPosx() + robo.getLargura(), robo.getPosy() + robo.getAltura(),
                0, 0, 
                AnimacaoAtiraCorrendo[indiceTiroAtual].getWidth(), AnimacaoAtiraCorrendo[indiceTiroAtual].getHeight(),
                null);
        }else if(robo.getUltimaDirecao() == -1){
            g.drawImage(AnimacaoAtiraCorrendo[indiceTiroAtual],
                robo.getPosx(), robo.getPosy(),
                robo.getPosx() + robo.getLargura(), robo.getPosy() + robo.getAltura(),
                AnimacaoAtiraCorrendo[indiceTiroAtual].getWidth(), 0,
                0, AnimacaoAtiraCorrendo[indiceTiroAtual].getHeight(),
                null);
            }  
        
    }
}