package model.entities;

public class VoteCount implements Comparable<VoteCount> {
    private String name;
    private Integer votes; 
    
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
        return getName().toLowerCase().compareTo(o.getName().toLowerCase());
    }
    
    @Override
    public String toString() {
        return name + ": " + votes;
    }
}
