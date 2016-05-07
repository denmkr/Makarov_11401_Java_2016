package ru.kpfu.dm.service;

import ru.kpfu.dm.entity.ProductGroup;

import java.util.List;

/**
 * Created by Denis on 17.04.16.
 */
public interface GroupService {
    ProductGroup create(ProductGroup productGroup);
    ProductGroup delete(long id);
    List<ProductGroup> findAll();
    ProductGroup update(ProductGroup productGroup);
    ProductGroup findById(long id);

    void addGroups(List<ProductGroup> productGroups);
    boolean updateGroups(List<ProductGroup> productGroups);
    ProductGroup findByGroupId(String groupId);
}
