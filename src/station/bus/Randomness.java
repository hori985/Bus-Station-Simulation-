package station.bus;

public class Randomness {
	
	private static String[] busses = { "24B", "46", "3", "21", "5", "35", "43P", "CORA"};
	public static int[] times = { 35, 40, 33, 50, 46, 34, 26, 67};
	
	static String generateBusID()
	{
		return busses[(int) (Math.random() * busses.length)];
	}
	
	static int generatePassangerNr()
	{
		return (int)(Math.random() * 100);
	}
	
	static int generateTimeScheduled(String id)
	{
		int place = 0;
		for(int i = 0; i < busses.length; i++)
		{
			if (busses[i] == id) 
			{
				place = i; break;
			}
		}
		
		return times[place];
	}
	
	static int generateTimeToStation(int timeScheduled)
	{
		double Meri = Math.random();
		
		if(Meri > 0.6f){ return timeScheduled + (int)(Math.random() * 8); }
		else { return timeScheduled - (int)(Math.random() * 8); }
	}
	
	static boolean waveBack()
	{
		if(Math.random() > 0.65f) { return true; }
		else { return false; }
	}
	
	static int fineBus(int nr) {	
		switch((int)(Math.random() * 2)) {
		case 0:
			return (int)(nr*0.1);
		case 1:
			return (int)(nr*0.2);
		case 2:
			return (int)(nr*0.4);
		default:
			return 0;
		}
	}
}

