/* * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
public class MyGame extends JComponent implements KeyListener, MouseMotionListener, MouseListener {
    // Height and Width of our game
    static final int WIDTH = 710;
    static final int HEIGHT = 950;
    //images
    BufferedImage cookiezi = loadImage("CookieZi.png");
    BufferedImage blockimg = loadImage("single blockk.png");
    BufferedImage SS = loadImage("SS (superpoints).png");
    
    //ARRAYS
    //block
    ArrayList<Rectangle> blocks = new ArrayList<>();
    //border
    ArrayList<Rectangle> borderwall = new ArrayList<>();
    //point circle things
    ArrayList<Rectangle> points = new ArrayList<>();
    ArrayList<Rectangle> superpoints = new ArrayList<>();
    //health hearts
    //ArrayList
    
    Font pixel = new Font("arial",Font.BOLD,20);
    
    //player
    Rectangle player = new Rectangle(345, 585, 23, 23);
    //moving variables
    int moveX = 0;
    int moveY = 0;
    //keyboard variables
    boolean up = false;
    boolean down = false;
    boolean right = false;
    boolean left = false;
    //colours
    Color border = new Color(255, 74, 243);
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    //To input images
    public BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        } catch (Exception e) {
            System.out.println("Error loading " + filename);
        }
        return img;
    }
    
    int Score = 0;
    
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        // GAME DRAWING GOES HERE 
        g.setColor(Color.BLACK);
        //create background
        g.fillRect(0, 0, 750, 950);
        //Border blocks
        g.setColor(border);
        //go through the blocks
        for (Rectangle block : borderwall) {
            //draw the block
            g.fillRect(block.x, block.y, block.width, block.height);
        }

        //for points
        g.setColor(Color.WHITE);
        for (Rectangle point : points) {
            g.fillOval(point.x, point.y, point.width, point.height);
        }
        
        //super points
        g.setColor(Color.BLACK);
        for (Rectangle superpoint : superpoints) {
            //draw the poitns
            g.drawImage(SS, superpoint.x, superpoint.y, superpoint.height, superpoint.width, null);
        }
        
        //rest of blocks
        g.setColor(Color.BLACK);
        for (Rectangle block : blocks) {
            //draw the block
            for (int x = block.x; x < block.x + block.width; x = x + 30) {
                for (int y = block.y; y < block.y + block.height; y = y + 30) {
                    g.drawImage(blockimg, x, y, 30, 30, null);
                }
            }
        }
        //player
        g.setColor(Color.black);
        g.drawImage(cookiezi, player.x, player.y, player.width, player.height, null);


        //Text
        g.setColor(Color.WHITE);
        g.setFont(pixel);
        g.drawString("Score: "+Score, 35, 40);
        g.drawString("Health:", 500, 40);




        // GAME DRAWING ENDS HERE
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        //initial things to do before game starts

        //add blocks
        //border
        borderwall.add(new Rectangle(0, 850, 325, 17));
        borderwall.add(new Rectangle(385, 850, 325, 17));
        borderwall.add(new Rectangle(0, 80, 17, 780));
        borderwall.add(new Rectangle(693, 80, 17, 780));
        borderwall.add(new Rectangle(0, 80, 325, 17));
        borderwall.add(new Rectangle(385, 80, 325, 17));
        //Inside border blocks
        blocks.add(new Rectangle(55, 130, 60, 60));
        blocks.add(new Rectangle(145, 130, 30, 60));
        blocks.add(new Rectangle(55, 220, 90, 60));
        blocks.add(new Rectangle(570, 220, 90, 60));
        blocks.add(new Rectangle(595, 130, 60, 60));
        blocks.add(new Rectangle(535, 130, 30, 60));
        blocks.add(new Rectangle(55, 310, 30, 90));
        blocks.add(new Rectangle(85, 370, 30, 30));
        blocks.add(new Rectangle(55, 430, 60, 30));
        blocks.add(new Rectangle(85, 460, 30, 30));
        blocks.add(new Rectangle(85, 520, 30, 60));
        blocks.add(new Rectangle(55, 550, 30, 30));
        blocks.add(new Rectangle(55, 610, 30, 30));
        blocks.add(new Rectangle(55, 670, 30, 60));
        blocks.add(new Rectangle(85, 700, 90, 30));
        blocks.add(new Rectangle(55, 760, 120, 60));
        blocks.add(new Rectangle(115, 610, 60, 60));
        blocks.add(new Rectangle(145, 310, 30, 120));
        blocks.add(new Rectangle(145, 460, 30, 120));
        blocks.add(new Rectangle(205, 370, 120, 30));
        blocks.add(new Rectangle(205, 400, 30, 60));
        blocks.add(new Rectangle(205, 520, 30, 90));
        blocks.add(new Rectangle(235, 580, 90, 30));
        blocks.add(new Rectangle(385, 580, 120, 30));
        blocks.add(new Rectangle(475, 520, 30, 60));
        blocks.add(new Rectangle(475, 370, 30, 90));
        blocks.add(new Rectangle(385, 370, 90, 30));
        blocks.add(new Rectangle(265, 310, 180, 30));
        blocks.add(new Rectangle(175, 220, 120, 60));
        blocks.add(new Rectangle(205, 130, 60, 60));
        blocks.add(new Rectangle(205, 310, 30, 30));
        blocks.add(new Rectangle(265, 640, 180, 30));
        blocks.add(new Rectangle(325, 220, 60, 90));
        blocks.add(new Rectangle(325, 670, 60, 90));
        blocks.add(new Rectangle(205, 640, 30, 30));
        blocks.add(new Rectangle(205, 700, 90, 30));
        blocks.add(new Rectangle(205, 760, 60, 60));
        blocks.add(new Rectangle(450, 130, 60, 60));
        blocks.add(new Rectangle(415, 220, 120, 60));
        blocks.add(new Rectangle(475, 310, 30, 30));
        blocks.add(new Rectangle(535, 310, 30, 120));
        blocks.add(new Rectangle(625, 310, 30, 90));
        blocks.add(new Rectangle(595, 370, 30, 30));
        blocks.add(new Rectangle(595, 430, 60, 30));
        blocks.add(new Rectangle(595, 460, 30, 30));
        blocks.add(new Rectangle(595, 520, 30, 60));
        blocks.add(new Rectangle(625, 550, 30, 30));
        blocks.add(new Rectangle(535, 460, 30, 120));
        blocks.add(new Rectangle(535, 610, 60, 60));
        blocks.add(new Rectangle(475, 640, 30, 30));
        blocks.add(new Rectangle(415, 700, 90, 30));
        blocks.add(new Rectangle(445, 760, 60, 60));
        blocks.add(new Rectangle(535, 760, 120, 60));
        blocks.add(new Rectangle(535, 700, 120, 30));
        blocks.add(new Rectangle(625, 670, 30, 30));
        blocks.add(new Rectangle(625, 610, 30, 30));
        //portal things
        blocks.add(new Rectangle(295, 790, 30, 60));
        blocks.add(new Rectangle(385, 790, 30, 60));
        blocks.add(new Rectangle(295, 95, 30, 90));
        blocks.add(new Rectangle(385, 95, 30, 90));
        //'ghost' place, possible 'next-level' tp as well?
        blocks.add(new Rectangle(385, 430, 60, 30));
        blocks.add(new Rectangle(415, 460, 30, 90));
        blocks.add(new Rectangle(265, 430, 60, 30));
        blocks.add(new Rectangle(265, 460, 30, 90));
        blocks.add(new Rectangle(295, 520, 120, 30));

        //Points
        //1st column
        points.add(new Rectangle(35, 140, 8, 8));
        points.add(new Rectangle(35, 170, 8, 8));
        points.add(new Rectangle(35, 200, 8, 8));
        points.add(new Rectangle(35, 230, 8, 8));
        points.add(new Rectangle(35, 260, 8, 8));
        points.add(new Rectangle(35, 290, 8, 8));
        points.add(new Rectangle(35, 320, 8, 8));
        points.add(new Rectangle(35, 350, 8, 8));
        points.add(new Rectangle(35, 380, 8, 8));
        points.add(new Rectangle(35, 410, 8, 8));
        points.add(new Rectangle(35, 440, 8, 8));
        points.add(new Rectangle(35, 470, 8, 8));
        points.add(new Rectangle(35, 500, 8, 8));
        points.add(new Rectangle(35, 530, 8, 8));
        points.add(new Rectangle(35, 560, 8, 8));
        points.add(new Rectangle(35, 590, 8, 8));
        points.add(new Rectangle(35, 620, 8, 8));
        points.add(new Rectangle(35, 650, 8, 8));
        points.add(new Rectangle(35, 680, 8, 8));
        points.add(new Rectangle(35, 710, 8, 8));
        points.add(new Rectangle(35, 740, 8, 8));
        points.add(new Rectangle(35, 770, 8, 8));
        points.add(new Rectangle(35, 800, 8, 8));
        //2nd column
        points.add(new Rectangle(65, 110, 8, 8));
        points.add(new Rectangle(65, 200, 8, 8));
        points.add(new Rectangle(65, 290, 8, 8));
        points.add(new Rectangle(65, 410, 8, 8));
        points.add(new Rectangle(65, 470, 8, 8));
        points.add(new Rectangle(65, 500, 8, 8));
        points.add(new Rectangle(65, 530, 8, 8));
        points.add(new Rectangle(65, 590, 8, 8));
        points.add(new Rectangle(65, 650, 8, 8));
        points.add(new Rectangle(65, 740, 8, 8));
        points.add(new Rectangle(65, 830, 8, 8));
        //3rd column
        points.add(new Rectangle(95, 110, 8, 8));
        points.add(new Rectangle(95, 200, 8, 8));
        points.add(new Rectangle(95, 290, 8, 8));
        points.add(new Rectangle(95, 320, 8, 8));
        points.add(new Rectangle(95, 350, 8, 8));
        points.add(new Rectangle(95, 410, 8, 8));
        points.add(new Rectangle(95, 500, 8, 8));
        points.add(new Rectangle(95, 590, 8, 8));
        points.add(new Rectangle(95, 620, 8, 8));
        points.add(new Rectangle(95, 650, 8, 8));
        points.add(new Rectangle(95, 680, 8, 8));
        points.add(new Rectangle(95, 740, 8, 8));
        points.add(new Rectangle(95, 830, 8, 8));
        //4th column
        points.add(new Rectangle(125, 110, 8, 8));
        points.add(new Rectangle(125, 140, 8, 8));
        points.add(new Rectangle(125, 170, 8, 8));
        points.add(new Rectangle(125, 200, 8, 8));
        points.add(new Rectangle(125, 290, 8, 8));
        points.add(new Rectangle(125, 320, 8, 8));
        points.add(new Rectangle(125, 350, 8, 8));
        points.add(new Rectangle(125, 380, 8, 8));
        points.add(new Rectangle(125, 410, 8, 8));
        points.add(new Rectangle(125, 440, 8, 8));
        points.add(new Rectangle(125, 470, 8, 8));
        points.add(new Rectangle(125, 500, 8, 8));
        points.add(new Rectangle(125, 530, 8, 8));
        points.add(new Rectangle(125, 560, 8, 8));
        points.add(new Rectangle(125, 590, 8, 8));
        points.add(new Rectangle(125, 680, 8, 8));
        points.add(new Rectangle(125, 740, 8, 8));
        points.add(new Rectangle(125, 830, 8, 8));
        //5th column
        points.add(new Rectangle(155, 110, 8, 8));
        points.add(new Rectangle(155, 200, 8, 8));
        points.add(new Rectangle(155, 230, 8, 8));
        points.add(new Rectangle(155, 260, 8, 8));
        points.add(new Rectangle(155, 290, 8, 8));
        points.add(new Rectangle(155, 440, 8, 8));
        points.add(new Rectangle(155, 590, 8, 8));
        points.add(new Rectangle(155, 680, 8, 8));
        points.add(new Rectangle(155, 740, 8, 8));
        points.add(new Rectangle(155, 830, 8, 8));
        //6th column
        points.add(new Rectangle(185, 110, 8, 8));
        points.add(new Rectangle(185, 140, 8, 8));
        points.add(new Rectangle(185, 170, 8, 8));
        points.add(new Rectangle(185, 200, 8, 8));
        points.add(new Rectangle(185, 290, 8, 8));
        points.add(new Rectangle(185, 320, 8, 8));
        points.add(new Rectangle(185, 650, 8, 8));
        points.add(new Rectangle(185, 680, 8, 8));
        points.add(new Rectangle(185, 710, 8, 8));
        points.add(new Rectangle(185, 740, 8, 8));
        points.add(new Rectangle(185, 770, 8, 8));
        points.add(new Rectangle(185, 800, 8, 8));
        points.add(new Rectangle(185, 830, 8, 8));
        //7th column
        points.add(new Rectangle(215, 110, 8, 8));
        points.add(new Rectangle(215, 200, 8, 8));
        points.add(new Rectangle(215, 290, 8, 8));
        points.add(new Rectangle(215, 680, 8, 8));
        points.add(new Rectangle(215, 740, 8, 8));
        points.add(new Rectangle(215, 830, 8, 8));
        //8th column
        points.add(new Rectangle(245, 110, 8, 8));
        points.add(new Rectangle(245, 200, 8, 8));
        points.add(new Rectangle(245, 290, 8, 8));
        points.add(new Rectangle(245, 320, 8, 8));
        points.add(new Rectangle(245, 650, 8, 8));
        points.add(new Rectangle(245, 680, 8, 8));
        points.add(new Rectangle(245, 740, 8, 8));
        points.add(new Rectangle(245, 830, 8, 8));
        //9th column
        points.add(new Rectangle(275, 110, 8, 8));
        points.add(new Rectangle(275, 140, 8, 8));
        points.add(new Rectangle(275, 170, 8, 8));
        points.add(new Rectangle(275, 200, 8, 8));
        points.add(new Rectangle(275, 290, 8, 8));
        points.add(new Rectangle(275, 680, 8, 8));
        points.add(new Rectangle(275, 740, 8, 8));
        points.add(new Rectangle(275, 770, 8, 8));
        points.add(new Rectangle(275, 800, 8, 8));
        points.add(new Rectangle(275, 830, 8, 8));
        //10th column
        points.add(new Rectangle(305, 200, 8, 8));
        points.add(new Rectangle(305, 230, 8, 8));
        points.add(new Rectangle(305, 260, 8, 8));
        points.add(new Rectangle(305, 290, 8, 8));
        points.add(new Rectangle(305, 680, 8, 8));
        points.add(new Rectangle(305, 710, 8, 8));
        points.add(new Rectangle(305, 740, 8, 8));
        points.add(new Rectangle(305, 770, 8, 8));
        //11th column
        points.add(new Rectangle(335, 200, 8, 8));
        points.add(new Rectangle(335, 770, 8, 8));
        //12th column
        points.add(new Rectangle(365, 200, 8, 8));
        points.add(new Rectangle(365, 770, 8, 8));
        //13th column
        points.add(new Rectangle(395, 200, 8, 8));
        points.add(new Rectangle(395, 230, 8, 8));
        points.add(new Rectangle(395, 260, 8, 8));
        points.add(new Rectangle(395, 290, 8, 8));
        points.add(new Rectangle(395, 680, 8, 8));
        points.add(new Rectangle(395, 710, 8, 8));
        points.add(new Rectangle(395, 740, 8, 8));
        points.add(new Rectangle(395, 770, 8, 8));
        //14th column
        points.add(new Rectangle(425, 110, 8, 8));
        points.add(new Rectangle(425, 140, 8, 8));
        points.add(new Rectangle(425, 170, 8, 8));
        points.add(new Rectangle(425, 200, 8, 8));
        points.add(new Rectangle(425, 290, 8, 8));
        points.add(new Rectangle(425, 680, 8, 8));
        points.add(new Rectangle(425, 740, 8, 8));
        points.add(new Rectangle(425, 770, 8, 8));
        points.add(new Rectangle(425, 800, 8, 8));
        points.add(new Rectangle(425, 830, 8, 8));
        //15th column
        points.add(new Rectangle(455, 110, 8, 8));
        points.add(new Rectangle(455, 200, 8, 8));
        points.add(new Rectangle(455, 290, 8, 8));
        points.add(new Rectangle(455, 320, 8, 8));
        points.add(new Rectangle(455, 650, 8, 8));
        points.add(new Rectangle(455, 680, 8, 8));
        points.add(new Rectangle(455, 740, 8, 8));
        points.add(new Rectangle(455, 830, 8, 8));
        //16th column
        points.add(new Rectangle(485, 110, 8, 8));
        points.add(new Rectangle(485, 200, 8, 8));
        points.add(new Rectangle(485, 290, 8, 8));
        points.add(new Rectangle(485, 680, 8, 8));
        points.add(new Rectangle(485, 740, 8, 8));
        points.add(new Rectangle(485, 830, 8, 8));
        //17th column
        points.add(new Rectangle(515, 110, 8, 8));
        points.add(new Rectangle(515, 140, 8, 8));
        points.add(new Rectangle(515, 170, 8, 8));
        points.add(new Rectangle(515, 200, 8, 8));
        points.add(new Rectangle(515, 290, 8, 8));
        points.add(new Rectangle(515, 320, 8, 8));
        points.add(new Rectangle(515, 650, 8, 8));
        points.add(new Rectangle(515, 680, 8, 8));
        points.add(new Rectangle(515, 710, 8, 8));
        points.add(new Rectangle(515, 740, 8, 8));
        points.add(new Rectangle(515, 770, 8, 8));
        points.add(new Rectangle(515, 800, 8, 8));
        points.add(new Rectangle(515, 830, 8, 8));
        //18th column
        points.add(new Rectangle(545, 110, 8, 8));
        points.add(new Rectangle(545, 200, 8, 8));
        points.add(new Rectangle(545, 230, 8, 8));
        points.add(new Rectangle(545, 260, 8, 8));
        points.add(new Rectangle(545, 290, 8, 8));
        points.add(new Rectangle(545, 440, 8, 8));
        points.add(new Rectangle(545, 590, 8, 8));
        points.add(new Rectangle(545, 680, 8, 8));
        points.add(new Rectangle(545, 740, 8, 8));
        points.add(new Rectangle(545, 830, 8, 8));
        //19th column
        points.add(new Rectangle(575, 110, 8, 8));
        points.add(new Rectangle(575, 140, 8, 8));
        points.add(new Rectangle(575, 170, 8, 8));
        points.add(new Rectangle(575, 200, 8, 8));
        points.add(new Rectangle(575, 290, 8, 8));
        points.add(new Rectangle(575, 320, 8, 8));
        points.add(new Rectangle(575, 350, 8, 8));
        points.add(new Rectangle(575, 380, 8, 8));
        points.add(new Rectangle(575, 410, 8, 8));
        points.add(new Rectangle(575, 440, 8, 8));
        points.add(new Rectangle(575, 470, 8, 8));
        points.add(new Rectangle(575, 500, 8, 8));
        points.add(new Rectangle(575, 530, 8, 8));
        points.add(new Rectangle(575, 560, 8, 8));
        points.add(new Rectangle(575, 590, 8, 8));
        points.add(new Rectangle(575, 680, 8, 8));
        points.add(new Rectangle(575, 740, 8, 8));
        points.add(new Rectangle(575, 830, 8, 8));
        //20th column
        points.add(new Rectangle(605, 110, 8, 8));
        points.add(new Rectangle(605, 200, 8, 8));
        points.add(new Rectangle(605, 290, 8, 8));
        points.add(new Rectangle(605, 320, 8, 8));
        points.add(new Rectangle(605, 350, 8, 8));
        points.add(new Rectangle(605, 410, 8, 8));
        points.add(new Rectangle(605, 500, 8, 8));
        points.add(new Rectangle(605, 590, 8, 8));
        points.add(new Rectangle(605, 620, 8, 8));
        points.add(new Rectangle(605, 650, 8, 8));
        points.add(new Rectangle(605, 680, 8, 8));
        points.add(new Rectangle(605, 740, 8, 8));
        points.add(new Rectangle(605, 830, 8, 8));
        //21st column
        points.add(new Rectangle(635, 110, 8, 8));
        points.add(new Rectangle(635, 200, 8, 8));
        points.add(new Rectangle(635, 290, 8, 8));
        points.add(new Rectangle(635, 410, 8, 8));
        points.add(new Rectangle(635, 470, 8, 8));
        points.add(new Rectangle(635, 500, 8, 8));
        points.add(new Rectangle(635, 530, 8, 8));
        points.add(new Rectangle(635, 590, 8, 8));
        points.add(new Rectangle(635, 650, 8, 8));
        points.add(new Rectangle(635, 740, 8, 8));
        points.add(new Rectangle(635, 830, 8, 8));
        //22nd column
        points.add(new Rectangle(665, 140, 8, 8));
        points.add(new Rectangle(665, 170, 8, 8));
        points.add(new Rectangle(665, 200, 8, 8));
        points.add(new Rectangle(665, 230, 8, 8));
        points.add(new Rectangle(665, 260, 8, 8));
        points.add(new Rectangle(665, 290, 8, 8));
        points.add(new Rectangle(665, 320, 8, 8));
        points.add(new Rectangle(665, 350, 8, 8));
        points.add(new Rectangle(665, 380, 8, 8));
        points.add(new Rectangle(665, 410, 8, 8));
        points.add(new Rectangle(665, 440, 8, 8));
        points.add(new Rectangle(665, 470, 8, 8));
        points.add(new Rectangle(665, 500, 8, 8));
        points.add(new Rectangle(665, 530, 8, 8));
        points.add(new Rectangle(665, 560, 8, 8));
        points.add(new Rectangle(665, 590, 8, 8));
        points.add(new Rectangle(665, 620, 8, 8));
        points.add(new Rectangle(665, 650, 8, 8));
        points.add(new Rectangle(665, 680, 8, 8));
        points.add(new Rectangle(665, 710, 8, 8));
        points.add(new Rectangle(665, 740, 8, 8));
        points.add(new Rectangle(665, 770, 8, 8));
        points.add(new Rectangle(665, 800, 8, 8));

        //super points
        superpoints.add(new Rectangle(30,105,25,25));
        superpoints.add(new Rectangle(30,819,25,25));
        superpoints.add(new Rectangle(655,105,25,25));
        superpoints.add(new Rectangle(655,819,25,25));



        //END INITIAL THINGS TO DO
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            if (player.x <= 385 && player.x >= 0 && player.y <= 80) {
                player.x = 350;
                player.y = 825;
            } else if (player.x <= 385 && player.x >= 0 && player.y >= 850) {
                player.x = 350;
                player.y = 90;
            }
            if (left) {
                moveX = -2;
                moveY = 0;
            } else if (right) {
                moveX = 2;
                moveY = 0;
            } else if (up) {
                moveY = -2;
                moveX = 0;
            } else if (down) {
                moveY = 2;
                moveX = 0;
            } else {
                moveX = 0;
                moveY = 0;
            }
            //move the player
            player.x = player.x + moveX;
            player.y = player.y + moveY;
            //if feet of player become lower than the screen
            if (player.y + player.height > HEIGHT) {
                player.y = HEIGHT - player.height;
            }
            //go through all blocks
            for (Rectangle block : blocks) {
                //is the player hitting a block
                if (player.intersects(block)) {
                    //get the collision rectangle
                    Rectangle intersection = player.intersection(block);

                    //fix the x movement
                    if (intersection.width < intersection.height) {
                        //player on the left
                        if (player.x < block.x) {
                            //move the player the overlap
                            player.x = player.x - intersection.width;
                        } else {
                            player.x = player.x + intersection.width;
                        }
                    } else {//fix the y
                        //hit the block with my head
                        if (player.y > block.y) {
                            player.y = player.y + intersection.height;
                            moveY = 0;
                        } else {
                            player.y = player.y - intersection.height;
                            moveY = 0;
                        }
                    }
                }
            }
            //go through all border blocks
            for (Rectangle block : borderwall) {
                //is the player hitting a block
                if (player.intersects(block)) {
                    //get the collision rectangle
                    Rectangle intersection = player.intersection(block);

                    //fix the x movement
                    if (intersection.width < intersection.height) {
                        //player on the left
                        if (player.x < block.x) {
                            //move the player the overlap
                            player.x = player.x - intersection.width;
                        } else {
                            player.x = player.x + intersection.width;
                        }
                    } else {//fix the y
                        //hit the block with my head
                        if (player.y > block.y) {
                            player.y = player.y + intersection.height;
                            moveY = 0;
                        } else {
                            player.y = player.y - intersection.height;
                            moveY = 0;
                        }
                    }
                }
            }

            //removing points from the game and adding them to the score
            //normal points
            for (Rectangle point : points) {
                if (player.intersects(point)) {
                    Score = Score + 100;
                    points.remove(point);
                    break;
                }
            }
            //super points
                //also making the 'monsters' go neutral so player can eat them
            for(Rectangle superpoint : superpoints){
                if(player.intersects(superpoint)){
                    Score = Score + 300;
                    superpoints.remove(superpoint);
                    break;
                }
            }

            // GAME LOGIC ENDS HERE 

            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if (deltaTime > desiredTime) {
                //took too much time, don't wait
            } else {
                try {
                    Thread.sleep(desiredTime - deltaTime);
                } catch (Exception e) {
                };
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
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        //add the listeners
        frame.addKeyListener(game); //keyboard
        game.addMouseListener(game); //mouse
        game.addMouseMotionListener(game); //mouse

        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            right = true;
        } else if (key == KeyEvent.VK_UP) {
            up = true;
        } else if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            right = false;
        } else if (key == KeyEvent.VK_UP) {
            up = false;
        } else if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
