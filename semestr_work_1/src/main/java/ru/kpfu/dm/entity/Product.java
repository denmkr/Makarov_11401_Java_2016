package ru.kpfu.dm.entity;

import javax.persistence.*;

/**
 * Created by Denis on 07.05.16.
 */
@Entity
@Table(name = "products", schema = "public", catalog = "mvc")
public class Product {
    private Long id;
    private String articule;
    private String name;
    private Integer stock;
    private Float price;
    private String currency;

    public Product() {
    }

    public Product(String articule, String name, Integer stock, Float price, String currency, ProductGroup group) {
        this.articule = articule;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.currency = currency;
        this.group = group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "articule")
    public String getArticule() {
        return articule;
    }

    public void setArticule(String articule) {
        this.articule = articule;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "stock")
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /* */
    private ProductGroup group;

    @ManyToOne(targetEntity = ProductGroup.class)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    public ProductGroup getProductGroup() {
        return group;
    }
    public void setProductGroup(ProductGroup group) {
        this.group = group;
    }
    /* */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (articule != null ? !articule.equals(that.articule) : that.articule != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (articule != null ? articule.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
