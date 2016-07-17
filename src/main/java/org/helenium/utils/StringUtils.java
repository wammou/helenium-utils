/** The helenium-utils project is initiated to provide a common reusable Java utils classes.
*   Copyright (C) 2016 The helenium-utils Authors.

*   This program is free software; you can redistribute it and/or modify 
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation; either version 3 of the License, or 
*   (at your option) any later version.

*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.

*   You should have received a copy of the GNU General Public License
*   along with this program; if not, see <http://www.gnu.org/licenses/>
*   or write to the Free Software Foundation, Inc., 51 Franklin Street, 
*   Fifth Floor, Boston, MA 02110-1301  USA
*/

package org.helenium.utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Walid Ammou < w.ammou@helenium.org >
 */

public class StringUtils {
	
	/**
	 * Utility class, do not instaciate
	 */
	private StringUtils(){

	}
	
	/**
	 * Check if a string is null
	 * 
	 * @param pString String to check is null
	 * @return true if null, false else
	 */
	public static boolean isNull(final String pString){
		
		return pString == null;
	}
	
	/**
	 * Check if a string is not null by the negation  of isNull method
	 * 
	 * @param pString String to check is not null
	 * @return true if not null, false else
	 */
	public static boolean isNotNull(final String pString){
		
		return !isNotNull(pString);
	}
	
	/**
	 * Check if a string is not null and empty
	 * 
	 * @param pString String to check
	 * @param pTrim if true, the string will be trimmed before performing the check of empty. If false, it well check if not null and empty
	 * @return true if empty, false else
	 */
	public static boolean isEmpty(final String pString, final boolean pTrim){
		
		if(pTrim){
			return isNotNull(pString) && !pString.trim().isEmpty();
		}
		
		return isNotNull(pString) && !pString.isEmpty();
	}
	
	/**
	 * Check if a string is not null and not empty
	 * 
	 * @param pString String to check
	 * @param pTrim if true, the string will be trimmed before performing the check of empty. If false, it well check if not null and not empty
	 * @return true if not empty, false else
	 */
	public static boolean isNotEmpty(final String pString, final boolean pTrim){
		
		return !isEmpty(pString, pTrim);
	}
	
	/**
	 *  Count the number of occurrences of a character in the string
	 *  
	 * @param pString String to loop
	 * @param pCharacter Character to which count number of occurrences
	 * @return number of occurrences in the string
	 */
	public static int countOccurrences(String pString, char pCharacter){
		
		int count = 0;
	    for (int i=0; i < pString.length(); i++){
	        if (pString.charAt(i) == pCharacter){
	             count++;
	        }
	    }
	    return count;
	}
	
	/**
	 * Reverse the order of string characters
	 * 
	 * @param pString String to reverse
	 * @return reversed string
	 */
	public static String reverse(final String pString){
		
		return new StringBuffer(pString).reverse().toString();
	}
	
	/**
     * Extract a sub-string via a regular expression.
     * 
     * @param pString String from which extract the sub-string
     * @param pRegExp Regular expression
     * @return Sub-string corresponding to the regular expression
     */
    public static String extract(final String pString, final String pRegExp) {
        final Pattern pattern = Pattern.compile(pRegExp);
        final Matcher matcher = pattern.matcher(pString);
        String result;
        if (matcher.find()) {
            result = matcher.group();
        } else {
            result = "";
        }
        return result;
    }
    
    /**
     * Transform a string that may contains Accents to another version without Accents
     * 
     * @param pString String to transform
     * @return Transformed string
     **/
    public static String withoutAccent(final String pString) {
    	
        return Normalizer.normalize(pString, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
    }
    
    /**
     *  truncation a string to create a string with fixed length
     * 
     * @param pString String to truncate
     * @param pLength Length of resulting string
     * @param pCharacter Character of truncation
     * @return String truncated string
     */
    public static String truncate(final String pString, final int pLength, final char pCharacter) {

        // If the string is null or empty
        if (pString == null || pString.isEmpty()) {
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < pLength; i++) {
                sb.append(pCharacter);
            }
            return sb.toString();
        }
        // If the string's length is lower than expected
        if (pString.length() < pLength) {
            final StringBuffer sb = new StringBuffer();
            sb.append(pString);
            int sbLength;
            for (sbLength = sb.length(); sbLength <= pLength; sbLength++) {
                sb.append(pCharacter);
            }
            return sb.toString();
        }
        // If the string's length is equal to what expected
        if (pString.length() == pLength) {
            final StringBuffer sb = new StringBuffer();
            sb.append(pString);
            return sb.toString();
        } else {
            // If the string's length is higher than what expected
            final StringBuffer sb = new StringBuffer();
            final String truncatedString = pString.substring(0, pLength);
            sb.append(truncatedString);
            return sb.toString();
        }
    }


}
