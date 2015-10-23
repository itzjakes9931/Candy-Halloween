package minhasClasses;

import java.awt.Color;
import java.awt.Graphics2D;

public class Tabuleiro extends Componente{
public int linhas;
public int colunas;
public int largura;
public int altura;
public int quaX;
public int quaY;
int quaT;
                                 // quadrado segue o mouse
	public Tabuleiro(float x, float y, int largura, int altura, int colunas,
			int linhas) {
		super(x, y);
		this.largura=largura;
		this.altura=altura;
		this.colunas=colunas;
		this.linhas=linhas;
		quaT = 30;
	}
	
	public boolean colideTabuleiro(int mousex, int mousey){
		if (mousex < x + largura && mousex > x)
			if(mousey<y+altura && mousey>y)
				return true;
		
		return false;
	}

	@Override
	public void update(float time, int cameraX, int cameraY) {
		// TODO Auto-generated method stub
		quaX = cameraX;
		quaY = cameraY;
		
	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		// TODO Auto-generated method stub
		dbg.setColor(Color.white);
		// quadrado mouse
		dbg.fillRect(quaX,quaY,quaT,quaT);
		//bordas
		dbg.drawRect((int)x, (int)y,largura,altura);
		//linhas e colunas
		int auy = 0;
		for (int i = 0; i < linhas; i++){
			dbg.drawLine((int)x,(int)y+auy,largura+(int)x,(int)y+auy);
			auy+= altura/linhas;
		}
		int aux = 0;
		for (int i = 0; i < linhas; i++){
			dbg.drawLine((int)x+aux,(int)y,(int)x+aux,(int)y+altura);
			aux+= largura/colunas;
		}
		
	}
	
}