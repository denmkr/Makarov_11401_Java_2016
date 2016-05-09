package ru.kpfu.dm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.entity.ProductGroup;
import ru.kpfu.dm.repository.GroupRepository;
import ru.kpfu.dm.service.GroupService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Resource
    GroupRepository groupRepository;

    @Override
    @Transactional
    public ProductGroup create(ProductGroup productGroup) {
        ProductGroup createdProductGroup = productGroup;
        return groupRepository.save(createdProductGroup);
    }

    @Override
    @Transactional
    public ProductGroup findById(long id) {
        return groupRepository.findOne(id);
    }

    @Override
    @Transactional
    public void addGroups(List<ProductGroup> productGroups) {
        for (ProductGroup productGroup : productGroups) {
            groupRepository.saveAndFlush(productGroup);
        }
    }

    @Override
    public boolean updateGroups(List<ProductGroup> productGroups) {
        for (ProductGroup group : productGroups) {

            if (groupRepository.findByGroupId(group.getGroupId()) == null) {
                groupRepository.saveAndFlush(group);
            }
            else groupRepository.updateGroupByGroupId(group.getGroupId(), group.getName());
        }

        return true;
    }

    @Override
    public ProductGroup findByGroupId(String groupId) {
        return groupRepository.findByGroupId(groupId);
    }

    @Override
    @Transactional
    public ProductGroup delete(long id) {
        ProductGroup deletedProductGroup = groupRepository.findOne(id);
        groupRepository.delete(deletedProductGroup);
        return deletedProductGroup;
    }

    @Override
    @Transactional
    public List<ProductGroup> findAll() {
        List<ProductGroup> products = groupRepository.findAll();
        return products;
    }

    @Override
    @Transactional
    public ProductGroup update(ProductGroup productGroup) {
        ProductGroup updatedProductGroup = groupRepository.findOne(productGroup.getId());

        updatedProductGroup.setName(productGroup.getName());
        return updatedProductGroup;
    }

}