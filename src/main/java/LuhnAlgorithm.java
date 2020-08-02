import java.util.Scanner;
import java.lang.Character;
/** @author Marina **/

public class LuhnAlgorithm {
    public static  int expectedDigit;
    public static int providedDigit;
    public static int total = 0;
    //76578998765501  (A valid number but not 16 digits)
    //2347669084563287 (A valid number with 16 digits)
    //2347669084563288 (Not valid number)

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");

        /*Using the trim method in case the user inter number with extra whitespaces in
        the beginning or the end of the String*/
        String userInput = scanner.nextLine().trim();

        //Get the last character(number) of the String
        providedDigit = Integer.parseInt(userInput.substring(userInput.length() - 1));

        boolean isValidNumber =validatCreditNumber(userInput, providedDigit);
        boolean isValidLength = validateLength(userInput);

        if (checkNumeric(userInput)) {
            System.out.println("User input: " + userInput.substring(0, userInput.length() - 1) + " " + providedDigit);
            System.out.println("Provided: " + providedDigit);
            System.out.println("Expected: " + expectedDigit);
            if(isValidNumber){
                System.out.println("Checksum: Valid "  );
            }else {
                System.out.println("Checksum: Not Valid "  );
            }
            if(isValidLength){
                System.out.println("Digits: " + userInput.length() + " " + "( Credit card )");
            }else {
                System.out.println("Digits: " + userInput.length() + " " + "( Not credit card! A credit card has 16 digits )");
            }
        }


    }

    public static boolean validatCreditNumber(String input, int providedDigit){

        int[] inputToInt = new int[input.length()];

        for (int i = 0; i < input.length(); i++){
            inputToInt[i] = Integer.parseInt(input.substring(i, i+1));
        }

        //Start the loop from the right and double each other digit
        for (int i = inputToInt.length - 2; i >= 0; i = i - 2){
            int currentValue = inputToInt[i];
            currentValue = currentValue * 2;

            if (currentValue > 9){
                currentValue = currentValue % 10 + 1;
            }

            inputToInt[i] = currentValue;
        }

       //Add each element of the array together to get a so that we can get one big number
        for(int i = 0; i < inputToInt.length -1 ; i++){
            total += inputToInt[i];
        }

      // To check the check digit I use a variable(expectedDigit) that equals the equation to get the luhn algorithm
      expectedDigit =(total * 9) % 10;

      if (expectedDigit == (total * 9) % 10){

          return providedDigit == expectedDigit;
        }
        else {
            return false;
        }
    }

    public static boolean checkNumeric(String input){

            for (char character : input.toCharArray())
            {
                try {

                    if (!Character.isDigit(character)) {
                        System.out.println("Only numbers allowed !");
                        return false;
                    }
                }catch (NumberFormatException e){
                    return false;
                }
            }
            return true;
    }

    public static boolean validateLength(String input) {
        if(input.length() == 16 ){
          return true;
        }else if (input.length() < 16 ){
           return false;

        }else {
            return false;

        }
    }

}
