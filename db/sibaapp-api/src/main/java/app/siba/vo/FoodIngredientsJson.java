package app.siba.vo;

import java.util.List;

import app.siba.model.FoodIngredients;
import lombok.Data;


@Data
public class FoodIngredientsJson {
	private long totalCnt;
	private List<FoodIngredients> list;
}
