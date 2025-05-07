import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen
 * 
 * Steven  
 * 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel,getWidth()/2, 200);
        prepare();
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,505,75);
        Label label = new Label("press <space> to start", 40);
        addObject(label,286,307);
        label.setLocation(303,301);
        label.setLocation(301,303);
        label.setLocation(311,306);
        label.setLocation(280,311);
        label.setLocation(440,255);
        label.setLocation(297,256);
        label.setLocation(309,251);
    }
}
