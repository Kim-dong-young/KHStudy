package study.board.service;

import study.board.domain.entity.Board;

import java.util.List;

public class BoardServiceJpaImpl implements BoardService {

    @Override
    public List<Board> findAll() {
        return List.of();
    }
}
