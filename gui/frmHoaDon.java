package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHoaDon frame = new frmHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1515, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlNav = new JPanel();
		pnlNav.setBounds(10, 0, 1491, 74);
		contentPane.add(pnlNav);
		pnlNav.setLayout(null);
		
		JPanel pnlNoiDung = new JPanel();
		pnlNoiDung.setBounds(10, 74, 1479, 681);
		contentPane.add(pnlNoiDung);
		pnlNoiDung.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "L\u1ECBch s\u1EED ho\u00E1 \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 755, 363);
		pnlNoiDung.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 20, 735, 43);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã hoá đơn:");
		lblNewLabel_2.setBounds(10, 10, 76, 13);
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(85, 7, 106, 19);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Tìm");
		btnNewButton_2.setBounds(202, 6, 67, 21);
		panel_3.add(btnNewButton_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(359, 7, 130, 19);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(520, 7, 130, 19);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 735, 292);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Chi ti\u1EBFt ho\u00E1 \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 383, 768, 288);
		pnlNoiDung.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 27, 748, 251);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("In hoá đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(1320, 10, 149, 43);
		pnlNoiDung.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin ho\u00E1 \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(836, 63, 474, 505);
		pnlNoiDung.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã hoá đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(34, 24, 133, 22);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(251, 32, 45, 13);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblKhchHng = new JLabel("Khách hàng:");
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKhchHng.setBounds(34, 72, 133, 30);
		panel_2.add(lblKhchHng);
		
		JLabel lblNewLabel_1_1 = new JLabel("X");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(251, 80, 45, 13);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblSdt = new JLabel("SDT:");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSdt.setBounds(34, 119, 95, 26);
		panel_2.add(lblSdt);
		
		JLabel lblNewLabel_1_2 = new JLabel("X");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(251, 125, 45, 13);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblTgTo = new JLabel("TG tạo:");
		lblTgTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTgTo.setBounds(34, 162, 95, 22);
		panel_2.add(lblTgTo);
		
		JLabel lblNewLabel_1_3 = new JLabel("X");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(251, 166, 45, 13);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblLoiThanhTon = new JLabel("Loại thanh toán:");
		lblLoiThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoiThanhTon.setBounds(34, 206, 133, 22);
		panel_2.add(lblLoiThanhTon);
		
		JLabel lblNewLabel_1_4 = new JLabel("X");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(251, 210, 45, 13);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblTngTinSn = new JLabel("Tổng tiền sản phẩm:");
		lblTngTinSn.setBackground(new Color(240, 240, 240));
		lblTngTinSn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTngTinSn.setBounds(34, 254, 188, 22);
		panel_2.add(lblTngTinSn);
		
		JLabel lblNewLabel_1_5 = new JLabel("X");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(251, 258, 45, 13);
		panel_2.add(lblNewLabel_1_5);
		
		JLabel lblTngTinGim = new JLabel("Tổng tiền giảm:");
		lblTngTinGim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTngTinGim.setBounds(34, 307, 156, 22);
		panel_2.add(lblTngTinGim);
		
		JLabel lblNewLabel_1_6 = new JLabel("X");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_6.setBounds(251, 311, 45, 13);
		panel_2.add(lblNewLabel_1_6);
		
		JLabel lblTngTinHd = new JLabel("Tổng tiền HD:");
		lblTngTinHd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngTinHd.setBounds(34, 361, 156, 43);
		panel_2.add(lblTngTinHd);
		
		JLabel lblNewLabel_1_7 = new JLabel("X");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_7.setBounds(251, 375, 45, 13);
		panel_2.add(lblNewLabel_1_7);
		
		JButton btnNewButton_1 = new JButton("Xoá hoá đơn");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(836, 591, 130, 43);
		pnlNoiDung.add(btnNewButton_1);
	}
}
