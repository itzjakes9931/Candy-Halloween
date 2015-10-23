package telas;

import gameMain.GamePanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Clock;
import java.util.ArrayList;

import static javafx.scene.paint.Color.color;
import minhasClasses.Bola;
import minhasClasses.Heroi;
import minhasClasses.Tabuleiro;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import stuff.Button;
import stuff.ButtonManager;

public class JogoDaSa implements Screen {

	boolean turno;
	boolean primeiro;

	String mensagem;
	String mensagem2;
	String mensagemDoTurno;
	Heroi p1, p2, p3, p4;

	// tabuleiro
	Tabuleiro tabuleiro;
	// x e y do mouse, para fazer o quadrado
	int mouseX, mouseY;
	public static int squareSizex;
	public static int squareSizey;

	int indexX;
	int indexY;

	ButtonManager botoes;
	ButtonManager botaoVoltar;

	ArrayList<DanoVisual> danosVisuais;

	// controle de batalha
	public boolean batalha;
	// auxiliar para batalhas
	Heroi auxiliar[] = new Heroi[2];
	Heroi daVez;
	Heroi alvo;

	public JogoDaSa() {
		batalha = false;
		daVez = null;
		alvo=null;
		botoes = new ButtonManager();
		botoes.add(new Button(70, 550, // tamanho da tela (x e y)
				100, 25, // largura e altura
				1, "Melee attack", // tarefa e o texto
				Color.red, true, // cor e o estado do bot�o
				null)); //
		botoes.add(new Button(200, 550, // tamanho da tela (x e y)
				100, 25, // largura e altura
				2, "Distance attack", // tarefa e o texto
				Color.red, true, // cor e o estado do bot�o
				null)); //

		// /botoes.add(new Button(600, 350, // tamanho da tela (x e y)
		// / 100, 25, //largura e altura
		// / 3, "Back", //tarefa e o texto
		// / Color.green, true, //cor e o estado do bot�o
		// null)); //
		botoes.add(new Button(600, 350, // tamanho da tela (x e y)
				100, 25, // largura e altura
				5, "Pausa", // tarefa e o texto
				Color.green, true, // cor e o estado do bot�o
				null)); //
		// TODO Auto-generated constructor stub
		botoes.setVisible(false, 0);
		botoes.setVisible(false, 1);
		// inicializa o dano quando atacar
		danosVisuais = new ArrayList<DanoVisual>();
		// Inicializando o objeto tabuleiro
		tabuleiro = new Tabuleiro(50, 50, 400, 400,// x,y,lar,alt
				10, 10);// colunas,linhas
		squareSizex = (tabuleiro.largura / tabuleiro.colunas);
		squareSizey = (tabuleiro.altura / tabuleiro.linhas);
		System.out.println("SquareSize: " + squareSizex);
		// cria uma matriz da minha classe Square
		mensagem = "|||||||||||||||||||||||||||||||||||||||";
		mensagem2 = "|||||||||||||||||||||||||||||||||||||||";
		mensagemDoTurno = "|||||||||||||||||||||||||||||||||||||||";
		p1 = new Heroi(0, 0, 9, 9, Color.red, 100, 1);
		// posicoes[p1.posX][p1.posY]=1;
		// setChaoParaAndar(p1.posX, p1.posY, 10);
		p2 = new Heroi(0, 0, 0, 9, Color.blue, 100, 1);
		// posicoes[p2.posX][p2.posY]=1;
		// setChaoParaAndar(p2.posX, p2.posY, 20);
		p3 = new Heroi(0, 0, 9, 0, Color.green, 100, 2);
		// posicoes[p3.posX][p3.posY]=1;
		// setChaoParaAndar(p3.posX, p3.posY, 30);
		p4 = new Heroi(0, 0, 0, 0, Color.yellow, 100, 2);
		// posicoes[p4.posX][p4.posY]=1;
		// setChaoParaAndar(p4.posX, p4.posY, 40);
		// turno = false = X
		turno = true;
		primeiro = true;

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Game";
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		
		
		for (int i = 0; i < danosVisuais.size(); i++) {
			danosVisuais.get(i).update(time, 0, 0);
			if (!danosVisuais.get(i).isVivo) {
				danosVisuais.remove(i);
				break;
			}
		}

		float timeCerto = time;

		p1.update(timeCerto, 0, 0);
		p2.update(timeCerto, 0, 0);
		p3.update(timeCerto, 0, 0);
		p4.update(timeCerto, 0, 0);
		switch (botoes.TASK) {
		case 1:// Melee attack
				// botoes.get(0).x-=20;
			if(alvo!=null){
				alvo.Ataque(daVez.dano);
				//alvo deixa de ser selecionado ou selecionavel.
				auxiliar[0].selecionado=false;
				auxiliar[0].selecionavel=false;
				if(auxiliar[1]!=null){
					auxiliar[1].selecionado=false;
					auxiliar[1].selecionavel=false;
				}
				//esquece o alvo
				alvo=null;
				//some os botoes
				botoes.setVisible(false, 0);
				botoes.setVisible(false, 1);
				//reseta o auxiliar
				auxiliar = new Heroi[2];
				//muda o turno
				mudaTurno(daVez);
				//esquece o da vez
				daVez=null;
				
			}
			
			//System.out.println(botoes.TASK);
			batalha=false;
			alvo=null;
			botoes.TASK = 0;
			break;
		case 2:// Distance attack
			// botoes.get(0).x-=20;
			System.out.println(botoes.TASK);
			botoes.TASK = 0;
			break;
		case 3:
			System.out.println(botoes.TASK);
			botoes.TASK = 0;
			break;
		case 4:
			System.out.println(botoes.TASK);
			botoes.TASK = 0;
			break;
		case 5:
			System.out.println(botoes.TASK);
			GamePanel.screen = new Pausa();
			botoes.TASK = 0;
			break;
		}

		// tabuleiro

		tabuleiro.update(timeCerto, mouseX, mouseY);
		// se meu mouse colide com o tabuleiro somentes as bordas
		if (tabuleiro.colideTabuleiro(mouseX, mouseY)) {
			indexX = (mouseX) / squareSizex;
			if (indexX > tabuleiro.colunas) {
				indexX = tabuleiro.colunas;
			}
			if (indexX <= 0) {
				indexX = 0;
			} else {
				indexX--;
			}
			tabuleiro.quaX = (indexX * squareSizex) + (int) tabuleiro.x;

			indexY = mouseY / squareSizey;
			if (indexY > tabuleiro.linhas) {
				indexY = tabuleiro.linhas;
			}
			if (indexY <= 0) {
				indexY = 0;
			} else {
				indexY--;
			}
			tabuleiro.quaY = indexY * squareSizey + (int) tabuleiro.y;
			mensagem = "Coluna: " + (indexX) + " Linha: " + (indexY);

			if (turno && primeiro) {
				mensagemDoTurno = "Vez de: Jogador 1 Her�i 1";
			}
			if (turno && !primeiro) {
				mensagemDoTurno = "Vez de: Jogador 1 Her�i 2";
			}
			if (!turno && primeiro) {
				mensagemDoTurno = "Vez de: Jogador 2 Her�i 1";
			}
			if (!turno && !primeiro) {
				mensagemDoTurno = "Vez de: Jogador 2 Her�i 2";
			}
		}
	}

