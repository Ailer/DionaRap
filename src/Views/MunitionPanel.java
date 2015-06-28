package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MunitionPanel extends JPanel
{
	private int _ammoCount = 0;
	private final String imagePath = String.format("Images%sDracula%sammo.png", File.separator, File.separator);
	private final Image image = this.getToolkit().getImage(imagePath);
				
	public void updateMunitionPanel(int ammoCount)
	{
		this._ammoCount = ammoCount;
		System.out.printf("Munition: %d", this._ammoCount);
		this.repaint();
	}
	
	int i = 0;
	public void paintComponent(Graphics g) 
	{
		Graphics2D graphic = (Graphics2D)g;
		int width = (int)(image.getWidth(this) / 1.5);
		int height = (int)(image.getHeight(this) / 1.5);
		graphic.clearRect(0, 0, this.getWidth(), this.getHeight());
			
		if (this._ammoCount <= 3)
		{
			int xPos = 0;
		
			
			for (int i = 0; i < this._ammoCount; i++)
			{
				graphic.drawImage(image, xPos, 0, width,height, this);
				xPos += width + 5;
			}
		}
		else
		{
			//graphic.clearRect(0, 0, 500, 500);
			//Font font = new Font("Arial",Font.BOLD,16);
			//graphic.setFont(font);
			graphic.drawString(String.format("*%d",this._ammoCount),0, 20);
			
			int xPos = width +5;
			
			for (int i = 0; i < 2; i++)
			{
				graphic.drawImage(image, xPos, 0, width,height, this);
				xPos += width + 5;
			}
		}
	}
	
	public Dimension getPreferredSize()
	{
		return super.getPreferredSize();
	}
}
