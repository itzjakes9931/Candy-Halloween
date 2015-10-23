package telas;

import gameMain.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import stuff.Button;
import stuff.ButtonManager;
public class Inicial implements Screen{
	
	
	ButtonManager gerenciadorDeBotoes;
	ButtonManager gerenciadorDosCreditos;
	ButtonManager gerenciadorDasInstrucoes;
	ButtonManager exit;
	BufferedImage img;
	
	public Inicial(){
		
		img = AbreImagem("/Imagens/MenuInicial.png");
		
		gerenciadorDeBotoes = new ButtonManager();
		gerenciadorDeBotoes.add(new Button(500, 300, // tamanho da tela (x e y)
				125, 25, //largura e altura 
				1, "Jogar :)", //tarefa e o texto 
				Color.green, true, //cor e o estado do botï¿½o 
				null)); //
		gerenciadorDosCreditos = new ButtonManager();
		gerenciadorDosCreditos.add(new Button(500, 350, // tamanho da tela (x e y)
				125, 25, //largura e altura 
				1, "Créditos", //tarefa e o texto 
				Color.green, true, //cor e o estado do botï¿½o 
				null)); //
		gerenciadorDasInstrucoes = new ButtonManager();
		gerenciadorDasInstrucoes.add(new Button(500, 400, // tamanho da tela (x e y)
				125, 25, //largura e altura 
				1, "Como jogar", //tarefa e o texto 
				Color.green, true, //cor e o estado do botï¿½o 
				null)); //
		exit = new ButtonManager();
		exit.add(new Button(500, 450, // tamanho da tela (x e y)
				125, 25, //largura e altura 
				1, "Sair :(", //tarefa e o texto 
				Color.red, true, //cor e o estado do botï¿½o 
				null)); //
	}
	




	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Menu inicial";
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		switch (gerenciadorDeBotoes.TASK) {
		case 1:
			//gerenciadorDeBotoes.get(0).x-=20;
			GamePanel.screen = new JogoDaSa();
			
			gerenciadorDeBotoes.TASK=0;
			break;
		default:
			break;
		}
		switch(gerenciadorDosCreditos.TASK){
		case 1:
			//gerenciadorDosCreditos.get(0).x-=20;
            System.out.println(gerenciadorDosCreditos);
			GamePanel.screen = new Credits();
			gerenciadorDosCreditos.TASK=0;
			break;

		}
		switch(gerenciadorDasInstrucoes.TASK){
		case 1:
			//gerenciadorDasInstrucoes.get(0).x-=20;
            System.out.println(gerenciadorDasInstrucoes);
			GamePanel.screen = new ComoJogar();
			gerenciadorDasInstrucoes.TASK=0;
			break;

		}
		switch(exit.TASK){
		case 1:
			//exit.get(0).x-=20;
            System.out.println(exit);
			GamePanel.gameOver = true;
			exit.TASK=0;
			break;

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		gerenciadorDeBotoes.pressed(e.getX(), e.getY());
		gerenciadorDosCreditos.pressed(e.getX(), e.getY());
		gerenciadorDasInstrucoes.pressed(e.getX(), e.getY());
		exit.pressed(e.getX(), e.getY());
	}

	@Override
	public void onMouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseMove(int x, int y) {
            
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D dbg) {
		// TODO Auto-generated method stub
		dbg.setFont(new Font("", Font.CENTER_BASELINE,15));
		dbg.drawString("Menu de testes", 490, 100);
		gerenciadorDeBotoes.draw(dbg,0,0);
		gerenciadorDosCreditos.draw(dbg,0,0);
		gerenciadorDasInstrucoes.draw(dbg,0,0);
		exit.draw(dbg,0,0);
		
	}
	 public BufferedImage AbreImagem(String path){
	    	BufferedImage image = null;
	    	try {
	    		BufferedImage imgtmp = ImageIO.read( getClass().getResource(path) );
	    		image = new BufferedImage(imgtmp.getWidth(), imgtmp.getHeight(), BufferedImage.TYPE_INT_ARGB);
	    		image.getGraphics().drawImage(imgtmp, 0,0,null);
	    		imgtmp = null;
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	
	    	return image;
	    }
}
