package imageprocessing;

import edu.princeton.cs.introcs.Picture;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;

/**
 * 
 * @author Gavin Fennelly
 * version: 27/10/2015
 * 
 * This class will provide the menu system of this programme.
 * It allows the user to select an image from the list and what they would like to do with it and then asks if 
 * they would like to continue using the program.
 *
 */

public class Driver {
	/**
	 * The main function of this class is getting the user to select an image and asks the user
	  what operation they want to perform on the image.
	 */
	
	/**
     * Starts the application
     * @param args
     */
	
	public static void main(String[] args)
	{
		Driver app = new Driver();
		int runProgramme;
		do
		{
			String fileLocation = app.mainMenu();
			app.chooseAction(fileLocation);
			StdOut.println("Would you like to edit another image? 1 = yes 0 = no.");
			runProgramme = StdIn.readInt();
			while(runProgramme != 1 && runProgramme != 0)
			{
				StdOut.println("Please re-enter your choice. 1 = yes 0 = no.");
				runProgramme = StdIn.readInt();
			}
			if(runProgramme == 0)
			{
				StdOut.println("Goodbye.");
				System.exit(0);
			}
		}
		while(runProgramme == 1);
	}
	/**
	 * 
	 *Provides the menu system so the user can choose which image he wants to use in the programme
	 */
	
	public String mainMenu()
	{
		StdOut.println("Please enter the number of the image you would like to use in the programme thank you.");
		StdOut.println("1. Ballons.");
		StdOut.println("2. Faces.");
		StdOut.println("3. Shapes.");
		StdOut.println("4. Stars.");
		StdOut.println("5. Stones.");
		String choice = "";
		int option = StdIn.readInt();
		while(option < 1 || option > 5)
		{
			StdOut.println("Invalid number, please choose between 1 and 5 only thank you.");
			option = StdIn.readInt();
		}
		switch(option)
		{
			case 1: choice = "images/ballons.png";
			break;
			case 2: choice = "images/faces.jpg";
			break;
			case 3: choice = "images/shapes.jpg";
			break;
			case 4: choice = "images/stars.png";
			break;
			case 5: choice = "images/stones.jpg";
		}
		return choice;
	}
	/**
	 * 
	 *Allows the user to choose an operation to perform on their selected image.
	 */
	
	public void chooseAction(String fileLocation)
	{
		ConnectedComponentImage image = new ConnectedComponentImage(fileLocation);
		StdOut.println("Please choose what you would like to do with this image.");
		StdOut.println("1. Count the components.");
		StdOut.println("2. Create a binary image representation of the original image.");
		StdOut.println("3. Create the image with components in random colours.");
		StdOut.println("4. Surround identified compontents with a box.");
		StdOut.println("5. Get the width and height of the image.");
		StdOut.println("6. Make a greyscale version of the picture.");
		StdOut.println("7. Count the amount of pixels in an image.");
		StdOut.println("8. Show the origional Image.");
		int option = StdIn.readInt();
		while(option < 1 || option > 8)
		{
			StdOut.println("Invalid number, please choose between 1 and 8 only thank you.");
			option = StdIn.readInt();
		}
		switch(option)
		{
			case 1: StdOut.println(image.countComponents());
			break;
			case 2: Picture picture = image.binaryComponentImage();
					picture.show();
			break;
			case 3: int picture1 = image.colourComponentImage();
					
			break;
			case 4: Picture picture2 = image.identifyComponentImage();
					picture2.show();
			break;
			case 5: String picSize = image.sizeOfPic();
			StdOut.println(picSize);
			break;
			case 6: Picture picture3 = image.Greyscale();
					picture3.show();
			break;
			case 7: int area = image.getAmountOfPixels();
					StdOut.println("There is " + area + " pixels in this image.");
			break;
			case 8: picture  = image.origionalImage();
			break;
		}
	}

}
