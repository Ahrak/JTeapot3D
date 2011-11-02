package de.fh_zwickau.cg3d.teapot.core;

import de.fh_zwickau.cg3d.teapot.classes3d.JPoint3D;
import de.fh_zwickau.cg3d.teapot.classes3d.JVector3D;

public abstract class JOpenGL3D extends JOpenGL{

	private static final long serialVersionUID = 1L;
	
	protected boolean isOrtho;
	protected boolean isFrustum;
	protected boolean isPerspective;
	
	protected float left;
	protected float right;
	protected float bottom;
	protected float top;
	protected float near;
	protected float far;
	protected float angle;
	protected float aspect;
	JPoint3D position;
	JPoint3D target;
	JVector3D viewingUp;
	
	public JOpenGL3D() {
		isFrustum = false;
		isOrtho = true;
		isPerspective = false;
		position = new JPoint3D(0, 0, 0);
		target = new JPoint3D(0, 0, -1);
		viewingUp = new JVector3D(0, 1, 0);
		left = bottom = near = -1;
		right = top = far = 1;
		angle = 30;
		aspect = 1;
		red = green = blue = 0.3f;
	}
	
	public void lookAt(final JPoint3D position, final JPoint3D target, final JVector3D viewingUp){
		this.position = position;
		this.target = target;
		this.viewingUp = viewingUp;
	}
	
	public void ortho(float left, float right, float bottom, float top, float near, float far){
		isFrustum = false;
		isOrtho = true;
		isPerspective = false;
		this.left = left;
		this.right = right;
		this.bottom = bottom;
		this.top = top;
		this.near = near;
		this.far = far;
	}
	
	public void frustum(float left, float right, float bottom, float top, float near, float far){
		isFrustum = true;
		isOrtho = false;
		isPerspective = false;
		this.left = left;
		this.right = right;
		this.bottom = bottom;
		this.top = top;
		this.near = near;
		this.far = far;
	}
	
	public void perspective(float angle, float aspect, float near, float far){
		isFrustum = false;
		isOrtho = false;
		isPerspective = true;
		this.angle = angle;
		this.aspect = aspect;
		this.near = near;
		this.far = far;
	}
}
