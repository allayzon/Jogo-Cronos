/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodjogo5.Inimigos;

//import TesteSegunda.AnimacaoMorrendo;
//import TesteSegunda.Personagem;
//import TesteSegunda.SistemaChao;
import prodjogo4.Robo.Robo;
import java.awt.Graphics2D;

/**
 *
 * @author Leonardo
 */
public class InimigoZombie {
    private int indice;
    private int cont;
    private int direcao;
    private int ultimaDirecao;
    private int posx;
    private int posy;
    private int largura;
    private int altura;
    private boolean morreu;
 // private ZumbiParado anime;
    private ZumbiAndando zumbiAndando;
    private ZumbiMorrendo zumbiMorrendo;
    private ZumbiAtaque zumbiAtaque;
    private int vasco;
    private boolean atacando;
    int tempo = 0;
    private int chaoMenor;
    private int chaoMaior;
    private boolean estaNoChao;
    int tipo = 0;

    
     public InimigoZombie(int inicialX, int inicialY,  int chaoMenor, int chaoMaior, int tipo){
         this.tipo = tipo;
         estaNoChao = true;
         this.chaoMenor = chaoMenor;
         this.chaoMaior = chaoMaior;
         zumbiAtaque = new ZumbiAtaque();
         
         atacando = false;
         morreu = false;
     //   anime = new ZumbiParado();
        zumbiAndando = new ZumbiAndando();
        zumbiMorrendo = new ZumbiMorrendo();
        
        zumbiAtaque.carregarZumbi(this);
        zumbiMorrendo.carregarZumbi(this);
        zumbiAndando.carregarZumbi(this);
        ultimaDirecao = 1;
        direcao = 1;
        this.posx = inicialX;
        this.posy = inicialY;
        largura = 150;
        altura = 150;
        cont = 0;
    }
    
    
    public void atacar(Robo heroi){
        if(heroi.getPosx() == this.getPosx() - 40 && this.getDirecao() == -1 || heroi.getPosx() == this.getPosx() + 40 && this.getDirecao() == 1){
            if(heroi.getPosy() > this.getPosy() - 130 && heroi.getPosy() < this.getPosy() + 10){
            setAtaque(true);
            }
        }else{
            setAtaque(false);
        }
    }
    
    
    
    public void atualizar(Robo heroi){
        atacar(heroi);
        
        if(isMorreu() == true){
            zumbiMorrendo.atualizar();  
        }else if(estaNoChao == false){        
                setPosy(5);
        }
        else if(isAtacando() == true){
           zumbiAtaque.atualizar();
           heroi.setMorreu(true);
           tempo++;
           if(tempo >= 50){
                heroi.reiniciarRobo();
                tempo = 0;
            }                     
        }
        else{
            zumbiAndando.atualizar(this);
        }
    }
    
    public void pintar(Graphics2D g){
        if(isMorreu() == true){
          zumbiMorrendo.pintar(g, this);
        }else if(isAtacando() == true){
           zumbiAtaque.pintar(g, this);
        }else{
        zumbiAndando.pintar(g, this);
        }
    }
    
    public int getUltimaDirecao() {
        return ultimaDirecao;
    }

    public void setDirecao(int direcao) {
        if(direcao != 0){
            ultimaDirecao = direcao;
            this.direcao = direcao;
        }else{
            this.direcao = direcao;
        }
    }
    
    public void setPosy(int posy) {
        this.posy += posy;
    }
    
    public void setEstaNoChao(boolean estaNoChao) {
        this.estaNoChao = estaNoChao;
    }
    
    public int getPosx() {
        return posx;
    }

    public int getChaoMenor() {
        return chaoMenor;
    }

    public int getChaoMaior() {
        return chaoMaior;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }
    
    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
    
     public int getDirecao() {
        return direcao;
    }
      public void morra(){
        morreu = true;
    }
    public boolean isMorreu() {
        return morreu;
    }
    
     public boolean isAtacando() {
        return atacando;
    }
     public void encontrouChao(){   
        this.setEstaNoChao(true);
    }
     public void setAtaque(boolean ataque) {
        this.atacando = ataque;
    }
     
}
