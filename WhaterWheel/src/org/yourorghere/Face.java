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
public class Face {
    float width,length;
    
    Point LeftTop;
    Point LeftBottom;
    Point RightBottom;
    Point RightTop;
    
    Face(Point leftTop, Point leftBottom, Point rightBottom, Point rightTop)
    {
        LeftTop=leftTop;
        LeftBottom=leftBottom;
        RightBottom=rightBottom;
        RightTop=rightTop;
    }
    
    Face(float Width, float Height, float Length, 
        float LeftTopCornerX, float LeftTopCornerY, float LeftTopCornerZ)
    {
        if(Width==0f){
            length=Length;
            width=Height;
            
            LeftTop=new Point(LeftTopCornerX, LeftTopCornerY, LeftTopCornerZ);
            LeftBottom= new Point(LeftTop.x, LeftTop.y-width, LeftTop.z);
            RightBottom=new Point(LeftBottom.x+length, LeftBottom.y, LeftBottom.z);
            RightTop=new Point(RightBottom.x, RightBottom.y+width, RightBottom.z);
        }
        if(Height==0f){
            width=Width;
            length=Length;
            
            LeftTop=new Point(LeftTopCornerX, LeftTopCornerY, LeftTopCornerZ);
            LeftBottom= new Point(LeftTop.x, LeftTop.y, LeftTop.z+width);
            RightBottom=new Point(LeftBottom.x+length, LeftBottom.y, LeftBottom.z);
            RightTop=new Point(RightBottom.x, RightBottom.y, RightBottom.z-width);
        }
        if(Length==0f){
            length=Width;
            width=Height;
            
            LeftTop=new Point(LeftTopCornerX, LeftTopCornerY, LeftTopCornerZ);
            LeftBottom= new Point(LeftTop.x, LeftTop.y-width, LeftTop.z);
            RightBottom=new Point(LeftBottom.x, LeftBottom.y, LeftBottom.z-length);
            RightTop=new Point(RightBottom.x, RightBottom.y+width, RightBottom.z);
        }
    }
    
    void Draw(GL gl){
        gl.glBegin(GL.GL_QUADS);
            gl.glVertex3f(LeftTop.x, LeftTop.y, LeftTop.z);
            gl.glVertex3f(LeftBottom.x, LeftBottom.y, LeftBottom.z); 
            gl.glVertex3f(RightBottom.x, RightBottom.y, RightBottom.z);
            gl.glVertex3f(RightTop.x, RightTop.y, RightTop.z);
       gl.glEnd();
    }
}
