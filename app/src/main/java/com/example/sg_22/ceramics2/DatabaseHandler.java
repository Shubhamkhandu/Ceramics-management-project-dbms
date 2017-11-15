package com.example.sg_22.ceramics2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ceraManagement.db";

    private static final String TABLE_CUSTOMERS = "Customers";

    private static final String KEY_ID = "customer_id";
    private static final String KEY_FNAME = "first_name";
    private static final String KEY_LNAME = "last_name";
    private static final String KEY_EMAIL = "email_id";
    private static final String KEY_CONTACT = "contact";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_CITY = "city";
    private static final String KEY_STATE = "state";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_PIN = "pin_code";

    private static final String TABLE_USERS = "Users";

    private static final String KEY_USERID = "user_id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private static final String TABLE_ADMIN = "Admin";

    private static final String KEY_ADMINID = "admin_id";
    private static final String KEY_AEMAIL = "admin_email";
    private static final String KEY_AFNAME = "admin_first_name";
    private static final String KEY_ALNAME = "admin_last_name";
    private static final String KEY_ACONTACT = "admin_contact";

    private static final String TABLE_PRODUCTS = "Products";

    private static final String KEY_PRODUCTID = "product_id";
    private static final String KEY_PRODUCT_NAME = "product_name";
    private static final String KEY_PRODUCT_TYPE = "product_type";
    private static final String KEY_PRICE = "price";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_QUANTITY = "quantity";


    private static final String TABLE_ORDERS = "Orders";

    private static final String KEY_ORDERID = "order_id";
    private static final String KEY_CUSEMAIL = "cus_emailid";
    private static final String KEY_PROID = "prod_id";
    private static final String KEY_QUAN = "chosen_quantity";
    private static final String KEY_TOTALPRICE = "total_price";

    private static final String TABLE_PURCHASE = "Purchase";

    private static final String KEY_PURCHASEID = "purchase_id";
    private static final String KEY_PID = "product_id";
    private static final String KEY_SID = "supplier_id";

    private static final String TABLE_SUPPLIER = "Supplier";

    private static final String KEY_SUPPLIERID = "supplier_id";
    private static final String KEY_SUPPLIER_NAME = "supplier_name";
    private static final String KEY_SUPPLIER_ADDRESS = "supplier_address";
    private static final String KEY_SUPPLIER_EMAIL = "supplier_email";
    private static final String KEY_SUPPLIER_CONTACT = "supplier_contact";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //BE CAREFUL WITH COMMAS
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CUSTOMERS = "CREATE TABLE " + TABLE_CUSTOMERS + " ( "
                + KEY_ID + " INTEGER, "
                + KEY_FNAME + " TEXT NOT NULL, "
                + KEY_LNAME + " TEXT NOT NULL, "
                + KEY_EMAIL + " TEXT NOT NULL PRIMARY KEY, "
                + KEY_CONTACT + " TEXT NOT NULL, "
                + KEY_ADDRESS + " TEXT NOT NULL, "
                + KEY_CITY + " TEXT NOT NULL, "
                + KEY_STATE + " TEXT NOT NULL, "
                + KEY_COUNTRY + " TEXT NOT NULL, "
                + KEY_PIN + " TEXT NOT NULL " + ")";
        db.execSQL(CREATE_CUSTOMERS);

        String CREATE_USERS = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_USERID + " INTEGER," + KEY_USERNAME + " TEXT NOT NULL PRIMARY KEY,"
                + KEY_PASSWORD + " TEXT NOT NULL,"
                + " FOREIGN KEY ("+KEY_USERNAME+") REFERENCES "+TABLE_CUSTOMERS+"("+KEY_EMAIL+") ON DELETE CASCADE,"
                + " FOREIGN KEY ("+KEY_USERNAME+") REFERENCES "+TABLE_ADMIN+"("+KEY_AEMAIL+") ON DELETE CASCADE)";
        db.execSQL(CREATE_USERS);

        String CREATE_ADMIN = "CREATE TABLE " + TABLE_ADMIN + "("
                + KEY_ADMINID + " INTEGER,"
                + KEY_AFNAME + " TEXT NOT NULL,"
                + KEY_ALNAME + " TEXT NOT NULL,"
                + KEY_AEMAIL + " TEXT PRIMARY KEY NOT NULL,"
                + KEY_ACONTACT + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_ADMIN);

        String CREATE_PRODUCTS = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_PRODUCTID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_PRODUCT_NAME + " TEXT NOT NULL,"
                + KEY_PRODUCT_TYPE + " TEXT NOT NULL," + KEY_PRICE + " INTEGER NOT NULL,"
                + KEY_BRAND + " TEXT NOT NULL,"
                + KEY_QUANTITY + " INTEGER NOT NULL" + ")";
        db.execSQL(CREATE_PRODUCTS);



        String CREATE_ORDERS = "CREATE TABLE " + TABLE_ORDERS + "("
                + KEY_ORDERID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_CUSEMAIL + " TEXT NOT NULL,"
                + KEY_PROID + " INTEGER NOT NULL," + KEY_QUAN + " INTEGER NOT NULL,"
                + KEY_TOTALPRICE + " INTEGER NOT NULL,"
                + " FOREIGN KEY ("+KEY_CUSEMAIL+") REFERENCES "+TABLE_CUSTOMERS+"("+KEY_EMAIL+") ON DELETE CASCADE,"
                + " FOREIGN KEY ("+KEY_PROID+") REFERENCES "+TABLE_PRODUCTS+"("+KEY_PRODUCTID+") ON DELETE CASCADE)";
        db.execSQL(CREATE_ORDERS);

        String CREATE_PURCHASE = "CREATE TABLE " + TABLE_PURCHASE + "("
                + KEY_PURCHASEID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_PID + " INTEGER NOT NULL,"
                + KEY_SID + " INTEGER NOT NULL,"
                + " FOREIGN KEY ("+KEY_PID+") REFERENCES "+TABLE_PRODUCTS+"("+KEY_PRODUCTID+") ON DELETE CASCADE,"
                + " FOREIGN KEY ("+KEY_SID+") REFERENCES "+TABLE_SUPPLIER+"("+KEY_SUPPLIERID+") ON DELETE CASCADE)";
        db.execSQL(CREATE_PURCHASE);

        String CREATE_SUPPLIER = "CREATE TABLE " + TABLE_SUPPLIER + "("
                + KEY_SUPPLIERID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + KEY_SUPPLIER_NAME + " TEXT NOT NULL,"
                + KEY_SUPPLIER_EMAIL + " TEXT NOT NULL," + KEY_SUPPLIER_ADDRESS + " TEXT NOT NULL,"
                + KEY_SUPPLIER_CONTACT + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_SUPPLIER);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PURCHASE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUPPLIER);

        onCreate(db);
    }

    public void addPurchase (Purchase purchase) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PID, purchase.get_pid());
        values.put(KEY_SID, purchase.get_sid());

        db.insert(TABLE_PURCHASE, null, values);
        db.close();
    }
    // Adding new customer
    public void addCustomer(Customers customers) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, customers.getfirstName());
        values.put(KEY_LNAME, customers.getlastName());
        values.put(KEY_EMAIL, customers.getemailid());
        values.put(KEY_CONTACT, customers.getContact());
        values.put(KEY_ADDRESS, customers.getaddress());
        values.put(KEY_CITY, customers.getcity());
        values.put(KEY_STATE, customers.getstate());
        values.put(KEY_COUNTRY, customers.getcountry());
        values.put(KEY_PIN, customers.getpin());

        // Inserting Row
        db.insert(TABLE_CUSTOMERS, null, values);
        db.close(); // Closing database connection
    }

    // Getting All customers
    public List<Customers> getAllCustomers() {
        List<Customers> customersList = new ArrayList<Customers>();
        // Select All Query
        String selectQuery = "SELECT  " +  KEY_FNAME +","+
                KEY_LNAME+","+
                KEY_EMAIL +","+
                KEY_CONTACT+","+
                KEY_ADDRESS+","+
                KEY_CITY+","+
                KEY_PIN+","+
                KEY_STATE+","+
        KEY_COUNTRY + " FROM " + TABLE_CUSTOMERS + " ORDER BY " + KEY_FNAME + ", " + KEY_LNAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Customers customers = new Customers();
                customers.setfirstName(cursor.getString(0));
                customers.setlastName(cursor.getString(1));
                customers.setemailid(cursor.getString(2));
                customers.setContact(cursor.getString(3));
                customers.setaddress(cursor.getString(4));
                customers.setcity(cursor.getString(5));
                customers.setstate(cursor.getString(7));
                customers.setcountry(cursor.getString(8));
                customers.setpin(cursor.getString(6));
                // Adding contact to list
                customersList.add(customers);
            } while (cursor.moveToNext());
        }

        // return contact list
        return customersList;
    }

    public boolean checkAdminUser(String email, String password) {
        String[] columns = {
                KEY_USERID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = KEY_USERNAME + " = ?" + " AND " + KEY_PASSWORD + " = ?" + " AND (" + KEY_USERID + " = 1 OR " + KEY_USERID + " = 2)";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        int Cursorcount = cursor.getCount();
        cursor.close();
        db.close();
        if(Cursorcount > 0) {
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password) {
        String[] columns = {
                KEY_USERID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = KEY_USERNAME + " = ?" + " AND " + KEY_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        int Cursorcount = cursor.getCount();
        cursor.close();
        db.close();
        if(Cursorcount > 0) {
            return true;
        }
        return false;
    }


    public void addUser(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, users.getusername());
        values.put(KEY_PASSWORD, users.getpassword());

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single customer
    public String getUser(String email_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CUSTOMERS, new String[] { KEY_FNAME,
                        KEY_LNAME}, KEY_EMAIL + "=?",
                new String[] { String.valueOf(email_id) }, null, null, null, null);
        if (cursor.moveToFirst());
        else {
            String n = getAUser(email_id);
            return n;
        }
        String name = cursor.getString(0) + " " + cursor.getString(1);
        return name;
    }

    public String getAUser(String email_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ADMIN, new String[] { KEY_AFNAME,
                        KEY_ALNAME}, KEY_AEMAIL + "=?",
                new String[] { String.valueOf(email_id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        String name = cursor.getString(0) + " " + cursor.getString(1);

        return name;
    }

    public void addProducts(Products products) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, products.get_product_name());
        values.put(KEY_PRODUCT_TYPE, products.get_product_type());
        values.put(KEY_PRICE, products.get_price());
        values.put(KEY_BRAND, products.get_brand());
        values.put(KEY_QUANTITY, products.get_quantity());

        // Inserting Row
        db.insert(TABLE_PRODUCTS, null, values);
        db.close(); // Closing database connection
    }

    public List<Purchase> getAllPurchase() {
        List<Purchase> productsList = new ArrayList<Purchase>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PURCHASE + " ORDER BY " + KEY_PURCHASEID;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Purchase purchase = new Purchase();
                purchase.set_purchase_id(Integer.parseInt(cursor.getString(0)));
                purchase.set_pid(Integer.parseInt(cursor.getString(1)));
                purchase.set_sid(Integer.parseInt(cursor.getString(2)));
                productsList.add(purchase);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }


    // Getting All customers
    public List<Products> getAllProducts() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }

    // Getting customers Count
    // Updating single contact
    public int updateProducts(String pname, String ptype, int price, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, pname);
        values.put(KEY_PRODUCT_TYPE, ptype);
        values.put(KEY_PRICE, price);
        values.put(KEY_QUANTITY, quantity);

        // updating row
        return db.update(TABLE_PRODUCTS, values, KEY_PRODUCT_NAME + " = ?" + " AND " + KEY_PRODUCT_TYPE + " = ?",
                new String[] { pname, ptype});
    }

    public int getpid(String pname, String ptype) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] {KEY_PRODUCTID}, KEY_PRODUCT_NAME + " = ? " + "AND " + KEY_PRODUCT_TYPE + " = ?",
                new String[] {pname, ptype}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return Integer.parseInt(cursor.getString(0));
    }

    public String getpname(int pid) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] {KEY_PRODUCT_NAME}, KEY_PRODUCTID + " = ? ",
                new String[] {String.valueOf(pid)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor.getString(0);
    }

    public String getsname(int sid) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SUPPLIER, new String[] {KEY_SUPPLIER_NAME}, KEY_SUPPLIERID + " = ? ",
                new String[] {String.valueOf(sid)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor.getString(0);
    }

    public int getsid(String sname) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_SUPPLIER, new String[] {KEY_SUPPLIERID}, KEY_SUPPLIER_NAME + " = ? ",
                new String[] {sname}, null, null, null, null);
        if (cursor.moveToFirst());
        else
            return -5;

        return Integer.parseInt(cursor.getString(0));
    }

    public String retrieveName(String em_ID, int flag) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(flag == 1) {
            Cursor cursor = db.query(TABLE_PRODUCTS, new String[]{KEY_PRODUCT_NAME
                    }, KEY_PRODUCTID + "= ?",
                    new String[]{String.valueOf(em_ID)}, null, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();
            return cursor.getString(0);
        }
        return getUser(em_ID);
    }

    public int updateQuantity(int proID, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] { KEY_QUANTITY
                        }, KEY_PRODUCTID + "= ?",
                new String[] { String.valueOf(proID) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        int x = Integer.parseInt(cursor.getString(0));
        int y = x - quantity;
        if(y < 0){
            return (-5);
        }
        ContentValues values = new ContentValues();
        values.put(KEY_QUANTITY,y);
        return db.update(TABLE_PRODUCTS, values, KEY_PRODUCTID + " = ?",
                new String[] { Integer.toString(proID)});
    }
    // Deleting single customer
    public int deleteProduct(String productname,String producttype) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_PRODUCTS, KEY_PRODUCT_NAME + " = ?" + " AND " + KEY_PRODUCT_TYPE + " = ?",
                new String[] {productname,producttype });
        db.close();
        return i;
    }


    public void addOrder(String cusemail, int proID, int quantity, int TotalPrice) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CUSEMAIL, cusemail);
        values.put(KEY_PROID, proID);
        values.put(KEY_QUAN, quantity);
        values.put(KEY_TOTALPRICE, TotalPrice);

        // Inserting Row
        db.insert(TABLE_ORDERS, null, values);
        db.close(); // Closing database connection
    }

    public List<Orders> getAllOrders() {
        List<Orders> ordersList = new ArrayList<Orders>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ORDERS + " ORDER BY " + KEY_CUSEMAIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Orders orders = new Orders();
                orders.set_order_id(Integer.parseInt(cursor.getString(0)));
                orders.set_cusemail(cursor.getString(1));
                orders.set_proID(Integer.parseInt(cursor.getString(2)));
                orders.set_quantity(Integer.parseInt(cursor.getString(3)));
                orders.set_total_price(Integer.parseInt(cursor.getString(4)));
                orders.set_customer_name(retrieveName(cursor.getString(1),0));
                orders.set_product_name(retrieveName(cursor.getString(2),1));
                // Adding contact to list
                ordersList.add(orders);
            } while (cursor.moveToNext());
        }

        // return contact list
        return ordersList;
    }

    public List<Orders> getCartOrders(String email) {
        List<Orders> ordersList = new ArrayList<Orders>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ORDERS + " WHERE " + KEY_CUSEMAIL + " = \"" + email + "\"" + " ORDER BY " + KEY_PROID;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Orders orders = new Orders();
                orders.set_order_id(Integer.parseInt(cursor.getString(0)));
                orders.set_cusemail(cursor.getString(1));
                orders.set_proID(Integer.parseInt(cursor.getString(2)));
                orders.set_quantity(Integer.parseInt(cursor.getString(3)));
                orders.set_total_price(Integer.parseInt(cursor.getString(4)));
                orders.set_customer_name(retrieveName(cursor.getString(1),0));
                orders.set_product_name(retrieveName(cursor.getString(2),1));
                // Adding contact to list
                ordersList.add(orders);
            } while (cursor.moveToNext());
        }

        // return contact list
        return ordersList;
    }


    public void addSupplier(Suppliers suppliers) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SUPPLIER_NAME, suppliers.get_supplier_name());
        values.put(KEY_SUPPLIER_EMAIL, suppliers.get_supplier_email());
        values.put(KEY_SUPPLIER_ADDRESS, suppliers.get_supplier_address());
        values.put(KEY_SUPPLIER_CONTACT, suppliers.get_supplier_contact());

        // Inserting Row
        db.insert(TABLE_SUPPLIER, null, values);
        db.close(); // Closing database connection
    }

    // Getting All customers
    public List<Suppliers> getAllSuppliers() {
        List<Suppliers> suppliersList = new ArrayList<Suppliers>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SUPPLIER + " ORDER BY " + KEY_SUPPLIER_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Suppliers suppliers = new Suppliers();
                suppliers.set_supplier_id(Integer.parseInt(cursor.getString(0)));
                suppliers.set_supplier_name(cursor.getString(1));
                suppliers.set_supplier_email(cursor.getString(2));
                suppliers.set_supplier_address(cursor.getString(3));
                suppliers.set_supplier_contact(cursor.getString(4));
                // Adding contact to list
                suppliersList.add(suppliers);
            } while (cursor.moveToNext());
        }

        // return contact list
        return suppliersList;
    }

    // Deleting single customer
    public int deleteSupplier(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_SUPPLIER, KEY_SUPPLIER_NAME + " = ?" + " AND " + KEY_SUPPLIER_EMAIL + " = ?",
                new String[] { name, email });
        db.close();
        return i;
    }



    public List<Products> getTilesPaving() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Paving Tiles\""+ " AND "+ KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }

    public List<Products> getTilesFloor() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Floor Tiles\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTilesGlazed() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Glazed Vitrified Tiles\"" + " AND "+ KEY_QUANTITY + " IS NOT \"0\""+ " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTilesPolished() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Polished Vitrified Tiles\"" + " AND "+  KEY_QUANTITY + " IS NOT \"0\""+ " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTilesRoofing() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Roofing Tiles\"" + " AND "+  KEY_QUANTITY + " IS NOT \"0\""+ " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTilesWall() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Wall Tiles\"" + " AND "+  KEY_QUANTITY + " IS NOT \"0\""+ " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }


    public List<Products> getPipes() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Pipes & Fittings\"" + " AND "+ KEY_QUANTITY + " IS NOT \"0\""+ " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTanks() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Tanks\"" + " AND "+ KEY_QUANTITY + " IS NOT \"0\""+ " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }

    public int getQuantityFromProductID(int productID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] { KEY_QUANTITY}, KEY_PRODUCTID + "=?",
                new String[] { String.valueOf(productID) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        int quantity = Integer.parseInt(cursor.getString(0));

        return quantity;

    }

    public void InsertInitialValues(){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int[] adminID = new int[]{1,2};
        String[] fName = new String[]{"Shreyansh", "Shubham"};
        String[] lName = new String[]{"Gopawar", "Khandelwal"};
        String[] email = new String[]{"kudoshinichi@gmail.com", "shubhamkhandelwal18@gmail.com"};
        String[] cNum = new String[]{"9632587410", "9999912345"};
        int length = adminID.length;
        int count = 0;
        while (length != 0){
            contentValues.put(KEY_ADMINID, adminID[count]);
            contentValues.put(KEY_AFNAME, fName[count]);
            contentValues.put(KEY_ALNAME, lName[count]);
            contentValues.put(KEY_AEMAIL, email[count]);
            contentValues.put(KEY_ACONTACT, cNum[count]);
            sqLiteDatabase.insert(TABLE_ADMIN, null, contentValues);
            length--;
            count++;
        }

        sqLiteDatabase.close();
    }

    public void InsertInitialValu(){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int[] adminID = new int[]{1,2};
        String[] email = new String[]{"kudoshinichi@gmail.com", "shubhamkhandelwal18@gmail.com"};
        String[] pass = new String[] {"haibara", "shinchan"};
        int length = adminID.length;
        int count = 0;
        while (length != 0){
            contentValues.put(KEY_USERID, adminID[count]);
            contentValues.put(KEY_USERNAME, email[count]);
            contentValues.put(KEY_PASSWORD, pass[count]);
            sqLiteDatabase.insert(TABLE_USERS, null, contentValues);
            length--;
            count++;
        }

        sqLiteDatabase.close();
    }

    public List<Products> getBasinColored() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Colored Ceramic Basin\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getBasinMarbel() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Marbel Basin\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getBasinResin() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Resin Washbasin\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getBasinWall() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Wall Mounted Basin\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getBasinTable() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Table Mounted Basin\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getBasinWooden() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Wooden Basin\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getShowerDigital() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Digital Shower\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getShowerElectric() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Electric Shower\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getShowerMixer() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Mixer Shower\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getShowerPower() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Power Shower\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTapPillar() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Pillar Taps\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTapMixer() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Mixer Taps\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTapLong() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Long Handle Taps\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTapThermo() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Thermostatic Taps\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTubAlcove() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Alcove Bathtub\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTubDrop() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Drop-In Bathtub\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTubCorner() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Corner Bathtub\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getTubFree() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Free-Standing Bathtub\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getFlushDuel() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Duel FLush\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getFlushDoubleCyclone() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Double Cyclone Flush\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getFlushGravity() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Gravity Flush\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }
    public List<Products> getFlushPressure() {
        List<Products> productsList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_PRODUCT_TYPE + "= \"Pressure Assisted Flush\""+ " AND "+  KEY_QUANTITY + " IS NOT \"0\"" + " ORDER BY " + KEY_PRODUCT_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.set_product_id(Integer.parseInt(cursor.getString(0)));
                products.set_product_name(cursor.getString(1));
                products.set_product_type(cursor.getString(2));
                products.set_price(Integer.parseInt(cursor.getString(3)));
                products.set_brand(cursor.getString(4));
                products.set_quantity(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                productsList.add(products);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }

}
