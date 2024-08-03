package com.rookie.bigdata.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:51
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("t_user")
public class User {
    @Id
    private long id;
    private String name;
    private long age;

}
