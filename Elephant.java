import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Steven 
 * @version April 2025
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantSound.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
   
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        
        // Remove apples if elephant eats it 
        eat();
        animateElephant();
    }
    
    public Elephant()
    {
        for (int i = 0; i < idleRight.length; i++)
        {
           idleRight[i]= new GreenfootImage("images/elephant_idle/idle" + i + ".png"); 
           idleRight[i].scale(100, 100);
        }
        
        for (int i = 0; i < idleLeft.length; i++)
        {
           idleLeft[i]= new GreenfootImage("images/elephant_idle/idle" + i + ".png"); 
           idleLeft[i].mirrorHorizontally();
           idleLeft[i].scale(100, 100);            
        }
        setImage(idleRight[0]);
        animationTimer.mark();
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if (animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if (facing.equals("right"))
        {

            setImage(idleRight[imageIndex]);
            imageIndex =  (imageIndex + 1) % idleRight.length;
        }
        else 
        {
            setImage(idleLeft[imageIndex]);
            imageIndex =  (imageIndex + 1) % idleLeft.length;            
        }
    }
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
