import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import controller.VersionController;
import model.globals.Globals;
import model.updater.Updater;
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
						
						LauncherView_Panel launcherView = new LauncherView_Panel(frame);

						Image image = Toolkit.getDefaultToolkit().getImage(launcherView.getClass().getResource("/resources/images/app-icon.jpeg"));
						ImageIcon icon = new ImageIcon(image);
						frame.setIconImage(icon.getImage());
						
						frame.setContentPane(launcherView);
						frame.setVisible(true);
						
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
