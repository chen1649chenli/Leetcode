import org.junit.Assert;
import org.junit.Test;

public class _88MergeSortedArrayTest {
    @Test
    public void testcase1(){
        _088MergeSortedArray arr = new _088MergeSortedArray();
        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{2,5,6};
        arr.merge(a, 3, b, 3);
        int[] expected = new int[]{1,2,2,3,5,6};
        Assert.assertArrayEquals(expected, a);
    }
}
