package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;


/**
 * GLRenderer.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class GLRenderer implements GLEventListener {

    WhaterPortion wp[];
    GLU glu = new GLU();
    int n=0;
    
    public static float VSpeed;
    
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        wp= new WhaterPortion[10];
        VSpeed=0.0f;
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(1.0f,1.0f,1.0f,0.0f);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glLoadIdentity();
        glu.gluPerspective(90,-1, 2, -2);
        glu.gluLookAt(1, 2, 3, 0, 0, 0, 0, 1, 0);

        //gl.glOrtho(-2, 2, -2, 2, 2, -2);
        //gl.glRotatef(60, 0, 1, 0);

        WaterMill wm= new WaterMill(16, 1.0f,0.5f, 0.5f, 0.05f, 0.5f);
        wm.Draw(gl);
        
        Gutter g = new Gutter(new Point(-2.0f, 1.8f, 0.6f), 0.1f, 0.5f, 1.0f,  0.25f, 2.0f);
        g.Draw(gl);

//        float di=(float)(((float)2*Math.PI)/16);
//        float r=0.2f;
//        float R=1f;
//            for(float i=0.0f; i<=(float)(2*Math.PI);i=i+di)
//            {
//                
//                float rx=(float)(r*Math.cos(i-(di/4)-Time));
//                float ry=(float)(r*Math.sin(i-(di/4)-Time));
//                float rz=0.5f;
//                float rnext_x=(float)(r*Math.cos(i+(di/4-Time)));
//                float rnext_y=(float)(r*Math.sin(i+(di/4)-Time));
//                float rnext_z=rz;
//                gl.glPointSize(10);
//                gl.glBegin(GL.GL_LINES);
//                    gl.glVertex2f(rx, ry);
//                    gl.glVertex2f(rnext_x, rnext_y);
//                gl.glEnd();
//                
//                float Rx=(float)(R*Math.cos(i-(di/20)-Time));
//                float Ry=(float)(R*Math.sin(i-(di/20)-Time));
//                float Rnext_x=(float)(R*Math.cos(i+(di/20)-Time));
//                float Rnext_y=(float)(R*Math.sin(i+(di/20)-Time));
//                float Rz=0.5f;
//                float Rnext_z=Rz;
//                gl.glPointSize(10);
//                gl.glBegin(GL.GL_LINES);
//                    gl.glVertex2f(Rx, Ry);
//                    gl.glVertex2f(Rnext_x, Rnext_y);
//                gl.glEnd();
//                
//                Rectangle3D paddle= new Rectangle3D(new Point(Rx,Ry,Rz), 
//                        new Point(rx, ry, rz), 
//                        new Point(rnext_x, rnext_y, rnext_z),
//                        new Point(Rnext_x, Rnext_y, Rnext_z) , 
//                        1.0f);
//             
//                paddle.Draw(gl);
//            }
       
        if(n<10)
        {
            n++;
            wp[n-1] =new WhaterPortion();
        }
        for(int i=0; i<n;i++)
        {
            wp[i].Move(gl);
            wp[i].Draw(gl);
            if(VSpeed>0)
            {
            VSpeed=VSpeed;
            }
        }
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

