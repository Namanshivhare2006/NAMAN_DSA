// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int num=image[sr][sc];
//         if(image[sr][sc]==color){
//             return image;
//         }
//         func(image,sr,sc,color,num);
//         return image;
        
//     }
//     public static void func(int[][] img,int i,int j,int color,int num){
//         if(i<0 || j<0 || i>=img.length || j>=img[0].length || img[i][j]!=num){
//             return;
//         }
//         img[i][j]=color;
//         func(img,i+1,j,color,num);
//         func(img,i-1,j,color,num);
//         func(img,i,j-1,color,num);
//         func(img,i,j+1,color,num);


//     }
// }
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // clone image grid
        int[][] result = image;
        int oldColor = result[sr][sc];

        if(oldColor == color) return result;
        
        dfs(sr, sc, oldColor, color, result);
        return result;
        }

    public void dfs(int sr, int sc, int oldColor, int newColor, int[][] result) {
        if(sr < 0 || sr >= result.length || sc < 0 || sc >= result[0].length || result[sr][sc] != oldColor) return;
        
        result[sr][sc] = newColor;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int[] dir : directions){
            int newRow = sr + dir[0];
            int newCol = sc + dir[1];

                dfs(newRow, newCol, oldColor, newColor, result);
            
        }
    }
}