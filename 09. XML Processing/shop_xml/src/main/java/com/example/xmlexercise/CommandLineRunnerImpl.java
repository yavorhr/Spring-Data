package com.example.xmlexercise;

import com.example.xmlexercise.model.dto.Shop_SeedDtos.CategorySeedRootDto;
import com.example.xmlexercise.model.dto.Shop_SeedDtos.ProductSeedRootDto;
import com.example.xmlexercise.model.dto.Shop_SeedDtos.UserSeedRootDto;
import com.example.xmlexercise.model.dto.Shop_query1.ProductViewRootDto;
import com.example.xmlexercise.model.dto.Shop_query2.UserViewRootDto;
import com.example.xmlexercise.model.dto.Shop_query3.CategoryRootDto;
import com.example.xmlexercise.model.dto.Shop_query4.UsersRootDto;
import com.example.xmlexercise.service.CategoryService;
import com.example.xmlexercise.service.ProductService;
import com.example.xmlexercise.service.UserService;
import com.example.xmlexercise.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String RESOURCE_FILE_PATH = "src/main/resources/Files/";

    private static final String CATEGORIES_FILE_NAME = "categories.xml";
    private static final String USERS_FILE_NAME = "users.xml";
    private static final String PRODUCTS_FILE_NAME = "products.xml";

    private static final String OUTPUT_FILE_PATH = "output/";
    private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.xml";
    private static final String SOLD_PRODUCTS_FILE_NAME = "sold-products.xml";
    private static final String EXTRACT_CATEGORIES = "extract-categories.xml";
    private static final String FIND_USERS_WITH_MORE_THAN_ONE_PRODUCT_SOLD = "find-users-sold-products.xml";

    private final BufferedReader bufferedReader;
    private final XmlParser xmlParser;

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Please select ex: ");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum) {
            case 1:
                productsInRange();
            case 2:
                successfullySoldProducts();
            case 3:
                getAllCategories();
            case 4 : usersAndProducts();
        }
    }

    private void usersAndProducts() throws JAXBException {
        UsersRootDto userRootDto = this.userService.getAllUsersWithProducts();
        xmlParser.writeToFile(RESOURCE_FILE_PATH+OUTPUT_FILE_PATH+FIND_USERS_WITH_MORE_THAN_ONE_PRODUCT_SOLD,userRootDto);
        System.out.println();
    }

    private void getAllCategories() throws JAXBException {
        CategoryRootDto categoryRootDto = categoryService.getCategoriesOrderedByProductsCountPlusAvgPrice();
        xmlParser.writeToFile(RESOURCE_FILE_PATH+OUTPUT_FILE_PATH+EXTRACT_CATEGORIES,categoryRootDto);
    }

    private void successfullySoldProducts() throws JAXBException {
        UserViewRootDto userViewRootDto =
                userService.findUsersWithMoreThanOneSoldProducts();
        xmlParser.writeToFile(RESOURCE_FILE_PATH + OUTPUT_FILE_PATH + SOLD_PRODUCTS_FILE_NAME, userViewRootDto);
    }

    private void productsInRange() throws JAXBException {
        ProductViewRootDto rootDto =
                productService.findProductsInRangeWithoutBuyer();
        xmlParser.writeToFile(RESOURCE_FILE_PATH + OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE_NAME, rootDto);
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (categoryService.getEntityCount() == 0) {

            CategorySeedRootDto categorySeedRootDto =
                    xmlParser.fromFile(RESOURCE_FILE_PATH + CATEGORIES_FILE_NAME, CategorySeedRootDto.class);

            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (userService.getCount() == 0) {
            UserSeedRootDto userSeedRootDto =
                    xmlParser.fromFile(RESOURCE_FILE_PATH + USERS_FILE_NAME, UserSeedRootDto.class);

            userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (productService.getCount() == 0) {
            ProductSeedRootDto productSeedRootDto =
                    xmlParser.fromFile(RESOURCE_FILE_PATH + PRODUCTS_FILE_NAME, ProductSeedRootDto.class);

            productService.seedProducts(productSeedRootDto.getProducts());
        }

    }
}
