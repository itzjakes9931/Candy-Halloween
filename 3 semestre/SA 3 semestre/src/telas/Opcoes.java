package telas;

import gameMain.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import stuff.Button;
import stuff.ButtonManager;

public class Opcoes implements Screen {
	ButtonManager Voltar;
	
	public Opcoes(){
		Voltar = new ButtonManager();
		Voltar.add(new Button(500, 400, // tamanho da tela (x e y)
				125, 25, //largura e altura 
				1, "Sair do jogo", //tarefa e o texto 
				Color.green, true, //cor e o estado do botï¿½o 
				null)); //
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		switch(Voltar.TASK){
		case 1:
			//gerenciadorDasInstrucoes.get(0).x-=20;
            System.out.println(Voltar);
			GamePanel.screen = new Game();
			Voltar.TASK=0;
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
		Voltar.pressed(e.getX(), e.getY());
		
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
		dbg.drawString("Menu opções não criado", 540, 300);
		Voltar.draw(dbg,0,0);
		
	}

}
