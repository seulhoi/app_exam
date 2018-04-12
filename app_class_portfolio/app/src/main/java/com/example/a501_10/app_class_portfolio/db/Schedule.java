package com.example.a501_10.app_class_portfolio.db;

import org.greenrobot.greendao.annotation.*;

import com.example.a501_10.app_class_portfolio.db.DaoSession;
import org.greenrobot.greendao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "SCHEDULE".
 */
@Entity(active = true)
public class Schedule {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private java.util.Date created_at;

    @NotNull
    private java.util.Date updated_at;
    private String place_name;
    private java.util.Date visit_time;
    private java.util.Date elapse_time;
    private Long spend_money;
    private long place_id;
    private long trip_id;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient ScheduleDao myDao;

    @ToOne(joinProperty = "place_id")
    private Place place;

    @Generated
    private transient Long place__resolvedKey;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Schedule() {
    }

    public Schedule(Long id) {
        this.id = id;
    }

    @Generated
    public Schedule(Long id, java.util.Date created_at, java.util.Date updated_at, String place_name, java.util.Date visit_time, java.util.Date elapse_time, Long spend_money, long place_id, long trip_id) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.place_name = place_name;
        this.visit_time = visit_time;
        this.elapse_time = elapse_time;
        this.spend_money = spend_money;
        this.place_id = place_id;
        this.trip_id = trip_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getScheduleDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public java.util.Date getCreated_at() {
        return created_at;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCreated_at(@NotNull java.util.Date created_at) {
        this.created_at = created_at;
    }

    @NotNull
    public java.util.Date getUpdated_at() {
        return updated_at;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUpdated_at(@NotNull java.util.Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public java.util.Date getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(java.util.Date visit_time) {
        this.visit_time = visit_time;
    }

    public java.util.Date getElapse_time() {
        return elapse_time;
    }

    public void setElapse_time(java.util.Date elapse_time) {
        this.elapse_time = elapse_time;
    }

    public Long getSpend_money() {
        return spend_money;
    }

    public void setSpend_money(Long spend_money) {
        this.spend_money = spend_money;
    }

    public long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(long place_id) {
        this.place_id = place_id;
    }

    public long getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(long trip_id) {
        this.trip_id = trip_id;
    }

    /** To-one relationship, resolved on first access. */
    @Generated
    public Place getPlace() {
        long __key = this.place_id;
        if (place__resolvedKey == null || !place__resolvedKey.equals(__key)) {
            __throwIfDetached();
            PlaceDao targetDao = daoSession.getPlaceDao();
            Place placeNew = targetDao.load(__key);
            synchronized (this) {
                place = placeNew;
            	place__resolvedKey = __key;
            }
        }
        return place;
    }

    @Generated
    public void setPlace(Place place) {
        if (place == null) {
            throw new DaoException("To-one property 'place_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.place = place;
            place_id = place.getId();
            place__resolvedKey = place_id;
        }
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
