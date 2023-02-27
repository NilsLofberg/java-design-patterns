package com.iluwatar.filter.criteria;

import com.iluwatar.filter.product.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for InStockCriteria.
 */
public class InStockCriteria implements Criteria<Product> {

  @Override
  public List<Product> meetCriteria(List<Product> items) {
    List<Product> inStockProducts = new ArrayList<>();
    for (Product product : items) {
      if (product.getNrInStock() > 0) {
        inStockProducts.add(product);
      }
    }
    return inStockProducts;
  }
}
