/*
 * $HeadURL$
 * $Revision$
 * $Date$
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.cookie;

import java.util.Date;

/**
 * HTTP "magic-cookie" represents a piece of state information
 * that the HTTP agent and the target server can exchange to maintain 
 * a session.
 * 
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @since 4.0
 */
public interface Cookie {

    /**
     * Returns the name.
     *
     * @return String name The name
     */
    String getName();

    /**
     * Returns the value.
     *
     * @return String value The current value.
     */
    String getValue();

    /**
     * Returns the comment describing the purpose of this cookie, or
     * <tt>null</tt> if no such comment has been defined.
     * 
     * @return comment 
     *
     * @see #setComment(String)
     */
    String getComment();

    /**
     * If a user agent (web browser) presents this cookie to a user, the
     * cookie's purpose will be described using this comment.
     * 
     * @param comment
     *  
     * @see #getComment()
     */
    void setComment(String comment);

    /**
     * Returns the expiration {@link Date} of the cookie, or <tt>null</tt>
     * if none exists.
     * <p><strong>Note:</strong> the object returned by this method is 
     * considered immutable. Changing it (e.g. using setTime()) could result
     * in undefined behaviour. Do so at your peril. </p>
     * @return Expiration {@link Date}, or <tt>null</tt>.
     *
     * @see #setExpiryDate(java.util.Date)
     *
     */
    Date getExpiryDate();

    /**
     * Sets expiration date.
     * <p><strong>Note:</strong> the object returned by this method is considered
     * immutable. Changing it (e.g. using setTime()) could result in undefined 
     * behaviour. Do so at your peril.</p>
     *
     * @param expiryDate the {@link Date} after which this cookie is no longer valid.
     *
     * @see #getExpiryDate
     *
     */
    void setExpiryDate (Date expiryDate);


    /**
     * Returns <tt>false</tt> if the cookie should be discarded at the end
     * of the "session"; <tt>true</tt> otherwise.
     *
     * @return <tt>false</tt> if the cookie should be discarded at the end
     *         of the "session"; <tt>true</tt> otherwise
     */
    boolean isPersistent();


    /**
     * Returns domain attribute of the cookie.
     * 
     * @return the value of the domain attribute
     *
     * @see #setDomain(java.lang.String)
     */
    String getDomain();

    /**
     * Sets the domain attribute.
     * 
     * @param domain The value of the domain attribute
     *
     * @see #getDomain
     */
    void setDomain(String domain);


    /**
     * Returns the path attribute of the cookie
     * 
     * @return The value of the path attribute.
     * 
     * @see #setPath(java.lang.String)
     */
    String getPath();

    /**
     * Sets the path attribute.
     *
     * @param path The value of the path attribute
     *
     * @see #getPath
     *
     */
    void setPath(String path);

    /**
     * @return <code>true</code> if this cookie should only be sent over secure connections.
     * @see #setSecure(boolean)
     */
    boolean isSecure();

    /**
     * Sets the secure attribute of the cookie.
     * <p>
     * When <tt>true</tt> the cookie should only be sent
     * using a secure protocol (https).  This should only be set when
     * the cookie's originating server used a secure protocol to set the
     * cookie's value.
     *
     * @param secure The value of the secure attribute
     * 
     * @see #isSecure()
     */
    void setSecure (boolean secure);

    /**
     * Returns the version of the cookie specification to which this
     * cookie conforms.
     *
     * @return the version of the cookie.
     * 
     * @see #setVersion(int)
     *
     */
    int getVersion();

    /**
     * Sets the version of the cookie specification to which this
     * cookie conforms. 
     *
     * @param version the version of the cookie.
     * 
     * @see #getVersion
     */
    void setVersion(int version);

    /**
     * Returns true if this cookie has expired.
     * @param date Current time
     * 
     * @return <tt>true</tt> if the cookie has expired.
     */
    boolean isExpired(final Date date);

    /**
     * Indicates whether the cookie had a path specified in a 
     * path attribute of the <tt>Set-Cookie</tt> header. This value
     * is important for generating the <tt>Cookie</tt> header because 
     * some cookie specifications require that the <tt>Cookie</tt> header 
     * should only include a path attribute if the cookie's path 
     * was specified in the <tt>Set-Cookie</tt> header.
     *
     * @param value <tt>true</tt> if the cookie's path was explicitly 
     * set, <tt>false</tt> otherwise.
     * 
     * @see #isPathAttributeSpecified
     */
    public void setPathAttributeSpecified(boolean value);

    /**
     * Returns <tt>true</tt> if cookie's path was set via a path attribute
     * in the <tt>Set-Cookie</tt> header.
     *
     * @return value <tt>true</tt> if the cookie's path was explicitly 
     * set, <tt>false</tt> otherwise.
     * 
     * @see #setPathAttributeSpecified
     */
    boolean isPathAttributeSpecified();

    /**
     * Indicates whether the cookie had a domain specified in a 
     * domain attribute of the <tt>Set-Cookie</tt> header. This value
     * is important for generating the <tt>Cookie</tt> header because 
     * some cookie specifications require that the <tt>Cookie</tt> header 
     * should only include a domain attribute if the cookie's domain 
     * was specified in the <tt>Set-Cookie</tt> header.
     *
     * @param value <tt>true</tt> if the cookie's domain was explicitly 
     * set, <tt>false</tt> otherwise.
     *
     * @see #isDomainAttributeSpecified
     */
    void setDomainAttributeSpecified(boolean value);

    /**
     * Returns <tt>true</tt> if cookie's domain was set via a domain 
     * attribute in the <tt>Set-Cookie</tt> header.
     *
     * @return value <tt>true</tt> if the cookie's domain was explicitly 
     * set, <tt>false</tt> otherwise.
     *
     * @see #setDomainAttributeSpecified
     */
    boolean isDomainAttributeSpecified();

}

