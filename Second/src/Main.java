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
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            dp[i][0] = 0;
        }
        for(int j=0;j<=n;j++)
        {
            dp[0][j] = 0;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        // finding the subsequence
        int i=m;
        int j=n;
        List<Character> char_list = new ArrayList<>();
        while(i>0 && j>0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                char_list.add(s1.charAt(i-1));
                i--;
                j--;
            }
            else
            {
                if(dp[i][j-1]>dp[i-1][j])
                {
                    j--;
                }
                else
                {
                    i--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k=char_list.size()-1;k>=0;k--)
        {
            sb.append(char_list.get(k));
        }
        return sb.toString();
    }
}
