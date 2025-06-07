class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> subDomainFreq = new HashMap<>();

        for(String cpDomain: cpdomains){
            List<String> freqAndSubDomain = getFreqAndSubDomain(cpDomain);

            int freq = Integer.parseInt(freqAndSubDomain.get(0));
            List<String> subDomains = getAllSubDomain(freqAndSubDomain.get(1));

            subDomains.forEach(subDomain->{
                subDomainFreq.put(subDomain, subDomainFreq.getOrDefault(subDomain, 0) + freq);
            });
        }

        List<String> ans = new ArrayList<>();
        for(String subDomain: subDomainFreq.keySet()){
            String cpDomain = subDomainFreq.get(subDomain).toString() + " " + subDomain;
            ans.add(cpDomain);
        }
        return ans;
    }

    private List<String> getAllSubDomain(String domain){
        int index=0;
        List<String> subDomains = new ArrayList<>();

        int size = domain.length();
        subDomains.add(domain);
        for(index=0; index<size; index++){
            if(domain.charAt(index) == '.'){
                subDomains.add(domain.substring(index+1, size));
            }
        }
        // System.out.println("subDomains");
        // System.out.println(subDomains);
        return subDomains;
    }

    private List<String> getFreqAndSubDomain(String cpDomain){
        int spaceIndex=0;

        for(spaceIndex=0; spaceIndex<cpDomain.length(); spaceIndex++){
            if(cpDomain.charAt(spaceIndex) == ' '){
                break;
            }
        }

        List<String> freqAndSubDomain = new ArrayList<>();
        freqAndSubDomain.add(cpDomain.substring(0, spaceIndex));
        freqAndSubDomain.add(cpDomain.substring(spaceIndex+1, cpDomain.length()));

        // System.out.println("freqAndSubDomain");
        // System.out.println(freqAndSubDomain);
        return freqAndSubDomain;
    }
}