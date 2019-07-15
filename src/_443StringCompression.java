public class _443StringCompression {
    public int compress(char[] chars) {
        if (chars == null) return 0;

        int ansIdx = 0, index = 0;
        while (index < chars.length){
            char curr = chars[index];
            chars[ansIdx++] = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == curr){
                index += 1;
                count += 1;
            }
            if (count > 1){
                for (char c : Integer.toString(count).toCharArray()){
                    chars[ansIdx++] = c;
                }
            }

        }
        return ansIdx;
    }
}
