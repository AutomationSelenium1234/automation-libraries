package com.tmb.pageFactory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public final class DefaultElementLocatorFactory implements ElementLocatorFactory {
  private final SearchContext searchContext;

  public DefaultElementLocatorFactory(SearchContext searchContext) {
    this.searchContext = searchContext;
  }

  public ElementLocator createLocator(Field field) {
    return new DefaultElementLocator(searchContext, field);
  }
}
