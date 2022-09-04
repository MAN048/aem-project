
package com.fedex.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
 
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class RssModel {
 
    @Inject
    private String url;
 
    @Inject
    private String count;
 
    @Inject
    @Named("multifield/.")
    private List<RssFeedModel> bulletPointList;
 
    public String getUrl() {
        return url;
    }
 
    public String getCount() {
        return count;
    }
 
    public List<RssFeedModel> getBulletPointList() {
        return bulletPointList;
    }
 
    public boolean isConfigured() {
        return bulletPointList != null && !bulletPointList.isEmpty();
    }
 
}