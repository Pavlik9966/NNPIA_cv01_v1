package com.nnpia.cv01.dtos;

import com.nnpia.cv01.domains.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AppUserInputQLDTO {
    private String username;

    private String password;

    private Boolean active;

    private String creationDate;

    private String updateDate;

    public AppUser toEntity() {
        return new AppUser(
                getUsername(),
                getPassword(),
                getActive(),
                LocalDateTime.parse(getCreationDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                LocalDateTime.parse(getUpdateDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }
}