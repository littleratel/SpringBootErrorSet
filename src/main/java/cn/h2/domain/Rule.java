package cn.h2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Rule {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    private String type;
    private String content;
    private String ruleName;

    /**
     * @param type
     * @param content
     * @param logType
     */
    public Rule(String type, String content, String logType) {
        super();
        this.type = type;
        this.content = content;
    }

}
