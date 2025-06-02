class Main {
    static int candy(int[] ratings) {
        int candyCount = 0;
        int n = ratings.length;
        int[] candies = new int[n];

        for (int i = 0; i < n; i++)
            candies[i] = 1;
        
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i-1] + 1;
        
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            candyCount += candies[i - 1];
        }

        return candyCount + candies[n - 1];
    }
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int result = candy(ratings);
        System.out.println(result);
    }
}