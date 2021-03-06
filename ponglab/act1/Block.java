//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;
//after finish
  //to run
  //add folder to build path
  // katie can show me tomorro
  public Block()
  {
	xPos =0;
	yPos =0;
	width =0;
	height =0;

  }

  public Block(int x, int y) {
	  xPos = x;
	  yPos = y;
  }
  //add other Block constructors - x , y , width, height, color
  public Block(int x, int y, int width, int height){
	xPos = x;
	yPos = y;
	this.width = width;
	this.height = height;
  }
  
  public Block(int x, int y, int width, int height, Color col){
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		setColor(col);
	  }

  //add the other set methods
  public void setPos(int x, int y) {
	  setX(x);
	  setY(y);
  }
  public void setX(int x){
	xPos =x;
  }
  public void setY(int y){
	yPos =y;
  }

  public void setColor(Color col)
  {
	  color = col;

  }

  public void draw(Graphics window)
  {
    //uncomment after you write the set and get methods
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
	  window.setColor(col);
	  window.fillRect(getX(), getY(), getWidth(), getHeight());

  }

  public boolean equals(Object obj)
  {
	  Block hi = (Block) obj;
	  return (getX()== hi.getX() && getY() == hi.getY());



//    return false;
  }

  //add the other get methods
 
  public int getX(){
		return xPos;
  }
  public int getY(){
		return yPos;
  }
  
  public int getWidth(){
		return width;
  }
  public int getHeight(){
		return height;
  }
  //add a toString() method  - x , y , width, height, color
  
  public String toString() {
	  return xPos + " " + yPos + " " + width + " " + height + " " + color;
  }
}
