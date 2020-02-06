package script.tasks;

import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import script.kehbaSmelter;

import static script.tasks.Traverse.SMELT_AREA;

public class searchFurnace extends Task {

    public final int PARENT_INDEX = 446;
    public final int CHILD_INDEX = 34;
    public final String ACTION = "Make Gold amulet (u)";

    public InterfaceComponent makeAmulet = Interfaces.getComponent(PARENT_INDEX, CHILD_INDEX);
    private static final String SMELT_ACTION = "Smelt";

    @Override
    public boolean validate() {
        //return !Players.getLocal().isAnimating() && !Players.getLocal().isMoving();
        return SMELT_AREA.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Player Local = Players.getLocal();
        SceneObject furnace = SceneObjects.getNearest("Furnace");
            Log.fine("Furnace has been found, interacting.");
            furnace.interact("Smelt");
            Time.sleep(5000,6000);
            if (makeAmulet != null){
                makeAmulet.interact(ACTION);
            }
            Log.fine("Smelting Necklace");
            Time.sleepUntil( () -> makeAmulet.getEnabledMaterialId() != -1, 30000,42000);
            return 1200;
            }
        //}else{
            //Log.severe("Furnace not fount!");
            //Movement.walkToRandomized(SMELT_AREA.getCenter());
        //if(makeAmulet != null){
           // makeAmulet.interact(ACTION);
            //Log.fine("Interacting With Jewelz");
           // Time.sleepUntil( () -> makeAmulet.getMaterialId() != -1, 30000,42000);
       // }
}
