package BasicProgram;

public class PyramidNumberPattern {

	public static void main(String[] args) {

		int rows = 5;

		for (int i = 1; i <= rows; i++) {
			for (int s = 1; s <= (rows - i); s++) {
				System.out.print("  ");
			}

			int num = i;
			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");
				num++;
			}

			num = num - 2;
			for (int j = 1; j < i; j++) {
				System.out.print(num + " ");
				num--;
			}

			System.out.println();
		}
	}

}
