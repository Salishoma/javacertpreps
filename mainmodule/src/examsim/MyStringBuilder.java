package examsim;

public class MyStringBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder a = sb.append("a");
        StringBuilder b = sb.append("b");
        System.out.println(a==b);
    }
}
