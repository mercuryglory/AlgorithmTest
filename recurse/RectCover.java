package recurse;

/**
 * created by mercury on 2020-04-11
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法
 */
public class RectCover {

    /**
     * 归纳法，n=0,0种
     * n=1,1种  n=2,2种  n=3,3种
     * 分两步考虑：第一次摆放一块2*1的小矩形，方法共有f(n-1)
     * 第一次摆放一块1*2的小矩形，方法共有f(n-2),因为摆放了一块1*2的小矩阵（用√√表示），
     * 对应下方的1*2（用××表示）摆放方法就确定了
     */
    public static int rectCover(int target) {
        if (target <= 1) {
            return target;
        }
        if (target == 2) {
            return 2;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }


    public static void main(String[] args) {
        System.out.println(rectCover(4));

    }
}
