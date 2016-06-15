package main.domain;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args){
    	Scanner in = new Scanner( System.in );
    	Formatter f = new Formatter();
        while (true) {
        	System.out.println("%nEnter your regex: ");
        	String p = in.nextLine();
			Pattern pattern = 
            Pattern.compile(p);
			
			System.out.println("Enter input string to search: ");
			String m = in.nextLine();
            Matcher matcher = 
            pattern.matcher(m);

            boolean found = false;
            while (matcher.find()) {
            	System.out.println(
            			f.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end()));
                found = true;
            }
            if(!found){
                System.out.println("No match found.%n");
            }
        }
    }
}