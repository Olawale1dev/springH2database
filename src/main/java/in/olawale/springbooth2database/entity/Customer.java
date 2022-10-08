package in.olawale.springbooth2database.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table (name="tbl_customer")
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY )
    private Long Id;
    private String name;
    private Long age;
    private String location;


    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column( name="update_at")
    private Date updatedAt;
}
