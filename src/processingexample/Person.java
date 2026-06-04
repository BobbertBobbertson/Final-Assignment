/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processingexample;

/**
 *
 * @author 342850047
 */
import processing.core.PApplet;
import processing.core.PImage;

public class Person {
    private String name;
    private int age;
    private PImage image;
    private PApplet app;
    private int width, height;
    int x;
    int y;
    public Person(PApplet p, int x, int y, String name, int age, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
        this.image = app.loadImage(imagePath);
        this.width = image.width;
        this.height = image.height;
    }
       public boolean isCollidingWith(Person other) {
    // Check if the bounding boxes of the two persons intersect
    boolean isLeftOfOtherRight = x < other.x + other.width;
    boolean isRightOfOtherLeft = x + width > other.x;
    boolean isAboveOtherBottom = y < other.y + other.height;
    boolean isBelowOtherTop = y + height > other.y;

    return isLeftOfOtherRight && isRightOfOtherLeft 
      && isAboveOtherBottom && isBelowOtherTop;
  }

     public void displayInfo(PApplet p){
         app.fill(0);
         app.text("Name: " + name, x, y -50);
         app.text("Age: ", x, y - 30);
     }

    
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    
    public void draw(){
        app.image(image, x, y);
    }
}
