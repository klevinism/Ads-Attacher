package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.PostObject;
import model.globals.Globals;
import model.table.TableModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;

@SuppressWarnings("serial")
public class DeleteAdView_Panel extends JPanel {
	private JTextField textField;
	private JTable table;
	private JSeparator separator;
	private PostObject posts = new PostObject();
	private LinkedList<PostObject> linkedPosts = new LinkedList<PostObject>();
	private String[] columnNames = {"Id","Title","Author","Category","Date","Url"};
	private JButton DeleteAd, DeletePost;
	
	public void doInBackground(){
		/*
		 * TODO
		 * 1- Get all posts 
		 */
		if(posts.getAllPosts().size() != 0)
			linkedPosts = posts.getAllPosts();
	}

	/**
	 * Create the panel.
	 */
	public DeleteAdView_Panel(final JFrame currentFrame) {
		doInBackground();

		setSize(500,570);
		setLayout(new MigLayout("", "[pref!,grow][][grow][grow]", "[][][pref!,grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Search Post:");
		add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		TableModel tableModel = new TableModel(linkedPosts);
		tableModel.setColumnName(columnNames);
		table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		add(new JScrollPane(table), "cell 0 3 3 1,grow");
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	ListSelectionModel lsm = (ListSelectionModel)event.getSource();
		    	toggleDeleteButtons(!lsm.isSelectionEmpty());
		    }
		});
		
		separator = new JSeparator();
		add(separator, "cell 0 4 3 2,grow");
		
		JButton button = new JButton("<-- Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				currentFrame.setContentPane(new LauncherView_Panel(currentFrame));
				currentFrame.setVisible(true);
			}
		});
		add(button, "cell 0 5 2 0");
			
		
		DeleteAd = new JButton("Remove Ad");
		try{
			Image img = ImageIO.read(getClass().getResource(Globals.paths.LocalImageFolder+"block_ads.png"));
			DeleteAd.setIcon(new ImageIcon(img));
		}catch(IOException ex){
		}
		DeleteAd.setEnabled(false);
		DeleteAd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getSelectedPost();
			}}
		);
		
		add(DeleteAd, "cell 1 5 3 0,wrap");
		
		DeletePost = new JButton("Remove Post");
		try{
			Image img = ImageIO.read(getClass().getResource(Globals.paths.LocalImageFolder+"delete.png"));
			DeletePost.setIcon(new ImageIcon(img));
		}catch(IOException ex){
		}
		DeletePost.setEnabled(false);
		add(DeletePost, "cell 3 5 3 0,wrap");

	}
	
	private PostObject getSelectedPost(){
		table.convertRowIndexToModel(0);

		int[] row = table.getSelectedRows();
		for(int x=0; x<row.length; x++){
			row[x] = table.convertRowIndexToModel(row[x]);//convert index to model so value does not change if table sorted
			
			System.out.println(table.getModel().getValueAt(row[x],5));//get link to delete post or remove ad
		}
		/*if(row != -1){
			System.out.println(table.getModel().getValueAt(row,0));
		}else{
			return null;
		}*/
		return null;
	}

	private void toggleDeleteButtons(boolean toggleable){
			DeleteAd.setEnabled(toggleable);
			DeletePost.setEnabled(toggleable);
	}
}
