/*
  Copyright (C) 2009 Volker Berlin (i-net software)

  This software is provided 'as-is', without any express or implied
  warranty.  In no event will the authors be held liable for any damages
  arising from the use of this software.

  Permission is granted to anyone to use this software for any purpose,
  including commercial applications, and to alter it and redistribute it
  freely, subject to the following restrictions:

  1. The origin of this software must not be misrepresented; you must not
     claim that you wrote the original software. If you use this software
     in a product, an acknowledgment in the product documentation would be
     appreciated but is not required.
  2. Altered source versions must be plainly marked as such, and must not be
     misrepresented as being the original software.
  3. This notice may not be removed or altered from any source distribution.

  Jeroen Frijters
  jeroen@frijters.net
  
 */
package java_.awt;

import java.awt.*;

import junit.ikvm.ReferenceData;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author Volker Berlin
 */
public class WindowTest{

    protected static ReferenceData reference;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        reference = new ReferenceData();
    }


    @AfterClass
    public static void tearDownAfterClass() throws Exception{
        if(reference != null){
            reference.save();
        }
    }


    protected Window createWindow(){
        return new Window((Window)null);
    }


    @Test
    public void getBackground(){
        Window window = createWindow();
        window.addNotify();
        Color color = window.getBackground();
        assertNotNull(window.getPeer());
        window.dispose();
        assertNull(window.getPeer());
        reference.assertEquals("getBackground", color);

        window = createWindow();
        window.setBackground(Color.RED);
        window.addNotify();
        assertEquals(Color.RED, window.getBackground());
        window.dispose();
    }


    @Test
    public void getForeground(){
        Window window = createWindow();
        window.addNotify();
        Color color = window.getForeground();
        window.dispose();
        reference.assertEquals("getForeground", color);

        window = createWindow();
        window.setForeground(Color.RED);
        window.addNotify();
        assertEquals(Color.RED, window.getForeground());
        window.dispose();
    }


    @Test
    public void getFont(){
        Window window = createWindow();
        window.addNotify();
        Font font = window.getFont();
        window.dispose();
        reference.assertEquals("getFont", font);

        font = new Font("Arial", 0, 13);
        window = createWindow();
        window.setFont(font);
        window.addNotify();
        assertEquals(font, window.getFont());
        window.dispose();
    }

}