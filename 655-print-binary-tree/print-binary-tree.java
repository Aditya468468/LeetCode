class Solution {
    private static class NodeInfo {
        TreeNode node;
        int r;
        int col;

        NodeInfo(TreeNode node, int r, int col) {
            this.node = node;
            this.r = r;
            this.col = col;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        int ht = height(root);
        int r = ht + 1;
        int c = (1 << (ht + 1)) - 1;
        //Construct
        for(int i=0;i<r;i++)
        {
            List<String> currentRow = new ArrayList<>(Collections.nCopies(c, ""));
            list.add(currentRow);
        }
        Queue<NodeInfo> q = new LinkedList<>();
        int rootCol = (c - 1) / 2;
        list.get(0).set(rootCol, String.valueOf(root.val));
        q.offer(new NodeInfo(root, 0, rootCol));
        int row = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                NodeInfo curr = q.poll();
                TreeNode node = curr.node;
                TreeNode left = node.left;
                TreeNode right = node.right;
                int offset = (int)Math.pow(2, ht - curr.r - 1);
                int leftPos = curr.col - offset;
                int rightPos = curr.col + offset;
                if(left != null)
                {
                    list.get(curr.r + 1).set(leftPos, String.valueOf(left.val));
                    q.offer(new NodeInfo(left, curr.r + 1, leftPos));
                }
                if(right != null)
                {
                    list.get(curr.r + 1).set(rightPos, String.valueOf(right.val));
                    q.offer(new NodeInfo(right, curr.r + 1, rightPos));
                }
            }
            row++;
        }
        return list;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}