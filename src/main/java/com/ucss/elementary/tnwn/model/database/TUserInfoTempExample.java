package com.ucss.elementary.tnwn.model.database;

import java.util.ArrayList;
import java.util.List;

public class TUserInfoTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserInfoTempExample() {
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

        public Criteria andServicenumIsNull() {
            addCriterion("SERVICENUM is null");
            return (Criteria) this;
        }

        public Criteria andServicenumIsNotNull() {
            addCriterion("SERVICENUM is not null");
            return (Criteria) this;
        }

        public Criteria andServicenumEqualTo(String value) {
            addCriterion("SERVICENUM =", value, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumNotEqualTo(String value) {
            addCriterion("SERVICENUM <>", value, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumGreaterThan(String value) {
            addCriterion("SERVICENUM >", value, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICENUM >=", value, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumLessThan(String value) {
            addCriterion("SERVICENUM <", value, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumLessThanOrEqualTo(String value) {
            addCriterion("SERVICENUM <=", value, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumLike(String value) {
            addCriterion("SERVICENUM like", value, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumNotLike(String value) {
            addCriterion("SERVICENUM not like", value, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumIn(List<String> values) {
            addCriterion("SERVICENUM in", values, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumNotIn(List<String> values) {
            addCriterion("SERVICENUM not in", values, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumBetween(String value1, String value2) {
            addCriterion("SERVICENUM between", value1, value2, "servicenum");
            return (Criteria) this;
        }

        public Criteria andServicenumNotBetween(String value1, String value2) {
            addCriterion("SERVICENUM not between", value1, value2, "servicenum");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStatedescIsNull() {
            addCriterion("STATEDESC is null");
            return (Criteria) this;
        }

        public Criteria andStatedescIsNotNull() {
            addCriterion("STATEDESC is not null");
            return (Criteria) this;
        }

        public Criteria andStatedescEqualTo(String value) {
            addCriterion("STATEDESC =", value, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescNotEqualTo(String value) {
            addCriterion("STATEDESC <>", value, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescGreaterThan(String value) {
            addCriterion("STATEDESC >", value, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescGreaterThanOrEqualTo(String value) {
            addCriterion("STATEDESC >=", value, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescLessThan(String value) {
            addCriterion("STATEDESC <", value, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescLessThanOrEqualTo(String value) {
            addCriterion("STATEDESC <=", value, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescLike(String value) {
            addCriterion("STATEDESC like", value, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescNotLike(String value) {
            addCriterion("STATEDESC not like", value, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescIn(List<String> values) {
            addCriterion("STATEDESC in", values, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescNotIn(List<String> values) {
            addCriterion("STATEDESC not in", values, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescBetween(String value1, String value2) {
            addCriterion("STATEDESC between", value1, value2, "statedesc");
            return (Criteria) this;
        }

        public Criteria andStatedescNotBetween(String value1, String value2) {
            addCriterion("STATEDESC not between", value1, value2, "statedesc");
            return (Criteria) this;
        }

        public Criteria andNetidIsNull() {
            addCriterion("NETID is null");
            return (Criteria) this;
        }

        public Criteria andNetidIsNotNull() {
            addCriterion("NETID is not null");
            return (Criteria) this;
        }

        public Criteria andNetidEqualTo(String value) {
            addCriterion("NETID =", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidNotEqualTo(String value) {
            addCriterion("NETID <>", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidGreaterThan(String value) {
            addCriterion("NETID >", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidGreaterThanOrEqualTo(String value) {
            addCriterion("NETID >=", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidLessThan(String value) {
            addCriterion("NETID <", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidLessThanOrEqualTo(String value) {
            addCriterion("NETID <=", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidLike(String value) {
            addCriterion("NETID like", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidNotLike(String value) {
            addCriterion("NETID not like", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidIn(List<String> values) {
            addCriterion("NETID in", values, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidNotIn(List<String> values) {
            addCriterion("NETID not in", values, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidBetween(String value1, String value2) {
            addCriterion("NETID between", value1, value2, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidNotBetween(String value1, String value2) {
            addCriterion("NETID not between", value1, value2, "netid");
            return (Criteria) this;
        }

        public Criteria andNetiddescIsNull() {
            addCriterion("NETIDDESC is null");
            return (Criteria) this;
        }

        public Criteria andNetiddescIsNotNull() {
            addCriterion("NETIDDESC is not null");
            return (Criteria) this;
        }

        public Criteria andNetiddescEqualTo(String value) {
            addCriterion("NETIDDESC =", value, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescNotEqualTo(String value) {
            addCriterion("NETIDDESC <>", value, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescGreaterThan(String value) {
            addCriterion("NETIDDESC >", value, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescGreaterThanOrEqualTo(String value) {
            addCriterion("NETIDDESC >=", value, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescLessThan(String value) {
            addCriterion("NETIDDESC <", value, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescLessThanOrEqualTo(String value) {
            addCriterion("NETIDDESC <=", value, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescLike(String value) {
            addCriterion("NETIDDESC like", value, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescNotLike(String value) {
            addCriterion("NETIDDESC not like", value, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescIn(List<String> values) {
            addCriterion("NETIDDESC in", values, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescNotIn(List<String> values) {
            addCriterion("NETIDDESC not in", values, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescBetween(String value1, String value2) {
            addCriterion("NETIDDESC between", value1, value2, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andNetiddescNotBetween(String value1, String value2) {
            addCriterion("NETIDDESC not between", value1, value2, "netiddesc");
            return (Criteria) this;
        }

        public Criteria andPortinidIsNull() {
            addCriterion("PORTINID is null");
            return (Criteria) this;
        }

        public Criteria andPortinidIsNotNull() {
            addCriterion("PORTINID is not null");
            return (Criteria) this;
        }

        public Criteria andPortinidEqualTo(String value) {
            addCriterion("PORTINID =", value, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidNotEqualTo(String value) {
            addCriterion("PORTINID <>", value, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidGreaterThan(String value) {
            addCriterion("PORTINID >", value, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidGreaterThanOrEqualTo(String value) {
            addCriterion("PORTINID >=", value, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidLessThan(String value) {
            addCriterion("PORTINID <", value, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidLessThanOrEqualTo(String value) {
            addCriterion("PORTINID <=", value, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidLike(String value) {
            addCriterion("PORTINID like", value, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidNotLike(String value) {
            addCriterion("PORTINID not like", value, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidIn(List<String> values) {
            addCriterion("PORTINID in", values, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidNotIn(List<String> values) {
            addCriterion("PORTINID not in", values, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidBetween(String value1, String value2) {
            addCriterion("PORTINID between", value1, value2, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortinidNotBetween(String value1, String value2) {
            addCriterion("PORTINID not between", value1, value2, "portinid");
            return (Criteria) this;
        }

        public Criteria andPortiniddescIsNull() {
            addCriterion("PORTINIDDESC is null");
            return (Criteria) this;
        }

        public Criteria andPortiniddescIsNotNull() {
            addCriterion("PORTINIDDESC is not null");
            return (Criteria) this;
        }

        public Criteria andPortiniddescEqualTo(String value) {
            addCriterion("PORTINIDDESC =", value, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescNotEqualTo(String value) {
            addCriterion("PORTINIDDESC <>", value, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescGreaterThan(String value) {
            addCriterion("PORTINIDDESC >", value, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescGreaterThanOrEqualTo(String value) {
            addCriterion("PORTINIDDESC >=", value, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescLessThan(String value) {
            addCriterion("PORTINIDDESC <", value, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescLessThanOrEqualTo(String value) {
            addCriterion("PORTINIDDESC <=", value, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescLike(String value) {
            addCriterion("PORTINIDDESC like", value, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescNotLike(String value) {
            addCriterion("PORTINIDDESC not like", value, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescIn(List<String> values) {
            addCriterion("PORTINIDDESC in", values, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescNotIn(List<String> values) {
            addCriterion("PORTINIDDESC not in", values, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescBetween(String value1, String value2) {
            addCriterion("PORTINIDDESC between", value1, value2, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortiniddescNotBetween(String value1, String value2) {
            addCriterion("PORTINIDDESC not between", value1, value2, "portiniddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutidIsNull() {
            addCriterion("PORTOUTID is null");
            return (Criteria) this;
        }

        public Criteria andPortoutidIsNotNull() {
            addCriterion("PORTOUTID is not null");
            return (Criteria) this;
        }

        public Criteria andPortoutidEqualTo(String value) {
            addCriterion("PORTOUTID =", value, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidNotEqualTo(String value) {
            addCriterion("PORTOUTID <>", value, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidGreaterThan(String value) {
            addCriterion("PORTOUTID >", value, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidGreaterThanOrEqualTo(String value) {
            addCriterion("PORTOUTID >=", value, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidLessThan(String value) {
            addCriterion("PORTOUTID <", value, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidLessThanOrEqualTo(String value) {
            addCriterion("PORTOUTID <=", value, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidLike(String value) {
            addCriterion("PORTOUTID like", value, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidNotLike(String value) {
            addCriterion("PORTOUTID not like", value, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidIn(List<String> values) {
            addCriterion("PORTOUTID in", values, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidNotIn(List<String> values) {
            addCriterion("PORTOUTID not in", values, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidBetween(String value1, String value2) {
            addCriterion("PORTOUTID between", value1, value2, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutidNotBetween(String value1, String value2) {
            addCriterion("PORTOUTID not between", value1, value2, "portoutid");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescIsNull() {
            addCriterion("PORTOUTIDDESC is null");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescIsNotNull() {
            addCriterion("PORTOUTIDDESC is not null");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescEqualTo(String value) {
            addCriterion("PORTOUTIDDESC =", value, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescNotEqualTo(String value) {
            addCriterion("PORTOUTIDDESC <>", value, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescGreaterThan(String value) {
            addCriterion("PORTOUTIDDESC >", value, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescGreaterThanOrEqualTo(String value) {
            addCriterion("PORTOUTIDDESC >=", value, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescLessThan(String value) {
            addCriterion("PORTOUTIDDESC <", value, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescLessThanOrEqualTo(String value) {
            addCriterion("PORTOUTIDDESC <=", value, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescLike(String value) {
            addCriterion("PORTOUTIDDESC like", value, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescNotLike(String value) {
            addCriterion("PORTOUTIDDESC not like", value, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescIn(List<String> values) {
            addCriterion("PORTOUTIDDESC in", values, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescNotIn(List<String> values) {
            addCriterion("PORTOUTIDDESC not in", values, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescBetween(String value1, String value2) {
            addCriterion("PORTOUTIDDESC between", value1, value2, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andPortoutiddescNotBetween(String value1, String value2) {
            addCriterion("PORTOUTIDDESC not between", value1, value2, "portoutiddesc");
            return (Criteria) this;
        }

        public Criteria andHomenetIsNull() {
            addCriterion("HOMENET is null");
            return (Criteria) this;
        }

        public Criteria andHomenetIsNotNull() {
            addCriterion("HOMENET is not null");
            return (Criteria) this;
        }

        public Criteria andHomenetEqualTo(String value) {
            addCriterion("HOMENET =", value, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetNotEqualTo(String value) {
            addCriterion("HOMENET <>", value, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetGreaterThan(String value) {
            addCriterion("HOMENET >", value, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetGreaterThanOrEqualTo(String value) {
            addCriterion("HOMENET >=", value, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetLessThan(String value) {
            addCriterion("HOMENET <", value, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetLessThanOrEqualTo(String value) {
            addCriterion("HOMENET <=", value, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetLike(String value) {
            addCriterion("HOMENET like", value, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetNotLike(String value) {
            addCriterion("HOMENET not like", value, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetIn(List<String> values) {
            addCriterion("HOMENET in", values, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetNotIn(List<String> values) {
            addCriterion("HOMENET not in", values, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetBetween(String value1, String value2) {
            addCriterion("HOMENET between", value1, value2, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetNotBetween(String value1, String value2) {
            addCriterion("HOMENET not between", value1, value2, "homenet");
            return (Criteria) this;
        }

        public Criteria andHomenetdescIsNull() {
            addCriterion("HOMENETDESC is null");
            return (Criteria) this;
        }

        public Criteria andHomenetdescIsNotNull() {
            addCriterion("HOMENETDESC is not null");
            return (Criteria) this;
        }

        public Criteria andHomenetdescEqualTo(String value) {
            addCriterion("HOMENETDESC =", value, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescNotEqualTo(String value) {
            addCriterion("HOMENETDESC <>", value, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescGreaterThan(String value) {
            addCriterion("HOMENETDESC >", value, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescGreaterThanOrEqualTo(String value) {
            addCriterion("HOMENETDESC >=", value, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescLessThan(String value) {
            addCriterion("HOMENETDESC <", value, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescLessThanOrEqualTo(String value) {
            addCriterion("HOMENETDESC <=", value, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescLike(String value) {
            addCriterion("HOMENETDESC like", value, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescNotLike(String value) {
            addCriterion("HOMENETDESC not like", value, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescIn(List<String> values) {
            addCriterion("HOMENETDESC in", values, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescNotIn(List<String> values) {
            addCriterion("HOMENETDESC not in", values, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescBetween(String value1, String value2) {
            addCriterion("HOMENETDESC between", value1, value2, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andHomenetdescNotBetween(String value1, String value2) {
            addCriterion("HOMENETDESC not between", value1, value2, "homenetdesc");
            return (Criteria) this;
        }

        public Criteria andActivetimeIsNull() {
            addCriterion("ACTIVETIME is null");
            return (Criteria) this;
        }

        public Criteria andActivetimeIsNotNull() {
            addCriterion("ACTIVETIME is not null");
            return (Criteria) this;
        }

        public Criteria andActivetimeEqualTo(String value) {
            addCriterion("ACTIVETIME =", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotEqualTo(String value) {
            addCriterion("ACTIVETIME <>", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeGreaterThan(String value) {
            addCriterion("ACTIVETIME >", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVETIME >=", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeLessThan(String value) {
            addCriterion("ACTIVETIME <", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeLessThanOrEqualTo(String value) {
            addCriterion("ACTIVETIME <=", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeLike(String value) {
            addCriterion("ACTIVETIME like", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotLike(String value) {
            addCriterion("ACTIVETIME not like", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeIn(List<String> values) {
            addCriterion("ACTIVETIME in", values, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotIn(List<String> values) {
            addCriterion("ACTIVETIME not in", values, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeBetween(String value1, String value2) {
            addCriterion("ACTIVETIME between", value1, value2, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotBetween(String value1, String value2) {
            addCriterion("ACTIVETIME not between", value1, value2, "activetime");
            return (Criteria) this;
        }

        public Criteria andServicetypeIsNull() {
            addCriterion("SERVICETYPE is null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIsNotNull() {
            addCriterion("SERVICETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypeEqualTo(String value) {
            addCriterion("SERVICETYPE =", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotEqualTo(String value) {
            addCriterion("SERVICETYPE <>", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThan(String value) {
            addCriterion("SERVICETYPE >", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICETYPE >=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThan(String value) {
            addCriterion("SERVICETYPE <", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThanOrEqualTo(String value) {
            addCriterion("SERVICETYPE <=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLike(String value) {
            addCriterion("SERVICETYPE like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotLike(String value) {
            addCriterion("SERVICETYPE not like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeIn(List<String> values) {
            addCriterion("SERVICETYPE in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotIn(List<String> values) {
            addCriterion("SERVICETYPE not in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeBetween(String value1, String value2) {
            addCriterion("SERVICETYPE between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotBetween(String value1, String value2) {
            addCriterion("SERVICETYPE not between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypedescIsNull() {
            addCriterion("SERVICETYPEDESC is null");
            return (Criteria) this;
        }

        public Criteria andServicetypedescIsNotNull() {
            addCriterion("SERVICETYPEDESC is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypedescEqualTo(String value) {
            addCriterion("SERVICETYPEDESC =", value, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescNotEqualTo(String value) {
            addCriterion("SERVICETYPEDESC <>", value, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescGreaterThan(String value) {
            addCriterion("SERVICETYPEDESC >", value, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICETYPEDESC >=", value, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescLessThan(String value) {
            addCriterion("SERVICETYPEDESC <", value, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescLessThanOrEqualTo(String value) {
            addCriterion("SERVICETYPEDESC <=", value, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescLike(String value) {
            addCriterion("SERVICETYPEDESC like", value, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescNotLike(String value) {
            addCriterion("SERVICETYPEDESC not like", value, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescIn(List<String> values) {
            addCriterion("SERVICETYPEDESC in", values, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescNotIn(List<String> values) {
            addCriterion("SERVICETYPEDESC not in", values, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescBetween(String value1, String value2) {
            addCriterion("SERVICETYPEDESC between", value1, value2, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andServicetypedescNotBetween(String value1, String value2) {
            addCriterion("SERVICETYPEDESC not between", value1, value2, "servicetypedesc");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("REGION is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("REGION is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("REGION =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("REGION <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("REGION >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("REGION >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("REGION <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("REGION <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("REGION like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("REGION not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("REGION in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("REGION not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("REGION between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("REGION not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionnameIsNull() {
            addCriterion("REGIONNAME is null");
            return (Criteria) this;
        }

        public Criteria andRegionnameIsNotNull() {
            addCriterion("REGIONNAME is not null");
            return (Criteria) this;
        }

        public Criteria andRegionnameEqualTo(String value) {
            addCriterion("REGIONNAME =", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotEqualTo(String value) {
            addCriterion("REGIONNAME <>", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameGreaterThan(String value) {
            addCriterion("REGIONNAME >", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameGreaterThanOrEqualTo(String value) {
            addCriterion("REGIONNAME >=", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLessThan(String value) {
            addCriterion("REGIONNAME <", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLessThanOrEqualTo(String value) {
            addCriterion("REGIONNAME <=", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLike(String value) {
            addCriterion("REGIONNAME like", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotLike(String value) {
            addCriterion("REGIONNAME not like", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameIn(List<String> values) {
            addCriterion("REGIONNAME in", values, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotIn(List<String> values) {
            addCriterion("REGIONNAME not in", values, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameBetween(String value1, String value2) {
            addCriterion("REGIONNAME between", value1, value2, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotBetween(String value1, String value2) {
            addCriterion("REGIONNAME not between", value1, value2, "regionname");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("PROVINCE like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("PROVINCE not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvincenameIsNull() {
            addCriterion("PROVINCENAME is null");
            return (Criteria) this;
        }

        public Criteria andProvincenameIsNotNull() {
            addCriterion("PROVINCENAME is not null");
            return (Criteria) this;
        }

        public Criteria andProvincenameEqualTo(String value) {
            addCriterion("PROVINCENAME =", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameNotEqualTo(String value) {
            addCriterion("PROVINCENAME <>", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameGreaterThan(String value) {
            addCriterion("PROVINCENAME >", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCENAME >=", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameLessThan(String value) {
            addCriterion("PROVINCENAME <", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameLessThanOrEqualTo(String value) {
            addCriterion("PROVINCENAME <=", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameLike(String value) {
            addCriterion("PROVINCENAME like", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameNotLike(String value) {
            addCriterion("PROVINCENAME not like", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameIn(List<String> values) {
            addCriterion("PROVINCENAME in", values, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameNotIn(List<String> values) {
            addCriterion("PROVINCENAME not in", values, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameBetween(String value1, String value2) {
            addCriterion("PROVINCENAME between", value1, value2, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameNotBetween(String value1, String value2) {
            addCriterion("PROVINCENAME not between", value1, value2, "provincename");
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