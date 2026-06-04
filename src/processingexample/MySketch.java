/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processingexample;
import processing.core.PApplet;
import processing.core.PImage;

public class MySketch extends PApplet {
    private Person person1;
    private PImage bg;
    int stage = 0;
    
    public void settings(){
        size (400,400);
    }
    
    public void setup(){
        bg = loadImage("images/background.jpg");
        person1 = new Person(this,width/2, height/2,"Bob",99,"images/person.png");
        textSize(20);
    }
    
    public void draw(){
        image(bg, 0, 0, width, height);
        
        if (stage == 0){
            fill(0);
            text("My Cultural Story", 20, 50);
            text("Press any key to continue", 20, 100);
        }else if (stage == 1){
            person1.draw();
        }
        
        if (keyPressed){
            if (keyCode == LEFT){
                person1.move(-5,0);
            }else if (keyCode == RIGHT){
                person1.move(5,0);
            }else if (keyCode == UP){
                person1.move(0,-5);
            }else if (keyCode == DOWN){
                person1.move(0,5);
            }
        }
        
    }
    
    public void keyPressed(){
        if (stage == 0){
            if (keyCode == ENTER){
                stage = 1;image(bg, 0, 0, width, height);
            }
        }
    }
    
    
}

