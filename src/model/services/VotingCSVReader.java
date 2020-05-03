package model.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.entities.VoteCount;
import model.entities.VoteCountListing;

public class VotingCSVReader implements VoteCountListing {
    private BufferedReader reader;
    private List<VoteCount> votes = new ArrayList<>(); 

    public VotingCSVReader(String filePath) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(filePath));
    }
    
    public void readFile() throws IOException {
        String line = reader.readLine();
        while (line != null) {
            String[] tuple = line.split(",");
            String name = tuple[0].trim();
            int count = Integer.parseInt(tuple[1].trim()); 
            votes.add(new VoteCount(name, count));
            line = reader.readLine();                    
        }
    }
    
    public Iterator<VoteCount> getVotes() {
        return votes.iterator();
    }
}
