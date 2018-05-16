package Board;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AboutUI extends JFrame implements ActionListener {
	public AboutUI() {
		getContentPane().setBackground(Color.WHITE);
		setSize(450, 468);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon("logo.png"));
		logo.setBounds(0, 12, 434, 200);
		getContentPane().add(logo);

		JLabel lblNewLabel = new JLabel("<html>Project Gaebalgoebal Goebalgaebal <br><br>Team Oguogung <br><br> Chief Programmer<br> JU JAEMIN <br><br>Programmer & DBA <br>& Designer<br> JEON HEEBAE </html>");
		lblNewLabel.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 13));
		lblNewLabel.setBounds(41, 146, 207, 255);
		getContentPane().add(lblNewLabel);

		JLabel lblVersion = new JLabel("Version 1.0.0");
		lblVersion.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 13));
		lblVersion.setBounds(325, 12, 93, 40);
		getContentPane().add(lblVersion);

		JLabel lblThanksTo = new JLabel("<html>Thanks to <br>JSS Sensei <br> Class C no minna</html>");
		lblThanksTo.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 13));
		lblThanksTo.setBounds(175, 307, 130, 67);
		getContentPane().add(lblThanksTo);
		
		JLabel lblcCopyright = new JLabel("<html>(c)Copyright Oguogung's Engineers,<br> Programmers and others , 2018.  <br>All rights reserved.</html>");
		lblcCopyright.setBounds(175, 210, 253, 71);
		getContentPane().add(lblcCopyright);
		
		JLabel lblAllUse = new JLabel("New label");
		lblAllUse.setIcon(new ImageIcon("C:\\Users\\heebae\\Desktop\\ProjectBackup\\\uC804\uCCB4\uC774\uC6A9\uAC00.PNG"));
		lblAllUse.setBounds(20, 10, 50, 58);
		getContentPane().add(lblAllUse);
		
		 
		
		
		setTitle("About");

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
