package script.tasks;

import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.Scene;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;
import org.rspeer.script.task.TaskScript;
import org.rspeer.ui.Log;
import script.kehbaSmelter;

import static script.tasks.Traverse.SMELT_AREA;

public class smeltFurnace extends Task {

    SceneObject furnace = SceneObjects.getNearest("Furnace");

    public final int PARENT_INDEX = 446;
    public final int CHILD_INDEX = 34;
    public final String ACTION = "Make Gold amulet (u)";

    public InterfaceComponent makeAmulet = Interfaces.getComponent(PARENT_INDEX, CHILD_INDEX);

    @Override
    public boolean validate() {
        //return makeAmulet.containsAction(ACTION);
        return !SMELT_AREA.contains(furnace);

    }

    @Override
    public int execute() {
        if(makeAmulet != null){  // & makeAmulet.interact(ACTION)){
            makeAmulet.interact(ACTION);
            Log.fine("Smelting screen is active");
            Time.sleepUntil( () -> makeAmulet.getMaterialId() != -1, 30000, 45000);
        }
        return 1000;
    }
}
