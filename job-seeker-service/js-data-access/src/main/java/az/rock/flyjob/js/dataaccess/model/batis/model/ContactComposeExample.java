package az.rock.flyjob.js.dataaccess.model.batis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class ContactComposeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContactComposeExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(Object value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(Object value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(Object value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(Object value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(Object value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(Object value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<Object> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<Object> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(Object value1, Object value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(Object value1, Object value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNull() {
            addCriterion("process_status is null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNotNull() {
            addCriterion("process_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusEqualTo(String value) {
            addCriterion("process_status =", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotEqualTo(String value) {
            addCriterion("process_status <>", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThan(String value) {
            addCriterion("process_status >", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThanOrEqualTo(String value) {
            addCriterion("process_status >=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThan(String value) {
            addCriterion("process_status <", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThanOrEqualTo(String value) {
            addCriterion("process_status <=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLike(String value) {
            addCriterion("process_status like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotLike(String value) {
            addCriterion("process_status not like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIn(List<String> values) {
            addCriterion("process_status in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotIn(List<String> values) {
            addCriterion("process_status not in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusBetween(String value1, String value2) {
            addCriterion("process_status between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotBetween(String value1, String value2) {
            addCriterion("process_status not between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusIsNull() {
            addCriterion("row_status is null");
            return (Criteria) this;
        }

        public Criteria andRowStatusIsNotNull() {
            addCriterion("row_status is not null");
            return (Criteria) this;
        }

        public Criteria andRowStatusEqualTo(String value) {
            addCriterion("row_status =", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotEqualTo(String value) {
            addCriterion("row_status <>", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusGreaterThan(String value) {
            addCriterion("row_status >", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("row_status >=", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLessThan(String value) {
            addCriterion("row_status <", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLessThanOrEqualTo(String value) {
            addCriterion("row_status <=", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLike(String value) {
            addCriterion("row_status like", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotLike(String value) {
            addCriterion("row_status not like", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusIn(List<String> values) {
            addCriterion("row_status in", values, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotIn(List<String> values) {
            addCriterion("row_status not in", values, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusBetween(String value1, String value2) {
            addCriterion("row_status between", value1, value2, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotBetween(String value1, String value2) {
            addCriterion("row_status not between", value1, value2, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateIsNull() {
            addCriterion("modification_date is null");
            return (Criteria) this;
        }

        public Criteria andModificationDateIsNotNull() {
            addCriterion("modification_date is not null");
            return (Criteria) this;
        }

        public Criteria andModificationDateEqualTo(Date value) {
            addCriterion("modification_date =", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotEqualTo(Date value) {
            addCriterion("modification_date <>", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateGreaterThan(Date value) {
            addCriterion("modification_date >", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modification_date >=", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateLessThan(Date value) {
            addCriterion("modification_date <", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateLessThanOrEqualTo(Date value) {
            addCriterion("modification_date <=", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateIn(List<Date> values) {
            addCriterion("modification_date in", values, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotIn(List<Date> values) {
            addCriterion("modification_date not in", values, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateBetween(Date value1, Date value2) {
            addCriterion("modification_date between", value1, value2, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotBetween(Date value1, Date value2) {
            addCriterion("modification_date not between", value1, value2, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andResumeUuidIsNull() {
            addCriterion("resume_uuid is null");
            return (Criteria) this;
        }

        public Criteria andResumeUuidIsNotNull() {
            addCriterion("resume_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andResumeUuidEqualTo(Object value) {
            addCriterion("resume_uuid =", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidNotEqualTo(Object value) {
            addCriterion("resume_uuid <>", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidGreaterThan(Object value) {
            addCriterion("resume_uuid >", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidGreaterThanOrEqualTo(Object value) {
            addCriterion("resume_uuid >=", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidLessThan(Object value) {
            addCriterion("resume_uuid <", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidLessThanOrEqualTo(Object value) {
            addCriterion("resume_uuid <=", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidIn(List<Object> values) {
            addCriterion("resume_uuid in", values, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidNotIn(List<Object> values) {
            addCriterion("resume_uuid not in", values, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidBetween(Object value1, Object value2) {
            addCriterion("resume_uuid between", value1, value2, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidNotBetween(Object value1, Object value2) {
            addCriterion("resume_uuid not between", value1, value2, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andAccessModifierIsNull() {
            addCriterion("access_modifier is null");
            return (Criteria) this;
        }

        public Criteria andAccessModifierIsNotNull() {
            addCriterion("access_modifier is not null");
            return (Criteria) this;
        }

        public Criteria andAccessModifierEqualTo(String value) {
            addCriterion("access_modifier =", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierNotEqualTo(String value) {
            addCriterion("access_modifier <>", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierGreaterThan(String value) {
            addCriterion("access_modifier >", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierGreaterThanOrEqualTo(String value) {
            addCriterion("access_modifier >=", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierLessThan(String value) {
            addCriterion("access_modifier <", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierLessThanOrEqualTo(String value) {
            addCriterion("access_modifier <=", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierLike(String value) {
            addCriterion("access_modifier like", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierNotLike(String value) {
            addCriterion("access_modifier not like", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierIn(List<String> values) {
            addCriterion("access_modifier in", values, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierNotIn(List<String> values) {
            addCriterion("access_modifier not in", values, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierBetween(String value1, String value2) {
            addCriterion("access_modifier between", value1, value2, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierNotBetween(String value1, String value2) {
            addCriterion("access_modifier not between", value1, value2, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIsNull() {
            addCriterion("format_type is null");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIsNotNull() {
            addCriterion("format_type is not null");
            return (Criteria) this;
        }

        public Criteria andFormatTypeEqualTo(String value) {
            addCriterion("format_type =", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotEqualTo(String value) {
            addCriterion("format_type <>", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeGreaterThan(String value) {
            addCriterion("format_type >", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("format_type >=", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeLessThan(String value) {
            addCriterion("format_type <", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeLessThanOrEqualTo(String value) {
            addCriterion("format_type <=", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeLike(String value) {
            addCriterion("format_type like", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotLike(String value) {
            addCriterion("format_type not like", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIn(List<String> values) {
            addCriterion("format_type in", values, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotIn(List<String> values) {
            addCriterion("format_type not in", values, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeBetween(String value1, String value2) {
            addCriterion("format_type between", value1, value2, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotBetween(String value1, String value2) {
            addCriterion("format_type not between", value1, value2, "formatType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeIsNull() {
            addCriterion("live_type is null");
            return (Criteria) this;
        }

        public Criteria andLiveTypeIsNotNull() {
            addCriterion("live_type is not null");
            return (Criteria) this;
        }

        public Criteria andLiveTypeEqualTo(String value) {
            addCriterion("live_type =", value, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeNotEqualTo(String value) {
            addCriterion("live_type <>", value, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeGreaterThan(String value) {
            addCriterion("live_type >", value, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("live_type >=", value, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeLessThan(String value) {
            addCriterion("live_type <", value, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeLessThanOrEqualTo(String value) {
            addCriterion("live_type <=", value, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeLike(String value) {
            addCriterion("live_type like", value, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeNotLike(String value) {
            addCriterion("live_type not like", value, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeIn(List<String> values) {
            addCriterion("live_type in", values, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeNotIn(List<String> values) {
            addCriterion("live_type not in", values, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeBetween(String value1, String value2) {
            addCriterion("live_type between", value1, value2, "liveType");
            return (Criteria) this;
        }

        public Criteria andLiveTypeNotBetween(String value1, String value2) {
            addCriterion("live_type not between", value1, value2, "liveType");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("data is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("data is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("data =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("data <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("data >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("data >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("data <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("data <=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLike(String value) {
            addCriterion("data like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("data not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("data in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("data not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("data between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("data not between", value1, value2, "data");
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