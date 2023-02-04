
package com.ctu.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.bridge.builtin.LongBridge;

import com.ctu.utils.TimestampDeserializer;
import com.ctu.utils.TimestampSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity(name = "Requests")
@Table(name = "Requests", schema = "PUBLIC")
@Indexed
public class Request {

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reqId")
    private Long reqId;

    @Column(name = "requestType")
    @Field(index = Index.YES, store = Store.NO)
    private String requestType;

    @Column(name = "employeeId")
    @FieldBridge(impl = LongBridge.class)
    @Field
    private Long employeeId;

    @Column(name = "createdTime")
    @JsonDeserialize(using = TimestampDeserializer.class)
    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp createdTime;

    @Column(name = "fromDate")
    @JsonDeserialize(using = TimestampDeserializer.class)
    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp fromDate;

    @Column(name = "toDate")
    @JsonDeserialize(using = TimestampDeserializer.class)
    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp toDate;

    @Column(name = "reason")
    @Field
    private String reason;

    @IndexedEmbedded
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    public Request() {
    }

    public Request(String requestType, Long employeeId, Timestamp createdTime, Timestamp fromDate,
            Timestamp toDate, String reason, Status status) {
        this.requestType = requestType;
        this.employeeId = employeeId;
        this.createdTime = createdTime;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
    }

    @JsonIgnore
    public boolean isMissingKeys() {
        if (this.requestType == null) {
            return true;
        }
        if (this.employeeId == null) {
            return true;
        }
        if (this.fromDate == null) {
            return true;
        }
        if (this.toDate == null) {
            return true;
        }
        if (this.reason == null) {
            return true;
        }
        return false;

    }

    @JsonIgnore
    public boolean isEmpty() {
        if (this.requestType != null) {
            return false;
        }
        if (this.employeeId != null) {
            return false;
        }
        if (this.fromDate != null) {
            return false;
        }
        if (this.toDate != null) {
            return false;
        }
        if (this.reason != null) {
            return false;
        }
        return true;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Field
    @DateBridge(resolution = Resolution.MILLISECOND)
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Field
    @DateBridge(resolution = Resolution.MILLISECOND)
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @Field
    @DateBridge(resolution = Resolution.MILLISECOND)
    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request [reqId=" + reqId + ", employeeId=" + employeeId + ", createdTime=" + createdTime + ", fromDate="
                + fromDate + ", toDate=" + toDate + ", reason=" + reason + "]";
    }
}
