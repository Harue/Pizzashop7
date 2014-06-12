package pizzashop;

import java.util.Date;

import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Last {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String title;
     
    @Persistent
    private String count;
     
    @Persistent
    private Date datetime;
 
    public Last(String title,  String count, Date datetime) {
        super();
        this.title = title;
        this.count = count;
        this.datetime = datetime;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
 
    public String getCount() {
        return count;
    }
 
    public void setCount(String count) {
        this.count = count;
    }
 
    public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}