
package com.MarketPlace.Entity;

import java.time.LocalDateTime;

import javax.persistence.*;
//import jakarta.persistence.*;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CurrentUserSession {
    @Id
    @Column(unique = true)
    private Integer userId;

    private String uniqueID;

    private Boolean admin;

    private LocalDateTime localDateTime;
}
