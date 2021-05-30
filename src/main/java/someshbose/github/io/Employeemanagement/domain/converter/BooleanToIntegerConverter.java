package someshbose.github.io.Employeemanagement.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToIntegerConverter implements AttributeConverter<Boolean,Integer> {

  @Override
  public Integer convertToDatabaseColumn(Boolean aBoolean) {
    return aBoolean?1:0;
  }

  @Override
  public Boolean convertToEntityAttribute(Integer integer) {
    return integer>0;
  }
}
