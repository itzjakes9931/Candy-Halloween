package telas;

import gameMain.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import stuff.Button;
import stuff.ButtonManager;

public class Credits implements Screen {
	ButtonManager botaoVoltar;
	public Credits(){
		botaoVoltar = new ButtonManager();
		botaoVoltar.add(new Button(500, 400, // tamanho da tela (x e y)
				100, 25, //largura e altura 
				1, "Back", //tarefa e o texto 
				Color.green, true, //cor e o estado do botão 
				null)); //
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Créditos";
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		switch(botaoVoltar.TASK){
		case 1:
			botaoVoltar.get(0).x-=20;
            System.out.println(botaoVoltar);
			GamePanel.screen = new Inicial();
			botaoVoltar.TASK=0;
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
		botaoVoltar.pressed(e.getX(), e.getY());

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
		dbg.drawString("Créditos...",500,100);
		dbg.drawString("Programador:",500,180);
		dbg.drawString("Victor Swoboda Neto",500,200);
		dbg.drawString("Designer:",500,300);
		dbg.drawString("João pedro costa",500,320);
		dbg.drawString("Software used:",500,220);
		dbg.drawString("Eclipse Luna.",500,240);
		dbg.drawString("Softwares used:",500,340);
		dbg.drawString("Autodesk 3DS MAX;",500,360);
		dbg.drawString("Adobe Illustrator.",500,380);
		botaoVoltar.draw(dbg,0,0);

	}

}
