/**
 * Hoisting
 */

console.log(name);
var name = 'jiwon';
console.log(name);

/**
 * Hoisting이란?
 * 
 * 모든 변수 선언문이 코드의 최상단으로 이동되는 것 처럼 느껴지는 현상
 * 왜냐하면 JS에서 코드를 파싱하며, 확인한 변수들을 미리 공간을 확보해둔다.
 * 
 * var에서만 일어남, let과 const는 tdz를 이용해 방지
 * 
 * let은 사용하면 tdz(temporal dead zone)에 따로 저장
 * let은 tdz에 존재한다면, 호이스팅이 안되는 것 처럼 막아놓는다.
 */