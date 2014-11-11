/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author Sparko
 */

public class WhaterPortion {
    float m, v;
    int index=-1;
    boolean IsStoped;
    boolean IsOutOfSystem=false;
    float t=0;
    float v0;
    float g=10.0f;     
    float time;
    float startX=-2f;
    float x,y,z,y0,x0;
    float a;
    float dx,dy,dz;
    int size;
    float lbx;
    float lby;
    float lty;
    float ltx;
    float localOY=lby;
    float Ox,Oy,Oz;
    float[] FrontFacaLeftStraightEduation;
    float angle;
    float deltaX,deltaY;
    Point PointOfOxIntersection;
    float r;
    float center_of_paddle_X;
    float center_of_paddle_Y;
    float Length_Bottom__to_Particle;
    float Length_Particle_to_Top;
    boolean X_IS_INITIALIZED_FOR_FINISH=false;
            
    public void Move(GL gl){
        if(IsOutOfSystem==false||IsOutOfSystem==true){
            time=time+0.01f;

            if(x<0&&IsStoped==false)
            {
                x=startX+v0*time; 
                y=y0;
            }
            else
            {
               if(IsStoped==true)
               {
                    if(index>-1)
                    {
                        float i=Common.GetAngle(FrontFacaLeftStraightEduation);/*Common.GetAngle(Common.GetStraightEduation(new Point(Ox, Oy, Oz), new Point(0, 0, Oz)));*/
    //                    gl.glColor3f(0f, 1f, 0f);
    //                    gl.glLineWidth(3);
    //                    gl.glBegin(GL.GL_LINES);
    //                     gl.glVertex3f(Ox, Oy, z);
    //                     gl.glVertex3f(Ox, 0, z);
    //                     gl.glVertex3f(Ox, Oy, z);
    //                     gl.glVertex3f(0, 0, z);
    //                    gl.glEnd();
    //                    gl.glColor3f(1f, 0f, 0f);
    //                    gl.glLineWidth(3);
    //                    gl.glBegin(GL.GL_LINES);
    //                     gl.glVertex3f(0, 0, z);
    //                     gl.glVertex3f(0, 1, z);
    //                     gl.glVertex3f(0, 0, z);
    //                     gl.glVertex3f(1, 0, z);
    //                    gl.glEnd();
                        Ox=(float)(r*Math.cos(i));
                        Oy=(float)(r*Math.sin(i));
                        //Ox=x;
                        //Oy=y;

                        center_of_paddle_X=(WaterMill.paddles[index].Left.LeftTop.x+WaterMill.paddles[index].Left.RightTop.x)/2;
                        center_of_paddle_Y=(WaterMill.paddles[index].Left.LeftTop.y+WaterMill.paddles[index].Left.RightTop.y)/2;
                        lbx=((Point)(((Face)(((Rectangle3D)(WaterMill.paddles[index])).Front)).LeftBottom)).x;
                        lby=((Point)(((Face)(((Rectangle3D)(WaterMill.paddles[index])).Front)).LeftBottom)).y;
                        lty=((Point)(((Face)(((Rectangle3D)(WaterMill.paddles[index])).Front)).LeftTop)).y;
                        ltx=((Point)(((Face)(((Rectangle3D)(WaterMill.paddles[index])).Front)).LeftTop)).x;

                    }
                    GLRenderer.VSpeed=GLRenderer.VSpeed+0.00001f*Common.GetTotalSpeed(m,WaterMill.paddles[index].mass,Common.GetSpeedModule(v0, (100*time*time)));
                    //angle=Common.GetAlpha(WaterMill.paddles[index].Front.LeftTop, Common.GetPointOfStraightIntersection(Common.GetStraightEduation(WaterMill.paddles[index].Front.LeftTop, WaterMill.paddles[index].Front.LeftBottom)))*(float)((float)180/(float)Math.PI);
                    FrontFacaLeftStraightEduation=Common.GetStraightEduation(WaterMill.paddles[index].Front.LeftTop, WaterMill.paddles[index].Front.LeftBottom);
                    PointOfOxIntersection = Common.GetPointOfStraightIntersection(FrontFacaLeftStraightEduation);
                    //angle=Common.GetAlpha(WaterMill.paddles[index].Front.LeftTop, PointOfOxIntersection)*(float)((float)180/(float)Math.PI);
                    angle=Common.GetAngle(FrontFacaLeftStraightEduation)*(float)((float)180/(float)Math.PI);
                    Point FrontLeftTop= WaterMill.paddles[index].Front.LeftTop;
                    Point Intersection= Common.GetPointOfStraightIntersection(Common.GetStraightEduation(WaterMill.paddles[index].Front.LeftTop, WaterMill.paddles[index].Front.LeftBottom));
                    Point OxProjection= new Point(FrontLeftTop.x, 0, FrontLeftTop.z);
                    a=Common.GetAcceleration(angle);
    //                gl.glColor3f(0f, 0f, 1f);
    //                    gl.glLineWidth(3);
    //                    gl.glBegin(GL.GL_LINES);
    //                     gl.glVertex3f(Intersection.x, Intersection.y, -2);
    //                     gl.glVertex3f(FrontLeftTop.x, FrontLeftTop.y, -2);
    //                     gl.glVertex3f(Intersection.x, Intersection.y, -2);
    //                     gl.glVertex3f(OxProjection.x, OxProjection.y, -2);
    //                    gl.glEnd();
                    //gl.glPushMatrix();
                    //gl.glTranslatef( x, y, z);
                    //gl.glRotatef(angle, 0, 0, 1);

    //                gl.glColor3f(0f, 0f, 0);
    //                gl.glLineWidth(3);
    //                gl.glBegin(GL.GL_LINES);
    //                    gl.glVertex3f(0, 0, z);
    //                    gl.glVertex3f(0, 1, z);
    //                    gl.glVertex3f(0, 0, z);
    //                    gl.glVertex3f(1, 0, z);
    //                gl.glEnd();

    //                gl.glPointSize(20);
    //                gl.glColor3f(0.0f, 0.0f, 0.0f);
    //                gl.glBegin(GL.GL_POINTS);
    //                    gl.glVertex3f(x, y, z);
    //                gl.glEnd();
                    if(center_of_paddle_Y>0&&IsOutOfSystem==false)
                    {
                       // x=x+0.01f;
                        if(x>(-Length_Bottom__to_Particle))
                        {
                            x=x-0.01f;
                        }
                        else
                        {
                            x=-Length_Bottom__to_Particle;
                        }
                    }
                    else
                    {
                        if(x<=Length_Particle_to_Top&&IsOutOfSystem==false)
                        {
                            x=x+0.001f*time;
                        }
                        else
                        {
                            if(X_IS_INITIALIZED_FOR_FINISH==false)
                            {
                                x=ltx;
                                y=lty;
                                X_IS_INITIALIZED_FOR_FINISH=true;
                                time=0.01f;
                            }
                            x=x+v0*time; 
                            y=(y-(float)((g*(x*x))/(4*(v0*v0))));
                            IsOutOfSystem=true;
                            
                        }
                    }
                    //gl.glRotatef(angle, 0, 0, -1);
    //                gl.glColor3f(0f, 0f, 0);
    //                gl.glLineWidth(3);
    //                gl.glBegin(GL.GL_LINES);
    //                    gl.glVertex3f(0, 0, z);
    //                    gl.glVertex3f(0, 1, z);
    //                    gl.glVertex3f(0, 0, z);
    //                    gl.glVertex3f(1, 0, z);
    //                gl.glEnd();
                    //gl.glTranslatef(-Ox, -Oy, -Oz);

                    //gl.glPopMatrix();

    //                gl.glPointSize(20);
    //                gl.glColor3f(0.0f, 0.0f, 0.0f);
    //                gl.glBegin(GL.GL_POINTS);
    //                    gl.glVertex3f(x, y, z);
    //                gl.glEnd();

    //                gl.glColor3f(0f, 0f, 0);
    //                gl.glLineWidth(3);
    //                gl.glBegin(GL.GL_LINES);
    //                    gl.glVertex3f(0, 0, z);
    //                    gl.glVertex3f(0, 1, z);
    //                    gl.glVertex3f(0, 0, z);
    //                    gl.glVertex3f(1, 0, z);
    //                gl.glEnd();
                }
                else{
                    x=startX+v0*time; 
                    for (int i=0; i<WaterMill.paddles.length;i++) {
                        double value = (WaterMill.paddles[i].FrontPlaneEduation_xyzC[0] * x 
                                        + WaterMill.paddles[i].FrontPlaneEduation_xyzC[1] * y 
                                        + WaterMill.paddles[i].FrontPlaneEduation_xyzC[2] * z 
                                        + WaterMill.paddles[i].FrontPlaneEduation_xyzC[3]);
                        double exp=Math.abs(value);
                        double minimum=Math.pow(10, -2);
                        if(exp<minimum)
                        {
                            if(WaterMill.paddles[i].Front.LeftTop.y>y
                                &&WaterMill.paddles[i].Front.LeftBottom.y<y
                                &&WaterMill.paddles[i].Front.LeftTop.z>z
                                &&WaterMill.paddles[i].Front.RightTop.z<z)  
                            {
                                index=i;
                                Ox=x;
                                Oy=y;
                                Oz=z;

                                FrontFacaLeftStraightEduation=Common.GetStraightEduation(WaterMill.paddles[i].Front.LeftTop, WaterMill.paddles[i].Front.LeftBottom);
                                PointOfOxIntersection = Common.GetPointOfStraightIntersection(FrontFacaLeftStraightEduation);
                                angle=Common.GetAlpha(WaterMill.paddles[i].Front.LeftTop, PointOfOxIntersection)*(float)((float)180/(float)Math.PI);
                                deltaX=WaterMill.paddles[i].Front.LeftTop.x-Ox;
                                deltaY=WaterMill.paddles[i].Front.LeftTop.y-Oy;
                                //lty=((Point)(((Face)(((Rectangle3D)(WaterMill.paddles[index])).Front)).LeftTop)).y;
                                //ltx=((Point)(((Face)(((Rectangle3D)(WaterMill.paddles[index])).Front)).LeftTop)).x;
                                center_of_paddle_X=(WaterMill.paddles[index].Left.LeftTop.x+WaterMill.paddles[index].Left.RightTop.x)/2;
                                center_of_paddle_Y=(WaterMill.paddles[index].Left.LeftTop.y+WaterMill.paddles[index].Left.RightTop.y)/2;
                                Length_Bottom__to_Particle=Common.Length(WaterMill.paddles[index].Left.LeftBottom.x, WaterMill.paddles[index].Left.LeftBottom.y, z, x, y, z);
                                Length_Particle_to_Top=Common.Length(WaterMill.paddles[index].Left.LeftTop.x, WaterMill.paddles[index].Left.LeftTop.y, z, x, y, z);
                                r=Common.Length(Ox, Oy, Oz, 0, 0, Oz);
                                x=0;
                                y=Common.Length(WaterMill.paddles[index].Left.LeftTop.x, WaterMill.paddles[index].Left.LeftTop.y, WaterMill.paddles[index].Left.LeftTop.z, center_of_paddle_X, center_of_paddle_Y, WaterMill.paddles[index].Left.LeftTop.z);
                                if(IsStoped==false)
                                IsStoped=true;
                            }

                        }
                        else{
                            y=y0-(float)((g*(x*x))/(2*(v0*v0)));
                        }

                        if(IsStoped==true)
                            return;
                    }
                }
            }
        }
    }
    
