package com.kh.spring.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * - Aspect : 해당 클래스가 Aspect(aop객체)라는 것을 선언
 * - Component : Spring이 해당 빈을 찾을 수 있도록 선언(Bean 등록)
 */

@Slf4j // lombok 로그 불러오는 함수
@Aspect
@Component
public class LoggingAOP {
	/*
	 * <시점>
	 * @Before : 대상 메서드 실행 전에 Advice(추가기능)가 실행된다.
	 * 
	 * @After : 대상 메서드 실행 후에 Advice(추가기능)가 실행된다.
	 * 
	 * @AfterReturning : 대상 메서드가 정상적으로 반환된 후에 Advice(추가기능)가 실행된다.
	 * 
	 * @AfterThrowing : 대상 메서드가 예외를 던진 후에 Advice(추가기능)가 실행된다.
	 * 
	 * @Around : 대상 메서드를 감싸서 메서드 호출 전,후 모두 Advice(추가기능)가 실행된다.
	 */
	
	/*
	 * <대상>
	 * target : 특정 인터페이스와 그 자식클래스
	 * within : 특정 패키지 또는 클래스
	 * execution : 표현식으로 형태 지정
	 */
	
	// 특정 메서드나 패키지등의 join point
	@Pointcut("execution(* com.kh.spring..controller.*.*(..) )") // com.kh 아래 모든 controller 패키지 하위 클래스의 모든 메소드에 전부 적용
	private void cut() {};
	
	// cut메소드가 실행되는 지점 이전에 before() 메서드를 실행
	// JoinPoint  : pointcut 지점에 대한 정보가 들어있다.
	// 메서드의 실행이 가장 일반적인 joinpoint다
	@Before("cut()")
	public void before(JoinPoint joinPoint) {
		
		// 실행되는 메서드의 이름을 가져오기
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		Object[] args = joinPoint.getArgs();
		
		log.info("=================== START ===================="); // slf4j
		log.info("--------------- API Controller ---------------");
		log.info("Information   : " + methodSignature);
		log.info("Method Name   : " + method);
		log.info("Parameter     : " + Arrays.toString(args));
	}
	
	@AfterReturning(value="cut()", returning="obj")
	public void afterReturn(JoinPoint joinPoint, Object obj) {
		log.info("==================== END =====================");
		log.info("Object        : " + obj);
	}
	
	// api 시간 측정
	@Around("cut()")
	public Object displayLogInfo(ProceedingJoinPoint joinPoint) throws Throwable {
		// 실행전 서버 시간
		long start = System.currentTimeMillis(); // 0
		
		// joinPoint.proceed() = 실행하려던 joinpoint 메서드 실행
		Object result = joinPoint.proceed(); // 원래 해야하던 작업 진행
		
		// 실행후 서버 시간
		long end = System.currentTimeMillis(); // 1000
		
		long runTime = end - start; // 실행 시간 ( 1000 - 0 )
		
		log.info("---------------------------------------------");
		log.info("Information     : " + joinPoint.getSignature());
		log.info("Processing Time : " + runTime + "ms");
		
		return result;
	}
	
}
