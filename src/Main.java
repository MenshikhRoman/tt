import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));

    }
    public static String calc (String input) throws Exception{
        String [] roman = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI",
                "XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII",
                "XLIV","XLV","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX",
                "LX","LXI","LXII","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII",
                "LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV",
                "LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII",
                "XCVIII","XCIX","C"};
        String [] action = {"+","-","*","/"};
        int romanIndex2 = -1;
        int actionIndex = -1;
        int romanIndex0 = -1;
        int a = 0;
        int b = 0;
        String result = "0" ;
        for (int i = 0; i<action.length; i++){
            if(input.contains(action[i])){
                actionIndex = i;
                break;
            }
        }
        if (actionIndex ==-1) throw new Exception("т.к. строка не является математической операцией");

        String [] strings = input.split(" ");
        if (strings.length != 3)  throw new Exception("формат математической операции не удовлетворяет заданию - два" +
                " операнда и один оператор (+, -, /, *)");

        for (int i = 0; i<roman.length; i++) {
            if (strings[2].equals(roman[i])) {
                romanIndex2 = i;
                break;
            }
        }
        for (int i = 0; i<roman.length; i++){
            if (strings[0].equals(roman[i])){
                romanIndex0 = i;
                break;
            }
        }
        if (romanIndex2>0 && romanIndex0>0){
            a = romanIndex0;
            b = romanIndex2;
        }
        if (romanIndex2<0 && romanIndex0<0){
            a = Integer.parseInt(strings[0]);
            b = Integer.parseInt(strings[2]);
        }
        if(romanIndex2>0 && romanIndex0<0 || romanIndex2<0 && romanIndex0>0 ) throw new Exception("т.к. используются" +
                " одновременно разные системы счисления");
        if (a<1 || b<1 || a>10 || b>10) throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10" +
                " включительно");

        int res = 0;
        switch (action[actionIndex]){
            case "+":
                res = a+b;
                break;
            case "-":
                res = a-b;
                break;
            case "*":
                res = a*b;
                break;
            case "/":
                res = a/b;
                break;
        }
        if (romanIndex2>0 && romanIndex0>0){
            if (res<1) throw new Exception("т.к. в римской системе нет отрицательных чисел");
            result = roman[res];
            return result;
        }
        else
            result = String.valueOf(res);
        return result;

    }
}