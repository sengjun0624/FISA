/* 원문(en)

Intro:

    Filtering requirements have grown. We need to be
    able to filter any kind of Persons.

Exercise:

    Fix typing for the filterPersons so that it can filter users
    and return User[] when personType='user' and return Admin[]
    when personType='admin'. Also filterPersons should accept
    partial User/Admin type according to the personType.
    `criteria` argument should behave according to the
    `personType` argument value. `type` field is not allowed in
    the `criteria` field.

Higher difficulty bonus exercise:

    Implement a function `getObjectKeys()` which returns more
    convenient result for any argument given, so that you don't
    need to cast it.

    let criteriaKeys = Object.keys(criteria) as (keyof User)[];
    -->
    let criteriaKeys = getObjectKeys(criteria);

*/

/*
    6번

    filterPersons()를 수정해서 user를 필터링할 수 있고, personType이 'user'일 때는
    User[]을, personType이 'admin'일 때는 Admin[]을 반환하도록 구현

    또한 filterPersons()는 인수(파라미터) 'personType'에 따라 부분적으로 User 타입을 받거나, Admin 타입을 받을 수도 있어야함(오버로딩 개념 활용)

    criteria 인수는 personType의 인수에 따라 함수의 동작이 달라져야함
    제약조건: 'type' 필드는 criteria 필드에 허용될 수 없음

    Higher difficulty bonus exercise:(미번역)

*/

interface User {
    type: 'user';
    name: string;
    age: number;
    occupation: string;
}

interface Admin {
    type: 'admin';
    name: string;
    age: number;
    role: string;
}

export type Person = User | Admin;

export const persons: Person[] = [
    { type: 'user', name: 'Max Mustermann', age: 25, occupation: 'Chimney sweep' },
    { type: 'admin', name: 'Jane Doe', age: 32, role: 'Administrator' },
    { type: 'user', name: 'Kate Müller', age: 23, occupation: 'Astronaut' },
    { type: 'admin', name: 'Bruce Willis', age: 64, role: 'World saver' },
    { type: 'user', name: 'Wilson', age: 23, occupation: 'Ball' },
    { type: 'admin', name: 'Agent Smith', age: 23, role: 'Anti-virus engineer' }
];

export function logPerson(person: Person) {
    console.log(
        ` - ${person.name}, ${person.age}, ${person.type === 'admin' ? person.role : person.occupation}`
    );
}

// ex) filterPersons(persons, 'user', { age: 23 }); // admin이 아닌 user 리스트에서 age가 23인 user만 필터링
export function filterPersons(persons: Person[], personType: string, criteria: object): Person[] {
    return persons
        .filter((person) => person.type === personType) // personType('user' or 'admin')으로 user와 admin 중 하나로 필터링
        .filter((person) => {
            let criteriaKeys = getObjectKey(criteria);// 인수 criteria의 타입을 object로 하면 이 줄은 해결 가능하나, 아래의 에러 발생
            return criteriaKeys.every((fieldName) => {
                return person[fieldName] === criteria[fieldName];
                // Element implicitly has an 'any' type because expression of type 'string' can't be used to index type 'Person'.
                // No index signature with a parameter of type 'string' was found on type '{}'.
            });
        });
}

// const getObjectKeys = <T>(obj: T) => Object.keys(obj) as (keyof T)[];
export function getObjectKey<T extends object>(criteria: T) {
    return Object.keys(criteria) as (keyof T)[]; // as (keyof T)[]을 뒤에 추가하지 않으면 filterPersons()의 최종 return부분에서 하단(Line86~)에 작성된(ELement implicitly~)에러 발생
                                    // 다른 해결 방법으로는 User, Admin 인터페이스의 필드 부분에 각각 인덱스 시그니처인 [key: string]: string | number;를 추가하여 해결 가능
}

export const usersOfAge23 = filterPersons(persons, 'user', { age: 23 });
export const adminsOfAge23 = filterPersons(persons, 'admin', { age: 23 });

console.log('Users of age 23:');
usersOfAge23.forEach(logPerson);

console.log();

console.log('Admins of age 23:');
adminsOfAge23.forEach(logPerson);

// In case if you are stuck:
// https://www.typescriptlang.org/docs/handbook/2/functions.html#function-overloads
