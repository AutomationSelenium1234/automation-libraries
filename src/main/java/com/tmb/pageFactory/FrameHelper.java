package com.tmb.pageFactory;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.driver.DriverManager;

import com.tmb.annotations.IFrame;
import com.tmb.annotations.IFrames;

public class FrameHelper 
{
    public static void switchToFrame(final Field field) {
        if (field != null) {
//        	BaseUtils.getInstance().getDriver().manage().timeouts().setScriptTimeout(3, TimeUnit.MILLISECONDS);
        	DriverManager.getDriver().switchTo().defaultContent();
             if (field.getAnnotation(IFrames.class) != null) {
                final IFrames iframes = field.getAnnotation(IFrames.class);
                final IFrame[] frames = iframes.value();
                if (frames.length > 0) {
                    for (final IFrame eachFrame : frames) {
                        if (!ignoreIframe(eachFrame)) {
                            if (StringUtils.isNotBlank((CharSequence)eachFrame.xpath())) {
                                final WebElement frameElement = DriverManager.getDriver().findElement(By.xpath(eachFrame.xpath()));
                                DriverManager.getDriver().switchTo().frame(frameElement);
                            }
                            else if (StringUtils.isNotBlank((CharSequence)eachFrame.name())) {
                            	DriverManager.getDriver().switchTo().frame(eachFrame.name());
                            }
                        }
                    }
                }
            }
        }
//      getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(getParameter("implicitlyWaitTime","60")), TimeUnit.SECONDS);
        
    }
    
    private static boolean ignoreIframe(final IFrame frame) {
        final String frameToIgnore = ""; //TestCache.getFrameToIgnore(); getParameter("frameToIgnore", "");
        if (frameToIgnore != null) {
            final String[] attrToIgnore = frameToIgnore.split(":");
            if (attrToIgnore.length != 2) {
                return false;
            }
            if (frame.name() != null && attrToIgnore[0].equals("name") && frame.name().contains(attrToIgnore[1])) {
                return true;
            }
            if (frame.xpath() != null && attrToIgnore[0].equals("xpath") && frame.xpath().contains(attrToIgnore[1])) {
                return true;
            }
            final String[] attributes;
            final String[] attrs = attributes = frame.attributes();
            for (final String each : attributes) {
                try {
                    final String[] attPair = each.split("=");
                    if (attrToIgnore[0].equals(attPair[0].trim()) && attPair[1].trim().contains(attrToIgnore[1])) {
                        return true;
                    }
                }
                catch (Exception e) {}
            }
        }
        return false;
    }
}
