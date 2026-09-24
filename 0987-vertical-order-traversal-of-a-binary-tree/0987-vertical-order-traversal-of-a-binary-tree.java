/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {

    // Node ko store karne ke liye
    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // column -> row -> values
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        dfs(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();

        // Har column
        for (TreeMap<Integer, List<Integer>> rows : map.values()) {

            List<Integer> list = new ArrayList<>();

            // Har row
            for (List<Integer> values : rows.values()) {

                // Same row + same column me values
                Collections.sort(values);

                list.addAll(values);
            }

            ans.add(list);
        }

        return ans;
    }

    public void dfs(TreeNode root, int row, int col,
                    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {

        if (root == null) {
            return;
        }

        // Column nahi hai to create karo
        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }

        // Row nahi hai to create karo
        if (!map.get(col).containsKey(row)) {
            map.get(col).put(row, new ArrayList<>());
        }

        // Node ki value store karo
        map.get(col).get(row).add(root.val);

        // Left -> column - 1
        dfs(root.left, row + 1, col - 1, map);

        // Right -> column + 1
        dfs(root.right, row + 1, col + 1, map);
    }
}