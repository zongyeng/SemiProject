
DROP TABLE USERINFO;
DROP SEQUENCE USERINFOSEQ;

CREATE SEQUENCE USERINFOSEQ;

--유저 기본정보 입니다. 
--가입순서, 기능번호, 이름, 닉네임, 성별, 나이, 핸드폰번호, 이메일, 가입일자, 유저 조회수, 유저 추천수, 활성화여부
CREATE TABLE USERINFO(
	USERSEQ NUMBER PRIMARY KEY,
	USERCONTROLNO NUMBER(1) NOT NULL CONSTRAINT CONTROLNOCHECK CHECK (USERCONTROLNO IN ('0', '1', '2')),
	USERNAME VARCHAR2(30) NOT NULL,
	USERNICNAME VARCHAR2(30) NOT NULL CONSTRAINT NICNAMECHECK UNIQUE,
	USERSEX CHAR(1) NOT NULL CONSTRAINT SEXCHECK CHECK (USERSEX IN ('M','F','X')),
	USERAGE NUMBER(4) NOT NULL,
	USERPHONNUMBER VARCHAR2(20) NOT NULL,
	USEREMAIL VARCHAR2(30),
	USERSIGNDATE DATE DEFAULT SYSDATE CONSTRAINT SIGNDATE NOT NULL,
	MUSICIANVIEW NUMBER DEFAULT '0' CONSTRAINT NOTNEGATIVEVIEW CHECK (MUSICIANVIEW>=0),
	MUSICIANRECOMMENDATION NUMBER DEFAULT '0' CONSTRAINT NOTNEGATIVERECOMMENDATION CHECK (MUSICIANRECOMMENDATION>=0),
	USERENABLE CHAR(1) DEFAULT 'Y' CONSTRAINT ENABLECHECK CHECK (USERENABLE IN ('Y','N')) 
);

SELECT USERSEQ, USERCONTROLNO, USERNAME, USERNICNAME, USERSEX, USERAGE, USERPHONNUMBER, USEREMAIL, USERSIGNDATE, MUSICIANVIEW, MUSICIANRECOMMENDATION, USERENABLE FROM USERINFO;

INSERT INTO USERINFO 
	VALUES(USERINFOSEQ.NEXTVAL,'0','조영찬','메롱캬르르','M','27','010-3495-0424','zongyeng1@navre.com',SYSDATE,'0','0','Y');

INSERT INTO USERINFO (USERSEQ,USERCONTROLNO,USERNAME,USERNICNAME,USERSEX,USERAGE,USERPHONNUMBER,USEREMAIL) 
	VALUES(USERINFOSEQ.NEXTVAL,'1','박훈성','pigstar0000','M','29','010-1234-5678','pigstar0000@navre.com');

	
DROP TABLE MUSICIANALBUM;
DROP SEQUENCE ALBUMSEQ;

CREATE SEQUENCE ALBUMSEQ;

--뮤지션 앨범 정보 입니다. 엘범 이름을 '고유번호_앨범이름'으로 잡아주세요.
--앨범 고유번호, 뮤지션고유번호, 앨범등록순서번호, 앨범이름, 파일용량, 파일길이, 하이라이트 시작 시간, 앨범설명, 작곡가, 작사가, 등록일자, 총조회수, 총추천수, 활성화여부 
CREATE TABLE MUSICIANALBUM(
	ALBUMSEQ NUMBER PRIMARY KEY,
	MUSICIANSEQ NUMBER,
	ALBUMNO NUMBER,
	ALBUMNAME VARCHAR2(30) NOT NULL,
	ALBUMSIZE NUMBER NOT NULL,
	ALBUMTIME NUMBER NOT NULL,
	ALBUMHIGHLIGHTTIME NUMBER DEFAULT '0' NOT NULL,
	ALBUMCONTENT VARCHAR2(300) DEFAULT '없음' NOT NULL,
	ALBUMCOMPOSER VARCHAR2(100) DEFAULT '미상'  NOT NULL,
	ALBUMLYRICIST VARCHAR2(100) DEFAULT '미상' NOT NULL,
	ALBUMINPUTDATE DATE DEFAULT SYSDATE NOT NULL,
	ALBUMTAG VARCHAR2(300) DEFAULT '미지정' NOT NULL,
	ALBUMVIEW NUMBER DEFAULT '0' CONSTRAINT NOTNEGATIVEALBUMVIEW CHECK (ALBUMVIEW>=0),
	ALBUMRECOMMENDATION NUMBER DEFAULT '0' CONSTRAINT NOTNEGATIVEALBUMRECOMMENDATION CHECK (ALBUMRECOMMENDATION>=0),
	ALBUMENABLE CHAR(1) DEFAULT 'Y' CONSTRAINT ENABLEALBUMCHECK CHECK (ALBUMENABLE IN ('Y','N')),
	CONSTRAINT MUSICIANFK FOREIGN KEY(MUSICIANSEQ) REFERENCES USERINFO(USERSEQ)
);

SELECT ALBUMSEQ, MUSICIANSEQ, ALBUMNO, ALBUMNAME, ALBUMSIZE, ALBUMTIME, ALBUMHIGHLIGHTTIME, ALBUMCONTENT, ALBUMCOMPOSER, ALBUMLYRICIST, ALBUMINPUTDATE, ALBUMVIEW, ALBUMRECOMMENDATION, ALBUMENABLE FROM MUSICIANALBUM;

INSERT INTO MUSICIANALBUM 
	VALUES(ALBUMSEQ.NEXTVAL,'1','1','1_FUNKEYMUSIC','13','0350','0123','펑키뮤직!','박훈성','조영찬',SYSDATE,'funky','0','0','Y');

INSERT INTO MUSICIANALBUM (ALBUMSEQ,MUSICIANSEQ, ALBUMNO, ALBUMNAME, ALBUMSIZE, ALBUMTIME) 
	VALUES(ALBUMSEQ.NEXTVAL,'1','2','1_SMILEDAY','12.23','0401');

DROP TABLE ALBUMSTATISTICS;

--앨범의 조회수와 추천수를 계산하고 기간별 통계낼 수 있는 테이블입니다.
--앨범 고유번호, 조회 일자, 추천수
CREATE TABLE ALBUMSTATISTICS(
	ALBUMSEQ NUMBER,
	ALBUMVIEW DATE DEFAULT SYSDATE NOT NULL,
	ALBUMRECOMMENDATION CHAR(1) CONSTRAINT ENABLEALBUMSTATISTICSCHECK CHECK (ALBUMRECOMMENDATION IN ('Y','N')),
	CONSTRAINT ALBUMSEQFK FOREIGN KEY(ALBUMSEQ) REFERENCES MUSICIANALBUM(ALBUMSEQ)
);

--추천수 카운트 예제.
SELECT COUNT(ALBUMRECOMMENDATION) FROM ALBUMSTATISTICS WHERE ALBUMRECOMMENDATION='Y';

INSERT INTO ALBUMSTATISTICS (ALBUMSEQ, ALBUMRECOMMENDATION) VALUES('1','N');

INSERT INTO ALBUMSTATISTICS (ALBUMSEQ, ALBUMRECOMMENDATION) VALUES('1','Y');

INSERT INTO ALBUMSTATISTICS (ALBUMSEQ, ALBUMRECOMMENDATION) VALUES('1','Y');



