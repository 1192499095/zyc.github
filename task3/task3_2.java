package task3;
import java.util.*;
public class task3_2 {
    public static boolean checkEmail(String email){
        if(email.matches("[a-z0-9A-Z]+@[a-z0-9A-Z]+\\.[a-z0-9A-Z]+")){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            String s = input.nextLine();
            System.out.println(checkEmail(s));
        }
    }
}
