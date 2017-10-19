package si.petrol.workshop.market.models.db.common;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

   @Id
   @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    private void onCreate(){
        Instant now = Instant.now();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    @PreUpdate
    private void onUpdate(){
        Instant now = Instant.now();

        this.setUpdatedAt(now);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
