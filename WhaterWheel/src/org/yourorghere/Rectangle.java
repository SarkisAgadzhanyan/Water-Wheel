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
public class Rectangle {
    
     float left_top_X;
     float left_bottom_X;
     float rigth_bottom_X;
     float rigth_top_X;
     
     float left_top_Y;
     float left_bottom_Y;
     float rigth_bottom_Y;
     float rigth_top_Y;


     float left_top_Z;
     float left_bottom_Z;
     float rigth_bottom_Z;
     float rigth_top_Z;
    
    Rectangle(Point LeftTop, Point LeftBottom, Point RightBottom, Point RightTop ){
        
        left_top_X=LeftTop.x;
        left_bottom_X=LeftBottom.x;
        rigth_bottom_X=RightBottom.x;
        rigth_top_X=RightTop.x;
     
        left_top_Y=LeftTop.y;
        left_bottom_Y=LeftBottom.y;
        rigth_bottom_Y=RightBottom.y;
        rigth_top_Y=RightTop.y;

        left_top_Z=LeftTop.z;
        left_bottom_Z=LeftBottom.z;
        rigth_bottom_Z=RightBottom.z;
        rigth_top_Z=RightTop.z;
    }
    
     public static void DrawLeft(GL gl,float x,float y,float z, float w, float h)
    {
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        gl.glBegin(GL.GL_QUADS);
            gl.glVertex3f((float)(0.2f*Math.cos(x+w/2)),(float)(0.2f*Math.sin(y+w/2)), z);
            gl.glVertex3f((float)(0.6f*Math.cos(x+w/6)), (float)(0.6f*Math.sin(y+w/6)), z);
            gl.glVertex3f((float)(0.6f*Math.cos(x-w/6)), (float)(0.6f*Math.sin(y-w/6)), z);
            gl.glVertex3f((float)(0.2f*Math.cos(x-w/2)), (float)(0.2f*Math.sin(y-w/2)), z);
        gl.glEnd();
    }
     
     public static void DrawTop(GL gl,float x,float y,float z, float w, float h)
    {
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        gl.glBegin(GL.GL_QUADS);
            gl.glVertex3f((float)(0.6f*Math.cos(x+w/6)),(float)(0.6f*Math.sin(y+w/6)),  z);
            gl.glVertex3f((float)(0.6f*Math.cos(x+w/6)), (float)(0.6f*Math.sin(y+w/6)), -z);
            gl.glVertex3f((float)(0.6f*Math.cos(x-w/6)), (float)(0.6f*Math.sin(y-w/6)), -z);
            gl.glVertex3f((float)(0.6f*Math.cos(x-w/6)), (float)(0.6f*Math.sin(y-w/6)),  z);
        gl.glEnd();
//       gl.glBegin(GL.GL_QUADS);
//        gl.glVertex3f(x-w, y+h, z);
//        gl.glVertex3f(x-w, y+h, -z);
//        gl.glVertex3f(x, y+h, -z);
//        gl.glVertex3f(x, y+h, z);
//       gl.glEnd();
    }
     
     
      public static void DrawRight(GL gl,float x,float y,float z, float w, float h)
    {
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        gl.glBegin(GL.GL_QUADS);
            gl.glVertex3f((float)(0.2f*Math.cos(x+w/2)),(float)(0.2f*Math.sin(y+w/2)), -z);
            gl.glVertex3f((float)(0.6f*Math.cos(x+w/6)),(float)(0.6f*Math.sin(y+w/6)), -z);
            gl.glVertex3f((float)(0.6f*Math.cos(x-w/6)),(float)(0.6f*Math.sin(y-w/6)), -z);
            gl.glVertex3f((float)(0.2f*Math.cos(x-w/2)),(float)(0.2f*Math.sin(y-w/2)), -z);
        gl.glEnd();
//       gl.glBegin(GL.GL_QUADS);
//        gl.glVertex3f(x-w, y, -z);
//        gl.glVertex3f(x-w, y+h, -z);
//        gl.glVertex3f(x, y+h, -z);
//        gl.glVertex3f(x, y, -z);
//       gl.glEnd();
    }
      
      public static void DrawBottom(GL gl,float x,float y,float z, float w)
    {
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        gl.glBegin(GL.GL_QUADS);
            gl.glVertex3f((float)(0.2f*Math.cos(x+w/2)),(float)(0.2f*Math.sin(y+w/2)),  z);
            gl.glVertex3f((float)(0.2f*Math.cos(x+w/2)), (float)(0.2f*Math.sin(y+w/2)), -z);
            gl.glVertex3f((float)(0.2f*Math.cos(x-w/2)), (float)(0.2f*Math.sin(y-w/2)), -z);
            gl.glVertex3f((float)(0.2f*Math.cos(x-w/2)), (float)(0.2f*Math.sin(y-w/2)),  z);
        gl.glEnd();
//       gl.glBegin(GL.GL_QUADS);
//        gl.glVertex3f(x-w, y, z);
//        gl.glVertex3f(x-w, y, -z);
//        gl.glVertex3f(x, y, -z);
//        gl.glVertex3f(x, y, z);
//       gl.glEnd();
    }
      
      public static void DrawFront(GL gl,float x,float y,float z,float w, float h)
    {
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        gl.glBegin(GL.GL_QUADS);
            gl.glVertex3f((float)(0.2f*Math.cos(x-w/2)),(float)(0.2f*Math.sin(y-w/2)),  z);
            gl.glVertex3f((float)(0.6f*Math.cos(x-w/6)), (float)(0.6f*Math.sin(y-w/6)), z);
            gl.glVertex3f((float)(0.6f*Math.cos(x-w/6)), (float)(0.6f*Math.sin(y-w/6)), -z);
            gl.glVertex3f((float)(0.2f*Math.cos(x-w/2)), (float)(0.2f*Math.sin(y-w/2)), -z);
        gl.glEnd();
//       gl.glBegin(GL.GL_QUADS);
//        gl.glVertex3f(x, y, z);
//        gl.glVertex3f(x, y+h, z);
//        gl.glVertex3f(x, y+h, -z);
//        gl.glVertex3f(x, y, -z);
//       gl.glEnd();
    }
      
        public static void DrawRear(GL gl,float x,float y,float z, float w, float h)
    {
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        gl.glBegin(GL.GL_QUADS);
            gl.glVertex3f((float)(0.2f*Math.cos(x+w/2)),(float)(0.2f*Math.sin(y+w/2)),  z);
            gl.glVertex3f((float)(0.6f*Math.cos(x+w/6)), (float)(0.6f*Math.sin(y+w/6)), z);
            gl.glVertex3f((float)(0.6f*Math.cos(x+w/6)), (float)(0.6f*Math.sin(y+w/6)), -z);
            gl.glVertex3f((float)(0.2f*Math.cos(x+w/2)), (float)(0.2f*Math.sin(y+w/2)), -z);
        gl.glEnd();
//       gl.glBegin(GL.GL_QUADS);
//        gl.glVertex3f(x-w, y, z);
//        gl.glVertex3f(x-w, y+h, z);
//        gl.glVertex3f(x-w, y+h, -z);
//        gl.glVertex3f(x-w, y, -z);
//       gl.glEnd();
    }
}


