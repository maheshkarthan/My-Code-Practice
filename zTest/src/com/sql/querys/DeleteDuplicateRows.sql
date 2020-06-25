 
-- Assume we have duplicate records  with colums empid, name, 
-- we need to delete all the rows other than first duplicate occurence

With CTE_Duplicates as
   (select empid, name, row_number() over(partition by empid, name order by empid,name ) rownumber 
   	from Employee)
   	delete from CTE_Duplicates where rownumber > 1