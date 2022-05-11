package gov.ifms.common.cache.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomEntity {
    @Id
    private Integer id;
}