package com.example.shop.constant;

public class ProjectConstants {
  // INPUT
  public static final String INPUT_RESOURCES_FILES_PATH = "src/main/resources/input/";

  public static final String CATEGORIES_FILE_NAME = "categories.xml";
  public static final String USERS_FILE_NAME = "users.xml";
  public static final String PRODUCTS_FILE_NAME = "products.xml";

  public static final String SEED_CATEGORIES = INPUT_RESOURCES_FILES_PATH + CATEGORIES_FILE_NAME;
  public static final String SEED_USERS = INPUT_RESOURCES_FILES_PATH + USERS_FILE_NAME;
  public static final String SEED_PRODUCTS = INPUT_RESOURCES_FILES_PATH + PRODUCTS_FILE_NAME;

  // OUTPUT
  public static final String OUTPUT_RESOURCE_FILES_PATH = "src/main/resources/output/";

  public static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.xml";
  public static final String SOLD_PRODUCTS_FILE_NAME = "sold-products.xml";
  public static final String EXTRACT_CATEGORIES = "extract-categories.xml";
  public static final String FIND_USERS_WITH_MORE_THAN_ONE_PRODUCT_SOLD = "find-users-sold-products.xml";

  public static final String FIRST_QUERY = OUTPUT_RESOURCE_FILES_PATH + PRODUCTS_IN_RANGE_FILE_NAME;
  public static final String SECOND_QUERY = OUTPUT_RESOURCE_FILES_PATH + SOLD_PRODUCTS_FILE_NAME;
  public static final String THIRD_QUERY = OUTPUT_RESOURCE_FILES_PATH +  EXTRACT_CATEGORIES;
  public static final String FOURTH_QUERY = OUTPUT_RESOURCE_FILES_PATH +FIND_USERS_WITH_MORE_THAN_ONE_PRODUCT_SOLD;
}
