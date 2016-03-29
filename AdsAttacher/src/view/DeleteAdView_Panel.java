package view;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.PostObject;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class DeleteAdView_Panel extends JPanel {
	private JTextField textField;
	private JTable table;
	private JSeparator separator;
	private PostObject[][] postObject;
	private Object[] columnNames;
	
	public void doInBackground(){
		JCheckBox checkBox = new JCheckBox();
		/*
		 * TODO
		 * 1- Declare columnNames 
		 * 2- 
		 */
		columnNames = new Object[]{checkBox,"asdf","asdf"};
		postObject = new PostObject[][]{{}};
	}

	/**
	 * Create the panel.
	 */
	public DeleteAdView_Panel(JFrame currentFrame) {
		doInBackground();

		setSize(500,500);
		setLayout(new MigLayout("", "[pref!,grow][][grow]", "[][][pref!,grow][]"));
		
		JLabel lblNewLabel = new JLabel("Search Post:");
		add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		table = new JTable(postObject,columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		add(new JScrollPane(table), "cell 0 2 3 1,grow");
		
		separator = new JSeparator();
		add(separator, "cell 0 3 3 1,grow");
	}

}
