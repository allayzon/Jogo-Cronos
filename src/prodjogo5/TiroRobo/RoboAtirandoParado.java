/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodjogo5.TiroRobo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import prodjogo4.Robo.Robo;

/**
 *
 * @author Leonardo
 */
public class RoboAtirandoParado
{
    private int indiceTiroAtual;
    private int timer;
    private BufferedImage[] AnimacaoAtiraParado;
    public RoboAtirandoParado(){
        indiceTiroAtual = 0;
        timer = 0;
        AnimacaoAtiraParado = new BufferedImage[4];
        try{
            for(int i = 0; i < 4; i++){
                String imagem = "imagensRobo/Shoot (" + (i + 1) + ").png";
                System.out.println("Carregando a imagem: " + imagem);
                AnimacaoAtiraParado[i] = ImageIO.read(new File(imagem));
            }
    
        }catch(Exception e){
            System.out.println("Não foi possível carregar as imagens do robo parado");
                    
            } 
        }
    
      public void atualizar(Robo robo) {
        timer++;
                if(timer >= 4){
                    indiceTiroAtual++;
                    if(indiceTiroAtual >= 4){
                        indiceTiroAtual = 0;
                     //   atirando = false;
                        robo.setAtirando(false);
                    }
                    timer = 0;
                }
    }

   

    public void pintar(Robo heroi, Graphics2D g) {
            if(heroi.getUltimaDirecao() == 1){
       //         if(heroi.getDirecao() == 0){
                g.drawImage(AnimacaoAtiraParado[indiceTiroAtual],
                heroi.getPosx(), heroi.getPosy(),
                heroi.getPosx() + heroi.getLargura(), heroi.getPosy() + heroi.getAltura(),
                0, 0, 
                AnimacaoAtiraParado[indiceTiroAtual].getWidth(), AnimacaoAtiraParado[indiceTiroAtual].getHeight(),
                null);
        //        }
        }else if(heroi.getUltimaDirecao() == -1){
    //        if(heroi.getDirecao() == 0){
            g.drawImage(AnimacaoAtiraParado[indiceTiroAtual],
                heroi.getPosx(), heroi.getPosy(),
                heroi.getPosx() + heroi.getLargura(), heroi.getPosy() + heroi.getAltura(),
                AnimacaoAtiraParado[indiceTiroAtual].getWidth(), 0,
                0, AnimacaoAtiraParado[indiceTiroAtual].getHeight(),
                null);
        //    }  
        }
        
    }
      
}
