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
