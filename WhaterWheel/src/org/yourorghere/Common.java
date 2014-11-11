/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yourorghere;

/**
 *
 * @author Sparko
 */
public class Common {
    
    static Point CreatePoint(float x, float y, float z)
    {
        Point p = new Point(x,y,z);
        
        return p;
    }
    
    static double[] GetPlaneEduation(Point p1, Point p2, Point p3){
        double[] xyzC=new double[4];
        double x1,x2,x3,y1,y2,y3,z1,z2,z3,x,y,z, C;
        x1=(double)p1.x;
        x2=(double)p2.x;
        x3=(double)p3.x;
        y1=(double)p1.y;
        y2=(double)p2.y;
        y3=(double)p3.y;
        z1=(double)p1.z;
        z2=(double)p2.z;
        z3=(double)p3.z;
        
        x=y2*z3-y1*z3-y2*z1+y1*z2-y3*z2+y3*z1;
        y=x3*z2-x3*z1-x1*z2-x2*z3+x1*z3+x2*z1;
        z=x2*y3-x2*y1-x1*y3+x3*y1-x3*y2+x1*y2;
        C=-x1*y2*z3-x2*y3*z1-x3*y1*z2+x3*y2*z1+x2*y1*z3+x1*y3*z2;
        
        xyzC[0]=x;
        xyzC[1]=y;
        xyzC[2]=z;
        xyzC[3]=C;
        
      
        
        return xyzC;
    }
    
    static void GetPlaneEduationInPieces()
    {
        
    }
    
    static float[] GetStraightEduation(Point p1, Point p2)
    {
        float x1,x2,y1,y2,z1,z2,x,y,z,C;
        
        x1=p1.x;
        x2=p2.x;
        y1=p1.y;
        y2=p2.y;
        z1=p1.z;
        z2=p2.z;
        z=p1.z;
        float StraightEduation[]=new float[4];
        
        x=(y2-y1);
        y=(-x2+x1);
        C=(-x1*y2)+(y1*x2);
        
        StraightEduation[0]=x;
        StraightEduation[1]=y;
        StraightEduation[2]=z;
        StraightEduation[3]=C;
        
        
        return StraightEduation;
    }
    
    static Point GetPointOfStraightIntersection(float[] StraightEduation)
    {
        float y=0;
        float x=-StraightEduation[3]/StraightEduation[0];
        float z=StraightEduation[2];
        
        return new Point(x,y,z);
    }
    
    static float GetTotalSpeed(float m1, float m2, float v1)
    {
        float TotalSpeed=(m1/(m1+m2))*v1;
        return TotalSpeed;
    }
    
    static float GetAcceleration(float alpha)
    {
        float acceleration=10*((float)Math.sin(alpha)-(float)Math.cos(alpha));
        
        return acceleration;
    }
    
    static float GetSpeedModule(float Vx, float Vy)
    {
        float speedModule= (float)Math.sqrt(Vx*Vx+Vy*Vy);
        
        return speedModule;
    }
    
    static float GetAlpha(Point p1, Point p2)
    {
        float y3=0;
        float x3=p1.x;
        float z3=p1.z;
        
        float a=Length(p1.x,p1.y,p1.z,x3,y3,z3);
        float b=Length(x3,y3,z3,p2.x,p2.y,p2.z);
        float c=(float)Math.sqrt((float)Math.pow(a,2)+(float)Math.pow(b, 2));
        
        float alpha=(float)Math.asin(Math.sin((double)(a)/(double)(c)));
        
        return alpha;
    }
    
    static float GetAngle(float[] eduation)
    {
        float x1=eduation[0];
        float x2=0;
        
        float y1=eduation[1];
        float y2=1;
        
        float Angle=(float)Math.acos(((float)Math.abs(x1*x2+y1*y2))/((float)Math.sqrt((x1*x1)+(y1*y1))*(float)Math.sqrt((x2*x2)+(y2*y2))));
                
        return Angle;
    }
    
     static float Length(float x1,float y1,float z1,float x2,float y2,float z2)
    {
        float L = (float)Math.sqrt((float)Math.pow(x1-x2, 2)+(float)Math.pow(y1-y2, 2)+(float)Math.pow(z1-z2, 2));
        
        return L;
    }
}

