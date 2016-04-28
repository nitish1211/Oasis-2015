package v2015.oasis.pilani.bits.com.home;

import java.util.Date;

/**
 * Created by jai on 20/10/15.
 */
public class EventModel implements Comparable<EventModel> {

    private String id;
    private String name;
    private String location;
    private Date start;
    private Date end;
    private String desc;
    private String timeLeft;
    private boolean isAllDay;
    private int isProfShow;

    public EventModel() {
    }

    public EventModel(String id, String name, String location, Date start, Date end, String desc, boolean isAllDay, int isProfShow) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.start = start;
        this.end = end;
        this.desc = desc;
        this.isAllDay = isAllDay;
        this.isProfShow = isProfShow;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLocation(String location) { this.location = location; }

    public String getLocation() { return this.location; }

    public void setStart(Date start) { this.start = start; }

    public Date getStart() { return this.start; }

    public void setEnd(Date end) { this.end = end; }

    public Date getEnd() { return this.end; }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getTimeLeft() {
        return this.timeLeft;
    }

    public void setAllDay(boolean isAllDay) { this.isAllDay = isAllDay; }

    public boolean isAllDay(){ return  this.isAllDay; }

    public void setProfShow(int isProfShow) { this.isProfShow = isProfShow; }

    public int isProfShow() {return this.isProfShow; }

    @Override
    public int compareTo(EventModel d){
        return (this.getStart()).compareTo(d.getStart());
    }
    }
