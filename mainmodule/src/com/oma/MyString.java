package src.com.oma;

public class MyString {

    public static void main(String[] args) {
        String str = """
                This is an example
                    of a multi-line
                string with
                    inconsistent
                indentation.""";

        int length = "This is an example".length();
        int length1 = "    of a multi-line".length();
        int length2 = "string with".length();
        int length3 = "    inconsistent".length();
        int length4 = " indentation.".length();

        System.out.println("Space length: " + "        ".length());
        System.out.println("Length: " + (length + length1 + length2 + length3 + length4));
        System.out.println("Length: " + str.length());
        myStripIndent(str);

        String input
                = "GeeksforGeeks\nA Computer Science portal for geeks.";
        myIndent(input, 5);
    }
    private static void myStripIndent(String str) {
        String s = str.stripIndent();
        System.out.println(s);
    }

    private static void myIndent(String str, int n) {
        String indent = str.indent(n);
        System.out.println(indent);
    }
}
