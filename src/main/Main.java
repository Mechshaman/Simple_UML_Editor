package main;

import mode.ModeController;
import objects.ObjectController;
import ui.UIController;

public class Main {
	public static void main(String[] args) {
		ObjectController objectController = new ObjectController();
		ModeController modeController = new ModeController(objectController);
		UIController uiController = new UIController(modeController, objectController);
		uiController.showUI();
    }
}
