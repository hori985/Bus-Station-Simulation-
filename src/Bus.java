package busStation;

public class Bus {
	private int passangerNr;
	private int timeToStation, timeScheduled;
	private String id;
	private int filepath;
	
	Bus()
	{
		this.id = Randomness.generateBusID();
		this.passangerNr = Randomness.generatePassangerNr();
		this.timeScheduled = Randomness.generateTimeScheduled(this.id);
		this.timeToStation = Randomness.generateTimeToStation(this.timeScheduled);
		
		/*TO DO:
		 *ADD FILEPATH
		**/
	}
	
	
	
	public int getPassangerNr() {
		return passangerNr;
	}

	public void setPassangerNr(int passangerNr) {
		this.passangerNr = Randomness.generatePassangerNr();
	}

	public int getTimeToStation() {
		return timeToStation;
	}

	public void setTimeToStation() {
		this.timeToStation += Randomness.generateTimeToStation(this.timeScheduled);
	}

	public int getTimeScheduled() {
		return timeScheduled;
	}

	public void setTimeScheduled() {
		this.timeScheduled += Randomness.generateTimeScheduled(this.id);
	}

	public String getID() {
		return id;
	}

	public int getFilepath() {
		return filepath;
	}

	/*
	public void setFilepath() {
		this.filepath = Randomness.;
	}*/
	
}
