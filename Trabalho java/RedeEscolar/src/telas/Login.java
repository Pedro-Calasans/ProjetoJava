package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private JTextField tfProntuario;
	private JTextField tfSenha;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(196, 12, 121, 15);
		add(lblLogin);
		
		tfProntuario = new JTextField();
		tfProntuario.setBounds(12, 108, 240, 19);
		add(tfProntuario);
		tfProntuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 151, 70, 15);
		add(lblSenha);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(12, 178, 240, 19);
		add(tfSenha);
		tfSenha.setColumns(10);
		
		JLabel lblPronturio = new JLabel("Prontuário");
		lblPronturio.setBounds(12, 81, 98, 15);
		add(lblPronturio);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setBounds(12, 228, 117, 25);
		add(btnEntrar);

	}
}
