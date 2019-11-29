package com.rui.domain.export;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExportExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andInputDateIsNull() {
            addCriterion("input_date is null");
            return (Criteria) this;
        }

        public Criteria andInputDateIsNotNull() {
            addCriterion("input_date is not null");
            return (Criteria) this;
        }

        public Criteria andInputDateEqualTo(Date value) {
            addCriterion("input_date =", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateNotEqualTo(Date value) {
            addCriterion("input_date <>", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateGreaterThan(Date value) {
            addCriterion("input_date >", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateGreaterThanOrEqualTo(Date value) {
            addCriterion("input_date >=", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateLessThan(Date value) {
            addCriterion("input_date <", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateLessThanOrEqualTo(Date value) {
            addCriterion("input_date <=", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateIn(List<Date> values) {
            addCriterion("input_date in", values, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateNotIn(List<Date> values) {
            addCriterion("input_date not in", values, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateBetween(Date value1, Date value2) {
            addCriterion("input_date between", value1, value2, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateNotBetween(Date value1, Date value2) {
            addCriterion("input_date not between", value1, value2, "inputDate");
            return (Criteria) this;
        }

        public Criteria andContractIdsIsNull() {
            addCriterion("contract_ids is null");
            return (Criteria) this;
        }

        public Criteria andContractIdsIsNotNull() {
            addCriterion("contract_ids is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdsEqualTo(String value) {
            addCriterion("contract_ids =", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsNotEqualTo(String value) {
            addCriterion("contract_ids <>", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsGreaterThan(String value) {
            addCriterion("contract_ids >", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsGreaterThanOrEqualTo(String value) {
            addCriterion("contract_ids >=", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsLessThan(String value) {
            addCriterion("contract_ids <", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsLessThanOrEqualTo(String value) {
            addCriterion("contract_ids <=", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsLike(String value) {
            addCriterion("contract_ids like", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsNotLike(String value) {
            addCriterion("contract_ids not like", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsIn(List<String> values) {
            addCriterion("contract_ids in", values, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsNotIn(List<String> values) {
            addCriterion("contract_ids not in", values, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsBetween(String value1, String value2) {
            addCriterion("contract_ids between", value1, value2, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsNotBetween(String value1, String value2) {
            addCriterion("contract_ids not between", value1, value2, "contractIds");
            return (Criteria) this;
        }

        public Criteria andCustomerContractIsNull() {
            addCriterion("customer_contract is null");
            return (Criteria) this;
        }

        public Criteria andCustomerContractIsNotNull() {
            addCriterion("customer_contract is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerContractEqualTo(String value) {
            addCriterion("customer_contract =", value, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractNotEqualTo(String value) {
            addCriterion("customer_contract <>", value, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractGreaterThan(String value) {
            addCriterion("customer_contract >", value, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractGreaterThanOrEqualTo(String value) {
            addCriterion("customer_contract >=", value, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractLessThan(String value) {
            addCriterion("customer_contract <", value, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractLessThanOrEqualTo(String value) {
            addCriterion("customer_contract <=", value, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractLike(String value) {
            addCriterion("customer_contract like", value, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractNotLike(String value) {
            addCriterion("customer_contract not like", value, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractIn(List<String> values) {
            addCriterion("customer_contract in", values, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractNotIn(List<String> values) {
            addCriterion("customer_contract not in", values, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractBetween(String value1, String value2) {
            addCriterion("customer_contract between", value1, value2, "customerContract");
            return (Criteria) this;
        }

        public Criteria andCustomerContractNotBetween(String value1, String value2) {
            addCriterion("customer_contract not between", value1, value2, "customerContract");
            return (Criteria) this;
        }

        public Criteria andLcnoIsNull() {
            addCriterion("lcno is null");
            return (Criteria) this;
        }

        public Criteria andLcnoIsNotNull() {
            addCriterion("lcno is not null");
            return (Criteria) this;
        }

        public Criteria andLcnoEqualTo(String value) {
            addCriterion("lcno =", value, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoNotEqualTo(String value) {
            addCriterion("lcno <>", value, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoGreaterThan(String value) {
            addCriterion("lcno >", value, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoGreaterThanOrEqualTo(String value) {
            addCriterion("lcno >=", value, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoLessThan(String value) {
            addCriterion("lcno <", value, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoLessThanOrEqualTo(String value) {
            addCriterion("lcno <=", value, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoLike(String value) {
            addCriterion("lcno like", value, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoNotLike(String value) {
            addCriterion("lcno not like", value, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoIn(List<String> values) {
            addCriterion("lcno in", values, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoNotIn(List<String> values) {
            addCriterion("lcno not in", values, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoBetween(String value1, String value2) {
            addCriterion("lcno between", value1, value2, "lcno");
            return (Criteria) this;
        }

        public Criteria andLcnoNotBetween(String value1, String value2) {
            addCriterion("lcno not between", value1, value2, "lcno");
            return (Criteria) this;
        }

        public Criteria andConsigneeIsNull() {
            addCriterion("consignee is null");
            return (Criteria) this;
        }

        public Criteria andConsigneeIsNotNull() {
            addCriterion("consignee is not null");
            return (Criteria) this;
        }

        public Criteria andConsigneeEqualTo(String value) {
            addCriterion("consignee =", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotEqualTo(String value) {
            addCriterion("consignee <>", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeGreaterThan(String value) {
            addCriterion("consignee >", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeGreaterThanOrEqualTo(String value) {
            addCriterion("consignee >=", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLessThan(String value) {
            addCriterion("consignee <", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLessThanOrEqualTo(String value) {
            addCriterion("consignee <=", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLike(String value) {
            addCriterion("consignee like", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotLike(String value) {
            addCriterion("consignee not like", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeIn(List<String> values) {
            addCriterion("consignee in", values, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotIn(List<String> values) {
            addCriterion("consignee not in", values, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeBetween(String value1, String value2) {
            addCriterion("consignee between", value1, value2, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotBetween(String value1, String value2) {
            addCriterion("consignee not between", value1, value2, "consignee");
            return (Criteria) this;
        }

        public Criteria andMarksIsNull() {
            addCriterion("marks is null");
            return (Criteria) this;
        }

        public Criteria andMarksIsNotNull() {
            addCriterion("marks is not null");
            return (Criteria) this;
        }

        public Criteria andMarksEqualTo(String value) {
            addCriterion("marks =", value, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksNotEqualTo(String value) {
            addCriterion("marks <>", value, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksGreaterThan(String value) {
            addCriterion("marks >", value, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksGreaterThanOrEqualTo(String value) {
            addCriterion("marks >=", value, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksLessThan(String value) {
            addCriterion("marks <", value, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksLessThanOrEqualTo(String value) {
            addCriterion("marks <=", value, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksLike(String value) {
            addCriterion("marks like", value, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksNotLike(String value) {
            addCriterion("marks not like", value, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksIn(List<String> values) {
            addCriterion("marks in", values, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksNotIn(List<String> values) {
            addCriterion("marks not in", values, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksBetween(String value1, String value2) {
            addCriterion("marks between", value1, value2, "marks");
            return (Criteria) this;
        }

        public Criteria andMarksNotBetween(String value1, String value2) {
            addCriterion("marks not between", value1, value2, "marks");
            return (Criteria) this;
        }

        public Criteria andShipmentPortIsNull() {
            addCriterion("shipment_port is null");
            return (Criteria) this;
        }

        public Criteria andShipmentPortIsNotNull() {
            addCriterion("shipment_port is not null");
            return (Criteria) this;
        }

        public Criteria andShipmentPortEqualTo(String value) {
            addCriterion("shipment_port =", value, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortNotEqualTo(String value) {
            addCriterion("shipment_port <>", value, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortGreaterThan(String value) {
            addCriterion("shipment_port >", value, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortGreaterThanOrEqualTo(String value) {
            addCriterion("shipment_port >=", value, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortLessThan(String value) {
            addCriterion("shipment_port <", value, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortLessThanOrEqualTo(String value) {
            addCriterion("shipment_port <=", value, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortLike(String value) {
            addCriterion("shipment_port like", value, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortNotLike(String value) {
            addCriterion("shipment_port not like", value, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortIn(List<String> values) {
            addCriterion("shipment_port in", values, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortNotIn(List<String> values) {
            addCriterion("shipment_port not in", values, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortBetween(String value1, String value2) {
            addCriterion("shipment_port between", value1, value2, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andShipmentPortNotBetween(String value1, String value2) {
            addCriterion("shipment_port not between", value1, value2, "shipmentPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortIsNull() {
            addCriterion("destination_port is null");
            return (Criteria) this;
        }

        public Criteria andDestinationPortIsNotNull() {
            addCriterion("destination_port is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationPortEqualTo(String value) {
            addCriterion("destination_port =", value, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortNotEqualTo(String value) {
            addCriterion("destination_port <>", value, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortGreaterThan(String value) {
            addCriterion("destination_port >", value, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortGreaterThanOrEqualTo(String value) {
            addCriterion("destination_port >=", value, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortLessThan(String value) {
            addCriterion("destination_port <", value, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortLessThanOrEqualTo(String value) {
            addCriterion("destination_port <=", value, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortLike(String value) {
            addCriterion("destination_port like", value, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortNotLike(String value) {
            addCriterion("destination_port not like", value, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortIn(List<String> values) {
            addCriterion("destination_port in", values, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortNotIn(List<String> values) {
            addCriterion("destination_port not in", values, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortBetween(String value1, String value2) {
            addCriterion("destination_port between", value1, value2, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andDestinationPortNotBetween(String value1, String value2) {
            addCriterion("destination_port not between", value1, value2, "destinationPort");
            return (Criteria) this;
        }

        public Criteria andTransportModeIsNull() {
            addCriterion("transport_mode is null");
            return (Criteria) this;
        }

        public Criteria andTransportModeIsNotNull() {
            addCriterion("transport_mode is not null");
            return (Criteria) this;
        }

        public Criteria andTransportModeEqualTo(String value) {
            addCriterion("transport_mode =", value, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeNotEqualTo(String value) {
            addCriterion("transport_mode <>", value, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeGreaterThan(String value) {
            addCriterion("transport_mode >", value, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeGreaterThanOrEqualTo(String value) {
            addCriterion("transport_mode >=", value, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeLessThan(String value) {
            addCriterion("transport_mode <", value, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeLessThanOrEqualTo(String value) {
            addCriterion("transport_mode <=", value, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeLike(String value) {
            addCriterion("transport_mode like", value, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeNotLike(String value) {
            addCriterion("transport_mode not like", value, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeIn(List<String> values) {
            addCriterion("transport_mode in", values, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeNotIn(List<String> values) {
            addCriterion("transport_mode not in", values, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeBetween(String value1, String value2) {
            addCriterion("transport_mode between", value1, value2, "transportMode");
            return (Criteria) this;
        }

        public Criteria andTransportModeNotBetween(String value1, String value2) {
            addCriterion("transport_mode not between", value1, value2, "transportMode");
            return (Criteria) this;
        }

        public Criteria andPriceConditionIsNull() {
            addCriterion("price_condition is null");
            return (Criteria) this;
        }

        public Criteria andPriceConditionIsNotNull() {
            addCriterion("price_condition is not null");
            return (Criteria) this;
        }

        public Criteria andPriceConditionEqualTo(String value) {
            addCriterion("price_condition =", value, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionNotEqualTo(String value) {
            addCriterion("price_condition <>", value, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionGreaterThan(String value) {
            addCriterion("price_condition >", value, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionGreaterThanOrEqualTo(String value) {
            addCriterion("price_condition >=", value, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionLessThan(String value) {
            addCriterion("price_condition <", value, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionLessThanOrEqualTo(String value) {
            addCriterion("price_condition <=", value, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionLike(String value) {
            addCriterion("price_condition like", value, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionNotLike(String value) {
            addCriterion("price_condition not like", value, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionIn(List<String> values) {
            addCriterion("price_condition in", values, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionNotIn(List<String> values) {
            addCriterion("price_condition not in", values, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionBetween(String value1, String value2) {
            addCriterion("price_condition between", value1, value2, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andPriceConditionNotBetween(String value1, String value2) {
            addCriterion("price_condition not between", value1, value2, "priceCondition");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBoxNumsIsNull() {
            addCriterion("box_nums is null");
            return (Criteria) this;
        }

        public Criteria andBoxNumsIsNotNull() {
            addCriterion("box_nums is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNumsEqualTo(Long value) {
            addCriterion("box_nums =", value, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsNotEqualTo(Long value) {
            addCriterion("box_nums <>", value, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsGreaterThan(Long value) {
            addCriterion("box_nums >", value, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsGreaterThanOrEqualTo(Long value) {
            addCriterion("box_nums >=", value, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsLessThan(Long value) {
            addCriterion("box_nums <", value, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsLessThanOrEqualTo(Long value) {
            addCriterion("box_nums <=", value, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsIn(List<Long> values) {
            addCriterion("box_nums in", values, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsNotIn(List<Long> values) {
            addCriterion("box_nums not in", values, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsBetween(Long value1, Long value2) {
            addCriterion("box_nums between", value1, value2, "boxNums");
            return (Criteria) this;
        }

        public Criteria andBoxNumsNotBetween(Long value1, Long value2) {
            addCriterion("box_nums not between", value1, value2, "boxNums");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsIsNull() {
            addCriterion("gross_weights is null");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsIsNotNull() {
            addCriterion("gross_weights is not null");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsEqualTo(BigDecimal value) {
            addCriterion("gross_weights =", value, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsNotEqualTo(BigDecimal value) {
            addCriterion("gross_weights <>", value, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsGreaterThan(BigDecimal value) {
            addCriterion("gross_weights >", value, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_weights >=", value, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsLessThan(BigDecimal value) {
            addCriterion("gross_weights <", value, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_weights <=", value, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsIn(List<BigDecimal> values) {
            addCriterion("gross_weights in", values, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsNotIn(List<BigDecimal> values) {
            addCriterion("gross_weights not in", values, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_weights between", value1, value2, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andGrossWeightsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_weights not between", value1, value2, "grossWeights");
            return (Criteria) this;
        }

        public Criteria andMeasurementsIsNull() {
            addCriterion("measurements is null");
            return (Criteria) this;
        }

        public Criteria andMeasurementsIsNotNull() {
            addCriterion("measurements is not null");
            return (Criteria) this;
        }

        public Criteria andMeasurementsEqualTo(BigDecimal value) {
            addCriterion("measurements =", value, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsNotEqualTo(BigDecimal value) {
            addCriterion("measurements <>", value, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsGreaterThan(BigDecimal value) {
            addCriterion("measurements >", value, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("measurements >=", value, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsLessThan(BigDecimal value) {
            addCriterion("measurements <", value, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("measurements <=", value, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsIn(List<BigDecimal> values) {
            addCriterion("measurements in", values, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsNotIn(List<BigDecimal> values) {
            addCriterion("measurements not in", values, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("measurements between", value1, value2, "measurements");
            return (Criteria) this;
        }

        public Criteria andMeasurementsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("measurements not between", value1, value2, "measurements");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Long value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Long value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Long value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Long value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Long value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Long value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Long> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Long> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Long value1, Long value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Long value1, Long value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andProNumIsNull() {
            addCriterion("pro_num is null");
            return (Criteria) this;
        }

        public Criteria andProNumIsNotNull() {
            addCriterion("pro_num is not null");
            return (Criteria) this;
        }

        public Criteria andProNumEqualTo(Integer value) {
            addCriterion("pro_num =", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotEqualTo(Integer value) {
            addCriterion("pro_num <>", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThan(Integer value) {
            addCriterion("pro_num >", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_num >=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThan(Integer value) {
            addCriterion("pro_num <", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThanOrEqualTo(Integer value) {
            addCriterion("pro_num <=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumIn(List<Integer> values) {
            addCriterion("pro_num in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotIn(List<Integer> values) {
            addCriterion("pro_num not in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumBetween(Integer value1, Integer value2) {
            addCriterion("pro_num between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_num not between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andExtNumIsNull() {
            addCriterion("ext_num is null");
            return (Criteria) this;
        }

        public Criteria andExtNumIsNotNull() {
            addCriterion("ext_num is not null");
            return (Criteria) this;
        }

        public Criteria andExtNumEqualTo(Integer value) {
            addCriterion("ext_num =", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumNotEqualTo(Integer value) {
            addCriterion("ext_num <>", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumGreaterThan(Integer value) {
            addCriterion("ext_num >", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ext_num >=", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumLessThan(Integer value) {
            addCriterion("ext_num <", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumLessThanOrEqualTo(Integer value) {
            addCriterion("ext_num <=", value, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumIn(List<Integer> values) {
            addCriterion("ext_num in", values, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumNotIn(List<Integer> values) {
            addCriterion("ext_num not in", values, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumBetween(Integer value1, Integer value2) {
            addCriterion("ext_num between", value1, value2, "extNum");
            return (Criteria) this;
        }

        public Criteria andExtNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ext_num not between", value1, value2, "extNum");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIsNull() {
            addCriterion("create_dept is null");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIsNotNull() {
            addCriterion("create_dept is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDeptEqualTo(String value) {
            addCriterion("create_dept =", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotEqualTo(String value) {
            addCriterion("create_dept <>", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptGreaterThan(String value) {
            addCriterion("create_dept >", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptGreaterThanOrEqualTo(String value) {
            addCriterion("create_dept >=", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLessThan(String value) {
            addCriterion("create_dept <", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLessThanOrEqualTo(String value) {
            addCriterion("create_dept <=", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLike(String value) {
            addCriterion("create_dept like", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotLike(String value) {
            addCriterion("create_dept not like", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIn(List<String> values) {
            addCriterion("create_dept in", values, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotIn(List<String> values) {
            addCriterion("create_dept not in", values, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptBetween(String value1, String value2) {
            addCriterion("create_dept between", value1, value2, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotBetween(String value1, String value2) {
            addCriterion("create_dept not between", value1, value2, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
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