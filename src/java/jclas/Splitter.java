/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 *
 * @author diego Returns the terms of dbpedia that contains the results we
 * search it can ether be at dbpedia page or resource
 */
public class Splitter {

    String rest[] = new String[3];
    String rest2[] = new String[3];
    ArrayList<String> links = new ArrayList<String>();
    ArrayList<String> redLinks = new ArrayList<String>();
    ArrayList<String> relevantLinks = new ArrayList<String>();

    public ArrayList<String> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }
    
    

    public void doer() {
        //System.out.println("doer");
        try {
            for (int i = 0; i < getLinks().size(); i++) {
//System.out.println( getLinks().size());
                if (getLinks().get(i).contains("dbpedia.org/resource") ) {
                   // System.out.println(getLinks().get(i));
                    rest = getLinks().get(i).split("resource/");
                    rest2 = rest[1].split(";");
                    redLinks.add(URLDecoder.decode(rest2[0], "UTF-8"));                    
                    //redLinks.add(rest2[0]);
                }

                if (getLinks().get(i).contains("dbpedia.org/page") ) {
                    //relevantLinks.add( getLinks().get(i).replace("page", "resource"));                    
                    rest = getLinks().get(i).split("page/");
                    rest2 = rest[1].split(";");
                    redLinks.add(URLDecoder.decode(rest2[0], "UTF-8"));
                    //redLinks.add(rest2[0]);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    
    public void relevantLink() throws UnsupportedEncodingException {
        
        System.out.println("yep relevantlinks  ");
        
        for (int i = 0; i < getLinks().size(); i++) {

            if (getLinks().get(i).contains("dbpedia.org")){
                
                rest = getLinks().get(i).split(";");
                if(rest[0].contains("dbpedia.org/page"))
                    rest[0].replace("page", "resource");
                relevantLinks.add(rest[0]);         
            }
        }//printer();
    }

    public ArrayList<String> getRedLinks() throws UnsupportedEncodingException {
        doer();
        //printer();
        return redLinks;
    }

    public ArrayList<String> getRelevantLinks() throws UnsupportedEncodingException {
        relevantLink();
        
        return relevantLinks;
    }

    public void printer() throws UnsupportedEncodingException {
        for (int i = 0; i < redLinks.size(); i++) {
            //System.out.println(i+" _normal : " + URLDecoder.decode(redLinks.get(i), "UTF-8"));
            System.out.println(i+" _red    : " + redLinks.get(i));

        }
    }
}
