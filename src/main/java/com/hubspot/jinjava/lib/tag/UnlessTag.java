package com.hubspot.jinjava.lib.tag;

import com.hubspot.jinjava.doc.annotations.JinjavaDoc;
import com.hubspot.jinjava.doc.annotations.JinjavaParam;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.tree.TagNode;
import com.hubspot.jinjava.util.ObjectTruthValue;

/**
 * Unless is a conditional just like 'if' but works on the inverse logic.
 * 
 * {% unless x &lt; 0 %} x is greater than zero {% endunless %}
 *
 *
 * @author jstehler
 */

@JinjavaDoc(
    value="Unless is a conditional just like 'if' but works on the inverse logic.\n\n" +
          "{% unless x &lt; 0 %} x is greater than zero {% endunless %}",
    params=@JinjavaParam(value="expr", type="expression"))
public class UnlessTag extends IfTag {

  @Override
  public String getName() {
    return "unless";
  }
  
  @Override
  public String getEndTagName() {
    return "endunless";
  }
  
  @Override
  protected boolean evaluateIfElseTagNode(TagNode tagNode, JinjavaInterpreter interpreter) {
    if(tagNode.getName().equals("unless")) {
      return !ObjectTruthValue.evaluate(interpreter.resolveELExpression(tagNode.getHelpers(), tagNode.getLineNumber()));
    }

    return super.evaluateIfElseTagNode(tagNode, interpreter);
  }
  
}
