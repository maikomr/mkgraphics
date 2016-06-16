package mk;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MkGraphicsLibraryTest extends JFrame {
	private static final long serialVersionUID = 1L;

	public MkGraphicsLibraryTest() {
		super("MkGraphics Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
	}

	@Override
	public void paint(Graphics g) {

		// a point
		MkGraphics.drawLine(g, 10, 20, 10, 20);

		// vertical lines
		MkGraphics.drawLine(g, 100, 100, 100, 200);
		MkGraphics.drawLine(g, 100, 100, 100, 0);

		// horizontal lines
		MkGraphics.drawLine(g, 100, 100, 150, 100);
		MkGraphics.drawLine(g, 100, 100, 50, 100);

		// all cases
		MkGraphics.drawLine(g, 100, 100, 150, 120);
		MkGraphics.drawLine(g, 100, 100, 150, 200);
		MkGraphics.drawLine(g, 100, 100, 50, 200);
		MkGraphics.drawLine(g, 100, 100, 50, 120);
		MkGraphics.drawLine(g, 100, 100, 50, 80);
		MkGraphics.drawLine(g, 100, 100, 50, 0);
		MkGraphics.drawLine(g, 100, 100, 150, 0);
		MkGraphics.drawLine(g, 100, 100, 150, 80);

		// a rectangle
		MkGraphics.drawRect(g, 250, 200, 400, 250);

		// a circle
		MkGraphics.drawCircle(g, 300, 100, 50);

		// horizontal ellipse
		MkGraphics.drawEllipse(g, 500, 100, 100, 50);

		// vertical ellipse
		MkGraphics.drawEllipse(g, 500, 300, 50, 100);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

	protected static void createAndShowGUI() {
		JFrame graphicsTest = new MkGraphicsLibraryTest();
		graphicsTest.pack();
		graphicsTest.setVisible(true);
	}
}
