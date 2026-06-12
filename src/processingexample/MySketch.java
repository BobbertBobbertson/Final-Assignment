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
    private PImage bg3;
    private PImage bg1c; //
    private PImage bg2c; //
    private PImage bg3c; //
    private PImage bg4c; //
    private Person arrow;
    private Person arrow1;
    private PImage dialog1;
    private PImage death; //
    private Person trigger;
    private Person coffin;
    int stage = 0; 
    
    
    public void settings(){
        size (600,600);
    }
    
    public void setup(){
        bg = loadImage("images/background.jpg");
        bg1 = loadImage("images/interiorhouse.png");
        bg2 = loadImage("images/outsidehouse.png");
        bg3 = loadImage("images/teach.png");
        bg1c = loadImage("images/chase1");
        bg2c = loadImage("images/chase2");
        bg3c = loadImage("images/chase3");
        bg4c = loadImage("images/chase4");
        death = loadImage("images/deathscreen");
        arrow = new Person(this,width/2,height/2,"arrow",99,"images/arrow.png");
        arrow1 = new Person(this,width/2,height/2,"arrow",99,"images/arrow.png");
        trigger = new Person(this,width/2,height/2,"light",99,"images/light.png");
        person1 = new Person(this,width/2, height/2 + 50,"Bob",99,"images/person.png");
        person2 = new Person(this,width/2, height/2,"Rob",99,"images/car.png");
        person3 = new Person(this,width/2,height/2 - height/3,"leave",99,"images/rectangle.png");
        coffin = new Person(this,width/2,height/2,"coffin",99,"images/coffin.png");
        dialog1 = loadImage("images/Dialogue1.png");
        textSize(20);
    }
    
    public void draw(){
        image(bg, 0, 0, width, height);
        //
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
            arrow1.x = height/2;
            arrow1.y = 0;
        }else if(stage == 2){
            image(bg2,0,0,width,height);
            person1.draw();
            arrow.move(700,700);
            arrow1.draw();   
        }else if (stage == 3){
            image(bg3,0,0,width,height);
            person1.draw();
            arrow1.move(700, 700);
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
        if (person1.isCollidingWith(arrow1)){
            stage = 3;image(bg3,0,0,width,height);
            person1.x = height/2;
            person1.y = height/2;
        }
        if (person1.isCollidingWith(coffin)){
            stage = 4;images(bg4,0,0,width,height);
            person1.x = height/2;
            person1.y = height/2;
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

