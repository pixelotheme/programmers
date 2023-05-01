package level1;

public class EvenAndOdd {
    public static void main(String[] args) {
        /*
        짝수와 홀수
        문제 설명
         - 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
        제한 조건
         - num은 int 범위의 정수입니다.
         - 0은 짝수입니다.
        */

        int num = 50035;
//        String answer;
//
//        int remainder;

//        if(num == 0){
//            answer = "Even";
//        }else{
//            remainder = num%2;
//            if(remainder == 0){
//                answer = "Even";
//            }else{
//                answer = "Odd";
//            }
//        }
//        EvenAndOdd evenAndOdd = new EvenAndOdd();

        System.out.println(evenOdd(num));
    }

    private static String evenOdd(int num){
        return (num % 2 == 0)? "Even" : "Odd";
    }
}
