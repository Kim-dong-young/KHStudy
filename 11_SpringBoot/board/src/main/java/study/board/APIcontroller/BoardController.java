package study.board.APIcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.board.domain.dto.BoardResponse;
import study.board.domain.entity.Board;
import study.board.service.BoardService;

import java.util.ArrayList;
import java.util.List;

/*
    REST API는 REST(REpresentational State Transfer) 라는 아키텍쳐 스타일을 따르는 API다
    REST는 자원을 기반으로 한 네트워크 아키텍쳐 설계 방식으로, 주로 HTTP를 사용하여 클라이언트와 서버간의 데이터 통신을 지원
    => 데이터만 왔다갔다
    REST API는 REST의 원칙에 따라 자원을 정의하고 자원에 대한 표준 HTTP메서드(GET,POST,PUT,DELETE,PATCH 등)를 사용하여 조작한다.

    url에는 접근할 자원의 경로를 지정한다.
    작업은 HTTP 메서드를 사용하여 표현한다.
    GET : 자원의 조회(읽기)
    POST : 자원의 생성
    PUT : 자원의 수정(수정 가능한 데이터의 전체)
          ex) 게시판을 수정한다 => 수정 가능한 게시글 제목, 내용 전체를 변경, 수정 불가능한 작성일자는 그대로
    PATCH : 자원의 수정(수정 가능한 데이터의 일부)
          ex) 회원의 닉네임만 수정한다 => 여러 정보 중 닉네임만 수정
    DELETE : 자원의 삭제

    REST는 아키텍쳐 스타일이지 공식이 아니다. 따라서 설계와 구현 방식이 개발자마다 다를 수 있다.
    RESTful하지 않는 방식으로 설계되는 경우도 많다. like 트랜잭션 묶어서 여러개 처리 해야할 때
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    // 행위를 주소로 직접 지정하지 않음 ex) @GetMapping("write")

    // api board 경로의 get 요청에는 무조건 이 메소드가 호출된다
    // ResponseEntity : 스프링 제공 응답 객체
    @GetMapping
    public ResponseEntity<List<BoardResponse.SimpleDTO>> getBoardList() {
        List<Board> boardList = boardService.findAll();
        List<BoardResponse.SimpleDTO> resultDTOList = new ArrayList<>();
        for(Board board : boardList) {
            /*
                빌드 패턴을 사용하면 이렇게 일일이 안해도 됌
                BoardResponse.SimpleDTO sd = new BoardResponse.SimpleDTO();
                sd.getTitle(board.getTitle());
             */
            resultDTOList.add(BoardResponse.SimpleDTO.fromEntity(board));
        }

        // HttpStatus : Enum type ( 정해진 값들 중 하나만 가짐 )
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }

    // api board 경로에 boardId 파라미터가 담긴 get 요청에는 무조건 이 메소드 호출
    // PathVariable : 주소(파라미터)에 담긴 값을 변수로 가져와줌
    @GetMapping("/{boardId}")
    public void getBoard(@PathVariable Long boardId) {

    }

    @PostMapping
    public void createBoard() {

    }

    @PutMapping
    public void updateBoard() {

    }

    @DeleteMapping
    public void deleteBoard() {

    }
}
