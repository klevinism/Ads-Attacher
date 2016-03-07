package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class SettingView_Panel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public SettingView_Panel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		//setSize(500, 450);
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.setMaximumSize(this.getSize());
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("General", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblWordpressAdminUrl = new JLabel("Wordpress Admin Url :");
		GridBagConstraints gbc_lblWordpressAdminUrl = new GridBagConstraints();
		gbc_lblWordpressAdminUrl.gridwidth = 2;
		gbc_lblWordpressAdminUrl.anchor = GridBagConstraints.EAST;
		gbc_lblWordpressAdminUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblWordpressAdminUrl.gridx = 0;
		gbc_lblWordpressAdminUrl.gridy = 1;
		panel_1.add(lblWordpressAdminUrl, gbc_lblWordpressAdminUrl);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 25);
		gbc_textField.gridwidth = 6;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username :");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.gridwidth = 2;
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 2;
		panel_1.add(lblUsername, gbc_lblUsername);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 6;
		gbc_textField_1.insets = new Insets(0, 0, 5, 25);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.gridwidth = 2;
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		panel_1.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 6;
		gbc_passwordField.insets = new Insets(0, 0, 5, 25);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 3;
		panel_1.add(passwordField, gbc_passwordField);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridwidth = 9;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 5;
		panel_1.add(separator, gbc_separator);
		
		JLabel lblAdCode = new JLabel("Ad Code :");
		GridBagConstraints gbc_lblAdCode = new GridBagConstraints();
		gbc_lblAdCode.gridwidth = 2;
		gbc_lblAdCode.anchor = GridBagConstraints.EAST;
		gbc_lblAdCode.insets = new Insets(15, 0, 5, 5);
		gbc_lblAdCode.gridx = 0;
		gbc_lblAdCode.gridy = 6;
		panel_1.add(lblAdCode, gbc_lblAdCode);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		JScrollPane txtAreaScrollPane = new JScrollPane(textArea);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 3;
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(15, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 6;
		panel_1.add(txtAreaScrollPane, gbc_textArea);
	}
	
	public void setWpAdminUrl(String WpAdminUrl){
		textField.setText(WpAdminUrl);
	}
	public String getWpAdminUrl(){
		return textField.getText().toString();
	}
}
