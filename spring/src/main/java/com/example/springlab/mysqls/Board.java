package com.example.springlab.mysqls;

import org.springframework.context.annotation.Import;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author gutenlee
 * @since 2022/12/25
 */
@Entity
public class Board {

    @Id
    private Integer boardId;

    public Board(Integer boardId) {
        this.boardId = boardId;
    }

    protected Board() {

    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                '}';
    }
}
