package com.tmb.pageFactory;

import com.tmb.driver.DriverManager;

public abstract class Page {

	public Page() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

}
