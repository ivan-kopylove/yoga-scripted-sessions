package com.github.lazyf1sh.logic;

class EditDistance {

    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0, new int[word1.length()][word2.length()]);
    }

    private int dfs(String word1, String word2, int w1, int w2, int[][] dp)
    {
        if(word1.length() == w1)
        {
            return word2.length() - w2;
        }

        if(word2.length() == w2)
        {
            return word1.length() - w1;
        }

        if(dp[w1][w2] != 0)
        {
            return dp[w1][w2];
        }

        if(word1.charAt(w1) == word2.charAt(w2))
        {
            return dfs(word1, word2, w1 + 1, w2 + 1, dp);
        }

        int replace = dfs(word1, word2, w1 + 1, w2 + 1, dp);
        int delete = dfs(word1, word2, w1 + 1, w2, dp);
        int insert = dfs(word1, word2, w1, w2 + 1, dp);

        dp[w1][w2] = 1 + Math.min(Math.min(replace, delete), insert);
        return dp[w1][w2];
    }
}