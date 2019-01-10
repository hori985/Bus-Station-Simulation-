package station.bus;

public class Collector {
	private int vigilance;
	
	Collector(){
		this.vigilance=(int)Math.random() * 3;
	}
	
	public int fineBus(int nr) {
		switch(vigilance) {
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
