/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodjogo4.Robo;

//import aula006.Cenario.Chao;
import prodjogo5.Inimigos.InimigoDino;
import prodjogo5.Inimigos.Inimigos;
//import TesteSegunda.Personagem;
import prodjogo5.Inimigos.InimigoZombie;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Leonardo
 */
public class Tiro {
	private int posx;
	private int posy;
	private int velocidade;
	private int direcao;
	private int indiceAtual;
	private int largura;
	private int altura;
	private static BufferedImage animacao[];

	public static void carregaImagens() {
		animacao = new BufferedImage[5];
		try {
			for (int i = 0; i < 5; i++) {
				String imagem = "imagensRobo/Objects/Bullet_00" + i + ".png";
				System.out.println("Carregando a imagem: " + imagem);
				animacao[i] = ImageIO.read(new File(imagem));
			}
		} catch (IOException e) {
			System.out.println("não foi possível carregar a imagem de tiro");
		}
	}

	public Tiro(int posx, int posy, int direcao) {
		this.posx = posx;
		this.posy = posy;
		this.direcao = direcao;
		this.velocidade = 10;
		this.indiceAtual = 0;
		this.altura = 25;
		this.largura = 25;
	}

	public Tiro(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
		this.velocidade = 3;
		this.indiceAtual = 0;
		this.altura = 25;
		this.largura = 25;
	}

	public boolean collide(Inimigos inimigo) {
		if (posx > inimigo.getPosx() && posx < inimigo.getPosx() + inimigo.getTamx()) {
			if (posy > inimigo.getPosy() && posy < inimigo.getPosy() + inimigo.getTamy()) {
				return true;
			}
		}
		return false;
	}

//    public boolean collideAmigo(Robo vasco){
//        if(posx > vasco.getPosx() && posx < vasco.getPosx() + vasco.getLargura()){
//            if(posy > vasco.getPosy() && posy < vasco.getPosy() + vasco.getAltura()){
//                return true;  
//            }
//        }
//        return false;
//    }
	public boolean collideHeroi(Robo heroi) {
		if (posx > heroi.getPosx() && posx < heroi.getPosx() + heroi.getLargura()) {
			if (posy > heroi.getPosy() && posy < heroi.getPosy() + heroi.getAltura()) {
				return true;
			}
		}
		return false;
	}

	public boolean collideDino(InimigoDino dino) {
		if (posx > dino.getPosx() && posx < dino.getPosx() + 100) {
			if (posy > dino.getPosy() && posy < dino.getPosy() + 150) {
				return true;
			}
		}
		return false;
	}
//    public boolean collideDino(InimigoDino dino){
//        // if(heroi.getPosx() > this.getPosx() - 20 && heroi.getPosx() < this.getPosx() + 20 ||  heroi.getPosx() == this.getPosx() + 20 ){
//
//            if(dino.getPosx() > posx - 50 && dino.getPosx() < this.getPosx() + 80 ){
//            if(dino.getPosy() > this.getPosy() - 130 && dino.getPosy() < this.getPosy() + 10){
////                return true;  
////                }   
//            return true;
//            }
//            }
//        
//        return false;
//    }

	public boolean collideZumbi(InimigoZombie zumbi) {
		if (posx > zumbi.getPosx() && posx < zumbi.getPosx() + zumbi.getLargura()) {
			if (posy > zumbi.getPosy() && posy < zumbi.getPosy() + zumbi.getAltura()) {
				return true;
			}
		}
		return false;
	}

//    public boolean collideChao(Chao chao){
//        if(posx > chao.posx && posx < chao.posy + chao.largura){
//            if(posy > chao.posy && posy < chao.posy + chao.altura){
//                return true;  
//            }
//        }
//        return false;
//    }

	public void atualizar() {
		posx += direcao * velocidade;
		indiceAtual++;
		if (indiceAtual >= 5) {
			indiceAtual = 0;
		}
	}

	public boolean deveSerRemovido() {
		if ((posx < 0 || posx > 1600)) {
			return true;
		}
		return false;
	}

	public void pintar(Graphics2D g) {
		if (direcao == 1) {
			g.drawImage(animacao[indiceAtual], posx, posy, posx + largura, posy + altura, 0, 0,
					animacao[indiceAtual].getWidth(), animacao[indiceAtual].getHeight(), null);

		} else if (direcao == -1) {
			g.drawImage(animacao[indiceAtual], posx, posy, posx + largura, posy + altura,
					animacao[indiceAtual].getWidth(), 0, 0, animacao[indiceAtual].getHeight(), null);
		}
	}

}
