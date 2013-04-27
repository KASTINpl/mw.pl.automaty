package pl.mw.automaty;

import java.util.Arrays;

public class aut {
	public int[] liczba = new int[8];
	public int bc = 2; 

	public int getLocate(int p, int x, int n) {
		if (p == 1 && x == 1 && n == 1)
			return 0;
		else if (p == 1 && x == 1 && n == 0)
			return 1;
		else if (p == 1 && x == 0 && n == 1)
			return 2;
		else if (p == 1 && x == 0 && n == 0)
			return 3;
		else if (p == 0 && x == 1 && n == 1)
			return 4;
		else if (p == 0 && x == 1 && n == 0)
			return 5;
		else if (p == 0 && x == 0 && n == 1)
			return 6;
		else if (p == 0 && x == 0 && n == 0)
			return 7;
		else
			return 0;
	}

	public void loadDec(int dec) {
		Arrays.fill(this.liczba, 0);
		int pos = 0;
		while (dec > 0) {
			this.liczba[7-pos] = (dec % 2);
			dec = dec / 2;
			pos += 1;
		}
	}

	public int getBinCode(int locate) {
		return this.liczba[locate];
	}
}
