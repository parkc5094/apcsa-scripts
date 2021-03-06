import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width/2; col < width; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottPixel = null;
    int height = pixels.length;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = 0; row < height / 2; row++)
      {
        topPixel = pixels[row][col];
        bottPixel = pixels[height-1-row][col];
        bottPixel.setColor(topPixel.getColor());
      }
    }
  }
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottPixel = null;
    int height = pixels.length;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = height/2; row < height; row++)
      {
        topPixel = pixels[row][col];
        bottPixel = pixels[height-1-row][col];
        bottPixel.setColor(topPixel.getColor());
      }
    }
  }
  public void mirrorDiagonal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  
	  for (int row = 0; row < pixels.length; row++){
	      for (int col = 0; col < width; col++){
	    	 if(col<pixels.length) { 
	    	  leftPixel = pixels[row][col];
	    	  rightPixel = pixels[col][row];
	    	  leftPixel.setColor(rightPixel.getColor());
	    	 }
	    }
	 } 
  }
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  public void mirrorArms()
  {
    int mirrorPoint = 196;
    Pixel topPixel = null;
    Pixel bottPixel = null;
   // int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 161; row < 196; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 102; col < 295; col++)
      {
        
        topPixel = pixels[row][col];      
        bottPixel = pixels[mirrorPoint - row + mirrorPoint]                       
                         [col];
        bottPixel.setColor(topPixel.getColor());
        //count++;
      }
    }
    //System.out.println(count);
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 344;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    //int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 233; row < 322; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 237; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        //count++;
      }
    }
    //System.out.println(count);
  }
  
  public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical)
  {
    int mirrorPoint;
    
    
    if(vertical) {
    	mirrorPoint = x2;
    	Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        
        // loop through the rows
        for (int row = y1; row < y2; row++)
        {
          // loop from 13 to just before the mirror point
          for (int col = x1; col < mirrorPoint; col++)
          {
            
            leftPixel = pixels[row][col];      
            rightPixel = pixels[row]                       
                             [mirrorPoint - col + mirrorPoint];
            rightPixel.setColor(leftPixel.getColor());
            //count++;
          }
        }
    	
    }
    else {
    	mirrorPoint = x2;
    	Pixel topPixel = null;
        Pixel bottPixel = null;
       // int count = 0;
        Pixel[][] pixels = this.getPixels2D();
        
        // loop through the rows
        for (int row = x1; row < x2; row++)
        {
          // loop from 13 to just before the mirror point
          for (int col = y1; col < mirrorPoint; col++)
          {
            
            topPixel = pixels[row][col];      
            bottPixel = pixels[mirrorPoint - row + mirrorPoint]                       
                             [col];
            bottPixel.setColor(topPixel.getColor());
            //count++;
          }
        }
    	
    }
    //System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  public void createMyCollage()
  {
    Picture barb = new Picture("barbaraS.jpg");
    Picture cater = new Picture("caterpillar.jpg");
    Picture kat = new Picture("KatieFancy.jpg");
    this.copy(barb,10,20);
    this.copy(cater,100,30);
    this.copy(kat,50,50);
    Picture flowerNoBlue = new Picture(cater);
    flowerNoBlue.zeroBlue();
    Picture flowerNoBlue1 = new Picture(kat);
    flowerNoBlue1.grayscaleLuminosity();
    Picture flowerNoBlue2 = new Picture(cater);
    flowerNoBlue2.zeroBlue();
    flowerNoBlue2.mirrorDiagonal();
    this.copy(flowerNoBlue,300,0);
    this.copy(flowerNoBlue2,100,20);
    this.copy(flowerNoBlue1,100,100);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel bottPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color bottColor = null;
    for (int row = 0; row < pixels.length -1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        bottPixel = pixels[row +1][col];
    	bottColor = bottPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else if(row != 0 && leftPixel.colorDistance(bottColor) > edgeDist){
        	leftPixel.setColor(Color.BLACK);
        }
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  public void Negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }
  
  public void edgeDetection2(double amt)
  {
    Pixel currPixel = null;
    Pixel belowPixel = null;
    
    int endY = this.getHeight() -1;
    for (int y = 0; y < endY; y++)
    {
      for (int x = 0; 
           x < this.getWidth(); x++)
      {
        currPixel = this.getPixel(x, y);
        belowPixel = this.getPixel(x, y +1);
        
        if(Math.abs(currPixel.getAverage() - belowPixel.getAverage())< amt)
			currPixel.setColor(Color.WHITE);
		else
			currPixel.setColor(Color.BLACK);
      }
    }
  }
  public void Grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    //grayscaleAverage();
    //grayscaleLightness();
    grayscaleLuminosity();
    
  }
  public void grayscaleAverage()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	  pixelObj.setGrayAverage();
      }
    }
  }
  public void grayscaleLuminosity()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	  pixelObj.setGrayLuminosity();
      }
    }
  }
  public void grayscaleLightness()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	  pixelObj.setGrayLightness();
      }
    }
  }
  
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    //int redT =0, greenT=0, blueT =0;
    
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    		  pixelObj.setRed(pixelObj.getRed()*4);
    		  //pixelObj.setGreen(pixelObj.getGreen() + 20);
      }
    }
    
  }
  
  public void blur(int x, int y, int w, int h) {
	  Pixel thisPixel = null;
	  Pixel topPixel = null;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel bottPixel = null;
	  
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = x; row < x+w; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = y; col < y + h; col++)
	      {
	        /*
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row]                       
	                         [mirrorPoint - col + mirrorPoint];
	        rightPixel.setColor(leftPixel.getColor());
	        count++;*/
	    	  
	    	thisPixel = pixels[row][col];
	    	rightPixel = pixels[row][col+1];
	    	leftPixel = pixels[row][col-1];
	    	topPixel = pixels[row+1][col];
	    	bottPixel = pixels[row-1][col];
	    	int blurredR = (int)((rightPixel.getRed() + leftPixel.getRed() + topPixel.getRed() + bottPixel.getRed())/4);
	    	int blurredB = (int)((rightPixel.getBlue() + leftPixel.getBlue() + topPixel.getBlue() + bottPixel.getBlue())/4);
	    	int blurredG = (int)((rightPixel.getGreen() + leftPixel.getGreen() + topPixel.getGreen() + bottPixel.getGreen())/4);
	    	 Color blur = new Color(blurredR, blurredB, blurredG);
	    	
	    	thisPixel.setColor(blur);
	      }
	    }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
	//Picture p = new SimplePicture();
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
