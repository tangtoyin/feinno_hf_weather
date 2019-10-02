package com.ucss.elementary.tnwn.model.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TBLongareacodePlaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBLongareacodePlaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeIsNull() {
            addCriterion("PLATFORMCODE is null");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeIsNotNull() {
            addCriterion("PLATFORMCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeEqualTo(String value) {
            addCriterion("PLATFORMCODE =", value, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeNotEqualTo(String value) {
            addCriterion("PLATFORMCODE <>", value, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeGreaterThan(String value) {
            addCriterion("PLATFORMCODE >", value, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PLATFORMCODE >=", value, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeLessThan(String value) {
            addCriterion("PLATFORMCODE <", value, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeLessThanOrEqualTo(String value) {
            addCriterion("PLATFORMCODE <=", value, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeLike(String value) {
            addCriterion("PLATFORMCODE like", value, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeNotLike(String value) {
            addCriterion("PLATFORMCODE not like", value, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeIn(List<String> values) {
            addCriterion("PLATFORMCODE in", values, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeNotIn(List<String> values) {
            addCriterion("PLATFORMCODE not in", values, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeBetween(String value1, String value2) {
            addCriterion("PLATFORMCODE between", value1, value2, "platformcode");
            return (Criteria) this;
        }

        public Criteria andPlatformcodeNotBetween(String value1, String value2) {
            addCriterion("PLATFORMCODE not between", value1, value2, "platformcode");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNull() {
            addCriterion("AREACODE is null");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNotNull() {
            addCriterion("AREACODE is not null");
            return (Criteria) this;
        }

        public Criteria andAreacodeEqualTo(String value) {
            addCriterion("AREACODE =", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotEqualTo(String value) {
            addCriterion("AREACODE <>", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThan(String value) {
            addCriterion("AREACODE >", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThanOrEqualTo(String value) {
            addCriterion("AREACODE >=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThan(String value) {
            addCriterion("AREACODE <", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThanOrEqualTo(String value) {
            addCriterion("AREACODE <=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLike(String value) {
            addCriterion("AREACODE like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotLike(String value) {
            addCriterion("AREACODE not like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeIn(List<String> values) {
            addCriterion("AREACODE in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotIn(List<String> values) {
            addCriterion("AREACODE not in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeBetween(String value1, String value2) {
            addCriterion("AREACODE between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotBetween(String value1, String value2) {
            addCriterion("AREACODE not between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeIsNull() {
            addCriterion("PLATFORMAREACODE is null");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeIsNotNull() {
            addCriterion("PLATFORMAREACODE is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeEqualTo(String value) {
            addCriterion("PLATFORMAREACODE =", value, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeNotEqualTo(String value) {
            addCriterion("PLATFORMAREACODE <>", value, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeGreaterThan(String value) {
            addCriterion("PLATFORMAREACODE >", value, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeGreaterThanOrEqualTo(String value) {
            addCriterion("PLATFORMAREACODE >=", value, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeLessThan(String value) {
            addCriterion("PLATFORMAREACODE <", value, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeLessThanOrEqualTo(String value) {
            addCriterion("PLATFORMAREACODE <=", value, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeLike(String value) {
            addCriterion("PLATFORMAREACODE like", value, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeNotLike(String value) {
            addCriterion("PLATFORMAREACODE not like", value, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeIn(List<String> values) {
            addCriterion("PLATFORMAREACODE in", values, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeNotIn(List<String> values) {
            addCriterion("PLATFORMAREACODE not in", values, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeBetween(String value1, String value2) {
            addCriterion("PLATFORMAREACODE between", value1, value2, "platformareacode");
            return (Criteria) this;
        }

        public Criteria andPlatformareacodeNotBetween(String value1, String value2) {
            addCriterion("PLATFORMAREACODE not between", value1, value2, "platformareacode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}