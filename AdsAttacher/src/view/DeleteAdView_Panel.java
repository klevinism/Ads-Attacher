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
import model.async.AsyncTasks;
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

@SuppressWarnings("serial")
public class DeleteAdView_Panel extends JPanel {
	private JTextField textField;
	private JTable table;
	private JSeparator separator;
	private PostObject posts = new PostObject();
	private LinkedList<PostObject> linkedPosts = new LinkedList<PostObject>();
	private String[] columnNames = {"Id","Title","Author","Category","Date","Url","DeleteUrl"};
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
				AsyncTasks asyncTasks = new AsyncTasks();
				asyncTasks.deleteAd(getSelectedPost());
				Thread async = new Thread(asyncTasks);
				async.run();
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
		DeletePost.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AsyncTasks asyncTasks = new AsyncTasks();
				asyncTasks.deletePost(getSelectedPost());
				Thread async = new Thread(asyncTasks);
				async.run();
			}}
		);
		add(DeletePost, "cell 3 5 3 0,wrap");

	}
	
	private PostObject getSelectedPost(){
		PostObject selectedPost = null;
		table.convertRowIndexToModel(0);

		int[] row = table.getSelectedRows();
		for(int x=0; x<row.length; x++){
			selectedPost = new PostObject();
			row[x] = table.convertRowIndexToModel(row[x]);//convert index to model so value does not change if table sorted
			
			selectedPost.setId((int)table.getModel().getValueAt(row[x],0));
			selectedPost.setTitle(table.getModel().getValueAt(row[x],1).toString());
			selectedPost.setAuthor(table.getModel().getValueAt(row[x],2).toString());
			selectedPost.setCategory(table.getModel().getValueAt(row[x],3).toString());
			selectedPost.setDate(table.getModel().getValueAt(row[x],4).toString());
			selectedPost.setUrl(table.getModel().getValueAt(row[x],5).toString());
			selectedPost.setDeleteUrl(table.getModel().getValueAt(row[x],6).toString());
		}
		return selectedPost;
	}

	private void toggleDeleteButtons(boolean toggleable){
			DeleteAd.setEnabled(toggleable);
			DeletePost.setEnabled(toggleable);
	}
	
	
}
