package level1;

import java.util.stream.IntStream;

/**
 * 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
 * */
public class DivisorSum {
    public static void main(String[] args ){

        //n은 0 이상 3000이하인 정수
        // 나머지가 0 나오는 나누기 값을 모두 더한다
        Integer divisor = divisor(12);
        System.out.println("약수의 합"+divisor);
    }

    static Integer divisor(int num){
//        int sum = 0;
//        for(int i= 1; i <= num; i ++ ){
//
//
//            sum += (num % i == 0) ?  i : 0;
//        }

        int sum = IntStream.rangeClosed(1, num/2)
                .filter(j -> num % j == 0)
                .sum();

        return sum + num;
    }
}
