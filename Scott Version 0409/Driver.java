

public class Driver {
		//Main Method
	//Runs game
	public static void main(String[] args) {
		StartMenu game = new StartMenu();
	}
    
	//QUICKPLAY GAMEMODE
	//Default size 3x3 grid
	public void QuickPlay() {
		QuickPlay getGrid = new QuickPlay(3);
	}
	
	//MAIN MENU
	//Move to main menu
	public void MainMenu() {
		MainMenu menu = new MainMenu();
	}
	
	//FREEPLAY MENU
	//Move to free play menu
	public void FreePlayMenu() {
		FreePlayMenu free = new FreePlayMenu();
	}
	
	//FREEPLAY GAMEMODE
	//Different size free play grids
	public void SmallFreePlay() {
		Gameplay getGrid = new FreePlay(3);
	}
	public void MediumFreePlay() {
		Gameplay getGrid = new FreePlay(4);
	}
	public void LargeFreePlay() {
		Gameplay getGrid = new FreePlay(5);
	}
	
	//TIMEPLAY MENU
	//Move to time play menu
	public void TimePlayMenu() {
		TimePlayMenu time = new TimePlayMenu();
	}
	
	//TIMEPLAY GAMEMODE
	//Different times
	public void EasyTimePlay() {
		Gameplay getGrid = new TimePlay(3);
	}
	public void MediumTimePlay() {
		Gameplay getGrid = new TimePlay(3);
	}
	public void HardTimePlay() {
		Gameplay getGrid = new TimePlay(3);
	}
	
	//START MENU
	//Move to start menu
	public void StartMenu() {
		StartMenu start = new StartMenu();
	}
}
