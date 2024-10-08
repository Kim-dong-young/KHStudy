package com.kh.spring.member.model.vo;

import java.sql.Date;

import lombok.Data;

// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @ToString
// @EqualsAndHashCode
// 위의 모든걸 한방에 추가하는 어노테이션 @Data
@Data
public class Member {
	// 카멜케이스 표기시 대문자 앞에 최소 2글자 있어야함
	// 걍 롬복 에러
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String gender;
	private String age;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
}
