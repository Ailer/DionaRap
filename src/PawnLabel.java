import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;


public abstract class PawnLabel extends JLabel 
{
	public PawnLabel()
	{
		super();
		this.setSize(35,35);
		Font font = this.getFont();
		this.setFont(new Font(font.getName(), font.getStyle(),35));
	}
	
	public void InvertColor(Color backgroundColor)
	{
		Color foreground = new Color(255 - backgroundColor.getRed(),
									 255 - backgroundColor.getBlue(),
									 255 - backgroundColor.getGreen());	
		//Color foreground = backgroundColor == Color.BLACK ? Color.WHITE : Color.BLACK;
		this.setForeground(foreground);
	}
}
