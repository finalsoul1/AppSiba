package app.siba.vo;

import java.util.List;

import app.siba.model.FoodType;
import lombok.Data;

@Data
public class FoodTypeJson {
	private long totalCnt;
	private List<FoodType> list;
}
