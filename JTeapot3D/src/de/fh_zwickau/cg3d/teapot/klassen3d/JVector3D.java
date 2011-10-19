package de.fh_zwickau.cg3d.teapot.klassen3d;


public class JVector3D {
	private float dx;
	private float dy;
	private float dz;
	
	public JVector3D(float x, float y, float z) {
		dx = x;
		dy = y;
		dz = z;
	}
	
	public void set(float x, float y, float z){
		dx = x;
		dy = y;
		dz = z;
	}
	
	public void set(JPoint3D p1, JPoint3D p2){
		dx = p2.getX() - p1.getX();
		dy = p2.getY() - p1.getY();
		dz = p2.getZ() - p1.getZ();
	}

	public float getDx() {
		return dx;
	}

	public float getDy() {
		return dy;
	}

	public float getDz() {
		return dz;
	}
	
	public float getLength(){
		return (float)Math.sqrt(dx * dx + dy * dy);
	}
	
	public void rotateZ(float angle){
		float x, y;
		
		x = (float) Math.cos(angle) * dx + (float)Math.sin(angle) * dy;
		y = (float)-Math.sin(angle) * dx + (float)Math.cos(angle) * dy;
		dx = x;
		dy = y;
	}
}
