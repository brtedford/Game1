/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game1;

import java.io.*;
import javalib.impworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import javalib.colors.*;
import java.awt.Color;
import java.awt.geom.*;
import java.util.Random;

/**
 *
 * @author briantedford
 */

//Implementing a game in which the player must navigate a
//gauntlet filled with moving traps and walls

//Victory condition: player reaches goal without losing lives

//Failure ondition: player loses all lives by getting hit by traps


//need to implement:

    //collision detection on walls
    //for player and traps

    //trap randomizer

    //level setup

    //Scoring: +1 upon each goal reached
    //new random level on each goal reached

    //TESTS

    

public class RunGame1 extends World{
   
    //Gameboard as playing field
    //consists of an GameWorld array?
    //all objects "player", "wall", "goal" and "trap" exist within Gameboard
    //as objects with posns corresponding to Gameboard coordinates


 final int screenWidth = 400;
 
 static int level;

 static Player player1;

 static Goal goal1;

 static Wall wall1;
 static Wall wall2;
 static Wall wall3;
 static Wall wall4;
 static Wall wall5;

 static Trap trap1;
 static Trap trap2;
 static Trap trap3;
 static Trap trap4;
 static Trap trap5;

 boolean gameOver;


 public RunGame1(int level, Goal goal1, Player player1, Wall wall1, Wall wall2,
         Wall wall3, Wall wall4, Wall wall5, Trap trap1, Trap trap2, Trap trap3,
         Trap trap4, Trap trap5) {
 super();
 this.level = level;
 this.goal1 = new Goal(new Posn(395,5), 10, new Blue());
 this.player1 = new Player(new Posn(5,395), 10, new Red());

 this.wall1 = new Wall(new Posn(70,350), 10, new Green());
 this.wall2 = new Wall(new Posn(140,280), 10, new Green());
 this.wall3 = new Wall(new Posn(210,210), 10, new Green());
 this.wall4 = new Wall(new Posn(280,140), 10, new Green());
 this.wall5 = new Wall(new Posn(350,70), 10, new Green());

 this.trap1 = new Trap(new Posn(90,370), 10, new Yellow(), 5, false);
 this.trap1 = new Trap(new Posn(160,300), 10, new Yellow(), 4, false);
 this.trap1 = new Trap(new Posn(230,230), 10, new Yellow(), 3, false);
 this.trap1 = new Trap(new Posn(310,160), 10, new Yellow(), 2, false);
 this.trap1 = new Trap(new Posn(370,90), 10, new Yellow(), 1, false);

 }

 public void onKeyEvent (String keyPress) {
     if((! wall1.playerWall(player1) && ! wall2.playerWall(player1)) &&
             (! wall3.playerWall(player1) && ! wall4.playerWall(player1))
         && wall5.playerWall(player1)){

            if (keyPress.equals("up") || (keyPress.equals("down")) ||
                (keyPress.equals("left")) || (keyPress.equals("right"))){

            player1.playMove(keyPress);
 }
            else {}
    }
    }

 public WorldEnd gameOver() {
if((trap1.playerHit(player1) || trap2.playerHit(player1)) ||
    ((trap3.playerHit(player1) || trap4.playerHit(player1))) ||
    trap5.playerHit(player1)){
return new WorldEnd(true, new OverlayImages(this.makeImage(),
new TextImage(new Posn(screenWidth/2, screenWidth/2),
"And They Never Heard From Them Again...", new White()).overlayImages(
new TextImage(new Posn(screenWidth/2, screenWidth/2+25),
"Your Bones Rest On " + level, new White()))));
} else {
return new WorldEnd(false, this.makeImage());
}

}

 public void onTick() {
    trap1.trapMoveX();
    trap2.trapMoveX();
    trap3.trapMoveY();
    trap4.trapMoveY();
    trap5.trapMoveY();
 }

 public void levelUp(){
     if (this.goal1.playerGoal(player1)){

          this.level++;
          this.trap1 = new Trap(new Posn(90,370), 10, new Yellow(),
                  this.trap1.velo * 10 % 9, false);
          this.trap2 = new Trap(new Posn(90,370), 10, new Yellow(),
                  this.trap2.velo * 10 % 9, false);
          this.trap3 = new Trap(new Posn(90,370), 10, new Yellow(),
                  this.trap3.velo * 10 % 9, false);
          this.trap4 = new Trap(new Posn(90,370), 10, new Yellow(),
                  this.trap4.velo * 10 % 9, false);
          this.trap5 = new Trap(new Posn(90,370), 10, new Yellow(),
                  this.trap5.velo * 10 % 9, false);

          RunGame1 gameb = new RunGame1(level, goal1, player1, wall1, wall2,
         wall3, wall4, wall5, trap1, trap2, trap3, trap4, trap5);

          gameb.bigBang(screenWidth, screenWidth, 1);
         
     }

 }

 public WorldImage background = new RectangleImage(new Posn(0, 0), screenWidth, 400, new Color(255, 255, 255));

 public WorldImage makeImage() {
 WorldImage temp = new OverlayImages(background, player1.drawPlayer());
 WorldImage temp2 = temp.overlayImages(goal1.drawGoal(), wall1.drawWall());
 WorldImage temp3 = temp2.overlayImages(wall2.drawWall(), wall3.drawWall());
 WorldImage temp4 = temp3.overlayImages(wall4.drawWall(), wall5.drawWall());
 WorldImage temp5 = temp4.overlayImages(trap1.drawTrap(), trap2.drawTrap());
 WorldImage temp6 = temp5.overlayImages(trap3.drawTrap(), trap4.drawTrap());
 WorldImage finalImage = temp6.overlayImages(trap5.drawTrap());

 return finalImage;
 }



 public static void main(String[] args) {

     MoveTestGame1.theMoveTests();
     OtherTestGame1.theOtherTests();
     System.out.println("Tests passed, initializing dungeon");

    RunGame1 gameb = new RunGame1(level, goal1, player1, wall1, wall2,
         wall3, wall4, wall5, trap1, trap2, trap3, trap4, trap5);

    gameb.bigBang(400, 400, 1);

    }
 
}

    
