/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author pircn0556
 */



// make sure you rename this class if you are doing a copy/paste
public class MyGame extends JComponent{

    //block
    ArrayList<Rectangle> blocks = new ArrayList<>();
    
    
    
    
    
    
    
    // Height and Width of our game
    static final int WIDTH = 710;
    static final int HEIGHT = 950;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    //colours
    Color border = new Color(117,16,53);
    
    
    
    
    public BufferedImage loadImage(String filename){
        BufferedImage img = null;
        try{
            img =ImageIO.read(new File(filename));
        }catch(Exception e){
            System.out.println("Error loading "+filename);
        }
        return img;
    }
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        g.setColor(Color.BLACK);
        //create background
        g.fillRect(0, 0, 750, 950);

        //go through the blocks
        g.setColor(border);
        for (Rectangle block : blocks) {
            //draw the block
            g.fillRect(block.x, block.y, block.width, block.height);
        }
        
        
        
        
        // GAME DRAWING ENDS HERE
    }
    
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run()
    {
        //initial things to do before game starts
        //add blocks
            //border
        blocks.add(new Rectangle(0, 855, 770, 17));
        blocks.add(new Rectangle(0,80,17,780));
        blocks.add(new Rectangle(693,80,17,780));
        blocks.add(new Rectangle(0,80,770,17));
            //Inside border blocks
        blocks.add(new Rectangle(55,130,60,60));
        blocks.add(new Rectangle(145,130,30,60));
        blocks.add(new Rectangle(55,220,90,60));
        blocks.add(new Rectangle(570,220,90,60));
        blocks.add(new Rectangle(600,130,60,60));
        blocks.add(new Rectangle(540,130,30,60));
        blocks.add(new Rectangle(55,310,30,90));
        blocks.add(new Rectangle(85,370,30,30));
        blocks.add(new Rectangle(55,430,60,30));
        blocks.add(new Rectangle(85,460,30,30));
        blocks.add(new Rectangle(85,520,30,60));
        blocks.add(new Rectangle(55,550,30,30));
        blocks.add(new Rectangle(55,610,30,30));
        blocks.add(new Rectangle(55,670,30,60));
        blocks.add(new Rectangle(85,700,90,30));
        blocks.add(new Rectangle(55,760,120,60));
        blocks.add(new Rectangle(115,610,60,60));
        blocks.add(new Rectangle(145,310,30,120));
        blocks.add(new Rectangle(145,460,30,120));
        blocks.add(new Rectangle(205,370,120,30));
        blocks.add(new Rectangle(205,400,30,60));
        blocks.add(new Rectangle(205,520,30,90));
        blocks.add(new Rectangle(235,580,90,30));
        blocks.add(new Rectangle(385,580,120,30));
        blocks.add(new Rectangle(475,520,30,60));
        blocks.add(new Rectangle(475,370,30,90));
        blocks.add(new Rectangle(385,370,90,30));
        blocks.add(new Rectangle(265,310,180,30));
        blocks.add(new Rectangle(175,220,120,60));
        blocks.add(new Rectangle(205,130,60,60));
        blocks.add(new Rectangle(205,310,30,30)); 
        blocks.add(new Rectangle(265,640,180,30));
        blocks.add(new Rectangle(325,220,60,90));
        blocks.add(new Rectangle(325,670,60,90));
        blocks.add(new Rectangle(205,640,30,30));
        blocks.add(new Rectangle(205,700,90,30));
        blocks.add(new Rectangle(205,760,60,60));
        blocks.add(new Rectangle(450,130,60,60));
        blocks.add(new Rectangle(420,220,120,60));
        blocks.add(new Rectangle(480,310,30,30));
        blocks.add(new Rectangle(540,310,30,120));
        blocks.add(new Rectangle(630,310,30,90));
        blocks.add(new Rectangle(600,370,30,30));
        blocks.add(new Rectangle(600,430,60,30));
        blocks.add(new Rectangle(600,460,30,30));
        blocks.add(new Rectangle(600,520,30,60));
        blocks.add(new Rectangle(630,550,30,30));
        blocks.add(new Rectangle(540,460,30,120));
        blocks.add(new Rectangle(540,610,60,60));
        blocks.add(new Rectangle(475,640,30,30));
        blocks.add(new Rectangle(415,700,90,30));
        blocks.add(new Rectangle(445,760,60,60));
        blocks.add(new Rectangle(540,760,120,60));
        blocks.add(new Rectangle(540,700,120,30));
        blocks.add(new Rectangle(630,670,30,30));
        blocks.add(new Rectangle(630,610,30,30));
        
        //portal things
        blocks.add(new Rectangle(295,790,30,65));
        blocks.add(new Rectangle(385,790,30,65));
        blocks.add(new Rectangle(295,95,30,95));
        blocks.add(new Rectangle(385,95,30,95));
        
        
            //'ghost' place, possible 'next-level' tp as well?
        blocks.add(new Rectangle(385,430,60,30));
        blocks.add(new Rectangle(415,460,30,90));
        blocks.add(new Rectangle(265,430,60,30));
        blocks.add(new Rectangle(265,460,30,90));
        blocks.add(new Rectangle(295,520,120,30));
        
        



        //END INITIAL THINGS TO DO
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            

            // GAME LOGIC ENDS HERE 
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if(deltaTime > desiredTime)
            {
                //took too much time, don't wait
            }else
            {
                try
                {
                    Thread.sleep(desiredTime - deltaTime);
                }catch(Exception e){};
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // creates an instance of my game
        MyGame game = new MyGame();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
         
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // starts my game loop
        game.run();
    }
}
