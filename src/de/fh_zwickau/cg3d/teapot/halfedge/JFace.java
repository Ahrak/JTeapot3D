package de.fh_zwickau.cg3d.teapot.halfedge;

import java.util.HashSet;
import java.util.Set;


public class JFace {
	private static short nextId;
	
	private short id;
	private JSolid solid;
	private JLoop outerLoop;
	private Set<JLoop> innerLoops;
	private JVector faceEquation;
	private JFace next;
	private JFace previous;
	
	public JFace() {
		this.innerLoops = new HashSet<JLoop>();
	}
	
	public short getId() {
		return id;
	}
	public JSolid getSolid() {
		return solid;
	}
	public void setSolid(JSolid solid) {
		this.solid = solid;
	}
	public JLoop getOuterLoop() {
		return outerLoop;
	}
	public void setOuterLoop(JLoop outerLoop) {
		this.outerLoop = outerLoop;
	}
	public Set<JLoop> getInnerLoops() {
		return innerLoops;
	}
	public void setInnerLoops(Set<JLoop> innerLoops) {
		this.innerLoops = innerLoops;
	}
	public JVector getFaceEquation() {
		return faceEquation;
	}
	public void addInnerLoop(JLoop innerLoop){
		this.innerLoops.add(innerLoop);
	}
	public void setFaceEquation(JVector faceEquation) {
		this.faceEquation = faceEquation;
	}
	public JFace getNext() {
		return next;
	}
	public void setNext(JFace next) {
		this.next = next;
	}
	public JFace getPrevious() {
		return previous;
	}
	public void setPrevious(JFace previous) {
		this.previous = previous;
	}
}
