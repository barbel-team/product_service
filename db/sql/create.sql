
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
    ord_date   date        NOT NULL,
    p_time     timestamp   not null default current_timestamp
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
    realfile   varchar(30) NOT NULL,
    prd_ment   varchar(50) NOT NULL,
    prd_stock  INT(15)     NOT NULL,
    prd_sales  INT(15)     NOT NULL,
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

# <!--상품 이미지-->
create table product_img
(
    uuid        VARCHAR(50),
    imgname     VARCHAR(30),
    contenttype VARCHAR(30),
    productid   INT,
    foreign key (productid) references product (uid) on update cascade on delete restrict
);