class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int maxUnsatisfyedCustomer = 0;
        int currentunsatisfyedcustomers = 0;

        for(int i = 0; i<minutes; i++){
            currentunsatisfyedcustomers +=customers[i] * grumpy[i];
        }
 maxUnsatisfyedCustomer = currentunsatisfyedcustomers;
        int i = 0; 
        int j = minutes;
        while(j<n){
          currentunsatisfyedcustomers += customers[j] * grumpy[j];
           currentunsatisfyedcustomers-=customers[i]*grumpy[i];

            maxUnsatisfyedCustomer = Math.max( maxUnsatisfyedCustomer, currentunsatisfyedcustomers );
           i++;
             j++;
        }
    
      
        int total = maxUnsatisfyedCustomer;
        for(int k = 0; k<n; k++){
            if(grumpy[k]==0){
                total+=customers[k];
            }
        }
        return total;
        
    }
}