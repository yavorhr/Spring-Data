package com.example.cardealer_practice.constant;

public class ProjectConstants {
  // Input
  private static final String INPUT_FOLDER = "src/main/resources/input/";

  public static final String SUPPLIERS = "suppliers.json";
  public static final String CARS = "cars.json";
  public static final String CUSTOMERS = "customers.json";
  public static final String PARTS = "parts.json";
  public static final String SALES = "sales.json";

  public static final String SUPPLIERS_INPUT_PATH = INPUT_FOLDER + SUPPLIERS;
  public static final String CARS_INPUT_PATH = INPUT_FOLDER + CARS;
  public static final String CUSTOMERS_INPUT_PATH = INPUT_FOLDER + CUSTOMERS;
  public static final String PARTS_INPUT_PATH = INPUT_FOLDER + PARTS;
  public static final String SALES_INPUT_PATH = INPUT_FOLDER + SALES;

  //Output
  private static final String OUTPUT = "src/main/resources/output/";

  public static final String FIRST_QUERY = "ordered_customers";
  public static final String SECOND_QUERY = "cars_toyota";

  public static final String FIRST_QUERY_PATH = OUTPUT + FIRST_QUERY;
  public static final String SECOND_QUERY_PATH = OUTPUT + SECOND_QUERY;
}
