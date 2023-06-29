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
public class RoboAtirandoPulando {
	
	private BufferedImage[] animacaoAtiraPulando;
	private int indice;
	private int cont;

	public RoboAtirandoPulando() {
		animacaoAtiraPulando = new BufferedImage[5];

		try {
			for (int i = 0; i < 5; i++) {
				String imagem = "imagensRobo/JumpShoot (" + (i + 1) + ").png";
				System.out.println("Carregando a imagem: " + imagem);
				animacaoAtiraPulando[i] = ImageIO.read(new File(imagem));
			}

		} catch (Exception e) {
			System.out.println("Não foi possível carregar as imagens do robo atirando pulando");

		}
	}

	public void atualizar(Robo robo) {
		cont++;
		if (cont >= 5) {
			indice++;
			if (indice >= 5) {
				indice = 0;
				// atirando = false;
				robo.setAtirando(false);
			}
			cont = 0;
		}
	}

	public void pintar(Robo robo, Graphics2D g) {
		if (robo.getUltimaDirecao() == 1) {
			// if(heroi.getDirecao() == 0){
			g.drawImage(animacaoAtiraPulando[indice], robo.getPosx(), robo.getPosy(),
					robo.getPosx() + robo.getLargura(), robo.getPosy() + robo.getAltura(), 0, 0,
					animacaoAtiraPulando[indice].getWidth(), animacaoAtiraPulando[indice].getHeight(), null);
			// }
		} else if (robo.getUltimaDirecao() == -1) {
			// if(heroi.getDirecao() == 0){
			g.drawImage(animacaoAtiraPulando[indice], robo.getPosx(), robo.getPosy(),
					robo.getPosx() + robo.getLargura(), robo.getPosy() + robo.getAltura(),
					animacaoAtiraPulando[indice].getWidth(), 0, 0, animacaoAtiraPulando[indice].getHeight(), null);
			// }
		}
	}
}
