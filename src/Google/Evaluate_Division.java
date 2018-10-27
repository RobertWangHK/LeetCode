package Google;

import java.util.HashMap;
import java.util.Map;

public class Evaluate_Division {
    Map<String, String> parents;
    Map<String, Double> vals;

    public Evaluate_Division() {
        this.parents = new HashMap<>();
        this.vals = new HashMap<>();
    }

    public boolean insert(String[] equation, double val) {
        String a = equation[0];
        String b = equation[1];
        if (!parents.containsKey(a)) {
            parents.put(a, a);
            vals.put(a, 1.0);
        }
        if (!parents.containsKey(b)) {
            parents.put(b, b);
            vals.put(b, 1.0);
        }
        String p1 = root(parents, a);
        String p2 = root(parents, b);
        double v1 = distanceToRoot(vals, parents, a);
        double v2 = distanceToRoot(vals, parents, b);
        parents.put(p1, p2);
        vals.put(p1, v2 / v1 * val);
        return true;
    }

    public double query(String[] query) {
        String a = query[0];
        String b = query[1];
        if (!parents.containsKey(a) || !parents.containsKey(b) || !parents.get(a).equals(parents.get(b))) {
            return -1.0;
        }
        return distanceToRoot(vals, parents, a) / distanceToRoot(vals, parents, b);
    }

    private String root(Map<String, String> parents, String s) {
        while (!s.equals(parents.get(s))) {
            s = parents.get(s);
        }
        return s;
    }

    private double distanceToRoot(Map<String, Double> vals, Map<String, String> parents, String s) {
        double ret = 1.0;
        while (!s.equals(parents.get(s))) {
            ret *= vals.get(s);
            s = parents.get(s);
        }
        return ret;
    }
}
