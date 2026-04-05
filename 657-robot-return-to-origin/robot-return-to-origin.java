class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(char direction : moves.toCharArray()){
            if(direction=='U') y++;
            else if(direction=='D') y--;
            else if(direction=='R') x++;
            else if(direction=='L') x--;

        }
        if(x==0 && y==0) return true;
        return false;
    }
}