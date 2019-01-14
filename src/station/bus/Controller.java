package station.bus;

import java.awt.event.*;
import java.util.PriorityQueue;

import javax.swing.*;

class B{
	static Bus b1;
	static Bus b2;
}


class TimeController implements ActionListener{
	private JTextArea time;
	private int timeValue;
	private PriorityQueue<Bus> busses;
	private JPanel bus1;
	private JPanel bus2;
	private JTextField field1;
	private JTextField field2;
	private JTextArea events;
	
	TimeController(JTextArea timeboi, int timeValue, PriorityQueue<Bus> busses, JPanel panel_2
			,JPanel panel_3, JTextField field_1, JTextField field_2,JTextArea events )
	{
		this.time = timeboi;
		this.timeValue = timeValue;
		this.busses=busses;
		this.bus1=panel_2;
		this.bus2=panel_3;
		this.field1 = field_1;
		this.field2 = field_2;
		this.events = events;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent time) {	
	
	
		this.bus1.setVisible(false);
		this.bus2.setVisible(false);
		if(this.field1.getText().equals("Empty") == false)
			this.events.append("Bus " + this.field1.getText()+" has left the station\n");
		if(this.field2.getText().equals("Empty") == false)
			this.events.append("Bus " + this.field2.getText()+" has left the station.\n");
		
		this.field1.setText("Empty");
		this.field2.setText("Empty");
		
		if(this.busses.peek().getTimeToStation()-this.timeValue < 5) {
			this.timeValue+= this.busses.peek().getTimeToStation() - this.timeValue;
		}else {
			this.timeValue += 5;
		}
		
		if(this.busses.peek().getTimeToStation()==this.timeValue) {
			B.b1=this.busses.poll();
			int late = B.b1.getTimeToStation() - B.b1.getTimeScheduled();
			this.field1.setText(B.b1.getID());
			this.bus1.setVisible(true);
			B.b1.leaveStation();
			this.busses.add(B.b1);
			
			if(late < 0)this.events.append("Bus "+this.field1.getText()+" has entered the station "+ (-1)*late + " minutes early.\n");
			else this.events.append("Bus "+this.field1.getText()+" has entered the station "+ late + " minutes late.\n");
		}
		if(this.busses.peek().getTimeToStation()==this.timeValue) {
			B.b2=this.busses.poll();
			int late = B.b2.getTimeToStation() - B.b2.getTimeScheduled();
			this.field2.setText(B.b2.getID());
			this.bus2.setVisible(true);
			B.b2.leaveStation();
			this.busses.add(B.b2);

			if(late < 0)this.events.append("Bus "+this.field2.getText()+" has entered the station "+ (-1)*late + " minutes early.\n");
			else this.events.append("Bus "+this.field2.getText()+" has entered the station "+ late + " minutes late.\n");
		}
		
		
		Time date = new Time();
		date.getTime(this.timeValue);
		this.time.setText(date.DHM);
	}
}


class WaveController implements ActionListener{
	private JTextArea wave;
	private JTextField isBus;
	
	WaveController(JTextArea waveboi, JTextField isBus)
	{
		this.wave = waveboi;
		this.isBus=isBus;
	}
	
	@Override
	public void actionPerformed(ActionEvent wave) {
		if(this.isBus.getText().equals("Empty")==false) {
		if(Randomness.waveBack()) this.wave.append("The bus driver waved back! :)\n");
		else this.wave.append("The bus driver ignored you.\n"); //FINAL DECISION DO NOT CHANGE
		}
		else
			this.wave.append("You wave at nothing, everybody stares at you like you're crazy.\n");
		}
}

class TicketController implements ActionListener{
	private JTextArea control;
	private JTextField isBus1,isBus2;
	
	TicketController(JTextArea controlboi, JTextField isBus1,JTextField isBus2)
	{
		this.control = controlboi;
		this.isBus1=isBus1;
		this.isBus2=isBus2;
	}
	
	@Override
	public void actionPerformed(ActionEvent time) {
		int fine;
		fine=0;
		
		if(this.isBus2.getText().equals("Empty")==false) {
			fine+=Randomness.fineBus(B.b2.getPassangerNr());
		}
		else
		if(this.isBus1.getText().equals("Empty")==false) {
			fine+=Randomness.fineBus(B.b1.getPassangerNr());
			this.control.append("The controller fined "+ fine + " people \n");
		}
		else
			this.control.append("How can you control no busses? SMH...\n");
		
		
	}
}