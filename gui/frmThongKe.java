package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class frmThongKe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThongKe frame = new frmThongKe();
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
	public frmThongKe() {
		
		setForeground(new Color(240, 240, 240));
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1503, 789);
	//	setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpMenu = new JPanel();
		jpMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpMenu.setBounds(10, 10, 1167, 40);
		contentPane.add(jpMenu);
		jpMenu.setLayout(null);
		
		JButton btnNewButton = new JButton("Đăng Xuất");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(1067, 5, 93, 30);
		jpMenu.add(btnNewButton);
		
		JButton btniMtKhu = new JButton("Đổi Mật Khẩu");
		btniMtKhu.setBounds(953, 5, 110, 30);
		jpMenu.add(btniMtKhu);
		
		JButton btnNewButton_1 = new JButton("Nhân Viên");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setBounds(857, 5, 92, 30);
		jpMenu.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Khách Hàng");
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		btnNewButton_2.setBounds(743, 5, 110, 30);
		jpMenu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Hóa Đơn");
		btnNewButton_3.setBackground(new Color(0, 128, 255));
		btnNewButton_3.setBounds(561, 5, 85, 30);
		jpMenu.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Thống Kê");
		btnNewButton_4.setBackground(new Color(0, 128, 255));
		btnNewButton_4.setBounds(649, 5, 90, 30);
		jpMenu.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Trang Chủ");
		btnNewButton_4_1.setBackground(new Color(0, 128, 255));
		btnNewButton_4_1.setBounds(451, 5, 105, 30);
		jpMenu.add(btnNewButton_4_1);
		
		JPanel jpKhungTrangChu = new JPanel();
		jpKhungTrangChu.setBackground(new Color(255, 228, 225));
		jpKhungTrangChu.setBounds(10, 60, 1167, 603);
		contentPane.add(jpKhungTrangChu);
		jpKhungTrangChu.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 245, 1147, 348);
		jpKhungTrangChu.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(366, 5, 2, 2);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(171, 89, 827, 200);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh", "\u0110\u1ECBa Ch\u1EC9", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "Email", "Ng\u00E0y Tuy\u1EC3n D\u1EE5ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Boolean.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(73);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.getColumnModel().getColumn(7).setPreferredWidth(93);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Từ ngày:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(38, 28, 89, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblnNgy = new JLabel("Đến ngày:");
		lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnNgy.setBounds(238, 28, 96, 25);
		panel.add(lblnNgy);
		
		JLabel lblTngDoanhThu = new JLabel("Tổng Doanh Thu:");
		lblTngDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngDoanhThu.setBounds(560, 28, 127, 25);
		panel.add(lblTngDoanhThu);
		
		JLabel lblSSnPhm = new JLabel("Số Sản Phẩm Bán Được:");
		lblSSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSSnPhm.setBounds(745, 28, 174, 25);
		panel.add(lblSSnPhm);
		
		JLabel lblSHan = new JLabel("Số Hóa Đơn:");
		lblSHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSHan.setBounds(983, 28, 96, 25);
		panel.add(lblSHan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(10, 10, 1147, 226);
		jpKhungTrangChu.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(152, 251, 152));
		panel_2.setBounds(10, 10, 370, 206);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hôm Nay");
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 33));
		lblNewLabel.setBounds(105, 10, 155, 52);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1000000đ");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(126, 73, 145, 37);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số Hóa Đơn:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(50, 154, 96, 31);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("100");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(152, 154, 96, 31);
		panel_2.add(lblNewLabel_2_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(169, 169, 169));
		panel_2_1.setBounds(390, 10, 370, 206);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblTunNy = new JLabel("Tuân Này");
		lblTunNy.setFont(new Font("Kristen ITC", Font.PLAIN, 33));
		lblTunNy.setBounds(125, 10, 155, 52);
		panel_2_1.add(lblTunNy);
		
		JLabel lblNewLabel_1_1 = new JLabel("1000000đ");
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(135, 73, 145, 37);
		panel_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("100");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_1.setBounds(155, 151, 96, 31);
		panel_2_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Số Hóa Đơn:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(53, 151, 96, 31);
		panel_2_1.add(lblNewLabel_2_3);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(255, 182, 193));
		panel_2_2.setBounds(772, 10, 365, 206);
		panel_1.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel lblThngNy = new JLabel("Tháng Này");
		lblThngNy.setFont(new Font("Kristen ITC", Font.PLAIN, 33));
		lblThngNy.setBounds(105, 10, 184, 52);
		panel_2_2.add(lblThngNy);
		
		JLabel lblNewLabel_1_2 = new JLabel("1000000đ");
		lblNewLabel_1_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(117, 72, 145, 37);
		panel_2_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("100");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_2.setBounds(160, 152, 96, 31);
		panel_2_2.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_4 = new JLabel("Số Hóa Đơn:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(58, 152, 96, 31);
		panel_2_2.add(lblNewLabel_2_4);
		
		
		
	}
}
