import LogEsiea.LogEsiea;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Let's rock this project !");
		
		LogEsiea log = new LogEsiea();
		log.setDestination('f');
		
		log.error("Error");
		log.setDestination('t');
		log.wtf("What the fuck ?");
		log.debug("Debug");
		log.info("Info");
	}

}
