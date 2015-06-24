
package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.*;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.controller.logic.DionaRapGameLogic;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.MTConfiguration;
import de.fhwgt.dionarap.model.objects.Ammo;
import DionaRapSettings.Settings;
import Listener.*;

/**
 * @author nkunkel	
 * MainWindow with GameBoard for DionaRap
 */
public class MainWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	private ControlWindow _controlWindow;
	private Board _board;
	private DionaRapModel _dionaRapModel;
	private DionaRapController _dionaRapController;
	private DionaRapGameLogic _dionaRapGameLogic;
	private DionaRapToolBar _dionaRapToolbar;
	private DionaRapMenuBar _dionaRapMenubar;
	private DionaRapModelListener _dionaRapModelListener;
	private Settings _settings;
	private String _theme;
	private final int opponentCountStart = 3;
	private final int obstacleCount = 5;
	private final int grideSizeX = 10;
	private final int grideSizeY = 10;
	private final int ammoCount = 5;
	
	/**
	 * ctor for MainWindow
	 */
	public MainWindow()
	{		
		this._settings = new Settings();
		this._settings.setOpponentsCount(5);
		this._settings.saveSettigns();
		this._theme = "Dracula";
		this._board = new Board(this._theme, 10, 10);
		this._dionaRapMenubar = new DionaRapMenuBar(this);
		this.setJMenuBar(this._dionaRapMenubar);
		this._dionaRapToolbar = new DionaRapToolBar();
		this._dionaRapToolbar.setPreferredSize(new Dimension(this.getWidth(), this._dionaRapToolbar.getToolBarHeight()));
		this.add(this._dionaRapToolbar, BorderLayout.PAGE_END);
		this.add(this._board, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Diona Rap");	
		
		this.setVisible(true);
		this.pack();
		
		this._controlWindow = new ControlWindow(this);	
		this.addComponentListener(new MainWindowListener(this._controlWindow));
		this.addKeyListener(new ControlKeyListener(this));
		this.addMouseListener(new DionaRapMouseListener(this));
		this.setLocationRelativeTo(null);
		this._controlWindow.setLocation(this.getX() + this.getWidth() + 20, this.getY());
		this._dionaRapModelListener = new DionaRapModelListener(this);
		this.initaliseGame();
	}
	
	public void initaliseGame()
	{
		this.setTbRestartButtonEnabled(false);
		this._dionaRapToolbar.setScore(0);
		this._dionaRapToolbar.setProgress(0);
		this._dionaRapModel = new DionaRapModel(this.grideSizeX,this.grideSizeY,this.opponentCountStart,this.obstacleCount);
		this._dionaRapController = new DionaRapController(this._dionaRapModel);
		this._dionaRapGameLogic = new DionaRapGameLogic(this._dionaRapModel);
		this._dionaRapModel.addModelChangedEventListener(this._dionaRapModelListener);
		this._dionaRapModel.setShootAmount(0);
		
		for (int i=0; i < this.ammoCount; i++)
		{
			this._dionaRapModel.addAmmo(new Ammo());
		}
	
		this.updateGame();
		this.setMTConfiguration();
		this.requestFocus();
	}
	
	private void setMTConfiguration()
	{
		MTConfiguration mtConfig = new MTConfiguration();
		mtConfig.setAlgorithmAStarActive(true);
		mtConfig.setAvoidCollisionWithObstacles(true);
		mtConfig.setAvoidCollisionWithOpponent(false);
		mtConfig.setMinimumTime(800);
		mtConfig.setShotGetsOwnThread(true);
		mtConfig.setOpponentWaitTime(2000);
		mtConfig.setShotWaitTime(500);
		mtConfig.setRandomOpponentWaitTime(false); 
		mtConfig.setDynamicOpponentWaitTime(false); 
		this._dionaRapController.setMultiThreaded(mtConfig);
	}
		
	public DionaRapController getDionaRapController()
	{
		return this._dionaRapController;
	}
	
	public String getTheme()
	{
		return this._theme;
	}
	
	public void setTheme(String theme)
	{
		this._theme = theme;
		this._board.setTheme(theme);
		this.updateGame();
	}
	
	public void updateGame()
	{
		this._board.updateBoard(this._dionaRapModel.getAllPawns());
		this._dionaRapToolbar.setScore(this._dionaRapModel.getScore());
		this._dionaRapToolbar.setAmmo(this._dionaRapModel.getShootAmount());
		
		int progress = 100 * (this.opponentCountStart - this._dionaRapModel.getOpponentCount()) / this.opponentCountStart;
		this._dionaRapToolbar.setProgress(progress);
	}
	
	public void setTbRestartButtonEnabled(boolean enabled)
	{
		this._dionaRapToolbar.setRestartButtonEnabled(enabled);
	}
	
	public void toogleToolBarVisible()
	{
		this._dionaRapToolbar.setVisible(!this._dionaRapToolbar.isVisible());
	}
	
	public void toogleNavigatorVisible()
	{
		this._controlWindow.setVisible(!this._controlWindow.isVisible());
	}
	
	public void setToolbarPosition(String position)
	{
		if (this._dionaRapToolbar.isVisible())
		{
			this.remove(this._dionaRapToolbar);
			this.add(this._dionaRapToolbar, position);
			this.pack();
		}
	}
	
	public Point getCoordinates(Point point)
	{
		int x = point.x / this._board.getFieldSize().width;
		int y = point.y / this._board.getFieldSize().height -1;
		
		y = y== -1 ? 0 : y;
		
		return new Point(x,y);
	}
	
	public Point getPlayerPosition()
	{
		int x = this._dionaRapModel.getPlayer().getX();
		int y = this._dionaRapModel.getPlayer().getY();
		return new Point(x,y);
	}
	
	public void flashAmmoPanel()
	{
		this._dionaRapToolbar.flashAmmoPanel();
	}
}
