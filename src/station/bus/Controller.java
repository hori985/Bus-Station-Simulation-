package station.bus;

import java.awt.event.*;
import javax.swing.*;


class TimeController implements ActionListener{
	private JTextArea time;
	private int timeValue;
	
	TimeController(JTextArea timeboi, int timeValue)
	{
		this.time = timeboi;
		this.timeValue = timeValue;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent time) {
		this.timeValue += 5;
		Time date = new Time();
		date.getTime(this.timeValue);
		this.time.setText(date.DHM);
	}
}


class WaveController implements ActionListener{
	private JTextArea wave;
	
	WaveController(JTextArea waveboi)
	{
		this.wave = waveboi;
	}
	
	@Override
	public void actionPerformed(ActionEvent wave) {
		if(Randomness.waveBack()) this.wave.append("The bus driver waved back! :)\n");
		else this.wave.append("The bus driver showed you the middle finger!\n"); //FINAL DECISION DO NOT CHANGE
	}
}

class TicketController implements ActionListener{
	private JTextArea control;
	
	TicketController(JTextArea controlboi)
	{
		this.control = controlboi;
	}
	
	@Override
	public void actionPerformed(ActionEvent time) {
		this.control.append("The controller fined " + Randomness.fineBus(25) + " people. \n");
	}
}