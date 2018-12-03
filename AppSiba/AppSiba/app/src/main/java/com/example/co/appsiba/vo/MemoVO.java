package com.example.co.appsiba.vo;

public class MemoVO {

    private int memoId;
    private String ingredientName;
    private String checked;

    public MemoVO(){}

    public MemoVO(int memoId, String ingredientName, String checked) {
        this.memoId = memoId;
        this.ingredientName = ingredientName;
        this.checked = checked;
    }

    public int getMemoId() {
        return memoId;
    }

    public void setMemoId(int memoId) {
        this.memoId = memoId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

}