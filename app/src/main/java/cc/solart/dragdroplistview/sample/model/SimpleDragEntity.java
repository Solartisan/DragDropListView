package cc.solart.dragdroplistview.sample.model;

import cc.solart.dragdrop.IDragEntity;

/**
 * -------------------------------------------------------------------------
 * Author: imilk
 * Create:  16:41
 * -------------------------------------------------------------------------
 * Describe:
 * -------------------------------------------------------------------------
 * Changes:
 * -------------------------------------------------------------------------
 * 16 : Create by imilk
 * -------------------------------------------------------------------------
 */
public class SimpleDragEntity implements IDragEntity {
    private int id;
    private String name;
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
