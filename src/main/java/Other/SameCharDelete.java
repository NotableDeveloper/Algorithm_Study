package Other;

/*
    browoanoommnaon

    1. "browoanoommnaon"
    2. "browoanmmnaon"
    3. "browoannaon"
    4. "browoaaon"
    5. "browoon"
    6. "brown"

    zyelleyz

    1. "zyelleyz"
    2. "zyeeyz"
    3. "zyyz"
    4. "zz"
    5. ""
*/
public class SameCharDelete {
    static void DFS(String cipherText, StringBuilder sb){
        for(int i = 0; i < cipherText.length(); i++){
            int next = i + 1;
            if(next <= cipherText.length() - 1 &&
                    cipherText.charAt(i) == cipherText.charAt(next)){

                sb.delete(0, sb.length());

                String encodingText = cipherText.substring(0, i)
                        + cipherText.substring(next + 1, cipherText.length());

                sb.append(encodingText);

                DFS(encodingText, sb);
            }
        }
    }

    public static void main(String[] args) {
        String ciperText = "browoanoommnaon";
        StringBuilder sb = new StringBuilder();
        DFS(ciperText, sb);
        System.out.println(sb);
    }
}
