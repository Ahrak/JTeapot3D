package de.fh_zwickau.cg3d.teapot.halfedge;


public class JHalfEdge {
	private JEdge parentEdge;
	private JVertex startVertex;
	private JLoop loop;
	private JHalfEdge next;
	private JHalfEdge previous;
	
	public JEdge getParentEdge() {
		return parentEdge;
	}
	public void setParentEdge(JEdge parentEdge) {
		this.parentEdge = parentEdge;
	}
	public JVertex getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(JVertex startVertex) {
		this.startVertex = startVertex;
	}
	public JLoop getLoop() {
		return loop;
	}
	public void setLoop(JLoop loop) {
		this.loop = loop;
	}
	public JHalfEdge getNext() {
		return next;
	}
	public void setNext(JHalfEdge next) {
		this.next = next;
	}
	public JHalfEdge getPrevious() {
		return previous;
	}
	public void setPrevious(JHalfEdge previous) {
		this.previous = previous;
	}
}
