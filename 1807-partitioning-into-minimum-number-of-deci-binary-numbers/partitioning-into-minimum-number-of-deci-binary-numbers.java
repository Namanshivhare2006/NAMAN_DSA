class Solution {
    public int minPartitions(String n) {
        if(n.indexOf('9')!=-1) return 9; 
        if(n.indexOf('8')!=-1) return 8;          
        if(n.indexOf('7')!=-1) return 7;
        if(n.indexOf('6')!=-1) return 6;
        if(n.indexOf('5')!=-1) return 5;
        if(n.indexOf('4')!=-1) return 4;
        if(n.indexOf('3')!=-1) return 3;
        if(n.indexOf('2')!=-1) return 2;
        if(n.indexOf('1')!=-1) return 1;
        return 0;
    }
}