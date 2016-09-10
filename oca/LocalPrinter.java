public class LocalPrinter {

	public static void main(String... args){
		System.out.println("Starting...");
		
		int i = 0;
		for (String arg : args) {
			System.out.println("Argument "+ ++i + ": " + arg);
		}
		System.out.println("Finishing...");
	}
}
