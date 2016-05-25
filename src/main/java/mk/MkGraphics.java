package main.java.mk;

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
        // TODO implement bresenham in all cases
    }

    /**
     * Draws the outline of the specified rectangle. The left and right edges of
     * the rectangle are at x and x + width. The top and bottom edges are at y
     * and y + height.
     *
     * @param g the graphic context in which the pixel will be drawn.
     * @param x x coordinate.
     * @param y y coordinate.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public static void drawRect(Graphics g, int x, int y, int width, int height) {
        // TODO implmement bresenham for a rectangle
    }

    /**
     * Draws a circle, with center in the x and y coordinates.
     *
     * @param g the graphic context in which the pixel will be drawn.
     * @param x the center x coordinate.
     * @param y the center y coordinate.
     * @param radius the radius of the circle.
     */
    public static void drawCircle(Graphics g, int x, int y, int radius) {
        // TODO implmement bresenham for a circle 
    }

    /**
     * Draws an ellipse, that fits within the rectangle specified by the x, y,
     * width, and height arguments.
     *
     * @param g the graphic context in which the pixel will be drawn.
     * @param x the center x coordinate.
     * @param y the center y coordinate.
     * @param width the width of the ellipse.
     * @param height the height of the ellipse.
     */
    public static void drawEllipse(Graphics g, int x, int y, int width, int height) {
        // TODO implmement bresenham for an oval
    }
}