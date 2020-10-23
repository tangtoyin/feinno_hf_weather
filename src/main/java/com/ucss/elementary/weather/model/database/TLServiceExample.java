package com.ucss.elementary.weather.model.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLServiceExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppcodeIsNull() {
            addCriterion("APPCODE is null");
            return (Criteria) this;
        }

        public Criteria andAppcodeIsNotNull() {
            addCriterion("APPCODE is not null");
            return (Criteria) this;
        }

        public Criteria andAppcodeEqualTo(String value) {
            addCriterion("APPCODE =", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeNotEqualTo(String value) {
            addCriterion("APPCODE <>", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeGreaterThan(String value) {
            addCriterion("APPCODE >", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeGreaterThanOrEqualTo(String value) {
            addCriterion("APPCODE >=", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeLessThan(String value) {
            addCriterion("APPCODE <", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeLessThanOrEqualTo(String value) {
            addCriterion("APPCODE <=", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeLike(String value) {
            addCriterion("APPCODE like", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeNotLike(String value) {
            addCriterion("APPCODE not like", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeIn(List<String> values) {
            addCriterion("APPCODE in", values, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeNotIn(List<String> values) {
            addCriterion("APPCODE not in", values, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeBetween(String value1, String value2) {
            addCriterion("APPCODE between", value1, value2, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeNotBetween(String value1, String value2) {
            addCriterion("APPCODE not between", value1, value2, "appcode");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("METHOD is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("METHOD =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("METHOD <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("METHOD >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("METHOD >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("METHOD <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("METHOD <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("METHOD like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("METHOD not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("METHOD in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("METHOD not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("METHOD between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("METHOD not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andResultcodeIsNull() {
            addCriterion("RESULTCODE is null");
            return (Criteria) this;
        }

        public Criteria andResultcodeIsNotNull() {
            addCriterion("RESULTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andResultcodeEqualTo(String value) {
            addCriterion("RESULTCODE =", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotEqualTo(String value) {
            addCriterion("RESULTCODE <>", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeGreaterThan(String value) {
            addCriterion("RESULTCODE >", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RESULTCODE >=", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLessThan(String value) {
            addCriterion("RESULTCODE <", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLessThanOrEqualTo(String value) {
            addCriterion("RESULTCODE <=", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLike(String value) {
            addCriterion("RESULTCODE like", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotLike(String value) {
            addCriterion("RESULTCODE not like", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeIn(List<String> values) {
            addCriterion("RESULTCODE in", values, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotIn(List<String> values) {
            addCriterion("RESULTCODE not in", values, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeBetween(String value1, String value2) {
            addCriterion("RESULTCODE between", value1, value2, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotBetween(String value1, String value2) {
            addCriterion("RESULTCODE not between", value1, value2, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultmessageIsNull() {
            addCriterion("RESULTMESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andResultmessageIsNotNull() {
            addCriterion("RESULTMESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andResultmessageEqualTo(String value) {
            addCriterion("RESULTMESSAGE =", value, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageNotEqualTo(String value) {
            addCriterion("RESULTMESSAGE <>", value, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageGreaterThan(String value) {
            addCriterion("RESULTMESSAGE >", value, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageGreaterThanOrEqualTo(String value) {
            addCriterion("RESULTMESSAGE >=", value, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageLessThan(String value) {
            addCriterion("RESULTMESSAGE <", value, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageLessThanOrEqualTo(String value) {
            addCriterion("RESULTMESSAGE <=", value, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageLike(String value) {
            addCriterion("RESULTMESSAGE like", value, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageNotLike(String value) {
            addCriterion("RESULTMESSAGE not like", value, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageIn(List<String> values) {
            addCriterion("RESULTMESSAGE in", values, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageNotIn(List<String> values) {
            addCriterion("RESULTMESSAGE not in", values, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageBetween(String value1, String value2) {
            addCriterion("RESULTMESSAGE between", value1, value2, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andResultmessageNotBetween(String value1, String value2) {
            addCriterion("RESULTMESSAGE not between", value1, value2, "resultmessage");
            return (Criteria) this;
        }

        public Criteria andClientipIsNull() {
            addCriterion("CLIENTIP is null");
            return (Criteria) this;
        }

        public Criteria andClientipIsNotNull() {
            addCriterion("CLIENTIP is not null");
            return (Criteria) this;
        }

        public Criteria andClientipEqualTo(String value) {
            addCriterion("CLIENTIP =", value, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipNotEqualTo(String value) {
            addCriterion("CLIENTIP <>", value, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipGreaterThan(String value) {
            addCriterion("CLIENTIP >", value, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENTIP >=", value, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipLessThan(String value) {
            addCriterion("CLIENTIP <", value, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipLessThanOrEqualTo(String value) {
            addCriterion("CLIENTIP <=", value, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipLike(String value) {
            addCriterion("CLIENTIP like", value, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipNotLike(String value) {
            addCriterion("CLIENTIP not like", value, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipIn(List<String> values) {
            addCriterion("CLIENTIP in", values, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipNotIn(List<String> values) {
            addCriterion("CLIENTIP not in", values, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipBetween(String value1, String value2) {
            addCriterion("CLIENTIP between", value1, value2, "clientip");
            return (Criteria) this;
        }

        public Criteria andClientipNotBetween(String value1, String value2) {
            addCriterion("CLIENTIP not between", value1, value2, "clientip");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeIsNull() {
            addCriterion("ELAPSEDTIME is null");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeIsNotNull() {
            addCriterion("ELAPSEDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeEqualTo(Integer value) {
            addCriterion("ELAPSEDTIME =", value, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeNotEqualTo(Integer value) {
            addCriterion("ELAPSEDTIME <>", value, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeGreaterThan(Integer value) {
            addCriterion("ELAPSEDTIME >", value, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ELAPSEDTIME >=", value, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeLessThan(Integer value) {
            addCriterion("ELAPSEDTIME <", value, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeLessThanOrEqualTo(Integer value) {
            addCriterion("ELAPSEDTIME <=", value, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeIn(List<Integer> values) {
            addCriterion("ELAPSEDTIME in", values, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeNotIn(List<Integer> values) {
            addCriterion("ELAPSEDTIME not in", values, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeBetween(Integer value1, Integer value2) {
            addCriterion("ELAPSEDTIME between", value1, value2, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andElapsedtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ELAPSEDTIME not between", value1, value2, "elapsedtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
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