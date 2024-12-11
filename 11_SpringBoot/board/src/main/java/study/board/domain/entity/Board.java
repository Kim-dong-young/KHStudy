package study.board.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter // Setter를 쓰면 정보 은닉이 안됨, 외부에서 값 변경이 가능해 추적이 너무 힘듦.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 상속 관계가 아닌 외부에서 데이터를 안넣은 기본 생성자로는 생성 불가
@AllArgsConstructor
@Builder
public class Board {
   private Long boardId;
   private String title;
   private String contents;
   private String fileName;
   private String memberEmail;
   private LocalDateTime createAt;
   private LocalDateTime updateAt;

//  @Builder 패턴 - 단, 기본 생성자는 필요함. 이렇게 하면 Setter 사용 없이 생성 가능
//
//   public static Builder builder() {
//        return new Builder();
//   }
//
//   public static class Builder {
//       private Board board = new Board();
//
//       public Builder setBoardId(Long boardId) {
//           this.board.setBoardId(boardId);
//           return this;
//       }
//
//       public Builder setTitle(String title) {
//           this.board.setTitle(title);
//           return this;
//       }
//
//       ...
//
//       public Board build(){
//          return this.board;
//       }
//   }
/*
    위 패턴으로 만들면
    Board.builder().setBoardId("123").setTitle("asdf").build();
    이런 식으로 체이닝 해 객체 생성이 가능
    => 메소드에서 build 객체 자체를 return 해 주고 있으므로, set메소드를 사용 가능
    => 최종적으로 build를 호출해, 내가 원하는 객체를 return 받음
 */
}
