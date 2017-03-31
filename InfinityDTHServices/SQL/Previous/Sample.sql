create table Sample
(
    sampleId  Integer primary key,
    sampleName varchar2(30) not null,
    sampleDate date not null
);

CREATE SEQUENCE Sample_Sequence
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE
	NOCACHE
	NOCYCLE;
  
commit;