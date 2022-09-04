package com.fedex.aem.core.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.sling.api.resource.Resource;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
class RssFeedModelTest {

	private RssFeedModel rss;
	Resource jsonResource;

	private final AemContext aemContext = new AemContext();

	@BeforeEach
	void setUp() {
		aemContext.addModelsForClasses(RssFeedModel.class);
		aemContext.load().json("/com/fedex/aem/core/models/rssfeedmanual.json", "/content");
		jsonResource = aemContext.currentResource("/content/rssfeed");
		rss = jsonResource.adaptTo(RssFeedModel.class);

	}

	@Test
	void getTitle() {
		final String expected = "Rain";
		String actual = rss.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getDescription() {
		final String expected = "rainy day";
		String actual = rss.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	void getPubdate() {
		final String expected = "01/09/2000";
		String actual = rss.getPubdate();
		assertEquals(expected, actual);
	}
}