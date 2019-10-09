package com.ucss.elementary.tnwn.model.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLTnwninterlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLTnwninterlogExample() {
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

        public Criteria andIfcodeIsNull() {
            addCriterion("IFCODE is null");
            return (Criteria) this;
        }

        public Criteria andIfcodeIsNotNull() {
            addCriterion("IFCODE is not null");
            return (Criteria) this;
        }

        public Criteria andIfcodeEqualTo(String value) {
            addCriterion("IFCODE =", value, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeNotEqualTo(String value) {
            addCriterion("IFCODE <>", value, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeGreaterThan(String value) {
            addCriterion("IFCODE >", value, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeGreaterThanOrEqualTo(String value) {
            addCriterion("IFCODE >=", value, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeLessThan(String value) {
            addCriterion("IFCODE <", value, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeLessThanOrEqualTo(String value) {
            addCriterion("IFCODE <=", value, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeLike(String value) {
            addCriterion("IFCODE like", value, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeNotLike(String value) {
            addCriterion("IFCODE not like", value, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeIn(List<String> values) {
            addCriterion("IFCODE in", values, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeNotIn(List<String> values) {
            addCriterion("IFCODE not in", values, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeBetween(String value1, String value2) {
            addCriterion("IFCODE between", value1, value2, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfcodeNotBetween(String value1, String value2) {
            addCriterion("IFCODE not between", value1, value2, "ifcode");
            return (Criteria) this;
        }

        public Criteria andIfnameIsNull() {
            addCriterion("IFNAME is null");
            return (Criteria) this;
        }

        public Criteria andIfnameIsNotNull() {
            addCriterion("IFNAME is not null");
            return (Criteria) this;
        }

        public Criteria andIfnameEqualTo(String value) {
            addCriterion("IFNAME =", value, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameNotEqualTo(String value) {
            addCriterion("IFNAME <>", value, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameGreaterThan(String value) {
            addCriterion("IFNAME >", value, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameGreaterThanOrEqualTo(String value) {
            addCriterion("IFNAME >=", value, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameLessThan(String value) {
            addCriterion("IFNAME <", value, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameLessThanOrEqualTo(String value) {
            addCriterion("IFNAME <=", value, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameLike(String value) {
            addCriterion("IFNAME like", value, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameNotLike(String value) {
            addCriterion("IFNAME not like", value, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameIn(List<String> values) {
            addCriterion("IFNAME in", values, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameNotIn(List<String> values) {
            addCriterion("IFNAME not in", values, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameBetween(String value1, String value2) {
            addCriterion("IFNAME between", value1, value2, "ifname");
            return (Criteria) this;
        }

        public Criteria andIfnameNotBetween(String value1, String value2) {
            addCriterion("IFNAME not between", value1, value2, "ifname");
            return (Criteria) this;
        }

        public Criteria andRequesterIsNull() {
            addCriterion("REQUESTER is null");
            return (Criteria) this;
        }

        public Criteria andRequesterIsNotNull() {
            addCriterion("REQUESTER is not null");
            return (Criteria) this;
        }

        public Criteria andRequesterEqualTo(String value) {
            addCriterion("REQUESTER =", value, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterNotEqualTo(String value) {
            addCriterion("REQUESTER <>", value, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterGreaterThan(String value) {
            addCriterion("REQUESTER >", value, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterGreaterThanOrEqualTo(String value) {
            addCriterion("REQUESTER >=", value, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterLessThan(String value) {
            addCriterion("REQUESTER <", value, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterLessThanOrEqualTo(String value) {
            addCriterion("REQUESTER <=", value, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterLike(String value) {
            addCriterion("REQUESTER like", value, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterNotLike(String value) {
            addCriterion("REQUESTER not like", value, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterIn(List<String> values) {
            addCriterion("REQUESTER in", values, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterNotIn(List<String> values) {
            addCriterion("REQUESTER not in", values, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterBetween(String value1, String value2) {
            addCriterion("REQUESTER between", value1, value2, "requester");
            return (Criteria) this;
        }

        public Criteria andRequesterNotBetween(String value1, String value2) {
            addCriterion("REQUESTER not between", value1, value2, "requester");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIfurlIsNull() {
            addCriterion("IFURL is null");
            return (Criteria) this;
        }

        public Criteria andIfurlIsNotNull() {
            addCriterion("IFURL is not null");
            return (Criteria) this;
        }

        public Criteria andIfurlEqualTo(String value) {
            addCriterion("IFURL =", value, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlNotEqualTo(String value) {
            addCriterion("IFURL <>", value, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlGreaterThan(String value) {
            addCriterion("IFURL >", value, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlGreaterThanOrEqualTo(String value) {
            addCriterion("IFURL >=", value, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlLessThan(String value) {
            addCriterion("IFURL <", value, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlLessThanOrEqualTo(String value) {
            addCriterion("IFURL <=", value, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlLike(String value) {
            addCriterion("IFURL like", value, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlNotLike(String value) {
            addCriterion("IFURL not like", value, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlIn(List<String> values) {
            addCriterion("IFURL in", values, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlNotIn(List<String> values) {
            addCriterion("IFURL not in", values, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlBetween(String value1, String value2) {
            addCriterion("IFURL between", value1, value2, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfurlNotBetween(String value1, String value2) {
            addCriterion("IFURL not between", value1, value2, "ifurl");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeIsNull() {
            addCriterion("IFRESULTCODE is null");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeIsNotNull() {
            addCriterion("IFRESULTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeEqualTo(String value) {
            addCriterion("IFRESULTCODE =", value, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeNotEqualTo(String value) {
            addCriterion("IFRESULTCODE <>", value, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeGreaterThan(String value) {
            addCriterion("IFRESULTCODE >", value, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeGreaterThanOrEqualTo(String value) {
            addCriterion("IFRESULTCODE >=", value, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeLessThan(String value) {
            addCriterion("IFRESULTCODE <", value, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeLessThanOrEqualTo(String value) {
            addCriterion("IFRESULTCODE <=", value, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeLike(String value) {
            addCriterion("IFRESULTCODE like", value, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeNotLike(String value) {
            addCriterion("IFRESULTCODE not like", value, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeIn(List<String> values) {
            addCriterion("IFRESULTCODE in", values, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeNotIn(List<String> values) {
            addCriterion("IFRESULTCODE not in", values, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeBetween(String value1, String value2) {
            addCriterion("IFRESULTCODE between", value1, value2, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultcodeNotBetween(String value1, String value2) {
            addCriterion("IFRESULTCODE not between", value1, value2, "ifresultcode");
            return (Criteria) this;
        }

        public Criteria andIfresultIsNull() {
            addCriterion("IFRESULT is null");
            return (Criteria) this;
        }

        public Criteria andIfresultIsNotNull() {
            addCriterion("IFRESULT is not null");
            return (Criteria) this;
        }

        public Criteria andIfresultEqualTo(String value) {
            addCriterion("IFRESULT =", value, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultNotEqualTo(String value) {
            addCriterion("IFRESULT <>", value, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultGreaterThan(String value) {
            addCriterion("IFRESULT >", value, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultGreaterThanOrEqualTo(String value) {
            addCriterion("IFRESULT >=", value, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultLessThan(String value) {
            addCriterion("IFRESULT <", value, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultLessThanOrEqualTo(String value) {
            addCriterion("IFRESULT <=", value, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultLike(String value) {
            addCriterion("IFRESULT like", value, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultNotLike(String value) {
            addCriterion("IFRESULT not like", value, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultIn(List<String> values) {
            addCriterion("IFRESULT in", values, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultNotIn(List<String> values) {
            addCriterion("IFRESULT not in", values, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultBetween(String value1, String value2) {
            addCriterion("IFRESULT between", value1, value2, "ifresult");
            return (Criteria) this;
        }

        public Criteria andIfresultNotBetween(String value1, String value2) {
            addCriterion("IFRESULT not between", value1, value2, "ifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeIsNull() {
            addCriterion("OUTERIFCODE is null");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeIsNotNull() {
            addCriterion("OUTERIFCODE is not null");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeEqualTo(String value) {
            addCriterion("OUTERIFCODE =", value, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeNotEqualTo(String value) {
            addCriterion("OUTERIFCODE <>", value, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeGreaterThan(String value) {
            addCriterion("OUTERIFCODE >", value, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeGreaterThanOrEqualTo(String value) {
            addCriterion("OUTERIFCODE >=", value, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeLessThan(String value) {
            addCriterion("OUTERIFCODE <", value, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeLessThanOrEqualTo(String value) {
            addCriterion("OUTERIFCODE <=", value, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeLike(String value) {
            addCriterion("OUTERIFCODE like", value, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeNotLike(String value) {
            addCriterion("OUTERIFCODE not like", value, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeIn(List<String> values) {
            addCriterion("OUTERIFCODE in", values, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeNotIn(List<String> values) {
            addCriterion("OUTERIFCODE not in", values, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeBetween(String value1, String value2) {
            addCriterion("OUTERIFCODE between", value1, value2, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifcodeNotBetween(String value1, String value2) {
            addCriterion("OUTERIFCODE not between", value1, value2, "outerifcode");
            return (Criteria) this;
        }

        public Criteria andOuterifnameIsNull() {
            addCriterion("OUTERIFNAME is null");
            return (Criteria) this;
        }

        public Criteria andOuterifnameIsNotNull() {
            addCriterion("OUTERIFNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOuterifnameEqualTo(String value) {
            addCriterion("OUTERIFNAME =", value, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameNotEqualTo(String value) {
            addCriterion("OUTERIFNAME <>", value, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameGreaterThan(String value) {
            addCriterion("OUTERIFNAME >", value, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameGreaterThanOrEqualTo(String value) {
            addCriterion("OUTERIFNAME >=", value, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameLessThan(String value) {
            addCriterion("OUTERIFNAME <", value, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameLessThanOrEqualTo(String value) {
            addCriterion("OUTERIFNAME <=", value, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameLike(String value) {
            addCriterion("OUTERIFNAME like", value, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameNotLike(String value) {
            addCriterion("OUTERIFNAME not like", value, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameIn(List<String> values) {
            addCriterion("OUTERIFNAME in", values, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameNotIn(List<String> values) {
            addCriterion("OUTERIFNAME not in", values, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameBetween(String value1, String value2) {
            addCriterion("OUTERIFNAME between", value1, value2, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifnameNotBetween(String value1, String value2) {
            addCriterion("OUTERIFNAME not between", value1, value2, "outerifname");
            return (Criteria) this;
        }

        public Criteria andOuterifurlIsNull() {
            addCriterion("OUTERIFURL is null");
            return (Criteria) this;
        }

        public Criteria andOuterifurlIsNotNull() {
            addCriterion("OUTERIFURL is not null");
            return (Criteria) this;
        }

        public Criteria andOuterifurlEqualTo(String value) {
            addCriterion("OUTERIFURL =", value, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlNotEqualTo(String value) {
            addCriterion("OUTERIFURL <>", value, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlGreaterThan(String value) {
            addCriterion("OUTERIFURL >", value, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlGreaterThanOrEqualTo(String value) {
            addCriterion("OUTERIFURL >=", value, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlLessThan(String value) {
            addCriterion("OUTERIFURL <", value, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlLessThanOrEqualTo(String value) {
            addCriterion("OUTERIFURL <=", value, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlLike(String value) {
            addCriterion("OUTERIFURL like", value, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlNotLike(String value) {
            addCriterion("OUTERIFURL not like", value, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlIn(List<String> values) {
            addCriterion("OUTERIFURL in", values, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlNotIn(List<String> values) {
            addCriterion("OUTERIFURL not in", values, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlBetween(String value1, String value2) {
            addCriterion("OUTERIFURL between", value1, value2, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifurlNotBetween(String value1, String value2) {
            addCriterion("OUTERIFURL not between", value1, value2, "outerifurl");
            return (Criteria) this;
        }

        public Criteria andOuterifresultIsNull() {
            addCriterion("OUTERIFRESULT is null");
            return (Criteria) this;
        }

        public Criteria andOuterifresultIsNotNull() {
            addCriterion("OUTERIFRESULT is not null");
            return (Criteria) this;
        }

        public Criteria andOuterifresultEqualTo(String value) {
            addCriterion("OUTERIFRESULT =", value, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultNotEqualTo(String value) {
            addCriterion("OUTERIFRESULT <>", value, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultGreaterThan(String value) {
            addCriterion("OUTERIFRESULT >", value, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultGreaterThanOrEqualTo(String value) {
            addCriterion("OUTERIFRESULT >=", value, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultLessThan(String value) {
            addCriterion("OUTERIFRESULT <", value, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultLessThanOrEqualTo(String value) {
            addCriterion("OUTERIFRESULT <=", value, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultLike(String value) {
            addCriterion("OUTERIFRESULT like", value, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultNotLike(String value) {
            addCriterion("OUTERIFRESULT not like", value, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultIn(List<String> values) {
            addCriterion("OUTERIFRESULT in", values, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultNotIn(List<String> values) {
            addCriterion("OUTERIFRESULT not in", values, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultBetween(String value1, String value2) {
            addCriterion("OUTERIFRESULT between", value1, value2, "outerifresult");
            return (Criteria) this;
        }

        public Criteria andOuterifresultNotBetween(String value1, String value2) {
            addCriterion("OUTERIFRESULT not between", value1, value2, "outerifresult");
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