SELECT COUNT(*)                                AS count,
       SUM(IF(r.status = 'PROCESSING', 1, 0))  AS processing_count,
       SUM(IF(r.status = 'APPROVED', 1, 0))    AS approved_count,
       SUM(IF(r.status = 'DISAPPROVED', 1, 0)) AS disapproved_count
FROM report as r;

SELECT COUNT(*)                                                  AS count,
       SUM(CASE WHEN r.status = 'PROCESSING' THEN 1 ELSE 0 END)  AS processing_count,
       SUM(CASE WHEN r.status = 'APPROVED' THEN 1 ELSE 0 END)    AS approved_count,
       SUM(CASE WHEN r.status = 'DISAPPROVED' THEN 1 ELSE 0 END) AS disapproved_count
FROM report AS r;

SELECT year, COUNT(*) as count
FROM report AS r
group by r.year
order by year;

SELECT SUM(IF(u.user_role = 'USER', 1, 0))      AS user_count,
       SUM(IF(u.user_role = 'INSPECTOR', 1, 0)) AS inspector_count
FROM user as u;

SELECT SUM(IF(u.user_role = 'USER', 1, 0))      AS user_count,
       SUM(IF(u.user_role = 'INSPECTOR', 1, 0)) AS inspector_count
FROM user as u;

