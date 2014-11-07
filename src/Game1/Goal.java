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
    //Goal char
    //Static location
    //Randomly generated for each level
    //On top row of Gameboard
    //Upon collision with Player
    //Level and Score up 1

public class Goal {

    public Posn goalLoc;
    public int size;
    public IColor color = new Blue();

    public Goal(Posn goalLoc, int size, IColor color){
        this.goalLoc = goalLoc;
        this.size = size;
        this.color = color;
    }

    public boolean playerGoal(Player player1){
        if ((this.goalLoc.x - player1.playLoc.x & this.goalLoc.y - player1.playLoc.y) < size){
            return true;
        }
            else return false;
    }

    public WorldImage drawGoal() {
        return new RectangleImage(this.goalLoc, this.size, this.size, this.color);
    }
}
