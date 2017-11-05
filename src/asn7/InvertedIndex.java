

//This is my code
//Michael O'Brien
//CS312

package asn7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

public class InvertedIndex
{
    private Hashtable<String, ArrayList<Document>> map;
    private StopList stopList;


    public InvertedIndex(StopList stopList, ArrayList<Document> docList)
    {
        this.map = new Hashtable<String, ArrayList<Document>>();
        this.stopList = stopList;
        index(docList);
    }

    private void index(ArrayList<Document> docs)
    {
        for(Document file: docs)
        {
            for(String word: file)
            {
                if (!stopList.containsSW(word) && word != " ")
                {
                    if(this.map.contains(word) && !this.map.get(word).contains(file))
                        this.map.get(word).add(file);

                    else
                    {
                        ArrayList<Document> newArr = new ArrayList<Document>();
                        newArr.add(file);
                        this.map.put(word, newArr);
                    }
                }
            }
        }
        long startTime = System.currentTimeMillis();
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("@@ took " + elapsedTime + "ms");
    }

    /**
     * @param String
     * @return ArrayList<String>
     */
    private ArrayList<String> readQuery(String userQuery)
    {
        ArrayList<String> queryWords  = new ArrayList<String>();
        ArrayList<String> cleanQuery = new ArrayList<String>();

        StringTokenizer stok = new StringTokenizer(userQuery, " ");

        while(stok.hasMoreTokens())
        {
            queryWords.add(stok.nextToken());
        }

        for(String word: queryWords)
        {
            String newWord = word.replaceAll("[^@a-zA-Z]", "").toLowerCase();
            cleanQuery.add(newWord);
        }

        Iterator<String> iter = cleanQuery.iterator();

        while (iter.hasNext())
        {
            String word = iter.next();
            if(stopList.containsSW(word))
            {
                iter.remove();
            }
        }


        for(String words: cleanQuery)
            System.out.print(words + " ");


        return cleanQuery;
    }
    public void query(String query)
    {
        //if(query.equals("@@debug")
        //dumpInvertedIndex Method

        ArrayList<String> Q = readQuery(query);

        for(String word: Q)
        {
            if(this.map.containsKey(word))
            {
                ArrayList<Document> printList = (ArrayList<Document>) this.map.get(word).clone();
                System.out.println("cha boy" + printList);
                for(Document doc: printList)

                    doc.docName();
            }
        }
    }
}


