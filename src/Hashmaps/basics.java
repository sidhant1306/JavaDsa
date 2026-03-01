package Hashmaps;

import java.util.HashMap;
import java.util.HashSet;

public class basics {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Sidhant", 99);
        map.put("Gellii", 98);
        map.put("moglu", 50);
        map.put("satyam", 40);

        System.out.println(map.get("Gellii"));
        System.out.println(map.getOrDefault("Vaibhav", 0));     // either print the key's value or the default you provide if the key doesn't exist.
        System.out.println(map.containsKey("moglu"));   // true, yes it contains the key named moglu.


        HashSet<Integer> set = new HashSet<>();

        set.add(283);
        set.add(34);
        set.add(283);
        set.add(77);
        set.add(34);
        set.add(77);
        System.out.println(set);
    }
}
