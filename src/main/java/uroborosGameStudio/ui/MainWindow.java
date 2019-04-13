package uroborosGameStudio.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uroborosGameStudio.domain.appModel.MainWindowModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private MainWindowModel model = new MainWindowModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setTitle("Uroboros Game Studio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnOpenWindow = new JButton("Crear Proyecto Nuevo");
		btnOpenWindow.setBounds(57, 152, 149, 23);
		btnOpenWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.createNewProyect();
				EditorWindow mw = new EditorWindow(model);
				mw.OpenWindow(model);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnOpenWindow);
		
		JButton btnCargarProyecto = new JButton("Abrir Proyecto");
		btnCargarProyecto.setEnabled(false);
		btnCargarProyecto.setBounds(230, 152, 135, 23);
		contentPane.add(btnCargarProyecto);
		
		JLabel lblBienvenidosAUroboros = new JLabel("Bienvenidos a Uroboros Game Studio");
		lblBienvenidosAUroboros.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblBienvenidosAUroboros.setBounds(33, 69, 385, 28);
		contentPane.add(lblBienvenidosAUroboros);
	}
}
