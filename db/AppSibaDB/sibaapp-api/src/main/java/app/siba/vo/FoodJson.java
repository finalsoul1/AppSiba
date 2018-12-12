package app.siba.vo;

import java.util.List;

import app.siba.model.Food;
import lombok.Data;

@Data
public class FoodJson {
	private long totalCnt;
	private List<Food> list;
}
