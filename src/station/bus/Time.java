package station.bus;

public class Time {
	public String DHM;
	
	Time()
	{
		DHM = "Day: 0 \n Hour: 0 Minute: 0";
	}
	
	public void getTime(int x)
	{
		int day=0, hour=0, minute=0;
		day = x/(24*60);
		x-=day*24*60;
		hour = x / 60;
		x-=hour*60;
		minute = x;
		
		this.DHM = "Day: "+ day + "\nHour: " + hour + " Minute: " + minute;
	}
	
	
}
