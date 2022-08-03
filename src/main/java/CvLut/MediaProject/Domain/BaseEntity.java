package CvLut.MediaProject.Domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
// MappedSuperclass -> 실제 Entity가 아닌 일반 클래스를 Entity클래스들이 상속받기 위해 필요하다.
// Spring Data JPA를 이용한 BaseEntity
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private Timestamp createdAt;
    @LastModifiedDate
    private Timestamp updatedAt;
}
