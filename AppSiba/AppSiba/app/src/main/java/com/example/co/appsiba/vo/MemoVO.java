package com.example.co.appsiba.vo;

public class MemoVO {

    private String ingredientName;
    private String checkBoxCheckedStatus;

    public MemoVO(String ingredientName, String checkBoxCheckedStatus) {
        this.ingredientName = ingredientName;
        this.checkBoxCheckedStatus = checkBoxCheckedStatus;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getCheckBoxCheckedStatus() {
        return checkBoxCheckedStatus;
    }

    public void setCheckBoxCheckedStatus(String checkBoxCheckedStatus) {
        this.checkBoxCheckedStatus = checkBoxCheckedStatus;
    }

}
