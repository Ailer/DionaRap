package Views;

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

public class DionaRapToolBar extends JToolBar 
{
	private static final long serialVersionUID = 1L;
	private JButton _restartButton;
	private JButton _settingsButton;
	private JTextPane _scoreTextField;
	private JProgressBar _currentProgress;
	private final int toolBarHeight = 60; 
	private final int toolBarWidth = 500;
	
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
	
	public DionaRapToolBar() 
	{
		super();
		
		this._restartButton = new JButton("Neu starten");
		this._restartButton.setEnabled(false);
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
		scorePanel.setPreferredSize(new Dimension(100, toolBarHeight));	
		scorePanel.setLayout(null);
		this.add(scorePanel);
		
		this._scoreTextField = new JTextPane();
		this._scoreTextField.setBounds(10, 15, 135, 30);
		this._scoreTextField.setEditable(false);
		this._scoreTextField.setToolTipText("Aktueller Punktestand");
		scorePanel.add(this._scoreTextField);	
				
		JPanel ammoPanel = new JPanel();
		ammoPanel.setToolTipText("Aktuelle Munition");
		ammoPanel.setBorder(BorderFactory.createTitledBorder("Munition"));
		ammoPanel.setPreferredSize(new Dimension(100, toolBarHeight));
		this.add(ammoPanel);
				
		JPanel progressPanel = new JPanel();	
		progressPanel.setLayout(null);
		progressPanel.setBorder(BorderFactory.createTitledBorder("Spielfortschritt..."));
		progressPanel.setPreferredSize(new Dimension(100, toolBarHeight));	
		progressPanel.setToolTipText("Aktueller Fortschritt");
		this.add(progressPanel);
		
		this._currentProgress = new JProgressBar();
		this._currentProgress.setStringPainted(true);
		this._currentProgress.setBounds(10,20,135,25);
		progressPanel.add(this._currentProgress);
		
		this._settingsButton = new JButton("Einstellungen");
		this.add(this._settingsButton);
		
		this.setPreferredSize(new Dimension(toolBarWidth, toolBarHeight));
		
		this.setScore(0);
		this.setProgress(0);
	}
}
