package BimsS;
import java.util.*;

public class State {
    public static HashMap<String,Integer> varTable;
    State() {
        varTable = new HashMap<String,Integer>();
    }

    // for int Vars
    public static boolean exists(String id) {
        if (varTable.get(id) == null) { return false; };
        return true;
    }

    public static int lookup(String id) {
        return varTable.get(id);
    }

    public static void update(String id, Integer v) {
        varTable.put(id,v);
    }
    }
