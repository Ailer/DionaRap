package Views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JWindow;

import DionaRapSettings.Settings;
import Listener.SaveConfigurationListener;

public class ConfigurationDialog extends JDialog 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Settings _settings;
	private JSlider _opponentStartWaitTimeSlider;
	private JSlider _shootDelaySlider;
	private JSlider _opponentWaitTimeSlider;
	private JCheckBox _randomWaittime;
	private JCheckBox _avoidObstacleCollision;
	private JCheckBox _avoidOpponentCollision;
	private JTextField _grideSizeXTextField;
	private JTextField _grideSizeYTextField;
	private JTextField _opponentsCountTextField;
	private JTextField _obstaclesCountTextField;

	public ConfigurationDialog(MainWindow mainWindow) 
	{
		this.setLayout(new GridLayout(11,2));
		this._settings = new Settings();
		this.add(new JLabel("Wartezeit der Gegner"));
		
		this._opponentStartWaitTimeSlider = new JSlider(0,10000);
		this._opponentStartWaitTimeSlider.setValue(this._settings.getOpponentsCount());
		this._opponentStartWaitTimeSlider.createStandardLabels(2000);
		this._opponentStartWaitTimeSlider.setValue(this._settings.getOpponentsStartWaitTime());
		this.add(this._opponentStartWaitTimeSlider);	
		
		this.add(new JLabel("Verzögerung eines Schuss"));
		this._shootDelaySlider = new JSlider();
		this._shootDelaySlider.setValue(this._settings.getShootDelay());
		this.add(this._shootDelaySlider);
		
		this.add(new JLabel("Wartezeit eines Gegners vor jedem Schritt"));
		this._opponentWaitTimeSlider = new JSlider();
		this._opponentWaitTimeSlider.setValue(this._settings.getOpponentsWaitTime());
		this.add(this._opponentWaitTimeSlider);
		
		this.add(new JPanel());
		this._randomWaittime = new JCheckBox("Zufällige Wartezeit der Gegner");
		this._randomWaittime.setSelected(this._settings.isRandomWaitTime());
		this.add(this._randomWaittime);
		this.add(new JPanel());
		this._avoidObstacleCollision = new JCheckBox("Gegner meiden Kollision mit Hindernissen");
		this._avoidObstacleCollision.setSelected(this._settings.isAvoidObstacleCollisionEnabled());
		this.add(this._avoidObstacleCollision);
		this.add(new JPanel());
		this._avoidOpponentCollision = new JCheckBox("Gegner meiden Kollision mit anderen Gegnern");
		this._avoidObstacleCollision.setSelected(this._settings.isAvoidObstacleCollisionEnabled());
		this.add(this._avoidOpponentCollision);
		
		this.add(new JLabel("Anzahl Zeilen des Spielfelds"));
		this._grideSizeXTextField = new JTextField();
		this._grideSizeXTextField.setText(Integer.toString(this._settings.getGrideSizeX()));
		this.add(this._grideSizeXTextField);
		
		this.add(new JLabel("Anzahl Spalten des Spielfelds"));
		this._grideSizeYTextField = new JTextField();
		this._grideSizeYTextField.setText(Integer.toString(this._settings.getGrideSizeY()));
		this.add(this._grideSizeYTextField);
		
		this.add(new JLabel("Anzahl Hindernisse"));
		this._obstaclesCountTextField = new JTextField();
		this._obstaclesCountTextField.setText(Integer.toString(this._settings.getObstaclesCount()));
		this.add(this._obstaclesCountTextField);
		
		this.add(new JLabel("Anzahl der Gegner"));
		this._opponentsCountTextField = new JTextField();
		this._opponentsCountTextField.setText(Integer.toString(this._settings.getOpponentsCount()));
		this.add(this._opponentsCountTextField);
		
		JButton saveButton = new JButton("Speichern");		
		saveButton.addActionListener(new SaveConfigurationListener());
		saveButton.setPreferredSize(new Dimension(200, 50));
		this.add(saveButton);
		
		JButton closeButton = new JButton("Abbrechen");
		closeButton.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				JButton source = (JButton)arg0.getSource();
				if (source.getTopLevelAncestor() instanceof ConfigurationDialog)
				{
					ConfigurationDialog configDialog = (ConfigurationDialog)source.getTopLevelAncestor();
					configDialog.setVisible(false);
				}			
			}
		});
		
		closeButton.setPreferredSize(new Dimension(200, 50));
		this.add(closeButton);
		
		this.setModal(true);
		this.pack();
		this.setLocationRelativeTo(mainWindow);
	}	

	public int getOpponentStarWaitTime()
	{
		return this._opponentStartWaitTimeSlider.getValue();
	}
	
	public int getShootDelay()
	{
		return this._shootDelaySlider.getValue();
	}

	public int getOpponentWaitTime()
	{
		return this._opponentWaitTimeSlider.getValue();
	}

	public boolean isRandomWaitTime()
	{
		return this._randomWaittime.isSelected();
	}

	public boolean isAvoidObstacleCollisionEnabled()
	{
		return this._avoidObstacleCollision.isSelected();
	}

	public boolean isAvoidOpponentCollisionEnabled()
	{
		return this._avoidOpponentCollision.isSelected();
	}

	public int getGrideSizeX()
	{
		int tmp = 0;
		
		try 
		{
			tmp = Integer.parseInt(this._grideSizeXTextField.getText());
		} 
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public int getGrideSizeY()
	{
		int tmp = 0;
		
		try 
		{
			tmp = Integer.parseInt(this._grideSizeYTextField.getText());
		} 
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public int getOpponentsCount()
	{
		int tmp = 0;
		
		try 
		{
			tmp = Integer.parseInt(this._opponentsCountTextField.getText());
		} 
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		return tmp;
	}

	public int getObstaclesCount()
	{
		int tmp = 0;
		
		try 
		{
			tmp = Integer.parseInt(this._obstaclesCountTextField.getText());
		} 
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tmp;
	}
}
