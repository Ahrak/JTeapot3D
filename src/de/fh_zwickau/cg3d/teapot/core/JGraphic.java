package de.fh_zwickau.cg3d.teapot.core;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public abstract class JGraphic {
	
	protected GL2 gl;
	protected GLU glu;
	protected GLUT glut;
	protected int currentList;
	
	public JGraphic() {
		currentList = 0;
	}
	
	protected abstract void init();
	
	public abstract void draw();
	
	protected int nextListNr(){
		return ++currentList;
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
