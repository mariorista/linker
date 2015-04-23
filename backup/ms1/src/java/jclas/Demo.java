/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

import java.io.IOException;
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
  static  ArrayList<String> val = new ArrayList<String>();
    
    

    public static void main(String[] args) throws MalformedURLException, IOException {
        Conn con =new Conn();
        con.setQ("juventus");
        con.setSub("http");
        
       con.getAllin();
      /// goer();
    }
    
     public static void goer() {
       

        //for (int i = 0; i < val.size(); i++) {
       //System.out.println("--->"+val.size());
       // }
    }
//       
}
