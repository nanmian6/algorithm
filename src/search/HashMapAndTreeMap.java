package search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author nanmian
 */
public class HashMapAndTreeMap {

    public static class Node {
        public int value;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("nanmian", "我是难眠");
        System.out.println(map.containsKey("nanmian"));
        System.out.println(map.containsKey("nan"));
        System.out.println(map.get("nanmian"));
        System.out.println("=======================");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1234567, "我是1234567");

        Integer a = 1234567;
        Integer b = 1234567;

        System.out.println(a.equals(b));
        System.out.println(map2.containsKey(a));
        System.out.println(map2.containsKey(b));


        System.out.println("===================");

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();

        treeMap1.put(3, "我是3");
        treeMap1.put(0, "我是3");
        treeMap1.put(7, "我是3");
        treeMap1.put(2, "我是3");
        treeMap1.put(5, "我是3");
        treeMap1.put(9, "我是3");

        System.out.println(treeMap1.containsKey(7));
        System.out.println(treeMap1.containsKey(6));
        System.out.println(treeMap1.get(3));

        treeMap1.put(3, "他是3");
        System.out.println(treeMap1.get(3));

        treeMap1.remove(3);
        System.out.println(treeMap1.get(3));

        System.out.println(treeMap1.firstKey());
        System.out.println(treeMap1.lastKey());
        // <=5 离5最近的key告诉我
        System.out.println(treeMap1.floorKey(5));
        // <=6 离6最近的key告诉我
        System.out.println(treeMap1.floorKey(6));
        // >=5 离5最近的key告诉我
        System.out.println(treeMap1.ceilingKey(5));
        // >=6 离6最近的key告诉我
        System.out.println(treeMap1.ceilingKey(6));

//        Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		TreeMap<Node, String> treeMap2 = new TreeMap<>();
//		treeMap2.put(node3, "我是node3");
//		treeMap2.put(node4, "我是node4");
    }

}
