/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yourorghere;
import javax.media.opengl.*;
import java.math.*;
import javax.media.opengl.glu.*;
/**
 *
 * @author Sparko
 */
public class Point {
    float x,y,z;
    Point(float xCoord, float yCoord, float zCoord){
        x=xCoord;
        y=yCoord;
        z=zCoord;
    }
    
    void Draw(GL gl){
        gl.glPointSize(4);
        gl.glColor3f(0, 0, 0);
        gl.glBegin(GL.GL_POINTS);
            gl.glVertex3f(x, y, z);
        gl.glEnd();
    }
}
