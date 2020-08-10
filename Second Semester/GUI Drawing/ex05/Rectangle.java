package ex05;

import java.awt.Color;

import javax.swing.JPanel;

class Rectangle extends JPanel{
	
	Color color;
	int width;
	int height;
	int x;
	int y;
	
	public Rectangle(Color color , int width , int height , int x , int y){
		
		this.color = color;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		
		
	}

    
}