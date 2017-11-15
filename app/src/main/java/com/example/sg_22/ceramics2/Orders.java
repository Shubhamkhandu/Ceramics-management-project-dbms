package com.example.sg_22.ceramics2;

/**
 * Created by SG-22 on 11/8/2017.
 */

public class Orders {
    int _order_id;
    String _cusemail;
    int _proID;
    int _quantity;
    int _total_price;
    String  _customer_name;
    String _product_name;

    public  Orders() {

    }

    public Orders(String _cusemail, int _proID, int _quantity, int _total_price) {
        this._cusemail = _cusemail;
        this._proID = _proID;
        this._quantity = _quantity;
        this._total_price = _total_price;
    }

    public Orders(int _order_id, String _cusemail, int _proID, int _quantity, int _total_price) {
        this._order_id = _order_id;
        this._cusemail = _cusemail;
        this._proID = _proID;
        this._quantity = _quantity;
        this._total_price = _total_price;
    }

    public String get_customer_name() {
        return _customer_name;
    }

    public void set_customer_name(String _customer_name) {
        this._customer_name = _customer_name;
    }

    public String get_product_name() {
        return _product_name;
    }

    public void set_product_name(String _product_name) {
        this._product_name = _product_name;
    }

    public int get_order_id() {
        return _order_id;
    }

    public void set_order_id(int _order_id) {
        this._order_id = _order_id;
    }

    public String get_cusemail() {
        return _cusemail;
    }

    public void set_cusemail(String _cusemail) {
        this._cusemail = _cusemail;
    }

    public int get_proID() {
        return _proID;
    }

    public void set_proID(int _proID) {
        this._proID = _proID;
    }

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }

    public int get_total_price() {
        return _total_price;
    }

    public void set_total_price(int _total_price) {
        this._total_price = _total_price;
    }
}

