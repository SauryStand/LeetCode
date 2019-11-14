package algorithm.jianzhioffer;

/**
 * @program: leetcode
 * @description:
 *
 * Input:
 * "A B"
 *
 * Output:
 * "A%20B"
 * @author: voyager2511
 * @create: 2019-11-06 20:43
 **/
public class ReplaceBlank {

    public String replceBlank(StringBuffer stringBuffer){
        int sbLength = stringBuffer.length() - 1;
        for (int i = 0; i < sbLength; i++) {
            if (stringBuffer.charAt(i) == ' ') {
                stringBuffer.append(" ");
            }
        }

        int sbNewLength = stringBuffer.length() - 1;
        while (sbLength >= 0 && sbNewLength > sbLength) {
            char c = stringBuffer.charAt(sbLength--);
            if (c == ' '){
                stringBuffer.setCharAt(sbNewLength--, '%');
                stringBuffer.setCharAt(sbNewLength--, '2');
                stringBuffer.setCharAt(sbNewLength--, '0');
            } else {
                stringBuffer.setCharAt(sbNewLength--, c);
            }
        }

        return stringBuffer.toString();
    }

}
