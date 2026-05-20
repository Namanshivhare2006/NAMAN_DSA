class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> gebank = new HashSet<>(Arrays.asList(bank));

        // endGene must exist in bank
        if (!gebank.contains(endGene)) {
            return -1;
        }

        char[] mutations = {'A', 'C', 'G', 'T'};

        Queue<String> aq = new LinkedList<>();
        aq.add(startGene);

        int count = 0;

        while (!aq.isEmpty()) {

            int n = aq.size();

            for (int j = 0; j < n; j++) {

                String gene = aq.poll();

                // reached target
                if (gene.equals(endGene)) {
                    return count;
                }

                StringBuilder curr = new StringBuilder(gene);

                for (int i = 0; i < 8; i++) {

                    char original = curr.charAt(i);

                    for (char mutation : mutations) {

                        curr.setCharAt(i, mutation);

                        String nextgene = curr.toString();

                        if (gebank.contains(nextgene)) {

                            aq.add(nextgene);

                            // mark visited
                            gebank.remove(nextgene);
                        }
                    }

                    // restore original character
                    curr.setCharAt(i, original);
                }
            }

            count++;
        }

        return -1;
    }
}