package ru.tinkoff.edu.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinkChat implements Serializable {
    @SuppressWarnings("checkstyle:MemberName")
    private Long chat_id;

    @SuppressWarnings("checkstyle:MemberName")
    private Long link_id;
}
