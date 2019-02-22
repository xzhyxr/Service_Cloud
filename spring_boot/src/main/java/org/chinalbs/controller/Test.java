package org.chinalbs.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class Test {
	public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = charArray.length - 1; i >= 0; i--)
        {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
	
	public int reverse(int x) {
        String str = String.valueOf(x);
        char[] charArray = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        
        int size = 0;
        if ("-".equals(String.valueOf(charArray[0]))) {
        	sb.append("-");
        	size = 1;
        }
        for (int i = charArray.length - 1; i >= size; i--)
        {
            sb.append(charArray[i]);
        }
        
        try {
			return Integer.parseInt(sb.toString());
		} catch (Exception e) {
			return 0;
		}
    }
	
	public boolean isAnagram(String s, String t) {
        if (null == s || null == t) {
        	return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        if (s.equals(t)) {
        	return true;
        }
        if (s.length() != t.length()) {
        	return false;
        }
        char[] sArray = s.toCharArray();
        List<String> sList = new ArrayList<String>();
        for (int i = 0; i < sArray.length; i++) {
        	sList.add(String.valueOf(sArray[i]));
        }
        char[] tArray = t.toCharArray();
        for (int i = 0; i < tArray.length; i++) {
        	if (!sList.contains(String.valueOf(tArray[i]))) {
        		return false;
        	}
        	sList.remove(String.valueOf(tArray[i]));
        }
        return true;
    }

	public boolean isPalindrome(String s) {
        if (null == s) {
        	return false;
        }
        
        if ("".equals(s)) {
        	return true;
        }
        
        char[] sArray = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sArray.length; i++) {
        	String str = String.valueOf(sArray[i]);
        	if (str.matches("\\w|\\d")) {
        		sb.append(String.valueOf(sArray[i]));
        	}
        }
        
        String result = sb.toString();
        
        return result.equalsIgnoreCase(sb.reverse().toString());
    }
	
	public int myAtoi(String str) {
        if (null == str) {
        	return 0;
        }
        str = str.trim();
        if ("".equals(str)) {
        	return 0;
        }
        
        String first = str.substring(0, 1);
        if (!"-".equals(first) && !"+".equals(first) && !first.matches("\\d")) {
        	return 0;
        }
        
        char[] sArray = str.toCharArray();
        StringBuffer sb = new StringBuffer(first);
        for (int i = 1; i < sArray.length; i++) {
        	String s = String.valueOf(sArray[i]);
        	if (!s.matches("\\d")) {
        		break;
        	}
        	sb.append(String.valueOf(sArray[i]));
        }
        
        if ("-".equals(sb.toString()) || "+".equals(sb.toString())) {
        	return 0;
        }
        
        try {
			return Integer.parseInt(sb.toString());
		} catch (Exception e) {
			if ("-".equals(first)) {
	        	return Integer.MIN_VALUE;
	        } else {
	        	return Integer.MAX_VALUE;
	        }
		}
    }
	
	public int uniqueMorseRepresentations(String[] words) {
		if (words.length > 100) {
			return 0;
		}
        Map<String, String> mosCodeMap = new HashMap<String, String>();
        mosCodeMap.put("a", ".-");
        mosCodeMap.put("b", "-...");
        mosCodeMap.put("c", "-.-.");
        mosCodeMap.put("d", "-..");
        mosCodeMap.put("e", ".");
        mosCodeMap.put("f", "..-.");
        mosCodeMap.put("g", "--.");
        mosCodeMap.put("h", "....");
        mosCodeMap.put("i", "..");
        mosCodeMap.put("j", ".---");
        mosCodeMap.put("k", "-.-");
        mosCodeMap.put("l", ".-..");
        mosCodeMap.put("m", "--");
        mosCodeMap.put("n", "-.");
        mosCodeMap.put("o", "---");
        mosCodeMap.put("p", ".--.");
        mosCodeMap.put("q", "--.-");
        mosCodeMap.put("r", ".-.");
        mosCodeMap.put("s", "...");
        mosCodeMap.put("t", "-");
        mosCodeMap.put("u", "..-");
        mosCodeMap.put("v", "...-");
        mosCodeMap.put("w", ".--");
        mosCodeMap.put("x", "-..-");
        mosCodeMap.put("y", "-.--");
        mosCodeMap.put("z", "--..");
        
        Set<String> results = new HashSet<String>();
        for (String word : words) {
        	if (word == null || "".equals(word) || word.length() > 12) {
        		continue;
        	}
        	
        	StringBuffer sb = new StringBuffer("");
        	for (int i = 0; i < word.length(); i++) {
        		String str = word.substring(i, i+1);
        		String mosCode = mosCodeMap.get(str);
        		if (mosCode == null || "".equals(mosCode)) {
        			break;
        		}
        		sb.append(mosCode);
        	}
        	if (!"".equals(sb.toString())) {
        		results.add(sb.toString());
        	}
        }
        
        return results.size();
    }
	
	private int count = 0;
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int [][] test = new int[R * C][2];
		
		if (R < 1 || R > 100) {
			return test;
		}
		if (C < 1 || C > 100) {
			return test;
		}
		if (r0 < 0 || r0 >= R) {
			return test;
		}
		if (c0 < 0 || c0 >= C) {
			return test;
		}
		
		int size = 1;
		while (count < R * C) {
			for (int i = 0; i < size; i++) {
				deal(R, C, r0, c0, test);
				c0 = c0 + 1;
			}
			
			for (int i = 0; i < size; i++) {
				deal(R, C, r0, c0, test);
				r0 = r0 + 1;
			}
			size++;
			
			for (int i = 0; i < size; i++) {
				deal(R, C, r0, c0, test);
				c0 = c0 - 1;
			}
			
			for (int i = 0; i < size; i++) {
				deal(R, C, r0, c0, test);
				r0 = r0 - 1;
			}
			size++;
		}
		
		return test;
    }

	private void deal(int R, int C, int r0, int c0, int[][] test) {
		if (c0 >= 0 && c0 < C && r0 >= 0 && r0 < R) {
			test[count][0] = r0;
			test[count][1] = c0;
			count++;
		}
	}
	
	public int flipgame(int[] fronts, int[] backs) {
		int frontsLength = fronts.length;
		int backsLength = backs.length;
        if (frontsLength != backsLength) {
        	return 0;
        }
        
        if (frontsLength < 1 || frontsLength > 1000) {
        	return 0;
        }
        
        for (int i = 0; i < frontsLength; i++) {
        	if (fronts[i] < 1 || fronts[i] > 2000) {
        		return 0;
        	}
        }
        
        for (int i = 0; i < backsLength; i++) {
        	if (backs[i] < 1 || backs[i] > 2000) {
        		return 0;
        	}
        }
        
        int result = -1;
        
        // 不翻转
        result = calc(fronts, backs, result);
        
        
        
        return result;
    }

	private int calc(int[] fronts, int[] backs, int result) {
		for (int i = 0; i < backs.length; i++) {
        	boolean isEquals = false;
        	for (int j = 0; j < fronts.length; j++) {
        		if (backs[i] == fronts[j]) {
        			isEquals = true;
        			break;
        		}
        	}
        	
        	if (!isEquals) {
        		if (result == -1 || backs[i] < result) {
        			result = backs[i];
        		} 
        	}
        }
		return result;
	}

	public static void main(String[] args) {
		Test t = new Test();
		int[][] results = t.spiralMatrixIII(5,6,1,4);
		
		for (int[] result : results) {
			System.out.println(result[0] + "," + result[1]);
		}
		
	}
}
