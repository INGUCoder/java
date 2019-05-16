package com.svideo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbVideoExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbVideoExample() {
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

        public Criteria andVideoNameIsNull() {
            addCriterion("video_name is null");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNotNull() {
            addCriterion("video_name is not null");
            return (Criteria) this;
        }

        public Criteria andVideoNameEqualTo(String value) {
            addCriterion("video_name =", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotEqualTo(String value) {
            addCriterion("video_name <>", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThan(String value) {
            addCriterion("video_name >", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThanOrEqualTo(String value) {
            addCriterion("video_name >=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThan(String value) {
            addCriterion("video_name <", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThanOrEqualTo(String value) {
            addCriterion("video_name <=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLike(String value) {
            addCriterion("video_name like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotLike(String value) {
            addCriterion("video_name not like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameIn(List<String> values) {
            addCriterion("video_name in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotIn(List<String> values) {
            addCriterion("video_name not in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameBetween(String value1, String value2) {
            addCriterion("video_name between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotBetween(String value1, String value2) {
            addCriterion("video_name not between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andMovieYearIsNull() {
            addCriterion("movie_year is null");
            return (Criteria) this;
        }

        public Criteria andMovieYearIsNotNull() {
            addCriterion("movie_year is not null");
            return (Criteria) this;
        }

        public Criteria andMovieYearEqualTo(Integer value) {
            addCriterion("movie_year =", value, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearNotEqualTo(Integer value) {
            addCriterion("movie_year <>", value, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearGreaterThan(Integer value) {
            addCriterion("movie_year >", value, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie_year >=", value, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearLessThan(Integer value) {
            addCriterion("movie_year <", value, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearLessThanOrEqualTo(Integer value) {
            addCriterion("movie_year <=", value, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearIn(List<Integer> values) {
            addCriterion("movie_year in", values, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearNotIn(List<Integer> values) {
            addCriterion("movie_year not in", values, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearBetween(Integer value1, Integer value2) {
            addCriterion("movie_year between", value1, value2, "movieYear");
            return (Criteria) this;
        }

        public Criteria andMovieYearNotBetween(Integer value1, Integer value2) {
            addCriterion("movie_year not between", value1, value2, "movieYear");
            return (Criteria) this;
        }

        public Criteria andShowTimeIsNull() {
            addCriterion("show_time is null");
            return (Criteria) this;
        }

        public Criteria andShowTimeIsNotNull() {
            addCriterion("show_time is not null");
            return (Criteria) this;
        }

        public Criteria andShowTimeEqualTo(Date value) {
            addCriterion("show_time =", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotEqualTo(Date value) {
            addCriterion("show_time <>", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeGreaterThan(Date value) {
            addCriterion("show_time >", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("show_time >=", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeLessThan(Date value) {
            addCriterion("show_time <", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeLessThanOrEqualTo(Date value) {
            addCriterion("show_time <=", value, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeIn(List<Date> values) {
            addCriterion("show_time in", values, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotIn(List<Date> values) {
            addCriterion("show_time not in", values, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeBetween(Date value1, Date value2) {
            addCriterion("show_time between", value1, value2, "showTime");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotBetween(Date value1, Date value2) {
            addCriterion("show_time not between", value1, value2, "showTime");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNull() {
            addCriterion("options is null");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (Criteria) this;
        }

        public Criteria andOptionsEqualTo(String value) {
            addCriterion("options =", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotEqualTo(String value) {
            addCriterion("options <>", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThan(String value) {
            addCriterion("options >", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThanOrEqualTo(String value) {
            addCriterion("options >=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThan(String value) {
            addCriterion("options <", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThanOrEqualTo(String value) {
            addCriterion("options <=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLike(String value) {
            addCriterion("options like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotLike(String value) {
            addCriterion("options not like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsIn(List<String> values) {
            addCriterion("options in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotIn(List<String> values) {
            addCriterion("options not in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsBetween(String value1, String value2) {
            addCriterion("options between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotBetween(String value1, String value2) {
            addCriterion("options not between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Double value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Double value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Double value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Double value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Double value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Double value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Double> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Double> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Double value1, Double value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Double value1, Double value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andDownloadsIsNull() {
            addCriterion("downloads is null");
            return (Criteria) this;
        }

        public Criteria andDownloadsIsNotNull() {
            addCriterion("downloads is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadsEqualTo(Long value) {
            addCriterion("downloads =", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotEqualTo(Long value) {
            addCriterion("downloads <>", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsGreaterThan(Long value) {
            addCriterion("downloads >", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsGreaterThanOrEqualTo(Long value) {
            addCriterion("downloads >=", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsLessThan(Long value) {
            addCriterion("downloads <", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsLessThanOrEqualTo(Long value) {
            addCriterion("downloads <=", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsIn(List<Long> values) {
            addCriterion("downloads in", values, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotIn(List<Long> values) {
            addCriterion("downloads not in", values, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsBetween(Long value1, Long value2) {
            addCriterion("downloads between", value1, value2, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotBetween(Long value1, Long value2) {
            addCriterion("downloads not between", value1, value2, "downloads");
            return (Criteria) this;
        }

        public Criteria andPlaysIsNull() {
            addCriterion("plays is null");
            return (Criteria) this;
        }

        public Criteria andPlaysIsNotNull() {
            addCriterion("plays is not null");
            return (Criteria) this;
        }

        public Criteria andPlaysEqualTo(Long value) {
            addCriterion("plays =", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysNotEqualTo(Long value) {
            addCriterion("plays <>", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysGreaterThan(Long value) {
            addCriterion("plays >", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysGreaterThanOrEqualTo(Long value) {
            addCriterion("plays >=", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysLessThan(Long value) {
            addCriterion("plays <", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysLessThanOrEqualTo(Long value) {
            addCriterion("plays <=", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysIn(List<Long> values) {
            addCriterion("plays in", values, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysNotIn(List<Long> values) {
            addCriterion("plays not in", values, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysBetween(Long value1, Long value2) {
            addCriterion("plays between", value1, value2, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysNotBetween(Long value1, Long value2) {
            addCriterion("plays not between", value1, value2, "plays");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMvTypeIsNull() {
            addCriterion("mv_type is null");
            return (Criteria) this;
        }

        public Criteria andMvTypeIsNotNull() {
            addCriterion("mv_type is not null");
            return (Criteria) this;
        }

        public Criteria andMvTypeEqualTo(String value) {
            addCriterion("mv_type =", value, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeNotEqualTo(String value) {
            addCriterion("mv_type <>", value, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeGreaterThan(String value) {
            addCriterion("mv_type >", value, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mv_type >=", value, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeLessThan(String value) {
            addCriterion("mv_type <", value, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeLessThanOrEqualTo(String value) {
            addCriterion("mv_type <=", value, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeLike(String value) {
            addCriterion("mv_type like", value, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeNotLike(String value) {
            addCriterion("mv_type not like", value, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeIn(List<String> values) {
            addCriterion("mv_type in", values, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeNotIn(List<String> values) {
            addCriterion("mv_type not in", values, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeBetween(String value1, String value2) {
            addCriterion("mv_type between", value1, value2, "mvType");
            return (Criteria) this;
        }

        public Criteria andMvTypeNotBetween(String value1, String value2) {
            addCriterion("mv_type not between", value1, value2, "mvType");
            return (Criteria) this;
        }

        public Criteria andImgTypeIsNull() {
            addCriterion("img_type is null");
            return (Criteria) this;
        }

        public Criteria andImgTypeIsNotNull() {
            addCriterion("img_type is not null");
            return (Criteria) this;
        }

        public Criteria andImgTypeEqualTo(String value) {
            addCriterion("img_type =", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotEqualTo(String value) {
            addCriterion("img_type <>", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeGreaterThan(String value) {
            addCriterion("img_type >", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("img_type >=", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLessThan(String value) {
            addCriterion("img_type <", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLessThanOrEqualTo(String value) {
            addCriterion("img_type <=", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLike(String value) {
            addCriterion("img_type like", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotLike(String value) {
            addCriterion("img_type not like", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeIn(List<String> values) {
            addCriterion("img_type in", values, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotIn(List<String> values) {
            addCriterion("img_type not in", values, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeBetween(String value1, String value2) {
            addCriterion("img_type between", value1, value2, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotBetween(String value1, String value2) {
            addCriterion("img_type not between", value1, value2, "imgType");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andSliderImageIsNull() {
            addCriterion("slider_image is null");
            return (Criteria) this;
        }

        public Criteria andSliderImageIsNotNull() {
            addCriterion("slider_image is not null");
            return (Criteria) this;
        }

        public Criteria andSliderImageEqualTo(String value) {
            addCriterion("slider_image =", value, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageNotEqualTo(String value) {
            addCriterion("slider_image <>", value, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageGreaterThan(String value) {
            addCriterion("slider_image >", value, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageGreaterThanOrEqualTo(String value) {
            addCriterion("slider_image >=", value, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageLessThan(String value) {
            addCriterion("slider_image <", value, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageLessThanOrEqualTo(String value) {
            addCriterion("slider_image <=", value, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageLike(String value) {
            addCriterion("slider_image like", value, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageNotLike(String value) {
            addCriterion("slider_image not like", value, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageIn(List<String> values) {
            addCriterion("slider_image in", values, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageNotIn(List<String> values) {
            addCriterion("slider_image not in", values, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageBetween(String value1, String value2) {
            addCriterion("slider_image between", value1, value2, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andSliderImageNotBetween(String value1, String value2) {
            addCriterion("slider_image not between", value1, value2, "sliderImage");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andIsplayIsNull() {
            addCriterion("isplay is null");
            return (Criteria) this;
        }

        public Criteria andIsplayIsNotNull() {
            addCriterion("isplay is not null");
            return (Criteria) this;
        }

        public Criteria andIsplayEqualTo(Integer value) {
            addCriterion("isplay =", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayNotEqualTo(Integer value) {
            addCriterion("isplay <>", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayGreaterThan(Integer value) {
            addCriterion("isplay >", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayGreaterThanOrEqualTo(Integer value) {
            addCriterion("isplay >=", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayLessThan(Integer value) {
            addCriterion("isplay <", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayLessThanOrEqualTo(Integer value) {
            addCriterion("isplay <=", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayIn(List<Integer> values) {
            addCriterion("isplay in", values, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayNotIn(List<Integer> values) {
            addCriterion("isplay not in", values, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayBetween(Integer value1, Integer value2) {
            addCriterion("isplay between", value1, value2, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayNotBetween(Integer value1, Integer value2) {
            addCriterion("isplay not between", value1, value2, "isplay");
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