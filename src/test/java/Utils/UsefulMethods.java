package Utils;

public class UsefulMethods {
    public static String getRandomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        String listOfCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random()*listOfCharacters.length());
            sb.append(listOfCharacters.charAt(index));
        }
        return sb.toString();
    }
}
