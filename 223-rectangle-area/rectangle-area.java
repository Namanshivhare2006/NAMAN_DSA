class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        

        //area both 
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        //common
        int width = Math.min(ax2 , bx2) - Math.max(ax1, bx1);
        int height = Math.min(ay2, by2) - Math.max(ay1,by1);

        return area1 + area2 - Math.max(width, 0) * Math.max(height, 0);
    }
}