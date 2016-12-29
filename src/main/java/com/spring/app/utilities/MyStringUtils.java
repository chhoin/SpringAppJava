package com.spring.app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author kimchhoin.sok
 *
 */
public class MyStringUtils {
	public static Logger logger = LoggerFactory.getLogger(MyStringUtils.class);
	  public static String LIST_SEPARATOR_COMMA = ",";
	  public static String LIST_SEPARATOR_SLASH = "/";
	  public static final String[] EMPTY_ARRAY = new String[0];
	  private static final String FOLDER_SEPARATOR = "/";
	  private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

	  public static String[] removeDuplicateStrings(String[] array)
	  {
	    if (isEmpty(array)) {
	      return array;
	    }
	    Set set = new TreeSet();
	    set.addAll(Arrays.asList(array));
	    return toStringArray(set);
	  }

	  public static Set<String> splitStringByCommaToSet(String s) {
	    return splitStringToSet(s, ',');
	  }

	  public static String[] splitStringByCommaToArray(String s) {
	    return splitStringToArray(s, ',');
	  }

	  public static Set<String> splitStringToSet(String s, char c) {
	    char[] chars = s.toCharArray();
	    int count = 1;
	    for (char x : chars) {
	      if (x == c) {
	        ++count;
	      }
	    }

	    Object result = new HashSet(count);
	    int len = chars.length;
	    int k = 0;
	    int pos = 0;
	    for (; pos < len; ++pos) {
	      if (chars[pos] == c) {
	        int size = pos - k;
	        if (size > 0) {
	          ((Set)result).add(new String(chars, k, size));
	        }
	        k = pos + 1;
	      }
	    }
	    int size = pos - k;
	    if (size > 0) {
	      ((Set)result).add(new String(chars, k, size));
	    }
	    return ((Set<String>)result);
	  }

	  public static String[] splitStringToArray(CharSequence s, char c) {
	    if ((s == null) || (s.length() == 0)) {
	      return EMPTY_ARRAY;
	    }
	    int count = 1;
	    for (int i = 0; i < s.length(); ++i) {
	      if (s.charAt(i) == c) {
	        ++count;
	      }
	    }
	    String[] result = new String[count];
	    StringBuilder builder = new StringBuilder();
	    int res = 0;
	    for (int i = 0; i < s.length(); ++i) {
	      if (s.charAt(i) == c) {
	        if (builder.length() > 0) {
	          result[(res++)] = builder.toString();
	          builder.setLength(0);
	        }
	      }
	      else {
	        builder.append(s.charAt(i));
	      }
	    }
	    if (builder.length() > 0) {
	      result[(res++)] = builder.toString();
	    }
	    if (res != count)
	    {
	      String[] result1 = new String[res];
	      System.arraycopy(result, 0, result1, 0, res);
	      return result1;
	    }
	    return result;
	  }

	  public static String[] toStringArray(Collection<String> collection)
	  {
	    if (collection == null) {
	      return null;
	    }
	    return ((String[])collection.toArray(new String[collection.size()]));
	  }

	  public static String[] split(String toSplit, String delimiter)
	  {
	    if ((!(hasLength(toSplit))) || (!(hasLength(delimiter)))) {
	      return null;
	    }
	    int offset = toSplit.indexOf(delimiter);
	    if (offset < 0) {
	      return null;
	    }
	    String beforeDelimiter = toSplit.substring(0, offset);
	    String afterDelimiter = toSplit.substring(offset + delimiter.length());
	    return new String[] { beforeDelimiter, afterDelimiter };
	  }

	  public static boolean isEmpty(CharSequence str)
	  {
	    return (!(hasLength(str)));
	  }

	  private static boolean isEmpty(Object[] array)
	  {
	    return ((array == null) || (array.length == 0));
	  }

	  public static String trimAllWhitespace(String str)
	  {
	    if (!(hasLength(str))) {
	      return str;
	    }
	    StringBuilder sb = new StringBuilder(str);
	    int index = 0;
	    while (sb.length() > index) {
	      if (Character.isWhitespace(sb.charAt(index))) {
	        sb.deleteCharAt(index);
	      }
	      ++index;
	    }

	    return sb.toString();
	  }

	  public static boolean hasLength(String str)
	  {
	    return hasLength(str);
	  }

	  public static boolean hasLength(CharSequence str)
	  {
	    return ((str != null) && (str.length() > 0));
	  }

	  public static String upperCaseFirst(String value)
	  {
	    char[] array = value.toCharArray();

	    array[0] = Character.toUpperCase(array[0]);

	    return new String(array);
	  }

	  public static List<Long> getValuesLong(String srcValues)
	  {
	    return getValuesLong(srcValues, LIST_SEPARATOR_COMMA);
	  }

	  public static List<Integer> getValuesInt(String srcValues)
	  {
	    return getValuesInt(srcValues, LIST_SEPARATOR_COMMA);
	  }

	  public static List<Long> getValuesLong(String srcValues, String sep)
	  {
	    List lstIds = new ArrayList();
	    if (srcValues == null) {
	      return lstIds;
	    }

	    String sepString = null;
	    if (StringUtils.isEmpty(sep))
	      sepString = LIST_SEPARATOR_COMMA;
	    else {
	      sepString = sep;
	    }

	    String[] values = srcValues.replace(" ", "").split(sepString);
	    for (String val : values) {
	      Long nb = Long.valueOf(0L);
	      try {
	        nb = Long.valueOf(val);
	        if (nb.longValue() > 0L) {
	          lstIds.add(nb);
	        }
	        else
	          logger.warn(new StringBuilder().append("The string [").append(srcValues).append("] shall contains a list of Long (> 0) separated by \",\". Check in the Application Advanced Configuration.").toString());
	      }
	      catch (Exception e)
	      {
	        logger.warn(new StringBuilder().append("The string [").append(srcValues).append("] shall contains a list of Long (> 0) separated by \",\". Check in the Application Advanced Configuration.").toString());
	      }
	    }
	    return lstIds;
	  }

	  public static List<Integer> getValuesInt(String srcValues, String sep)
	  {
	    List lstIds = new ArrayList();
	    if (srcValues == null) {
	      return lstIds;
	    }

	    String sepString = null;
	    if (StringUtils.isEmpty(sep))
	      sepString = LIST_SEPARATOR_COMMA;
	    else {
	      sepString = sep;
	    }

	    String[] values = srcValues.replace(" ", "").split(sepString);
	    for (String val : values) {
	      Integer nb = Integer.valueOf(0);
	      try {
	        nb = Integer.valueOf(val);
	        if (nb.intValue() > 0) {
	          lstIds.add(nb);
	        }
	        else
	          logger.warn(new StringBuilder().append("The string [").append(srcValues).append("] shall contains a list of Integer (> 0) separated by \",\". Check in the Application Advanced Configuration.").toString());
	      }
	      catch (Exception e)
	      {
	        logger.warn(new StringBuilder().append("The string [").append(srcValues).append("] shall contains a list of Integer (> 0) separated by \",\". Check in the Application Advanced Configuration.").toString());
	      }
	    }
	    return lstIds;
	  }

	  public static boolean hasUppercase(String str)
	  {
	    return (!(str.equals(str.toLowerCase())));
	  }

	  public static boolean hasLowercase(String str)
	  {
	    return (!(str.equals(str.toUpperCase())));
	  }

	  public static boolean hasNumeric(String str)
	  {
	    return str.matches(".*\\d.*");
	  }
}
