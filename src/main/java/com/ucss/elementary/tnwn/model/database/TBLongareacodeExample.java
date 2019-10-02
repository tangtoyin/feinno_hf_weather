package com.ucss.elementary.tnwn.model.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TBLongareacodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBLongareacodeExample() {
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

        public Criteria andProcidIsNull() {
            addCriterion("PROCID is null");
            return (Criteria) this;
        }

        public Criteria andProcidIsNotNull() {
            addCriterion("PROCID is not null");
            return (Criteria) this;
        }

        public Criteria andProcidEqualTo(String value) {
            addCriterion("PROCID =", value, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidNotEqualTo(String value) {
            addCriterion("PROCID <>", value, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidGreaterThan(String value) {
            addCriterion("PROCID >", value, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidGreaterThanOrEqualTo(String value) {
            addCriterion("PROCID >=", value, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidLessThan(String value) {
            addCriterion("PROCID <", value, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidLessThanOrEqualTo(String value) {
            addCriterion("PROCID <=", value, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidLike(String value) {
            addCriterion("PROCID like", value, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidNotLike(String value) {
            addCriterion("PROCID not like", value, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidIn(List<String> values) {
            addCriterion("PROCID in", values, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidNotIn(List<String> values) {
            addCriterion("PROCID not in", values, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidBetween(String value1, String value2) {
            addCriterion("PROCID between", value1, value2, "procid");
            return (Criteria) this;
        }

        public Criteria andProcidNotBetween(String value1, String value2) {
            addCriterion("PROCID not between", value1, value2, "procid");
            return (Criteria) this;
        }

        public Criteria andOpertypeIsNull() {
            addCriterion("OPERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpertypeIsNotNull() {
            addCriterion("OPERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpertypeEqualTo(String value) {
            addCriterion("OPERTYPE =", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeNotEqualTo(String value) {
            addCriterion("OPERTYPE <>", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeGreaterThan(String value) {
            addCriterion("OPERTYPE >", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPERTYPE >=", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeLessThan(String value) {
            addCriterion("OPERTYPE <", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeLessThanOrEqualTo(String value) {
            addCriterion("OPERTYPE <=", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeLike(String value) {
            addCriterion("OPERTYPE like", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeNotLike(String value) {
            addCriterion("OPERTYPE not like", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeIn(List<String> values) {
            addCriterion("OPERTYPE in", values, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeNotIn(List<String> values) {
            addCriterion("OPERTYPE not in", values, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeBetween(String value1, String value2) {
            addCriterion("OPERTYPE between", value1, value2, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeNotBetween(String value1, String value2) {
            addCriterion("OPERTYPE not between", value1, value2, "opertype");
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

        public Criteria andProvcodeIsNull() {
            addCriterion("PROVCODE is null");
            return (Criteria) this;
        }

        public Criteria andProvcodeIsNotNull() {
            addCriterion("PROVCODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvcodeEqualTo(String value) {
            addCriterion("PROVCODE =", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeNotEqualTo(String value) {
            addCriterion("PROVCODE <>", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeGreaterThan(String value) {
            addCriterion("PROVCODE >", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVCODE >=", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeLessThan(String value) {
            addCriterion("PROVCODE <", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeLessThanOrEqualTo(String value) {
            addCriterion("PROVCODE <=", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeLike(String value) {
            addCriterion("PROVCODE like", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeNotLike(String value) {
            addCriterion("PROVCODE not like", value, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeIn(List<String> values) {
            addCriterion("PROVCODE in", values, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeNotIn(List<String> values) {
            addCriterion("PROVCODE not in", values, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeBetween(String value1, String value2) {
            addCriterion("PROVCODE between", value1, value2, "provcode");
            return (Criteria) this;
        }

        public Criteria andProvcodeNotBetween(String value1, String value2) {
            addCriterion("PROVCODE not between", value1, value2, "provcode");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNull() {
            addCriterion("AREANAME is null");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNotNull() {
            addCriterion("AREANAME is not null");
            return (Criteria) this;
        }

        public Criteria andAreanameEqualTo(String value) {
            addCriterion("AREANAME =", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotEqualTo(String value) {
            addCriterion("AREANAME <>", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThan(String value) {
            addCriterion("AREANAME >", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThanOrEqualTo(String value) {
            addCriterion("AREANAME >=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThan(String value) {
            addCriterion("AREANAME <", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThanOrEqualTo(String value) {
            addCriterion("AREANAME <=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLike(String value) {
            addCriterion("AREANAME like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotLike(String value) {
            addCriterion("AREANAME not like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameIn(List<String> values) {
            addCriterion("AREANAME in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotIn(List<String> values) {
            addCriterion("AREANAME not in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameBetween(String value1, String value2) {
            addCriterion("AREANAME between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotBetween(String value1, String value2) {
            addCriterion("AREANAME not between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andValiddateIsNull() {
            addCriterion("VALIDDATE is null");
            return (Criteria) this;
        }

        public Criteria andValiddateIsNotNull() {
            addCriterion("VALIDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andValiddateEqualTo(String value) {
            addCriterion("VALIDDATE =", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateNotEqualTo(String value) {
            addCriterion("VALIDDATE <>", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateGreaterThan(String value) {
            addCriterion("VALIDDATE >", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateGreaterThanOrEqualTo(String value) {
            addCriterion("VALIDDATE >=", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateLessThan(String value) {
            addCriterion("VALIDDATE <", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateLessThanOrEqualTo(String value) {
            addCriterion("VALIDDATE <=", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateLike(String value) {
            addCriterion("VALIDDATE like", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateNotLike(String value) {
            addCriterion("VALIDDATE not like", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateIn(List<String> values) {
            addCriterion("VALIDDATE in", values, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateNotIn(List<String> values) {
            addCriterion("VALIDDATE not in", values, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateBetween(String value1, String value2) {
            addCriterion("VALIDDATE between", value1, value2, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateNotBetween(String value1, String value2) {
            addCriterion("VALIDDATE not between", value1, value2, "validdate");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNull() {
            addCriterion("EXPIREDATE is null");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNotNull() {
            addCriterion("EXPIREDATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredateEqualTo(String value) {
            addCriterion("EXPIREDATE =", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotEqualTo(String value) {
            addCriterion("EXPIREDATE <>", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThan(String value) {
            addCriterion("EXPIREDATE >", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThanOrEqualTo(String value) {
            addCriterion("EXPIREDATE >=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThan(String value) {
            addCriterion("EXPIREDATE <", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThanOrEqualTo(String value) {
            addCriterion("EXPIREDATE <=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLike(String value) {
            addCriterion("EXPIREDATE like", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotLike(String value) {
            addCriterion("EXPIREDATE not like", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateIn(List<String> values) {
            addCriterion("EXPIREDATE in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotIn(List<String> values) {
            addCriterion("EXPIREDATE not in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateBetween(String value1, String value2) {
            addCriterion("EXPIREDATE between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotBetween(String value1, String value2) {
            addCriterion("EXPIREDATE not between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("TIMESTAMP is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("TIMESTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(String value) {
            addCriterion("TIMESTAMP =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(String value) {
            addCriterion("TIMESTAMP <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(String value) {
            addCriterion("TIMESTAMP >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("TIMESTAMP >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(String value) {
            addCriterion("TIMESTAMP <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(String value) {
            addCriterion("TIMESTAMP <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLike(String value) {
            addCriterion("TIMESTAMP like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotLike(String value) {
            addCriterion("TIMESTAMP not like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<String> values) {
            addCriterion("TIMESTAMP in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<String> values) {
            addCriterion("TIMESTAMP not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(String value1, String value2) {
            addCriterion("TIMESTAMP between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(String value1, String value2) {
            addCriterion("TIMESTAMP not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNull() {
            addCriterion("ISVALID is null");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNotNull() {
            addCriterion("ISVALID is not null");
            return (Criteria) this;
        }

        public Criteria andIsvalidEqualTo(Short value) {
            addCriterion("ISVALID =", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotEqualTo(Short value) {
            addCriterion("ISVALID <>", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThan(Short value) {
            addCriterion("ISVALID >", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThanOrEqualTo(Short value) {
            addCriterion("ISVALID >=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThan(Short value) {
            addCriterion("ISVALID <", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThanOrEqualTo(Short value) {
            addCriterion("ISVALID <=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidIn(List<Short> values) {
            addCriterion("ISVALID in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotIn(List<Short> values) {
            addCriterion("ISVALID not in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidBetween(Short value1, Short value2) {
            addCriterion("ISVALID between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotBetween(Short value1, Short value2) {
            addCriterion("ISVALID not between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andLocationcodeIsNull() {
            addCriterion("LOCATIONCODE is null");
            return (Criteria) this;
        }

        public Criteria andLocationcodeIsNotNull() {
            addCriterion("LOCATIONCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLocationcodeEqualTo(String value) {
            addCriterion("LOCATIONCODE =", value, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeNotEqualTo(String value) {
            addCriterion("LOCATIONCODE <>", value, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeGreaterThan(String value) {
            addCriterion("LOCATIONCODE >", value, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATIONCODE >=", value, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeLessThan(String value) {
            addCriterion("LOCATIONCODE <", value, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeLessThanOrEqualTo(String value) {
            addCriterion("LOCATIONCODE <=", value, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeLike(String value) {
            addCriterion("LOCATIONCODE like", value, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeNotLike(String value) {
            addCriterion("LOCATIONCODE not like", value, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeIn(List<String> values) {
            addCriterion("LOCATIONCODE in", values, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeNotIn(List<String> values) {
            addCriterion("LOCATIONCODE not in", values, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeBetween(String value1, String value2) {
            addCriterion("LOCATIONCODE between", value1, value2, "locationcode");
            return (Criteria) this;
        }

        public Criteria andLocationcodeNotBetween(String value1, String value2) {
            addCriterion("LOCATIONCODE not between", value1, value2, "locationcode");
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