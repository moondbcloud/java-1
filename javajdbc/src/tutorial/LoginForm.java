package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm  frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToJavadb = new JLabel("Welcome to JAVADB Class");
		lblWelcomeToJavadb.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToJavadb.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblWelcomeToJavadb.setBounds(78, 36, 448, 37);
		contentPane.add(lblWelcomeToJavadb);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(388, 114, 166, 27);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setBounds(388, 175, 166, 27);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(267, 117, 104, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(267, 178, 104, 21);
		contentPane.add(lblPassword);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JoinForm joinform = new JoinForm();
				joinform.setVisible(true);
			}
		});
		btnJoin.setBounds(259, 267, 129, 29);
		contentPane.add(btnJoin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// first we need to choose database : DB Connection
				// and add database jar file  to project 
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "madang";
				String pwd = "madang";
				
				try {
					// 연결 설정
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection(url, user, pwd);
					// id와 pwd 입력 받기
					String uid = txtUserID.getText();
					String upwd = txtUserPWD.getText();
					
					// 질의 구성
					String sql = "SELECT * FROM members WHERE userid=? AND userpwd=?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					pstmt.setString(2, upwd);
					
					// 질의 실행
					ResultSet result = pstmt.executeQuery();

					// 결과 처리
					if(result.next()) {
						// 현재 화면을 닫고....
						dispose();
						// 새로운 화면을 생성한 후
						// 관리자에게는 멤머 관리용 화면을 
						if(uid.equals("admin")) {
							MemberInfo membInfo = new MemberInfo();
							membInfo.setVisible(true);
						}else {
							// 기타 멤버에게는 일반 사용자용 화면을....
							UserForm userForm = new UserForm();
							userForm.setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
					}

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
			
		});
		btnLogin.setBounds(425, 267, 129, 29);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(17, 114, 166, 214);
		contentPane.add(label);
	}
}














