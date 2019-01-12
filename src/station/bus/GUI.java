package station.bus;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GUI {

	public JFrame frame;
	public JTextArea timeArea;
	public JTextArea textArea; //Event
	public int time;
	public JTextField textArea_1;
	public JTextField textArea_2;
	private Comparator<Bus> comparator;
	public PriorityQueue<Bus> busses;
	public JPanel panel_2;
	public JPanel panel_3;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		time = 0;
		
		this.comparator = new BusComparator();
		this.busses=new PriorityQueue<>(10, comparator); 	//Our city is poor and can only afford 10 busses max!
		this.fillBusses();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 533, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Bus Station");
		
		JButton btnNewButton = new JButton("Pass Time");
		btnNewButton.setBounds(10, 301, 151, 35);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton button = new JButton("Wave at Bus Driver");
		button.setBounds(10, 255, 151, 35);
		frame.getContentPane().add(button);
		
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(171, 209, 346, 127);
		frame.getContentPane().add(scrollPane);
		
		
		JButton button_1 = new JButton("Control Tickets");
		button_1.setBounds(10, 209, 151, 35);
		frame.getContentPane().add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel.setBounds(10, 11, 494, 187);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(157, 85, 181, 10);
		panel.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(157, 11, 181, 52);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textArea_1 = new JTextField();
		panel_2.add(textArea_1);
		textArea_1.setText("Empty");
		panel_2.setBackground(Color.yellow);
		panel_2.setVisible(false);
		
		panel_3 = new JPanel();
		panel_3.setBounds(157, 112, 181, 52);
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		textArea_2 = new JTextField();
		panel_3.add(textArea_2);
		textArea_2.setText("Empty");
		panel_3.setBackground(Color.yellow);
		panel_3.setVisible(false);
		
		timeArea = new JTextArea();
		timeArea.setBounds(366, 11, 116, 44);
		timeArea.setBackground(new Color(240, 240, 240));
		panel.add(timeArea);
		
	
		ActionListener timeButtonPressed = new TimeController(this.timeArea, this.time, this.busses,
				this.panel_2,this.panel_3, this.textArea_1,this.textArea_2,this.textArea);
		btnNewButton.addActionListener(timeButtonPressed);
		
		ActionListener waveButtonPressed = new WaveController(this.textArea,this.textArea_1);
		button.addActionListener(waveButtonPressed);
		
		ActionListener ticketButtonPressed = new TicketController(this.textArea,this.textArea_1,this.textArea_2);
		button_1.addActionListener(ticketButtonPressed);
	}
	
	private void fillBusses() {
		for(int i=0;i<8;i++) {
		this.busses.add(new Bus());
		}
	}
	
}
