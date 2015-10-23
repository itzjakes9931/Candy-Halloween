package minhasClasses;

import java.awt.Color;
import java.awt.Graphics2D;

import minhasClasses.Componente;

public class Barra extends Componente {

	public int altura;
	public int largura;
	public Color cor;
	public int larguraAtual;
	public Barra(float x, float y,int largura,int altura,Color cor) {
		super(x, y);
		
		this.largura=largura;
		this.altura=altura;
		this.cor=cor;
		this.larguraAtual = largura-10;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float time, int vidaAtual, int vidaMax) {
		// TODO Auto-generated method stub

		larguraAtual = (largura-10)*vidaAtual/vidaMax;
	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		// TODO Auto-generated method stub
		//borda
		dbg.setColor(Color.gray);
		dbg.fillRect((int)x-35, (int)y-10, largura, altura);
		//barra
		dbg.setColor(cor);
		dbg.fillRect((int)x+5-35, (int)y-10, larguraAtual, altura);
		
		
	}

}
