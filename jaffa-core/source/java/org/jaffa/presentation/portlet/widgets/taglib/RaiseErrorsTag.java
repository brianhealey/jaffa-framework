/*
 * ====================================================================
 * JAFFA - Java Application Framework For All
 *
 * Copyright (C) 2002 JAFFA Development Group
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Redistribution and use of this software and associated documentation ("Software"),
 * with or without modification, are permitted provided that the following conditions are met:
 * 1.	Redistributions of source code must retain copyright statements and notices.
 *         Redistributions must also contain a copy of this document.
 * 2.	Redistributions in binary form must reproduce the above copyright notice,
 * 	this list of conditions and the following disclaimer in the documentation
 * 	and/or other materials provided with the distribution.
 * 3.	The name "JAFFA" must not be used to endorse or promote products derived from
 * 	this Software without prior written permission. For written permission,
 * 	please contact mail to: jaffagroup@yahoo.com.
 * 4.	Products derived from this Software may not be called "JAFFA" nor may "JAFFA"
 * 	appear in their names without prior written permission.
 * 5.	Due credit should be given to the JAFFA Project (http://jaffa.sourceforge.net).
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 */

package org.jaffa.presentation.portlet.widgets.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.jaffa.presentation.portlet.widgets.taglib.exceptions.OuterFormTagMissingRuntimeException;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
import java.util.Iterator;
import org.jaffa.presentation.portlet.widgets.taglib.exceptions.JspWriteRuntimeException;
import org.jaffa.presentation.portlet.FormBase;
import org.jaffa.util.MessageHelper;
import javax.servlet.http.HttpServletRequest;
import org.jaffa.util.StringHelper;

/** Tag Handler for the RaiseErrors tag.*/
public class RaiseErrorsTag extends CustomTag implements IFormTag {

    private static Logger log = Logger.getLogger(RaiseErrorsTag.class);
    private static final String TAG_NAME = "RaiseErrorsTag";

    /** Default constructor.
     */
    public RaiseErrorsTag() {
        super();
    }


    /**
     * This generates the HTML for the tag.
     * @throws JspException if any error occurs.
     */
    public void otherDoEndTagOperations() throws JspException {

        // Get the form bean from the page.
        FormBase form = TagHelper.getFormBase(pageContext);
        if(form == null) {
            String str = "The " + TAG_NAME + " should be inside a FormTag";
            log.error(str);
            throw new OuterFormTagMissingRuntimeException(str);
        }

        // get the errors from the form
        if ( form.hasErrors((HttpServletRequest) pageContext.getRequest()) ) {
            ActionMessages errors = form.getErrors((HttpServletRequest) pageContext.getRequest());
            StringBuffer buf = new StringBuffer();
            buf.append("<SCRIPT type=\"text/javascript\">");
            for (Iterator itr = errors.get(); itr.hasNext();) {
                ActionMessage error = (ActionMessage) itr.next();
                buf.append("addMessage(\"");
                //buf.append( RequestUtils.message(pageContext, null, null, error.getKey(), error.getValues() ) );
                String message = StringHelper.convertToHTML(MessageHelper.findMessage(pageContext, error.getKey(), error.getValues())) + 
                        TagHelper.getLabelEditorLink(pageContext, error.getKey());
                buf.append((message != null ? message : error.getKey()));
                buf.append("\");");
            }
            // delete the error so that it doesnt get re-displayed
            form.clearErrors((HttpServletRequest) pageContext.getRequest());
            buf.append("</SCRIPT>");

            try {
                JspWriter w = pageContext.getOut();
                w.print( buf.toString() );
            } catch (IOException e) {
                String str = "Exception in writing the " + TAG_NAME;
                log.error(str, e);
                throw new JspWriteRuntimeException(str, e);
            }
        }
    }

}
