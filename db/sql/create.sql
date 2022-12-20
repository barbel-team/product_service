
# <!--주문관리-->
create table ord
(
    uid        INT AUTO_INCREMENT PRIMARY KEY,
    fk_num     BIGINT      NOT NULL,
    res_nm     varchar(20) NOT NULL,
    res_addr01 varchar(30) NOT NULL,
    res_addr02 varchar(30) NOT NULL,
    res_addr03 varchar(30) NOT NULL,
    res_tel    varchar(12) NOT NULL,
    res_hp     varchar(13) NOT NULL,
    deliv_req  varchar(40) NOT NULL,
    fk_prdnum  INT         NOT NULL,
    ord_date   date        NOT NULL,
    p_time     timestamp   not null default current_timestamp,
    FOREIGN KEY (fk_prdnum) REFERENCES product (uid)
);


# <!--카테고리별 상품관리-->
create table ctgprd
(
    uid    INT AUTO_INCREMENT PRIMARY KEY,
    c_name varchar(30) NOT NULL
);

# <!--상품관리-->
create table product
(
    uid        INT AUTO_INCREMENT PRIMARY KEY,
    fk_cate    INT         NOT NULL,
    prd_price  varchar(15) NOT NULL,
    prd_cmp    varchar(30) NOT NULL,
    prd_type   varchar(30) NOT NULL,
    prd_img    varchar(100) NOT NULL,
    prd_ment   varchar(50) NOT NULL,
    prd_stock  INT(15)     NOT NULL default 100,
    prd_sales  INT(15)     NOT NULL default 0,
    prd_name   VARCHAR(50) NOT NULL,
    FOREIGN KEY (fk_cate) REFERENCES ctgprd (uid)
);

# <!--장바구니-->
create table cart_prd
(
    uid       INT AUTO_INCREMENT PRIMARY KEY,
    fk_member BIGINT  NOT NULL,
    fk_ord    INT     NOT NULL,
    amount    INT(20) NOT NULL,
    cart_chk  INT(10) NOT NULL,
    cart_pay  INT(20) NOT NULL,
    FOREIGN KEY (fk_ord) REFERENCES product (uid)
);

insert into ctgprd
(c_name) values ("보충제");
insert into ctgprd
(c_name) values ("보조용품");
insert into ctgprd
(c_name) values ("의류");

insert into product
(fk_cate, prd_price, prd_cmp, prd_type, prd_img, prd_ment, prd_name) VALUES
(1, 50000, "마이프로틴", "유청단백", "https://static.thcdn.com/images/small/original//productimg/960/960/10530943-1224889444460882.jpg",
 "세계에서 가장 많이 팔리는 프로틴!", "임팩트 웨이");

insert into product
(fk_cate, prd_price, prd_cmp, prd_type, prd_img, prd_ment, prd_name) VALUES
    (1, 60000, "마이프로틴", "유청단백", "https://static.thcdn.com/images/large/original//productimg/1600/1600/10530911-5884889444360331.jpg",
     "세계에서 가장 건강한 프로틴!", "임팩트 웨이 아이솔레이트");

insert into product
(fk_cate, prd_price, prd_cmp, prd_type, prd_img, prd_ment, prd_name) VALUES
    (1, 45000, "마이프로틴", "크레아틴", "https://static.thcdn.com/images/large/original/productimg/1600/1600/10530050-9574620647469231.jpg",
     "강한 나를 만들어주는 마법의 비약 크레아틴!", "크레아틴 모노 하이드레이트");

insert into ord
(fk_num, res_nm, res_addr01, res_addr02, res_addr03, res_tel, res_hp, deliv_req, fk_prdnum, ord_date) values
(1, "김우중", "15875", "경기 군포시 용호2로 51", "104동 1401호", "031-457-0139", "010-6773-0139", "근손실 날 것 같습니다. 빨리 배송해주세요!", 1, current_date);

