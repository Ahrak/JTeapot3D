package de.fh_zwickau.cg3d.teapot.halfedge;

import java.util.HashSet;
import java.util.Set;

public class JSolid {
	
	// nextId -1 tells how much solids have been created
	private static short nextId = 0;
	
	private short id;
	private Set<JFace> faces;
	private Set<JEdge> edges;
	private Set<JVertex> vertices;
	private JSolid next;
	private JSolid previous;
	
	public JSolid() {
		this.id = nextId;
		nextId++;
		
		faces = new HashSet<JFace>();
		edges = new HashSet<JEdge>();
		vertices = new HashSet<JVertex>();
	}
	
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public Set<JFace> getFaces() {
		return faces;
	}
	public void setFaces(Set<JFace> faces) {
		this.faces = faces;
	}
	public void addFace(JFace face){
		faces.add(face);
	}
	public void removeFace(JFace face){
		faces.remove(face);
	}
	public Set<JEdge> getEdges() {
		return edges;
	}
	public void setEdges(Set<JEdge> edges) {
		this.edges = edges;
	}
	public Set<JVertex> getVertices() {
		return vertices;
	}
	public void setVertices(Set<JVertex> vertices) {
		this.vertices = vertices;
	}
	public JSolid getNext() {
		return next;
	}
	public void setNext(JSolid next) {
		this.next = next;
	}
	public JSolid getPrevious() {
		return previous;
	}
	public void setPrevious(JSolid previous) {
		this.previous = previous;
	}
}
