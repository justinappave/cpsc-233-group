package tilePuzzle;

public class Driver {
	
	public void QuickPlay() {
		Grid getGrid = new Grid();
		getGrid.SmallGrid();
	}
	public void MainMenu() {
		MainMenu menu = new MainMenu();
	}
	public void FreePlayMenu() {
		FreePlayMenu free = new FreePlayMenu();
	}
	public void SmallPlay() {
		Grid getGrid = new Grid();
		getGrid.SmallGrid();
	}
	public void MediumPlay() {
		Grid getGrid = new Grid();
		getGrid.MediumGrid();
	}
	public void LargePlay() {
		Grid getGrid = new Grid();
		getGrid.LargeGrid();
	}
	public void TimePlayMenu() {
		TimePlayMenu time = new TimePlayMenu();
	}
	public void TimePlay() {
		Grid  getGrid = new Grid();
		getGrid.SmallGrid();
	}
	public void StartMenu() {
		StartMenu start = new StartMenu();
	}
	public static void main(String[] args) {
		StartMenu game = new StartMenu();
	}
}
