package app.siba.model;

import java.util.ArrayList;
import java.util.List;

public class IngredientListExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public IngredientListExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdIsNull() {
			addCriterion("ingredient_sub_category_id is null");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdIsNotNull() {
			addCriterion("ingredient_sub_category_id is not null");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdEqualTo(Integer value) {
			addCriterion("ingredient_sub_category_id =", value, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdNotEqualTo(Integer value) {
			addCriterion("ingredient_sub_category_id <>", value, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdGreaterThan(Integer value) {
			addCriterion("ingredient_sub_category_id >", value, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ingredient_sub_category_id >=", value, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdLessThan(Integer value) {
			addCriterion("ingredient_sub_category_id <", value, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdLessThanOrEqualTo(Integer value) {
			addCriterion("ingredient_sub_category_id <=", value, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdIn(List<Integer> values) {
			addCriterion("ingredient_sub_category_id in", values, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdNotIn(List<Integer> values) {
			addCriterion("ingredient_sub_category_id not in", values, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdBetween(Integer value1, Integer value2) {
			addCriterion("ingredient_sub_category_id between", value1, value2, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andIngredientSubCategoryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ingredient_sub_category_id not between", value1, value2, "ingredientSubCategoryId");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andFileNameIsNull() {
			addCriterion("file_name is null");
			return (Criteria) this;
		}

		public Criteria andFileNameIsNotNull() {
			addCriterion("file_name is not null");
			return (Criteria) this;
		}

		public Criteria andFileNameEqualTo(String value) {
			addCriterion("file_name =", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameNotEqualTo(String value) {
			addCriterion("file_name <>", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameGreaterThan(String value) {
			addCriterion("file_name >", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameGreaterThanOrEqualTo(String value) {
			addCriterion("file_name >=", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameLessThan(String value) {
			addCriterion("file_name <", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameLessThanOrEqualTo(String value) {
			addCriterion("file_name <=", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameLike(String value) {
			addCriterion("file_name like", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameNotLike(String value) {
			addCriterion("file_name not like", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameIn(List<String> values) {
			addCriterion("file_name in", values, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameNotIn(List<String> values) {
			addCriterion("file_name not in", values, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameBetween(String value1, String value2) {
			addCriterion("file_name between", value1, value2, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameNotBetween(String value1, String value2) {
			addCriterion("file_name not between", value1, value2, "fileName");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ingredient_list
	 * @mbg.generated  Fri Nov 23 12:12:08 KST 2018
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ingredient_list
     *
     * @mbg.generated do_not_delete_during_merge Fri Nov 23 11:57:36 KST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}