package ru.kpfu.dm.entity;

/**
 * Created by Denis on 08.02.16.
 */
public class GroupRelation {

    String root;
    String child;

    public GroupRelation(String root, String child) {
        this.child = child;
        this.root = root;
    }

    public GroupRelation(String root) {
        this.root = root;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getChild() {
        return child;
    }

    public String getRoot() {
        return root;
    }
}
