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
public class Gutter {
   
    Point LWall_LFace_LTop;
    float Wall_Thickness;
    float Wall_Height;
    float Height;
    float Width;
    float Length;
    
    
     Point face[]=new Point[4];
    
     
     Gutter(Point _LWall_LFace_LTop, float wall_Thickness, float wall_height,
            float width, float height, float length){
         LWall_LFace_LTop=_LWall_LFace_LTop;
         Wall_Height=wall_height;
         Wall_Thickness=wall_Thickness;
         Height=height;
         Width=width;
         Length=length;
     }
     
    void Draw(GL gl)
    {
       // Point LeftTop1 = new Point(-2.0f, 1.8f, 1.0f);

        Rectangle3D  LeftBorder= new Rectangle3D(Wall_Thickness,Wall_Height,Length,LWall_LFace_LTop);
            
        LeftBorder.Draw(gl); 
        
        Point LeftTop2 = new Point(LWall_LFace_LTop.x, LWall_LFace_LTop.y-Height, LWall_LFace_LTop.z-Wall_Thickness);

        Rectangle3D  Bottom= new Rectangle3D(Width,Height,Length,LeftTop2);
        
        Bottom.Draw(gl); 
        
        Point LeftTop3 = new Point(LWall_LFace_LTop.x, LWall_LFace_LTop.y, LeftTop2.z-Width);

        Rectangle3D  RightBorder= new Rectangle3D(Wall_Thickness,Wall_Height,Length,LeftTop3);
            
        RightBorder.Draw(gl);
    }
    
    
//    void DrawLeftBorder(GL gl){
//          
//          Point LeftTop= new Point(startPointX,endY,0.5f);
//          Point LeftBottom= new Point( startPointX, 0.8f-height, 0.5f);
//          Point RightBottom= new Point(endPointX,0.8f-height,0.5f);
//          Point RightTop= new Point( endPointX, 0.8f, 0.5f);
//          
//          face[0]=LeftTop;
//          face[1]=LeftBottom;
//          face[2]=RightBottom;
//          face[3]=RightTop;
//                  
//          //Face Left=new Face(LeftTop, LeftBottom, RightBottom, RightTop);
//          
//          //Rectangle Left= new Rectangle(LeftTop, LeftBottom, RightBottom, RightTop)
//          
//          
//          Point p5= new Point(startPointX,0.8f,-0.5f);
//          Point p6= new Point( startPointX, 0.8f-height,-0.5f);
//          Point p7= new Point(endPointX,0.8f-height, -0.5f);
//          Point p8= new Point( endPointX, 0.8f, -0.5f);
//
//          //Face Right=new Face(LeftTop, LeftBottom, RightBottom, RightTop);
////        //left face
////        
////        // x coordindates of points for left face
////        float leftFace_left_top_X=startPointX;
////        float leftFace_left_bottom_X=leftFace_left_top_X;
////        float leftFace_rigth_bottom_X=startPointX+length;
////        float leftFace_rigth_top_X=leftFace_rigth_bottom_X;
////        
////        
////        // y coordindates of points for left face
////        float leftFace_left_top_Y;
////        float leftFace_left_bottom_Y;
////        float leftFace_rigth_bottom_Y;
////        float leftFace_rigth_top_Y;
////        
////        
////        // z coordindates of points for left face
////        float leftFace_left_top_Z;
////        float leftFace_left_bottom_Z;
////        float leftFace_rigth_bottom_Z;
////        float leftFace_rigth_top_Z;
////        
////        
////        //front face
////        
////        // x coordindates of points for front face
////        float frontFace_left_top_X;
////        float frontFace_left_bottom_X;
////        float frontFace_right_bottom_X;
////        float frontFace__tight_top_X;
////        
////        
////        // y coordindates of points for front face
////        float frontFace_left_top_Y;
////        float frontFace_left_bottom_Y;
////        float frontFace_right_bottom_Y;
////        float frontFace__tight_top_Y;
////        
////        
////        // z coordindates of points for front face
////        float frontFace_left_top_Z;
////        float frontFace_left_bottom_Z;
////        float frontFace_right_bottom_Z;
////        float frontFace__tight_top_Z;
////        
////        
////        //top face
////        
////        // x coordindates of points for top face
////        float topFace_left_top_X;
////        float topFace_left_bottom_X;
////        float topFace_right_bottom_X;
////        float topFace_right_top_X;
////        
////        
////        // y coordindates of points for top face
////        float topFace_left_top_Y;
////        float topFace_left_bottom_Y;
////        float topFace_right_bottom_Y;
////        float topFace_right_top_Y;
////        
////        
////        // z coordindates of points for top face
////        float topFace_left_top_Z;
////        float topFace_left_bottom_Z;
////        float topFace_right_bottom_Z;
////        float topFace_right_top_Z;
//    }
    
    
    
 
    
}