	// troca de turno

	// System.out.println("turno "+turno);
	// System.out.println("turno jogador por time "+turno);

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			GamePanel.screen = new Inicial();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private boolean existeBonecoNaPosicao(int posX, int posY) {
		if ((p1.posX == posX) && (p1.posY == posY))
			return true;
		if ((p2.posX == posX) && (p2.posY == posY))
			return true;
		if ((p3.posX == posX) && (p3.posY == posY))
			return true;
		return (p4.posX == posX) && (p4.posY == posY);
	}

	private Heroi getHeroi(int posX, int posY) {
		if ((p1.posX == posX) && (p1.posY == posY))
			return p1;
		if ((p2.posX == posX) && (p2.posY == posY))
			return p2;
		if ((p3.posX == posX) && (p3.posY == posY))
			return p3;
		if ((p4.posX == posX) && (p4.posY == posY))
			return p4;

		return null;
	}

	public Heroi[] existeAlguemPerto(Heroi player) {
		Heroi auxiliar[] = new Heroi[2];
		int total = 0;
		if (player.posY - 1 >= 0
				&& existeBonecoNaPosicao(player.posX, player.posY - 1)) {
			auxiliar[total] = getHeroi(player.posX, player.posY - 1);
			if (auxiliar[total] != null && auxiliar[total].time != player.time) {
				total++;
			}
		}

		if (player.posX + 1 < 10
				&& existeBonecoNaPosicao(player.posX + 1, player.posY)) {
			auxiliar[total] = getHeroi(player.posX + 1, player.posY);
			if (auxiliar[total] != null && auxiliar[total].time != player.time) {
				total++;
			}
		}

		if (player.posY + 1 < 10
				&& existeBonecoNaPosicao(player.posX, player.posY + 1)) {
			auxiliar[total] = getHeroi(player.posX, player.posY + 1);
			if (auxiliar[total] != null && auxiliar[total].time != player.time) {
				total++;
			}
		}

		if (player.posX - 1 >= 0
				&& existeBonecoNaPosicao(player.posX - 1, player.posY)) {
			auxiliar[total] = getHeroi(player.posX - 1, player.posY);
			if (auxiliar[total] != null && auxiliar[total].time != player.time) {
				total++;
			}
		}

		return auxiliar;

	}
	
