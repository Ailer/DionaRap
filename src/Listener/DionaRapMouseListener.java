package Listener;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import de.fhwgt.dionarap.controller.DionaRapController;
import Views.MainWindow;
import Views.ThemePopupMenu;

public class DionaRapMouseListener implements MouseListener 
{
	private MainWindow _mainWindow;
	private ThemePopupMenu _themePopup;
	
	public DionaRapMouseListener(MainWindow mainWindow)
	{
		this._mainWindow = mainWindow;
		this._themePopup = new ThemePopupMenu(this._mainWindow);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		if (arg0.getButton() == 1)
		{
			Point playerPosition = this._mainWindow.getPlayerPosition();
			Point mousePosition = this._mainWindow.getCoordinates(arg0.getPoint());
			DionaRapController drc = this._mainWindow.getDionaRapController();
			
			// ====== 1 ======
			if (playerPosition.getX() -1 == mousePosition.getX()
					&& playerPosition.getY() +1 == mousePosition.getY())
			{
				drc.movePlayer(1);
			}
			// ====== 2 ======
			else if(playerPosition.getX()  == mousePosition.getX()
					&& playerPosition.getY() +1 == mousePosition.getY())
			{
				drc.movePlayer(2);
			}
			// ====== 3 ======
			else if(playerPosition.getX() + 1 == mousePosition.getX()
					&& playerPosition.getY() +1 == mousePosition.getY())
			{
				drc.movePlayer(3);
			}
			// ====== 4 ======
			else if(playerPosition.getX() - 1 == mousePosition.getX()
					&& playerPosition.getY() == mousePosition.getY())
			{
				drc.movePlayer(4);
			}
			// ====== 5 ======
			else if (playerPosition.getX() == mousePosition.getX() 
					&& playerPosition.getY() == mousePosition.getY() )
			{
				if (!drc.shoot())
				{
					this._mainWindow.flashAmmoPanel();
				}
			}
			// ====== 6 ======
			else if (playerPosition.getX() + 1 == mousePosition.getX() 
					&& playerPosition.getY() == mousePosition.getY())
			{
				drc.movePlayer(6);
			}
			
			// ====== 7 ======
			else if (playerPosition.getX() - 1 == mousePosition.getX()
				&& playerPosition.getY() -1 == mousePosition.getY())
			{
				drc.movePlayer(7);
			}	
			// ====== 8 ======
			else if (playerPosition.getX() == mousePosition.getX()
					&& playerPosition.getY() -1 == mousePosition.getY())
			{
				drc.movePlayer(8);
			}
			// ====== 9 ======
			else if(playerPosition.getX() + 1 == mousePosition.getX()
					&& playerPosition.getY() -1 == mousePosition.getY())
			{
				drc.movePlayer(9);
			}	
		
			System.out.printf("Spieler x: %d y: %d \n", playerPosition.x, playerPosition.y);
			System.out.printf("Maus x: %d y: %d \n", mousePosition.x, mousePosition.y);
		}
		else if (arg0.getButton() == 3)
		{	
			this._themePopup.setLocation(arg0.getXOnScreen(),arg0.getYOnScreen());
			this._themePopup.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
