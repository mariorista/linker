/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public class Disambiguity {

    ArrayList<String> links = new ArrayList<String>();//contains the links returned by the parser
    String[] redLnks;
    String q;
    //String[] redLnks2;
    //ArrayList<Integer> subOrObjDisamb = new ArrayList<Integer>();//the dbpedia red links that do not have disambiguity
    ArrayList<String> terms = new ArrayList<String>();// contains the terms from the disambiguity page
    ArrayList<String> searchTerms = new ArrayList<String>();//contains the terms undecoded
    ArrayList<String> comments = new ArrayList<String>();//contains the comments of each term
    ArrayList<String> redComList = new ArrayList<String>();//contains the disambiguity link for each page
    ArrayList<String> isDisList = new ArrayList<String>();
    ArrayList<String> hasDisList = new ArrayList<String>();
    ArrayList<String> keyTerm = new ArrayList<String>();
    int isDisSize, hasDisSize, redSize;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }


    public ArrayList<String> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public ArrayList<String> getTerms() {
        return terms;
    }

    public ArrayList<String> getRedComList() {
        return redComList;
    }

    public void setKeyTerm() {

        for (int i = 0; i < redLnks.length; i++) {
            if (redLnks[i] != null) {
                keyTerm.add(Strint(redLnks[i], -1));
            }
        }
        keyTerm.addAll(isDisList);
        keyTerm.addAll(hasDisList);

    }

    public ArrayList<String> getKeyTerm() {
        return keyTerm;
    }

    public void bbb() {
        System.out.println("term_size " + terms.size());
        System.out.println("coment_size " + comments.size());
//        System.out.println("redt_size " + getRedDisSize());
        System.out.println("redc_size " + redComList.size());
    }

    public void printMore() {
        for (int i = 0; i < terms.size(); i++) {
            System.out.println(i + " ===: " + terms.get(i));
//            System.out.println(i + " ===: " + comments.get(i));
        }
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(i + " ===: " + comments.get(i));
        }
//        for (int i = 0; i < redComList.size(); i++) {
//            System.out.println(i + " ===: " + redComList.get(i));
//        }
    }

    public void doAll() throws UnsupportedEncodingException, IOException {
        //System.out.println("disamnbbb,  do all");

        getTheRelLinks();       // get the red links

        disQueryObj();          // look if they are part of a disambiguity page

        disQuerySub();          // look if they are a disambiguity page

        getDbTerms();           // get the terms of the redLinks that were part of a disambiguity page    
//        bbb();
        getDbComents();
//
        redComment();           // get the terms for the remaining redlinks 
////
        setKeyTerm();
        
        printMore();
        bbb();
//        
//        
//        printerT();
//        printerC();

    }

    /*
     * get the terms that are returned by sindiche
     */
    public void getTheRelLinks() throws UnsupportedEncodingException {
        ArrayList temp;
        Splitter spl = new Splitter();
        spl.setLinks(links);
        temp = spl.getRedLinks();
        redLnks = (String[]) temp.toArray(new String[temp.size()]);
//        redLnks2 = new String[redLnks.length];
    }

    /*
     * query the dbpedia to find the disambiguity pages of the results we have
     * so far from sindice ; fill disList
     */
    //?o  dbo:wikiPageDisambiguates  <http://dbpedia.org/resource/"   key   ">.
    public void disQueryObj() throws UnsupportedEncodingException, IOException {
        String keyWord;

        for (int i = 0; i < redLnks.length; i++) {
            keyWord = URLEncoder.encode(redLnks[i], "UTF-8");
            passOne(keyWord, i);
        }

        for (int i = 0; i < redLnks.length; i++) {
            if (redLnks[i] == null) {
                continue;
            }
            keyWord = URLEncoder.encode(URLEncoder.encode(redLnks[i], "UTF-8"), "UTF-8");
            passOne(keyWord, i);
        }


    }


    /*
     * technically added to function corectly
     */
    public void passOne(String key, int i) throws MalformedURLException, IOException {

        String add, line, sig;
        BufferedReader br = null;
        String[] temp = new String[2];
        int count = 0, idx = i;
try{
        add = "http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=PREFIX+dbo%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E+%0D%0A%0D%0ASELECT+++%3Fo+%0D%0AWHERE%7B+%0D%0A%0D%0A+%3Fo++dbo%3AwikiPageDisambiguates++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F" + key + "%3E.%0D%0A%0D%0A%7D%0D%0A&format=text%2Fhtml&timeout=0&debug=on";
        URL u = new URL(add);
        URLConnection uc = u.openConnection();
        uc.connect();

        InputStream is = uc.getInputStream();
        br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        while ((line = br.readLine()) != null) {
            if (line.contains("<td>")) {
                count++;
                temp = line.split("<td>");
                temp = temp[1].split("</td>");
                sig = Strint(temp[0], idx);

                if (!isDisList.contains(sig)) {
                    isDisList.add(sig);
                    redLnks[i] = null;
                }
            }
            if (count >= 1) {
                idx = redLnks.length + count;
            }
        }//wnd while 
        is.close();
}catch(Exception e){e.printStackTrace();}

    }

