import greenfoot.*;

public class MyWorld extends World 
{
    public int score = 0;
    Label scoreLabel;
    public MyWorld() 
    {
        super(600, 400, 1, false);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        createApple();
    }
    
    /**
     * Game over
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Increase score
     */
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    /**
     * Create a new apple at random location at top of sc\reen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);        
    }
}
