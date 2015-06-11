package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.controller.logic.DionaRapGameLogic;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.Grid;
import de.fhwgt.dionarap.model.objects.AbstractPawn;
import de.fhwgt.dionarap.model.objects.Ammo;
import de.fhwgt.dionarap.model.objects.Player;
import Listener.*;

/**
 * @author nkunkel	public void updateBoard()
	{
		this._playerLabel
	}
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
	private int _opponentCountStart = 3;
	
	/**
	 * ctor for MainWindow
	 */
	public MainWindow()
	{		
		this._board = new Board();	
		this._dionaRapToolbar = new DionaRapToolBar();
		this.add(this._dionaRapToolbar, BorderLayout.PAGE_START);
		this.add(this._board, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Diona Rap");	
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(250,250));
		this.pack();
		//this._board.upupdateBackgroundImage();

		this._controlWindow = new ControlWindow(this);	
		this.addComponentListener(new MainWindowListener(this._controlWindow));
		this.addKeyListener(new ControlKeyListener(this));
		this._controlWindow.setLocation(this.getX() + this.getWidth() + 20, this.getY());
		this.initaliseGame();
		this.requestFocus();
	}
	
	
	public void initaliseGame()
	{
		this.setTbRestartButtonEnabled(false);
		this._dionaRapToolbar.setScore(0);
		this._dionaRapToolbar.setProgress(0);
		this._dionaRapModel = new DionaRapModel(10,10,this._opponentCountStart,3);
		this._dionaRapController = new DionaRapController(this._dionaRapModel);
		this._dionaRapGameLogic = new DionaRapGameLogic(this._dionaRapModel);
		this._dionaRapModel.addModelChangedEventListener(new DionaRapModelListener(this));
		this._dionaRapModel.addAmmo(new Ammo());
		this.updateGame();
	}
		
	public DionaRapController getDionaRapController()
	{
		return this._dionaRapController;
	}
	
	public void updateGame()
	{
		this._board.updateBoard(this._dionaRapModel.getAllPawns());
		this._dionaRapToolbar.setScore(this._dionaRapModel.getScore());
		System.out.print(this._dionaRapModel.getOpponentCount());
		
		int progress = 100 * (this._opponentCountStart - this._dionaRapModel.getOpponentCount()) / this._opponentCountStart;
		this._dionaRapToolbar.setProgress(progress);
	}
	
	public void setTbRestartButtonEnabled(boolean enabled)
	{
		this._dionaRapToolbar.setRestartButtonEnabled(enabled);
	}
}
