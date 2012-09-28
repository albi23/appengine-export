/*
 * $Id: RtfBasicElement.java 2996 2007-11-20 22:40:36Z hallm $
 * $Name$
 *
 * Copyright 2001, 2002, 2003, 2004 by Mark Hall
 *
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the License.
 *
 * The Original Code is 'iText, a free JAVA-PDF library'.
 *
 * The Initial Developer of the Original Code is Bruno Lowagie. Portions created by
 * the Initial Developer are Copyright (C) 1999, 2000, 2001, 2002 by Bruno Lowagie.
 * All Rights Reserved.
 * Co-Developer of the code is Paulo Soares. Portions created by the Co-Developer
 * are Copyright (C) 2000, 2001, 2002 by Paulo Soares. All Rights Reserved.
 *
 * Contributor(s): all the names of the contributors are added in the source code
 * where applicable.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * LGPL license (the ?GNU LIBRARY GENERAL PUBLIC LICENSE?), in which case the
 * provisions of LGPL are applicable instead of those above.  If you wish to
 * allow use of your version of this file only under the terms of the LGPL
 * License and not to allow others to use your version of this file under
 * the MPL, indicate your decision by deleting the provisions above and
 * replace them with the notice and other provisions required by the LGPL.
 * If you do not delete the provisions above, a recipient may use your version
 * of this file under either the MPL or the GNU LIBRARY GENERAL PUBLIC LICENSE.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the MPL as stated above or under the terms of the GNU
 * Library General Public License as published by the Free Software Foundation;
 * either version 2 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library general Public License for more
 * details.
 *
 * If you didn't download this code from the following link, you should check if
 * you aren't using an obsolete version:
 * http://www.lowagie.com/iText/
 */

package com.lowagie.text.rtf;

import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.rtf.document.RtfDocument;

/**
 * The RtfBasicElement interface defines the interface for elements that can
 * be added to the RtfWriter.
 *
 * @version $Id: RtfBasicElement.java 2996 2007-11-20 22:40:36Z hallm $
 * @author Mark Hall (mhall@edu.uni-klu.ac.at)
 * @author Thomas Bickel (tmb99@inode.at)
 */
public interface RtfBasicElement {
    /**
     * Constant for the beginning of a rtf group
     */
    public static final byte[] OPEN_GROUP = "{".getBytes();
    /**
     * Constant for the end of an rtf group
     */
    public static final byte[] CLOSE_GROUP = "}".getBytes();
    /**
     * Constant for a delimiter in rtf
     */
    public static final byte[] DELIMITER = " ".getBytes();
    /**
     * Constant for a comma delimiter in rtf
     */
    public static final byte[] COMMA_DELIMITER = ";".getBytes();
    /**
     * The factor to use for translating from iText to rtf measurments
     */
    public static final double TWIPS_FACTOR = 20;

    /**
     * Return the content of the Element in a byte array
     * 
     * @return The byte array containing the data
     * @deprecated As of iText 2.0.6 or earlier, replaced by
     * {@link #writeContent(OutputStream)}, scheduled for removal at or after 2.1.0
     */
    public byte[] write();
    
    /**
     * Writes the element content to the given output stream.
     * This method replaces the {@link #write()} method which is now deprecated. 
     * 
     * @param out
     */
    public void writeContent(OutputStream out) throws IOException;
    
    /**
     * Sets the RtfDocument this RtfElement belongs to
     * 
     * @param doc The RtfDocument to use
     */
    public void setRtfDocument(RtfDocument doc);
    
    /**
     * Sets whether this RtfBasicElement is in a table
     * 
     * @param inTable Whether this RtfBasicElement is in a table
     */
    public void setInTable(boolean inTable);
    
    /**
     * Sets whether this RtfBasicElement is in a header
     * 
     * @param inHeader Whether this RtfBasicElement is in a header
     */
    public void setInHeader(boolean inHeader);
}
