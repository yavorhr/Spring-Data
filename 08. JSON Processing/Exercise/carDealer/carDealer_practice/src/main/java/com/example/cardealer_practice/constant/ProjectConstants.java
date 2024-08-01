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

  //Output
  private static final String OUTPUT = "src/main/resources/output/";

  public static final String FIRST_QUERY = "ordered_customers.json";
  public static final String SECOND_QUERY = "cars_toyota.json";
  public static final String THIRD_QUERY = "local_suppliers.json";
  public static final String FOURTH_QUERY = "cars_with_parts.json";
  public static final String FIFTH_QUERY = "top_sales_by_customer.json";

  public static final String ORDERED_CUSTOMERS = OUTPUT + FIRST_QUERY;
  public static final String TOYOTA_CARS = OUTPUT + SECOND_QUERY;
  public static final String LOCAL_SUPPLIERS = OUTPUT + THIRD_QUERY ;
  public static final String CARS_WITH_PARTS = OUTPUT + FOURTH_QUERY ;
  public static final String TOP_SALES = OUTPUT + FIFTH_QUERY ;
}