	void mudaTurno(Heroi player){
		if(player==p1){
			primeiro = false;
		}else if(player==p2){
			turno = false;
			primeiro = true;
		}else if(player==p3){
			turno = false;
			primeiro = false;
		}else if(player==p4){
			turno = true;
			primeiro = true;
		}
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		danosVisuais.add(new DanoVisual(e.getX(), e.getY(), 4000, "s"));

		botoes.pressed(e.getX(), e.getY());

		if (e.getButton() == 1) {

			System.out.println("turno " + turno);
			System.out.println("turno jogador por time " + turno);
			System.out.println("coord p1 " + p1.posX + p1.posY);
			if (!batalha){
				if (turno && primeiro) {// jogador 1 heroi 1
					if (!existeBonecoNaPosicao(indexX, indexY)) {
						int dist = Math.abs(indexX - p1.posX)
								+ Math.abs(indexY - p1.posY);
						if ((dist > 0) && (dist <= 3)) {
							p1.posX = indexX;
							p1.posY = indexY;
							// verificar se tem alguem perto
							auxiliar = existeAlguemPerto(p1);
							if (auxiliar[0] == null) {
								mudaTurno(p1);
							} else {
								batalha = true;
								auxiliar[0].selecionavel = true;
								if (auxiliar[1] != null){
									auxiliar[1].selecionavel = true;
								}else{
									alvo = auxiliar[0];
								}
								daVez = p1;
								botoes.setVisible(true, 0);
								botoes.setVisible(true, 1);
							}

						}
					}
				} else if (turno && !primeiro) {// jogador 1 heroi 2
					if (!existeBonecoNaPosicao(indexX, indexY)) {
						int dist = Math.abs(indexX - p2.posX)
								+ Math.abs(indexY - p2.posY);
						if ((dist > 0) && (dist <= 3)) {
							p2.posX = indexX;
							p2.posY = indexY;

							auxiliar = existeAlguemPerto(p2);
							if (auxiliar[0] == null) {
								mudaTurno(p2);
							} else {
								batalha = true;
								auxiliar[0].selecionavel = true;
								if (auxiliar[1] != null){
									auxiliar[1].selecionavel = true;
								}else{
									alvo = auxiliar[0];
								}
								daVez = p2;
								botoes.setVisible(true, 0);
								botoes.setVisible(true, 1);
							}

						}
					}

				} else if (!turno && primeiro) {// jogador 2 heroi 1
					if (!existeBonecoNaPosicao(indexX, indexY)) {
						int dist = Math.abs(indexX - p3.posX)
								+ Math.abs(indexY - p3.posY);
						if ((dist > 0) && (dist <= 3)) {
							p3.posX = indexX;
							p3.posY = indexY;

							auxiliar = existeAlguemPerto(p3);
							if (auxiliar[0] == null) {
								mudaTurno(p3);
							} else {
								batalha = true;
								auxiliar[0].selecionavel = true;
								if (auxiliar[1] != null){
									auxiliar[1].selecionavel = true;
								}else{
									alvo = auxiliar[0];
								}
								daVez = p3;
								botoes.setVisible(true, 0);
								botoes.setVisible(true, 1);
							}
						}
					}

				} else if (!turno && !primeiro) {// jogador 2 heroi 2
					if (!existeBonecoNaPosicao(indexX, indexY)) {
						int dist = Math.abs(indexX - p4.posX)
								+ Math.abs(indexY - p4.posY);
						if ((dist > 0) && (dist <= 3)) {
							p4.posX = indexX;
							p4.posY = indexY;

							auxiliar = existeAlguemPerto(p4);
							if (auxiliar[0] == null) {
								mudaTurno(p4);
							} else {
								batalha = true;
								auxiliar[0].selecionavel = true;
								if (auxiliar[1] != null){
									auxiliar[1].selecionavel = true;
								}else{
									alvo = auxiliar[0];
								}
								daVez = p4;
								botoes.setVisible(true, 0);
								botoes.setVisible(true, 1);
							}
						}
					}

				}
			}else{//input da batalha
				auxiliar[0].selecionado=false;
				if(auxiliar[1]!=null){
					auxiliar[1].selecionado=false;
					alvo = getHeroi(indexX, indexY);
					if(alvo==auxiliar[0] || alvo==auxiliar[1]){
						alvo.selecionado=true;
					}
				}
			}

		}
	}

