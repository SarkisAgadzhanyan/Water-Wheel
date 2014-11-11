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
public class WaterMill {

    int n;
    float di;
    //float VSpeed;
    static Rectangle3D paddles[];
    float Width, Paddle_Height,  Paddle_Length, r_Hole,R, r_Disc, start_Z;
    float massOmnePaddle;   

    Point LeftFace_LeftTop1;
    Point LeftFace_LeftTop2;

    WaterMill(int countOfPaddles,float paddle_width, float paddle_height,float r_disc , float r_hole, float startZ)
    {
        n=countOfPaddles;
        paddles=new Rectangle3D[n];
        Width=paddle_width;
        Paddle_Height=paddle_height;
        r_Hole=r_hole;
        r_Disc=r_disc;
        start_Z=startZ;
        massOmnePaddle=0.5f;
        R=r_Disc+Paddle_Height;
        di=(float)(((float)(2*Math.PI))/n);
        //VSpeed=GLRenderer.VSpeed;
    }
     
     WaterMill(int countOfPaddles, Point _LeftFace1_LeftTop1, Point _LeftFace2_LeftTop2,
             float paddle_width, float paddle_height, float paddle_length, float r_hole){
         n=countOfPaddles;
         paddles=new Rectangle3D[n];
         massOmnePaddle=2.0f;
         LeftFace_LeftTop1=_LeftFace1_LeftTop1;
         LeftFace_LeftTop2=_LeftFace2_LeftTop2;
         Width=paddle_width;
         Paddle_Height=paddle_height;
         Paddle_Length=paddle_length;
         r_Hole=r_hole;
         R=(float)Math.sqrt((float)(Math.pow((LeftFace_LeftTop1.y-(LeftFace_LeftTop1.y-paddle_height)), 2)));
         di=(float)(((float)(2*Math.PI))/n);
         //VSpeed=GLRenderer.VSpeed;
         
     }
     
     void Draw(GL gl)
     {
            int createdPaddles=0;
            for(float i=0.0f; i<=(float)(2*Math.PI);i=i+di)
            {
                
                float rx=(float)(r_Disc*Math.cos(i-(di/4)-GLRenderer.VSpeed));
                float ry=(float)(r_Disc*Math.sin(i-(di/4)-GLRenderer.VSpeed));
                float rz=start_Z;
                float rnext_x=(float)(r_Disc*Math.cos(i+(di/4)-GLRenderer.VSpeed));
                float rnext_y=(float)(r_Disc*Math.sin(i+(di/4)-GLRenderer.VSpeed));
                float rnext_z=rz;
                
                gl.glPointSize(10);
                gl.glBegin(GL.GL_LINES);
                    gl.glVertex2f(rx, ry);
                    gl.glVertex2f(rnext_x, rnext_y);
                gl.glEnd();
                
                float Rx=(float)(R*Math.cos(i-(di/8)-GLRenderer.VSpeed));
                float Ry=(float)(R*Math.sin(i-(di/8)-GLRenderer.VSpeed));
                float Rnext_x=(float)(R*Math.cos(i+(di/8)-GLRenderer.VSpeed));
                float Rnext_y=(float)(R*Math.sin(i+(di/8)-GLRenderer.VSpeed));
                float Rz=rz;
                float Rnext_z=rz;
                
                gl.glPointSize(10);
                gl.glBegin(GL.GL_LINES);
                    gl.glVertex2f(Rx, Ry);
                    gl.glVertex2f(Rnext_x, Rnext_y);
                gl.glEnd();
                
                LeftFace_LeftTop1=new Point(Rx,Ry,Rz);
                Rectangle3D paddle= new Rectangle3D(LeftFace_LeftTop1, 
                        new Point(rx, ry, rz), 
                        new Point(rnext_x, rnext_y, rnext_z),
                        new Point(Rnext_x, Rnext_y, Rnext_z) , 
                        Width,massOmnePaddle,i,R);
                paddles[createdPaddles]=paddle;
                createdPaddles++;
                paddle.Draw(gl);
            Disc3D d = new Disc3D(di, r_Hole, r_Disc, LeftFace_LeftTop1.z, Width);
            d.Draw(gl);
            
            //VSpeed=VSpeed+0.001f;

 /*           for(float i=0.0f; i<=(float)(2*Math.PI);i=i+di)
            {
                Rectangle3D  paddle1= new Rectangle3D(Width,Paddle_Height,Paddle_Length,LeftFace_LeftTop1);
                Rectangle3D  paddle2= new Rectangle3D(Width,Paddle_Height,Paddle_Length,LeftFace_LeftTop2);

                paddle1.Draw(gl);
                paddle2.Draw(gl);
                
//               //gl.glBegin(GL.GL_QUADS);
//                paddles[paddlesCount] = new Paddle(); 
//                paddles[paddlesCount].Draw(gl, i, i, 0.5f);
//               // gl.glEnd();
//                paddlesCount++;
                gl.glRotatef(360.0f/16.0f, 0, 0, 1);
                paddles[createdPaddles]=paddle1;
                paddles[createdPaddles+1]=paddle2;
                createdPaddles=createdPaddles+2;
            }

            Disc3D d = new Disc3D(di, r_Hole, R, LeftFace_LeftTop1.z, Width);
            d.Draw(gl);
*/
        }
    }
    
     void Move(GL gl)
     {
         Draw(gl);
     }
}
