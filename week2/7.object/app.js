/**
 * JavaScript 에서 원시값 (Primitive Value) or 기본 타입을 제외한 모든 것들은 객체 (object)
 * IF 학점 데이터가 있다.
 * 수학(Math), 국어(Kor)
 *
 * 1번째 관리하는 방법
 * A라는 학생의 국어,수학점수
 * B라는 학생의 국어,수학점수
 * kor1,kor2 -> const kor1=85; cost kor2=95;
 *
 * 2번째 방법 (grouping)
 * A라는 학생의 국어,수학 점수 -> kor = 85,Math = 95; 하나의 오브젝트로 관리가능.
 * const studentA = {
 *     kor:85,
 *     math:95
 * }
 *
 * @Object
 * 프로퍼티로 구성된 집합 프로퍼티는 key-value로 구성됨.
 */

const dog = {name: 'Eve', age: 10, gender: 'male'};
console.log(dog);
console.dir(dog); // dir => 어떤 객체의 프로퍼티에 접근하는 함수구나. 목록 형태로 출력
console.log(dog.name);

const rabbit = {
    age: 2,
    name: '토토',
    walk: () => console.log('깡총깡총'),
    address: {
        city:'서울',
        gu:'마포',
        dong:'상암동'
    }

}
console.log(rabbit);
rabbit.walk();
console.log(rabbit.walk);


//토토가 사는 곳은 상암동입니다.를 출력
console.log(`${rabbit.name}가 사는 곳은 ${rabbit.address.dong}입니다.`);