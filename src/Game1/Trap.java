/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game1;

import java.io.*;
import javalib.funworld.*;
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

    //Trap char
    //Randomly generated initial posn
    //and initial velocity
    //On contact with player
    //playerLife - 1
    //On contact with wall
    //(trapVelocity * -1)

public class Trap {

    public Posn trapLoc;
    public int size;
    public IColor color = new Yellow();
    public int velo;
    public boolean atBound;

    public Trap(Posn trapLoc, int size, IColor color, int velo, boolean atBound){
        this.trapLoc = trapLoc;
        this.size = size;
        this.color = color;
        this.velo = velo;
        this.atBound = atBound;
    }

    //Need to impliment rebound()
    //method which checks for boolean value atBound
    //if false, do nothing
    //if true, velocity must be reversed

    //Reversal of velocity
    //Velocity ust be turned into a series of coordinates

    public void trapMoveX(){
        this.trapLoc.x = (this.trapLoc.x + velo);
    }

    public void trapMoveY() {
        this.trapLoc.y = (this.trapLoc.y + velo);
    }

    boolean atWall (Wall wall1){
        if (((this.trapLoc.x - wall1.wallLoc.x) < size && (this.trapLoc.y - wall1.wallLoc.y) < size)){
            return true;
        }
            else return false;
    }

    public void rebound(){
Wall wall1 = new Wall(new Posn(70,350), 10, new Green());
Wall wall2 = new Wall(new Posn(140,280), 10, new Green());
Wall wall3 = new Wall(new Posn(210,210), 10, new Green());
Wall wall4 = new Wall(new Posn(280,140), 10, new Green());
Wall wall5 = new Wall(new Posn(350,70), 10, new Green());

        if((this.atWall(wall1) || this.atWall(wall2)) ||
    (this.atWall(wall3) || this.atWall(wall4)) ||
    this.atWall(wall5)) {
            this.velo = this.velo * -1;
        }
    }


    public boolean playerHit(Player player1){
        if (((this.trapLoc.x - player1.playLoc.x) < size && (this.trapLoc.y - player1.playLoc.y) < size)){
            return true;
        }
            else return false;
    }

    public WorldImage drawTrap(){
        return new RectangleImage(this.trapLoc, this.size, this.size, this.color);
    }
}
