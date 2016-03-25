import java.awt.EventQueue;
import java.io.File;

import javax.swing.UIManager;

import controller.VersionController;
import model.XMLFileManipulation;
import model.updater.Updater;
import model.updater.UpdaterObject;
import view.*;

public class Main{
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		
		VersionController vController = new VersionController();
		
		if(vController.isUpToDate()){
			
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Throwable e) {
				e.printStackTrace();
			}
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						View_Frame frame = new View_Frame("Ads Attacher");
						frame.setVisible(true);
						frame.setContentPane(new MainView_Panel());
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}else{
			Updater updater = new Updater();
			updater.initComponents();
			updater.setVisible(true);
			updater.download();
		}
	}	
}
