package com.iluwatar.filter;

import com.iluwatar.filter.criteria.InStockCriteria;
import com.iluwatar.filter.product.Product;
import com.iluwatar.filter.product.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InStockCriteriaTest {

    @Test
    void testSomeMeetsCriteria(){
        InStockCriteria criteria = new InStockCriteria();
        Product computer = new Product("Computer", 4000, ProductCategory.ELECTRONICS, 5);
        Product phone = new Product("Smartphone", 500, ProductCategory.ELECTRONICS, 0);
        Product headphones = new Product("Headphones", 100, ProductCategory.ELECTRONICS, 1);
        ArrayList<Product> products = new ArrayList<>();
        products.add(computer);
        products.add(phone);
        products.add(headphones);
        List<Product> criteriaRes = criteria.meetCriteria(products);
        List<Product> productsInStock = new ArrayList<>();
        productsInStock.add(computer);
        productsInStock.add(headphones);
        Assert.assertEquals(criteriaRes, productsInStock);
    }

    @Test
    void testNoMeetsCriteria(){
        InStockCriteria criteria = new InStockCriteria();
        Product computer = new Product("Computer", 4000, ProductCategory.ELECTRONICS, 0);
        Product phone = new Product("Smartphone", 500, ProductCategory.ELECTRONICS, 0);
        Product headphones = new Product("Headphones", 100, ProductCategory.ELECTRONICS, 0);
        ArrayList<Product> products = new ArrayList<>();
        products.add(computer);
        products.add(phone);
        products.add(headphones);
        List<Product> criteriaRes = criteria.meetCriteria(products);
        List<Product> productsInStock = new ArrayList<>();
        Assert.assertEquals(criteriaRes, productsInStock);
    }

    @Test
    void testAllMeetsCriteria(){
        InStockCriteria criteria = new InStockCriteria();
        Product computer = new Product("Computer", 4000, ProductCategory.ELECTRONICS, 100);
        Product phone = new Product("Smartphone", 500, ProductCategory.ELECTRONICS, 6);
        Product headphones = new Product("Headphones", 100, ProductCategory.ELECTRONICS, 9);
        ArrayList<Product> products = new ArrayList<>();
        products.add(computer);
        products.add(phone);
        products.add(headphones);
        List<Product> criteriaRes = criteria.meetCriteria(products);
        List<Product> productsInStock = new ArrayList<>();
        productsInStock.add(computer);
        productsInStock.add(phone);
        productsInStock.add(headphones);
        Assert.assertEquals(criteriaRes, productsInStock);
    }
}
