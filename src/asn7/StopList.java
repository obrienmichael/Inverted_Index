package asn7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StopList
{
    protected HashSet<String> stopList;

    public StopList(String fileName)
    {
        createStopList(fileName);
    }

    /**
     *
     * @param fileName
     */
    public HashSet<String> createStopList(String fileName)
    {
        stopList = new HashSet<String>();

        try
        {
            BufferedReader BuffRead = new BufferedReader(new FileReader(fileName));

            for(String line; (line = BuffRead.readLine()) != null;)
                stopList.add(line.trim());

            BuffRead.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return stopList;

    }

    /**
     * Boolean that indicates if there are stop words present in an array list
     * @param stopList
     * @param queryWords
     * @return true if stop word is present
     * @return false if there are no words
     */
    public boolean containsStopWord(Set<String> stopList, ArrayList<String> queryWords)
    {
        for(String words: queryWords)
        {
            if(stopList.contains(words))
            {
                System.out.println("There are stopwords in the array");
                return true;
            }
        }
        System.out.println("there are NO stopwords in the array ");
        return false;
    }

    /**
     *
     * @param stopList
     * @param word
     * @return
     */
    public boolean containsSW(String word)
    {
        if(stopList.contains(word))
            return true;
        return false;
    }

    /**
     *
     * @param stopList
     * @param queryWords
     * @return NewList ArrayList

    public ArrayList<String> deleteStopWords(Set<String> stopList, ArrayList<String> queryWords)
    {
    Iterator<String> iter = queryWords.iterator();

    while (iter.hasNext())
    {
    String word = iter.next();
    if(stopList.contains(word))
    {
    iter.remove();
    }
    }

    for(String words: queryWords)
    System.out.print(words + " ");

    return queryWords;
    } */

}
