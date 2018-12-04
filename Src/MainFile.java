import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainFile{
    public static void main(String[] args){
        System.out.println("Enter file name..");
        Scanner scan = new Scanner(System.in);
        String fileName = scan.next();
        
        
        String filePath = fileName;


        String[] parts = usingBufferedReader( fileName ).split(" ");

        boolean flag = false;
        System.out.println("How many buckets do you want?");
        int checkBucket = scan.nextInt();
        // System.out.println("Do you want to print hash table?  (Y || N)");
        // char checkPrint = scan.next().charAt(0);
        System.out.println("Do you want search for a special key word..?\n\n If Yes hit the word if No hit 'No' ");
        String checkSearch = scan.next();

       
      //  if(checkPrint=='Y' || checkPrint =='y')
             flag= true;

        HashTableImp hashTableData = new HashTableImp(checkBucket);

        //hashTablesData.calculateStandardDeviation(parts);

        for( int itr =0; itr< parts.length;itr++){
            //System.out.println(parts[itr]);
            hashTableData.insert(parts[itr]);
            //System.out.println(parts[itr]+"  "+parts[itr].hashCode());
        }
        
        if(flag)
             hashTableData.printHashTable();

//         String keyWordForSearch = scan.next();
        if(checkSearch.equalsIgnoreCase("No")){
           
        }
        else{
            //String keyWordForSearch = checkPrint;
            long startTime = System.nanoTime();
            System.out.println("\n key word  \"" + checkSearch+"\" is used  "+ hashTableData.search(checkSearch)+"  number of time(s)");
            long endTime = System.nanoTime();
            System.out.println("That took "+(endTime-startTime)+" ns.");
        }
    }

  //  }


    private static String usingBufferedReader(String filePath){
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){

            String CurrentLine;
            while ((CurrentLine = br.readLine()) != null){
                //CurrentLine.replaceAll("[^a-zA-Z0-9]", "");
                contentBuilder.append(CurrentLine).append('\n');
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }
       
        return contentBuilder.toString().toLowerCase().replaceAll("\\s+", " ").replaceAll("[^a-z ]", "");
    }
}