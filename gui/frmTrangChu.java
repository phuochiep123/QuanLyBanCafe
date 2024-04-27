package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;

public class frmTrangChu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlMenu;
	JPanel jpnMenuIcon;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JPanel pnlTienMat ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTrangChu frame = new frmTrangChu();
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
	public frmTrangChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        
        setBounds(0, 0, 1515, 790);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(205,201,195,255));
        contentPane.setBounds(0, 0, screenWidth, screenHeight);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        pnlMenu = new JPanel();
        pnlMenu.setBackground(new Color(151,181,173,255));
        pnlMenu.setBounds(10, 0, 0, 742);
        contentPane.add(pnlMenu);
        pnlMenu.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 229, 153);
        pnlMenu.add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dongMenu();
        	}
        });
        btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\code_JAVA\\CoffeeShop\\img\\iconclose.png"));
        btnNewButton_2.setBounds(205, 0, 24, 21);
        panel.add(btnNewButton_2);
        
        JPanel panel_9 = new JPanel();
        panel_9.setBounds(0, 173, 239, 507);
        pnlMenu.add(panel_9);
        panel_9.setLayout(new GridLayout(7, 1, 0, 0));
        
        JButton btnNewButton = new JButton("Trang chủ");
        panel_9.add(btnNewButton);
        
        JButton btnHan = new JButton("Hóa Đơn");
        panel_9.add(btnHan);
        
        JButton btnKhuynMi = new JButton("Khuyến mãi");
        panel_9.add(btnKhuynMi);
        
        JButton btnSnPhm = new JButton("Sản phẩm");
        panel_9.add(btnSnPhm);
        
        JButton btnQunLKhch = new JButton("Quản lý khách hàng");
        panel_9.add(btnQunLKhch);
        
        JButton btnQunLNhn = new JButton("Quản lý nhân viên");
        panel_9.add(btnQunLNhn);
        
        JButton btnThngK = new JButton("Thống kê");
        panel_9.add(btnThngK);
        
        JPanel pnlNoiDung = new JPanel();
        pnlNoiDung.setBounds(10, 58, 1479, 697);
        contentPane.add(pnlNoiDung);
        pnlNoiDung.setLayout(null);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_3.setBounds(17, 10, 727, 366);
        pnlNoiDung.add(panel_3);
        panel_3.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 21, 707, 335);
        panel_3.add(tabbedPane);
        
        JPanel pnlBanhNgot = new JPanel();
        tabbedPane.addTab("Bánh ngọt", null, pnlBanhNgot, null);
        pnlBanhNgot.setLayout(new GridLayout(5, 5, 0, 0));
        
        JPanel panel_14 = new JPanel();
        tabbedPane.addTab("Thức uống khác", null, panel_14, null);
        panel_14.setLayout(null);
        
        JLabel lblNewLabel_8 = new JLabel("Thức uống khác");
        lblNewLabel_8.setBounds(184, 124, 164, 13);
        panel_14.add(lblNewLabel_8);
        
        JPanel panel_12 = new JPanel();
        tabbedPane.addTab("Cafe", null, panel_12, null);
        tabbedPane.setEnabledAt(2, true);
        panel_12.setLayout(null);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m \u0111\u01B0\u1EE3c ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4.setBounds(17, 384, 727, 275);
        pnlNoiDung.setBackground(new Color(205,201,195,255));
        pnlNoiDung.add(panel_4);
        panel_4.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setToolTipText("");
        scrollPane.setBounds(10, 20, 714, 257);
        panel_4.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"STT", "T\u00EAn s\u1EA3n ph\u1EA9m", "K\u00EDch th\u01B0\u1EDBc", "Gi\u00E1", "M\u00F4 t\u1EA3", "Lo\u1EA1i"
        	}
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(34);
        table.getColumnModel().getColumn(1).setPreferredWidth(79);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        scrollPane.setViewportView(table);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(754, 10, 408, 210);
        pnlNoiDung.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel_4 = new JLabel("Số điện thoại:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(10, 22, 111, 23);
        panel_5.add(lblNewLabel_4);
        
        textField = new JTextField();
        textField.setBounds(117, 20, 190, 23);
        panel_5.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton_4 = new JButton("Tìm");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_4.setBounds(322, 22, 63, 21);
        panel_5.add(btnNewButton_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("Họ tên:");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1.setBounds(10, 66, 96, 23);
        panel_5.add(lblNewLabel_4_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(117, 68, 190, 23);
        panel_5.add(textField_1);
        
        JLabel lblNewLabel_5 = new JLabel("Khách hàng chưa tồn tại!");
        lblNewLabel_5.setBounds(116, 45, 173, 13);
        panel_5.add(lblNewLabel_5);
        
        JLabel lblNewLabel_4_1_1 = new JLabel("Giới tính:");
        lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1.setBounds(10, 106, 75, 23);
        panel_5.add(lblNewLabel_4_1_1);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
        rdbtnNewRadioButton.setBounds(117, 109, 51, 21);
        panel_5.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnN = new JRadioButton("Nữ");
        rdbtnN.setBounds(185, 109, 51, 21);
        panel_5.add(rdbtnN);
        
        JLabel lblNewLabel_4_1_1_1 = new JLabel("Điểm tích lũy:");
        lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1.setBounds(10, 139, 111, 23);
        panel_5.add(lblNewLabel_4_1_1_1);
        
        JLabel lblNewLabel_6 = new JLabel("0");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_6.setBounds(117, 144, 45, 13);
        panel_5.add(lblNewLabel_6);
        
        JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Mã KH:");
        lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1_1.setBounds(10, 166, 51, 23);
        panel_5.add(lblNewLabel_4_1_1_1_1);
        
        JLabel lblNewLabel_6_1 = new JLabel("---");
        lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_6_1.setBounds(117, 172, 45, 13);
        panel_5.add(lblNewLabel_6_1);
        
        JButton btnNewButton_5 = new JButton("+");
        btnNewButton_5.setBounds(322, 69, 51, 21);
        panel_5.add(btnNewButton_5);
        
        JPanel pnlThanhToan = new JPanel();
        pnlThanhToan.setBorder(new TitledBorder(null, "Th\u00F4ng tin thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlThanhToan.setBounds(754, 446, 736, 225);
        pnlNoiDung.add(pnlThanhToan);
        pnlThanhToan.setLayout(null);
        
        JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Số lượng sản phẩm:");
        lblNewLabel_4_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1_2.setBounds(10, 22, 150, 23);
        pnlThanhToan.add(lblNewLabel_4_1_1_1_2);
        
        JLabel lblNewLabel_4_1_1_1_2_1 = new JLabel("Phí VAT:");
        lblNewLabel_4_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1_2_1.setBounds(10, 55, 150, 23);
        pnlThanhToan.add(lblNewLabel_4_1_1_1_2_1);
        
        JLabel lblNewLabel_4_1_1_1_2_2 = new JLabel("Tổng tiền:");
        lblNewLabel_4_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1_2_2.setBounds(10, 99, 91, 23);
        pnlThanhToan.setBackground(new Color(151,181,173,255));
        pnlThanhToan.add(lblNewLabel_4_1_1_1_2_2);
        
        JLabel lblNewLabel_4_1_1_1_2_3 = new JLabel("Hình thức thanh toán:");
        lblNewLabel_4_1_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1_2_3.setBounds(10, 143, 150, 23);
        pnlThanhToan.add(lblNewLabel_4_1_1_1_2_3);
        
        JLabel lblNewLabel_4_1_1_1_2_4 = new JLabel("10");
        lblNewLabel_4_1_1_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1_2_4.setBounds(190, 22, 45, 23);
        pnlThanhToan.add(lblNewLabel_4_1_1_1_2_4);
        
        JLabel lblNewLabel_4_1_1_1_2_4_1 = new JLabel("100 đ");
        lblNewLabel_4_1_1_1_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1_2_4_1.setBounds(190, 55, 45, 23);
        pnlThanhToan.add(lblNewLabel_4_1_1_1_2_4_1);
        
        JLabel lblNewLabel_4_1_1_1_2_4_1_1 = new JLabel("1.000.000đ");
        lblNewLabel_4_1_1_1_2_4_1_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_4_1_1_1_2_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_4_1_1_1_2_4_1_1.setBounds(188, 97, 150, 23);
        pnlThanhToan.add(lblNewLabel_4_1_1_1_2_4_1_1);
        JComboBox cboThanhToan = new JComboBox();
        cboThanhToan.setModel(new DefaultComboBoxModel(new String[] {"Chuyển khoản", "Tiền mặt"}));
        cboThanhToan.setBounds(170, 146, 150, 31);
        pnlThanhToan.add(cboThanhToan);
        
        pnlTienMat = new JPanel();
        cboThanhToan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String phuongThucThanhToan = (String) cboThanhToan.getSelectedItem();
        		if(phuongThucThanhToan.equals("Chuyển khoản")) {
        			pnlTienMat.setVisible(false);
        		}else {
        			pnlTienMat.setVisible(true);
        		}
        	}
        });
        pnlTienMat.setBounds(348, 21, 369, 131);
        pnlThanhToan.add(pnlTienMat);
        pnlTienMat.setVisible(false);
        pnlTienMat.setLayout(null);
        
        JLabel lblNewLabel_4_1_1_1_2_5 = new JLabel("Tiền khách đưa:");
        lblNewLabel_4_1_1_1_2_5.setBounds(10, 10, 116, 19);
        lblNewLabel_4_1_1_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnlTienMat.add(lblNewLabel_4_1_1_1_2_5);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(124, 10, 88, 23);
        pnlTienMat.add(textField_2);
        
        JButton btnNewButton_4_1 = new JButton("30");
        btnNewButton_4_1.setBounds(124, 42, 63, 21);
        pnlTienMat.add(btnNewButton_4_1);
        
        JButton btnNewButton_4_1_1 = new JButton("50");
        btnNewButton_4_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_4_1_1.setBounds(197, 43, 63, 21);
        pnlTienMat.add(btnNewButton_4_1_1);
        
        JButton btnNewButton_4_1_2 = new JButton("100");
        btnNewButton_4_1_2.setBounds(271, 43, 63, 21);
        pnlTienMat.add(btnNewButton_4_1_2);
        
        JButton btnNewButton_4_1_3 = new JButton("200");
        btnNewButton_4_1_3.setBounds(124, 66, 63, 21);
        pnlTienMat.add(btnNewButton_4_1_3);
        
        JButton btnNewButton_4_1_4 = new JButton("300");
        btnNewButton_4_1_4.setBounds(197, 66, 63, 21);
        pnlTienMat.add(btnNewButton_4_1_4);
        
        JButton btnNewButton_4_1_5 = new JButton("500");
        btnNewButton_4_1_5.setBounds(271, 66, 63, 21);
        pnlTienMat.add(btnNewButton_4_1_5);
        
        JLabel lblNewLabel_4_1_1_1_2_5_1 = new JLabel("Tiền thừa:");
        lblNewLabel_4_1_1_1_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4_1_1_1_2_5_1.setBounds(10, 102, 98, 19);
        pnlTienMat.add(lblNewLabel_4_1_1_1_2_5_1);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(124, 97, 190, 23);
        pnlTienMat.add(textField_3);
        
        JLabel lblNewLabel_7 = new JLabel("000 VNĐ");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_7.setBounds(217, 16, 74, 13);
        pnlTienMat.add(lblNewLabel_7);
        
        JButton btnNewButton_6 = new JButton("THANH TOÁN");
        btnNewButton_6.setBackground(new Color(255, 255, 255));
        btnNewButton_6.setBounds(515, 162, 187, 41);
        pnlThanhToan.add(btnNewButton_6);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new TitledBorder(null, "T\u00ECnh tr\u1EA1ng b\u00E0n tr\u1ED1ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_8.setBounds(1172, 10, 297, 426);
        pnlNoiDung.add(panel_8);
        panel_8.setLayout(null);
        
        JPanel panel_10 = new JPanel();
        panel_10.setBounds(10, 23, 277, 350);
        panel_8.add(panel_10);
        panel_10.setLayout(new GridLayout(6, 3, 0, 0));
        
        JButton btnNewButton_3_1 = new JButton("1");
        btnNewButton_3_1.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1);
        
        JButton btnNewButton_3_2 = new JButton("2");
        btnNewButton_3_2.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_2);
        
        JButton btnNewButton_3_3 = new JButton("3");
        btnNewButton_3_3.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_3);
        
        JButton btnNewButton_3_4 = new JButton("4");
        btnNewButton_3_4.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_4);
        
        JButton btnNewButton_3_5 = new JButton("5");
        btnNewButton_3_5.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_5);
        
        JButton btnNewButton_3 = new JButton("6");
        btnNewButton_3.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3);
        
        JButton btnNewButton_3_1_1 = new JButton("7");
        btnNewButton_3_1_1.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_1);
        
        JButton btnNewButton_3_1_2 = new JButton("8");
        btnNewButton_3_1_2.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_2);
        
        JButton btnNewButton_3_1_3 = new JButton("9");
        btnNewButton_3_1_3.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_3);
        
        JButton btnNewButton_3_1_4 = new JButton("10");
        btnNewButton_3_1_4.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_4);
        
        JButton btnNewButton_3_1_5 = new JButton("11");
        btnNewButton_3_1_5.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_5);
        
        JButton btnNewButton_3_1_6 = new JButton("12");
        btnNewButton_3_1_6.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_6);
        
        JButton btnNewButton_3_1_7 = new JButton("13");
        btnNewButton_3_1_7.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_7);
        
        JButton btnNewButton_3_1_8 = new JButton("14");
        btnNewButton_3_1_8.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_8);
        
        JButton btnNewButton_3_1_9 = new JButton("15");
        btnNewButton_3_1_9.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_9);
        
        JButton btnNewButton_3_1_10 = new JButton("16");
        btnNewButton_3_1_10.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_10);
        
        JButton btnNewButton_3_1_11 = new JButton("17");
        btnNewButton_3_1_11.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_11);
        
        JButton btnNewButton_3_1_12 = new JButton("17");
        btnNewButton_3_1_12.setBackground(new Color(128, 255, 128));
        panel_10.add(btnNewButton_3_1_12);
        
        JLabel lblNewLabel_2 = new JLabel("Xanh: đang trống");
        lblNewLabel_2.setBounds(20, 383, 152, 13);
        panel_8.add(lblNewLabel_2);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "Khuy\u1EBFn m\u00E3i \u0111\u00E3 \u00E1p d\u1EE5ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6.setBounds(754, 230, 408, 206);
        pnlNoiDung.add(panel_6);
        panel_6.setLayout(null);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 20, 388, 157);
        panel_6.add(scrollPane_1);
        
        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"M\u00E3 Khuy\u1EBFn m\u00E3i", "M\u00E3 SP", "Gi\u00E1 g\u1ED1c", "Gi\u00E1 khuy\u1EBFn m\u00E3i"
        	}
        ));
        table_1.getColumnModel().getColumn(0).setPreferredWidth(81);
        table_1.getColumnModel().getColumn(1).setPreferredWidth(55);
        table_1.getColumnModel().getColumn(1).setMinWidth(22);
        table_1.getColumnModel().getColumn(3).setPreferredWidth(82);
        scrollPane_1.setViewportView(table_1);
        
        JPanel pnlKhungL = new JPanel();
        pnlKhungL.setBackground(new Color(151,181,173,255));
        pnlKhungL.setBounds(0, 0, 10, 681);
        pnlNoiDung.add(pnlKhungL);
        
        JPanel pnlKhungB = new JPanel();
        pnlKhungB.setBackground(new Color(151,181,173,255));
        pnlKhungB.setBounds(0, 669, 1481, 12);
        pnlNoiDung.add(pnlKhungB);
        
        JPanel pnlNav = new JPanel();
        pnlNav.setBackground(new Color(151,181,173,255));
        pnlNav.setBounds(10, 0, 1491, 59);
        contentPane.add(pnlNav);
        pnlNav.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Phan Phước Hiệp - Nhân Viên");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(442, 22, 283, 13);
        pnlNav.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("18/04/2024 - 10:10:10");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(158, 15, 295, 31);
        pnlNav.add(lblNewLabel_1);
        
        JButton btnNewButton_1 = new JButton("Thay ca & Đăng xuất");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(1302, 12, 167, 36);
        pnlNav.add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("Đổi mật khẩu");
        btnNewButton_1_1.setBounds(1157, 12, 119, 36);
        pnlNav.add(btnNewButton_1_1);
        
        JLabel lblNewLabel_3 = new JLabel("Trang chủ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(1041, 10, 95, 47);
        pnlNav.add(lblNewLabel_3);
        
        jpnMenuIcon = new JPanel();
        jpnMenuIcon.setBorder(null);
        jpnMenuIcon.setBounds(0, 0, 148, 57);
        pnlNav.add(jpnMenuIcon);
        jpnMenuIcon.setBackground(new Color(151,181,173,255));
        jpnMenuIcon.setLayout(null);
        
        JButton btnMoMenu = new JButton("");
        btnMoMenu.setBounds(10, 10, 47, 43);
        jpnMenuIcon.add(btnMoMenu);
        btnMoMenu.setBackground(new Color(151,181,173,255));
        btnMoMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		moMenuBar();
        	}
        });
        btnMoMenu.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\code_JAVA\\CoffeeShop\\img\\iconmenu.jpg"));
        
        JLabel lblNewLabel_9 = new JLabel("MENU");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_9.setBounds(60, 10, 59, 43);
        jpnMenuIcon.add(lblNewLabel_9);
        
        JPanel pnlKhungR = new JPanel();
        pnlKhungR.setBackground(new Color(151,181,173,255));
        pnlKhungR.setBounds(1485, 0, 16, 755);
        contentPane.add(pnlKhungR);
	}
	/*
	 * Width: 248
	 * height: 808
	 */
	void moMenuBar() {
		new Thread(new Runnable(){
			public void run() {
				jpnMenuIcon.setVisible(false);
				for(int i =0; i < 248; i++) {
					pnlMenu.setSize(i, 808);
					try {
						Thread.sleep(0, 1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	void dongMenu() {
		new Thread(new Runnable() {
			public void run() {
				jpnMenuIcon.setVisible(true);
				for(int i =248; i > 0; i--) {
					pnlMenu.setSize(i, 808);
					try {
						Thread.sleep(0, 1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	 private JPanel addProduct(String name, String imagePath) {
	        JPanel productPanel = new JPanel();
	        productPanel.setLayout(new BorderLayout());

	        JLabel productImage = new JLabel(new ImageIcon(imagePath)); 
	        JLabel productName = new JLabel(name, SwingConstants.CENTER); 

	        productPanel.add(productImage, BorderLayout.CENTER);
	        productPanel.add(productName, BorderLayout.SOUTH);

	        return productPanel;  
	    }
}
