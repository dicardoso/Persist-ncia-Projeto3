package aplicacao_swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaCadastrarVideo {
	private JFrame frame;
	private JLabel lbLink;
	private JLabel lbNome;
	private JLabel lbAssunto;
	private JLabel lbMenssagem;
	private JTextField tfLink;
	private JTextField tfNome;
	private JTextField tfAssunto;
	private JButton button;

	public TelaCadastrarVideo() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Cadastro vídeo");
		frame.setBounds(100, 100, 300, 211);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbLink = new JLabel("Link:");
		lbLink.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbLink.setBounds(10, 26, 71, 14);
		frame.getContentPane().add(lbLink);
		
		tfLink = new JTextField();
		tfLink.setBounds(91, 23, 141, 20);
		frame.getContentPane().add(tfLink);
		tfLink.setColumns(10);
		
		lbNome = new JLabel("Nome:");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbNome.setBounds(10, 54, 71, 14);
		frame.getContentPane().add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(91, 51, 116, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		lbAssunto = new JLabel("Assunto:");
		lbAssunto.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAssunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbAssunto.setBounds(10, 82, 71, 14);
		frame.getContentPane().add(lbAssunto);
		
		tfAssunto = new JTextField();
		tfAssunto.setBounds(91, 79, 116, 20);
		frame.getContentPane().add(tfAssunto);
		tfAssunto.setColumns(10);
		
		lbMenssagem = new JLabel("");
		lbMenssagem.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMenssagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbMenssagem.setBounds(10, 140, 200, 14);
		frame.getContentPane().add(lbMenssagem);
		
		button = new JButton("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String link = tfLink.getText();
					String nome = tfNome.getText();
					String assunto = tfAssunto.getText();
					Fachada.cadastrarVideo(link, nome, assunto);
					tfLink.setText("");
					tfNome.setText("");
					tfAssunto.setText("");
					lbMenssagem.setText("cadastro realizado");
				}
				catch(Exception e) {
					lbMenssagem.setText(e.getMessage());
				}
			}
		});
		button.setBounds(80, 114, 108, 23);
		frame.getContentPane().add(button);
		
		
		
		
		frame.setVisible(true);
	}
}
