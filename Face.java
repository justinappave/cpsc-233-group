import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics;

/**
 * When you run this application it opens a window that shows the drawing of a face.
 * The face is drawn such that it fills up the entire window.
 */
public class Face extends JFrame {
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
    
    public static final int DEFAULT_WINDOW_WIDTH = 400;
    public static final int DEFAULT_WINDOW_HEIGHT = 400;
    public static final int BORDER_SIZE = 50;

    // By default, we'll draw one face
    public int numberOfFaces = 1;

    /**
     * This method draws a face such that it fills the bounding box
     * defined by the top (x,y) coordinate and the width and height specified.
     * @param canvas the space the face should be drawn in.
     * @param top_x the x-coordinate of the top-left corner of the bounding box to draw in.
     * @param top_y the y-coordinate of the top-left corner of the bounding box to draw in.
     * @param width the width of the bounding box to draw the face in.
     * @param height the height of the bounding box to draw the face in.
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
     * This method will be called automatically when this window is displayed to determine
     * what should be drawn inside the window.  In this implementation, we're drawing
     * a face that will fill the entire canvas (leaving a bit of space for a border
     * around the face).
     * @param canvas the space to draw inside of.
     */
    public void paint(Graphics canvas) {
        // First compute the top left corner of the bounding box to draw the face inside.
        // We'll let that be at the very top-left of the canvas (0,0) but with a bit of
        // space for the border.
        int top_x = BORDER_SIZE; //=50
        int top_y = BORDER_SIZE;
		int bottomLeft_x = BORDER_SIZE ;
		int bottomLeft_y = 4 * BORDER_SIZE;
		int topRight_x = 4 * BORDER_SIZE;
		int topRight_y = BORDER_SIZE;
		int bottomRight_x = 4 * BORDER_SIZE;
		int bottomRight_y = 4 * BORDER_SIZE;
        
        // We want the face to take up the entire window, expect for some space for a border.
        // So the width should be the width of the entire canvas minus space for a border on either
        // end.  (Similarly for the height of the drawing.)
        int width = getWidth() - 2 * BORDER_SIZE;
        int height = getHeight() - 2 * BORDER_SIZE;
        
        // Draw the face.
		switch(numberOfFaces){
			case 1:
				drawFace(canvas,top_x,top_y,width,height);
				break;
			case 2:
				drawFace(canvas,top_x,top_y,width/2,height/2);
				drawFace(canvas,bottomLeft_x,bottomLeft_y,width/2,height/2);
				break;
			case 3:
				drawFace(canvas,top_x,top_y,width/2,height/2);
				drawFace(canvas,bottomLeft_x,bottomLeft_y,width/2,height/2);
				drawFace(canvas,topRight_x,topRight_y,width/2,height/2);
				break;
			case 4:
				drawFace(canvas,top_x,top_y,width/2,height/2);
				drawFace(canvas,bottomLeft_x,bottomLeft_y,width/2,height/2);
				drawFace(canvas,topRight_x,topRight_y,width/2,height/2);
				drawFace(canvas,bottomRight_x,bottomRight_y,width/2,height/2);
				break;
		}
		
    }
    
    /**
     * Create the window for this JFrame with a default size. 
     */
    public Face() {
        setSize (DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        // Create the Frame to draw the faces in.
        Face faceWindow = new Face();
        
        // Ask the user how many faces to draw.
        Object[] possibleValues = { "1", "2", "3", "4" };
        String numOfFaces = (String)JOptionPane.showInputDialog(null,
                        "How many faces should I draw?", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        possibleValues, possibleValues[0]);    
        // Set the number of faces to draw in the window.
        faceWindow.numberOfFaces = Integer.parseInt(numOfFaces);
        
        // Make the window visible.
        faceWindow.setVisible(true);
    }
}
