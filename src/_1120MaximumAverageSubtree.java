public class _1120MaximumAverageSubtree {
    double max = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }

    private double[] helper(TreeNode node){
        if (node == null){
            return new double[]{0, 0};
        }
        double total = node.val;
        double count = 1;
        double[] leftRes = helper(node.left);
        double[] rightRes = helper(node.right);
        total = total + leftRes[0] + rightRes[0];
        count = count + leftRes[1] + rightRes[1];
        double avg = total / count;
        if (avg > max){
            max = avg;
        }
        return new double[]{total, count};
    }
}
