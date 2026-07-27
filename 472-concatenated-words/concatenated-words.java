class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> hs = new HashSet<>();
        HashMap<String,Boolean> map = new HashMap<>();
        for(String word : words){
            hs.add(word);
        }
        List<String> res = new ArrayList<>();
     for(int i = 0; i<words.length; i++){
        if(IsConcates(words[i], hs,map)){
            res.add(words[i]);
        }
        

     }  
     return res; 
    }
    public boolean IsConcates(String word,  Set<String> hs, HashMap<String,Boolean> map){
        if(map.containsKey(word)){
            return map.get(word);
        }
        for(int i = 0; i<word.length(); i++){
            String prefix = word.substring(0,i+1);
            String suffix = word.substring(i+1,word.length());
            if(hs.contains(prefix) && hs.contains(suffix) || hs.contains(prefix) && IsConcates(suffix,hs,map)){
                map.put(word,true);
                return true;
            }

        }
        map.put(word,false);
        return false;
    }
}