package ex05;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class DrawPane extends JTextArea {
    ArrayList<Rectangle> rectArray = new ArrayList<>();	
    GroupLayout gl = new GroupLayout(this);
    GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
    ParallelGroup pGroup = gl.createParallelGroup();
    
	public void addRectangle(Color color , int width , int height , int x , int y) {
		x = rectArray.size()==0? x:rectArray.get(rectArray.size()-1).width+ x + 3;
		rectArray.add(new Rectangle(color, width, height, x, y));
	}
	
	@Override
	public void paintComponent(Graphics g ) {
		
		for (Rectangle rect: rectArray) {
			hGroup.addGroup(pGroup);
			super.paintComponent(g);
			g.setColor(rect.color);
			JPanel panel = new JPanel();
			panel.setBounds(rect.x, rect.y, rect.width, rect.height);
			panel.setBackground(rect.color);
			 pGroup.addComponent(panel)	;
			 }
		
	}
	
	
	
	
	
}