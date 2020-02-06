package script.tasks;

import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;
import org.rspeer.script.task.TaskScript;
import script.kehbaSmelter;

public class smeltFurnace extends Task {

    final int PARENT_INDEX = 446;
    final int CHILD_INDEX = 34;
    final String ACTION = "Make Gold amulet (u)";

    InterfaceComponent makeAmulet = Interfaces.getComponent(PARENT_INDEX, CHILD_INDEX);

    @Override
    public boolean validate() {
        return Inventory.contains(kehbaSmelter.GOLD_BAR, kehbaSmelter.OBJ_MOULD) && makeAmulet.isVisible();
    }

    @Override
    public int execute() {
        if(makeAmulet != null & makeAmulet.interact(ACTION)){
            Time.sleepUntil( () -> makeAmulet.getMaterialId() != -1, 2000, 3000);
        }
        return 1000;
    }
}
