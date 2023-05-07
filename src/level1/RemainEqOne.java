package level1;

import java.util.stream.IntStream;

public class RemainEqOne {


    /**
     * 자연수 n이 매개변수로 주어집니다.
     * n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
     * 답이 항상 존재함은 증명될 수 있습니다.
     * */
    public static void main(String[] args){
        //큰 수부터 찾고 해당 숫자의 최소 공배수
        // 51 -> 50 이 처음 -> 5 로 나누면 나머지 1
        // 50 나누기 1~...2.3.4.5....나머지 0 인 첫 숫자
        int n = 94759205;
        int divide;
        int answer = 0;

        RemainEqOne remainEqOne = new RemainEqOne();
        System.out.println(n % 2);
        //v2
//        for(int a = 2; a < n; a++){
//            if(n % a == 1){
//                answer = a;
//                break;
//            }
//        }

        //v3
        answer = IntStream.rangeClosed(2, n)
                .filter(i -> n % i == 1)
                .findFirst()
                .orElse(0);

        //v1
//        for(int i = 1; i >0; i++){
//            //나머지가 1 인 가장 작은 자연수 리턴
//            divide = n-i;
//             if (n%divide == 1){
//                 answer = remainEqOne.remain(divide);
//                 if(answer != 0){
//                     break;
//                 }
//             }
//        }
        System.out.println("answer = " + answer);
    }

    public int remain(int divide){

        for(int j = 2; j <= divide; j ++){
            if(divide % j == 0){
                return j;
            }
        }
        return 0;
    }
}
