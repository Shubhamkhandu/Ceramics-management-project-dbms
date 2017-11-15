package com.example.sg_22.ceramics2;

/**
 * Created by SG-22 on 11/5/2017.
 */

public class Suppliers {
    int _supplier_id;
    String _supplier_name;
    String _supplier_address;
    String _supplier_email;
    String _supplier_contact;

    public Suppliers() {

    }

    public Suppliers(int _supplier_id, String _supplier_name, String _supplier_address, String _supplier_email, String _supplier_contact) {
        this._supplier_id = _supplier_id;
        this._supplier_name = _supplier_name;
        this._supplier_address = _supplier_address;
        this._supplier_email = _supplier_email;
        this._supplier_contact = _supplier_contact;
    }

    public Suppliers(String _supplier_name, String _supplier_address, String _supplier_email, String _supplier_contact) {
        this._supplier_name = _supplier_name;
        this._supplier_email = _supplier_address;
        this._supplier_address = _supplier_email;
        this._supplier_contact = _supplier_contact;
    }

    public int get_supplier_id() {
        return _supplier_id;
    }

    public void set_supplier_id(int _supplier_id) {
        this._supplier_id = _supplier_id;
    }

    public String get_supplier_name() {
        return _supplier_name;
    }

    public void set_supplier_name(String _supplier_name) {
        this._supplier_name = _supplier_name;
    }

    public String get_supplier_address() {
        return _supplier_address;
    }

    public void set_supplier_address(String _supplier_address) {
        this._supplier_address = _supplier_address;
    }

    public String get_supplier_email() {
        return _supplier_email;
    }

    public void set_supplier_email(String _supplier_email) {
        this._supplier_email = _supplier_email;
    }

    public String get_supplier_contact() {
        return _supplier_contact;
    }

    public void set_supplier_contact(String _supplier_contact) {
        this._supplier_contact = _supplier_contact;
    }
}
