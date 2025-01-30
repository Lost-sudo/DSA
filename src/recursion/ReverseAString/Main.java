package recursion.ReverseAString;

public class Main {
    public static void main(String[] args) {
        Main newMain = new Main();

        // Testing the reverse method with the string "Java"
        System.out.println(newMain.reverse("Java")); // Output: "avaJ"
    }

    /**
     * A recursive method to reverse a given string.
     *
     * @param str The input string to be reversed.
     * @return The reversed string.
     */
    public String reverse(String str) {
        // Base case: If the string is null or has one or zero characters, return the string as is
        if ((str == null) || (str.length() <= 1)) {
            return str;
        }

        // Recursive case: Reverse the substring excluding the first character and append the first character
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
