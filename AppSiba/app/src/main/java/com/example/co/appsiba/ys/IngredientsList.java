package com.example.co.appsiba.ys;

public class IngredientsList {

    private String inameOnFormerPage;
    private String inameOnCurrentPage;

    public String getIname() {
        return inameOnFormerPage;
    }

    public void addOnMemo(){
        inameOnFormerPage = editText.text;
        inameOnCurrentPage = inameOnFormerPage;

        textView3.text = inameOnCurrentPage;
    }
}
