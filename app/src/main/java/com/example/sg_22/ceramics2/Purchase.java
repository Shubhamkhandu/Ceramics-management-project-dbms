package com.example.sg_22.ceramics2;

/**
 * Created by SG-22 on 11/11/2017.
 */

public class Purchase {
    int _purchase_id;
    int _pid;
    int _sid;

    public Purchase() {

    }

    public Purchase(int _purchase_id, int _pid, int _sid) {
        this._purchase_id = _purchase_id;
        this._pid = _pid;
        this._sid = _sid;
    }

    public Purchase(int _pid, int _sid) {
        this._pid = _pid;
        this._sid = _sid;
    }

    public int get_purchase_id() {
        return _purchase_id;
    }

    public void set_purchase_id(int _purchase_id) {
        this._purchase_id = _purchase_id;
    }

    public int get_pid() {
        return _pid;
    }

    public void set_pid(int _pid) {
        this._pid = _pid;
    }

    public int get_sid() {
        return _sid;
    }

    public void set_sid(int _sid) {
        this._sid = _sid;
    }
}
