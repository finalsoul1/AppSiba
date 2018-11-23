package com.example.co.appsiba.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SibaDbHelper extends SQLiteOpenHelper {

    private static SibaDbHelper sInstance;

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Siba.db";

    // table name
    private static final String INGREDIENT_CATEGORY = "ingre_cate";
    private static final String INGERDIENT_SUB_CATEGORY = "ingre_sub_cate";
    private static final String INGERDIENT_LIST = "ingre_list";

    // 테이블 생성
    private static final String CREATE_TABLE_CATE = "CREATE TABLE "
            + INGREDIENT_CATEGORY + "(id INTEGER PRIMARY KEY, name TEXT)";

    private static final String CREATE_TABLE_SUB_CATE = "CREATE TABLE "
            + INGERDIENT_SUB_CATEGORY + "(id INTEGER PRIMARY KEY, ingredient_category_id INTEGER, name TEXT)";

    private static final String CREATE_TABLE_SUB_SUB_CATE = "CREATE TABLE "
            + INGERDIENT_LIST + "(id INTEGER PRIMARY KEY, ingredient_category_id INTEGER, name TEXT, file_name TEXT)";

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
    private static final String DELETE_TABLE_SUB_SUB_CATE = "DROP TABLE IF EXISTS " + INGERDIENT_LIST;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CATE);
        db.execSQL(CREATE_TABLE_SUB_CATE);
        db.execSQL(CREATE_TABLE_SUB_SUB_CATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE_CATE);
        db.execSQL(DELETE_TABLE_SUB_CATE);
        db.execSQL(DELETE_TABLE_SUB_SUB_CATE);

        onCreate(db);
    }
}
