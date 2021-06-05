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

public class TelaRegistrarVisualizacao {
	private JFrame frame;
	private JLabel lbLink;
	private JLabel lbEmail;
	private JLabel lbNota;
	private JLabel lbMenssagem;
	private JTextField tfLink;
	private JTextField tfEmail;
	private JTextField tfNota;
	private JButton button;

	public TelaRegistrarVisualizacao() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Cadastro visualização");
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
		
		lbEmail = new JLabel("Email:");
		lbEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbEmail.setBounds(10, 54, 71, 14);
		frame.getContentPane().add(lbEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(91, 51, 116, 20);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		lbNota = new JLabel("Nota:");
		lbNota.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNota.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbNota.setBounds(10, 82, 71, 14);
		frame.getContentPane().add(lbNota);
		
		tfNota = new JTextField();
		tfNota.setBounds(91, 79, 20, 20);
		frame.getContentPane().add(tfNota);
		tfNota.setColumns(10);
		
		lbMenssagem = new JLabel("");
		lbMenssagem.setHorizontalAlignment(SwingConstants.LEFT);
		lbMenssagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbMenssagem.setBounds(10, 140, 300, 14);
		frame.getContentPane().add(lbMenssagem);
		
		button = new JButton("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String link = tfLink.getText();
					String email = tfEmail.getText();
					String nota = tfNota.getText();
					Fachada.registrarVisualizacao(link, email, Integer.parseInt(nota));
					tfLink.setText("");
					tfEmail.setText("");
					tfNota.setText("");
					lbMenssagem.setText("Vizualização cadastrada");
				}
				catch(Exception e) {
					lbMenssagem.setText("Campo nota deve ser um inteiro");
				}
			}
		});
		button.setBounds(80, 114, 108, 23);
		frame.getContentPane().add(button);
		
		
		
		
		frame.setVisible(true);
	}
}
