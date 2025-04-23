package JavaPatternProgram;

public class MirrorUpperStarTriangle {

	public static void main(String[] args) {
		int n = 7;

		// Upper Half
		for (int i = 1; i <= n; i++) {

			for (int s = 1; s <= n - i; s++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		for (int i = n; i >= 1; i--) {

			for (int s = 1; s <= n - i; s++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
