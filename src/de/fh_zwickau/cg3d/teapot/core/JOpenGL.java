package de.fh_zwickau.cg3d.teapot.core;

import javax.media.opengl.GL2;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.jogamp.opengl.util.gl2.GLUT;

public abstract class JOpenGL extends JFrame implements GLEventListener {
	
	private static final long serialVersionUID = 1L;
	
	protected float red;
	protected float green;
	protected float blue;
	
	protected float xMin;
	protected float xMax;
	protected float yMin;
	protected float yMax;
	protected JGraphic graphic; 
	
	private GLCapabilities capabilities;
	private GLCanvas canvas;
	
	protected GL2 gl;
	protected GLU glu;
	protected GLUT glut;
	
	public JOpenGL() {
		red = 1;
		green = 1;
		blue = 1;
		xMin = -50;
		xMax = 50;
		yMin = -50;
		yMax = 50;
		graphic = null;
	}
	public void InitOpenGL(String text, int width, int height){
		setTitle(text);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		glu = new GLU();
		glut = new GLUT();
		capabilities = new GLCapabilities(GLProfile.get(GLProfile.GL2));
		capabilities.setDoubleBuffered(true);
		canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		add(canvas);
		canvas.requestFocus();
		setVisible(true);
	}
	
	public void setGraphic(JGraphic graphic){
		this.graphic = graphic;
	}
	
	public void setWindow(float xMin, float xMax, float yMin, float yMax){
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}
	public void getWindow(Float xMin, Float xMax, Float yMin, Float yMax){
		xMin = this.xMin;
		xMax = this.xMax;
		yMin = this.yMin;
		yMax = this.yMax;
	}
	public float getRatio(){
		return (xMax - xMin) / (yMax - yMin);
	}
	public void setBackground(float r, float g, float b){
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	public GL2 getGl() {
		return gl;
	}
	public GLU getGlu() {
		return glu;
	}
	public GLUT getGlut() {
		return glut;
	}
	public void invalidate(){
		canvas.repaint();
	}
}
