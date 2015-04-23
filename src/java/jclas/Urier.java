/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jclas;

/**
 *
 * @author diego
 */
public class Urier {
    
    String foafStr = "http://xmlns.com/foaf/0.1/";
    String dbStr = "http://dbpedia.org/ontology/";
    
    String ontology,sub, fullOnt;

    public String getDbStr() {
        return dbStr;
    }

    public void setDbStr(String dbStr) {
        this.dbStr = dbStr;
    }

    public String getFoafStr() {
        return foafStr;
    }

    public String getSub() {
        
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setFoafStr(String foafStr) {
        this.foafStr = foafStr;
    }

    public String getOntology() {
        return ontology;
    }

    public void setOntology(String ontology) {
        this.ontology = ontology;
    }

    public String getFullOnt() {
         System.out.println(ontology);
        
         if (ontology.equals("foaf"))
            fullOnt= getFoafStr()+sub;
         else if (ontology.equals("dbpedia"))
            fullOnt=  getDbStr()+sub;
        else
            return "";
          System.out.println("fullOnt"+fullOnt);
        return fullOnt;
    }

    public void setFuulOnt(String fuulOnt) {
        this.fullOnt = fullOnt;
    }
}
