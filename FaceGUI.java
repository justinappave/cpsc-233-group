import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * GUI for drawing faces.  This example asks the user if they want to see a small,
 * medium or large face.
 */
public class FaceGUI extends JFrame {
    // Information on how to draw a face.  The information for
    // the face, eyes and mouth is relative.  Each number indicates
    // a percentage of the space available that should be used
    // for each component and a percentage to move left for the
    // x-coordinates and a percentage to move down for the 
    // y-coordinates.
    
    // Relative info for face (circle) where (x,y) are top left of
    // bounding box and diameter is size of bounding box.
    public static final float FACE_DIAMETER = 1.0f;
    public static final float X_FACE = 0.0f;
    public static final float Y_FACE = 0.0f;
    
    // Relative info for eyes
    public static final float EYE_WIDTH  =  0.3f;
    public static final float EYE_HEIGHT = 0.15f;
    public static final float X_LEFT_EYE = 0.15f;
    public static final float X_RIGHT_EYE = 0.55f;
    public static final float Y_RIGHT_EYE = 0.35f;
    public static final float Y_LEFT_EYE = 0.35f;
    
    //Relative info for mouth
    public static final float MOUTH_WIDTH = 0.5f;
    public static final float MOUTH_HEIGHT = 0.25f;
    public static final float X_MOUTH = 0.25f;
    public static final float Y_MOUTH = 0.55f;
    public static final int MOUTH_START_ANGLE = 180;
    public static final int MOUTH_DEGREES_SHOWN = 180;
    
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;
    public static final int BORDER_SIZE = 50;
    
    public String sizeOfFace = "Small";
   
    /** 
     * Draws a face in the specified bounding box on the specified canvas.
     * The relative information for a face stored in the constants is transformed to
     * ensure the face fills the entire bounding box.
     * <p>
     * The bounding box to draw in should be contained in the canvas/window, otherwise
     * nothing will show in the window.
     *
     * @param canvas the canvas/window to draw the face in.
     * @param top_x the x-coordinate of the top-left corner of the box to draw in.
     * @param top_y the y-coordinate of the top-left corner of the box to draw in.
     * @param width the width of the bounding box to draw in.
     * @param height the height of the boudning box to draw in.
     */
    public void drawFace(Graphics canvas, int top_x, int top_y, int width, int height) { 
        // Draw face outline
        canvas.drawOval((int)(width * X_FACE) + top_x, 
                        (int)(height * Y_FACE) + top_y,
                        (int)(width * FACE_DIAMETER), 
                        (int)(height * FACE_DIAMETER));
        //Draw eyes
        canvas.fillOval((int)(width * X_LEFT_EYE) + top_x,
                        (int)(height * Y_LEFT_EYE) + top_y,
                        (int)(width * EYE_WIDTH),
                        (int)(height * EYE_HEIGHT));
        canvas.fillOval((int)(width * X_RIGHT_EYE) + top_x,
                        (int)(height * Y_RIGHT_EYE) + top_y,
                        (int)(width * EYE_WIDTH),
                        (int)(height * EYE_HEIGHT));
                        
        // Draw mouth
        canvas.drawArc((int)(width * X_MOUTH) + top_x,
                        (int)(height * Y_MOUTH) + top_y,
                        (int)(width * MOUTH_WIDTH),
                        (int)(height * MOUTH_HEIGHT),
                        MOUTH_START_ANGLE, MOUTH_DEGREES_SHOWN);
    }    

    /**
     * Draws what should be displayed in this window.  this will be called each
     * time the window needs to be refreshed.  This includes when the window
     * is displayed, maximized, moved, etc.)
     * <p>
     * Currently, it just draws one face.  This code will have to be updated such
     * that more faces are drawn based on the value stored in numberOfFaces.  Use
     * a switch statement to determine the value and draw the correct number of faces.
     * <p>
     * To draw more faces, you will have to make the bounding box for each
     * face smaller than if there is just one face and for each face drawn in a single
     * window, you'll have to move the top-left corner.
     *
     * @param canvas the canvas/window to draw in.
     */
    public void paint(Graphics canvas) {
        // Set bounding box to draw face into.  This includes the top-left
        // x and y coordinates and the width and height of the box to draw in.

        switch (sizeOfFace) {
        case "Small":
            int top_x = BORDER_SIZE * 3;
            int top_y = BORDER_SIZE * 3;
            int width = (getWidth() - 2 * 3 * BORDER_SIZE);
            int height = (getHeight() - 2 * 3 * BORDER_SIZE);
            drawFace(canvas,top_x,top_y,width,height);
        case "Medium":
            top_x = BORDER_SIZE * 2;
            top_y = BORDER_SIZE * 2;
            width = (getWidth() - 2 * 2 * BORDER_SIZE);
            height = (getHeight() - 2 * 2 * BORDER_SIZE);
            drawFace(canvas,top_x,top_y,width,height);
            break;
        case "Large":
            top_x = BORDER_SIZE;
            top_y = BORDER_SIZE;
            width = (getWidth() - 2 * BORDER_SIZE);
            height = (getHeight() - 2 * BORDER_SIZE);
            drawFace(canvas,top_x,top_y,width,height);
            break;
        }
    }
    
    /** 
     * Creates the actual window for the faces.
     */
    public FaceGUI() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Run the program by prompting the user for the number of faces
     * to draw, then creating the window for the faces.
     */    
    public static void main(String[] args) {
        // Create the window.
        FaceGUI faceWindow = new FaceGUI();

        // Ask the user for the size of the face
        Object[] possibleValues = { "Small", "Medium", "Large"};
        String size = (String)JOptionPane.showInputDialog(null,
                        "What size would you like the face to be?", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        possibleValues, possibleValues[0]);    
        // Set the size of the face in the window object                
        faceWindow.sizeOfFace = size;
        
        // Make the window visible.
        faceWindow.setVisible(true);
    }
}
