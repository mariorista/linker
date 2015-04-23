/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Conn implements Runnable {

    String ont, clas, sub, q, f5;
    String filename, url;
    Parse pr;
    ArrayList<String> la = new ArrayList<String>();
    ArrayList<String> allin = new ArrayList<String>();

    public void setPr(Parse pr) {
        this.pr = pr;
    }

    public String getQ() {
        return q;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getOnt() {
        return ont;
    }

    public void setOnt(String ont) {
        this.ont = ont;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

 
    public ArrayList<String> getAllin() {
        run();
        return allin;
    }

    @Override
    public void run() {
        String add, rest;
        try {
           //System.out.println("q: "+q);
            for (int j = 1; j < 2; j++) {
//                 if ((getSub().equals("")) || (getSub() == null)) {
//                add = "http://api.sindice.com/v3/search?q=" + q + "&page=";
//            } else {
//                add = "http://api.sindice.com/v3/search?q=" + q + "&fq=class:" + sub + "&page=";
//            }
add = "http://api.sindice.com/v3/search?q=" + q + "&page=";
                rest = j + "&format=rdfxml";
                url = add + rest;
                System.out.println(url);
                // url = "http://api.sindice.com/v3/search?q=juventus&page=2&format=rdfxml";

                URL u = new URL(url);
                URLConnection uc = u.openConnection();
                uc.connect();

                InputStream is = uc.getInputStream();
                pr = new Parse(is);
                pr.setQ(q);
                la = pr.getVal();
                //System.out.println("Conn--> la-size:"+la.size());

                is.close();
                allin.addAll(la);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void copier() {

        allin.addAll(la);
    }
}
