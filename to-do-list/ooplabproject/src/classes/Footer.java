package classes;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JTextField;

public class Footer extends JPanel{
	
	JButton addTask;
	JButton clear;
	JTextField Task;
	JPanel panel;
	
	Footer()
	{
		
		this.setPreferredSize(new Dimension(400,60));
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		
		addTask = new JButton("Add Task");
		addTask.setBorder(BorderFactory.createEmptyBorder());
		addTask.setFont(new Font("Sans-serif",Font.PLAIN, 20));
		addTask.setVerticalAlignment(JButton.BOTTOM);
		//addTask.setBackground(Color.white);
		this.add(addTask);
		
		
		this.add(Box.createHorizontalStrut(20));
		clear = new JButton("Clear finished tasks");
		clear.setFont(new Font("Sans-serif",Font.PLAIN, 20));
		clear.setBorder(BorderFactory.createEmptyBorder());
		//clear.setBackground();
		this.add(clear);
		
	}
	
	public JButton getNewTask(){
		return addTask;
	}
	
	public JButton getClear() {
		return clear;
	}
}
