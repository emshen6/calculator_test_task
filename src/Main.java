import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> arabicNums = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        ArrayList<String> romanNums = new ArrayList<>(Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));
        ArrayList<String> operands = new ArrayList<>(Arrays.asList("-", "+", "*", "/"));
        String[] components = scan.nextLine().split(" ");
        if (components.length != 3) throw new Exception();
        int x, y, result;
        boolean isRoman = false;
        if (romanNums.contains(components[0])){
            x = romanNums.indexOf(components[0]);
            isRoman = true;
        }
        else if (arabicNums.contains(components[0])) x = arabicNums.indexOf(components[0]);
        else throw new Exception();

        if (romanNums.contains(components[2])){
            if (!isRoman) throw new Exception();
            y = romanNums.indexOf(components[2]);
        }
        else if (arabicNums.contains(components[2])){
            if (isRoman) throw new Exception();
            y = arabicNums.indexOf(components[2]);
        }
        else throw new Exception();

        result = switch (components[1]) {
            case "-" -> Calculator.subtract(x, y);
            case "+" -> Calculator.add(x, y);
            case "/" -> Calculator.divide(x, y);
            case "*" -> Calculator.multiply(x, y);
            default -> throw new Exception();
        };

        if (isRoman && (result < 0)) throw new Exception();

        if (isRoman) System.out.println(RomanArabicConverter.toRoman(result));
        else System.out.println(result);
    }
}
