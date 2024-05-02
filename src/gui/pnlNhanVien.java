package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class pnlNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Create the frame.
	 */
	public pnlNhanVien() {

		setBackground(new Color(205,201,195,255));
		setBounds(10, 58, 1491, 697);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 629, 677);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(56, 130, 138, 19);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 127, 275, 29);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(56, 187, 138, 19);
		panel_1.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 184, 275, 29);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới tính:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(56, 243, 138, 19);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(56, 286, 138, 19);
		panel_1.add(lblNewLabel_1_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 283, 275, 29);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày sinh:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(56, 341, 138, 19);
		panel_1.add(lblNewLabel_1_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(219, 338, 275, 29);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("Chức vụ:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(56, 405, 138, 19);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Ngày tuyển dụng:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_6.setBounds(56, 457, 138, 19);
		panel_1.add(lblNewLabel_1_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(219, 454, 275, 29);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_1_7 = new JLabel("Địa chỉ:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_7.setBounds(56, 507, 138, 19);
		panel_1.add(lblNewLabel_1_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(219, 504, 275, 29);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_1_8 = new JLabel("Email:");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_8.setBounds(56, 560, 138, 19);
		panel_1.add(lblNewLabel_1_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(219, 557, 275, 29);
		panel_1.add(textField_9);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(56, 23, 112, 97);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ảnh đại diện");
		lblNewLabel_2.setBounds(0, 10, 112, 77);
		panel_4.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(219, 244, 60, 21);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setBounds(294, 244, 72, 21);
		panel_1.add(rdbtnN);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên bán hàng", "Quản lý"}));
		comboBox.setBounds(219, 402, 275, 29);
		panel_1.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Cập nhật");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(264, 619, 138, 36);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Thêm");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(430, 619, 138, 36);
		panel_1.add(btnNewButton_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(649, 10, 832, 677);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 22, 822, 65);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mã nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 175, 21);
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(20, 33, 165, 19);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBounds(205, 32, 71, 21);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Chức vụ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(353, 10, 95, 21);
		panel_3.add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên", "Quản lý", "Tất cả"}));
		comboBox_1.setBounds(363, 32, 175, 21);
		panel_3.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 832, 598);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}
}
