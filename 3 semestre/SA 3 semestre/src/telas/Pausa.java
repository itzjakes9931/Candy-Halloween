package telas;

import gameMain.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import stuff.Button;
import stuff.ButtonManager;

public class Pausa implements Screen {
	ButtonManager VoltarJogo;
	ButtonManager Opcoes;
	ButtonManager SairJogo;
	public Pausa(){
		VoltarJogo = new ButtonManager();
		VoltarJogo.add(new Button(500, 300, // tamanho da tela (x e y)
				150, 25, //largura e altura 
				1, "Voltar ao jogo", //tarefa e o texto 
				Color.green, true, //cor e o estado do botï¿½o 
				null)); //
		Opcoes = new ButtonManager();
		Opcoes.add(new Button(500, 350, // tamanho da tela (x e y)
				150, 25, //largura e altura 
				1, "Opções", //tarefa e o texto 
				Color.green, true, //cor e o estado do botï¿½o 
				null)); //
		SairJogo = new ButtonManager();
		SairJogo.add(new Button(500, 400, // tamanho da tela (x e y)
				150, 25, //largura e altura 
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
		switch (VoltarJogo.TASK) {
		case 1:
			//gerenciadorDeBotoes.get(0).x-=20;
			GamePanel.screen = new JogoDaSa();
			
			VoltarJogo.TASK=0;
			break;
		default:
			break;
		}
		switch(Opcoes.TASK){
		case 1:
			//gerenciadorDosCreditos.get(0).x-=20;
            System.out.println(Opcoes);
			GamePanel.screen = new Opcoes();
			Opcoes.TASK=0;
			break;

		}
		switch(SairJogo.TASK){
		case 1:
			//gerenciadorDasInstrucoes.get(0).x-=20;
            System.out.println(SairJogo);
			GamePanel.screen = new Inicial();
			SairJogo.TASK=0;
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
		VoltarJogo.pressed(e.getX(), e.getY());
		Opcoes.pressed(e.getX(), e.getY());
		SairJogo.pressed(e.getX(), e.getY());
		
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
		dbg.setFont(new Font("", Font.CENTER_BASELINE,20));
		dbg.drawString("Menu de testes", 490, 100);
		VoltarJogo.draw(dbg,0,0);
		Opcoes.draw(dbg,0,0);
		SairJogo.draw(dbg,0,0);
		
	}

}
