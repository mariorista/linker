/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Connecter {

    /*
     * String ont, clas, sub, q, f5; String filename; Parse pr;
     * ArrayList<String> la = new ArrayList<String>(); ArrayList<String> allin =
     * new ArrayList<String>();
     */
    Conn con = new Conn();
    Splitter spl = new Splitter();
    ArrayList<String> links = new ArrayList<String>();  //holds the regular links
    ArrayList<String> redLnk = new ArrayList<String>(); // holds the reduced links (domain)
    String text, txt;

    public void show() throws FileNotFoundException {
        System.out.println("im here show");
        con.setQ("Skanderbeg");
        con.setSub("http://dbpedia.org/ontology/Person");
        setLinks();                                                     //get the links
        setRedLnk();                                                    //get the reduced links 
        System.out.println("im here show after");
       // printer();
        executer();


    }
    
    public void printer() {
        for(int i=0;i<getRedLnk().size();i++){
            System.out.println("----: "+getLinks().get(i));
             System.out.println("----> "+getRedLnk().get(i));
        }
    }

    public void executer() {
        try {
            for (int i = 0; i < getRedLnk().size(); i++) {
                String txt = getRedLnk().get(i);
                text = getInfo(txt);
                System.out.print(text);
                //fileWriter(text, "file_" + txt + "_" + i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setLinks() {//initates the links arralylist from the con results
        links = con.getAllin();
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public ArrayList<String> getRedLnk() {
        return redLnk;
    }

    public void setRedLnk() {//initiates the red links from the links-arraylist and splitter-class
        spl.setLinks(links);
        redLnk = spl.getRedLinks();
    }

    /*
     * writes the xml resuls to a file
     */
    public void fileWriter(String text, String fName) throws FileNotFoundException {
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(fName + ".xml"));
            out.print(text);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /*
     * get the results from dbpedia
     */
    public String getInfo(String keyWord) {

        String line = "i am empty";  //will contain the xml response as an string 
        String data = null;
        try {
            //add-is the SPARQL query that we run
            String add = "http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=PREFIX+dbo%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E+%0D%0APREFIX+%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E+%0D%0A%0D%0ASELECT++%3Fpred+%3Fo+%0D%0AWHERE%7B+%0D%0A%0D%0A+%7B%3A" + keyWord + "++%3Fpred+%3Fo.+%0D%0AFILTER+%28lang+%28%3Fo%29+%3D%22en%22%29+.%7D+%0D%0A%0D%0AUNION++%0D%0A%0D%0A+%7B%3A" + keyWord + "++dbo%3AwikiPageExternalLink+%3Fo+.%7D+%0D%0A%0D%0A%7D+%0D%0A&format=text%2Fxml&timeout=0&debug=on";

            URL u = new URL(add);
            URLConnection uc = u.openConnection();
            uc.connect();
            InputStream is = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                System.out.println(line);
            }
            data = sb.toString();
            is.close();
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();

            return line;
        }
    }
}
