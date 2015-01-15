package run;
import control.GameController;
public class Launch {
	public static void main(String[] args) {
		GameController game = new GameController(1);
		game.init();
	}

}
