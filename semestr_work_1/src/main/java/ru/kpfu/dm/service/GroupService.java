package ru.kpfu.dm.service;

import ru.kpfu.dm.entity.GroupRelation;
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.entity.ProductGroup;

import java.util.List;

/**
 * Created by Denis on 17.04.16.
 */
public interface GroupService {
    ProductGroup create(ProductGroup productGroup);
    boolean delete(long id);
    List<ProductGroup> findAll();
    ProductGroup update(ProductGroup productGroup);
    ProductGroup findById(long id);

    boolean addGroups(List<ProductGroup> productGroups);
    boolean updateGroups(List<ProductGroup> productGroups);
    boolean addParentsGroupsToGroups(List<GroupRelation> relations);
    ProductGroup findByGroupId(String groupId);
}
