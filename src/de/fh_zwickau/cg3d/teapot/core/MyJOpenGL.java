package de.fh_zwickau.cg3d.teapot.core;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

public class MyJOpenGL extends JOpenGL3D {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void display(GLAutoDrawable arg0) {
		
		gl.glClearColor(red, green, blue, 1f);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glEnable(GL.GL_DEPTH_TEST);
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		if(isOrtho)
			gl.glOrtho(left, right, bottom, top, near, far);
		else if(isFrustum)
			gl.glFrustum(left, right, bottom, top, near, far);
		else if(isPerspective)
			glu.gluPerspective(angle, aspect, near, far);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		glu.gluLookAt(position.getX(), position.getY(), position.getZ(),
				target.getX(), target.getY(), target.getZ(),
				viewingUp.getDx(), viewingUp.getDy(), viewingUp.getDz());
		
		graphic.draw();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		graphic.setGl(gl);
		graphic.setGlu(glu);
		graphic.setGlut(glut);
		// Workaround, because somehow I cannot use the GL commands from the
		// dialog thread
		graphic.init();
	}
	@Override
	public void reshape(GLAutoDrawable d, int x, int y, int width,
			int height) {
		
		int dim = Math.min(width, height);
    	gl.glViewport(0, 0, dim, dim);
	}
	
}
