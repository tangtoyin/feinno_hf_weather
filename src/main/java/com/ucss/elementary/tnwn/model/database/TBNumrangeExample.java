package com.ucss.elementary.tnwn.model.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TBNumrangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBNumrangeExample() {
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

        public Criteria andCitycodeIsNull() {
            addCriterion("CITYCODE is null");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNotNull() {
            addCriterion("CITYCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCitycodeEqualTo(String value) {
            addCriterion("CITYCODE =", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotEqualTo(String value) {
            addCriterion("CITYCODE <>", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThan(String value) {
            addCriterion("CITYCODE >", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITYCODE >=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThan(String value) {
            addCriterion("CITYCODE <", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThanOrEqualTo(String value) {
            addCriterion("CITYCODE <=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLike(String value) {
            addCriterion("CITYCODE like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotLike(String value) {
            addCriterion("CITYCODE not like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeIn(List<String> values) {
            addCriterion("CITYCODE in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotIn(List<String> values) {
            addCriterion("CITYCODE not in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeBetween(String value1, String value2) {
            addCriterion("CITYCODE between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotBetween(String value1, String value2) {
            addCriterion("CITYCODE not between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNull() {
            addCriterion("CITYNAME is null");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNotNull() {
            addCriterion("CITYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCitynameEqualTo(String value) {
            addCriterion("CITYNAME =", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotEqualTo(String value) {
            addCriterion("CITYNAME <>", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThan(String value) {
            addCriterion("CITYNAME >", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("CITYNAME >=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThan(String value) {
            addCriterion("CITYNAME <", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThanOrEqualTo(String value) {
            addCriterion("CITYNAME <=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLike(String value) {
            addCriterion("CITYNAME like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotLike(String value) {
            addCriterion("CITYNAME not like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameIn(List<String> values) {
            addCriterion("CITYNAME in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotIn(List<String> values) {
            addCriterion("CITYNAME not in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameBetween(String value1, String value2) {
            addCriterion("CITYNAME between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotBetween(String value1, String value2) {
            addCriterion("CITYNAME not between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andNumrangeIsNull() {
            addCriterion("NUMRANGE is null");
            return (Criteria) this;
        }

        public Criteria andNumrangeIsNotNull() {
            addCriterion("NUMRANGE is not null");
            return (Criteria) this;
        }

        public Criteria andNumrangeEqualTo(String value) {
            addCriterion("NUMRANGE =", value, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeNotEqualTo(String value) {
            addCriterion("NUMRANGE <>", value, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeGreaterThan(String value) {
            addCriterion("NUMRANGE >", value, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeGreaterThanOrEqualTo(String value) {
            addCriterion("NUMRANGE >=", value, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeLessThan(String value) {
            addCriterion("NUMRANGE <", value, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeLessThanOrEqualTo(String value) {
            addCriterion("NUMRANGE <=", value, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeLike(String value) {
            addCriterion("NUMRANGE like", value, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeNotLike(String value) {
            addCriterion("NUMRANGE not like", value, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeIn(List<String> values) {
            addCriterion("NUMRANGE in", values, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeNotIn(List<String> values) {
            addCriterion("NUMRANGE not in", values, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeBetween(String value1, String value2) {
            addCriterion("NUMRANGE between", value1, value2, "numrange");
            return (Criteria) this;
        }

        public Criteria andNumrangeNotBetween(String value1, String value2) {
            addCriterion("NUMRANGE not between", value1, value2, "numrange");
            return (Criteria) this;
        }

        public Criteria andImsiIsNull() {
            addCriterion("IMSI is null");
            return (Criteria) this;
        }

        public Criteria andImsiIsNotNull() {
            addCriterion("IMSI is not null");
            return (Criteria) this;
        }

        public Criteria andImsiEqualTo(String value) {
            addCriterion("IMSI =", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotEqualTo(String value) {
            addCriterion("IMSI <>", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThan(String value) {
            addCriterion("IMSI >", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThanOrEqualTo(String value) {
            addCriterion("IMSI >=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThan(String value) {
            addCriterion("IMSI <", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThanOrEqualTo(String value) {
            addCriterion("IMSI <=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLike(String value) {
            addCriterion("IMSI like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotLike(String value) {
            addCriterion("IMSI not like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiIn(List<String> values) {
            addCriterion("IMSI in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotIn(List<String> values) {
            addCriterion("IMSI not in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiBetween(String value1, String value2) {
            addCriterion("IMSI between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotBetween(String value1, String value2) {
            addCriterion("IMSI not between", value1, value2, "imsi");
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

        public Criteria andExpiprdateIsNull() {
            addCriterion("EXPIPRDATE is null");
            return (Criteria) this;
        }

        public Criteria andExpiprdateIsNotNull() {
            addCriterion("EXPIPRDATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpiprdateEqualTo(String value) {
            addCriterion("EXPIPRDATE =", value, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateNotEqualTo(String value) {
            addCriterion("EXPIPRDATE <>", value, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateGreaterThan(String value) {
            addCriterion("EXPIPRDATE >", value, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateGreaterThanOrEqualTo(String value) {
            addCriterion("EXPIPRDATE >=", value, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateLessThan(String value) {
            addCriterion("EXPIPRDATE <", value, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateLessThanOrEqualTo(String value) {
            addCriterion("EXPIPRDATE <=", value, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateLike(String value) {
            addCriterion("EXPIPRDATE like", value, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateNotLike(String value) {
            addCriterion("EXPIPRDATE not like", value, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateIn(List<String> values) {
            addCriterion("EXPIPRDATE in", values, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateNotIn(List<String> values) {
            addCriterion("EXPIPRDATE not in", values, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateBetween(String value1, String value2) {
            addCriterion("EXPIPRDATE between", value1, value2, "expiprdate");
            return (Criteria) this;
        }

        public Criteria andExpiprdateNotBetween(String value1, String value2) {
            addCriterion("EXPIPRDATE not between", value1, value2, "expiprdate");
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNull() {
            addCriterion("CLASSIFY is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNotNull() {
            addCriterion("CLASSIFY is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyEqualTo(String value) {
            addCriterion("CLASSIFY =", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotEqualTo(String value) {
            addCriterion("CLASSIFY <>", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThan(String value) {
            addCriterion("CLASSIFY >", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("CLASSIFY >=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThan(String value) {
            addCriterion("CLASSIFY <", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThanOrEqualTo(String value) {
            addCriterion("CLASSIFY <=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLike(String value) {
            addCriterion("CLASSIFY like", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotLike(String value) {
            addCriterion("CLASSIFY not like", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyIn(List<String> values) {
            addCriterion("CLASSIFY in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotIn(List<String> values) {
            addCriterion("CLASSIFY not in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyBetween(String value1, String value2) {
            addCriterion("CLASSIFY between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotBetween(String value1, String value2) {
            addCriterion("CLASSIFY not between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andServicerIsNull() {
            addCriterion("SERVICER is null");
            return (Criteria) this;
        }

        public Criteria andServicerIsNotNull() {
            addCriterion("SERVICER is not null");
            return (Criteria) this;
        }

        public Criteria andServicerEqualTo(String value) {
            addCriterion("SERVICER =", value, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerNotEqualTo(String value) {
            addCriterion("SERVICER <>", value, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerGreaterThan(String value) {
            addCriterion("SERVICER >", value, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICER >=", value, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerLessThan(String value) {
            addCriterion("SERVICER <", value, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerLessThanOrEqualTo(String value) {
            addCriterion("SERVICER <=", value, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerLike(String value) {
            addCriterion("SERVICER like", value, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerNotLike(String value) {
            addCriterion("SERVICER not like", value, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerIn(List<String> values) {
            addCriterion("SERVICER in", values, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerNotIn(List<String> values) {
            addCriterion("SERVICER not in", values, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerBetween(String value1, String value2) {
            addCriterion("SERVICER between", value1, value2, "servicer");
            return (Criteria) this;
        }

        public Criteria andServicerNotBetween(String value1, String value2) {
            addCriterion("SERVICER not between", value1, value2, "servicer");
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

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andServicernameIsNull() {
            addCriterion("SERVICERNAME is null");
            return (Criteria) this;
        }

        public Criteria andServicernameIsNotNull() {
            addCriterion("SERVICERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andServicernameEqualTo(String value) {
            addCriterion("SERVICERNAME =", value, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameNotEqualTo(String value) {
            addCriterion("SERVICERNAME <>", value, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameGreaterThan(String value) {
            addCriterion("SERVICERNAME >", value, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICERNAME >=", value, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameLessThan(String value) {
            addCriterion("SERVICERNAME <", value, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameLessThanOrEqualTo(String value) {
            addCriterion("SERVICERNAME <=", value, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameLike(String value) {
            addCriterion("SERVICERNAME like", value, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameNotLike(String value) {
            addCriterion("SERVICERNAME not like", value, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameIn(List<String> values) {
            addCriterion("SERVICERNAME in", values, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameNotIn(List<String> values) {
            addCriterion("SERVICERNAME not in", values, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameBetween(String value1, String value2) {
            addCriterion("SERVICERNAME between", value1, value2, "servicername");
            return (Criteria) this;
        }

        public Criteria andServicernameNotBetween(String value1, String value2) {
            addCriterion("SERVICERNAME not between", value1, value2, "servicername");
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

        public Criteria andBeginnoIsNull() {
            addCriterion("BEGINNO is null");
            return (Criteria) this;
        }

        public Criteria andBeginnoIsNotNull() {
            addCriterion("BEGINNO is not null");
            return (Criteria) this;
        }

        public Criteria andBeginnoEqualTo(String value) {
            addCriterion("BEGINNO =", value, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoNotEqualTo(String value) {
            addCriterion("BEGINNO <>", value, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoGreaterThan(String value) {
            addCriterion("BEGINNO >", value, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoGreaterThanOrEqualTo(String value) {
            addCriterion("BEGINNO >=", value, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoLessThan(String value) {
            addCriterion("BEGINNO <", value, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoLessThanOrEqualTo(String value) {
            addCriterion("BEGINNO <=", value, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoLike(String value) {
            addCriterion("BEGINNO like", value, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoNotLike(String value) {
            addCriterion("BEGINNO not like", value, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoIn(List<String> values) {
            addCriterion("BEGINNO in", values, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoNotIn(List<String> values) {
            addCriterion("BEGINNO not in", values, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoBetween(String value1, String value2) {
            addCriterion("BEGINNO between", value1, value2, "beginno");
            return (Criteria) this;
        }

        public Criteria andBeginnoNotBetween(String value1, String value2) {
            addCriterion("BEGINNO not between", value1, value2, "beginno");
            return (Criteria) this;
        }

        public Criteria andEndnoIsNull() {
            addCriterion("ENDNO is null");
            return (Criteria) this;
        }

        public Criteria andEndnoIsNotNull() {
            addCriterion("ENDNO is not null");
            return (Criteria) this;
        }

        public Criteria andEndnoEqualTo(String value) {
            addCriterion("ENDNO =", value, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoNotEqualTo(String value) {
            addCriterion("ENDNO <>", value, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoGreaterThan(String value) {
            addCriterion("ENDNO >", value, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoGreaterThanOrEqualTo(String value) {
            addCriterion("ENDNO >=", value, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoLessThan(String value) {
            addCriterion("ENDNO <", value, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoLessThanOrEqualTo(String value) {
            addCriterion("ENDNO <=", value, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoLike(String value) {
            addCriterion("ENDNO like", value, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoNotLike(String value) {
            addCriterion("ENDNO not like", value, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoIn(List<String> values) {
            addCriterion("ENDNO in", values, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoNotIn(List<String> values) {
            addCriterion("ENDNO not in", values, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoBetween(String value1, String value2) {
            addCriterion("ENDNO between", value1, value2, "endno");
            return (Criteria) this;
        }

        public Criteria andEndnoNotBetween(String value1, String value2) {
            addCriterion("ENDNO not between", value1, value2, "endno");
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