package ui;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import mode.ModeController;
import objects.ObjectController;

public class UIController {
	
	private MainFrame frame;
	private MenuBar menuBar;
	private ModeOptionsPanel modeOptionsPanel;
	private Canvas canvas;
	
	private ModeController modeController;
	private ObjectController objectController;
	
	public UIController(ModeController modeController, ObjectController objectController) {
		
		this.modeController = modeController;
		this.objectController = objectController;
		
		frame = new MainFrame();
		modeOptionsPanel = new ModeOptionsPanel(createModeOptionButtons());
		canvas = new Canvas(this.modeController, this.objectController);
		menuBar = new MenuBar(createMenuOptions());
	    frame.add(menuBar);
	    frame.add(modeOptionsPanel);
	    frame.add(canvas);
	}
	
	public void showUI() {
	    frame.setVisible(true);
	}
	
	private List<ModeOptionButton> createModeOptionButtons() {
		List<ModeOptionButton> modeOptionButtons = new ArrayList<ModeOptionButton>();
		modeOptionButtons.add(new ModeOptionButton(new Point(10,0), "select.png", modeController, "SelectMode"));
		modeOptionButtons.add(new ModeOptionButton(new Point(10,122), "association.png", modeController, "AssociationMode"));
		modeOptionButtons.add(new ModeOptionButton(new Point(10,244), "generalization.png", modeController, "GeneralizationMode"));
		modeOptionButtons.add(new ModeOptionButton(new Point(10,366), "composition.png", modeController, "CompositionMode"));
		modeOptionButtons.add(new ModeOptionButton(new Point(10,478), "class.png", modeController, "ClassMode"));
		modeOptionButtons.add(new ModeOptionButton(new Point(10,600), "usecase.png", modeController, "UseCaseMode"));
		return modeOptionButtons;
	}
	
	private List<MenuOption> createMenuOptions() {
		List<MenuOption> fileOptionItems = new ArrayList<MenuOption>();
		fileOptionItems.add(new MenuOption("File", createFileOptionItems()));
		fileOptionItems.add(new MenuOption("Edit", createEditOptionItems()));
		return fileOptionItems;
	}
	
	private List<MenuItem> createFileOptionItems() {
		List<MenuItem> fileOptionItems = new ArrayList<MenuItem>();
		return fileOptionItems;
	}
	
	private List<MenuItem> createEditOptionItems() {
		List<MenuItem> editOptionItems = new ArrayList<MenuItem>();
		editOptionItems.add(new MenuItem("rename", new RenameActionListener(objectController, canvas)));
		editOptionItems.add(new MenuItem("group", new GroupActionListener(objectController, canvas)));
		editOptionItems.add(new MenuItem("ungroup", new UnGroupActionListener(objectController, canvas)));
		return editOptionItems;
	}
	
}
