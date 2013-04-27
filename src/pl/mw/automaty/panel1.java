package pl.mw.automaty;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class panel1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private aut a = new aut();
	private int start_x = 40; // zacznij od 40% szerokosci ekranu
	private int pixelSize = 4;
	private int width = 775;
	private int height = 450;
	private int tabSize = this.width / this.pixelSize;

	public void refresh(String bc, String type, int start) {
		this.start_x = start;

		if (bc == "Łączenie")
			a.bc = 2;
		else if (bc == "Odbijanie")
			a.bc = 1;
		else
			a.bc = 0;

		a.loadDec(Integer.parseInt(type));

		if (this.getWidth() > 0)
			this.width = this.getWidth();
		if (this.getHeight() > 0)
			this.height = this.getHeight();

		this.tabSize = this.width / this.pixelSize;
		// System.out.println(" dec = "+type);
		// for (int i=0;i<8;i++) System.out.print(" "+a.liczba[i]);
		// System.out.println(" -- ");
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		g.setColor(new Color(250, 250, 250));
		g.fillRect(0, 0, this.width, this.height); // wyczysc plansze

		g.setColor(new Color(50, 100, 0)); // rysuj pixele

		// pierwszy rzad
		int[] t1 = new int[this.tabSize];
		for (int i = 0; i < this.tabSize; i++)
			t1[i] = 0;
		t1[this.tabSize * this.start_x / 100] = 1;

		// tymczasowy rząd
		int[] t2 = new int[this.tabSize];
		for (int i = 0; i < this.tabSize; i++)
			t2[i] = 0;

		// wszystkie wiersze na ekranie *********
		for (int y = 0; y < this.height / this.pixelSize; y++) {
			for (int x = 0; x < this.tabSize; x++) {
				// pokaz 1szy wiersz ******************
				if (y == 0 && t1[x] == 1) {
					g.fillRect(x * this.pixelSize, // position X
							y * this.pixelSize, // position Y
							this.pixelSize, // width
							this.pixelSize // height
					);
				}
				// System.out.print(" "+t1[x]);

				// oblicz stan kazdego elementu wiersza *********************
				if (x == 0 || x == this.tabSize - 1) {
					if (a.bc == 2) {
						if (x == 0)
							t2[x] = a.getBinCode(a.getLocate(
									t1[this.tabSize - 1], t1[x], t1[x + 1]));
						else
							t2[x] = a.getBinCode(a.getLocate(t1[x - 1], t1[x],
									t1[0]));
					} else {
						if (x == 0)
							t2[x] = a.getBinCode(a.getLocate(a.bc, t1[x],
									t1[x + 1]));
						else
							t2[x] = a.getBinCode(a.getLocate(t1[x - 1], t1[x],
									a.bc));
					}
				} else
					t2[x] = a.getBinCode(a.getLocate(t1[x - 1], t1[x],
							t1[x + 1]));

				if (t2[x] == 1)
					g.fillRect(x * this.pixelSize, // position X
							(y + 1) * this.pixelSize, // position Y
							this.pixelSize, // width
							this.pixelSize // height
					);
			}// x
				// System.out.print("\n");
			for (int i = 0; i < this.tabSize; i++)
				t1[i] = t2[i];
		}// f
	}// g
}
