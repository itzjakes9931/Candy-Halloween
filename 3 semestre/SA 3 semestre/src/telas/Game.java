/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import gameMain.GamePanel;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import minhasClasses.Bola;
import minhasClasses.Personagem;
import minhasClasses.Plataforma;
import minhasClasses.Poligono;
import minhasClasses.Tabuleiro;

public class Game implements Screen{
    
    public String name = "S.A";
    Random rnd = new Random();
    int x=0;
    Bola player1;
    Bola player2;
    int minX=100,maxX=500,minY,maxY;
    int cameraX=0,cameraY=0;
    
    boolean movePer = true;
    int sorteio;
    int limiteCameraD=925;
    int limiteCameraE=-190;
    BufferedImage img;
    
    boolean teste=false;
    
    ArrayList<Poligono> listaDePoligonos;
    ArrayList<DanoVisual> danosVisuais;
    
    int mouseX, mouseY;
    int turno = 1;
    Personagem personagem;
    
    float slow=1;
    
    // tabuleiro
    
    Tabuleiro tabuleiro;
    public Game() {
    	danosVisuais = new ArrayList<DanoVisual>();
    	// iniciando o obj tabuleiro
    	tabuleiro = new Tabuleiro(50,50,400,400, 10, 10);
    	//INIT
    	//3800 = 60fps
    	img = AbreImagem("/imagens/walk.png");
    	personagem = new Personagem(0, 100, 100, 100, 0, 0, img);
    	player2 = new Bola(40,40,40,0.0f,0.0f,Color.green);
    	
    	listaDePoligonos = new ArrayList<Poligono>();
    	Polygon polyy = new Polygon();
    	
    	listaDePoligonos.add(new Poligono(450, 500, 
    			polyy, 100, 0.1f, 0.1f, Color.WHITE));
    	
        img = AbreImagem("/imagens/walk.png");
        player1 = new Bola(415, 415, 15, 0.0f, 0.0f, Color.MAGENTA);
    
    }
    
    public void reset(){
        
    }
    

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(long time) {
    	
    	for (int i = 0; i<danosVisuais.size(); i++){
    		danosVisuais.get(i).update(time, 0, 0);
    		if (!danosVisuais.get(i).isVivo){
    			danosVisuais.remove(i);
    			break;
    		}
    	}
    	
    	
    	
    	// tabuleiro
    	
    	float timeCerto = time;
    	tabuleiro.update(timeCerto,mouseX, mouseY);
        //simula as tretas
       player1.update(timeCerto,0,0);
       if(tabuleiro.colideTabuleiro(mouseX,mouseY)){
       int squareSize = (tabuleiro.largura/tabuleiro.colunas);
       int indexX = (squareSize*(tabuleiro.quaX/squareSize)-squareSize)/squareSize;
       tabuleiro.quaX = (indexX*squareSize)+(int)tabuleiro.x;
       squareSize = (tabuleiro.altura/tabuleiro.linhas);
       int indexY = (squareSize*(tabuleiro.quaY/squareSize)-squareSize)/squareSize;
       tabuleiro.quaY = (indexY*squareSize)+(int)tabuleiro.y;
       }
       //Foreach doido das paradas que faz tudo sozinho
       for (Poligono poligono : listaDePoligonos) {
    	   poligono.update(timeCerto*slow, 0, 0);
       }
       personagem.update(timeCerto*slow,0,0);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
        	personagem.andaDireita();
          
        }
        
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
        	personagem.andaEsquerda();
        }
        
        if(e.getKeyCode()==KeyEvent.VK_UP){
 
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
        personagem.para(0);
        }
        
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
        personagem.para(1);
        }
    }
    

    @Override
    public void onMousePressed(MouseEvent e) {
        if(e.getButton()==1){
        	
        	danosVisuais.add(new DanoVisual(e.getX(),e.getY(),4000, "s"));
        	
        	System.out.println(e.getX());
        	System.out.println(e.getY());
        	if(e.getX() == 0 && e.getY() == 0 && e.getX() == 100 && e.getY() == 100);
        	sorteio=1;
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
    	if(e.getButton()==2){
            //System.out.println("Botao do Meio!");
           slow*= 10f;
        }
    }

    @Override
    public void onMouseMove(int x, int y) {
        mouseX = x;
        mouseY = y;
        if(tabuleiro.colideTabuleiro(mouseX,mouseY)){
        	tabuleiro.quaX=10;
        	tabuleiro.quaY=10;
        }
    }

    @Override
    public void draw(Graphics2D dbg) {
    	
    	
    	
        tabuleiro.draw(dbg,0,0);
        int x = mouseX;
    	int y = mouseY;
        if (x > 0 && y > 0){
        player1.draw(dbg,x,y);
        player2.draw(dbg,mouseX, mouseY);
        }
        
        for (int i = 0; i<danosVisuais.size(); i++){
    		danosVisuais.get(i).draw(dbg, 0, 0);
 
    	}
        
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