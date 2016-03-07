import java.awt.EventQueue; 
import javax.swing.UIManager;
import view.*;

public class Main{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	
}
