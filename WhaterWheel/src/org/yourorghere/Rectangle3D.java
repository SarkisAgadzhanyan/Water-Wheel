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
public class Rectangle3D {
//    Face Left;
//    Face Right;
//    Face Front;
//    Face Rear;
//    Face Top;
//    Face Bottom;
    
    Point LeftFace_LeftTopCorner;
    
    double[] RearPlaneEduation_xyzC; 
    double[] FrontPlaneEduation_xyzC;
    
    Face Left;
    Face Right;
    Face Top;
    Face Rear;
    Face Bottom;
    Face Front;
    
    float width,height,length, mass; 
    float alpha;
    
    Rectangle3D(Point LeftTop, Point LeftBottom, Point RightBottom, Point RightTop, float Width, float Mass, float Alpha,float R_wm)
    {
        width=Width;
        mass=Mass;
        alpha=Alpha;
        height=R_wm;
        Point RightFace_LeftTop = new Point(LeftTop.x, LeftTop.y, LeftTop.z-width);
        Point RightFace_LeftBottom=new Point(LeftBottom.x, LeftBottom.y, LeftBottom.z-width);
        Point RightFace_RightBottom=new Point(RightBottom.x, RightBottom.y, RightBottom.z-width);
        Point RightFace_RightTop= new Point(RightTop.x, RightTop.y, RightTop.z-width);
        
        Left=new Face(LeftTop, LeftBottom, RightBottom, RightTop);
        Right=new Face(RightFace_LeftTop,RightFace_LeftBottom,RightFace_RightBottom,RightFace_RightTop);
        Top=new Face(RightFace_LeftTop,LeftTop,RightTop,RightFace_RightTop);
        Bottom= new Face(RightFace_LeftBottom, LeftBottom,RightBottom,RightFace_RightBottom);
        Front= new Face(RightTop,RightBottom,RightFace_RightBottom,RightFace_RightTop);
        Rear=new Face(LeftTop,LeftBottom,RightFace_LeftBottom,RightFace_LeftTop);
        
        
        FrontPlaneEduation_xyzC=Common.GetPlaneEduation(Front.LeftTop, Front.LeftBottom, Front.RightBottom);
        RearPlaneEduation_xyzC=Common.GetPlaneEduation(Rear.LeftTop, Rear.LeftBottom, Rear.RightBottom);
    }
    
    Rectangle3D(float Width, float Height, float Length, Point leftFace_leftTopCorner){
        width=Width;
        height=Height;
        length=Length;
        LeftFace_LeftTopCorner=leftFace_leftTopCorner;
        
        float x=LeftFace_LeftTopCorner.x;
        float y=LeftFace_LeftTopCorner.y;
        float z=LeftFace_LeftTopCorner.z;
        
        Left=new Face(0, height, length, x,y,z);
        Right=new Face(0, height, length, x,y,z-width);
        Top=new Face(width, 0, length, x,y,z-width);
        Bottom=new Face(width, 0, length, x,y-height,z-width);
        Front=new Face(width, height, 0, x+length,y,z);
        Rear=new Face(width, height, 0, x,y,z);
        
        //RearPlaneEduation_xyzC=Common.GetPlaneEduation(Rear.LeftTop, Rear.LeftBottom, Rear.RightBottom);
    }
    
    
    void Draw(GL gl)
    {
        gl.glColor3f(1f, 0f, 0f);
        Left.Draw(gl);
        gl.glColor3f(1f, 0f, 0f);
        Right.Draw(gl);
        gl.glColor3f(0f, 1f, 0f);
        Front.Draw(gl);
        gl.glColor3f(0f, 1f, 0f);
        Rear.Draw(gl);
        gl.glColor3f(0f, 0f, 1f);
        Top.Draw(gl);
        gl.glColor3f(0f, 0f, 1f);
        Bottom.Draw(gl);
    }
}
