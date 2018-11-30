package app.siba.vo;
import java.util.List;


import app.siba.model.IngredientSubCategory;
import lombok.Data;

@Data
public class IngredientSubCategoryJson {
	private long totalCnt;
	private List<IngredientSubCategory> list;
}
