package ru.dm.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 12.05.16.
 */

public class ProductGroup {
    private Long id;
    private String groupId;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private ProductGroup parentGroup;

    public ProductGroup getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(ProductGroup parentGroup) {
        this.parentGroup = parentGroup;
    }

    private List<ProductGroup> childGroups = new ArrayList<ProductGroup>();

    public List<ProductGroup> getChildGroups() {
        return childGroups;
    }

    public void setChildGroups(List<ProductGroup> childGroups) {
        this.childGroups = childGroups;
    }

    /*
    private List<Product> products;

    @OneToMany(targetEntity = Product.class, mappedBy = "productGroup", fetch = FetchType.EAGER)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroup that = (ProductGroup) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
