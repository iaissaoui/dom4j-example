/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aissaoui.iqbal.xml.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 *
 * @author Iqbal AISSAOUI <aissaoui.iqbal@gmail.com>
 */
public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("<root><Tag1 F1=\"V1\" F2=\"V2\" F3=\"V3\" F4=\"V4\"/><Tag2 ");
        sb.append("   F1=\"V1\" ");
        sb.append("   F2=\"V2\" ");
        sb.append("   F3=\"V3\" F4=\"V4\"/><Tag3 ");
        sb.append("   F1=\"V1\" ");
        sb.append("   F2=\"V2\" ");
        sb.append("   F3=\"V3\" F4=\"V4\"");
        sb.append("   F5=\"V5\"");
        sb.append("/></root>");
        String text = sb.toString();
        try {
            Document document = DocumentHelper.parseText(text);
            String xPath = "/root/*";
            
            List<Node> list =  document.selectNodes(xPath);
            Map<String,String> map = new HashMap<>();
            for(Node n:list){
                System.out.println("Tag: " + n.getName());
                Map<String,String> hmAttributes = new HashMap<>();
                List<Attribute> lAttributes = ((Element) n).attributes();
                for(Attribute attr:lAttributes){
                    hmAttributes.put(attr.getName(), attr.getValue());
                }
                
                System.out.println("Attributes: " + hmAttributes.toString());
                                
            }
 

        } catch (DocumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
