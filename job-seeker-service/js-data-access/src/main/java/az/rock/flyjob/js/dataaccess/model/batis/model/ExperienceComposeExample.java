package az.rock.flyjob.js.dataaccess.model.batis.model;

import az.rock.flyjob.js.domain.presentation.dto.criteria.CourseCriteria;
import az.rock.flyjob.js.domain.presentation.dto.criteria.ExperienceCriteria;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import com.intellibucket.lib.fj.dataaccess.BatisPageable;

import java.util.*;

@SuppressWarnings("all")
public class ExperienceComposeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected BatisPageable pageable;

    public static ExperienceComposeExample of(ExperienceCriteria criteria){
        var example = new ExperienceComposeExample();
        return addCriteria(example,criteria);
    }

    public static ExperienceComposeExample of(ExperienceCriteria criteria, String orderByClause, BatisPageable pageable){
        var example = new ExperienceComposeExample(orderByClause,pageable);
        return addCriteria(example,criteria);
    }

    private static ExperienceComposeExample addCriteria(ExperienceComposeExample example,ExperienceCriteria criteria){
        var newCriteria = example.createCriteria();
        newCriteria.andRowStatusEqualTo(RowStatus.ACTIVE.name());
        newCriteria.andProcessStatusEqualTo(ProcessStatus.COMPLETED.name());
        if(Optional.ofNullable(criteria.getResumeID()).isPresent())newCriteria.andResumeUuidEqualTo(criteria.getResumeID().getRootID());
        if(Optional.ofNullable(criteria.getId()).isPresent())newCriteria.andUuidEqualTo(criteria.getId().getRootID());
        if(Optional.ofNullable(criteria.getAccessModifiers()).isPresent())newCriteria.andAccessModifierIn(criteria.getAccessModifiers().stream().map(AccessModifier::name).toList());
        return example;
    }

    public ExperienceComposeExample() {
        oredCriteria = new ArrayList<>();
    }
    public ExperienceComposeExample(String orderByClause, BatisPageable pageable) {
        this.orderByClause = orderByClause;
        this.pageable = pageable;
        oredCriteria = new ArrayList<>();
    }

    public BatisPageable getPageable() {
        return pageable;
    }

    public void setPageable(BatisPageable pageable) {
        this.pageable = pageable;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andEmployerIsNull() {
            addCriterion("employer is null");
            return (Criteria) this;
        }

        public Criteria andEmployerIsNotNull() {
            addCriterion("employer is not null");
            return (Criteria) this;
        }

        public Criteria andEmployerEqualTo(String value) {
            addCriterion("employer =", value, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerNotEqualTo(String value) {
            addCriterion("employer <>", value, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerGreaterThan(String value) {
            addCriterion("employer >", value, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerGreaterThanOrEqualTo(String value) {
            addCriterion("employer >=", value, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerLessThan(String value) {
            addCriterion("employer <", value, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerLessThanOrEqualTo(String value) {
            addCriterion("employer <=", value, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerLike(String value) {
            addCriterion("employer like", value, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerNotLike(String value) {
            addCriterion("employer not like", value, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerIn(List<String> values) {
            addCriterion("employer in", values, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerNotIn(List<String> values) {
            addCriterion("employer not in", values, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerBetween(String value1, String value2) {
            addCriterion("employer between", value1, value2, "employer");
            return (Criteria) this;
        }

        public Criteria andEmployerNotBetween(String value1, String value2) {
            addCriterion("employer not between", value1, value2, "employer");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andJobTitleIsNull() {
            addCriterion("job_title is null");
            return (Criteria) this;
        }

        public Criteria andJobTitleIsNotNull() {
            addCriterion("job_title is not null");
            return (Criteria) this;
        }

        public Criteria andJobTitleEqualTo(String value) {
            addCriterion("job_title =", value, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleNotEqualTo(String value) {
            addCriterion("job_title <>", value, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleGreaterThan(String value) {
            addCriterion("job_title >", value, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleGreaterThanOrEqualTo(String value) {
            addCriterion("job_title >=", value, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleLessThan(String value) {
            addCriterion("job_title <", value, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleLessThanOrEqualTo(String value) {
            addCriterion("job_title <=", value, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleLike(String value) {
            addCriterion("job_title like", value, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleNotLike(String value) {
            addCriterion("job_title not like", value, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleIn(List<String> values) {
            addCriterion("job_title in", values, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleNotIn(List<String> values) {
            addCriterion("job_title not in", values, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleBetween(String value1, String value2) {
            addCriterion("job_title between", value1, value2, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andJobTitleNotBetween(String value1, String value2) {
            addCriterion("job_title not between", value1, value2, "jobTitle");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Object value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Object value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Object value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Object value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Object value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Object value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Object> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Object> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Object value1, Object value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Object value1, Object value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeIsNull() {
            addCriterion("working_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeIsNotNull() {
            addCriterion("working_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeEqualTo(String value) {
            addCriterion("working_type =", value, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeNotEqualTo(String value) {
            addCriterion("working_type <>", value, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeGreaterThan(String value) {
            addCriterion("working_type >", value, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("working_type >=", value, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeLessThan(String value) {
            addCriterion("working_type <", value, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeLessThanOrEqualTo(String value) {
            addCriterion("working_type <=", value, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeLike(String value) {
            addCriterion("working_type like", value, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeNotLike(String value) {
            addCriterion("working_type not like", value, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeIn(List<String> values) {
            addCriterion("working_type in", values, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeNotIn(List<String> values) {
            addCriterion("working_type not in", values, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeBetween(String value1, String value2) {
            addCriterion("working_type between", value1, value2, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTypeNotBetween(String value1, String value2) {
            addCriterion("working_type not between", value1, value2, "workingType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeIsNull() {
            addCriterion("working_time_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeIsNotNull() {
            addCriterion("working_time_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeEqualTo(String value) {
            addCriterion("working_time_type =", value, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeNotEqualTo(String value) {
            addCriterion("working_time_type <>", value, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeGreaterThan(String value) {
            addCriterion("working_time_type >", value, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("working_time_type >=", value, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeLessThan(String value) {
            addCriterion("working_time_type <", value, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeLessThanOrEqualTo(String value) {
            addCriterion("working_time_type <=", value, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeLike(String value) {
            addCriterion("working_time_type like", value, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeNotLike(String value) {
            addCriterion("working_time_type not like", value, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeIn(List<String> values) {
            addCriterion("working_time_type in", values, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeNotIn(List<String> values) {
            addCriterion("working_time_type not in", values, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeBetween(String value1, String value2) {
            addCriterion("working_time_type between", value1, value2, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeTypeNotBetween(String value1, String value2) {
            addCriterion("working_time_type not between", value1, value2, "workingTimeType");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
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