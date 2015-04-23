/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Disambiguity {

    ArrayList<String> links = new ArrayList<String>();
    ArrayList<String> redLinks = new ArrayList<String>();
    ArrayList<String> terms = new ArrayList<String>();
    ArrayList<String> searchTerms = new ArrayList<String>();
    public ArrayList<String> comments = new ArrayList<String>();

    public ArrayList<String> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }

    public ArrayList<String> getRedLinks() {
        return redLinks;
    }

    public void setRedLinks(ArrayList<String> redLinks) {
        this.redLinks = redLinks;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public ArrayList<String> getTerms() {
        return terms;
    }

    public void doAll() {
        //System.out.println("disamnbbb,  do all");
        getTheRedLinks();
        getDbTerms();
        getDbComents();
    }

    /*
     * get the terms that are returned by sindiche
     */
    public void getTheRedLinks() {
        Splitter spl = new Splitter();
        spl.setLinks(links);
        redLinks = spl.getRedLinks();
        System.out.println("the size is" + redLinks.size());
    }

    public void printer() {
        for (int i = 0; i < redLinks.size(); i++) {
            System.out.println("red_" + redLinks.get(i));
        }
    }

    /*
     * for every reduced link--that is (every term that apears fronm the dbpedia
     * grapg relevant with our query-word) go to dbpedia disambiguation of that
     * term and get the other terms, and show them to the user for each of those
     * terms get the comment from dbpedia and show it on click.
     */
    public void getDbTerms() {
        for (int i = 0; i < redLinks.size(); i++) {
            getInfo(redLinks.get(i));
        }
    }

    /*
     * get the terms from the dbpedia disambigous resource
     */
    public void getInfo(String keyWord) {
        String line = "i am empty";  //will contain the xml response as an string 

        try {
            String add = "http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=PREFIX+dbo%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0D%0A+SELECT+++%3Fo+%0D%0AWHERE+%7B++%0D%0A%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F" + keyWord + "_%28disambiguation%29%3E++dbo%3AwikiPageDisambiguates++%3Fo.+%7D&format=text%2Fhtml&timeout=0&debug=on";

            URL u = new URL(add);
            URLConnection uc = u.openConnection();
            uc.connect();

            InputStream is = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                disTerms(line);                                             //get the term from the query
            }
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * get the object of the disambiguity page
     */
    public void disTerms(String txt) throws UnsupportedEncodingException {

        String[] tab;
        String temp;
        /*
         * the results will be in a html table so we split at the end of the
         * standart URI that contains "resource" and again at the end of the
         * term that is to the tag "</td>"
         */
        if (txt.contains("resource/")) {
            tab = txt.split("resource/");
            tab = tab[1].split("</td>");

            if (!searchTerms.contains(tab[0])) {
                searchTerms.add(tab[0]);
                temp = URLDecoder.decode(tab[0], "UTF-8");
                if (temp.contains("&#39;")) {
                    temp = temp.replaceAll("&#39;", "'");
                }
                terms.add(temp);
            }
        }
    }

    /*
     * get the comments that have as subject the disambiguous terms
     */
    public void getDbComents() {
        String line, temp;
        String term = null;
        String firstq = "http://dbpedia.org/sparql?default-graph-uri=&query=";
        String lastq = "&format=text%2Fhtml&timeout=0&debug=on";
        String add;
        String query;
        Boolean FlagBody;
        for (int i = 0; i < searchTerms.size(); i++) {
            try {
                FlagBody = false;
                term = searchTerms.get(i);
                query = "SELECT ?o "
                        + "WHERE { "
                        + "<http://dbpedia.org/resource/" + term + "> <http://www.w3.org/2000/01/rdf-schema#comment> ?o. "
                        + "FILTER(lang(?o)='en')."
                        + "}";
                add = firstq + URLEncoder.encode(query, "UTF-8") + lastq;

                URL u = new URL(add);
                URLConnection uc = u.openConnection();
                uc.connect();
                InputStream is = uc.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {

                    if (line.contains("<td>")) {

                        temp = URLDecoder.decode(line.substring(8, line.length() - 8), "UTF-8");//decode the text
                        if (temp.contains("&#39;")) {                                           // to be more user friendly
                            temp = temp.replaceAll("&#39;", "'");
                        }
                        comments.add(temp);
                        FlagBody = true;
                        break;
                    }
                }

                if (!FlagBody) {
                    comments.add("undisposed information");
                }


                //System.out.println(i + "  cmt--: term :" + term + " comment :" + line);
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }//end for
    }
}
