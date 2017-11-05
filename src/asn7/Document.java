package asn7;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Document implements Iterable<String>
{
    private String dName;
    private String content;

    /**
     *
     */
    public Document(String fileName)
    {
        //this.dName = dName;
        this.content = "";
        readFile(fileName);
    }


    /**
     *
     * @param fileName
     */
    public void readFile(String fileName)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while (true)
            {
                line = br.readLine();
                if (line == null)
                    break;
                else
                    this.content += (line + " ");
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param fileName
     */
    public void printContent()
    {
        System.out.println(content);
    }

    public void docName()
    {
        System.out.println(this.dName);
    }


    /**
     *
     * @return
     */
    public Iterator<String> iterator()
    {
        return new DocumentIterator();
    }

    /**
     *
     * @author Mike
     *
     */
    private class DocumentIterator implements Iterator<String>
    {
        StringTokenizer st;

        public DocumentIterator()
        {
            this.st = new StringTokenizer(content);
        }

        public boolean hasNext()
        {
            return this.st.hasMoreTokens();
        }


        public String next()
        {
            return this.st.nextToken().replaceAll("[^a-zA-Z]+", "");
        }


        public void remove()
        {
            throw new UnsupportedOperationException();
        }

    }
}