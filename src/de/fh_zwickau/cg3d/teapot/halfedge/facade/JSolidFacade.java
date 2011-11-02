package de.fh_zwickau.cg3d.teapot.halfedge.facade;

import java.util.Iterator;
import java.util.Set;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUtessellator;

import de.fh_zwickau.cg3d.teapot.halfedge.JEdge;
import de.fh_zwickau.cg3d.teapot.halfedge.JFace;
import de.fh_zwickau.cg3d.teapot.halfedge.JHalfEdge;
import de.fh_zwickau.cg3d.teapot.halfedge.JLoop;
import de.fh_zwickau.cg3d.teapot.halfedge.JSolid;
import de.fh_zwickau.cg3d.teapot.halfedge.JVector;
import de.fh_zwickau.cg3d.teapot.halfedge.JVertex;
import de.fh_zwickau.cg3d.teapot.tessellation.HalfEdgeTessCallback;
/**
 * 
 * @author Eric Schwarzenberger
 *
 */
public class JSolidFacade {
	
	private static HalfEdgeTessCallback callback;
	
	public static void compileSolid(JSolid solid, GL2 gl){		
		
		// start tessellation
		GLUtessellator tess = GLU.gluNewTess();
		callback = new HalfEdgeTessCallback(gl);
		
		// register tessellation call-backs
		GLU.gluTessCallback(tess, GLU.GLU_TESS_VERTEX, callback);
		GLU.gluTessCallback(tess, GLU.GLU_TESS_BEGIN, callback);
		GLU.gluTessCallback(tess, GLU.GLU_TESS_END, callback);
		
		gl.glNewList(1, GL2.GL_COMPILE);
		
		GLU.gluTessBeginPolygon(tess, null);
		
	    Iterator<JVertex> vertIter = solid.getVertices().iterator();
	    boolean contourOpen = true;
	    
	    while(vertIter.hasNext()){
	    	GLU.gluTessBeginContour(tess);
	    	JVertex firstVertex = vertIter.next();
	    	while(contourOpen && vertIter.hasNext()){
	    		JVertex v = vertIter.next();
	    		if(v.equals(firstVertex))
	    		{
	    			contourOpen = false;
	    			break;
	    		}
	    		else{
	    			double[] coords = v.getCoordinates().getValues();
	    			GLU.gluTessVertex(tess, coords, 0, coords);
	    		}
	    	}
	    	GLU.gluTessEndContour(tess);
	    }    
		gl.glEndList();
		
		// complete tessellation
		GLU.gluDeleteTess(tess);
	}
	
	/**
	 * Fügt einem Solid die Fläche hinzu, welche durch den äußeren Loop und die
	 * Menge der inneren Loops definiert ist.
	 * @param solid
	 * @param outerLoop
	 * @param innerLoops
	 * @return
	 */
	public static JFace addFace(JSolid solid, JLoop outerLoop, Set<JLoop> innerLoops){
		
		JFace tmpFace = new JFace();
		tmpFace.setOuterLoop(outerLoop);
		
		for(JLoop innerLoop : innerLoops){
			// vectorSet ist eine Teilmenge von innerLoopVectors
			tmpFace.addInnerLoop(innerLoop);
		}
		
		tmpFace.setSolid(solid);
		
		return tmpFace;
	}
	
	/**
	 * Erzeugt einen Loop, indem aus den gegebenen Vektoren Kanten und
	 * und damit implizit Halbkanten erzeugt werden.
	 * @param vectors Die Eckvektoren des Loops.
	 * @return Ein fertiger Loop.
	 */
	public static JLoop createLoop(Set<JVector> vectors){
		
		if(vectors.size() < 3){
			System.err.println("Ein Loop muss mindestens drei Vectoren haben!");
			System.exit(-1);
		}
		
		JLoop tmpLoop = new JLoop();
		
		Iterator<JVector> iter = vectors.iterator();
		JVector prev = iter.next();
		JVector cur = null;
		while(iter.hasNext()){
			cur = iter.next();
			JEdge edge = createEdge(prev, cur);
			prev = cur;
			
			edge.getLeftHalfEdge().setLoop(tmpLoop);
			edge.getRightHalfEdge().setLoop(tmpLoop);
			
			tmpLoop.addHalfEdge(edge.getLeftHalfEdge());
			tmpLoop.addHalfEdge(edge.getRightHalfEdge());
		}
			
		// TODO: connect edges and half edges to create the loop
		
		return tmpLoop;
	}
	
	/**
	 * Erzeugt eine Kante aus den beiden gegebenen Vektoren. Außerdem werden
	 * implizit die Halbkanten erzeugt.
	 * @param loop
	 * @param start
	 * @param end
	 * @return
	 */
	
	private static JEdge createEdge(JVector start, JVector end){
		JEdge tmpEdge = new JEdge();
		JHalfEdge leftHalfEdge = new JHalfEdge();
		JHalfEdge rightHalfEdge = new JHalfEdge();
		JVertex leftHalfEdgeStart = new JVertex(start);
		JVertex rightHalfEdgeStart = new JVertex(end);
		
		// set half edges of vertices
		leftHalfEdgeStart.setHalfEdge(leftHalfEdge);
		rightHalfEdgeStart.setHalfEdge(rightHalfEdge);
		
		// set vertices of half edges
		leftHalfEdge.setStartVertex(leftHalfEdgeStart);
		rightHalfEdge.setStartVertex(rightHalfEdgeStart);
		
		// set edge of half edges
		leftHalfEdge.setParentEdge(tmpEdge);
		rightHalfEdge.setParentEdge(tmpEdge);
		
		// set half edges of edge
		tmpEdge.setLeftHalfEdge(leftHalfEdge);
		tmpEdge.setRightHalfEdge(rightHalfEdge);
		
		return tmpEdge;
	}
}
