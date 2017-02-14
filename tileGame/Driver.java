public class Driver {
    public static void main(String[] args) {
        Menu gameMenu = new Menu();
        gameMenu.getName();
        gameMenu.getDifficulty();
        gameMenu.getMode();
            
        Grid gameGrid = new Grid();
        gameGrid.makeGrid();
        gameGrid.displayGrid();
    }
}
