package telas;

import gameMain.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import stuff.Button;
import stuff.ButtonManager;

public class ComoJogar implements Screen {
	ButtonManager ComoJogarVoltar;
	public ComoJogar(){
		ComoJogarVoltar = new ButtonManager();
		ComoJogarVoltar.add(new Button(500, 400, // tamanho da tela (x e y)
				100, 25, //largura e altura 
				1, "Back", //tarefa e o texto 
				Color.green, true, //cor e o estado do botï¿½o 
				null)); //
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Como Jogar";
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		switch(ComoJogarVoltar.TASK){
		case 1:
			ComoJogarVoltar.get(0).x-=20;
            System.out.println(ComoJogarVoltar);
			GamePanel.screen = new Inicial();
			ComoJogarVoltar.TASK=0;
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
		ComoJogarVoltar.pressed(e.getX(), e.getY());

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
		dbg.drawString("-> Para andar, clique em um quadrado do tabuleiro;",400,70);
		dbg.drawString("-> Há apenas 2 personagens para cada jogador;",400,90);
		dbg.drawString("-> Os personagens têm um limite máximo",400,110);
		dbg.drawString("de 3 casas ao redor do mesmo;",400,130);
		dbg.drawString("-> Chegue perto de algum inimigo para atacá-lo;",400,150);
		dbg.drawString("-> A primeira equipe a morrer perde..",400,170);
		ComoJogarVoltar.draw(dbg,0,0);

	}
}