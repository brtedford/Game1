/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movingblocks;

+import java.io.*;
+import javalib.funworld.*;
+import javalib.worldcanvas.*;
+import javalib.worldimages.*;
+import javalib.colors.*;
+import java.awt.Color;
+import java.awt.geom.*;

/**
 *
 * @author briantedford
 */

//Implementing a game in which the player must navigate a
//gauntlet filled with moving traps and walls

//Victory condition: player reaches goal without losing lives

//Failure ondition: player loses all lives by getting hit by traps


//needed object classes to implement:

    //Player char "@"
    //moves in 4 directions on button presses
    //May not occupy the same posn as walls
    //Life is lost of occupies the same posn as traps
    //begins in bottomleft corner of Gameboard

    //Gameboard as playing field
    //consists of an GameWorld array?
    //all objects "player", "wall", "goal" and "trap" exist within Gameboard
    //as objects with posns corresponding to Gameboard coordinates

    //Wall char "#"
    //Static location
    //Randomly generated for each level
    //reverses velocity of traps on contact
    //obstructs player movement
    //Borders all edges of Gameboard

    //Goal char "O"
    //Static location
    //Randomly generated for each level
    //On top row of Gameboard

    //Trap char "*"
    //Randomly generated initial posn
    //and initial velocity
    //On contact with player
    //playerLife - 1
    //On contact with wall
    //(trapVelocity * -1)

    //Scoring: +1 upon each goal reached

    //Controls:
    //player movement corresponds with
    //presses of directional arrows
    //for movement UP, DOWN, LEFT, and RIGHT

public class Game1 {

class Player {

    public Posn playLoc;
    public int size;
    public Color color;


    //A player has
    public Player(Posn playLoc, int size, Color color) {
        this.playLoc = playLoc;
        this.size = size;
        this.color = color;
    }

    public void playMove(String keyPress) {
        if(keyPress.equals("right")){
            this.playLoc = new Posn(this.playLoc.x + this.size, this.playLoc.y);
        }
        else if(keyPress.equals("left")){
            this.playLoc = new Posn(this.playLoc.x - this.size, this.playLoc.y);
        }
        else if(keyPress.equals("up")){
            this.playLoc = new Posn(this.playLoc.x, this.playLoc.y + this.size);
        }
        else if(keyPress.equals("down")){
            this.playLoc = new Posn(this.playLoc.x, this.playLoc.y - this.size);
        }
    }

    public WorldImage drawPlayer(){
        return new RectangleImage(this.playLoc, this.size, this.size, this.color);
    }
}

class Wall {

    public Posn wallLoc;
    public int size;
    public Color color;

    public Wall(Posn wallLoc, int size, Color color){
        this.wallLoc = wallLoc;
        this.size = size;
        this.color = color;
    }

    public WorldImage drawWall(){
        return new RectangleImage(this.wallLoc, this.size, this.size, this.color);
    }

}

class Trap {
    public Posn TrapLoc;
    public int size;
    public Color color;
    public int velo;

    public Trap(Posn trapLoc, int size, Color color, int velo){
        this.trapLoc = trapLoc;
        this.size = size;
        this.color = color;
        this.velo = velo;
    }

    public WorldImage drawTrap(){
        return new RectangleImage(this.trapLoc, this.size, this.size, this.color);
    }

}


class gameBoard extends World {
 int width;
 int height;
 Player player1;

 public gameBoard(int width, int height, Toad toady) {
 super();
 this.width = width;
 this.height = height;
 this.player1 = player1;
 }

 public World onKeyEvent (String keyPress) {
 this.player1.playMove(keyPress);
 return new gameBoard(this.width, this.height, this.player1);
 }

 public World onTick() {
 return new gameBoard(650, 650, this.player1);
 }

 public WorldImage background = new RectangleImage(new Posn(0, 0), 700, 700, new Color(255, 255, 255));

 public WorldImage makeImage() {
 return new OverlayImages(background, player1.drawPlayer());
 }



 public static void main(String[] args) {

 gameBoard w = new gameBoard(1200, 500, new Player(new Posn(950, 50), new White(), 25, 25));

 w.bigBang(1200, 500, 0.5);


}

    }
}

    
