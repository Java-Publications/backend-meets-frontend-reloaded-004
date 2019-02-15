package org.rapidpm.vaadin.v10.issuetracker.services;

import java.util.List;
import java.util.Locale;

import org.rapidpm.dependencies.core.logger.HasLogger;
import com.vaadin.flow.i18n.I18NProvider;

public class I18NProviderImpl02 implements I18NProvider, HasLogger {

  public I18NProviderImpl02() {
    logger().info("I18NProviderImpl02 was found..");
  }


  private final ResourceBundleService resourceBundleService = new ResourceBundleService();

  @Override
  public List<Locale> getProvidedLocales() {
    logger().info("getProvidedLocales.. ");
    return resourceBundleService
        .providedLocalesAsList();
  }

  @Override
  public String getTranslation(String key , Locale locale , Object... params) {
    logger().info("VaadinI18NProvider getTranslation.. key : " + key + " - " + locale);
    return resourceBundleService
        .resourceBundleToUse()
        .apply(locale)
        .getString(key);
  }
}