    void Draw(GL gl){
        gl.glPushMatrix();
        if(IsStoped==true&&IsOutOfSystem==false)
        {
            if(center_of_paddle_Y<=0&&center_of_paddle_X>0)
            {
                gl.glTranslatef( Ox, -Oy, 0);
                gl.glRotatef(angle, 0, 0, -1);
            }else
                if(center_of_paddle_Y<0&&center_of_paddle_X<=0)
                {
                    gl.glTranslatef( -Ox, -Oy, 0);
                    gl.glRotatef(180-angle, 0, 0, -1);
                }
                else
                    if(center_of_paddle_Y>=0&&center_of_paddle_X<=0)
                    {
                        gl.glTranslatef( -Ox, Oy, 0);
                        gl.glRotatef(180+angle, 0, 0, -1);
                    }else
                    {
                        gl.glTranslatef(Ox, Oy, 0);
                        gl.glRotatef(angle, 0, 0, 1);
                    }
        }
        gl.glPointSize(15);
        gl.glColor3f(0.1f, 0.1f, 1f);
        gl.glBegin(GL.GL_POINTS);
            gl.glVertex3f(x, y, z);
        gl.glEnd();
         gl.glColor3f(0.3f, 0.3f, 0.1f);
                gl.glLineWidth(3);
                gl.glBegin(GL.GL_LINES);
                    gl.glVertex3f(0, 0, z);
                    gl.glVertex3f(0, 1, z);
                    gl.glVertex3f(0, 0, z);
                    gl.glVertex3f(1, 0, z);
                gl.glEnd();
//        if(IsStoped==true)
//        {
//
//            if(angle>=180&& angle<=360)
//            {
//                gl.glRotatef(-(360-angle), 0, 0, -1);
//            }else
//            {
//                gl.glRotatef(angle, 0, 0, -1);
//            }
//            gl.glTranslatef(-Ox, -Oy, -Oz);
//        }
        gl.glPopMatrix();
    }
    
    void Collision()
    {
        dx=-dx;
        dy=-dy;
        dz=-dz;
    }
    
    double Length(float x1,float y1,float z1,float x2,float y2,float z2)
    {
        double L = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2)+Math.pow(z1-z2, 2));
        
        return L;
    }
    
    WhaterPortion(){
        
        y0=1.6f;
        v0=1.0f;
        x=startX;
        y=y0;
        z=(float)(Math.random()%2-0.5);
        
        m=0.003f;
        IsStoped=false;
        
        time=0.0f;
        dx=0.005f;
        dy=-0.009f;
        dz=0.002f;
    }
    
}
