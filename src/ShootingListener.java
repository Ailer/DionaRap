

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.fhwgt.dionarap.controller.DionaRapController;

public class ShootingListener implements ActionListener 
{

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Container con = (Container)arg0.getSource();
		MainWindow mw = (MainWindow)con.getParent()
								  .getParent()
								  .getParent()
								  .getParent()
								  .getParent();
		DionaRapController drController = mw.getDionaRapController();
		drController.shoot();
	}

}
