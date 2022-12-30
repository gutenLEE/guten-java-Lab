package com.example.springlab.mysqls;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gutenlee
 * @since 2022/12/25
 */
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