	@Override
	public void onMouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseMove(int x, int y) {
		// TODO Auto-generated method stub
		// System.out.println(x+":"+y);
		mouseX = x;
		mouseY = y;
		mensagem2 = "X: " + x + " Y: " + y;

	}

	@Override
	public void draw(Graphics2D dbg) {
		// TODO Auto-generated method stub
		// desenha o tabuleiro

		tabuleiro.draw(dbg, 0, 0);
		p1.draw(dbg, tabuleiro.x, tabuleiro.y);
		p2.draw(dbg, tabuleiro.x, tabuleiro.y);
		p3.draw(dbg, tabuleiro.x, tabuleiro.y);
		p4.draw(dbg, tabuleiro.x, tabuleiro.y);

		for (int i = 0; i < tabuleiro.colunas; i++) {
			for (int j = 0; j < tabuleiro.linhas; j++) {
				// dbg.drawString(""+posicoes[i][j],(i*squareSizex)+50,(j*squareSizey)+75);
			}

		}

		dbg.drawString("CH prototype v1.3.7", 600, 230);
		dbg.drawString("Lat�ncia:", 600, 310);
		dbg.drawString(mensagem, 600, 250);
		dbg.drawString(mensagem2, 600, 270);
		dbg.drawString(mensagemDoTurno, 600, 290);
		// dbg.drawString("vida: ", 600, 310);
		botoes.draw(dbg, 0, 0);

	}

	// @Override
	// public void onMouseDragged(MouseEvent e) {
	// // TODO Auto-generated method stub
	//
	// }

}
