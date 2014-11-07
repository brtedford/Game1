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
import java.util.Random;;

/**
 *
 * @author briantedford
 */

    //Player char
    //moves in 4 directions on button presses
    //May not occupy the same posn as walls
    //Life is lost of occupies the same posn as traps
    //begins in bottomleft corner of Gameboard

public class Player {

    public Posn playLoc;
    final int size = 10;
    static IColor pColor = new Red();


public Player(Posn playLoc, int size, IColor color) {
        this.playLoc = playLoc;
    }

    //Controls:
    //player movement corresponds with
    //presses of directional arrows
    //for movement UP, DOWN, LEFT, and RIGHT

    public void playMove(String keyPress) {
        if(keyPress.equals("right") & this.playLoc.x < 400 + this.size % 2 ){
            this.playLoc = new Posn(this.playLoc.x + this.size, this.playLoc.y);
        }
        else if(keyPress.equals("left") & this.playLoc.x > 0 - this.size % 2){
            this.playLoc = new Posn(this.playLoc.x - this.size, this.playLoc.y);
        }
        else if(keyPress.equals("up") & this.playLoc.y < 400 + this.size % 2){
            this.playLoc = new Posn(this.playLoc.x, this.playLoc.y);
        }
        else if(keyPress.equals("down") & this.playLoc.y > 0 - this.size % 2){
            this.playLoc = new Posn(this.playLoc.x, this.playLoc.y - this.size);
        }
    }

    public WorldImage drawPlayer(){
        return new RectangleImage(this.playLoc, this.size, this.size, pColor);
    }
}
