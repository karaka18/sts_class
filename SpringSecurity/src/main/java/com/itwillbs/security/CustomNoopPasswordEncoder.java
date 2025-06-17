package com.itwillbs.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *	사용자가 로그인할때 임시 비밀번호 암호화 
 */
public class CustomNoopPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		// 입력비밀번호 ->  암호화 비밀번호로 변경
		// ex)  a -> y 으로 변경 
		System.out.println(" 임시 암호화 실시! ");
		
		return rawPassword+"";
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// 암호화된 비밀번호가 맞는지 체크
		System.out.println(" 임시 비밀번호 체크! ");
		
		return rawPassword.toString().equals(encodedPassword);
	}

}
