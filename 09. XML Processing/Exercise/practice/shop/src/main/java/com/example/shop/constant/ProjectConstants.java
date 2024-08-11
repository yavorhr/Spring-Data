package com.example.shop.constant;

public class ProjectConstants {
  // INPUT
  private static final String INPUT_RESOURCES_FILES_PATH = "src/main/resources/input/";

  private static final String CATEGORIES_FILE_NAME = "categories.xml";
  private static final String USERS_FILE_NAME = "users.xml";
  private static final String PRODUCTS_FILE_NAME = "products.xml";

  private static final String SEED_CATEGORIES_PATH = INPUT_RESOURCES_FILES_PATH + CATEGORIES_FILE_NAME;
  private static final String SEED_USERS_PATH = INPUT_RESOURCES_FILES_PATH + USERS_FILE_NAME;
  private static final String SEED_PRODUCTS = INPUT_RESOURCES_FILES_PATH + PRODUCTS_FILE_NAME;

  // OUTPUT
  private static final String OUTPUT_RESOURCE_FILES_PATH = "src/main/resources/output/";

  private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.xml";
  private static final String SOLD_PRODUCTS_FILE_NAME = "sold-products.xml";
  private static final String EXTRACT_CATEGORIES = "extract-categories.xml";
  private static final String FIND_USERS_WITH_MORE_THAN_ONE_PRODUCT_SOLD = "find-users-sold-products.xml";

  private static final String FIRST_QUERY = OUTPUT_RESOURCE_FILES_PATH + PRODUCTS_IN_RANGE_FILE_NAME;
  private static final String SECOND_QUERY = OUTPUT_RESOURCE_FILES_PATH + SOLD_PRODUCTS_FILE_NAME;
  private static final String THIRD_QUERY = OUTPUT_RESOURCE_FILES_PATH +  EXTRACT_CATEGORIES;
  private static final String FOURTH_QUERY = OUTPUT_RESOURCE_FILES_PATH +FIND_USERS_WITH_MORE_THAN_ONE_PRODUCT_SOLD;
}
