/*parallel 6*/
select * from emp order by sal;

select avg(comm) from emp;

select * from ( select s.deptno, sum(sal) s_sal from emp s group by s.deptno ORDER BY sum(sal) ASC)
where ROWNUM <= 2 ; 

SELECT * 
FROM emp Emp1
WHERE (2) = ( SELECT COUNT(DISTINCT(Emp2.sal))
FROM emp Emp2
WHERE Emp2.sal > Emp1.sal);

select round(-100) from dual;

select round(364.32453, 2) from dual;

select round(364.32,-2) from dual;

select * from user_tables;

select round(344.32,-2) from dual;

select Trunc(374.32,-1) from dual;

select level from dual CONNECT by level<12;

select (SYSDATE) "Last" from dual;

SELECT to_char(sysdate ,'MONTH') from dual;

SELECT to_char(SYSTIMESTAMP ) from dual;

select e1.* from EMP e1 , emp e2
where e1.EMPNO=e2.MGR;

select level ,TO_CHAR(ADD_MONTHS(SYSDATE,level-2),'MONTH') from dual CONNECT by level <= 12;

Explain plan into my_plan_table for
select level ,TO_CHAR(ADD_MONTHS(SYSDATE,level-2),'MONTH') from dual CONNECT by level <= 12;

select * from tabs;

select * from user_constraints;

create table test as select * from emp; 


select * from test;

drop table test;

SELECT * from recyclebin;

flashback table ravdeep.test to before drop ;

 




