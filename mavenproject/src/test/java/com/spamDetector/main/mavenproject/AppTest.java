package com.spamDetector.main.mavenproject;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void spamDetectorPositive() {
    	final SpamDetector sd = SpamDetector.of("sexy,nigeria,you've won,one million,sexi,has ganado,un millón", 0.25);
    	final String text1 ="The new tesla car is very sexi one million you've won sexy" ;
    	
        Assert.assertTrue(sd.check(text1));
        
    }
    @Test
    public void spamDetectorNegative() {
    	final SpamDetector sd = SpamDetector.of("sexy,nigeria,you've won,one million,sexi,has ganado,un millón", 0.25);
    	final String text2 ="sey";
    	Assert.assertFalse(sd.check(text2));
    }
}
