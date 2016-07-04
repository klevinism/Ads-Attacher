package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.PostObject;
import model.table.TableModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class DeleteAdView_Panel extends JPanel {
	private JTextField textField;
	private JTable table;
	private JSeparator separator;
	private LinkedList<PostObject> postObject;
	private String[] columnNames = {"column 1","2","3"};
	
	public void doInBackground(){
		JCheckBox checkBox = new JCheckBox();
		/*
		 * TODO
		 * 1- Declare columnNames 
		 * 2- 
		 */
		postObject = new LinkedList<PostObject>();
		postObject.add(new PostObject(12,"kl","kl2","kl3","kl4"));
	}

	/**
	 * Create the panel.
	 */
	public DeleteAdView_Panel(final JFrame currentFrame) {
		doInBackground();

		setSize(500,570);
		setLayout(new MigLayout("", "[pref!,grow][][grow]", "[][][pref!,grow][]"));
		
		JLabel lblNewLabel = new JLabel("Search Post:");
		add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		TableModel tableModel = new TableModel(postObject);
		tableModel.setColumnName(columnNames);
		table = new JTable(tableModel);
		JTableHeader header = table.getTableHeader();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		add(new JScrollPane(table), "cell 0 2 3 1,grow");
		
		separator = new JSeparator();
		add(separator, "cell 0 3 3 1,grow");
		
		JButton button = new JButton("<-- Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				currentFrame.setContentPane(new LauncherView_Panel(currentFrame));
				currentFrame.setVisible(true);
			}
		});
		add(button, "cell 0 4 3 1");

	}

}
