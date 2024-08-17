package com.example.cardealer.constant;

public class ProjectConstants {
  // INPUT
  public static final String INPUT_RESOURCES_FILES_PATH = "src/main/resources/input/";

  public static final String CARS_FILE_NAME = "cars.xml";
  public static final String CUSTOMERS_FILE_NAME = "customers.xml";
  public static final String PARTS_FILE_NAME = "parts.xml";
  public static final String SUPPLIERS_FILE_NAME = "suppliers.xml";

  public static final String SEED_CARS = INPUT_RESOURCES_FILES_PATH + CARS_FILE_NAME;
  public static final String SEED_CUSTOMERS = INPUT_RESOURCES_FILES_PATH + CUSTOMERS_FILE_NAME;
  public static final String SEED_PARTS = INPUT_RESOURCES_FILES_PATH + PARTS_FILE_NAME;
  public static final String SEED_SUPPLIERS = INPUT_RESOURCES_FILES_PATH + SUPPLIERS_FILE_NAME;

  // OUTPUT
  public static final String OUTPUT_RESOURCE_FILES_PATH = "src/main/resources/output/";

  public static final String ORDERED_CUSTOMERS_FILE_NAME = "ordered-customers.xml";
  public static final String CARS_FROM_TOYOTA_FILE_NAME = "cars-from-make-toyota.xml";
  public static final String LOCAL_SUPPLIERS_FILE_NAME = "local-suppliers.xml";
  public static final String CARS_WITH_PARTS_FILE_NAME = "cars-with-their-list-of-parts.xml";
  public static final String TOYOTA_SALES_FILE_NAME = "total-sales-by-customer.xml";
  public static final String SALES_WITH_DISCOUNT_FILE_NAME = "sales-with-applied-discount.xml";

  public static final String FIRST_QUERY = OUTPUT_RESOURCE_FILES_PATH + ORDERED_CUSTOMERS_FILE_NAME;
  public static final String SECOND_QUERY = OUTPUT_RESOURCE_FILES_PATH + CARS_FROM_TOYOTA_FILE_NAME;
  public static final String THIRD_QUERY = OUTPUT_RESOURCE_FILES_PATH +  LOCAL_SUPPLIERS_FILE_NAME;
  public static final String FOURTH_QUERY = OUTPUT_RESOURCE_FILES_PATH +CARS_WITH_PARTS_FILE_NAME;
  public static final String FIFTH_QUERY = OUTPUT_RESOURCE_FILES_PATH +TOYOTA_SALES_FILE_NAME;
  public static final String SIXTH_QUERY = OUTPUT_RESOURCE_FILES_PATH +SALES_WITH_DISCOUNT_FILE_NAME;
}
