package com.example.productshop_practice.constant;

public class GlobalConstants {
  // Read from input dir
  public static final String INPUT_RESOURCES_FILE_PATH = "src/main/resources/input_files/";

  public static final String CATEGORIES_INPUT_FILE_PATH = "categories.json";
  public static final String USERS_INPUT_FILE_PATH = "users.json";
  public static final String PRODUCTS_INPUT_FILE_PATH = "products.json";

  public static final String SEED_CATEGORIES_PATH = INPUT_RESOURCES_FILE_PATH + CATEGORIES_INPUT_FILE_PATH;
  public static final String SEED_USERS_PATH = INPUT_RESOURCES_FILE_PATH + USERS_INPUT_FILE_PATH;
  public static final String SEED_PRODUCTS_PATH = INPUT_RESOURCES_FILE_PATH + PRODUCTS_INPUT_FILE_PATH;

  // Save to output dir
  public static final String OUTPUT_RESOURCES_FILE_PATH = "src/main/resources/output_files/";

  public static final String PRODUCTS_IN_RANGE_OUTPUT = "products_in_range.json";
  public static final String SOLD_PRODUCTS_OUTPUT = "sold_products.json";
  public static final String CATEGORIES_BY_PRODUCTS_OUTPUT = "categories_by_products.json";

  public static final String PRODUCTS_IN_RANGE = OUTPUT_RESOURCES_FILE_PATH + PRODUCTS_IN_RANGE_OUTPUT;
  public static final String SOLD_PRODUCTS = OUTPUT_RESOURCES_FILE_PATH + SOLD_PRODUCTS_OUTPUT;
  public static final String CATEGORIES_BY_PRODUCTS = OUTPUT_RESOURCES_FILE_PATH+ CATEGORIES_BY_PRODUCTS_OUTPUT;
}
