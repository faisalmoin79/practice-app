package com.example.demo;

import java.util.*;


public class ParsingHtmlTags{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
        try{
            while(testCases>0 && testCases <=100){
                String line = in.nextLine();
                
                String parsedContent = null;
                String outerTag = null;
                String tagName = null;
                boolean tagFound = false;
                if(line!=null && line.length()<=10000  && hasTag(line)){ // if line contains a tag
                    String lineToParse = line;
                    
                    while(lineToParse!=null && lineToParse.length() >0 && hasTag(lineToParse)){
                        // System.out.println("Parsing line: "+lineToParse);
                        tagName = getTagName(lineToParse);
                        //System.out.println("tagName: "+tagName);
                        
                        int startIndex = lineToParse.indexOf("<");
                        int endIndex = lineToParse.lastIndexOf("</"+tagName+">")+tagName.length()+3;
                        //System.out.println("startIndex: "+startIndex+", endIndex: "+endIndex);
                        outerTag = lineToParse.substring(startIndex, endIndex);
                        if(tagName!=null && !tagName.isEmpty()){
                            //System.out.println("Got valid tag: "+tagName);
                            
                            //System.out.println("outerTag: "+outerTag);
                            parsedContent = getNestedTagContents(outerTag);
                            if(parsedContent!=null && !parsedContent.trim().isEmpty()){
                                System.out.println(parsedContent);
                            }else{
                                System.out.println("None");
                            }
                            
                            tagFound = true;
                            
                        }else{
                            //System.out.println("Got no valid tag");
                            //System.out.println("None");
                        }
                        lineToParse = lineToParse.substring(outerTag.length());
                        //System.out.println("Next line to parse: "+lineToParse);

                         //System.out.println();
                    }
                    if(!tagFound){
                        System.out.println("None");
                    }

                } else {
                    // tag does not exist
                    System.out.println("None");
                }
                testCases--;
            }
        }catch(Exception e){
            //System.out.println("error: "+e.getMessage());
            System.out.println("None");
        }
	}
    
    
    public static String getNestedTagContents(String line){
        //System.out.println("line: "+line);
        while(getTagName(line)!=null){
            String tagName = getTagName(line);
            //System.out.println("tagName: "+tagName);
            line = getTagContents(line, tagName);
        }
        //System.out.println("tagContents: "+line);
        return line;
    }
    
    public static String getTagContents(String line, String tagName){
        String content = "None";
        String startTag = "<"+tagName+">";
        String endTag = "</"+tagName+">";

        if(line.contains(startTag) && line.contains(endTag)){
            int startIndex = line.indexOf(startTag)+tagName.length()+2;
            int endIndex = line.lastIndexOf(endTag);
            content = line.substring(startIndex, endIndex);
        }
        return content;
    }
        

    public static boolean hasTag(String testString){
        if(testString.contains("<") && testString.contains(">")){ // tag exisits;
            String tagName = testString.substring(testString.indexOf("<")+1, testString.indexOf(">"));
            String startTag = "<"+tagName+">";
            String endTag = "</"+tagName+">";
            if( testString.contains(startTag) && testString.contains(endTag)
            && testString.indexOf(endTag) > testString.indexOf(startTag)){
                return true;
            }
        }
        
        return false;
    }
        
    public static String getTagName(String testString){
        if(testString.contains("<") && testString.contains(">")){ // tag exists;
            String tagName = testString.substring(testString.indexOf("<")+1, testString.indexOf(">"));
            String startTag = "<"+tagName+">";
            String endTag = "</"+tagName+">";
            if( testString.contains(startTag) && testString.contains(endTag)
            && testString.indexOf(endTag) > testString.indexOf(startTag)){
                return tagName;
            }
        }
        
        return null;
    }
    
}



