package level1;

import java.util.Arrays;
import java.util.OptionalDouble;

public class FindAverage {

    /**
    * 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
     * arr은 길이 1 이상, 100 이하인 배열입니다.
     * arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
    * */

    public static void main(String[] args) {

        int [] arr = new int[] {1,4,-6,-7,4};
        double answer ;
        //v1 stream은 너무 느리다 - 개당 2~3초 심하면 5초 가까이 나오는중
//        answer = Arrays.stream(arr).average().getAsDouble();

        //v2 대부분 0.03 초
        double sum = 0;
        for (int a:arr){
            System.out.println("a = " + a);
            sum += a;
            System.out.println("sum = " + sum);
        }
        answer = sum / arr.length;

        System.out.println("answer = " + answer );
    }

}
