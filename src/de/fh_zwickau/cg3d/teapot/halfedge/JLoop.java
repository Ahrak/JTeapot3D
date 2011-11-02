package de.fh_zwickau.cg3d.teapot.halfedge;

import java.util.HashSet;
import java.util.Set;

public class JLoop {
	private Set<JHalfEdge> halfEgdes;
	private JFace face;
	private JLoop next;
	private JLoop previous;
	
	public JLoop() {
		this.halfEgdes = new HashSet<JHalfEdge>();
	}
	
	public Set<JHalfEdge> getHalfEgdes() {
		return halfEgdes;
	}
	public void setHalfEgdes(Set<JHalfEdge> egdes) {
		this.halfEgdes = egdes;
	}
	public void addHalfEdge(JHalfEdge halfEdge){
		this.halfEgdes.add(halfEdge);
	}
	public JFace getFace() {
		return face;
	}
	public void setFace(JFace face) {
		this.face = face;
	}
	public JLoop getNext() {
		return next;
	}
	public void setNext(JLoop next) {
		this.next = next;
	}
	public JLoop getPrevious() {
		return previous;
	}
	public void setPrevious(JLoop previous) {
		this.previous = previous;
	}
}
