package model.services;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import model.entities.VoteCount;
import model.entities.VoteCountListing;

public class CandidateSummaryReport {
    private Map<String, Integer> summary = new HashMap<>();

    public CandidateSummaryReport() {
    }
    
    public void countVotes(VoteCountListing list) {
        Iterator<VoteCount> votes = list.getVotes();
        while (votes.hasNext()) {
            VoteCount voteCount = votes.next();
            int count = summary.getOrDefault(voteCount.getName(), 0) + voteCount.getVotes(); 
            summary.put(voteCount.getName(), count);
        }
    }

    public Iterator<VoteCount> summary() {
        return this.summary(null);
    } 
    
    public Iterator<VoteCount> summary(Comparator<VoteCount> ordernation) {
        VoteCount.setOrderBy(ordernation);
        Set<VoteCount> votes = new TreeSet<>();
        
        for (Map.Entry<String, Integer> counter : summary.entrySet()) {
            votes.add(new VoteCount(counter.getKey(), counter.getValue()));
        }
        
        return votes.iterator();        
    }
}    