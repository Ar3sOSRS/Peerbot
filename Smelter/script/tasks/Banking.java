package script.tasks;

import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import script.kehbaSmelter;


public class Banking extends Task {
    @Override
    public boolean validate() {
        return Inventory.isFull() && Inventory.contains(kehbaSmelter.GOLD_AMULET) || Inventory.containsOnly(kehbaSmelter.OBJ_MOULD) && !kehbaSmelter.smelting;
    }

    @Override
    public int execute() {
        if (!Bank.isOpen()){
            Bank.open();
            Time.sleep(2500, 5500);
            return 100;
        }
        if (Bank.isOpen() && Inventory.contains(kehbaSmelter.GOLD_AMULET)){
            Bank.depositAllExcept(kehbaSmelter.OBJ_MOULD);
            Log.fine("Deposting Gold amulet (u)");
            Time.sleep(800, 1500);
        }
        //Bank.depositAll(kehbaSmelter.GOLD_AMULET);
        if (Bank.isOpen() && Inventory.containsOnly(kehbaSmelter.OBJ_MOULD)){
            Bank.withdrawAll(kehbaSmelter.GOLD_BAR);
            Log.fine("Withdrawing Gold Bars");
            Time.sleep(3000, 5500);
        }Bank.close();
        return 1000;
    }
}
