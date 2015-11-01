package imageprocessing;


import java.awt.Color;

import edu.princeton.cs.introcs.Picture;


public class Image {



	public static void main(String[] args) {

		Picture pic = new Picture("images/ballons.png");
	
		int maxX = 0;
		int minX = pic.width();
		int maxY = 0;
		int minY = pic.height();

		for (int x = 0; x < pic.width(); x++) {
			for (int y = 0; y < pic.height(); y++) {
				if (!pic.get(x, y).equals(Color.WHITE) ) {

					if (x < minX)
						minX = x;
					if (x > maxX)
						maxX = x;
					if (y < minY)
						minY = y;
					if (y > maxY)
						maxY = y;

				}
			}

		}


		pic.show();
	}

}