// <http://dbpedia.org/resource/"   key   ">  dbo:wikiPageDisambiguates  ?o.
    public void disQuerySub() throws UnsupportedEncodingException, MalformedURLException, IOException {
        System.out.println("\n disQuerySub : ");
        boolean flag;
        String add, line, keyWord;
        BufferedReader br = null;
        String[] temp = new String[2];

        for (int i = 0; i < redLnks.length; i++) {
            flag = false;
            if (redLnks[i] == null) {
                continue;
            }
            keyWord = redLnks[i];

            add = "http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=PREFIX+dbo%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E+%0D%0A%0D%0ASELECT+++%3Fo+%0D%0AWHERE%7B+%0D%0A%0D%0A%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F" + keyWord + "%3E++dbo%3AwikiPageDisambiguates++%3Fo.%0D%0A%0D%0A%7D%0D%0A&format=text%2Fhtml&timeout=0&debug=on";

            URL u = new URL(add);
            URLConnection uc = u.openConnection();
            uc.connect();

            InputStream is = uc.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            while ((line = br.readLine()) != null) {
                if (line.contains("<td>")) {
                    disTerms(line, i);          //clear the line and get the term
                    flag = true;
                }
            }//wnd while

            if (flag) {                                 // it indicates us if the query brought response
                hasDisList.add(Strint(keyWord, i));     // put the keyword + index in the has dis list
                redLnks[i] = null;
            }                                           // => has dis list and the terms have the same idx
            is.close();
        }

    }

    /*
     * we have the isDis List an now we get their tesults
     */
    public void getDbTerms() {
        String[] tab = null;
        int j;
        for (int i = 0; i < isDisList.size(); i++) {//for each disambiguity page
            tab = isDisList.get(i).split("-;");
            j = Integer.parseInt(tab[1]);           // we gwt the index of the is dis list to give ite to the 
            getInfo(tab[0], j);                     //get the terms and the searchTerms
        }
//        setIsDisSize();//values that we will need at getter
        System.out.println("AAA ->" + terms.size());

    }

    /*
     * get the terms from the dbpedia disambigous resource
     */
    public void getInfo(String keyWord, int idx) {
        String line = "i am empty";  //will contain the xml response as an string 
        String firstq = "http://dbpedia.org/sparql?default-graph-uri=&query=";
        String lastq = "&format=text%2Fhtml&timeout=0&debug=on";
        String query, add;
        BufferedReader br;
        try {
            query = "PREFIX dbo: <http://dbpedia.org/ontology/> " //if the page had disambiguation we just get the terms
                    + "SELECT   ?o "
                    + "WHERE { <" + keyWord + ">  dbo:wikiPageDisambiguates   ?o."
                    + "}";
            add = firstq + URLEncoder.encode(query, "UTF-8") + lastq;

            URL u = new URL(add);
            URLConnection uc = u.openConnection();
            uc.connect();

            InputStream is = uc.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            while ((line = br.readLine()) != null) {
                disTerms(line, idx);                                              //get the term from the query
            }
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    /*
     * get the object of the disambiguity page the results will be in a html
     * table so we split at the end of the standart URI that contains "resource"
     * and again at the end of the term that is to the tag "</td>"
     */
    public void disTerms(String txt, int idx) throws UnsupportedEncodingException {
        String[] tab;
        String temp;
        boolean flag;

        if (txt.contains("resource/")) {
            tab = txt.split("resource/");
            tab = tab[1].split("</td>");

            if (!searchTerms.contains(tab[0])) {
                searchTerms.add(tab[0]);
                temp = tab[0];
//                temp = URLDecoder.decode(tab[0], "UTF-8");
//                if (temp.contains("&#39;")) {
//                    temp = temp.replaceAll("&#39;", "'");
//                }                       // if the redLink has disambiguity list
                terms.add(Strint(temp, idx));
                //System.out.println(" terms-----: " + temp);
            }
        }

    }

    public void getDbComents() throws UnsupportedEncodingException {
        ArrayList<Integer> ttd = new ArrayList<Integer>();
        String[] tab;
        String temp;
        int idx = 0;
        int k=0;;
//      
        for (int i = 0; i < searchTerms.size(); i++) {

            if (commentFirstPass(searchTerms.get(i))) {
                tab = terms.get(i).split("-;");
                System.out.println(tab[0]);
                try {
                    idx = Integer.parseInt(tab[1]);
                } catch (NumberFormatException n) {
                    n.printStackTrace();
                }
                if (!commentPass(searchTerms.get(i), idx)) {
                    if (!commentPass(URLEncoder.encode(searchTerms.get(i), "UTF-8"), idx)) {
                        comments.add(Strint("undisposed information", idx));
                    }
                }
            } else {
                ttd.add(i);
            }
        }
        
//        for (int j = 0; j < ttd.size(); j++) {
//           
//            terms.remove(ttd.get(j)-k);
//            searchTerms.remove(ttd.get(j)-k);
//            k++;
//        }

    }

    public boolean commentPass(String keyWord, int idx) {
        String line, temp, str;
        String term = null;
        String add;
        String query;
        Boolean FlagBody;
        BufferedReader br;
        //for (int i = 0; i < searchTerms.size(); i++) {
        FlagBody = false;
        try {

            add = "http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=PREFIX+dbo%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E+%0D%0A%0D%0ASELECT+++%3Fo+%0D%0AWHERE%7B+%0D%0A%0D%0A%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F" + keyWord + "%3E+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23comment%3E+%3Fo.+%0D%0AFILTER%28lang%28%3Fo%29%3D%27en%27%29%0D%0A%0D%0A%7D%0D%0A&format=text%2Fhtml&timeout=0&debug=on";

            URL u = new URL(add);
            URLConnection uc = u.openConnection();
            uc.connect();
            InputStream is = uc.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            while ((line = br.readLine()) != null) {
                if (line.contains("<td>")) {

                    temp = URLDecoder.decode(line.substring(9, line.length() - 9), "UTF-8");//decode the text
                    if (temp.contains("&#39;")) {                                           // to be more user friendly
                        temp = temp.replaceAll("&#39;", "'");
                    }
                    comments.add(Strint(temp, idx));
                    System.out.println(" comments +  : " + Strint(temp, idx));
                    FlagBody = true;
                    break;//because we know our response contains only 1 response;
                }
            }

            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return FlagBody;

    }

    /*
     * get the comments that have as subject the disambiguous terms
     */
    public boolean commentFirstPass(String keyWord) {
        String line, query;
        String add;

        Boolean FlagBody;
        BufferedReader br;
        FlagBody = false;
        query = q;
        try {

            //add = "http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=ASK%0D%0A%7B+%0D%0A++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F" + keyWord + "%3E+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23comment%3E+%3Fo+.%0D%0AFILTER%28contains%28%3Fo%2C%22" + query + "%22%29%29.%0D%0A%7D&format=text%2Fhtml&timeout=0&debug=on";
            add="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=ASK%0D%0A%7B+%0D%0A++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F" + keyWord + "%3E+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23comment%3E+%3Fo+.%0D%0AFILTER%28contains%28UCASE%28%3Fo%29%2CUCASE+%28%22" + query + "%22%29%29%29.%0D%0A%7D&format=text%2Fhtml&timeout=0&debug=on";
            //add ="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=SELECT+%3Fo%0D%0A%7B+%0D%0A++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F" + keyWord + "%3E+%3Fp+%3Fo+.%0D%0A%0D%0AFILTER+%28lang%28%3Fo%29%3D%22en%22%29.%0D%0A%0D%0AFILTER+regex%28%3Fo%2C+%22" + query + "%22%29%0D%0A%0D%0A%7D&format=text%2Fhtml&timeout=0&debug=on";
            System.out.println(add);
            URL u = new URL(add);
            URLConnection uc = u.openConnection();
            uc.connect();
            InputStream is = uc.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            while ((line = br.readLine()) != null) {
                if (line.contains("true")) {
                    FlagBody = true;
                    System.out.println("it is true");
                    break;//because we know our response contains only 1 response;
                }
            }
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return FlagBody;

    }

    public void redComment() throws UnsupportedEncodingException {
        String str = "undisposed information";
        int pos = comments.size();    //27                                            //we find the inital size of comments
        for (int i = 0; i < redLnks.length; i++) {                              //these are the comments of is/has dis
//            if (commentFirstPass(redLnks[i])) {
            if (redLnks[i] != null) {
                if (!commentPass(redLnks[i], -1)) {
                    if (!commentPass(URLEncoder.encode(redLnks[i], "UTF-8"), -1)) {
                        redComList.add(Strint(str, -1));
                    }
                }
            }
//            } else {
//                redLnks[i] = null;
//            }
        }
        for (int i = pos; i < comments.size(); i++) {
            redComList.add(comments.get(i));
        }
        comments.removeAll(redComList);                                         //and delete them from the comments list
    }

    public void printerT() {
        System.out.println("\n\n printt");
        try {
            for (int i = 0; i < terms.size(); i++) {
                System.out.println("term--: " + terms.get(i));
                System.out.println("comm--: " + comments.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printerC() {
        System.out.println("\n\n printc");
        try {
            for (int i = 0; i < comments.size(); i++) {
                System.out.println("term--: " + terms.get(i));
                System.out.println("comm--: " + comments.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Strint(String s, int i) {
        //System.out.println("\n"+s+i);
        return s + "-;" + i;
    }
}
