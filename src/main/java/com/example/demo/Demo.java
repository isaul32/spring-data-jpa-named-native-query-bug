package com.example.demo;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Demo.findAllCustom",
        query = "select * from demo",
        resultSetMapping = "demo"
    )
})
@SqlResultSetMapping(
    name = "demo",
    classes = @ConstructorResult(
        targetClass = DemoPojo.class,
        columns = {
            @ColumnResult(name = "id", type = Long.class)
        }
    )
)
public class Demo {
  @Id
  @GeneratedValue
  private Long id;

  public Long getId() {
    return id;
  }
}
