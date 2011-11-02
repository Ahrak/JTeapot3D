package de.fh_zwickau.cg3d.teapot.examples;

import javax.media.opengl.GL2;

import de.fh_zwickau.cg3d.teapot.core.JGraphic;

public class JTeapotGraphic extends JGraphic{

	@Override
	protected void init() {
		gl.glNewList(nextListNr(),GL2.GL_COMPILE);
		
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
		
		gl.glShadeModel(GL2.GL_SMOOTH);
	}

	@Override
	public void draw() {
		
		gl.glCallList(currentList);
	}
}
