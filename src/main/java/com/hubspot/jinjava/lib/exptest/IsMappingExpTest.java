package com.hubspot.jinjava.lib.exptest;

import java.util.Map;

import com.hubspot.jinjava.doc.annotations.JinjavaDoc;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;


@JinjavaDoc("Return true if the given object is a dict")
public class IsMappingExpTest implements ExpTest {

  @Override
  public String getName() {
    return "mapping";
  }

  @Override
  public boolean evaluate(Object var, JinjavaInterpreter interpreter, Object... args) {
    return var != null && Map.class.isAssignableFrom(var.getClass());
  }

}
