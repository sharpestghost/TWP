package ru.tinkoff.edu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "link_chat")
public class Follow {
   // @EmbeddedId
   // @Column(name = "id")
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private LinkChat id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("chat_id")
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("link_id")
    private Link link;
}