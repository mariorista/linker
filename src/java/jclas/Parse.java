/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;

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

    public void valuer(ArrayList<String> res) throws UnsupportedEncodingException {

        String allDone = "";
        String line;
        String[] info = new String[3];
        String[] info2 = new String[30];
        String title = q, link, format;
        boolean flagt = true, flagl = true, flagf = true;



        for (int i = 0; i < res.size(); i++) {
            line = res.get(i);
            //format = "0";

            if (flagl == true && line.contains("<link")) {
                link = "nowhere";
                flagl = false;
                info = line.split("resource=");
                info2 = info[1].split("/>");
                link = URLDecoder.decode(info2[0], "UTF-8");
                link = link.substring(1, link.length() - 1);

                allDone = allDone + link + ";";
            }

            if (flagt == true && line.contains("<dc:title")) // an h thesi sti lista exei to element pou theleis
            {
                flagt = false;
                info = line.split(">");
                info2 = info[1].split("</dc:");
                title = info2[0];

                if (title.startsWith("&quot;")) {
                    title = title.substring(6, title.length() - 6);
                }

                allDone = allDone + title + ";";
            }
            
            if (flagf == true && line.contains("format>RDFA")) {
                flagf = false;
                allDone = allDone + 1;
            }
            if (flagf && i==res.size()-1){
                 allDone = allDone + 0; //to add the format type 
            }

            if (!flagt && !flagl & !flagf) {
                //allDone = allDone + format; //to add the 
                break;
            }
        }
        val.add(allDone);
        //System.out.println("done: "+allDone);
    }
}
