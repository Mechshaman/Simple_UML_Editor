package mode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.ObjectController;

public class ModeController {
	
	private List<BaseMode> modeList;
	private Map<String, Integer> modeListMap;
	
	private ObjectController objectController;
	
	
	private BaseMode currentMode;
	
	public ModeController(ObjectController objectController) {
		this.objectController = objectController;
		
		initModeList();
		initModeListMap();
		
		currentMode = modeList.get(modeListMap.get("SelectMode"));
	}
	
	public void initModeList() {
		modeList = new ArrayList<BaseMode>();
		modeList.add(new SelectMode(this.objectController));
		modeList.add(new AssociationMode(this.objectController));
		modeList.add(new GeneralizationMode(this.objectController));
		modeList.add(new CompositionMode(this.objectController));
		modeList.add(new ClassMode(this.objectController));
		modeList.add(new UseCaseMode(this.objectController));
	}
	
	public void initModeListMap() {
		modeListMap = new HashMap<>();
		modeListMap.put("SelectMode", 0);
		modeListMap.put("AssociationMode", 1);
		modeListMap.put("GeneralizationMode", 2);
		modeListMap.put("CompositionMode", 3);
		modeListMap.put("ClassMode", 4);
		modeListMap.put("UseCaseMode", 5);
	}
	
	public void setMode(String mode) {
		assert modeListMap.containsKey(mode);
		currentMode = modeList.get(modeListMap.get(mode));
	}
	
	public BaseMode getCurrentMode() {
		return currentMode;
	}
	
}
