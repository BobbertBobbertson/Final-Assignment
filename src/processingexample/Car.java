/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processingexample;

import processing.core.PApplet;
import processing.core.PImage;
public class Car {
    private int x, y;
    private PApplet app;
    private PImage image;
    private int speed;
    
    public Car(PApplet p, int x, int y, int speed, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.speed = speed;
        
        this.image = app.loadImage(imagePath);
    }
    
    public void move(int dx, int dy){
        x += dx*speed;
        y += dy*speed;
    }
    
    public void draw(){
        app.image(image,x,y);
    }
    
}
