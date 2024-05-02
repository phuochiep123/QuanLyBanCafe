package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class pnlSanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public pnlSanPham() {
		setBackground(new Color(205,201,195,255));
		setBounds(10, 58, 1491, 697);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 638, 677);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 54, 103, 24);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(167, 53, 335, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSnPhm.setBounds(23, 103, 103, 24);
		panel_1.add(lblTnSnPhm);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(167, 102, 335, 25);
		panel_1.add(textField_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "K\u00EDch th\u01B0\u1EDBc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(23, 155, 506, 162);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Small");
		chckbxNewCheckBox.setBounds(18, 55, 82, 21);
		panel_4.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("Giá bán:");
		lblNewLabel_1.setBounds(206, 20, 47, 13);
		panel_4.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 56, 197, 19);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(139, 89, 197, 19);
		panel_4.add(textField_3);
		
		JCheckBox chckbxMedium = new JCheckBox("Medium");
		chckbxMedium.setBounds(18, 88, 82, 21);
		panel_4.add(chckbxMedium);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(139, 121, 197, 19);
		panel_4.add(textField_4);
		
		JCheckBox chckbxLagre = new JCheckBox("Large");
		chckbxLagre.setBounds(18, 120, 82, 21);
		panel_4.add(chckbxLagre);
		
		JLabel lblTrngThi = new JLabel("Trạng thái:");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrngThi.setBounds(23, 420, 103, 24);
		panel_1.add(lblTrngThi);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đang bán", "Ngừng bán"}));
		comboBox.setBounds(167, 424, 335, 30);
		panel_1.add(comboBox);
		
		JLabel lblMT = new JLabel("Mô tả:");
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMT.setBounds(23, 491, 103, 24);
		panel_1.add(lblMT);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(167, 493, 335, 78);
		panel_1.add(textArea);
		
		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(284, 606, 139, 43);
		panel_1.add(btnNewButton);
		
		JButton btnXa = new JButton("Thêm");
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXa.setBounds(464, 606, 121, 43);
		panel_1.add(btnXa);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Cafe", "Bánh ngọt", "Thức uống khác"}));
		comboBox_2.setBounds(167, 352, 335, 30);
		panel_1.add(comboBox_2);
		
		JLabel lblLoiSnPhm = new JLabel("Loại sản phẩm:");
		lblLoiSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiSnPhm.setBounds(23, 348, 115, 24);
		panel_1.add(lblLoiSnPhm);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(pnlSanPham.class.getResource("/icon/logoThem.jpg")));
		btnNewButton_2.setBounds(512, 352, 35, 30);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(667, 10, 814, 677);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 21, 794, 70);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập mã sản phẩm:");
		lblNewLabel_2.setBounds(10, 10, 143, 13);
		panel_3.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 30, 184, 19);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Trạng thái:");
		lblNewLabel_2_1.setBounds(295, 9, 108, 13);
		panel_3.add(lblNewLabel_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Đang bán", "Ngừng bán"}));
		comboBox_1.setBounds(295, 28, 160, 21);
		panel_3.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1_1.setBounds(539, 28, 168, 21);
		panel_3.add(comboBox_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Loại:");
		lblNewLabel_2_1_1.setBounds(539, 9, 108, 13);
		panel_3.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setBounds(200, 29, 68, 21);
		panel_3.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 794, 585);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}
}
