"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const test = (text) => {
    console.log(text); // ES5로 컴파일시 Arrow Function => 구형 문법( function() )으로 변환됨
};
test("안녕 타입스크립트.");
