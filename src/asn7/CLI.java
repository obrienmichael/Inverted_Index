
package asn7;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CLI
{

    protected static HashSet<String> stopList;

    public static void main (String[] args)
    {
        Document doc;

        ArrayList<Document> documentList = new ArrayList<Document>();

        for(int i=1; i<args.length; i++)
        {
            doc = new Document(args[i]);
            documentList.add(doc);
        }


        StopList sl = new StopList(args[0]);

        InvertedIndex II = new InvertedIndex(sl, documentList);

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter query: ");

        String userQuery = scan.nextLine();

        //System.out.println(userQuery);

        II.query(userQuery);

        System.out.println("past query method");

    }

}