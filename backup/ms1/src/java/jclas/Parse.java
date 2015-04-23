/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author diego
 */
public class Parse {

    //InputStreamReader in;
    InputStream in;
    public ArrayList<String> lisrArray = new ArrayList<String>();
    public ArrayList<String> val = new ArrayList<String>();
    String q;

    public Parse(InputStream in) {
        this.in = in;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public ArrayList<String> getVal() throws IOException {
        parsinger();
        return val;
    }

    public ArrayList<String> pxml() throws SAXException, IOException {
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        String printl, printt = "haha", printf;
        try {
            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //parse using builder to get DOM representation of the XML file
            Document doc = db.parse(in);

            NodeList nList = doc.getElementsByTagName("link");

            for (int i = 0; i < nList.getLength(); i++) {


                Element link = (Element) nList.item(i);
                printl = link.getAttribute("rdf:resource");
                lisrArray.add(printl);
                //System.out.println(i + "_" + print);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lisrArray;
    }

    public void parsinger() throws IOException {

        ArrayList<String> res = new ArrayList();
        String line = "";
        InputStreamReader r = new InputStreamReader(in);
        BufferedReader input = new BufferedReader(r);

        try {
            while ((line = input.readLine()) != null) {
//System.out.println("--->"+line);
                if (line.contains("<Result")) {
                    while (!line.contains("</Result>")) {
                        line = input.readLine();
                        res.add(line);

                    }
                    valuer(res);
                    res.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void valuer(ArrayList<String> res) {

        String allDone = "";
        String line;
        String[] info = new String[3];
        String[] info2 = new String[30];
        String title, link;
        boolean flagt = true, flagl = true;



        for (int i = 0; i < res.size(); i++) {
            line = res.get(i);

            if (flagl == true && line.contains("<link")) {
                link = "nowhere";
                flagl = false;
                info = line.split("resource=");
                info2 = info[1].split("/>");
                link = info2[0];

                if (link.startsWith("\"")) {
                    link = link.substring(6, link.length() - 6);
                }
                allDone = allDone + link + ";";
            }
            if (flagt == true && line.contains("<dc:title>")) // an h thesi sti lista exei to element pou theleis
            {
               
                title = q;
                flagt = false;
                info = line.split(">");
                info2 = info[1].split("</dc:");
                title = info2[0];

                if (title.startsWith("&quot;")) {
                    title = title.substring(6, title.length() - 6);
                }
                 System.out.println("---"+title);
                
                allDone = allDone + title;
            }

            if (!flagt && !flagl) {
                break;
            }
        }
        val.add(allDone);
        //System.out.println("done: "+allDone);
    }
}
