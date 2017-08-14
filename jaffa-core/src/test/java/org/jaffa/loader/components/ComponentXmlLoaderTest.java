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

package org.jaffa.loader.components;

import org.jaffa.loader.IRepository;
import org.jaffa.presentation.portlet.component.ComponentDefinition;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * ComponentXmlLoaderTest - Verifies the Component beans can be loaded from the
 * ComponentManager implementation.
 */
public class ComponentXmlLoaderTest {


    private static AnnotationConfigApplicationContext xmlLoaderConfig =
            new AnnotationConfigApplicationContext(ComponentXmlLoaderTestConfig.class);

    /**
     * Test loading the XML config via the ComponentManager.
     * (Assumes a certain components file with particular values in
     * jaffa-framework/jaffa-core/target/test-classes/META-INF/components.xml)
     */
    @Test
    public void testXmlLoad() {
        ComponentManager componentManager =
                xmlLoaderConfig.getBean(ComponentManager.class);
        assertNull(componentManager.getComponentDefinition(null, null));
        assertNull(componentManager.getComponentDefinition("", null));

        IRepository<String, ComponentDefinition> repository =
                componentManager.getComponentRepository();
        List<ComponentDefinition> values = repository.getAllValues(null);
        assertEquals(4, values.size());

        Set<String> keys = repository.getAllKeys();
        String rolesEditorKey = "Jaffa.Admin.RolesEditor";
        assertTrue(keys.contains(rolesEditorKey));
        String testFunctionViewerKey = "Jaffa.UnitTest.TestFunctionViewer";
        assertTrue(keys.contains(testFunctionViewerKey));

        ComponentDefinition reComponentDefinition =
                componentManager.getComponentDefinition(rolesEditorKey, null);
        String reType = reComponentDefinition.getComponentType();
        assertEquals("Custom", reType);
        String[] optionals = reComponentDefinition.getOptionalFunctions();
        assertEquals(0, optionals.length);
        assertNull(reComponentDefinition.getParameters());
    }

 }
