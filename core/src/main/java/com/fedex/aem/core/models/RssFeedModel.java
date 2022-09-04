
package com.fedex.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
 
import javax.inject.Inject;
 
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class RssFeedModel {
 
    @Inject
    private String title;
 
    public String getTitle() {
        return title;
    }
    
    @Inject
    private String description;
 
    public String getDescription() {
        return description;
    }
    
    @Inject
    private String pubdate;
 
    public String getPubdate() {
        return pubdate;
    }
 
}