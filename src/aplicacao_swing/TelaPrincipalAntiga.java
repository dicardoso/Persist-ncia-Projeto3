package aplicacao_swing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaPrincipalAntiga {

	private JFrame frame;
	private JButton btnCadastrarVideo;
	private JButton btnRegistrarVisualizacao;
	private JButton btnListarVideos;
	private JButton btnListarVisualizacao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalAntiga window = new TelaPrincipalAntiga();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipalAntiga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

				Fachada.inicializar();

				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				//label.setIcon(imagem);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				//JOptionPane.showMessageDialog(frame, "banco fechado !");
			}
		});
		frame.setTitle("Vídeos");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnCadastrarVideo = new JButton("Cadastrar Vídeo");
		frame.add(btnCadastrarVideo);
		btnCadastrarVideo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarVideo.setHorizontalAlignment(SwingConstants.CENTER);
		btnCadastrarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastrarVideo();
			}
		});	
		frame.getContentPane().add(btnCadastrarVideo);
		
		btnRegistrarVisualizacao = new JButton("Registrar Visualização");
		frame.add(btnRegistrarVisualizacao);
		btnRegistrarVisualizacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrarVisualizacao.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegistrarVisualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaRegistrarVisualizacao();
			}
		});	
		frame.getContentPane().add(btnRegistrarVisualizacao);
		
		btnListarVideos = new JButton("Listagens");
		frame.add(btnListarVideos);
		btnListarVideos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarVideos.setHorizontalAlignment(SwingConstants.CENTER);
		btnListarVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaListar();
			}
		});	
		frame.getContentPane().add(btnListarVideos);
		
		btnListarVisualizacao = new JButton("Listagem de Visualizações");
		frame.add(btnListarVisualizacao);
		btnListarVisualizacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarVisualizacao.setHorizontalAlignment(SwingConstants.CENTER);
		btnListarVisualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastrarVideo();
			}
		});	
		frame.getContentPane().add(btnListarVisualizacao);
		
		frame.setLayout(new GridLayout(2,2));
		//-----------------------------------------------------------------
		
	}
}
