import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var s1 = scanner.next();
        var s2 = scanner.next();

        String lcs = lcs(s1, s2);
        System.out.println("LCS is" + " " + lcs);
        System.out.println("Length of LCS is" + " " + lcs.length());
    }
    public static String lcs(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();
        if (m == 0 || n == 0)
            return "";
        ArrayList<String> s1_subsets = getSubsets(s1);
        ArrayList<String> s2_subsets = getSubsets(s2);
        int l = 0;
        String lcs = "";
        for(String x: s1_subsets){
            for(String y: s2_subsets){
                if (x.equals(y) && x.length() > l){
                    lcs = x;
                    l = lcs.length();
                }
            }
        }

        return lcs;
    }

    private static ArrayList<String> getSubsets(String s1) {
        ArrayList<String> result = new ArrayList<>();
        int allMasks = (1 << s1.length());
        for (int i = 1; i < allMasks; i++)
        {
            ArrayList<Character> newRes = new ArrayList<Character>();
            for (int j = 0; j < s1.length(); j++)
                if ((i & (1 << j)) > 0)
                    newRes.add(s1.charAt(j));
            String x = new String();
            for (char y: newRes) {
                x += y;
            }
            result.add(x);
        }
        return result;
    }
}
