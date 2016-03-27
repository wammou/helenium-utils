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

/**
 * @author Walid Ammou < w.ammou@helenium.org >
 */

public class StringUtils {
	
	/**
	 * Check if a string is null
	 * 
	 * @param pString String to check is null
	 * @return true if null, false else
	 */
	public boolean isNull(final String pString){
		
		return pString == null;
	}
	
	/**
	 * Check if a string is not null by the negation  of isNull method
	 * 
	 * @param pString String to check is not null
	 * @return true if not null, false else
	 */
	public boolean isNotNull(final String pString){
		
		return !isNotNull(pString);
	}
	
	/**
	 * Check if a string is not null and not empty
	 * 
	 * @param pString String to check
	 * @param pTrim if true, the string will be trimmed before performing the check of empty. If false, it well check if not null and not empty
	 * @return 
	 */
	public boolean isNotEmpty(final String pString, final boolean pTrim){
		
		if(pTrim){
			return isNotNull(pString) && !pString.trim().isEmpty();
		}
		
		return isNotNull(pString) && !pString.isEmpty();
	}
	
	

}
