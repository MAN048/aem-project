package com.fedex.aem.core.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.sling.api.resource.Resource;


@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class RssModelTest {

    private RssModel rss;
    Resource jsonResource;
    
    private final AemContext aemContext=new AemContext();
    
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(RssModel.class);
        aemContext.load().json("/com/fedex/aem/core/models/rssfeed.json","/content");
        jsonResource = aemContext.currentResource("/content/rssfeed");
        rss=jsonResource.adaptTo(RssModel.class);
        
    }

    @Test
    void getUrl() {
        final String expected="https://sports.ndtv.com/rss/cricket";
        String actual= rss.getUrl();
        assertEquals(expected,actual);
    }
    
    @Test
    void getCount() {
        final String expected="5";
        String actual= rss.getCount();
        assertEquals(expected,actual);
    }
    
    @Test
    void isConfigured() {
        final boolean expected=false;
        boolean actual= rss.isConfigured();
        assertEquals(expected,actual);
    }

    

}
