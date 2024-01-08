public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        
    }

    public static String capVowelsLowRest (String string) {
        String str = "";
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (vowels.indexOf(currentChar) != -1) {
                str += (char) (currentChar - 'a' + 'A');
            } else {
                str += (char) (currentChar + 'a' - 'A');
            }
        }

        return str;
    }

    public static String camelCase(String string) {
        string = lowercase(string);

        if (string.length() == 1) {
            return lowercase(string);
        }

        String newStr = "";
        boolean first = true;

        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) != ' ') {
                int end = i + 1;

                if (end < string.length()) {
                    while (end < string.length() && string.charAt(end) != ' ') {
                        end++;
                        if (end == string.length()) {
                            break;
                        }
                    }

                    if (first) {
                        newStr += string.substring(i, end);
                        first = false;
                    } else {
                        newStr += capFirst(string.substring(i, end));
                    }

                    i = end - 1; // Adjusting the index to the end of the current word
                }
            }
        }

        return newStr;
    }


    public static int[] allIndexOf (String string, char chr) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                counter++;
            }
        }
        int[] times = new int[counter];
        int index = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                times[index++] = i;
            }
        }
        return times;
    }


public static String lowercase(String string) {
        String str = "";
        for(int i = 0; i < string.length(); i++){
            char ch = string.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ch += 32;
                str += (char)ch;
            }else{
                str += (char)ch;
            }
        }
        return str;
    }

    public static String capFirst(String string) {
        String newSt = "";
        if (!(string.charAt(0) >= 'A' && string.charAt(0) <= 'Z')) {
            newSt += (char) (string.charAt(0) - 32) + string.substring(1);
        }
        return newSt;
    }
}