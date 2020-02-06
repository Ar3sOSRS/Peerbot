package script.tasks;

import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import script.kehbaSmelter;

import static script.tasks.Traverse.SMELT_AREA;

public class searchFurnace extends Task {

    private static final String SMELT_ACTION = "Smelt";

    @Override
    public boolean validate() {
        return !Players.getLocal().isAnimating() && !Players.getLocal().isMoving();
    }

    @Override
    public int execute() {
        SceneObject furnace = SceneObjects.getNearest("Furnace");
        if(furnace !=null){
            furnace.interact(SMELT_ACTION);
            Log.fine("Furnace has been found, interacting.");
            Time.sleep(1200,1999);
        }else{
            Log.severe("Furnace not fount!");
            Movement.walkToRandomized(SMELT_AREA.getCenter());
        }
     return 1200;
    }                    
}
