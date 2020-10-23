package com.ucss.elementary.weather.model.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDUserExample() {
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

        public Criteria andPhonebindIsNull() {
            addCriterion("PHONEBIND is null");
            return (Criteria) this;
        }

        public Criteria andPhonebindIsNotNull() {
            addCriterion("PHONEBIND is not null");
            return (Criteria) this;
        }

        public Criteria andPhonebindEqualTo(String value) {
            addCriterion("PHONEBIND =", value, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindNotEqualTo(String value) {
            addCriterion("PHONEBIND <>", value, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindGreaterThan(String value) {
            addCriterion("PHONEBIND >", value, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindGreaterThanOrEqualTo(String value) {
            addCriterion("PHONEBIND >=", value, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindLessThan(String value) {
            addCriterion("PHONEBIND <", value, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindLessThanOrEqualTo(String value) {
            addCriterion("PHONEBIND <=", value, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindLike(String value) {
            addCriterion("PHONEBIND like", value, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindNotLike(String value) {
            addCriterion("PHONEBIND not like", value, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindIn(List<String> values) {
            addCriterion("PHONEBIND in", values, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindNotIn(List<String> values) {
            addCriterion("PHONEBIND not in", values, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindBetween(String value1, String value2) {
            addCriterion("PHONEBIND between", value1, value2, "phonebind");
            return (Criteria) this;
        }

        public Criteria andPhonebindNotBetween(String value1, String value2) {
            addCriterion("PHONEBIND not between", value1, value2, "phonebind");
            return (Criteria) this;
        }

        public Criteria andEmailbindIsNull() {
            addCriterion("EMAILBIND is null");
            return (Criteria) this;
        }

        public Criteria andEmailbindIsNotNull() {
            addCriterion("EMAILBIND is not null");
            return (Criteria) this;
        }

        public Criteria andEmailbindEqualTo(String value) {
            addCriterion("EMAILBIND =", value, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindNotEqualTo(String value) {
            addCriterion("EMAILBIND <>", value, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindGreaterThan(String value) {
            addCriterion("EMAILBIND >", value, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindGreaterThanOrEqualTo(String value) {
            addCriterion("EMAILBIND >=", value, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindLessThan(String value) {
            addCriterion("EMAILBIND <", value, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindLessThanOrEqualTo(String value) {
            addCriterion("EMAILBIND <=", value, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindLike(String value) {
            addCriterion("EMAILBIND like", value, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindNotLike(String value) {
            addCriterion("EMAILBIND not like", value, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindIn(List<String> values) {
            addCriterion("EMAILBIND in", values, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindNotIn(List<String> values) {
            addCriterion("EMAILBIND not in", values, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindBetween(String value1, String value2) {
            addCriterion("EMAILBIND between", value1, value2, "emailbind");
            return (Criteria) this;
        }

        public Criteria andEmailbindNotBetween(String value1, String value2) {
            addCriterion("EMAILBIND not between", value1, value2, "emailbind");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("NICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("NICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("NICKNAME =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("NICKNAME <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("NICKNAME >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("NICKNAME >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("NICKNAME <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("NICKNAME <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("NICKNAME like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("NICKNAME not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("NICKNAME in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("NICKNAME not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("NICKNAME between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("NICKNAME not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIsNull() {
            addCriterion("REGIONCODE is null");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIsNotNull() {
            addCriterion("REGIONCODE is not null");
            return (Criteria) this;
        }

        public Criteria andRegioncodeEqualTo(String value) {
            addCriterion("REGIONCODE =", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotEqualTo(String value) {
            addCriterion("REGIONCODE <>", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeGreaterThan(String value) {
            addCriterion("REGIONCODE >", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeGreaterThanOrEqualTo(String value) {
            addCriterion("REGIONCODE >=", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLessThan(String value) {
            addCriterion("REGIONCODE <", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLessThanOrEqualTo(String value) {
            addCriterion("REGIONCODE <=", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLike(String value) {
            addCriterion("REGIONCODE like", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotLike(String value) {
            addCriterion("REGIONCODE not like", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIn(List<String> values) {
            addCriterion("REGIONCODE in", values, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotIn(List<String> values) {
            addCriterion("REGIONCODE not in", values, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeBetween(String value1, String value2) {
            addCriterion("REGIONCODE between", value1, value2, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotBetween(String value1, String value2) {
            addCriterion("REGIONCODE not between", value1, value2, "regioncode");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNull() {
            addCriterion("HEADIMAGE is null");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNotNull() {
            addCriterion("HEADIMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimageEqualTo(String value) {
            addCriterion("HEADIMAGE =", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotEqualTo(String value) {
            addCriterion("HEADIMAGE <>", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThan(String value) {
            addCriterion("HEADIMAGE >", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThanOrEqualTo(String value) {
            addCriterion("HEADIMAGE >=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThan(String value) {
            addCriterion("HEADIMAGE <", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThanOrEqualTo(String value) {
            addCriterion("HEADIMAGE <=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLike(String value) {
            addCriterion("HEADIMAGE like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotLike(String value) {
            addCriterion("HEADIMAGE not like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageIn(List<String> values) {
            addCriterion("HEADIMAGE in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotIn(List<String> values) {
            addCriterion("HEADIMAGE not in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageBetween(String value1, String value2) {
            addCriterion("HEADIMAGE between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotBetween(String value1, String value2) {
            addCriterion("HEADIMAGE not between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Short value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Short value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Short value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Short value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Short value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Short value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Short> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Short> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Short value1, Short value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Short value1, Short value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("USERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("USERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Short value) {
            addCriterion("USERTYPE =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Short value) {
            addCriterion("USERTYPE <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Short value) {
            addCriterion("USERTYPE >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Short value) {
            addCriterion("USERTYPE >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Short value) {
            addCriterion("USERTYPE <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Short value) {
            addCriterion("USERTYPE <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Short> values) {
            addCriterion("USERTYPE in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Short> values) {
            addCriterion("USERTYPE not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Short value1, Short value2) {
            addCriterion("USERTYPE between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Short value1, Short value2) {
            addCriterion("USERTYPE not between", value1, value2, "usertype");
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

        public Criteria andAuditadminIdIsNull() {
            addCriterion("AUDITADMIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdIsNotNull() {
            addCriterion("AUDITADMIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdEqualTo(Long value) {
            addCriterion("AUDITADMIN_ID =", value, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdNotEqualTo(Long value) {
            addCriterion("AUDITADMIN_ID <>", value, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdGreaterThan(Long value) {
            addCriterion("AUDITADMIN_ID >", value, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("AUDITADMIN_ID >=", value, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdLessThan(Long value) {
            addCriterion("AUDITADMIN_ID <", value, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdLessThanOrEqualTo(Long value) {
            addCriterion("AUDITADMIN_ID <=", value, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdIn(List<Long> values) {
            addCriterion("AUDITADMIN_ID in", values, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdNotIn(List<Long> values) {
            addCriterion("AUDITADMIN_ID not in", values, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdBetween(Long value1, Long value2) {
            addCriterion("AUDITADMIN_ID between", value1, value2, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditadminIdNotBetween(Long value1, Long value2) {
            addCriterion("AUDITADMIN_ID not between", value1, value2, "auditadminId");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNull() {
            addCriterion("AUDITSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNotNull() {
            addCriterion("AUDITSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusEqualTo(Short value) {
            addCriterion("AUDITSTATUS =", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotEqualTo(Short value) {
            addCriterion("AUDITSTATUS <>", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThan(Short value) {
            addCriterion("AUDITSTATUS >", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThanOrEqualTo(Short value) {
            addCriterion("AUDITSTATUS >=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThan(Short value) {
            addCriterion("AUDITSTATUS <", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThanOrEqualTo(Short value) {
            addCriterion("AUDITSTATUS <=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIn(List<Short> values) {
            addCriterion("AUDITSTATUS in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotIn(List<Short> values) {
            addCriterion("AUDITSTATUS not in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusBetween(Short value1, Short value2) {
            addCriterion("AUDITSTATUS between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotBetween(Short value1, Short value2) {
            addCriterion("AUDITSTATUS not between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNull() {
            addCriterion("AUDITTIME is null");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNotNull() {
            addCriterion("AUDITTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAudittimeEqualTo(Date value) {
            addCriterion("AUDITTIME =", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotEqualTo(Date value) {
            addCriterion("AUDITTIME <>", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThan(Date value) {
            addCriterion("AUDITTIME >", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AUDITTIME >=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThan(Date value) {
            addCriterion("AUDITTIME <", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThanOrEqualTo(Date value) {
            addCriterion("AUDITTIME <=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeIn(List<Date> values) {
            addCriterion("AUDITTIME in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotIn(List<Date> values) {
            addCriterion("AUDITTIME not in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeBetween(Date value1, Date value2) {
            addCriterion("AUDITTIME between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotBetween(Date value1, Date value2) {
            addCriterion("AUDITTIME not between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAuditreasonIsNull() {
            addCriterion("AUDITREASON is null");
            return (Criteria) this;
        }

        public Criteria andAuditreasonIsNotNull() {
            addCriterion("AUDITREASON is not null");
            return (Criteria) this;
        }

        public Criteria andAuditreasonEqualTo(String value) {
            addCriterion("AUDITREASON =", value, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonNotEqualTo(String value) {
            addCriterion("AUDITREASON <>", value, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonGreaterThan(String value) {
            addCriterion("AUDITREASON >", value, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonGreaterThanOrEqualTo(String value) {
            addCriterion("AUDITREASON >=", value, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonLessThan(String value) {
            addCriterion("AUDITREASON <", value, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonLessThanOrEqualTo(String value) {
            addCriterion("AUDITREASON <=", value, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonLike(String value) {
            addCriterion("AUDITREASON like", value, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonNotLike(String value) {
            addCriterion("AUDITREASON not like", value, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonIn(List<String> values) {
            addCriterion("AUDITREASON in", values, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonNotIn(List<String> values) {
            addCriterion("AUDITREASON not in", values, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonBetween(String value1, String value2) {
            addCriterion("AUDITREASON between", value1, value2, "auditreason");
            return (Criteria) this;
        }

        public Criteria andAuditreasonNotBetween(String value1, String value2) {
            addCriterion("AUDITREASON not between", value1, value2, "auditreason");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNull() {
            addCriterion("LOGINNAME is null");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNotNull() {
            addCriterion("LOGINNAME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginnameEqualTo(String value) {
            addCriterion("LOGINNAME =", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotEqualTo(String value) {
            addCriterion("LOGINNAME <>", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThan(String value) {
            addCriterion("LOGINNAME >", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("LOGINNAME >=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThan(String value) {
            addCriterion("LOGINNAME <", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThanOrEqualTo(String value) {
            addCriterion("LOGINNAME <=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLike(String value) {
            addCriterion("LOGINNAME like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotLike(String value) {
            addCriterion("LOGINNAME not like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameIn(List<String> values) {
            addCriterion("LOGINNAME in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotIn(List<String> values) {
            addCriterion("LOGINNAME not in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameBetween(String value1, String value2) {
            addCriterion("LOGINNAME between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotBetween(String value1, String value2) {
            addCriterion("LOGINNAME not between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountIsNull() {
            addCriterion("LOGINERRORCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountIsNotNull() {
            addCriterion("LOGINERRORCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountEqualTo(Short value) {
            addCriterion("LOGINERRORCOUNT =", value, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountNotEqualTo(Short value) {
            addCriterion("LOGINERRORCOUNT <>", value, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountGreaterThan(Short value) {
            addCriterion("LOGINERRORCOUNT >", value, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountGreaterThanOrEqualTo(Short value) {
            addCriterion("LOGINERRORCOUNT >=", value, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountLessThan(Short value) {
            addCriterion("LOGINERRORCOUNT <", value, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountLessThanOrEqualTo(Short value) {
            addCriterion("LOGINERRORCOUNT <=", value, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountIn(List<Short> values) {
            addCriterion("LOGINERRORCOUNT in", values, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountNotIn(List<Short> values) {
            addCriterion("LOGINERRORCOUNT not in", values, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountBetween(Short value1, Short value2) {
            addCriterion("LOGINERRORCOUNT between", value1, value2, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLoginerrorcountNotBetween(Short value1, Short value2) {
            addCriterion("LOGINERRORCOUNT not between", value1, value2, "loginerrorcount");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeIsNull() {
            addCriterion("LASTLOGINERRORTIME is null");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeIsNotNull() {
            addCriterion("LASTLOGINERRORTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeEqualTo(Date value) {
            addCriterion("LASTLOGINERRORTIME =", value, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeNotEqualTo(Date value) {
            addCriterion("LASTLOGINERRORTIME <>", value, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeGreaterThan(Date value) {
            addCriterion("LASTLOGINERRORTIME >", value, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LASTLOGINERRORTIME >=", value, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeLessThan(Date value) {
            addCriterion("LASTLOGINERRORTIME <", value, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeLessThanOrEqualTo(Date value) {
            addCriterion("LASTLOGINERRORTIME <=", value, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeIn(List<Date> values) {
            addCriterion("LASTLOGINERRORTIME in", values, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeNotIn(List<Date> values) {
            addCriterion("LASTLOGINERRORTIME not in", values, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeBetween(Date value1, Date value2) {
            addCriterion("LASTLOGINERRORTIME between", value1, value2, "lastloginerrortime");
            return (Criteria) this;
        }

        public Criteria andLastloginerrortimeNotBetween(Date value1, Date value2) {
            addCriterion("LASTLOGINERRORTIME not between", value1, value2, "lastloginerrortime");
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