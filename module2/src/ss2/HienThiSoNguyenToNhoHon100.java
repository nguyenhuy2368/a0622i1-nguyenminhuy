package ss2;

public class HienThiSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        for (int N = 2; N < 100; N++) {
            boolean check = true;
            for (int i=2;i<=Math.sqrt(N);i++ ){
                if (N%i==0){
                    check= false;
                    break;
                }
            }
            if (check){
                System.out.println(N);
            }
        }
    }
}
