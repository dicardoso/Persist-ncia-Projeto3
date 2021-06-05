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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class TelaConsultar {

	private JFrame frmConsultar;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button_2;
	private JButton button_3;
	private JButton button;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public TelaConsultar() {
		initialize();
	}

	private void initialize() {
		frmConsultar = new JFrame();
		frmConsultar.setTitle("Consultar");
		frmConsultar.setBounds(100, 100, 505, 323);
		frmConsultar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultar.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 21, 409, 116);
		frmConsultar.getContentPane().add(scrollPane);

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
				new String[] {"", ""}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		button_2 = new JButton("Listar vídeos por assunto");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Link");
					model.addColumn("Nome");
					
					List<Video> lista = Fachada.consultarVideosPorAssunto(textField.getText());
					for(Video v : lista)
						model.addRow(new Object[]{ v.getLink(),v.getNome() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmConsultar,erro.getMessage());
				}
			}
		});
		button_2.setBounds(44, 148, 200, 23);
		frmConsultar.getContentPane().add(button_2);

		button_3 = new JButton("Listar vídeos por usuário");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Link");
					model.addColumn("Nome");
					model.addColumn("Nota");

					List<Video> lista = Fachada.consultarVideosPorUsuario(textField_1.getText());
					
					for(Video v : lista)
						for(Visualizacao vis : v.getVisualizacoes())
							model.addRow(new Object[]{v.getLink(), v.getNome(), vis.getNota()});

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmConsultar,erro.getMessage());
				}
			}
		});
		button_3.setBounds(44, 182, 200, 23);
		frmConsultar.getContentPane().add(button_3);

		button = new JButton("Consultar Usuarios por vídeo");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Usuário");
					
					table.getColumnModel().getColumn(0).setPreferredWidth(10);

					List<Usuario> lista = Fachada.consultarUsuariosPorVideo(textField_2.getText());
					for(Usuario u : lista)
						model.addRow(new Object[]{ u.getEmail()});

					table.setModel(model);
				}
				catch(NumberFormatException erro){
					JOptionPane.showMessageDialog(frmConsultar,"digite somente numero");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmConsultar,erro.getMessage());
				}
			}
		});
		button.setBounds(44, 215, 200, 23);
		frmConsultar.getContentPane().add(button);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(265, 150, 152, 20);
		frmConsultar.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(265, 184, 152, 20);
		frmConsultar.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(265, 217, 152, 20);
		frmConsultar.getContentPane().add(textField_2);

		frmConsultar.setVisible(true);
	}
}
