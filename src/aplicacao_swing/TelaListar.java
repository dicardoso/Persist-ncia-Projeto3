package aplicacao_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class TelaListar {

	private JFrame frmListar;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button;
	private JButton button_1;
	private JButton button_2;

	public TelaListar() {
		initialize();
	}

	private void initialize() {
		frmListar = new JFrame();
		frmListar.setTitle("Listar");
		frmListar.setBounds(100, 100, 570, 323);
		frmListar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListar.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 33, 462, 116);
		frmListar.getContentPane().add(scrollPane);

		table = new JTable();
	
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"", "", ""}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		button = new JButton("Listar vídeos");
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Link");
					model.addColumn("Nome");
					model.addColumn("Assuntos");
					model.addColumn("Avaliação");
					
					List<Video> lista = Fachada.listarVideos();
					for(Video v : lista)
						model.addRow(new Object[]{
								v.getLink(),
								v.getNome(),
								v.getPalavras(),
								v.getClassificacao()});

					table.setModel(model);
					}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListar,erro.getMessage());
				}
			}
		});
		button.setBounds(44, 172, 150, 23);
		frmListar.getContentPane().add(button);
		
		button_1 = new JButton("Listar visualizações");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Id");
					model.addColumn("Link");
					model.addColumn("Nome");
					model.addColumn("Nota");
					
					List<Visualizacao> lista = Fachada.listarVisualizacoes();
					for(Visualizacao v : lista)
						model.addRow(new Object[]{
								v.getId(),
								v.getVideo().getLink(),
								v.getVideo().getNome(),
								v.getNota()});

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListar,erro.getMessage());
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setHorizontalAlignment(SwingConstants.CENTER);
		button_1.setBounds(200, 172, 150, 23);
		frmListar.getContentPane().add(button_1);
		
		button_2 = new JButton("Listar usuários");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Email");
					model.addColumn("Visualizações");
					
					List<Usuario> lista = Fachada.listarUsuarios();
					for(Usuario u : lista)
						model.addRow(new Object[]{
								u.getEmail(),
								u.getVisualizacoes()});

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListar,erro.getMessage());
				}
			}
		});
		button_2.setHorizontalAlignment(SwingConstants.CENTER);
		button_2.setBounds(356, 172, 150, 23);
		frmListar.getContentPane().add(button_2);

		frmListar.setVisible(true);
	}
}
