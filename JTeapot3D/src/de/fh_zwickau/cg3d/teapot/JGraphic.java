package de.fh_zwickau.cg3d.teapot;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public class JGraphic {
	
	private GL2 gl;
	private GLU glu;
	private GLUT glut;
	
	public void init(){
				
		gl.glNewList(1,GL2.GL_COMPILE);
		
		gl.glColor3f(1,1,1);		
		gl.glPushMatrix();
			gl.glRotatef(90,1,0,0);
			glut.glutWireTeapot(3);
		gl.glPopMatrix();	

		gl.glColor3f(0,0,1);
		glut.glutSolidCube(1);

		gl.glColor3f(1,1,0);
		gl.glPushMatrix();
			gl.glTranslatef(0,0,1);
			glut.glutSolidCube(1);
		gl.glPopMatrix();

		gl.glColor3f(0,1,0);
		gl.glPushMatrix();
			gl.glTranslatef(10,0,0);
			glut.glutSolidCube(1);
		gl.glPopMatrix();
		gl.glEndList();
	}
	
	public void draw(){
		gl.glShadeModel(GL2.GL_SMOOTH);
		
		gl.glCallList(1);
	}
	
	public void setGl(GL2 gl) {
		this.gl = gl;
	}
	
	public void setGlu(GLU glu) {
		this.glu = glu;
	}

	public void setGlut(GLUT glut) {
		this.glut = glut;
	}
	
	
}
