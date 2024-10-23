package entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Condition", propOrder = {
        "filedName",
        "operator",
        "value"
})
@XmlRootElement(name = "Condition")
public class Condition {

    @XmlElement(required = true)
    private String filedName;
    @XmlElement(required = true)
    private String operator;
    @XmlElement(required = true)
    private String value;

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
