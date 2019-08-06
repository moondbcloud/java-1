package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MemberInfo extends JFrame {

	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	
	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	private JTextField txtPhone;
	private JTextField txtAddress;
	/**
	 * Create the frame.
	 */
	public MemberInfo() {
		setTitle("Member Information Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemberInformationForm = new JLabel("Member Information Form");
		lblMemberInformationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberInformationForm.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblMemberInformationForm.setBounds(205, 15, 531, 60);
		contentPane.add(lblMemberInformationForm);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(185, 118, 166, 27);
		contentPane.add(txtUserID);
		txtUserID.setColumns(20);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setBounds(185, 160, 166, 27);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(20);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(185, 217, 166, 27);
		contentPane.add(txtPhone);
		txtPhone.setColumns(20);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(185, 270, 166, 27);
		contentPane.add(txtAddress);
		txtAddress.setColumns(20);
		
		JLabel lblNewLabel = new JLabel("UserID");
		lblNewLabel.setBounds(32, 124, 82, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Password");
		lblNewLabel_1.setBounds(32, 166, 136, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(32, 220, 136, 21);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(32, 273, 136, 21);
		contentPane.add(lblAddress);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				sql = "SELECT * FROM members WHERE userid=?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					
					result = pstmt.executeQuery();
					
					while(result.next()) {
						String vuserid = result.getString("userid");
						String vuserpwd = result.getString("userpwd");
						String vphone = result.getString("phone");
						String vaddr = result.getString("address");
						txtUserID.setText(vuserid);
						txtUserPWD.setText(vuserpwd);
						txtPhone.setText(vphone);
						txtAddress.setText(vaddr);
					}// end of while
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSearch.setBounds(18, 431, 129, 29);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String upwd = txtUserPWD.getText();
				String uphone = txtPhone.getText();
				String uaddr = txtAddress.getText();
				if(!chkDuplicate(uid)) {
					sql = "INSERT INTO members VALUES(?,?,?,?)";
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, uid);
						pstmt.setString(2, upwd);
						pstmt.setString(3, uphone);
						pstmt.setString(4, uaddr);
						int rst = pstmt.executeUpdate();
						if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 추가하였습니다.");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "동일한 ID의 레코드가 존재합니다.");
				}// end of if else
			}// end of actionPerformed()
		});
		btnAdd.setBounds(165, 431, 129, 29);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String upwd = txtUserPWD.getText();
				String uphone = txtPhone.getText();
				String uaddr = txtAddress.getText();
				sql = "UPDATE members SET userpwd=?, phone=?, address=? WHERE userid=?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, upwd);
					pstmt.setString(2, uphone);
					pstmt.setString(3, uaddr);
					pstmt.setString(4, uid);
					int rst = pstmt.executeUpdate();
					if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 업데이트하였습니다.");
					txtUserID.setEditable(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(312, 431, 129, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				sql = "DELETE members WHERE userid= ?";
				int rst;
				try {
					rst = pstmt.executeUpdate();
					if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 삭제하였습니다.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(459, 431, 129, 29);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				closeAll();
				dispose();
				LoginForm loginform = new LoginForm();
				loginform.setVisible(true);
			}
		});
		btnExit.setBounds(753, 431, 129, 29);
		contentPane.add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserID.setText("");
				txtUserPWD.setText("");
				txtPhone.setText("");
				txtAddress.setText("");
			}
		});
		
		btnClear.setBounds(606, 431, 129, 29);
		contentPane.add(btnClear);
		

	}// end of MemberInfo()
	
	void dbconnect() {
		// 연결 설정
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버가 로드되지 않았습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스 연결에 문제가 있습니다.");
			e.printStackTrace();
		}
		
	}// end of dbconnect()
	
	boolean chkDuplicate(String newid) {
		boolean exist = false;
		dbconnect();
		
		sql = "SELECT * FROM members WHERE userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newid);
			result = pstmt.executeQuery();
			if(result.next()) {
				exist = true;
			}else exist = false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return exist;
	}//end of chkDuplicate()
	
	void closeAll() {
		if(pstmt != null )
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}//end of closeAll()
}