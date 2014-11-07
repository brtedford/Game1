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

//Code courtesy of our lovely Prof. Jay; we <3 u

 class Testers {

public static void check(String label, Object x, Object y) throws Exception {
if (x != y) {
throw new Exception("\n" + label + ": " + x + " should equal " + y + " but it don't :(");
}
}
public static void check_ints(String label, int x, int y) throws Exception {
if (x != y) {
throw new Exception("\n" + label + ": " + x + " should equal " + y + " but it don't :(");
}
}

}

 class MoveTestGame1 {

 final int screenWidth = 650;
 final int screenHeight = 650;

 static int level;

 static Player player1;

 static Goal goal1;

 static Wall wall1;
 static Wall wall2;
 static Wall wall3;
 static Wall wall4;
 static Wall wall5;

 boolean gameOver;


 public MoveTestGame1(int level, Goal goal1, Player player1, Wall wall1, Wall wall2,
         Wall wall3, Wall wall4, Wall wall5) {
 super();
 this.level = 1;
 this.goal1 = new Goal(new Posn(650,50), 10, new Blue());
 this.player1 = new Player(new Posn(500,650), 10, new Red());

 this.wall1 = new Wall(new Posn(70,350), 10, new Green());
 this.wall2 = new Wall(new Posn(140,280), 10, new Green());
 this.wall3 = new Wall(new Posn(210,210), 10, new Green());
 this.wall4 = new Wall(new Posn(280,140), 10, new Green());
 this.wall5 = new Wall(new Posn(350,70), 10, new Green());

 }

 public static void theMoveTests() throws Exception {

     MoveTestGame1 a = new MoveTestGame1(level, goal1, player1, wall1, wall2,
         wall3, wall4, wall5);

     //player move up test:
     //checks that upon pressing "up"
     //player moves up "size" units
     int initPY = (int) a.player1.playLoc.y;
     a.player1.playMove("up");
     Testers.check_ints("Player Moves Up", initPY - player1.size, a.player1.playLoc.y);

     //player moves down test:
     //checks that upon pressing "down"
     //player moves down "size" units
     int aftPY = (int) a.player1.playLoc.y;
     a.player1.playMove("down");
     Testers.check_ints("Player Moves Down", aftPY + player1.size, a.player1.playLoc.y);

     //player move left test:
     //checks that upon pressing "left"
     //player moves left "size" units
     int initPX = (int) a.player1.playLoc.x;
     a.player1.playMove("left");
     Testers.check_ints("Player Moves Left", initPX - player1.size, a.player1.playLoc.x);

     //player moves right test:
     //checks that upon pressing "right"
     //player moves right "size" units
     int aftPX = (int) a.player1.playLoc.x;
     a.player1.playMove("right");
     Testers.check_ints("Player Moves Right", aftPX + player1.size, a.player1.playLoc.x);

     //Upper boundary test:
     //checks that upon pressing "up" at top of screen,
     //player does not move further
     for (int i = 0; i < 70; i++){
         a.player1.playMove("up");
     }
     Testers.check_ints("player at upper boundary", a.player1.playLoc.y, 5);

     //Lower boundary test:
     //checks that upon pressing "down" at bottom of screen,
     //player does not move further
     for (int i = 0; i < 70; i++){
         a.player1.playMove("down");
     }
     Testers.check_ints("player at lower boundary", a.player1.playLoc.y, 695);

     //Left boundary test:
     //checks that upon pressing "left" at left of screen,
     //player does not move further
     for (int i = 0; i < 70; i++){
         a.player1.playMove("left");
     }
     Testers.check_ints("player at left boundary", a.player1.playLoc.x, 5);

     //Right boundary test:
     //checks that upon pressing "right" at right of screen,
     //player does not move further
     for (int i = 0; i < 70; i++){
         a.player1.playMove("right");
     }
     Testers.check_ints("player at right boundary", a.player1.playLoc.y, 695);

 }

 }

 class OtherTestGame1 {

 final int screenWidth = 650;
 final int screenHeight = 650;

 static int level;

 static Player player1;

 static Goal goal1;

 static Trap trap1;

 boolean gameOver;

 public OtherTestGame1(int level, Goal goal1, Player player1, Trap trap1){
     this.level = 1;
     this.goal1 = new Goal(new Posn(5,5), 10, new Blue());
     this.player1 = new Player(new Posn(5, 695), 10, new Red());
     this.trap1 = new Trap (new Posn(695,695), 10, new Yellow(), 10, false);
 }

 public static void theOtherTests() throws Exception{

     //These next tests require the player1
     //first enter a goal,
     //then hit a trap
     //then die, successfully ending the game
     //in that order

     OtherTestGame1 b = new OtherTestGame1(level, goal1, player1, trap1);

     //Level test:
     //tests that level increases correctly
     //upon player contact with goal
     for (int i = 0; i < 70; i++){
         b.player1.playMove("up");
     }
     Testers.check_ints("Test if player entered goal1", b.level, 2);

     //playerHit and gameOver tests
     //tests successful player collision with trap
     //and subsequent successful worldEnd

     for (int i = 0; i < 70; i++){
         b.player1.playMove("right");
     }
     for (int i = 0; i < 70; i++){
         b.player1.playMove("up");
     }
     Testers.check("Test if player hit trap", b.trap1.playerHit(player1), true);
     Testers.check("Tests if worldEnd was successfully called", b.gameOver, true);
 }

 }
