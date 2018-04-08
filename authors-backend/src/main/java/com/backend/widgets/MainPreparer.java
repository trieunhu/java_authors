package com.backend.widgets;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import com.backend.model.Config;
import com.backend.service.ConfigService;

public class MainPreparer implements ViewPreparer {
	@Autowired
	private ConfigService configService;
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		
		
		String nameAppString = "demo";
		Config nameApp = configService.findByName("nameApp");
		if(nameApp != null) {
			nameAppString = nameApp.getContent();
		}
		attributeContext.putAttribute(
	            "nameApp",
	            new Attribute(nameAppString),true);
	}

}
