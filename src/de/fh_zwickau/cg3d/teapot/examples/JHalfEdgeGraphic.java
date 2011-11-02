package de.fh_zwickau.cg3d.teapot.examples;

import java.util.HashSet;
import java.util.Set;

import javax.media.opengl.GL2;

import de.fh_zwickau.cg3d.teapot.core.JGraphic;
import de.fh_zwickau.cg3d.teapot.halfedge.JLoop;
import de.fh_zwickau.cg3d.teapot.halfedge.JSolid;
import de.fh_zwickau.cg3d.teapot.halfedge.JVector;
import de.fh_zwickau.cg3d.teapot.halfedge.facade.JSolidFacade;

public class JHalfEdgeGraphic extends JGraphic{

	@Override
	protected void init() {
		
		JSolid cube = new JSolid();
		
		Set<JVector> outerVectors = new HashSet<JVector>();
		outerVectors.add(new JVector(-50, -50, 0, 1));
		outerVectors.add(new JVector(50, -50, 0, 1));
		outerVectors.add(new JVector(50, 50, 0, 1));
		outerVectors.add(new JVector(-50, 50, 0, 1));
		JLoop outerFront = JSolidFacade.createLoop(outerVectors);
		
		Set<JVector> innerVectors = new HashSet<JVector>();
		innerVectors.add(new JVector(-20, -20, 0, 1));
		innerVectors.add(new JVector(20, -20, 0, 1));
		innerVectors.add(new JVector(20, 20, 0, 1));
		innerVectors.add(new JVector(-20, 20, 0, 1));
		JLoop innerFront1 = JSolidFacade.createLoop(innerVectors);
		
		Set<JLoop> innerLoops = new HashSet<JLoop>();
		innerLoops.add(innerFront1);
		
		
		JSolidFacade.addFace(cube, outerFront, innerLoops);
		
		JSolidFacade.compileSolid(cube, gl);
		
		gl.glShadeModel(GL2.GL_SMOOTH);
	}

	@Override
	public void draw() {
		gl.glCallList(1);
	}

}
