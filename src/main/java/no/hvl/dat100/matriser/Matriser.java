package no.hvl.dat100.matriser;

public class Matriser {

	// a)
	public static void skrivUt(int[][] matrise) {
		for (int[] rad : matrise) {
			for (int tall : rad) {
				System.out.print(tall + " ");
			}
			System.out.println();
		}
	}

	// b)
	public static String tilStreng(int[][] matrise) {
		StringBuilder tekst = new StringBuilder();
		for (int[] rad : matrise) {
			for (int j = 0; j < rad.length; j++) {
				if (j > 0) tekst.append(' ');
				tekst.append(rad[j]);
			}
			tekst.append('\n');
		}
		return tekst.toString();
	}

	// c)
	public static int[][] skaler(int tall, int[][] matrise) {
		int[][] resultat = new int[matrise.length][];
		for (int i = 0; i < matrise.length; i++) {
			resultat[i] = new int[matrise[i].length];
			for (int j = 0; j < matrise[i].length; j++) {
				resultat[i][j] = tall * matrise[i][j];
			}
		}
		return resultat;
	}

	// d)
	public static boolean erLik(int[][] a, int[][] b) {
		if (a.length != b.length) return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) return false;
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != b[i][j]) return false;
			}
		}
		return true;
	}

	// e) Speiling om hoveddiagonalen.
	public static int[][] speile(int[][] matrise) {
		int n = matrise.length;
		for (int[] rad : matrise) {
			if (rad.length != n) throw new IllegalArgumentException("Matrisen må være kvadratisk");
		}
		int[][] resultat = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) resultat[j][i] = matrise[i][j];
		}
		return resultat;
	}

	// f)
	public static int[][] multipliser(int[][] a, int[][] b) {
		int felles = a.length == 0 ? 0 : a[0].length;
		int kolonner = b.length == 0 ? 0 : b[0].length;
		for (int[] rad : a) {
			if (rad.length != felles) throw new IllegalArgumentException("Ulike radlengder i a");
		}
		for (int[] rad : b) {
			if (rad.length != kolonner) throw new IllegalArgumentException("Ulike radlengder i b");
		}
		if (felles != b.length) throw new IllegalArgumentException("Uforenlige dimensjoner");
		int[][] resultat = new int[a.length][kolonner];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < kolonner; j++) {
				for (int k = 0; k < felles; k++) resultat[i][j] += a[i][k] * b[k][j];
			}
		}
		return resultat;
	}
}
