package Listener;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.FocusManager;
import javax.swing.JFrame;

import Views.MainWindow;
import de.fhwgt.dionarap.controller.DionaRapController;


public class ControlKeyListener implements KeyListener
{
	private MainWindow _mainWindow;
	
	public ControlKeyListener(MainWindow mainWindow)
	{
		this._mainWindow = mainWindow;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		DionaRapController controller = this._mainWindow.getDionaRapController();
		
			switch(arg0.getKeyCode())
			{
				case KeyEvent.VK_NUMPAD1: controller.movePlayer(1);
					break;
				case KeyEvent.VK_NUMPAD2: controller.movePlayer(2);
					break;
				case KeyEvent.VK_NUMPAD3: controller.movePlayer(3);
					break;
				case KeyEvent.VK_NUMPAD4: controller.movePlayer(4);
					break;
				case KeyEvent.VK_NUMPAD5: controller.shoot();
					break;
				case KeyEvent.VK_NUMPAD6: controller.movePlayer(6);
					break;
				case KeyEvent.VK_NUMPAD7: controller.movePlayer(7);
					break;
				case KeyEvent.VK_NUMPAD8: controller.movePlayer(8);
					break;
				case KeyEvent.VK_NUMPAD9: controller.movePlayer(9);
					break;
			}
			
			this._mainWindow.updateGame();
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
