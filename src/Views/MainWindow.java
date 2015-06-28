
package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.*;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.controller.logic.DionaRapGameLogic;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.Grid;
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
	private MTConfiguration _mtConfig;
	private DionaRapToolBar _dionaRapToolbar;
	private DionaRapMenuBar _dionaRapMenubar;
	private DionaRapModelListener _dionaRapModelListener;
	private Settings _settings;
	private String _theme = "Dracula";
	private final int opponentCountStart = 3;
	private int obstacleCount = 5;
	private int grideSizeX = 10;
	private int grideSizeY = 10;
	private int ammoCount = 5;
	
	/**
	 * ctor for MainWindow
	 */
	public MainWindow()
	{		
		this._settings = new Settings();
		this._theme = "Dracula";
		this._dionaRapMenubar = new DionaRapMenuBar(this);
		this.setJMenuBar(this._dionaRapMenubar);
		this._dionaRapToolbar = new DionaRapToolBar();
		this._dionaRapToolbar.setPreferredSize(new Dimension(this.getWidth(), this._dionaRapToolbar.getToolBarHeight()));
		this.add(this._dionaRapToolbar, BorderLayout.PAGE_END);
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
		this.setVisible(true);
	}
	
	public void loadSettings()
	{
		this._settings.loadSettings();
		this._dionaRapModel = new DionaRapModel(this._settings.getGrideSizeY(),
				this._settings.getGrideSizeX(),
				this._settings.getOpponentsCount(),
				this._settings.getObstaclesCount());
		this._board = new Board(this.getTheme(), this._settings.getGrideSizeX(), this._settings.getGrideSizeY());
	
		this._mtConfig = new MTConfiguration();
		this._mtConfig.setAvoidCollisionWithObstacles(this._settings.isAvoidObstacleCollisionEnabled());
		this._mtConfig.setAvoidCollisionWithOpponent(this._settings.isAvoidOpponentCollisionEnabled());
		this._mtConfig.setOpponentStartWaitTime(this._settings.getOpponentsStartWaitTime());
		this._mtConfig.setOpponentWaitTime(this._settings.getOpponentWaitTime());
		this._mtConfig.setShotWaitTime(this._settings.getShootDelay());
		this._mtConfig.setRandomOpponentWaitTime(this._settings.isRandomWaitTime());
	
		this._mtConfig.setDynamicOpponentWaitTime(false);
		
		this._dionaRapController = new DionaRapController(this._dionaRapModel);
		this._dionaRapController.setMultiThreaded(this._mtConfig);
		
		
		System.out.printf("x: %d y: %d", this._settings.getGrideSizeX(), this._settings.getGrideSizeY());
	}
	
	public void initaliseGame()
	{
		this.setTbRestartButtonEnabled(false);
		
		this.loadSettings();
		this.add(this._board, BorderLayout.CENTER);
				
		this._dionaRapToolbar.setScore(0);
		this._dionaRapToolbar.setProgress(0);
		
		this._dionaRapGameLogic = new DionaRapGameLogic(this._dionaRapModel);

		this._dionaRapModel.addModelChangedEventListener(this._dionaRapModelListener);
		this._dionaRapModel.setShootAmount(0);
		
		for (int i=0; i < this.ammoCount; i++)
		{
			//this._dionaRapModel.addAmmo(new Ammo());
		}
	
		this.updateGame();
		this.requestFocus();
		
		this.setLocationRelativeTo(null);
		this.pack();
	}
	
	public void setMTConfiguration()
	{
		/*mtConfig = new MTConfiguration();
		mtConfig.setAlgorithmAStarActive(true);
		mtConfig.setAvoidCollisionWithObstacles(true);
		mtConfig.setAvoidCollisionWithOpponent(false);
		mtConfig.setMinimumTime(800);
		mtConfig.setShotGetsOwnThread(true);
		mtConfig.setOpponentWaitTime(2000);
		mtConfig.setShotWaitTime(500);
		mtConfig.setRandomOpponentWaitTime(false); 
		mtConfig.setDynamicOpponentWaitTime(false); 
		this._dionaRapController.setMultiThreaded(mtConfig);*/
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
		
	public boolean isGameStarted()
	{
		if (this._dionaRapModel == null)
		{
			return false;
		}
		
		return this._dionaRapModel.isActive();
	}
}
