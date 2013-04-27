package pl.mw.automaty;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class automaty extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					automaty frame = new automaty();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public automaty() {
		setForeground(UIManager.getColor("Button.highlight"));
		setBackground(Color.WHITE);
		setTitle("Modelowanie Wielkoskalowe - Automaty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

			// =================================	pasek ustawień 	================================
		
		JLabel lblWarunkiBrzegowe = new JLabel("Warunki brzegowe: ");
		panel.add(lblWarunkiBrzegowe);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("Button.highlight"));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Łączenie",
				"Odbijanie", "Zanikanie" }));
		panel.add(comboBox);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("CheckBox.background"));
		textPane.setText("  ");
		panel.add(textPane);

		JLabel lblTyp = new JLabel("Typ: ");
		panel.add(lblTyp);

		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(90, 1, 256, 1));
		panel.add(spinner);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(UIManager.getColor("CheckBox.background"));
		textPane_1.setText("  ");
		panel.add(textPane_1);

		final JSlider slider = new JSlider();
		slider.setMaximum(99);
		slider.setValue(40);
		slider.setMinimum(1);
		panel.add(slider);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(UIManager.getColor("CheckBox.background"));
		textPane_2.setText("  ");
		panel.add(textPane_2);
		
		// =================================	generuj grafike 	================================
		final panel1 panel_1 = new panel1();
		contentPane.add(panel_1, BorderLayout.CENTER);

		// =================================	akcja generowania 	================================
		JButton btnGeneruj = new JButton("GENERUJ");
		btnGeneruj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.refresh( comboBox.getSelectedItem().toString(), spinner.getValue().toString(), slider.getValue() );
			}
		});
		panel.add(btnGeneruj);

		panel_1.refresh( comboBox.getSelectedItem().toString(), spinner.getValue().toString(), slider.getValue() );
	}

}
