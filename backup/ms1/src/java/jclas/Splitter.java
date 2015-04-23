/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Splitter {

    static String rest[] = new String[3];
    ArrayList<String> links = new ArrayList<String>();
    ArrayList<String> redLinks = new ArrayList<String>();

    public ArrayList<String> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }

    public void doer() {
        try {

            
            for (int i = 0; i < getLinks().size(); i++) {
                
                 
                if (getLinks().get(i).indexOf("resource")>0) {
                    rest = getLinks().get(i).split("resource/");
                    redLinks.add(rest[1]);
                }

                if (getLinks().get(i).indexOf("page")>0) {
                    rest = getLinks().get(i).split("page/");
                    redLinks.add(rest[1]);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getRedLinks() {
        doer();
        return redLinks;
    }
}
