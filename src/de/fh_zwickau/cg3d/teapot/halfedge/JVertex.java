package de.fh_zwickau.cg3d.teapot.halfedge;

public class JVertex {
	private static short nextId;
	
	private short id;
	private JHalfEdge halfEdge;
	private JVector coordinates;
	private JVertex next;
	private JVertex previous;
	
	public JVertex(JVector coordinates) {
		this.id = nextId;		
		nextId++;
		this.coordinates = coordinates;
	}
	
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public JHalfEdge getHalfEdge() {
		return halfEdge;
	}
	public void setHalfEdge(JHalfEdge halfEdge) {
		this.halfEdge = halfEdge;
	}
	public JVector getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(JVector coordinates) {
		this.coordinates = coordinates;
	}
	public JVertex getNext() {
		return next;
	}
	public void setNext(JVertex next) {
		this.next = next;
	}
	public JVertex getPrevious() {
		return previous;
	}
	public void setPrevious(JVertex previous) {
		this.previous = previous;
	}
}
