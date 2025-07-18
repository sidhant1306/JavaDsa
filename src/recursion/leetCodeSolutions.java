import java.util.ArrayList;
import java.util.List;

public class leetCodeSolutions {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String up = "";
        if(up.isEmpty()){
            System.out.println(ans);
        }else{
            phone("", up, ans);
            System.out.println(ans);
        }

    }

    // QUE 17. LETTER COMBINATIONS OF A PHONE NUMBER :
    public static void phone(String p, String up, List<String> result){
        if(up.isEmpty()){
            result.add(p);
            return;
        }

        char digit = up.charAt(0);

        int start = 0;
        int nChars = 3;

        if(digit == '7'){
            start = 'p';
            nChars = 4;
        }

        else if(digit == '8'){
            start = 't';
            nChars = 3;
        }
        else if(digit == '9'){
            start = 'w';
            nChars = 4;
        }

        else{
            start = 'a' + (digit - '2') * 3;
        }

        for (int i = 0 ; i < nChars; i++) {
            char ch = (char)(start + i);

            phone(p + ch, up.substring(1), result);
        }
    }
}
