package org.rapidpm.vaadin.v10.issuetracker.services;

import static java.util.Locale.ENGLISH;
import static java.util.Locale.GERMAN;
import static java.util.ResourceBundle.getBundle;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.rapidpm.dependencies.core.logger.HasLogger;
import com.vaadin.flow.i18n.I18NProvider;

public class I18NProviderImpl01 implements I18NProvider, HasLogger {

  public I18NProviderImpl01() {
    logger().info("I18NProviderImpl01 was found..");
  }

  public static final String RESOURCE_BUNDLE_NAME = "labels";

  private static final ResourceBundle RESOURCE_BUNDLE_EN = getBundle(RESOURCE_BUNDLE_NAME , ENGLISH);
  private static final ResourceBundle RESOURCE_BUNDLE_DE = getBundle(RESOURCE_BUNDLE_NAME , GERMAN);

  private static final List<Locale> LOCALES = List.of(ENGLISH ,
                                                      GERMAN);

  @Override
  public List<Locale> getProvidedLocales() {
    logger().info("getProvidedLocales.. " + LOCALES);
    return LOCALES;
  }

  @Override
  public String getTranslation(String key , Locale locale , Object... params) {
    logger().info("getTranslation.. key : " + key + " - " + locale);

    ResourceBundle bundleToUse = (GERMAN.equals(locale))
                                 ? RESOURCE_BUNDLE_DE : RESOURCE_BUNDLE_EN;

    return bundleToUse.getString(key);
  }

}