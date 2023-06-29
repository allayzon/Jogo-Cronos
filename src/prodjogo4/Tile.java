package prodjogo4;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	int posx, posy;
	int tamx, tamy;
	int indice;
	BufferedImage imagem;
	
	public Tile(BufferedImage imagem, int posx, int posy, int tamx, int tamy, int indice) {
		
		this.imagem = imagem;
		this.posx = posx;
		this.posy = posy;
		this.tamx = tamx;
		this.tamy = tamy;
		this.indice = indice;
		
	}
	
	public void pintar(Graphics g, int translacao) {
		
		g.drawImage(imagem,				 // imagem que ser� desenhada
				posx - translacao, posy, 				 // posicao
				posx + tamx - translacao, posy + tamy,			 // posicao + tamanho
				0, 0, 							 // inicio da imagem original
				imagem.getWidth(), 		 // fim da imagem original
				imagem.getHeight(),
				null);
	}
	
	@Override
	public String toString() {
		return indice + " " + posx + " " + posy + " " + tamx + " " + tamy;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getTamx() {
		return tamx;
	}

	public void setTamx(int tamx) {
		this.tamx = tamx;
	}

	public int getTamy() {
		return tamy;
	}

	public void setTamy(int tamy) {
		this.tamy = tamy;
	}
	
	public int getIndice() {
		return indice;
	}
	
}
