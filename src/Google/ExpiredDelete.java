package Google;

import java.util.HashMap;
import java.util.Map;

public class ExpiredDelete {
    private int expiration;
    private Map<Integer, Node> map;
    private Node[] arr;

    public ExpiredDelete(int expiration) {
        this.expiration = expiration;
        map = new HashMap<>();
        arr = new Node[expiration];
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        if (System.currentTimeMillis() - node.timestamp > this.expiration) {
            map.remove(key);
            return -1;
        }
        return map.get(key).val;
    }

    public void put(int key, int val) {
        int index = (int)(System.currentTimeMillis() % this.expiration);
        if (arr[index] != null) {
            map.remove(arr[index].key);
            arr[index] = null;
        }
        arr[index] = new Node(key, val);
        map.put(key, arr[index]);
    }
}

class Node {
    int key;
    int val;
    long timestamp;

    public Node (int k, int v) {
        this.key = k;
        this.val = v;
        this.timestamp = System.currentTimeMillis();
    }
}
