package as.test.as1.peergrade1;

public class RomanNumeralsConverter {

    public String convertIntToRomanNumeralString(int inputInteger){
        if(inputInteger < 0 || inputInteger > 5000){
            throw new IllegalArgumentException("Value needs to be between 0 and 5000");
        }
        StringBuilder sb = new StringBuilder();

        int thousand = inputInteger / 1000;
        for (int i = thousand; thousand > 0; thousand--){
            sb.append("M");
        }
        int hundred = (inputInteger % 1000) / 100;
        if(hundred == 9){
            hundred -= 9;
            sb.append("CM");
        }else if(hundred >= 5) {
            hundred -= 5;
            sb.append("D");
        }else if(hundred == 4){
            hundred -= 4;
            sb.append("CD");
        }
        for (int i = hundred; hundred > 0; hundred--){
            sb.append("C");
        }

        int tens = (inputInteger % 100) / 10 ;
        if(tens == 9){
            tens -= 9;
            sb.append("XC");
        }else if(tens >= 5) {
            tens -= 5;
            sb.append("L");
        }else if(tens == 4){
            tens -= 4;
            sb.append("XL");
        }
        for (int i = tens; tens > 0; tens--){
            sb.append("X");
        }

        int ones = inputInteger % 10 ;
        if(ones == 9){
            ones -= 9;
            sb.append("IX");
        }else if(ones >= 5) {
            ones -= 5;
            sb.append("V");
        }else if(ones == 4){
            ones -= 4;
            sb.append("IV");
        }
        for (int i = ones; ones > 0; ones--){
            sb.append("I");
        }


    return sb.toString();
    }
}
