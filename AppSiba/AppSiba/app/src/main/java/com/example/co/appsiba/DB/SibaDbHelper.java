package com.example.co.appsiba.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SibaDbHelper extends SQLiteOpenHelper {

    private static SibaDbHelper sInstance;

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Siba.db";

    // table name, readonly
    private static final String INGREDIENT_CATEGORY = "ingredient_category";
    private static final String INGERDIENT_SUB_CATEGORY = "ingredient_sub_category";
    private static final String INGERDIENT_LIST = "ingredient_list";
    private static final String FOOD_TYPE = "food_type";
    private static final String FOOD = "food";
    private static final String FOOD_RECIPE = "food_recipe";
    private static final String FOOD_INGREDIENTS = "food_ingredients";

    // writable
    private static final String MY_FAVORATES = "my_favorates";
    private static final String MY_NOTEPAD = "my_notepad";
    private static final String MY_REFRIGERATOR = "my_refrigerator";



    // 테이블 생성
    private static final String CREATE_TABLE_CATE = "CREATE TABLE "
            + INGREDIENT_CATEGORY + "(id INTEGER PRIMARY KEY, name TEXT)";

    private static final String CREATE_TABLE_SUB_CATE = "CREATE TABLE "
            + INGERDIENT_SUB_CATEGORY + "(id INTEGER PRIMARY KEY, ingredient_category_id INTEGER, name TEXT)";

    private static final String CREATE_INGERDIENT_LIST = "CREATE TABLE "
            + INGERDIENT_LIST + "(id INTEGER PRIMARY KEY, ingredient_sub_category_id INTEGER, name TEXT, file_name TEXT)";

    private static final String CREATE_FOOD_TYPE = "CREATE TABLE " + FOOD_TYPE + "(id INTEGER PRIMARY KEY, name TEXT)";

    private static final String CREATE_FOOD = "CREATE TABLE " + FOOD
            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, food_type_id INTEGER, calorie REAL, carbohydrate REAL, protein REAL, fat REAL," +
            " natrium REAL, small_image_location TEXT, big_image_location TEXT, ingredients TEXT)";

    private static final String CREATE_FOOD_RECIPE = "CREATE TABLE "
            + FOOD_RECIPE + "(id INTEGER PRIMARY KEY AUTOINCREMENT, food_id INTEGER, recipe_desc TEXT, image_location TEXT, ord INTEGER)";

    private static final String CREATE_FOOD_INGREDIENTS = "CREATE TABLE "
            + FOOD_INGREDIENTS + "(id INTEGER PRIMARY KEY AUTOINCREMENT, food_id INTEGER, name TEXT)";


    private static final String CREATE_MY_FAVORATES = "CREATE TABLE "
            + MY_FAVORATES + "(id INTEGER PRIMARY KEY, food_id INTEGER, reg_data INTEGER)";

    private static final String CREATE_MY_NOTEPAD = "CREATE TABLE "
            + MY_NOTEPAD + "(id INTEGER PRIMARY KEY, ingredient_name TEXT, checked TEXT, reg_date DATETIME DEFAULT CURRENT_TIMESTAMP)";

    private static final String CREATE_MY_REFRIGERATOR = "CREATE TABLE "
            + MY_REFRIGERATOR + "(id INTEGER PRIMARY KEY, ingredient_list_id INTEGER)";



    private SibaDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static synchronized SibaDbHelper getInstance(Context context) {
        // 액티비티의 context가 메모리 릭을 발생할 수 있으므로
        // application context를 사용하는 것이 좋다
        if(sInstance == null) {
            sInstance = new SibaDbHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    // 테이블 삭제
    private static final String DELETE_TABLE_CATE = "DROP TABLE IF EXISTS " + INGREDIENT_CATEGORY;
    private static final String DELETE_TABLE_SUB_CATE = "DROP TABLE IF EXISTS " + INGERDIENT_SUB_CATEGORY;
    private static final String DELETE_TABLE_INGERDIENT_LIST = "DROP TABLE IF EXISTS " + INGERDIENT_LIST;
    private static final String DELETE_TABLE_FOOD_TYPE = "DROP TABLE IF EXISTS " + FOOD_TYPE;
    private static final String DELETE_TABLE_FOOD_RECIPE = "DROP TABLE IF EXISTS " + FOOD_RECIPE;
    private static final String DELETE_TABLE_FOOD_INGREDIENTS = "DROP TABLE IF EXISTS " + FOOD_INGREDIENTS;
    private static final String DELETE_TABLE_FOOD = "DROP TABLE IF EXISTS " + FOOD;

    private static final String DELETE_MY_FAVORATES = "DROP TABLE IF EXISTS " + MY_FAVORATES;
    private static final String DELETE_MY_NOTEPAD = "DROP TABLE IF EXISTS " + MY_NOTEPAD;
    private static final String DELETE_MY_REFRIGERATOR = "DROP TABLE IF EXISTS " + MY_REFRIGERATOR;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CATE);
        db.execSQL(CREATE_TABLE_SUB_CATE);
        db.execSQL(CREATE_INGERDIENT_LIST);
        db.execSQL(CREATE_FOOD_TYPE);
        db.execSQL(CREATE_FOOD);
        db.execSQL(CREATE_FOOD_RECIPE);
        db.execSQL(CREATE_FOOD_INGREDIENTS);

        db.execSQL(CREATE_MY_FAVORATES);
        db.execSQL(CREATE_MY_NOTEPAD);
        db.execSQL(CREATE_MY_REFRIGERATOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // v1.0 테이블 2개 <-- 기존 데이터

        // v2.0 테이블 3개 업그레이드
        // - 기존 데이터를 객체로 캐싱
        // - 기존 테이블 삭제
        // - 새 테이블 3개를 생성
        // - 기존 데이터를 새 테이블에 저장

        db.execSQL(DELETE_TABLE_CATE);
        db.execSQL(DELETE_TABLE_SUB_CATE);
        db.execSQL(DELETE_TABLE_INGERDIENT_LIST);
        db.execSQL(DELETE_TABLE_FOOD_TYPE);
        db.execSQL(DELETE_TABLE_FOOD);
        db.execSQL(DELETE_TABLE_FOOD_RECIPE);
        db.execSQL(DELETE_TABLE_FOOD_INGREDIENTS);

        db.execSQL(DELETE_MY_FAVORATES);
        db.execSQL(DELETE_MY_NOTEPAD);
        db.execSQL(DELETE_MY_REFRIGERATOR);

        onCreate(db);
    }

}