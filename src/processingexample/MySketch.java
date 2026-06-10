/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processingexample;
import processing.core.PApplet;
import processing.core.PImage;

public class MySketch extends PApplet {
    private Person person1;
    private Person person2;
    private Person person3;
    private PImage bg;
    private PImage bg1;
    private PImage bg2;
    private Person arrow;
    private PImage dialog1;
    int stage = 0; 
    
    
    public void settings(){
        size (600,600);
    }
    
    public void setup(){
        bg = loadImage("images/background.jpg");
        bg1 = loadImage("images/interiorhouse.png");
        bg2 = loadImage("images/outsidehouse.png");
        arrow = new Person(this,width/2,height/2,"arrow",99,"images/arrow.png");
        person1 = new Person(this,width/2, height/2 + 50,"Bob",99,"images/person.png");
        person2 = new Person(this,width/2, height/2,"Rob",99,"images/car.png");
        person3 = new Person(this,width/2,height/2 - height/3,"leave",99,"images/rectangle.png");
        dialog1 = loadImage("images/Dialogue1.png");
        textSize(20);
    }
    
    public void draw(){
        image(bg, 0, 0, width, height);
        
        if (stage == 0){
            fill(0);
            text("My Cultural Story", 20, 50);
            text("Press any key to continue", 20, 100);
            arrow.x = height/2 - 25;
            arrow.y = height/2 + height/3 + 50;
        }else if (stage == 1){
            image(bg1,0,0,width,height);
            person1.draw();
            person2.draw();
            person3.draw();
            arrow.draw();
            arrow.x = height/2 - 25;
            arrow.y = height/2 + height/3 + 50;
        }else if(stage == 2){
            image(bg2,0,0,width,height);
            person1.draw();
            arrow.move(700,700);
            
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
        
        if (person1.isCollidingWith(person2)){
            image(dialog1,50,300);
        }
        if (person1.isCollidingWith(arrow)) {
            stage = 2;image(bg2,0,0,width,height);
            person1.x = height/2 + 90;
            person1.y = height/2 + height/3;
        }
    }
    
    public void keyPressed(){
        if (stage == 0){
            if (keyCode == ENTER){
                stage = 1;image(bg1, 0, 0, width, height);
            }
        }
    }
    
    
}

