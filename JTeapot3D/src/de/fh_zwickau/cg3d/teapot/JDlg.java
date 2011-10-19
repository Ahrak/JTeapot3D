package de.fh_zwickau.cg3d.teapot;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.fh_zwickau.cg3d.teapot.klassen3d.JPoint3D;
import de.fh_zwickau.cg3d.teapot.klassen3d.JVector3D;

public class JDlg extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MyJOpenGL openGL;
	private JGraphic graphic;
	
	private float camX;
	private float camY;
	private float camZ;
	private float zoom;
	private float angleXY;
	private float angleZ;
	
	private JPanel contentPane;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtZ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDlg frame = new JDlg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JDlg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtX = new JTextField();
		txtX.setBounds(12, 18, 40, 19);
		contentPane.add(txtX);
		txtX.setColumns(10);
		txtX.setText(((Integer)(int)camX).toString());
		
		txtY = new JTextField();
		txtY.setBounds(57, 18, 40, 19);
		contentPane.add(txtY);
		txtY.setColumns(10);
		txtY.setText(((Integer)(int)camY).toString());
		
		txtZ = new JTextField();
		txtZ.setBounds(100, 18, 40, 19);
		contentPane.add(txtZ);
		txtZ.setColumns(10);
		txtZ.setText(((Integer)(int)camZ).toString());
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(26, -2, 15, 19);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(67, 0, 15, 15);
		contentPane.add(lblY);
		
		JLabel lblZ = new JLabel("z");
		lblZ.setBounds(109, 0, 15, 15);
		contentPane.add(lblZ);
		
		JButton btnOk = new JButton("Position anwenden");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(openGL == null)
					return;
				
				camX = Float.valueOf(txtX.getText());
				camY = Float.valueOf(txtY.getText());
				camZ = Float.valueOf(txtZ.getText());
				
				onCamera();
				openGL.invalidate();
			}
		});
		btnOk.setBounds(12, 49, 178, 25);
		contentPane.add(btnOk);
		
		JLabel lblZoom = new JLabel("Zoom");
		lblZoom.setBounds(12, 100, 70, 15);
		contentPane.add(lblZoom);
		
		final JSlider sliderZoom = new JSlider();
		sliderZoom.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int position = sliderZoom.getValue();
				
				zoom = (float)(position - sliderZoom.getMinimum())
						/ (sliderZoom.getMaximum() - sliderZoom.getMinimum())
						* (3-0)+0;
				zoom = (float)Math.pow(10, zoom);
				
				if(openGL != null){
					openGL.ortho(-zoom, zoom, -zoom, zoom, -100000, 100000);
					openGL.invalidate();
				}
			}
		});
		sliderZoom.setValue(10);
		sliderZoom.setMajorTickSpacing(1);
		sliderZoom.setMaximum(30);
		sliderZoom.setBounds(2, 127, 200, 16);
		contentPane.add(sliderZoom);
		
		final JSlider sliderWinkelZ = new JSlider();
		sliderWinkelZ.setOrientation(SwingConstants.VERTICAL);
		sliderWinkelZ.setMajorTickSpacing(1);
		sliderWinkelZ.setMaximum(18);
		sliderWinkelZ.setMinimum(-18);
		sliderWinkelZ.setBounds(214, -2, 31, 259);
		sliderWinkelZ.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int position = sliderWinkelZ.getValue();
				
				angleZ = (float)(position - sliderWinkelZ.getMinimum())
						/ (sliderWinkelZ.getMaximum()-sliderWinkelZ.getMinimum())
						* (-90-90)+90;
				
				onCamera();
				if(openGL != null)
					openGL.invalidate();
			}
		});
		contentPane.add(sliderWinkelZ);
		
		final JSlider sliderWinkelXY = new JSlider();
		sliderWinkelXY.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int position = sliderWinkelXY.getValue();
				
				angleXY = (float)(position - sliderWinkelXY.getMinimum())
						/ (sliderWinkelXY.getMaximum() - sliderWinkelXY.getMinimum())
						* (360 - 0)+0;
				
				if(graphic !=null)
					onCamera();
				if(openGL != null)
					openGL.invalidate();
			}
		});
		sliderWinkelXY.setMajorTickSpacing(1);
		sliderWinkelXY.setMaximum(72);
		sliderWinkelXY.setBounds(0, 183, 202, 25);
		contentPane.add(sliderWinkelXY);
		
		openGL = new MyJOpenGL();
		graphic = new JGraphic();
		openGL.setGraphic(graphic);
		
		openGL.InitOpenGL("OpenGL - Teapot", 500, 500);

		openGL.setBackground(0.5f,0.5f,0.5f);
		
		zoom = 10;
		sliderZoom.setValue((int)(Math.log10(zoom)-0)*(sliderZoom.getMaximum()-
				sliderZoom.getMinimum()) / (3-0) + sliderZoom.getMinimum());
		
		angleXY = 280;
		sliderWinkelXY.setValue((int)(angleXY-0)*(sliderWinkelXY.getMaximum()-
				sliderWinkelXY.getMinimum())/(360-0)+sliderWinkelXY.getMinimum());
		
		angleZ = 15;
		sliderWinkelZ.setValue((int)(angleZ-90)*(sliderWinkelZ.getMaximum()-
				sliderWinkelZ.getMinimum()) / (-90-90)+sliderWinkelZ.getMinimum());
		
		onCamera();
		openGL.ortho(-zoom, zoom, -zoom, zoom, -100000, 100000);
	}
	
	public void onCamera(){
		JPoint3D camPos = new JPoint3D(0, 0, 0);
		float angleXY, angleZ;
		float xx, yy, zz;
		
		angleXY = this.angleXY / 180 * (float)Math.PI;
		angleZ = this.angleZ / 180 * (float)Math.PI;
		
		xx = camX + (float)Math.cos(angleZ) * (float)Math.cos(angleXY);
		yy = camY + (float)Math.cos(angleZ) * (float)Math.sin(angleXY);
		zz = camZ + (float)Math.sin(angleZ);
		camPos.set(xx, yy, zz);
		
		if(Math.abs((float)Math.sin(angleZ)) < 0.999f){
			openGL.lookAt(camPos, new JPoint3D(camX, camY, camZ),
					new JVector3D(0,0,1));
		}
		else if(Math.sin(angleZ) > 0){
			openGL.lookAt(camPos, new JPoint3D(camPos.getX(), camPos.getY(), camPos.getZ()-1),
					new JVector3D((float)-Math.cos(angleXY), (float)-Math.sin(angleXY), 0));
		}
		else{
			openGL.lookAt(camPos, new JPoint3D(camPos.getX(),
					camPos.getY(), camPos.getZ()),
					new JVector3D((float)Math.cos(angleXY), (float)Math.sin(angleXY), 0));
		}
	}
}
