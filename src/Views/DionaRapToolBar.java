package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class DionaRapToolBar extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	private JButton _restartButton;
	private JButton _settingsButton;
	private JTextPane _scoreTextField;
	private JProgressBar _currentProgress;
	private final int toolBarHeight = 70; 
	private MunitionPanel _munitionPanel;

	
	public int getToolBarHeight()
	{
		return toolBarHeight;
	}
	
	public void setScore(int score)
	{
		if (score >= 0) 
		{
			this._scoreTextField.setText(Integer.toString(score));
		}
	}
	
	public void setAmmo(int numberOfAmmo)
	{
		if (numberOfAmmo >= 0)
		{
			this._munitionPanel.updateMunitionPanel(numberOfAmmo);
		}
	}
	
	public void setProgress(int progress)
	{
		if (progress >= 0 && progress <= 100)
		{
			this._currentProgress.setValue(progress);
		}
	}
	
	public void setRestartButtonEnabled(boolean enabled)
	{
		this._restartButton.setEnabled(enabled);
	}
	
	public void run()
	{		
		try 
		{
			this._munitionPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
			Thread.sleep(1000);
		
			//this._munitionPanel.setBorder(BorderFactory.createEmptyBorder());
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void flashAmmoPanel()
	{
		new Thread(this).run();
		//this._munitionPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
	}
	
	public DionaRapToolBar() 
	{
		super();
		
		this._restartButton = new JButton("Neu starten");
		this._restartButton.setEnabled(false);
		this._restartButton.setPreferredSize(new Dimension(100, 25));
		this.add(this._restartButton);
		
		this._restartButton.addActionListener(new ActionListener() 
		{				
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Container mainWindow = ((JButton)e.getSource()).getTopLevelAncestor();
				
				if (mainWindow instanceof MainWindow)
				{
					((MainWindow)mainWindow).initaliseGame();
				}								
			}
		});

		JPanel scorePanel = new JPanel();
		scorePanel.setBorder(BorderFactory.createTitledBorder("Punkte"));
		scorePanel.setPreferredSize(new Dimension(100, toolBarHeight - 10));	
		this.add(scorePanel);
		
		this._scoreTextField = new JTextPane();
		this._scoreTextField.setEditable(false);
		this._scoreTextField.setToolTipText("Aktueller Punktestand");
		scorePanel.add(this._scoreTextField);	
				
		JPanel ammoPanel = new JPanel();
		ammoPanel.setToolTipText("Aktuelle Munition");
		ammoPanel.setBorder(BorderFactory.createTitledBorder("Munition"));
		ammoPanel.setPreferredSize(new Dimension(150, toolBarHeight - 10));
		this._munitionPanel = new MunitionPanel();
		this._munitionPanel.setPreferredSize(new Dimension(150, toolBarHeight - 40));
		ammoPanel.add(this._munitionPanel);
		this.add(ammoPanel);
				
		JPanel progressPanel = new JPanel();	
		progressPanel.setBorder(BorderFactory.createTitledBorder("Spielfortschritt..."));
		progressPanel.setPreferredSize(new Dimension(150, toolBarHeight - 10));	
		progressPanel.setToolTipText("Aktueller Fortschritt");
		this.add(progressPanel);
		
		this._currentProgress = new JProgressBar();
		this._currentProgress.setPreferredSize(new Dimension(100, toolBarHeight - 50));
		this._currentProgress.setStringPainted(true);
		progressPanel.add(this._currentProgress);
		
		this._settingsButton = new JButton("Einstellungen");
		this._settingsButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new SettingsTableDialog();
			}
		});
		this.setPreferredSize(new Dimension(150, 25));
		this.add(this._settingsButton);
		
		this.setScore(0);
		this.setProgress(0);
	}
}
