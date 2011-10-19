package de.fh_zwickau.cg3d.teapot.klassen3d;

public class JPoint3D {
	private float x;
	private float y;
	private float z;
	
	public JPoint3D(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	public void set(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
