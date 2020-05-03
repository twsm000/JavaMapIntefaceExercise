package model.entities;

import java.util.Comparator;

public class VoteCount implements Comparable<VoteCount> {
    private String name;
    private Integer votes; 
    private static Comparator<VoteCount> defaultOrderBy = new Comparator<VoteCount>() {
        @Override
        public int compare(VoteCount o1, VoteCount o2) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
    };
    private static Comparator<VoteCount> orderBy = defaultOrderBy;    
    
    public static final void setOrderBy(Comparator<VoteCount> orderBy) {
        if (orderBy == null)
            VoteCount.orderBy = VoteCount.defaultOrderBy;
        else
            VoteCount.orderBy = orderBy;  
    }
    
    public VoteCount(String name, Integer votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public Integer getVotes() {
        return votes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VoteCount other = (VoteCount) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int compareTo(VoteCount o) {
        return orderBy.compare(this, o);
    }

    @Override
    public String toString() {
        return name + ": " + votes;
    }
}
