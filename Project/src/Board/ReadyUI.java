package Board;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.MemberDAO;
import MultiChatClient.ChatClientThread;
import VO.FilterWordVO;
import VO.GameVO;
import VO.MemberVO;
import VO.WordVO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ReadyUI extends JFrame implements ActionListener {

	private MemberVO vo;
	private JButton btnChangePassword;
	private JButton btnGameStart;
	private Board board;

	private MemberDAO dao = new MemberDAO();

	public ReadyUI(MemberVO vo) {
		getContentPane().setBackground(Color.WHITE);
		this.vo = vo;
		this.board = board;
		setSize(450, 450);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnChangePassword = new JButton("\uBE44\uBC00\uBC88\uD638\uBCC0\uACBD");
		btnChangePassword.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		btnChangePassword.setBounds(45, 350, 120, 30);
		getContentPane().add(btnChangePassword);
		btnChangePassword.addActionListener(this);

		btnGameStart = new JButton("\uAC8C\uC784\uC2DC\uC791");
		btnGameStart.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		btnGameStart.setBounds(259, 350, 120, 30);
		getContentPane().add(btnGameStart);
		btnGameStart.addActionListener(this);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		lblNewLabel.setBounds(201, 180, 62, 18);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uB4F1\uAE09");
		lblNewLabel_1.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(201, 220, 62, 18);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC2B9\uB960");
		lblNewLabel_2.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(201, 260, 62, 18);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uD50C\uB808\uC774\uD0C0\uC784");
		lblNewLabel_3.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(201, 300, 84, 18);
		getContentPane().add(lblNewLabel_3);

		JLabel idLabel = new JLabel("");
		idLabel.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		idLabel.setBounds(302, 180, 132, 18);
		getContentPane().add(idLabel);

		JLabel gradeLabel = new JLabel("");
		gradeLabel.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		gradeLabel.setBounds(302, 220, 132, 18);
		getContentPane().add(gradeLabel);

		JLabel winningrateLabel = new JLabel("");
		winningrateLabel.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		winningrateLabel.setBounds(302, 260, 132, 18);
		getContentPane().add(winningrateLabel);

		JLabel playtimeLabel = new JLabel("");
		playtimeLabel.setFont(new Font("��������ڵ�", Font.PLAIN, 13));
		playtimeLabel.setBounds(302, 300, 132, 18);
		getContentPane().add(playtimeLabel);

		try {
			idLabel.setText(vo.getId());

			winningrateLabel.setText(vo.getWinningRate() + "%");
			long pt = Long.parseLong(vo.getTotalplaytime());
			int pts = (int) (pt % 60);
			int ptm = (int) (pt % 3600);
			int pth = (int) (pt / 3600);
			playtimeLabel.setText(pth + "h " + ptm + "m " + pts + "s");

			if (Integer.parseInt(vo.getPlaynum()) < 20) // 20�ǹ̸�
			{
			} else if (Float.parseFloat(vo.getWinningRate()) >= 80)// ���̾�
			{
			} else if (Float.parseFloat(vo.getWinningRate()) >= 60)// �÷�
			{
			} else if (Float.parseFloat(vo.getWinningRate()) >= 40)// ���
			{
			} else if (Float.parseFloat(vo.getWinningRate()) >= 20)// �ǹ�
			{
			} else // �����
			{
			}

			JLabel grade_img = new JLabel("");
			grade_img.setIcon(new ImageIcon("grade_default.png"));
			grade_img.setBounds(25, 180, 150, 150);
			getContentPane().add(grade_img);

			JLabel logo = new JLabel("");
			logo.setHorizontalAlignment(SwingConstants.CENTER);
			logo.setIcon(new ImageIcon("logo.png"));
			logo.setBounds(0, 0, 434, 200);
			getContentPane().add(logo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "��й�ȣ����":
			ChangePasswordUI cp = new ChangePasswordUI(vo);
			break;
		case "���ӽ���":////////////////////////////////////////////////////////
			boolean flag = true;
			Board.thread.getUserList();
			/*
			 * for(int i=0;i<ChatClientThread.usernames.size();i++) {
			 * if(vo.getId().equals(ChatClientThread.usernames.get(i))){ flag=false; } }
			 * if(flag) { board.getThread().setUsername(vo.getId()); new Board(vo);
			 * this.dispose(); }else { JOptionPane.showMessageDialog(null,
			 * "�̹����ӵǾ� �ִ� �����Դϴ�.", null, JOptionPane.INFORMATION_MESSAGE); }
			 */
			board.getThread().setUsername(vo.getId());
			System.out.println("���� �������� �ο� ��" + MultiChatServer.ChatServerThread.countuserlist());
			if (MultiChatServer.ChatServerThread.countuserlist() < 3) {
				new WaitingUI();
				this.dispose();
			} else {
				new Board(vo);
				this.dispose();
			}
			break;
		}
	}
}
