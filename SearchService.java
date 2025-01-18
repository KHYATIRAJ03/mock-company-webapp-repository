package com.mockcompany.webapp.services;

import com.mockcompany.webapp.model.ProductItem;
import com.mockcompany.webapp.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private final ProductItemRepository productItemRepository;

    @Autowired
    public SearchService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    // Method to handle search logic
    public List<ProductItem> search(String query) {
        Iterable<ProductItem> allItems = productItemRepository.findAll();
        List<ProductItem> filteredItems = new ArrayList<>();
        String lowerCaseQuery = query.toLowerCase();

        for (ProductItem item : allItems) {
            if (item.getName().toLowerCase().contains(lowerCaseQuery) || 
                item.getCategory().toLowerCase().contains(lowerCaseQuery)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
}
