/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Demo {

    static Splitter spl = new Splitter();
    //String line,str;
    static String str, q;
    static ArrayList<String> val = new ArrayList<String>();
    private ArrayList<String> links;
    private static ArrayList<String> redLinks;
    static ArrayList<String> terms;
    static ArrayList<String> comments;

    public static void main(String[] args) throws MalformedURLException, IOException {
        Conn con = new Conn();
        con.setQ("jordan");
        val = con.getAllin();
        
        //showVals();
      
        Disambiguity dsg = new Disambiguity();
        //dsg.getInfo("Juventus");
        dsg.setLinks(val);
        dsg.doAll();
//        terms = dsg.getTerms();
//        comments = dsg.getComments();
//
//       // goer();
//
//        showTerms();
//        showComments() ;
    }

    public static void goer() {
        for (int i = 0; i < redLinks.size(); i++) {
            System.out.println("--->" + i + " " + redLinks.get(i));
        }
    }
//       

    public static void showTerms() {
        for (int i = 0; i < terms.size(); i++) {
            System.out.println("trm--->" + i + " " + terms.get(i));
        }
    }
    
      public static void showComments() {
        for (int i = 0; i < comments.size(); i++) {
            System.out.println("cmt--->" + i + " " + comments.get(i));
        }
    }
      
      public static void showVals() {
        for (int i = 0; i < val.size(); i++) {
            System.out.println("val--->" + i + " " + val.get(i));
        }
    }

    public static void getRedLinks() throws UnsupportedEncodingException {
        System.out.println("disamnbbb,  redlinks");
        Splitter spl = new Splitter();
        spl.setLinks(val);
        redLinks = spl.getRedLinks();
    }
    
    
    
    
}
