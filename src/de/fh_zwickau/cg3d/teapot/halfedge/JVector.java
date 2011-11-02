package de.fh_zwickau.cg3d.teapot.halfedge;


public class JVector {
	private double[] values = new double[4];

	public JVector(float x, float y, float z, float h) {
		values[0] = x;
		values[1] = y;
		values[2] = z;
		values[3] = h;
	}
	
	public double[] getValues() {
		return values;
	}

	public void setValues(double[] values) {
		this.values = values;
	}
}
