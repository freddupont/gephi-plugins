/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fred
 */
public class RegexRef {
  private Pattern Ref;
  private static HashMap<String, String> regs = new HashMap<String, String>();

  public RegexRef() {
      regs = new HashMap<String, String>();
      regs.put("CNEPE", "[A-Z][0-9]{12}[ -]([A-Z]\\s)?");
      regs.put("CNEPE2", "[A-Z][0-9]{10}[ -]");
      regs.put("CNEPE3", "CNEPE[A-Z0-9]{4}[ -]?[A-Z0-9]{5}[ -]");
      regs.put("TEGG", "[0-9]{2}[ -]?C[ -]?[0-9]{3}[ -]?[0-9]{0,2}[ -]");
      regs.put("CSCT", "CSCT[ -]?[0-9]{8}[ -]");
      regs.put("ECE", "ECE[A-Z]{2}[0-9]{6}[ -]([A-Z]\\s)?");
      regs.put("nc", "E[A-Z]{3,5}[0-9]{5,6}[ -]([A-Z]\\s)?");
      regs.put("Site", "[A-Z]{3}[0-9]{2}[ -]?[A-Z][0-9]{9}[A-Z]{4}[ -]");
      regs.put("Site1", "[A-Z]{3}[0-9]{2}[A-Z][0-9]{2}[ -]?[0-9]{3}[ -]?[A-Z0-9][0-9]{3}[ -]?[A-Z]{4}[ -]([A-Z]\\s)?");
      
    //Ref = Pattern.compile("[A-Z]*3[0-9]*2[A-Z][0-9]*9");
    //Ref = Pattern.compile("[A-Z]{3}[0-9]{2}[A-Z][0-9]{2}[ -]?[0-9]{3}[ -]?[A-Z0-9][0-9]{3}[A-Z]{4}([ -][A-Z]\\s)?");

  }
  
  //todochange this function to return RegexMatch
  public List<String> getAllRef(String s) {
    List<String> links = new ArrayList<String>();

      for (String Key : regs.keySet()) {
          String value = regs.get(Key);
          Matcher m = Pattern.compile(value).matcher(s);
          while (m.find()) {
              String match=m.group();
              links.add(match.replaceAll("[ -]", ""));
              //todo space en - and remove them
              /*matcher.find();
              /String link = matcher.group().replace.replaceFirst("href=\"", "")
              .replaceFirst("\">", "")
              .replaceFirst("\"[\\s]?target=\"[a-zA-Z_0-9]*", "");
              if (valid(link)) {
              links.add(makeAbsolute(url, link));
              }
              */
          }
      }
      //todo remove duplicate
    return links;
  }
}
