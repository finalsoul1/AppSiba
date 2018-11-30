package app.siba.vo;

import java.util.List;

import app.siba.model.IngredientCategory;
import lombok.Data;

@Data
public class IngredientCategoryJson {
	private long totalCnt;
	private List<IngredientCategory> list;
}
