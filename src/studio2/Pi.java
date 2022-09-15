package studio2;

public class Pi {

	public static void main(String[] args) {
		double coordX;
		double coordY;
		int count = 0;
		int totalSimulations = 10000000;
		for (int i = 0; i < totalSimulations; i++)
		{
			coordX = Math.pow(Math.random(), 2);
			coordY = Math.pow(Math.random(), 2);
			if (coordX + coordY <= 1)
			{
				count ++;
			}
		}
		double pi = 4 * count / (double) totalSimulations;
		System.out.print("Estimated Pi Value: " + pi);
	}

}
