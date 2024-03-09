package JUnitSamples;

public class Sample1 {
    public static void main(String[] args) {
        System.out.println("Value returned by getRandomString method is " + getRandomString(10));
    }
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String listOfCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * listOfCharacters.length());
            sb.append(listOfCharacters.charAt(index));
        }
        return sb.toString();
    }
}
