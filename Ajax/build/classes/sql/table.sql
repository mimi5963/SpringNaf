
select * from testrank2;

create table testrank2(
	
 id int primary key auto_increment,
 name VARCHAR(20) not NULL,
 pwd VARCHAR(20) not NULL,
 win int default 0,
 lose int default 0,
 score int
);


insert into testrank2 (name,pwd,win,lose) values('fgd','123',24,23);
update testrank2 set score = (win*2)+(lose*-1);


create view score_sort2 as
select id,name,win,lose,score
from testrank2
order by score desc;


select id,name,win,lose,rank
from(
select id, name, FORMAT(@ROWNUM := @ROWNUM+1,0) as rank, win, lose
from score_sort2, (select @ROWNUM := 0)row
)r;


commit;
