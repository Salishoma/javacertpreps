package src.examsim.fileio;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        var al = new ArrayList<Integer>();
        al.add(2);
        printElements(al);
    }

    @SuppressWarnings("unchecked")
    static void printElements(List<Integer>... la) {
        for(List<Integer> l : la){
            System.out.println(l);
        }
    }
}