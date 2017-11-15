package com.example.sg_22.ceramics2;

/**
 * Created by SG-22 on 11/4/2017.
 */

public class Products {
    int _product_id;
    String _product_name;
    String _product_type;
    int _quantity;
    String _brand;
    int _price;


    // Empty constructor
    public Products(){

    }

    public Products(int _product_id, String _product_name, String _product_type, int _price, String _brand, int _quantity) {
        this._product_id = _product_id;
        this._product_name = _product_name;
        this._product_type = _product_type;
        this._quantity = _quantity;
        this._brand = _brand;
        this._price = _price;
    }

    public Products(String _product_name, String _product_type, int _price, String _brand, int _quantity) {
        this._product_name = _product_name;
        this._product_type = _product_type;
        this._quantity = _quantity;
        this._brand = _brand;
        this._price = _price;
    }

    public String get_brand() {
        return _brand;
    }

    public void set_brand(String _brand) {
        this._brand = _brand;
    }

    public int get_product_id() {
        return _product_id;
    }

    public void set_product_id(int _product_id) {
        this._product_id = _product_id;
    }

    public String get_product_name() {
        return _product_name;
    }

    public void set_product_name(String _product_name) {
        this._product_name = _product_name;
    }

    public String get_product_type() {
        return _product_type;
    }

    public void set_product_type(String _product_type) {
        this._product_type = _product_type;
    }

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }

    public int get_price() {
        return _price;
    }

    public void set_price(int _price) {
        this._price = _price;
    }
}
