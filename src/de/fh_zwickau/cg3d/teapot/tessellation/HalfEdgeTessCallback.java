package de.fh_zwickau.cg3d.teapot.tessellation;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUtessellatorCallbackAdapter;

public class HalfEdgeTessCallback extends GLUtessellatorCallbackAdapter{
	
	private GL2 gl;
	
	public HalfEdgeTessCallback(GL2 gl) {
		this.gl = gl;
	}
	
	@Override
	public void begin(int type) {
		gl.glBegin(type);
	}
	
	@Override
	public void vertex(Object vertexData) {
		double[] pointer;
	      if (vertexData instanceof double[])
	      {
	        pointer = (double[]) vertexData;
	        if (pointer.length == 6)
	        	gl.glColor3dv(pointer, 3);
	        gl.glVertex3dv(pointer, 0);
	      }
	}
	
	@Override
	public void end() {
		gl.glEnd();
	}
	
	 public void error(int errnum)
	 {
		 GLU glu = new GLU();
	     String estring;

	     estring = glu.gluErrorString(errnum);
	     System.err.println("Tessellation Error: " + estring);
	     System.exit(0);
	 }
}
