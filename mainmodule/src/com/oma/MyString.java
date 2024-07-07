package src.com.oma;

public class MyString {

    public static void main(String[] args) {
        String str = """
                This is an example
                    of a multi-line
                string with
                    inconsistent
                indentation.""";
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
