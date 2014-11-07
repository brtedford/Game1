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

    //Wall char
    //Static location
    //Randomly generated for each level
    //reverses velocity of traps on contact
    //obstructs player movement

public class Wall {

    public Posn wallLoc;
    public int size;
    public IColor color = new Green();

    public Wall(Posn wallLoc, int size, IColor color){
        this.wallLoc = wallLoc;
        this.size = size;
        this.color = color;
    }

    boolean playerWall(Player player1){
        if (((this.wallLoc.x - player1.playLoc.x) < size && (this.wallLoc.y - player1.playLoc.y) < size)){
            return true;
        }
            else return false;
    }

    public WorldImage drawWall(){
        return new RectangleImage(this.wallLoc, this.size, this.size, this.color);
    }

}
