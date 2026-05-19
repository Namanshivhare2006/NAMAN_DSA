class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int arr[] = new int[n+1];
        for(int num : citations){
            if(num>n){
                arr[n]++;
            }else{
                arr[num]++;
            }
        }
        int count = 0;
        for(int i = n; i>=0; i--){
            count = count + arr[i];
            if(count>=i){
                return i;
            } 
            
        }
        return 0;
        
    }
}