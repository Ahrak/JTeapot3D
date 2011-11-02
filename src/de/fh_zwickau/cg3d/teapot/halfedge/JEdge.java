package de.fh_zwickau.cg3d.teapot.halfedge;

public class JEdge {
	private JHalfEdge rightHalfEdge;
	private JHalfEdge leftHalfEdge;
	private JEdge next;
	private JEdge previous;
	
	public JHalfEdge getRightHalfEdge() {
		return rightHalfEdge;
	}
	public void setRightHalfEdge(JHalfEdge rightHalfEdge) {
		this.rightHalfEdge = rightHalfEdge;
	}
	public JHalfEdge getLeftHalfEdge() {
		return leftHalfEdge;
	}
	public void setLeftHalfEdge(JHalfEdge leftHalfEdge) {
		this.leftHalfEdge = leftHalfEdge;
	}
	public JEdge getNext() {
		return next;
	}
	public void setNext(JEdge next) {
		this.next = next;
	}
	public JEdge getPrevious() {
		return previous;
	}
	public void setPrevious(JEdge previous) {
		this.previous = previous;
	}
}
