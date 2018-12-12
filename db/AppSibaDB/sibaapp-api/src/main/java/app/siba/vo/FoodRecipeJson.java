package app.siba.vo;

import java.util.List;

import app.siba.model.FoodRecipe;
import lombok.Data;

@Data
public class FoodRecipeJson {
	private long totalCnt;
	private List<FoodRecipe> list;
}
