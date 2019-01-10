package station.bus;

public class Bus {
	private int passangerNr;
	private int timeToStation, timeScheduled;
	private String id;
	
	
	Bus()
	{
		this.id = Randomness.generateBusID();
		this.setPassangerNr();
		this.setTimeScheduled();
		this.setTimeToStation();
		
		/*TO DO:
		 *ADD FILEPATH
		**/
	}
	
	public void leaveStation() {
		this.setPassangerNr();
		this.setTimeToStation();
	}
	
	public int getPassangerNr() {
		return passangerNr;
	}

	private void setPassangerNr() {
		this.passangerNr = Randomness.generatePassangerNr();
	}

	public int getTimeToStation() {
		return timeToStation;
	}

	private void setTimeToStation() {
		this.timeToStation += Randomness.generateTimeToStation(this.timeScheduled);
	}

	public int getTimeScheduled() {
		return timeScheduled;
	}

	private void setTimeScheduled() {
		this.timeScheduled += Randomness.generateTimeScheduled(this.id);
	}
	

	public String getID() {
		return id;
	}


	
}
