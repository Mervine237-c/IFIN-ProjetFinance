package com.esprit.ifin.audit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

  @Column(nullable = false, length = 36)
  @CreatedBy
  protected U createdBy;

  @Column(nullable = false)
  @CreatedDate
  protected LocalDateTime creationDate;

  @Column(length = 36)
  @LastModifiedBy
  protected U lastModifiedBy;

  @LastModifiedDate protected LocalDateTime lastModifiedDate;
}
