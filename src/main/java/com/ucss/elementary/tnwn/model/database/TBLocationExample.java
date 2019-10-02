package com.ucss.elementary.tnwn.model.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TBLocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBLocationExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("GID is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("GID is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(BigDecimal value) {
            addCriterion("GID =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(BigDecimal value) {
            addCriterion("GID <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(BigDecimal value) {
            addCriterion("GID >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GID >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(BigDecimal value) {
            addCriterion("GID <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GID <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<BigDecimal> values) {
            addCriterion("GID in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<BigDecimal> values) {
            addCriterion("GID not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GID between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GID not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andLocationnameIsNull() {
            addCriterion("LOCATIONNAME is null");
            return (Criteria) this;
        }

        public Criteria andLocationnameIsNotNull() {
            addCriterion("LOCATIONNAME is not null");
            return (Criteria) this;
        }

        public Criteria andLocationnameEqualTo(String value) {
            addCriterion("LOCATIONNAME =", value, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameNotEqualTo(String value) {
            addCriterion("LOCATIONNAME <>", value, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameGreaterThan(String value) {
            addCriterion("LOCATIONNAME >", value, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATIONNAME >=", value, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameLessThan(String value) {
            addCriterion("LOCATIONNAME <", value, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameLessThanOrEqualTo(String value) {
            addCriterion("LOCATIONNAME <=", value, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameLike(String value) {
            addCriterion("LOCATIONNAME like", value, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameNotLike(String value) {
            addCriterion("LOCATIONNAME not like", value, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameIn(List<String> values) {
            addCriterion("LOCATIONNAME in", values, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameNotIn(List<String> values) {
            addCriterion("LOCATIONNAME not in", values, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameBetween(String value1, String value2) {
            addCriterion("LOCATIONNAME between", value1, value2, "locationname");
            return (Criteria) this;
        }

        public Criteria andLocationnameNotBetween(String value1, String value2) {
            addCriterion("LOCATIONNAME not between", value1, value2, "locationname");
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

        public Criteria andLastlevelcodeIsNull() {
            addCriterion("LASTLEVELCODE is null");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeIsNotNull() {
            addCriterion("LASTLEVELCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeEqualTo(String value) {
            addCriterion("LASTLEVELCODE =", value, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeNotEqualTo(String value) {
            addCriterion("LASTLEVELCODE <>", value, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeGreaterThan(String value) {
            addCriterion("LASTLEVELCODE >", value, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeGreaterThanOrEqualTo(String value) {
            addCriterion("LASTLEVELCODE >=", value, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeLessThan(String value) {
            addCriterion("LASTLEVELCODE <", value, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeLessThanOrEqualTo(String value) {
            addCriterion("LASTLEVELCODE <=", value, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeLike(String value) {
            addCriterion("LASTLEVELCODE like", value, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeNotLike(String value) {
            addCriterion("LASTLEVELCODE not like", value, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeIn(List<String> values) {
            addCriterion("LASTLEVELCODE in", values, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeNotIn(List<String> values) {
            addCriterion("LASTLEVELCODE not in", values, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeBetween(String value1, String value2) {
            addCriterion("LASTLEVELCODE between", value1, value2, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andLastlevelcodeNotBetween(String value1, String value2) {
            addCriterion("LASTLEVELCODE not between", value1, value2, "lastlevelcode");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("PARENTID is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("PARENTID is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(BigDecimal value) {
            addCriterion("PARENTID =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(BigDecimal value) {
            addCriterion("PARENTID <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(BigDecimal value) {
            addCriterion("PARENTID >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PARENTID >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(BigDecimal value) {
            addCriterion("PARENTID <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PARENTID <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<BigDecimal> values) {
            addCriterion("PARENTID in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<BigDecimal> values) {
            addCriterion("PARENTID not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARENTID between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARENTID not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andLocationlevelIsNull() {
            addCriterion("LOCATIONLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLocationlevelIsNotNull() {
            addCriterion("LOCATIONLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLocationlevelEqualTo(BigDecimal value) {
            addCriterion("LOCATIONLEVEL =", value, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelNotEqualTo(BigDecimal value) {
            addCriterion("LOCATIONLEVEL <>", value, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelGreaterThan(BigDecimal value) {
            addCriterion("LOCATIONLEVEL >", value, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCATIONLEVEL >=", value, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelLessThan(BigDecimal value) {
            addCriterion("LOCATIONLEVEL <", value, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCATIONLEVEL <=", value, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelIn(List<BigDecimal> values) {
            addCriterion("LOCATIONLEVEL in", values, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelNotIn(List<BigDecimal> values) {
            addCriterion("LOCATIONLEVEL not in", values, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCATIONLEVEL between", value1, value2, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationlevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCATIONLEVEL not between", value1, value2, "locationlevel");
            return (Criteria) this;
        }

        public Criteria andLocationdescIsNull() {
            addCriterion("LOCATIONDESC is null");
            return (Criteria) this;
        }

        public Criteria andLocationdescIsNotNull() {
            addCriterion("LOCATIONDESC is not null");
            return (Criteria) this;
        }

        public Criteria andLocationdescEqualTo(String value) {
            addCriterion("LOCATIONDESC =", value, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescNotEqualTo(String value) {
            addCriterion("LOCATIONDESC <>", value, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescGreaterThan(String value) {
            addCriterion("LOCATIONDESC >", value, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATIONDESC >=", value, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescLessThan(String value) {
            addCriterion("LOCATIONDESC <", value, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescLessThanOrEqualTo(String value) {
            addCriterion("LOCATIONDESC <=", value, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescLike(String value) {
            addCriterion("LOCATIONDESC like", value, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescNotLike(String value) {
            addCriterion("LOCATIONDESC not like", value, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescIn(List<String> values) {
            addCriterion("LOCATIONDESC in", values, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescNotIn(List<String> values) {
            addCriterion("LOCATIONDESC not in", values, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescBetween(String value1, String value2) {
            addCriterion("LOCATIONDESC between", value1, value2, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andLocationdescNotBetween(String value1, String value2) {
            addCriterion("LOCATIONDESC not between", value1, value2, "locationdesc");
            return (Criteria) this;
        }

        public Criteria andTranscodeIsNull() {
            addCriterion("TRANSCODE is null");
            return (Criteria) this;
        }

        public Criteria andTranscodeIsNotNull() {
            addCriterion("TRANSCODE is not null");
            return (Criteria) this;
        }

        public Criteria andTranscodeEqualTo(String value) {
            addCriterion("TRANSCODE =", value, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeNotEqualTo(String value) {
            addCriterion("TRANSCODE <>", value, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeGreaterThan(String value) {
            addCriterion("TRANSCODE >", value, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSCODE >=", value, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeLessThan(String value) {
            addCriterion("TRANSCODE <", value, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeLessThanOrEqualTo(String value) {
            addCriterion("TRANSCODE <=", value, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeLike(String value) {
            addCriterion("TRANSCODE like", value, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeNotLike(String value) {
            addCriterion("TRANSCODE not like", value, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeIn(List<String> values) {
            addCriterion("TRANSCODE in", values, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeNotIn(List<String> values) {
            addCriterion("TRANSCODE not in", values, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeBetween(String value1, String value2) {
            addCriterion("TRANSCODE between", value1, value2, "transcode");
            return (Criteria) this;
        }

        public Criteria andTranscodeNotBetween(String value1, String value2) {
            addCriterion("TRANSCODE not between", value1, value2, "transcode");
            return (Criteria) this;
        }

        public Criteria andLocationorderIsNull() {
            addCriterion("LOCATIONORDER is null");
            return (Criteria) this;
        }

        public Criteria andLocationorderIsNotNull() {
            addCriterion("LOCATIONORDER is not null");
            return (Criteria) this;
        }

        public Criteria andLocationorderEqualTo(BigDecimal value) {
            addCriterion("LOCATIONORDER =", value, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderNotEqualTo(BigDecimal value) {
            addCriterion("LOCATIONORDER <>", value, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderGreaterThan(BigDecimal value) {
            addCriterion("LOCATIONORDER >", value, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCATIONORDER >=", value, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderLessThan(BigDecimal value) {
            addCriterion("LOCATIONORDER <", value, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCATIONORDER <=", value, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderIn(List<BigDecimal> values) {
            addCriterion("LOCATIONORDER in", values, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderNotIn(List<BigDecimal> values) {
            addCriterion("LOCATIONORDER not in", values, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCATIONORDER between", value1, value2, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationorderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCATIONORDER not between", value1, value2, "locationorder");
            return (Criteria) this;
        }

        public Criteria andLocationtypeIsNull() {
            addCriterion("LOCATIONTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLocationtypeIsNotNull() {
            addCriterion("LOCATIONTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLocationtypeEqualTo(BigDecimal value) {
            addCriterion("LOCATIONTYPE =", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeNotEqualTo(BigDecimal value) {
            addCriterion("LOCATIONTYPE <>", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeGreaterThan(BigDecimal value) {
            addCriterion("LOCATIONTYPE >", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCATIONTYPE >=", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeLessThan(BigDecimal value) {
            addCriterion("LOCATIONTYPE <", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCATIONTYPE <=", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeIn(List<BigDecimal> values) {
            addCriterion("LOCATIONTYPE in", values, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeNotIn(List<BigDecimal> values) {
            addCriterion("LOCATIONTYPE not in", values, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCATIONTYPE between", value1, value2, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCATIONTYPE not between", value1, value2, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeIsNull() {
            addCriterion("LOCATIONSIMPLECODE is null");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeIsNotNull() {
            addCriterion("LOCATIONSIMPLECODE is not null");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeEqualTo(String value) {
            addCriterion("LOCATIONSIMPLECODE =", value, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeNotEqualTo(String value) {
            addCriterion("LOCATIONSIMPLECODE <>", value, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeGreaterThan(String value) {
            addCriterion("LOCATIONSIMPLECODE >", value, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATIONSIMPLECODE >=", value, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeLessThan(String value) {
            addCriterion("LOCATIONSIMPLECODE <", value, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeLessThanOrEqualTo(String value) {
            addCriterion("LOCATIONSIMPLECODE <=", value, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeLike(String value) {
            addCriterion("LOCATIONSIMPLECODE like", value, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeNotLike(String value) {
            addCriterion("LOCATIONSIMPLECODE not like", value, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeIn(List<String> values) {
            addCriterion("LOCATIONSIMPLECODE in", values, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeNotIn(List<String> values) {
            addCriterion("LOCATIONSIMPLECODE not in", values, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeBetween(String value1, String value2) {
            addCriterion("LOCATIONSIMPLECODE between", value1, value2, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andLocationsimplecodeNotBetween(String value1, String value2) {
            addCriterion("LOCATIONSIMPLECODE not between", value1, value2, "locationsimplecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeIsNull() {
            addCriterion("TELECODE is null");
            return (Criteria) this;
        }

        public Criteria andTelecodeIsNotNull() {
            addCriterion("TELECODE is not null");
            return (Criteria) this;
        }

        public Criteria andTelecodeEqualTo(String value) {
            addCriterion("TELECODE =", value, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeNotEqualTo(String value) {
            addCriterion("TELECODE <>", value, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeGreaterThan(String value) {
            addCriterion("TELECODE >", value, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeGreaterThanOrEqualTo(String value) {
            addCriterion("TELECODE >=", value, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeLessThan(String value) {
            addCriterion("TELECODE <", value, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeLessThanOrEqualTo(String value) {
            addCriterion("TELECODE <=", value, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeLike(String value) {
            addCriterion("TELECODE like", value, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeNotLike(String value) {
            addCriterion("TELECODE not like", value, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeIn(List<String> values) {
            addCriterion("TELECODE in", values, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeNotIn(List<String> values) {
            addCriterion("TELECODE not in", values, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeBetween(String value1, String value2) {
            addCriterion("TELECODE between", value1, value2, "telecode");
            return (Criteria) this;
        }

        public Criteria andTelecodeNotBetween(String value1, String value2) {
            addCriterion("TELECODE not between", value1, value2, "telecode");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andProvincecodeIsNull() {
            addCriterion("PROVINCECODE is null");
            return (Criteria) this;
        }

        public Criteria andProvincecodeIsNotNull() {
            addCriterion("PROVINCECODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvincecodeEqualTo(String value) {
            addCriterion("PROVINCECODE =", value, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeNotEqualTo(String value) {
            addCriterion("PROVINCECODE <>", value, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeGreaterThan(String value) {
            addCriterion("PROVINCECODE >", value, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCECODE >=", value, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeLessThan(String value) {
            addCriterion("PROVINCECODE <", value, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCECODE <=", value, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeLike(String value) {
            addCriterion("PROVINCECODE like", value, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeNotLike(String value) {
            addCriterion("PROVINCECODE not like", value, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeIn(List<String> values) {
            addCriterion("PROVINCECODE in", values, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeNotIn(List<String> values) {
            addCriterion("PROVINCECODE not in", values, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeBetween(String value1, String value2) {
            addCriterion("PROVINCECODE between", value1, value2, "provincecode");
            return (Criteria) this;
        }

        public Criteria andProvincecodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCECODE not between", value1, value2, "provincecode");
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