package com.cameronbeeler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String s = "I am a string, Yes I am";
        System.out.println(s);
        String youString = s.replace("I", "You");
        System.out.println(youString);
        String alphaNumeric = "hello";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));
        System.out.println(alphaNumeric.replaceAll("^[a-z]*", "DONE"));
        System.out.println(alphaNumeric.matches("^hello"));
        System.out.println(alphaNumeric.replaceAll("llo$", "brew"));
        alphaNumeric = "abcdefg123cdefg5671";
        System.out.println(alphaNumeric.replaceAll("[a15]", "Z"));
        System.out.println(alphaNumeric.replaceAll("[^acd135]", "X"));
        // while the ^ prior to the brackets is a placement character, but inside the range is a negation
        System.out.println(alphaNumeric.replaceAll("(?i)[ABC]", "M")); //SWITCH off case sensitivity
        // (?iu) for unicode negation
        System.out.println(alphaNumeric.replaceAll("\\d", "Z")); // decimal map
        System.out.println(alphaNumeric.replaceAll("\\D", "0")); // non-decimal map
        String IHaveWhiteSpaces = "I have white space, a tab\t and a newline\n";
        System.out.println(IHaveWhiteSpaces);
        System.out.println(IHaveWhiteSpaces.replaceAll("\\s", ".")); // \\s removes all space types
        System.out.println(IHaveWhiteSpaces.replaceAll("\\W", ".")); // \\W removes all space types
        System.out.println(IHaveWhiteSpaces.replaceAll("\\S", "-")); // \\S removes all non-space types
        System.out.println(IHaveWhiteSpaces.replaceAll("\\w", ".")); // \\w removes all alphanumeric types
        System.out.println(alphaNumeric.replaceAll("\\W", "."));
        System.out.println(alphaNumeric.replaceAll("\\w", "."));
        System.out.println(IHaveWhiteSpaces.replaceAll("[\t\n ]", "-"));
        System.out.println(IHaveWhiteSpaces.replaceAll("\\b", ".")); // Boundaries alpha numeric text groups
        System.out.println(alphaNumeric.replaceAll("\\b", "*")); // boundaries...
        // Quantifiers - pattern for multiples & repeating sequences {1}, +,
        String repeatingValuesString = "aaaabcdeee12344444xyzzz999.2424555";
        System.out.println(repeatingValuesString);
        System.out.println(repeatingValuesString.replaceAll("^a{2}", "*"));
        System.out.println(repeatingValuesString.replaceAll("a{3,5}", "-")); // the {3,5} means between 3-5 times
        System.out.println(repeatingValuesString.replaceAll("^a+", "*")); // the + means any number of repeats...
        String TooManySpaces = "I  have too    many spaces and need    to fix    it.";
        System.out.println(TooManySpaces);
        System.out.println(TooManySpaces.replaceAll(" +", " ")); // replace duplicated spaces with a single space
        System.out.println(repeatingValuesString.replaceAll("abcdx*", "-")); // the * means the previous value may not match

        StringBuilder htmlText = new StringBuilder("<h1>my HTML Text Heading</h1>");
        htmlText.append("<h2>This is my sub-heading html</h2>");
        htmlText.append("<p>This is my first paragraph in my html</p>");
        htmlText.append("<p>This is a completely different paragraph in my html</p>");
        htmlText.append("<h2>This is my summary section for my html</h2>");
        htmlText.append("<p>and this is my summary paragraph</p>");

        System.out.println(htmlText);
//        String  h2Pattern = "<h2>";
        String  h2Pattern = "(<h2>)"; // groups are indicated by the '(' && ')'
        Pattern pattern   = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
        matcher.reset();

        int count = 0;
        while(matcher.find())
        {
            count++;
            System.out.println("Occurence " + count + " ; " + matcher.start() + " to " + matcher.end());
        }


        String  h2GroupPattern = "(<h2>.*?</h2>)"; // groups are indicated by the '(' && ')'
        Pattern groupPattern   = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        matcher.reset();
        while(groupMatcher.find())
        {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }


        String  h2TextPattern = "(<h2>)(.*?)(</h2>)"; // groups are indicated by the '(' && ')'
        Pattern textPattern   = Pattern.compile(h2TextPattern);
        Matcher textMatcher = textPattern.matcher(htmlText);
        System.out.println(textMatcher.matches());
        matcher.reset();
        while(textMatcher.find())
        {
            System.out.print("Opening -: " + textMatcher.group(1));
            System.out.print(textMatcher.group(3) + " :-Closing\n");
            System.out.println("Text in the <h2> heading ==> " + textMatcher.group(2));
        }
    }
}
