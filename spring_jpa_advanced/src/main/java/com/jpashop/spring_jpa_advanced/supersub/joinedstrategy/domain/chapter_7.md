
관계형 데이터베이스에는 상속이라는 개념 대신 슈퍼타입 서브타입 관계라는 모델링 기법이 객체의 상속 개념과 가장 유사함
ORM 에서 이야기하는 상속 관계 매핑은 객체의 상속 구조와 데이터베이스의 슈퍼타입 서브타입 관계를 매핑하는 것

슈퍼타입 서브타입 논리 모델을 실제 물리 모델인 테이블로 구현할 때 3가지 방법이 있음
1. 각각의 테이블로 변환
    각각을 모두 테이블로 만들고 조회할 때 조인을 사용
2. 통합 테이블로 변환
    같은 테이블을 하나만 사용해서 통합
3. 서브타입 테이블로 변환
    서브 타입마다 하나의 테이블을 만든다

### 조인전략
장점
1. 테이블이 정규화된다.
2. 외래 키 참조 무결성 제약조건을 활용할 수 있다.
3. 저장공간을 효율적으로 사용한다.

단점
1. 조회할 때 조인이 많이 사용되므로 성능이 저하될 수 있다.
2. 조회 쿼리가 복잡하다.
3. 데이터를 등록할 INSERT SQL을 두 번 실행한다.

```shell
    create table album (
        artist varchar(255),
        item_id bigint not null,

        primary key (item_id)
    )

    create table book (
        author varchar(255),
        isbn varchar(255),
        book_id bigint not null,

        primary key (book_id)
    )

    create table item (
       dtype varchar(31) not null,
        item_id bigint not null,
        name varchar(255),
        price integer not null,

        primary key (item_id)
    )

    create table movie (
        actor varchar(255),
        director varchar(255),
        item_id bigint not null,

        primary key (item_id)
    )

    alter table album
       add constraint FKminb9nib0bo4t9c4kpltxtuab
       foreign key (item_id)
       references item

    alter table book
       add constraint FKd6yi4gonrl3aka8s8v65vc5pm
       foreign key (book_id)
       references item

    alter table movie
       add constraint FKq2rg7rpjfg38px01dhl4qrik6
       foreign key (item_id)
       references item

    Hibernate:
        call next value for hibernate_sequence
    Hibernate:
        insert
        into
            item
            (name, price, dtype, item_id)
        values
            (?, ?, 'A', ?)
    Hibernate:
        insert
        into
            album
            (artist, item_id)
        values
            (?, ?)
```
