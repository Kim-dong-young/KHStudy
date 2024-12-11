package study.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.board.domain.entity.Board;

import java.util.List;

@Mapper // XML과 연결
public interface BoardMapper {
    List<Board> findAll();
}
