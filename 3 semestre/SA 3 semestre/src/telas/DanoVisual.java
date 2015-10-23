package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import minhasClasses.Componente;

public class DanoVisual extends Componente{
	
	int tempo; 
	String texto;
	int aux;
	boolean isVivo;
	public int alpha;

	public DanoVisual(float x, float y, float tempo, String texto) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.tempo=(int) tempo;
		this.texto=texto;
		isVivo=true;
		alpha=255;
		
	}

	@Override
	public void update(float time, int cameraX, int cameraY) {
		// TODO Auto-generated method stub
		alpha--;
		if (alpha < 0){
			alpha = 0;
		}
		aux += time;
		if (aux>=tempo){
			isVivo= false;
		}
		
	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		// TODO Auto-generated method stub
		dbg.setFont(new Font ("",Font.BOLD, 80));
		dbg.setColor(new Color(255,0,0,alpha));
		dbg.drawString(texto, x, y);
		
	}

}
