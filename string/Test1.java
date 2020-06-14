package string;

/**
 * created by mercury on 2020-06-14
 *
 * 逆序输出字符串，要求仍然是完整的语句，符合大小写规范，比如：
 *
 * 输入：This is a cat!
 * 输出：Cat a is this!
 */
public class Test1 {

    public static String reverseSentence(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        String content = input.toLowerCase();
        char[] arr = content.toCharArray();

        StringBuffer sb = new StringBuffer();
        StringBuffer word = new StringBuffer();
        String end = "";


        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            if (c != ' ') {
                if (i == 0) {
                    word.append(c);
                    word.reverse();
                    sb.append(word);
                } else if (i == arr.length - 1 && !Character.isLetter(c)) {
                    end = String.valueOf(c);
                } else {
                    word.append(c);
                }
            } else {
                word.reverse();
                sb.append(word).append(' ');
                word.delete(0, word.length());
            }
        }
        sb.append(end);

        return sb.substring(0, 1).toUpperCase().concat(sb.substring(1, sb.length()));
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("This is a cat!"));
    }

}
