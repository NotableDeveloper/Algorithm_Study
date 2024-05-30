package Other.dfs_bfs;

import java.util.ArrayList;
import java.util.List;
/*
    여섯 자리 형식의 전화번호 체계에서 희망하는 전화번호와
    이미 사용중인 전화번호를 입력 받아서 사용 가능한 전화번호 반환하기.

    전화 한 자리는 0 ~ 9가 올 수 있고, X는 와일드카드.
*/
public class TelephoneNumber {

    public static String[] solution(String hopeNumber, String[] existsNumbers) {
        List<String> possiblePhoneNumbers = new ArrayList<>();
        List<String> existsPhoneNumbers = new ArrayList<>();
        generateDigit(hopeNumber, 0, new StringBuilder(), possiblePhoneNumbers);

        for(String existsNumber : existsNumbers){
            generateDigit(existsNumber, 0, new StringBuilder(), existsPhoneNumbers);
        }

        /*
		    사용 가능한 번호 목록에서 이미 있는 번호 목록을 지움.
        */
        existsPhoneNumbers.forEach(possiblePhoneNumbers::remove);

        if(possiblePhoneNumbers.isEmpty()){
            return new String[]{"-1"};
        }

        return possiblePhoneNumbers.toArray(new String[0]);
    }

    /*
        StringBuilder currentNumber : 와일드카드 X를 고려하여 번호를 임시적으로 만들어두는 공간
        List<String> phoneNumber : 만들어진 여섯 자리의 번호를 영구적으로 저장하는 공간
    */
    private static void generateDigit(String hopeNumber, int index, StringBuilder currentNumber, List<String> phoneNumbers) {
        /*
            6번째 자리까지 탐색하면 종료
        */
        if (index == hopeNumber.length()) {
            phoneNumbers.add(currentNumber.toString());
            return;
        }
        
        char currentChar = hopeNumber.charAt(index);

        /*
            index번째 자리에서 X를 발견하면 다음 자리로 재귀호출
        */
        if (currentChar == 'X') {
            for (char digit = '0'; digit <= '9'; digit++) {
                currentNumber.append(digit);
                generateDigit(hopeNumber, index + 1, currentNumber, phoneNumbers);
                /*
                    다음에 넣을 숫자를 위해 현재 StringBuilder에 넣은 숫자를 지움.
                */
                currentNumber.deleteCharAt(currentNumber.length() - 1);
            }
        } else {
            currentNumber.append(currentChar);
            generateDigit(hopeNumber, index + 1, currentNumber, phoneNumbers);
            currentNumber.deleteCharAt(currentNumber.length() - 1);
        }
    }

    public static void main(String[] args) {
        String hopeNumber = "123-12X";
        String[] existsNumbers = {"123-123"};

        String[] possiblePhoneNumbers = solution(hopeNumber, existsNumbers);

        for (String phoneNumber : possiblePhoneNumbers) {
            System.out.println(phoneNumber);
        }
    }
}

