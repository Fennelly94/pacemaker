package imageprocessing;

import java.util.HashMap;
import java.util.Random;
import java.awt.Color;
import imageprocessing.Luminance;
import edu.princeton.cs.introcs.Picture;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/*************************************************************************
 *   Compilation: javac ConnectedComponentImage.java
 * 
 * The <tt>ConnectedComponentImage</tt> class
 * <p>
 * You do the rest....
 * 
 * @author Gavin Fennelly
 * Version: 27/10/2015
 *************************************************************************/


public class ConnectedComponentImage {
    
	Picture picture;
	String fileLocation;
	int width;
	int height;
	WeightedQuickUnionUF wqu;

	

	public ConnectedComponentImage(String fileLocation) {
		picture = getPicture(fileLocation);
		this.fileLocation = fileLocation;
		width  = picture.width();
	    height = picture.height();
	    wqu = new WeightedQuickUnionUF(width*height);
	}
	

	/**
	 * Returns the number of components identified in the image.
	 * 
	 * @return the number of components (between 1 and N)
	 */
	
	public int countComponents()
	{
		 {
		 return wqu.count();
		 }
			
		}
	/**
	 * Returns the origional image the way it looked when it was taken from google images
	 * @return
	 */
            		
	public Picture origionalImage()
	{
		Picture pic = new Picture(picture);
	
		pic.show();
		
		return pic;
	
}

	/**
	 * Returns the original image with each object bounded by a box.
	 * 
	 * @return a picture object with all components surrounded by a box
	 */
	public Picture identifyComponentImage() 
	{
		Color line = Color.RED;
		Picture identifiedPicture = new Picture(picture);
		int maxX = 0;
		int minX = identifiedPicture.width();
		int maxY = 0;
		int minY = identifiedPicture.height();
		
		StdOut.println("Please select the colour of the box you would like to use.");
		StdOut.println("1. Red");
		StdOut.println("2. Green");
		StdOut.println("3. Blue");
		int option = StdIn.readInt();
		while(option < 1 || option > 3)
		{
			StdOut.println("Please select a colour between 1 and 3 only thank you.");
			option = StdIn.readInt();
		}
		switch(option)
		{
			case 1: line = Color.RED;
			break;
			case 2: line = Color.GREEN;
			break;
			case 3: line = Color.BLUE;
			break;
		}

		for (int x = 0; x < identifiedPicture.width(); x++) 
		{
			for (int y = 0; y < identifiedPicture.height(); y++) 
			{
				if (!identifiedPicture.get(x, y).equals(Color.WHITE) ) 
				{
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

		for (int x = minX; x <= maxX; x++) 
		{
			identifiedPicture.set(x, minY, line);
			identifiedPicture.set(x, maxY, line);
		}
		for (int y = minY; y <= maxY; y++) 
		{
			identifiedPicture.set(minX, y, line);
			identifiedPicture.set(maxX, y, line);
		}
		return identifiedPicture;
	}

	/**
	 * Returns a picture with each object updated to a random colour.
	 * @return 
	 */
	
	public int colourComponentImage() 
	{
		{
			Random colour = new Random();
			HashMap<Integer, Color> table = new HashMap<Integer, Color>();
			Picture colouredPicture = new Picture(picture);
			countComponents();
			int p=0;
			for(int y = 0; y < height; y++)
			{
				for(int x = 0; x < width; x++)
				{
					return 0;
				}
				
			}
		}
	 	return height;
		
	}
	
	public Picture getPicture(String fileLocation) 
	{
		Picture getPicture = new Picture(fileLocation);
		return getPicture;
	}

	/**
	 * Returns a binarised version of the original image
	 * 
	 * @return a picture object with all components surrounded by a red box
	 */
	public Picture binaryComponentImage() 
	{
		Picture binarisePicture = new Picture(picture);;
        int width  = binarisePicture.width();
        int height = binarisePicture.height();
        double thresholdPixelValue = 130.0;
        
        //Binarises the image using the threshold value.
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = binarisePicture.get(x, y);
                if (Luminance.lum(c) < thresholdPixelValue) {
                	binarisePicture.set(x, y, Color.BLACK);
				} else {
					binarisePicture.set(x, y, Color.WHITE);
				}
               }
        }
        return binarisePicture;
	}
	
	//Returns the width and the height of an image.
	public String sizeOfPic()
	{
		Picture pictureSize = new Picture(picture);
		int width = pictureSize.width();
		int height = pictureSize.height();
		String size = "The width of this image is " + width + " pixels and the height is " + height + " pixels.";
		return size;
	}
	
	//Returns the image in black and white.
	public Picture BandW()
	{
		Picture pic = new Picture(picture);
		for (int i = 0; i < pic.width(); i++) {
			for (int j = 0; j < pic.height(); j++) {
				Color color = pic.get(i, j);
				pic.set(i, j, Luminance.toGray(color));
			}
		}
		return pic;
	}
	
	//Returns the amount of pixels in an image.
	public int getAmountOfPixels()
	{
		int height = picture.height();
		int width = picture.width();
		int area = width*height;
		return area;
	}
	
}

//	public Picture getPicture1(String fileLocation) 
//	{
//		Picture getPicture = new Picture(fileLocation);
//		return getPicture;
//	}




	//private WeightedQuickUnionUF checkPic(Picture pic)
//	{
//		return wqu;
		
//		width = pic.width();
//		height = pic.height();
		
//		WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(width*height);
//		for (int x = 0; x < height; x++) 
//		{
//			for (int y = 0; x < width; y++) 
//			{
//	return wqu;
//			}

		
	
		
			
			
			
			
