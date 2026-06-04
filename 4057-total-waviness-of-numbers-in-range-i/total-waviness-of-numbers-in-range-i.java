class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i = num1; i<=num2; i++){
        ArrayList<Integer> arr = new ArrayList<>();
        int num = i;
        while(num>0){
            int d = num%10;
            arr.add(d);
            num = num/10;
        }
        Collections.reverse(arr);
        for(int j = 1; j<arr.size()-1; j++){
               if(arr.get(j)>arr.get(j-1) && arr.get(j)>arr.get(j+1)){
                count++;
               }
               if(arr.get(j)<arr.get(j-1) && arr.get(j)<arr.get(j+1)){
                count++;
               }
        }
        }
       return count;
    }
}