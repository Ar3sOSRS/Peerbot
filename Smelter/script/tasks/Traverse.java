package script.tasks;

import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;

public class Traverse extends Task {
    public static final Area SMELT_AREA = Area.rectangular(3279, 3184, 3272, 3188);

    @Override
    public boolean validate() {
        return !SMELT_AREA.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Log.fine("Walking to Furnace");
        Movement.walkToRandomized(SMELT_AREA.getCenter());
        return 1000;
    }
}
