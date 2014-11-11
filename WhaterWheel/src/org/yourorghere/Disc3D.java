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
public class Disc3D {
    
    float di, r, R, startZ,endZ;
    
    Disc3D(float _di, float _r, float _R, float _startZ, float Width){
        di=_di;
        r=_r;
        R=_R;
        startZ=_startZ;
        endZ=startZ-Width;
    }
    
   void Draw(GL gl){
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        gl.glBegin(GL.GL_QUADS);
        for (float i=0.0f;i<=(float)(2*Math.PI);i=i+di)
        {
            gl.glColor3f(0.2f, 0.2f, 0.2f);
                gl.glVertex3f((float)(r*Math.cos(i+di)), (float)(r*Math.sin(i+di)),startZ);
                gl.glVertex3f((float)(R*Math.cos(i+di)), (float)(R*Math.sin(i+di)),startZ);
                gl.glVertex3f((float)(R*Math.cos(i)), (float)(R*Math.sin(i)),startZ);
                gl.glVertex3f((float)(r*Math.cos(i)), (float)(r*Math.sin(i)),startZ);

            gl.glColor3f((float)(R-r*Math.cos(i)), (float)(R-r*Math.cos(i)), (float)(R-r*Math.cos(i)));
                gl.glVertex3f((float)(r*Math.cos(i+di)), (float)(r*Math.sin(i+di)),endZ);
                gl.glVertex3f((float)(R*Math.cos(i+di)), (float)(R*Math.sin(i+di)),endZ); 
                gl.glVertex3f((float)(R*Math.cos(i)), (float)(R*Math.sin(i)),endZ);
                gl.glVertex3f((float)(r*Math.cos(i)), (float)(r*Math.sin(i)),endZ);
                
            gl.glColor3f(0.2f,0.7f, 0.1f);
                gl.glVertex3f((float)(R*Math.cos(i+di)), (float)(R*Math.sin(i+di)),endZ);
                gl.glVertex3f((float)(R*Math.cos(i+di)), (float)(R*Math.sin(i+di)),startZ);
                gl.glVertex3f((float)(R*Math.cos(i)), (float)(R*Math.sin(i)),startZ);
                gl.glVertex3f((float)(R*Math.cos(i)), (float)(R*Math.sin(i)),endZ);
                
            gl.glColor3f(0.7f, 0.1f, 0.1f);
                gl.glVertex3f((float)(r*Math.cos(i+di)), (float)(r*Math.sin(i+di)),endZ);
                gl.glVertex3f((float)(r*Math.cos(i+di)), (float)(r*Math.sin(i+di)),startZ); 
                gl.glVertex3f((float)(r*Math.cos(i)), (float)(r*Math.sin(i)),startZ);
                gl.glVertex3f((float)(r*Math.cos(i)), (float)(r*Math.sin(i)),endZ);
        }
        gl.glEnd();
    }
}
