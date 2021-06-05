package aplicacao_swing;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaPrincipal {
	private JFrame frame;
	private JMenu mnCadastrar;
	private JMenu mnListar;
	private JMenu mnConsultar;
	private JMenuItem mntmCadastrarVideo;
	private JMenuItem mntmCadastrarVisualizacao;
	private JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

				Fachada.inicializar();

				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
			}
		});
		frame.setTitle("Banco de Vídeos");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Banco de vídeos");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(label);
		frame.setResizable(false);


		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//-----------------------------------------------------------------
		mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);

		mntmCadastrarVideo = new JMenuItem("Vídeo");
		mntmCadastrarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaCadastrarVideo();
			}
		});
		mnCadastrar.add(mntmCadastrarVideo);

		mntmCadastrarVisualizacao = new JMenuItem("Visualização");
		mntmCadastrarVisualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaRegistrarVisualizacao();
			}
		});
	
		mnCadastrar.add(mntmCadastrarVisualizacao);

		//-----------------------------------------------------------------
		mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		mnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaListar();
			}
		});
		
		//-----------------------------------------------------------------
		mnConsultar = new JMenu("Consultas");
		mnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaConsultar();	
			}
		});
		menuBar.add(mnConsultar);	
	}
}
