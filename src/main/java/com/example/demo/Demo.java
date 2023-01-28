package com.example.demo;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

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
            @ColumnResult(name = "id")
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
