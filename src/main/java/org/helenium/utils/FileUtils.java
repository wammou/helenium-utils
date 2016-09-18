/** The sms-commander project is initiated to provide a common reusable Java utils classes.
 *   Copyright (C) 2016 The sms-commander Authors.

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Walid Ammou < w.ammou@helenium.org >
 */

public class FileUtils {

	private final static Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * Utility class, do not instanciate
	 */
	private FileUtils(){

	}

	/**
	 * Load properties of a properties file
	 *
	 * @param pFilePath Path to file
	 * @return Properties of the file
	 */
	public static Properties loadPropertiesOfFile(final String pFilePath){

		FileInputStream fis =null;
		final Properties properties = new Properties();

		try {
			fis = new FileInputStream(pFilePath);
			properties.load(fis);

		} catch (final FileNotFoundException pE) {
			LOGGER.error("File not found: " +  pFilePath, pE);
		} catch (final IOException pE) {
			LOGGER.error("Error while loading file's properties", pE);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (final IOException pE) {
					LOGGER.error("Error while closing the file" + pFilePath, pE);
				}
			}
		}

		return properties;
	}

}
