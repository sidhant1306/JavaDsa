package Trees;

import Trees.BinarySearchTrees.BinarySearchTree;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practice extends BinarySearchTree {
    public static BigInteger fact(int num) {
        BigInteger ans = new BigInteger("1");
        for (int i = 2; i <= num; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fact(234567));
    }
}
