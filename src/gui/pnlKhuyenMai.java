package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.Color;

public class pnlKhuyenMai extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public pnlKhuyenMai() { 	
		setBackground(new Color(205,201,195,255));
		setBounds(10, 74, 1479, 681);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 10, 805, 344);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 20, 785, 29);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập mã khuyến mãi:");
		lblNewLabel_2.setBounds(10, 10, 118, 13);
		panel_5.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(138, 7, 137, 19);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Tìm");
		btnNewButton_2.setBounds(285, 6, 58, 21);
		panel_5.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tình trạng:");
		lblNewLabel_3.setBounds(438, 10, 64, 13);
		panel_5.add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Đang áp dụng", "Kết thúc", "Tất cả"}));
		comboBox_2.setBounds(512, 6, 126, 21);
		panel_5.add(comboBox_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 49, 785, 285);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Khuy\u1EBFn m\u00E3i", "T\u00EAn khuy\u1EBFn m\u00E3i", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc", "Ph\u1EA7n tr\u0103m gi\u1EA3m gi\u00E1", "T\u00ECnh tr\u1EA1ng", "M\u00F4 t\u1EA3"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(81);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(84);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(101);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(82);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(140);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "S\u1EA3n ph\u1EA9m \u00E1p d\u1EE5ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 353, 805, 307);
		add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 20, 785, 51);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập mã sản phẩm:");
		lblNewLabel_1.setBounds(10, 0, 122, 13);
		panel_4.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(20, 22, 136, 19);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setBounds(181, 21, 57, 21);
		panel_4.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tình trạng");
		lblNewLabel_1_1.setBounds(343, 22, 75, 13);
		panel_4.add(lblNewLabel_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Đã áp dụng", "Chưa áp dụng"}));
		comboBox_1.setBounds(404, 21, 122, 21);
		panel_4.add(comboBox_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("áp dụng tất cả");
		chckbxNewCheckBox.setBounds(550, 21, 108, 21);
		panel_4.add(chckbxNewCheckBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 785, 209);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "K\u00EDch th\u01B0\u1EDBc", "Gi\u00E1 b\u00E1n", "Gi\u00E1 sau khuy\u1EBFn m\u00E3i", "\u0110\u00E3 \u00E1p d\u1EE5ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(78);
		table.getColumnModel().getColumn(4).setPreferredWidth(102);
		scrollPane.setViewportView(table);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Th\u00F4ng tin khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(845, 10, 599, 650);
		add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThm.setBounds(326, 509, 150, 47);
		panel_6.add(btnThm);
		
		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(122, 513, 138, 43);
		panel_6.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(175, 381, 377, 87);
		panel_6.add(textArea);
		
		JLabel lblMT = new JLabel("Mô tả:");
		lblMT.setBounds(93, 382, 49, 19);
		panel_6.add(lblMT);
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(175, 328, 377, 28);
		panel_6.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đang áp dụng", "Kết thúc"}));
		
		JLabel lblTnhTrng = new JLabel("Tình trạng:");
		lblTnhTrng.setBounds(80, 331, 76, 19);
		panel_6.add(lblTnhTrng);
		lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 282, 377, 28);
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPhnTrmGim = new JLabel("Phần trăm giảm giá:");
		lblPhnTrmGim.setBounds(16, 284, 138, 19);
		panel_6.add(lblPhnTrmGim);
		lblPhnTrmGim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 234, 377, 28);
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNgyKtThc = new JLabel("Ngày kết thúc:");
		lblNgyKtThc.setBounds(50, 236, 104, 19);
		panel_6.add(lblNgyKtThc);
		lblNgyKtThc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNgyBtu = new JLabel("Ngày bắt đầu:");
		lblNgyBtu.setBounds(57, 172, 97, 19);
		panel_6.add(lblNgyBtu);
		lblNgyBtu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 170, 377, 28);
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(175, 104, 377, 28);
		panel_6.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên khuyến mãi:");
		lblNewLabel.setBounds(50, 106, 114, 19);
		panel_6.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(438, 478, 114, 21);
		panel_6.add(btnNewButton_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
