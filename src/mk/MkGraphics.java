package mk;

import java.awt.Graphics;

/**
 * The <code>Graphics</code> class allows an application to draw shapes in a
 * Graphics context passed in as a function parameter.
 *
 * @author Maiko Alberto Morales Roman
 */
public class MkGraphics {

    /**
     * Draws a pixel, in the given point in the given graphics context's
     * coordinate system.
     *
     * @param g the graphic context in which the pixel will be drawn.
     * @param x x coordinate.
     * @param y y coordinate.
     */
    public static void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }

    /**
     * Draws a line, between the points (x1, y1) and (x2, y2) in the given
     * graphics context's coordinate system.
     *
     * @param g the graphic context in which the pixel will be drawn.
     * @param x1 first x coordinate.
     * @param y1 first y coordinate.
     * @param x2 second x coordinate.
     * @param y2 second y coordinate.
     */
    public static void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        
        if(dx == 0 && dy == 0) {
        	MkGraphics.putPixel(g, x1, y1); // a point
        } else if(dx == 0) { // a vertical line
        	int x = x1;
    		int y = y1;
        	if (dy > 0) {
        		while(y <= y2) {
        			MkGraphics.putPixel(g, x, y);
        			y = y + 1;
        		}
        	} else {
        		while(y >= y2) {
        			MkGraphics.putPixel(g, x, y);
        			y = y - 1;
        		}
        	}
        } else if(dy == 0) { // an horizontal line
        	int x = x1;
    		int y = y1;
        	if (dx > 0) {
        		while(x <= x2) {
        			MkGraphics.putPixel(g, x, y);
        			x = x + 1;
        		}
        	} else {
        		while(x >= x2) {
        			MkGraphics.putPixel(g, x, y);
        			x = x - 1;
        		}
        	}
        } else if(dx > 0) {
        	if(dy > 0) {
		        if(dx > dy) {
		        	drawLineCase1(g, x1, y1, x2, dx, dy);
		        } else {	        
			        drawLineCase2(g, x1, y1, y2, dx, dy);
		        }
        	} else if (dy < 0){
        		if(-1*dy > dx) {
        			drawLineCase7(g, x1, y1, y2, dx, dy);
        		} else {
        			drawLineCase8(g, x1, y1, x2, dx, dy);
        		}
        	}
        } else if(dx < 0) {
        	if(dy > 0) {
        		if(-1*dx < dy) {
        			drawLineCase3(g, x1, y1, y2, dx, dy);
        		} else {
        			drawLineCase4(g, x1, y1, x2, dx, dy);
        		}
        	} else {
        		if(-1*dx > -1*dy) {
        			drawLineCase5(g, x1, y1, x2, dx, dy);
        		} else {
        			drawLineCase6(g, x1, y1, y2, dx, dy);
        		}
        	}
        }
    }

	private static void drawLineCase1(Graphics g, int x1, int y1, int x2, int dx, int dy) {
		int d = 2*dy - dx; // start
		
		int e = 2*dy;
		int ne = 2*(dy - dx);
		
		int x = x1;
		int y = y1;        
		MkGraphics.putPixel(g, x, y);
		
		while (x < x2) {
			if(d <= 0) { // east
				d = d + e;
				x = x + 1;
			} else { // northeast
				d = d + ne;
				x = x + 1;
				y = y + 1;
			}
			MkGraphics.putPixel(g, x, y);
		}
	}

    private static void drawLineCase2(Graphics g, int x1, int y1, int y2, int dx, int dy) {
    	int d = dy -2*dx; // start
    	
    	int n = -2*dx;
    	int ne = 2*(dy - dx);
    	
    	int x = x1;
    	int y = y1;
    	MkGraphics.putPixel(g, x, y);
    	
    	while(y < y2) {
    		if(d <= 0) { // northeast
    			d = d + ne;
    			x = x + 1;
    			y = y + 1;
    		} else { // north
    			d = d + n;
    			y = y + 1;
    		}
    		MkGraphics.putPixel(g, x, y);
    	}    	
	}
    
    private static void drawLineCase3(Graphics g, int x1, int y1, int y2, int dx, int dy) {
    	int d = -(2*dx + dy); // start
    	
    	int n = -2*dx;
    	int nw = -2*(dx + dy);
    	
    	int x = x1;
    	int y = y1;
    	MkGraphics.putPixel(g, x, y);
    	
    	while(y < y2) {
    		if(d >= 0) {
    			d = d + nw;
    			x = x - 1;
    			y = y + 1;
    		} else {
    			d = d + n;
    			y = y + 1;
    		}
    		MkGraphics.putPixel(g, x, y);
    	}
    }
    
    private static void drawLineCase4(Graphics g, int x1, int y1, int x2, int dx, int dy) {
		int d = -(dx + 2*dy); // start
		
		int w = -2*dy;
		int nw = -2*(dx + dy);
		
		int x = x1;
    	int y = y1;
    	MkGraphics.putPixel(g, x, y);
    	
    	while(x > x2) {
    		if(d <= 0) { // northwest
    			d = d + nw;
    			x = x - 1;
    			y = y + 1;
    		} else { // west
    			d = d + w;
    			x = x - 1;
    		}
    		MkGraphics.putPixel(g, x, y);
    	}
	}
    
    private static void drawLineCase5(Graphics g, int x1, int y1, int x2, int dx, int dy) {
		int d = -2*dy + dx; // start
		
		int w = -2*dy;
		int sw = -2*(dy - dx);
		
		int x = x1;
		int y = y1;
    	MkGraphics.putPixel(g, x, y);
    	
    	while(x > x2) {
    		if(d >= 0) { // southwest
    			d = d + sw;
    			x = x - 1;
    			y = y - 1;
    		} else { // west
    			d = d + w;
    			x = x - 1;
    		}
        	MkGraphics.putPixel(g, x, y);
    	}
	}
    
    private static void drawLineCase6(Graphics g, int x1, int y1, int y2, int dx, int dy) {
		int d = 2*dx - dy; // start
		
		int s = 2*dx;
		int sw = 2*(dx - dy);
		
		int x = x1;
		int y = y1;
    	MkGraphics.putPixel(g, x, y);
    	
    	while( y > y2) {
    		if(d <= 0) { // south west
    			d = d + sw;
    			y = y - 1;
    			x = x - 1;
    		} else { // south
    			d = d + s;
    			y = y - 1;
    		}
        	MkGraphics.putPixel(g, x, y);
    	}
		
	}
    
    private static void drawLineCase7(Graphics g, int x1, int y1, int y2, int dx, int dy) {
		int d = 2*dx + dy; // start
		
		int s = 2*dx;
		int se = 2*(dy + dx);
		
		int x = x1;
		int y = y1;
    	MkGraphics.putPixel(g, x, y);
    	
    	while(y > y2) {
    		if(d >= 0) { // south east
    			d = d + se;
    			x = x + 1;
    			y = y - 1;
    		} else { // south
    			d = d + s;
    			y = y - 1;
    		}
        	MkGraphics.putPixel(g, x, y);
    	}
	}
    
    private static void drawLineCase8(Graphics g, int x1, int y1, int x2, int dx, int dy) {
		int d = 2*dy + dx; // start
		
		int e = 2*dy;
		int se = 2*(dy + dx);
		
		int x = x1;
		int y = y1;
    	MkGraphics.putPixel(g, x, y);
		
		while(x < x2) {
			if(d <= 0) { // south east
				d = d + se;
				x = x + 1;
				y = y - 1;
			} else { // east
				d = d + e;
				x = x + 1;
			}
	    	MkGraphics.putPixel(g, x, y);
		}
	}

	/**
     * Draws the outline of the specified rectangle.
     *
     * @param g the graphic context in which the pixel will be drawn.
     * @param x1 x1 start point coordinate.
     * @param y1 y1 start point coordinate.
     * @param x2 y2 end point coordinate.
     * @param y2 x2 end point coordinate.
     */
    public static void drawRect(Graphics g, int x1, int y1, int x2, int y2) {
    	MkGraphics.drawLine(g, x1, y1, x2, y1);
    	MkGraphics.drawLine(g, x1, y1, x1, y2);
    	MkGraphics.drawLine(g, x1, y2, x2, y2);
    	MkGraphics.drawLine(g, x2, y1, x2, y2);
    }

    /**
     * Draws a circle, with center in the x and y coordinates.
     *
     * @param g the graphic context in which the pixel will be drawn.
     * @param cx the center x coordinate.
     * @param cy the center y coordinate.
     * @param radius the radius of the circle.
     */
    public static void drawCircle(Graphics g, int cx, int cy, int radius) {
    	int x = 0;
    	int y = radius;
    	int d = 1 - radius;
    	int e = 3;
    	int se = -2*radius + 5;
    	drawCircle(g, cx, cy, x, y);
    	
    	while(y > x) {
    		if(d < 0) { // east
    			d = d + e;
    			e = e + 2;
    			se = se + 2;
    			x = x + 1;
    		} else { // south east
    			d = d + se;
    			e = e + 2;
    			se = se + 4;
    			x = x + 1;
    			y = y - 1;
    		}
    		drawCircle(g, cx, cy, x, y);
    	}
    }

    private static void drawCircle(Graphics g, int cx, int cy, int x, int y) {
		MkGraphics.putPixel(g, cx + x, cy + y);
		MkGraphics.putPixel(g, cx + y, cy + x);
		MkGraphics.putPixel(g, cx + x, cy - y);
		MkGraphics.putPixel(g, cx - y, cy + x);
		MkGraphics.putPixel(g, cx - x, cy - y);
		MkGraphics.putPixel(g, cx - y, cy - x);
		MkGraphics.putPixel(g, cx - x, cy + y);
		MkGraphics.putPixel(g, cx + y, cy - x);
	}

	/**
     * Draws an ellipse, that fits within the rectangle specified by the x, y,
     * width, and height arguments.
     *
     * @param g the graphic context in which the pixel will be drawn.
     * @param cx the center x coordinate.
     * @param cy the center y coordinate.
     * @param width the width of the ellipse.
     * @param height the height of the ellipse.
     */
    public static void drawEllipse(Graphics g, int xm, int ym, int a, int b) {
    	int x = -a, y = 0; /* II. quadrant from bottom left to top right */
    	long e2 = b, dx = (1+2*x)*e2*e2; /* error increment */
    	long dy = x*x, err = dx+dy; /* error of 1.step */
    	
    	do {
    		MkGraphics.putPixel(g, xm-x, ym+y); /* I. Quadrant */
    		MkGraphics.putPixel(g, xm+x, ym+y); /* II. Quadrant */
    		MkGraphics.putPixel(g, xm+x, ym-y); /* III. Quadrant */
    		MkGraphics.putPixel(g, xm-x, ym-y); /* IV. Quadrant */
	    	e2 = 2*err;
	    	if (e2 >= dx) { x++; err += dx += 2*(long)b*b; } /* x step */
	    	if (e2 <= dy) { y++; err += dy += 2*(long)a*a; } /* y step */
    	} while (x <= 0);
    	
    	while (y++ < b) { /* to early stop for flat ellipses with a=1, */
    		MkGraphics.putPixel(g, xm, ym+y); /* -> finish tip of ellipse */
    		MkGraphics.putPixel(g, xm, ym-y);
    	}
    }
}
