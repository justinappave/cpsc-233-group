import java.util.Scanner;

/**
 * Draw a Triangle (sideways) using asterix with the height
 * specified by the user.  The program assumes the user enters
 * and integer greater than 0.  No validation of input is done.
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter triangle size: ");
        // Get triangle size from user.
        int triangleSize = keyboard.nextInt();
        
        int numToDraw = 1;
        // Outer loop controls the lines to draw.
        for (numToDraw = 1; numToDraw <= triangleSize; numToDraw++) {
            // inner loop draws a single line of asterix, so it controls
            // characters on each line.
            for (int counter = 0; counter < numToDraw; counter++) {
                System.out.print('*');
            }
            // put a newline after the required number of asterix for the line
            System.out.println();
        }
        
        // Reached the peak of the triangle.  Now work downwards.
        for (numToDraw = numToDraw - 2; numToDraw > 0; numToDraw--) {
            for (int counter = 0; counter < numToDraw; counter++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}