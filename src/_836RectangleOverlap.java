public class _836RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], x2 = rec1[2], x3 = rec2[0], x4 = rec2[2];
        int y1 = rec1[1], y2 = rec1[3], y3 = rec2[1], y4 = rec2[3];
        boolean xNotOverlap = (x2 <= x3) || (x4 <= x1);
        boolean yNotOverlap = (y2 <= y3) || (y4 <= y1);
        return !(xNotOverlap || yNotOverlap);
    }
}
