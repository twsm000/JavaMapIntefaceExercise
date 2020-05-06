package application;

import java.util.Iterator;
import java.util.Scanner;

import model.entities.VoteCount;
import model.services.CandidateSummaryReport;
import model.services.VotingCSVReader;

/* Na contagem de votos de uma elei��o, s�o gerados v�rios registros 
 * de vota��o contendo o nome do canditado e a quantidade de votos
 * (formato .csv) que ele obteve em uma urna de vota��o. Voc� deve
 * fazer um programa para ler os registros de vota��o a partir de um
 * arquivo, e da� gerar um relat�rio consolidado com os totais de cada 
 * candidato.
 * */

public class Program {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file full path: ");
        String filePath = scan.next();
        
        try {
            VotingCSVReader listingService = new VotingCSVReader(filePath);
            listingService.readFile();
            CandidateSummaryReport report = new CandidateSummaryReport();
            report.countVotes(listingService);

            Iterator<VoteCount> summary = report.summary((vc1, vc2) -> vc2.getVotes().compareTo(vc1.getVotes()));
            int index = 0;
            while (summary.hasNext()) {
                System.out.printf("%d� - %s\n", ++index, summary.next());                
            }
        } catch (Exception e) {
            System.out.println("An error has ocurred: " + e.getMessage());            
            e.printStackTrace();
        }
        finally {
            scan.close();
        }
    }
}
