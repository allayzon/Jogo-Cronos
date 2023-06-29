/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodjogo5.Inimigos;
import prodjogo4.Robo.Robo;
import java.awt.Graphics2D;
/**
 *
 * @author Leonardo
 */
public class InimigoDino {
    private int indice;
    private int cont;
    private int direcao;
    private int ultimaDirecao;
    private int posx;
    private int posy;
    private int largura;
    private int altura;
    private DinoCorrendo dinoCorrendo;
    private DinoParado dinoParado;
    private boolean estaNoChao;
    public int tempoPulo;
    public int posy0;
    
    public InimigoDino(int posx, int posy){
        direcao = 0;
        ultimaDirecao = -1;
        this.posx = posx;
        this.posy = posy;
        altura = 150;
        largura = 150;
        dinoParado = new DinoParado();
        dinoCorrendo = new DinoCorrendo();
        estaNoChao = true;
        tempoPulo = 0;
        posy0 = 0;
        
    }

    
    public void setDirecao(int direcao) {
        if(direcao != 0){
            ultimaDirecao = direcao;
            this.direcao = direcao;
        }else{
            this.direcao = direcao;
        }
    } 
    
    public void encontrouChao(){
        this.setEstaNoChao(true);
        this.posy0 = this.getPosy();
    }
    
    public boolean collideMelle(Robo heroi){
        if(heroi.getPosx() > this.getPosx() - 50 && heroi.getPosx() < this.getPosx() + 80 ){
            if(heroi.getPosy() > this.getPosy() - 130 && heroi.getPosy() < this.getPosy() + 10){
                return true;
            }
        }
        return false;
    }
        
    public int getUltimaDirecao() {
        return ultimaDirecao;
    }
    
    public void atualizar(Robo heroi){
        if(heroi.getPosx() > getPosx() - 400){
            dinoCorrendo.atualizar(this);
        }if(estaNoChao == false){          
            setPosy((int) (posy0 - (-1 * tempoPulo * tempoPulo)/2));
            dinoParado.atualizar();
            tempoPulo++;
        }else{
            dinoParado.atualizar();
            tempoPulo = 0;
        }         
    }
    
    public void pintar(Graphics2D g, Robo heroi){
        if(heroi.getPosx() > getPosx() - 400){
            dinoCorrendo.pintar(g, this);
        }     
        else{
            dinoParado.pintar(g, this);
        }
    }
    public void setPosy(int posy) {
        this.posy = posy;
    }
   
    public void setEstaNoChao(boolean estaNoChao) {
        this.estaNoChao = estaNoChao;
    }

    public void setPosx(int posx) {
        this.posx += posx;
    }
    
    
    public int getDirecao() {
        return direcao;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
}
