package JavaPatternProgram;

public class PascalPattern {

	public static void main(String[] args) {
		int n = 6; // Number of rows

		for (int i = 0; i < n; i++) {

			for (int space = 0; space < n - i - 1; space++) {
				System.out.print("  ");
			}

			int num = 1;
			for (int j = 0; j <= i; j++) {
				System.out.print(num + "   ");

				num = num * (i - j) / (j + 1);
			}
			System.out.println();
		}
	}

}
