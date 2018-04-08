package com.frontend.widgets;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frontend.model.Config;
import com.frontend.service.ConfigService;


public class MainPreparer implements ViewPreparer {
	private static final Logger logger = LoggerFactory.getLogger(MainPreparer.class);
	@Autowired
	private ConfigService configService;
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		// TODO Auto-generated method stub
		logger.info("vao ham MainPreparer");
		
		String nameAppString = null;
		Config nameApp = configService.findByName("nameApp");
		if(nameApp != null) {
			nameAppString = nameApp.getContent();
		}
		attributeContext.putAttribute(
	            "nameApp",
	            new Attribute(nameAppString),true);
		
		String contentFooterString = null;
		Config contentFooter = configService.findByName("contentFooter");
		if(contentFooter != null) {
			contentFooterString = contentFooter.getContent();
		}
		attributeContext.putAttribute(
	            "contentFooter",
	            new Attribute(contentFooterString),true);
	}

}
