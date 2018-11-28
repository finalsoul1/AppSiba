package com.example.co.appsiba.memo;

public class Memo {

    private String ingredientName;
//    private CheckBox memoCheckBox;

    public Memo(String ingredientName) {
        this.ingredientName = ingredientName;
//        this.memoCheckBox = checkBoxStatus;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

//    public CheckBox getMemoCheckBox() {
//        return memoCheckBox;
//    }
//
//    public void setMemoCheckBox(CheckBox memoCheckBox) {
//        this.memoCheckBox = memoCheckBox;
//    }

}
