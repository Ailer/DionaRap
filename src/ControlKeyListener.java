import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.FocusManager;
import javax.swing.JFrame;


public class ControlKeyListener implements KeyListener
{
	private JFrame _mainWindow;
	
	public ControlKeyListener(JFrame mainWindow)
	{
		this._mainWindow = mainWindow;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{

	}

	@Override
	public void keyReleased(KeyEvent arg0){}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		System.out.print("Key pressed");
		this._mainWindow.requestFocus();
	}

}
