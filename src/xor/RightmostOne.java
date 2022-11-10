package xor;

/**
 * @author nanmian
 * 提取整形数的二进制最右侧的1
 */
public class RightmostOne {

    public static void main(String[] args) {
        System.out.println(findRightMostOne(5));
    }

    // num != 0
    // num最右侧的1，提取出来
    // num :      00110010110111000
    // rightOne : 00000000000001000
    public static int findRightMostOne(int num) {
        int result;

        // num :      00110010110111000
        // ~num :     11001101001000111
        // ~num + 1 : 11001101001001000     ~num + 1 = -num
        // num & ((~num) +1) : 00000000000001000
        result = num & ((~num) +1);

        return result;
    }

}
