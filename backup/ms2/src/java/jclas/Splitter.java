/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

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

                if (getLinks().get(i).indexOf("dbpedia.org/resource") > 0) {
                    rest = getLinks().get(i).split("resource/");
                    rest2 = rest[1].split(";");
                    redLinks.add(rest2[0]);
                }

                if (getLinks().get(i).indexOf("page") > 0) {
                    rest = getLinks().get(i).split("page/");
                    rest2 = rest[1].split(";");
                    redLinks.add(rest2[0]);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getRedLinks() {
        doer();
        // printer();
        return redLinks;
    }

    public void printer() {
        for (int i = 0; i < getLinks().size(); i++) {
            System.out.println("normal" + getLinks().get(i));
            System.out.println("red" + getRedLinks().get(i));

        }
    }
}
