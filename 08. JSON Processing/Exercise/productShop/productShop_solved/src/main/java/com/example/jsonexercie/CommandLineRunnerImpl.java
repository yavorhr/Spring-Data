package com.example.jsonexercie;

import com.example.jsonexercie.model.Dto.ProductNameAndPriceDto;
import com.example.jsonexercie.model.Dto.UserSoldDto;
import com.example.jsonexercie.service.CategoryService;
import com.example.jsonexercie.service.ProductService;
import com.example.jsonexercie.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private static final String OUTPUT_FILES_PATH = "src/main/resources/Files/Out/";
    private final static String PRODUCT_IN_RANGE_FILE_NAME = "products-in-range.json";
    private final static String USERS_AND_SOLD_PRODUCTS = "users-and-sold-products.json";
    private final Gson gson;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hi");
        seedData();

        System.out.println("Please enter exercise");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum) {
            case 1 -> productsInRange();
            case 2 -> soldProducts();
        }


    }

    private void soldProducts() throws IOException {
        List<UserSoldDto> userSoldDtos = userService.findAllUsersWithMoreThanOneSoldProducts();

        String content = gson.toJson(userSoldDtos);

        writeFileToResources(OUTPUT_FILES_PATH + USERS_AND_SOLD_PRODUCTS, content);
    }

    private void productsInRange() throws IOException {
        List<ProductNameAndPriceDto> productsDtos =
                productService.findAllProductsInRangeOrderByPrice(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

        String content = gson.toJson(productsDtos);

        writeFileToResources(OUTPUT_FILES_PATH + PRODUCT_IN_RANGE_FILE_NAME, content);
    }

    private void writeFileToResources(String filePath, String content) throws IOException {
        Files
                .write(Path.of(filePath),
                        //иска Collections.singleTon за да може да се сериализира
                        Collections.singleton(content));
    }

    private void seedData() throws IOException {
        categoryService
                .seedCategories();
        userService
                .seedUsers();
        productService
                .seedProducts();
    }
}
