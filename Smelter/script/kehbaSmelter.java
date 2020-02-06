package script;

import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.TaskScript;
import org.rspeer.ui.Log;
import script.tasks.Banking;
import script.tasks.searchFurnace;
import script.tasks.Traverse;
import script.tasks.smeltFurnace;

@ScriptMeta(name = "Script Name",  desc = "Script description", developer = "Developer's Name")
public class kehbaSmelter extends TaskScript {

    public static boolean smelting = false;
    public static final String GOLD_AMULET = "Gold amulet (u)";
    public static final String OBJ_FURNACE = "Furnace";
    public static final String GOLD_BAR = "Gold bar";
    public static final String OBJ_MOULD = "Amulet mould";

    @Override
    public void onStart() {
        Log.fine("Script Started!");
        submit(new Banking(), new Traverse(), new searchFurnace());
    }

    @Override
    public void onStop() {
        Log.severe("Script Started!");
    }

}